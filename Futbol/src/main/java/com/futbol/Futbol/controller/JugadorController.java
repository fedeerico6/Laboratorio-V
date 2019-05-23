package com.futbol.Futbol.controller;

import com.futbol.Futbol.model.Equipo;
import com.futbol.Futbol.model.Jugador;
import com.futbol.Futbol.service.IEquipoRepository;
import com.futbol.Futbol.service.IJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/jugador")
@RestController
public class JugadorController {
    @Autowired
    IJugadorRepository jugadorRepository;
    @Autowired
    EquipoController equipoController;

    @PostMapping("/{idEquipo}")
    public void addJugador(@RequestBody Jugador j, @PathVariable Integer idEquipo) {
        Equipo e = equipoController.getEquipoById(idEquipo);
        j.setEquipo(e);
        jugadorRepository.save(j);
    }

    @GetMapping("")
    public List<Jugador> getAll() {
        return jugadorRepository.findAll();
    }
}
