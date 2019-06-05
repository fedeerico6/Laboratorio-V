package com.parcial.primerparcial.repository;

import com.parcial.primerparcial.domains.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Integer> {
}
