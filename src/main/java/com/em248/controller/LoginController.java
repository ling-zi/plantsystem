package com.em248.controller;

import com.em248.model.User;
import com.em248.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                             HttpServletRequest request) {
        // 登录

        // 把从网页中获取的值存起来
        User u = userService.login(username, password);
        if (u != null) {
            // 设置一个登录状态，存放用户名（过滤器可以检测到这个状态，让已登录的用户不被过滤掉）
            request.setAttribute("loginstate", u.getUname());
            return "/index";
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

}
