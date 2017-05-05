package com.em248.controller;

import com.em248.model.Plant;
import com.em248.service.PlantService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private String PlantAdd(@RequestParam(name = "pname") String pname, @RequestParam(name = "phylum") String phylum,
			@RequestParam(name = "pfamily") String pfamily, @RequestParam(name = "pgenus") String pgenus,
			@RequestParam(name = "pdesc") String pdesc, @RequestParam(name = "pphotos") String pphotos) {
		Plant plant = new Plant(pname, pphotos, pdesc, pfamily, pgenus, phylum);
		boolean b = plantService.addplant(plant);
		if (b) {
			return "addplant";
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
	private String PlantChangeSub(@RequestParam(name = "pname") String pname,
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
