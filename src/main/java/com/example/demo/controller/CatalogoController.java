package com.example.demo.controller;

import com.example.demo.model.UserAuth;
import com.example.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CatalogoController {

    @Autowired
    private EventoService eventoService;

    @RequestMapping("/home")
    public String index (Model model){
        model.addAttribute("eventos",eventoService.getAllEventos()); //trocar getAll por getAll q tem vaga
        return "homePage";
    }

    @RequestMapping("/loginPage")
    public String routeLogin(Model model) {
        model.addAttribute("userAuth", new UserAuth());
        return "loginPage";
    }
}
