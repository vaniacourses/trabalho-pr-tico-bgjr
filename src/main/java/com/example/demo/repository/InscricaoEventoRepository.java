package com.example.demo.repository;

import com.example.demo.model.InscricaoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoEventoRepository extends JpaRepository<InscricaoEvento, Long> {
}
