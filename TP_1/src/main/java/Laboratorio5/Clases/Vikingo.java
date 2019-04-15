package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Ibeber;
import Laboratorio5.Interfaces.Iorinar;

public class Vikingo extends Humano {

    private Integer bebedorProfesional;

    public Vikingo(){
        super();
        this.bebedorProfesional = null;
    }

    public Vikingo(String nombre, Integer edad, Integer peso, Iorinar orinar, Ibeber beber, Integer bebedorProfesional) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfesional = bebedorProfesional;
    }

    public Integer getExtra() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {

        this.bebedorProfesional = bebedorProfesional;
    }

    @Override
    public String toString() {
        return "Vikingo{" +
                "bebedorProfesional=" + bebedorProfesional +
                "} " + super.toString();
    }
}
