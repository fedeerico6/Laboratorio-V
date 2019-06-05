package com.parcial.primerparcial.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String descripcion;
    private String foto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaPublicacion;
    private Integer liked;
    @OneToMany
    private List<Comentario> comentarios;
    @ManyToOne
    private Usuario usuario;

    @PrePersist
    public void setFechaPublicacion() {
        if(isNull(this.fechaPublicacion)) {
            this.fechaPublicacion = LocalDateTime.now();
        }
    }

}
