package com.futbol.Futbol;

import com.futbol.Futbol.model.Equipo;
import com.futbol.Futbol.model.Jugador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class FutbolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);
	}
}
