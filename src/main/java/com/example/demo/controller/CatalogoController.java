package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogoController {

    @RequestMapping("/")
    public String index (){
        return "homePage";
    }

    @RequestMapping("/loginPage")
    public String routeLogin() {
        return "loginPage";
    }
}
