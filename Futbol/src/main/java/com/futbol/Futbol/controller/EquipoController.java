package com.futbol.Futbol.controller;

import com.futbol.Futbol.model.Equipo;
import com.futbol.Futbol.service.IEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RequestMapping("/equipo")
@RestController
public class EquipoController {
    @Autowired
    IEquipoRepository equipoRepository;

    @PostMapping("")
    public void addEquipo(@RequestBody Equipo e){
        equipoRepository.save(e);
    }

    @GetMapping("")
    public List<Equipo> getAll() {
        return equipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable final Integer id)  {
        return equipoRepository.findById(id)
               .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No exsiste el equipo con el id", id)));
    }
}
