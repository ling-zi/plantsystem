package com.em248.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping
@Controller
public class IndexController {



    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = {"/","/kind"})
    public String kind(){
        return "kind";
    }
}
