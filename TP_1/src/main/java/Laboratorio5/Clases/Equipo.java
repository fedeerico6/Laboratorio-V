package Laboratorio5.Clases;

import Laboratorio5.JDBC.BaseDeDatos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Equipo {

    private List<Humano> equipo;

    public Equipo(){

        equipo = new ArrayList<Humano>();
    }

    public List<Humano> getEquipo(){
        return equipo;
    }

    public void add(Humano humano){

        equipo.add(humano);
    }

    public void setEquipo(List<Humano> equipo) {
        this.equipo = equipo;
    }

    public void ordenarPorPeso(){

        equipo.sort(Comparator.comparingInt(Humano::getPeso));
    }

    public void listarEquipo(){
        System.out.println("Equipo:");
        equipo.forEach(humano -> System.out.println(humano.toString()));
        System.out.println("\n\n");
    }

    public void retirarPrimeroDelEquipo(){
        if(equipo.size()>=0) {
            equipo.remove(0);
        }
    }

    public void combatir(List<Humano> visitantes){
        Boolean flag = true;
        while (flag){
            Random r = new Random();
            Integer tamañoLocal = equipo.size();
            Integer tamañoVisitante = visitantes.size();

            Humano local = equipo.get(r.nextInt(tamañoLocal));
            Humano visitante = visitantes.get(r.nextInt(tamañoVisitante));

            System.out.println("El combate se realiza entre:");
            System.out.println(local.toString());
            System.out.println(visitante.toString());

            Integer beberLocal = null;
            Integer orinarLocal = null;
            Integer beberVisitante = null;
            Integer orinarVisitante = null;

            if(local instanceof Vikingo){
                beberLocal = local.getBeber(((Vikingo) local).getExtra());
                orinarLocal = local.getOrinar(r.nextInt(50));
            } else {
                beberLocal = local.getBeber(r.nextInt(50));
                orinarLocal = local.getOrinar(((Espartano) local).getExtra());
            }

            if(visitante instanceof Vikingo){
                beberVisitante = visitante.getBeber(((Vikingo) visitante).getExtra());
                orinarVisitante = visitante.getOrinar(r.nextInt(50));
            } else {
                beberVisitante = visitante.getBeber(r.nextInt(50));
                orinarVisitante = visitante.getBeber(((Espartano) visitante).getExtra());
            }

            Integer sumaLocal = beberLocal + orinarLocal;
            Integer sumaVisitante = beberVisitante + orinarVisitante;
            if(sumaLocal == sumaVisitante){
                flag = true;
            } else {
                flag = false;
                if(sumaLocal > sumaVisitante){
                    System.out.println("GANO: " + local.toString());
                    BaseDeDatos.insertar(local.getNombre(),sumaLocal);
                    BaseDeDatos.leer();
                } else {
                    System.out.println("GANO: " + visitante.toString());
                    BaseDeDatos.insertar(visitante.getNombre(),sumaVisitante);
                    BaseDeDatos.leer();
                }
            }

        }

    }



}
