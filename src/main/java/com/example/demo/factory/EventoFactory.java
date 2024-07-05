package com.example.demo.factory;

import com.example.demo.model.Evento;

public abstract class EventoFactory {
    public abstract Evento createEvento(Evento evento);

    protected void copyEventoFields(Evento source, Evento target) {}

    protected boolean validateEvento(Evento evento) {
        return evento.getNome() != null && !evento.getNome().isEmpty() &&
               evento.getData() != null &&
               evento.getHorario() != null;
    }
}

