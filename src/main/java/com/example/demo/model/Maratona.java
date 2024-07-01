package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Maratona")
public class Maratona extends Evento {
    // Additional fields if any
}
