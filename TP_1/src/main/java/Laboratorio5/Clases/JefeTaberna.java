package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Ibeber;
import Laboratorio5.Interfaces.Iorinar;

public class JefeTaberna extends Humano {
    private Integer bebedorProfesional;
    private Integer toleranciaExtra;

    public JefeTaberna(String nombre, Integer edad, Integer peso, Integer toleranciaExtra, Integer bebedorProfesional){
        super(nombre,edad,peso,new OrinarEspartanoImp(),new BeberVikingoImp());
        this.bebedorProfesional = bebedorProfesional;
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public String toString() {
        return "JefeTaberna{" +
                "bebedorProfesional=" + bebedorProfesional +
                ", toleranciaExtra=" + toleranciaExtra +
                "} " + super.toString();
    }
}
