package bruff.eventuff.controller;

import bruff.eventuff.model.Evento;
import bruff.eventuff.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
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
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.saveOrUpdateEvento(evento);
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
}
