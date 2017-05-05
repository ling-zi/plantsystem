package com.em248.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tian on 2017/5/4.
 */
@RequestMapping
@Controller
public class IndexController {



    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }
}
