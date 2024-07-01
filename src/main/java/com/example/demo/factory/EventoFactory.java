package com.example.demo.factory;

import com.example.demo.model.Evento;
import com.example.demo.model.Palestra;
import com.example.demo.model.MiniCurso;
import com.example.demo.model.Maratona;

public interface EventoFactory {
    Evento createEvento();
    Palestra createPalestra();
    MiniCurso createMiniCurso();
    Maratona createMaratona();
}
