package com.example.demo.service;

import com.example.demo.model.Evento;
import com.example.demo.model.InscricaoEvento;
import com.example.demo.model.Usuario;
import com.example.demo.repository.InscricaoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoFacade {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private InscricaoEventoRepository inscricaoEventoRepository;

    public boolean inscricaoFacade(Evento evento, Usuario usuario){
        if (evento.getVagas() > 0){
            if (evento.getInscritos().contains(usuario)){
                return false; //o usuario ja esta inscrito
            }

            int numero_vagas_antigo = evento.getVagas();
            evento.setVagas(numero_vagas_antigo - 1);

            List<Usuario> inscritos = evento.getInscritos();
            inscritos.add(usuario);
            evento.setInscritos(inscritos);

            eventoService.saveOrUpdateEvento(evento); //atualiza numero de vagas e lista de inscritos do evento

            InscricaoEvento entidadeInscricao = new InscricaoEvento();
            entidadeInscricao.setUsuario(usuario);
            entidadeInscricao.setEvento(evento);
            entidadeInscricao.setDataInscricao(LocalDate.now());
            entidadeInscricao.setSituacao("Inscrito");

            entidadeInscricao = inscricaoEventoRepository.save(entidadeInscricao);

            //adicionar entidadeInscricao a historico de usuario
            return true;
        }
        return false;
    }
}
