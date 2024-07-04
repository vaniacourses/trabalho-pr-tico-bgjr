package com.example.demo.service;

import com.example.demo.factory.EventoFactory;
import com.example.demo.factory.MaratonaFactory;
import com.example.demo.factory.MiniCursoFactory;
import com.example.demo.factory.PalestraFactory;
import com.example.demo.model.Evento;
import com.example.demo.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;

import java.util.List;

@Service
public class EventoService {

    private Map<String, EventoFactory> factoryMap;


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

    public EventoService() {
        factoryMap = new HashMap<>();
        factoryMap.put("palestra", new PalestraFactory());
        factoryMap.put("minicurso", new MiniCursoFactory());
        factoryMap.put("maratona", new MaratonaFactory());
    }

    public Evento createEvento(Evento evento) {
        EventoFactory factory = factoryMap.get(evento.getCategoria().toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Invalid event type");
        }
        Evento newEvento = factory.createEvento(evento);
        copyEventoFields(evento, newEvento);
        return saveOrUpdateEvento(newEvento);
    }

    public static void copyEventoFields(Evento source, Evento target) {
        target.setNome(source.getNome());
        target.setDescricao(source.getDescricao());
        target.setData(source.getData());
        target.setHorario(source.getHorario());
        target.setCategoria(source.getCategoria());
        target.setVagas(source.getVagas());
    }

    public List<Evento> getEventoByNome(String nome) {
        return eventoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
