package com.example.demo.controller;

import com.example.demo.model.Certificado;
import com.example.demo.model.Evento;
import com.example.demo.model.Historico;
import com.example.demo.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/usuario/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<Historico> getAllHistorico() {
        return historicoService.getAllHistoricos();
    }

    @PutMapping("/{id}")
    public Historico saveOrUpdateHistorico(@PathVariable Long id,@RequestBody Historico historico) {
        historico.setId(id);
        return historicoService.saveOrUpdateHistorico(historico);
    }

    @GetMapping("/{id}")
    public Historico getHistoricoById(@PathVariable Long id) { return historicoService.getHistoricoById(id); }

    @GetMapping("/{id}/inscricoes")
    public List<Evento> getAllInscricoes(@PathVariable Long id) { return historicoService.getAllInscricoes(id); }

    @GetMapping("/{id}/certificados")
    public List<Certificado> getAllCertificados(@PathVariable Long id) { return historicoService.getAllCertificados(id);}

    @GetMapping("/{id}/carga-horaria")
    public BigDecimal getCargaHoraria(@PathVariable Long id) { return historicoService.getCargaHoraria(id); }



}



