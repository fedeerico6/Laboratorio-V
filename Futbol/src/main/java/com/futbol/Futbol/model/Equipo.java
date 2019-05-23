package com.futbol.Futbol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipo {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "El nombre del jugador no puede ser null")
    private String nombre;
    @OneToMany()
    private List<Jugador> jugadores;

    public void addJugador(Jugador j){
        jugadores.add(j);
    }
}
