package com.parcial.primerparcial.controllers;

import com.parcial.primerparcial.domains.Publicacion;
import com.parcial.primerparcial.domains.Usuario;
import com.parcial.primerparcial.repository.IPublicacionRepository;
import com.parcial.primerparcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IPublicacionRepository publicacionRepository;

    @PostMapping("")
    public void agregarUsuario(@RequestBody final Usuario usuario, @RequestHeader HttpHeaders httpHeaders) {
        usuario.setBrowser(httpHeaders.get("user-agent").toString());
        usuarioRepository.save(usuario);
    }

    @GetMapping("")
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void borrarUsuario(@PathVariable final Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No se encontro el usuario con el id : ", id)));
        if (!isNull(usuario)) {
            usuarioRepository.delete(usuario);
        }
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable final Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No se encontro el usuario con el id : ", id)));
        return usuario;
    }

    @PutMapping("")
    public void modificarUsuario(@RequestBody final Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @PostMapping("/vincularConPublicacion/{idUsuario}/{idPublicacion}")
    public void vincularUsuarioConPublicacion(@PathVariable final Integer idUsuario, @PathVariable final Integer idPublicacion) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No exsiste el usuario con el id: ",idUsuario)));
        Publicacion publicacion = publicacionRepository.findById(idPublicacion)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe una publicacion con el id: ",idPublicacion)));
        publicacion.setUsuario(usuario);
        publicacionRepository.save(publicacion);
        usuario.getPublicaciones().add(publicacion);
        usuarioRepository.save(usuario);
    }
}
