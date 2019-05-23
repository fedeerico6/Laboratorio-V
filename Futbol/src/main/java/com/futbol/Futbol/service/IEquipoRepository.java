package com.futbol.Futbol.service;

import com.futbol.Futbol.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipoRepository extends JpaRepository<Equipo,Integer> {
}
