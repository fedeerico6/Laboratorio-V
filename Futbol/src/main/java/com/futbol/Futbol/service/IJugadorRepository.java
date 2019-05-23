package com.futbol.Futbol.service;

import com.futbol.Futbol.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJugadorRepository extends JpaRepository<Jugador,Integer> {
}
