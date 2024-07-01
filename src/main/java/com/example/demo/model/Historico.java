package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Historico {
    @Id
    private Long id;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Evento> incricoes;
    @OneToMany
    private List<Certificado> certificados;
    private BigDecimal cargaHoraria;

    public Historico(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
