package com.parcial.primerparcial.controllers;

import com.parcial.primerparcial.domains.Comentario;
import com.parcial.primerparcial.domains.Publicacion;
import com.parcial.primerparcial.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {
    @Autowired
    IPublicacionRepository publicacionRepository;

    @Autowired
    IComentarioRepository comentarioRepository;

    @Autowired
    IPublicacionDTORepository publicacionDTORepository;

    @PostMapping("")
    public void agregarPublicacion(@RequestBody final Publicacion publicacion) {
        publicacionRepository.save(publicacion);
    }

    @GetMapping("")
    public List<Publicacion> getAll() {
        return publicacionRepository.findAll();
    }

    @PostMapping("vincularconComentario/{idPublicacion}/{idComentario}")
    public void vincularConUnComentario(@PathVariable final Integer idPublicacion, @PathVariable final Integer idComentario) {
        Publicacion publicacion = publicacionRepository.findById(idPublicacion)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe la publicacion con el id: ",idPublicacion)));
        Comentario comentario = comentarioRepository.findById(idComentario)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el comentario con el id: ",idComentario)));
        comentario.setPublicacion(publicacion);
        publicacion.getComentarios().add(comentario);
        comentarioRepository.save(comentario);
        publicacionRepository.save(publicacion);
    }

    @GetMapping("/query")
    public List<PublicacionDTO> getAllPub() {
        return publicacionDTORepository.getAllPublicaciones();
    }

    @GetMapping("/query2")
    public List<IPublicaciones> getAllPub2() {
        return publicacionRepository.getPublicaciones1();
    }

    @Async("Executor")
    CompletableFuture<List<Publicacion>> getAllSync() {
        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return CompletableFuture.completedFuture(publicaciones);
    }

}
