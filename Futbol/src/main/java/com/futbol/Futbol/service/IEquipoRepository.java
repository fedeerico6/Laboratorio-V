package com.futbol.Futbol.service;

import com.futbol.Futbol.ICantJugadores;
import com.futbol.Futbol.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;

public interface IEquipoRepository extends JpaRepository<Equipo,Integer> {
    //projection

}
