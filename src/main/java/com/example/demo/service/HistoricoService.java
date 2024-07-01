package com.example.demo.service;

import com.example.demo.model.Certificado;
import com.example.demo.model.Evento;
import com.example.demo.model.Historico;
import com.example.demo.model.Usuario;
import com.example.demo.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public List<Historico> getAllHistoricos() {
        return historicoRepository.findAll();
    }

    public Historico getHistoricoById(Long id) { return historicoRepository.findById(id).orElse(null); }

    public Historico saveOrUpdateHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    public List<Evento> getAllInscricoes(Long historicoId) {
        Historico historico = getHistoricoById(historicoId);
        if (historico != null) {
            return historico.getIncricoes();
        }
        return Collections.emptyList();
    }

    public List<Certificado> getAllCertificados(Long historicoId) {
        Historico historico = getHistoricoById(historicoId);
        if (historico != null) {
            return historico.getCertificados();
        }
        return Collections.emptyList();
    }

    public BigDecimal getCargaHoraria(Long historicoId) {
        Historico historico = getHistoricoById(historicoId);
        if (historico != null) {
            return historico.getCargaHoraria();
        }
        return BigDecimal.ZERO;
    }
    public Usuario getUsuario(Long historicoId) {
        Historico historico = getHistoricoById(historicoId);
        if (historico != null) {
            return historico.getUsuario();
        }
        return null;
    }
}
