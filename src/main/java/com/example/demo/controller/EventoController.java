package com.example.demo.controller;

import com.example.demo.model.Evento;
import com.example.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public Evento getEventoById(@PathVariable Long id) {
        return eventoService.getEventoById(id);
    }

    @PostMapping
    public ResponseEntity<?> createEvento(@RequestBody Evento evento) {
        try {
            Evento createdEvento = eventoService.createEvento(evento);
            return ResponseEntity.ok(createdEvento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return eventoService.saveOrUpdateEvento(evento);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
    }

    @GetMapping("/search")
    public List<Evento> searchEvents(@RequestParam String nome) {
        return eventoService.getEventoByNome(nome);
    }
}
