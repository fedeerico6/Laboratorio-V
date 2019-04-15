package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Ibeber;
import Laboratorio5.Interfaces.Iorinar;

public class Espartano extends Humano{

    private Integer toleranciaExtra;

    public Espartano() {
        super();
        toleranciaExtra = null;
    }

    public Espartano(String nombre, Integer edad, Integer peso, Iorinar orinar, Ibeber beber,Integer toleranciaExtra) {
        super(nombre, edad, peso, orinar, beber);
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public String toString() {
        return "Espartano{" +
                "toleranciaExtra=" + toleranciaExtra +
                "} " + super.toString();
    }
}
