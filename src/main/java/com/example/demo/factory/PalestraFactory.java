package com.example.demo.factory;
import com.example.demo.model.Evento;
import com.example.demo.model.Palestra;
import com.example.demo.service.EventoService;

public class PalestraFactory extends EventoFactory {
    @Override
    public Evento createEvento(Evento evento) {
        Palestra palestra = new Palestra();
        EventoService.copyEventoFields(evento, palestra);
        return palestra;
    }

    @SuppressWarnings("unused")
    protected void copyEventoFields(Evento source, Evento target) {
        target.setNome(source.getNome());
        target.setDescricao(source.getDescricao());
        target.setData(source.getData());
        target.setHorario(source.getHorario());
        target.setCategoria(source.getCategoria());
        target.setVagas(source.getVagas());
    }
}