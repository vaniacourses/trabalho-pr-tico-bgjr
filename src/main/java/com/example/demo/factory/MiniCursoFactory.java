package com.example.demo.factory;
import com.example.demo.model.Evento;
import com.example.demo.model.MiniCurso;
import com.example.demo.service.EventoService;

public class MiniCursoFactory extends EventoFactory {
    @Override
    public Evento createEvento(Evento evento) {
        MiniCurso miniCurso = new MiniCurso();
        EventoService.copyEventoFields(evento, miniCurso);
        return miniCurso;
    }

    private void copyEventoFields(Evento source, Evento target) {
        target.setNome(source.getNome());
        target.setDescricao(source.getDescricao());
        target.setData(source.getData());
        target.setHorario(source.getHorario());
        target.setCategoria(source.getCategoria());
        target.setVagas(source.getVagas());
    }
}
