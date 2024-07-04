package com.example.demo.factory;

import com.example.demo.model.Evento;

public abstract class EventoFactory {
    public abstract Evento createEvento(Evento evento);
}

