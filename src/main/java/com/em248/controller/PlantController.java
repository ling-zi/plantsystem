package com.em248.controller;

import com.em248.model.Plant;
import com.em248.service.PlantService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RequestMapping(value = "/plant")
@Controller
public class PlantController {

	PlantService plantService;
	
	
	@Autowired
	public PlantController(PlantService plantService) {
		this.plantService = plantService;
	}

	// 处理在首页搜索植物
	@RequestMapping("/search")
	public String viewPlant(@RequestParam("pname") String pname, Map<String, Object> model) {
		List<Plant> plants = plantService.querybyname(pname);
		model.put("plants", plants);
		// for (Plant plant : plants) {
		// System.out.println(plant.getPname());
		// }

		return "viewplant";
	}

	// 处理添加一种植物
	// 这才是添加植物的页面路径
	@RequestMapping("/add")
	private String index() {
		return "addplant";
	}

	// 这是处理表单的路径（不能直接访问！）
    @RequestMapping("/addplant")
    private String PlantAdd(@RequestParam CommonsMultipartFile file,
                            @RequestParam(name = "pname") String pname,
                            @RequestParam(name = "phylum") String phylum,
                            @RequestParam(name = "pfamily") String pfamily,
                            @RequestParam(name = "pgenus") String pgenus,
                            @RequestParam(name = "pdesc") String pdesc) {
    	//String cacheDirectory="D:\\Plantsys3.0\\PlanSystem\\src\\main\\webapp\\userimage";
    	//以下会传入D:\Javawork\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\lingzi3.0
        String cacheDirectory= ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/image/");
        String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
        File localFile=new File(cacheDirectory + fileName);
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Plant plant = new Plant(pname, fileName, pdesc, pfamily, pgenus, phylum);
        boolean b = plantService.addplant(plant);
        if (b) {
            return "/success";
        } else {
            return "/404";
        }

    }

	// 处理查看详细信息
	@RequestMapping("/detail")
	private String PlantDetail(@RequestParam(name = "pid") int pid, Map<String, Object> model) {
		Plant plant = plantService.querybyid(pid);
		model.put("plant", plant);
		return "plantdetail";
	}

	// 处理修改操作
	@RequestMapping("/change")
	private String PlantChange(@RequestParam(name = "pid") int pid, Map<String, Object> model) {
		Plant plant = plantService.querybyid(pid);
		model.put("plant", plant);
		return "plantmodify";

	}

	@RequestMapping("/changesubmit")
	private String PlantChangeSub(@RequestParam(name = "pid") int pid,
			@RequestParam(name = "pname") String pname,
			@RequestParam(name = "phylum") String phylum, @RequestParam(name = "pfamily") String pfamily,
			@RequestParam(name = "pgenus") String pgenus, @RequestParam(name = "pdesc") String pdesc,
			@RequestParam(name = "pphotos") String pphotos) {
		Plant plant = new Plant(pname, pphotos, pdesc, pfamily, pgenus, phylum);
		boolean b = plantService.changeplant(plant);
		if (b) {
			return "Success";
		} else {
			return "404";
		}
	}


}
