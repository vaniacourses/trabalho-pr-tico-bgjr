package com.example.demo.controller;

import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
}
