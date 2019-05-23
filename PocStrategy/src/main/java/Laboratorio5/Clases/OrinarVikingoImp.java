package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Iorinar;

import java.util.Random;

public class OrinarVikingoImp implements Iorinar {

    public Integer orinar(Integer extra){
        Random r = new Random();
        Integer numero = r.nextInt(20) + extra;

        /* LO HAGO PARA QUE EL METODO SIEMPRE DEVUELVA UN NUMERO PAR  */
        if((numero%2) != 0){
            numero++;
        }

        return numero;
    }
}
