package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CategoriaEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Evento> eventos;

    public CategoriaEvento() {

    }
}
