package app;

import clases.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hola la concha de tu  madre");
        Persona persona1 = new Persona("allan",28,19040012);
        Persona persona2 = new Persona("federico", 14,40794525);
        Persona persona3 = new Persona("pablito", 66,56654456);

        List<Persona> personas= new ArrayList<Persona>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        System.out.println("--------Para imprimir la list completa--------");
        System.out.println(String.format("Personas: %s",personas));

        System.out.println("----------MAYORES A 21-------------");
        // mayores a 21
        System.out.println(String.format("Mayores a 21: %s",personas.stream()
        .filter(persona->persona.getEdad() > 21)
        .collect(Collectors.toList())));

        System.out.println("-----------MENORES A 18-------------------");
        // menores 18
        System.out.println(String.format("menores 18: %s",personas.stream()
                .filter(persona->persona.getEdad() < 18)
                .collect(Collectors.toList())));

        System.out.println("---------MAYORES A 21 + DNI >20000000 -------------------");
        System.out.println(String.format("MAYORES A 21 + DNI >20000000: %s",personas.stream()
                .filter(persona->persona.getEdad() > 21 && persona.getDni()>20000000)
                //.filter( persona->persona.getDni() >20000000) // tambien funciona con este
                .collect(Collectors.toList())));

    }
}
