package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Ibeber;
import Laboratorio5.Interfaces.Iorinar;

public class Humano {

    private String nombre;
    private Integer edad;
    private Integer peso;
    private Iorinar orinar;
    private Ibeber beber;

    public Humano(){
        this.nombre = null;
        this.edad = null;
        this.peso = null;
        this.orinar = null;
        this.beber = null;
    }

    public Humano(String nombre,Integer edad,Integer peso,Iorinar orinar,Ibeber beber){
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setOrinar(Iorinar orinar) {
        this.orinar = orinar;
    }

    public void setBeber(Ibeber beber) {
        this.beber = beber;
    }

    public Integer getBeber(Integer numero){
        return beber.beber(numero);
    }

    public Integer getOrinar(Integer numero){
        return orinar.orinar(numero);
    }

    @Override
    public String toString() {
        return "Humano{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                '}';
    }
}
