package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CatalogoController {

    @RequestMapping("/home")
    public String index (){
        return "homePage";
    }

    @RequestMapping("/loginPage")
    public String routeLogin() {
        return "loginPage";
    }
}
