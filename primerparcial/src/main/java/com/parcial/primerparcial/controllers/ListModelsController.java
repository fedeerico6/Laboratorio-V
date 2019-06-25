package com.parcial.primerparcial.controllers;

import com.parcial.primerparcial.domains.Comentario;
import com.parcial.primerparcial.domains.ListModels;
import com.parcial.primerparcial.domains.Publicacion;
import com.parcial.primerparcial.domains.Usuario;
import com.parcial.primerparcial.repository.IComentarioRepository;
import com.parcial.primerparcial.repository.IPublicacionRepository;
import com.parcial.primerparcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/listmodels")
public class ListModelsController {

    @Autowired
    UsuarioController usuarioController;

    @Autowired
    ComentarioController comentarioController;

    @Autowired
    PublicacionController publicacionController;

    @GetMapping("AllContent")
    public ResponseEntity<?> retornarListas() {
        CompletableFuture<List<Publicacion>> publicaciones = publicacionController.getAllSync();
        CompletableFuture<List<Usuario>> usuarios = usuarioController.getAllSync();
        CompletableFuture<List<Comentario>> comentarios = comentarioController.getAllSync();

        ListModels listModels = new ListModels();
        try {
            listModels.setComentarios(comentarios.get());
            listModels.setUsuarios(usuarios.get());
            listModels.setPublicaciones(publicaciones.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(200).body(listModels);
    }
}
