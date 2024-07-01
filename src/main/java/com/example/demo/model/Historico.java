package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Historico {
    @OneToOne
    private Long idUsuario;
    private List<Evento> incricoes;
    private List<Certificado> certificados;
    private BigDecimal cargaHoraria;

    public Historico(){

    }
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Evento> getIncricoes() {
        return incricoes;
    }

    public void setIncricoes(List<Evento> incricoes) {
        this.incricoes = incricoes;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public BigDecimal getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(BigDecimal cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
