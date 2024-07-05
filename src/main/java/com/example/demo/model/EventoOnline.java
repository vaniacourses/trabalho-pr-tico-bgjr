package com.example.demo.model;

public class EventoOnline extends Evento {

    private String url;

    public EventoOnline() {}

    public EventoOnline(Long id, String nome, String descricao, String url) {
        super(id, nome, descricao);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + ", URL: " + url;
    }
}
