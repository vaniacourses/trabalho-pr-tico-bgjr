package com.example.demo.factory;
import com.example.demo.model.Evento;
import com.example.demo.model.Maratona;
import com.example.demo.service.EventoService;

public class MaratonaFactory extends EventoFactory {
    @Override
    public Evento createEvento(Evento evento) {
        Maratona maratona = new Maratona();
        EventoService.copyEventoFields(evento, maratona);
        return maratona;
    }

    protected void copyEventoFields(Evento source, Evento target) {
        target.setNome(source.getNome());
        target.setDescricao(source.getDescricao());
        target.setData(source.getData());
        target.setHorario(source.getHorario());
        target.setCategoria(source.getCategoria());
        target.setVagas(source.getVagas());
    }
}
