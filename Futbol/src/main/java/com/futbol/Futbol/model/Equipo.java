package com.futbol.Futbol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "El nombre del jugador no puede ser null")
    private String nombre;
    @JoinTable(
            name = "equipo_x_jugador",
            joinColumns = @JoinColumn(name = "fk_equipo", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_jugador", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Jugador> jugadores;

    public void addJugador(Jugador j){
        jugadores.add(j);
    }
}
