package com.example.demo.controller;

import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/aluno")
    public String acessoAluno (){
        return ""; //podera fazer inscricao e visualizar historico
    }

    @RequestMapping("/coord")
    public String acessoCoord (){
        return ""; //podera ver lista de alunos (e talvez seus historicos), crud eventos
    }

    @RequestMapping("/coord/listar")
    public String listarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "gridAlunos";
    }

    @RequestMapping("/coord/registrar")
    public String registarEvento() {
        return "fabricaEvento";
    }
}
