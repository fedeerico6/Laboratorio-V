package com.futbol.Futbol.controller;

import com.futbol.Futbol.model.Equipo;
import com.futbol.Futbol.model.Jugador;
import com.futbol.Futbol.service.IEquipoRepository;
import com.futbol.Futbol.service.IJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.ws.rs.core.Context;
import java.util.List;

@RequestMapping("/equipo")
@RestController
public class EquipoController {
    @Autowired
    IEquipoRepository equipoRepository;

    @Autowired
    IJugadorRepository jugadorRepository;

    @PostMapping("")
    public void addEquipo(@RequestBody Equipo e){
        equipoRepository.save(e);
    }

    @GetMapping("")
    public List<Equipo> getAll(@RequestHeader HttpHeaders httpHeaders) {
        System.out.println("ESTE ES EL PUTO HEADER "+httpHeaders.getOrigin());
        return equipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable final Integer id)  {
        return equipoRepository.findById(id)
               .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No exsiste el equipo con el id", id)));
    }

    @GetMapping("{id_equipo}/jugador")
    public void addJugador(@PathVariable final Integer id_equipo, @RequestBody Jugador j) {
        Equipo equipo = this.getEquipoById(id_equipo);
        equipo.addJugador(j);
        //equipo.getJugadores().add(j);
        this.equipoRepository.save(equipo);
    }

    @PostMapping("/vincular/{idEquipo}/{idJugador}")
    public void vincularJugadorConEquipo(@PathVariable final Integer idEquipo, @PathVariable final Integer idJugador) {
        Equipo equipo = equipoRepository.findById(idEquipo).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("me encanta la japi del equipo",idEquipo)));
        Jugador jugador = jugadorRepository.findById(idJugador).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("me encanta la  del jugador",idJugador)));
        equipo.getJugadores().add(jugador);
        equipoRepository.save(equipo);
        jugador.setEquipo(equipo);
        jugadorRepository.save(jugador);
    }

}
