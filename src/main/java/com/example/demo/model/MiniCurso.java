package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MiniCurso")
public class MiniCurso extends Evento {
    // Additional fields if any
}
