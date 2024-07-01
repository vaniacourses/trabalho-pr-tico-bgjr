package com.example.demo.service;

import com.example.demo.model.Evento;
import com.example.demo.model.Palestra;
import com.example.demo.model.MiniCurso;
import com.example.demo.model.Maratona;
import com.example.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Evento getEventoById(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public Evento saveOrUpdateEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public Evento createEvento(Evento evento) {
        switch (evento.getCategoria().toLowerCase()) {
            case "palestra":
                Palestra palestra = new Palestra();
                copyEventoFields(evento, palestra);
                return saveOrUpdateEvento(palestra);
            case "minicurso":
                MiniCurso miniCurso = new MiniCurso();
                copyEventoFields(evento, miniCurso);
                return saveOrUpdateEvento(miniCurso);
            case "maratona":
                Maratona maratona = new Maratona();
                copyEventoFields(evento, maratona);
                return saveOrUpdateEvento(maratona);
            default:
                throw new IllegalArgumentException("Invalid event type");
        }
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
