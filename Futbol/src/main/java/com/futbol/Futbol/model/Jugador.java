package com.futbol.Futbol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "El nombre del equipo no puede ser nulo")
    private String nombre;

    @Min(value = 18, message = "El jugador no puede ser menor de edad")
    @Max(value =34, message = "El jugador es un viejo choto, que se retire")
    private Integer edad;

    @ManyToMany(mappedBy = "jugadores")
    @JsonIgnore
    private List<Equipo> equipos;

    public void setEquipo(Equipo equipo) {
        equipos.add(equipo);
    }
}
