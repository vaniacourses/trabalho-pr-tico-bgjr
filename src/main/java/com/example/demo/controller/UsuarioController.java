package com.example.demo.controller;

import com.example.demo.model.UserAuth;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/auth")
    public String autenticaUsuario(UserAuth userAuth, RedirectAttributes attributes){
        Usuario usuario = usuarioService.autenticaUsuario(userAuth.getLogin(), userAuth.getPassword());
        if (usuario != null){
            Long id = usuario.getId(); //como usar id?
            if (usuario.getRole().equals("aluno")){
                return "aluno/catalogoAluno";
            } else if (usuario.getRole().equals("coord")) {
                return "coord/catalogoCoord";
            }
        }
        attributes.addFlashAttribute("authError", "Usuário não encontrado :(");
        return "redirect:/loginPage";
    }

    @RequestMapping("/auth/listar")
    public String listarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "coord/gridAlunos";
    }

    @RequestMapping("/auth/registrar")
    public String registarEvento() {
        return "coord/fabricaEvento";
    }
}
