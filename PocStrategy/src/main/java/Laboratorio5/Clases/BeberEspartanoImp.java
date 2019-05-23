package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Ibeber;

import java.util.Random;

public class BeberEspartanoImp implements Ibeber {

    public Integer beber(Integer extra) {
        Random r = new Random();
        Integer numero = r.nextInt(20) + extra;

        /* LO HAGO PARA QUE EL METODO SIEMPRE DEVUELVA UN NUMERO IMPAR  */
        if((numero%2) == 0){
            numero++;
        }

        return numero;
    }
}
