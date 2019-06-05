package com.parcial.primerparcial.repository;

import com.parcial.primerparcial.domains.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
}
