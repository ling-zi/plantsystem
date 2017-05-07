package com.em248.controller;

import com.em248.model.Plant;
import com.em248.model.User;
import com.em248.service.UserService;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tian on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/login_register")
    private String loginRegister(){
        return "/login_register";
    }

    /**
     * 用户登录
     */
    @RequestMapping("")
    private String UserLogin(@RequestParam String username,
                             @RequestParam String password,
                             HttpServletRequest request,
                             Map<String, Object> model) {
        // 登录
        // 把从网页中获取的值存起来
        User u = userService.login(username, password);
        if (u != null) {
        	model.put("user", u);
            // 设置一个登录状态，存放用户名（过滤器可以检测到这个状态，让已登录的用户不被过滤掉）
            request.setAttribute("loginstate", u.getUname());
            request.setAttribute("uid", u.getUid());
            return "/userinfo"; //登录成功后会跳到个人信息的页面
        } else {
            return "/404";
        }

    }


    @RequestMapping("/register")
    public String userRegister(@RequestParam(name = "r_username") String username,
                               @RequestParam(name = "r_password") String password,
                               @RequestParam(name = "r_email") String email) {


        User user = new User(username, email, password);
        boolean b = userService.register(user);
        if (b) {
            return "login";
//                response.sendRedirect(request.getContextPath()+"/myLogin?type=index");
        } else {
            return "404";
//                response.sendRedirect(request.getContextPath()+"/404.jsp");
        }
    }

    
  //显示修改个人信息
  	@RequestMapping("/modify")
  	public String userModifyPage(@RequestParam(name = "uid") int uid, Map<String, Object> model) {
		User user = userService.querybyid(uid);
		model.put("user", user);
  		return "usermodify";
  	}
  	//处理修改个人信息
  	@RequestMapping("/domodify")
  	public String doModify(@RequestParam(name="uid") int uid,
  			@RequestParam(name="uname") String uname,
  			@RequestParam(name="usexy") String usexy,
  			@RequestParam(name="uimageurl") String uimageurl,
  			@RequestParam(name="uemail") String uemail,
  			@RequestParam(name="ucellphone") String ucellphone,
  			@RequestParam(name="uaddress") String uaddress
  			){
  		User user =new User(uid, uname, uemail,  uimageurl, ucellphone, usexy, uaddress);
  		boolean b = userService.changeUser(user);
  		if(b){
  			return "Success";
  		}
  		else{
  			return "404";
  		}
  		
  	}
}
