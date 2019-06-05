package com.parcial.primerparcial.controllers;

import com.parcial.primerparcial.domains.Comentario;
import com.parcial.primerparcial.domains.Publicacion;
import com.parcial.primerparcial.repository.IComentarioRepository;
import com.parcial.primerparcial.repository.IPublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    IComentarioRepository comentarioRepository;

    @Autowired
    IPublicacionRepository publicacionRepository;

    @PostMapping("")
    public void agregarComentario(@RequestBody final Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @GetMapping("")
    public List<Comentario> getAll() {
        return comentarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Integer id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No se encuentra el comentario con el id : ", id)));
        Publicacion publicacion = publicacionRepository.findById(comentario.getPublicacion().getId())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No se encuentra la publicacion que contenga el comentario con el id : ", id)));
        List<Comentario> coments = publicacion.getComentarios();
        coments = coments.stream()
                        .dropWhile((c) -> c.getId() == id)
                        .collect(Collectors.toList());
        publicacion.setComentarios(coments);
        publicacionRepository.save(publicacion);
        comentarioRepository.delete(comentario);
    }

    @Scheduled(fixedRateString = "${time}")
    public void schuled() {
        comentarioRepository.deleteAll();
    }
}
