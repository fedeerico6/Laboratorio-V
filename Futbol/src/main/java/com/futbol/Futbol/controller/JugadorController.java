package com.futbol.Futbol.controller;

import com.futbol.Futbol.model.Equipo;
import com.futbol.Futbol.model.Jugador;
import com.futbol.Futbol.model.JugadorDTO;
import com.futbol.Futbol.service.IEquipoRepository;
import com.futbol.Futbol.service.IJugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/jugador")
@RestController
public class JugadorController {
    @Autowired
    IJugadorRepository jugadorRepository;

    @Autowired
    IEquipoRepository equipoRepository;

    @PostMapping("")
    public void addJugador(@RequestBody Jugador j) {
        jugadorRepository.save(j);
    }

    @GetMapping("")
    public List<Jugador> getAll() {
        return jugadorRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No exsiste el jugador con el id: ", id)));
        Equipo equipo = equipoRepository.findById(jugador.getEquipo().getId())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No exsiste el equipo que tenga un jugador con este id: ", id)));
        List<Jugador> jugadores = equipo.getJugadores();
        jugadores = jugadores.stream()
                 .dropWhile(j -> j.getId() == id)
                 .collect(Collectors.toList());
        equipo.setJugadores(jugadores);
        equipoRepository.save(equipo);
        jugadorRepository.delete(jugador);
    }

    @GetMapping("/obtener/{idJugador}")
    public JugadorDTO getById(@PathVariable final Integer idJugador) {
        Jugador jugador = jugadorRepository.findById(idJugador)
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No exsiste el jugador con el id",idJugador)));
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jugador,JugadorDTO.class);
    }
}
