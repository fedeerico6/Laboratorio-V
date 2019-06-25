package com.parcial.primerparcial.repository;

import com.parcial.primerparcial.domains.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionDTORepository extends JpaRepository<Publicacion, Integer> {

    String query = "select titulo, nombre, count(c.id) as cantidad from usuario u inner join publicacion p on u.id = p.usuario_id inner join comentario c on p.id = c.publicacion_id group by titulo, nombre";
    @Query(value = query , nativeQuery = true)
    public List<PublicacionDTO> getAllPublicaciones();

}
