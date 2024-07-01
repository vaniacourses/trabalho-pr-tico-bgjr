package com.example.demo.factory;

import com.example.demo.model.Evento;
import com.example.demo.model.Palestra;
import com.example.demo.model.MiniCurso;
import com.example.demo.model.Maratona;
import org.springframework.stereotype.Component;

@Component
public class DefaultEventoFactory implements EventoFactory {

    @Override
    public Evento createEvento() {
        return new Evento();
    }

    @Override
    public Palestra createPalestra() {
        return new Palestra();
    }

    @Override
    public MiniCurso createMiniCurso() {
        return new MiniCurso();
    }

    @Override
    public Maratona createMaratona() {
        return new Maratona();
    }
}
