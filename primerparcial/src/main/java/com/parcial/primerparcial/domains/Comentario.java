package com.parcial.primerparcial.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fecha;
    private String owner;
    @ManyToOne
    @JsonIgnore
    private Publicacion publicacion;

    @PrePersist
    public void setTime() {
        if(isNull(this.fecha)) {
            this.fecha = LocalDateTime.now();
        }
    }
}
