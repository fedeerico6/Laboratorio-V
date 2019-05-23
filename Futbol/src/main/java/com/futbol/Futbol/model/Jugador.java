package com.futbol.Futbol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jugador {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private Integer edad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    private Equipo equipo;

    public void setEquipo(Equipo e) {
        equipo = e;
    }
}
