package com.futbol.Futbol.controller;

import com.futbol.Futbol.model.Equipo;
import com.futbol.Futbol.service.IEquipoRepository;
import com.futbol.Futbol.service.IJugadorRepository;
import org.junit.Test;
import org.mockito.Mock;

public class EquipoControllerTest {
    @Mock
    IEquipoRepository equipoRepository;

    @Mock
    IJugadorRepository jugadorRepository;

    @Test
    public void addEquipo() {
        Equipo equipo = new Equipo();


    }
}
