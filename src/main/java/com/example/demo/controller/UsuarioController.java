package com.example.demo.controller;

import com.example.demo.model.Evento;
import com.example.demo.model.UserAuth;
import com.example.demo.model.Usuario;
import com.example.demo.service.EventoService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EventoService eventoService;

    @PostMapping("/auth")
    public String autenticaUsuario(UserAuth userAuth, RedirectAttributes attributes, Model model){
        Usuario usuario = usuarioService.autenticaUsuario(userAuth.getLogin(), userAuth.getPassword());
        if (usuario != null){
            List<Evento> eventos = eventoService.getAllEventos();
            return indexAuth(model, usuario, eventos);
        }
        attributes.addFlashAttribute("authError", "Usuário não encontrado :(");
        return "redirect:/loginPage";
    }

    public String indexAuth (Model model, Usuario usuario, List<Evento> eventos){
        model.addAttribute("usuario", usuario);
        model.addAttribute("eventos", eventos);
        if (usuario.getRole().equals("aluno")){
            return "aluno/catalogoAluno";
        }
        return "coord/catalogoCoord";
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
