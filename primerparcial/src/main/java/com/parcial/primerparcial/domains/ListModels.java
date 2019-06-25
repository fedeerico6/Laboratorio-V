package com.parcial.primerparcial.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListModels {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    @JsonIgnore
    private List<Comentario> comentarios = new ArrayList<Comentario>();
    private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
}
