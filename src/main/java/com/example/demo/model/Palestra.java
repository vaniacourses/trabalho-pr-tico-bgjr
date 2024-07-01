package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Palestra")
public class Palestra extends Evento {
    // Additional fields if any
}
