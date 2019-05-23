package Laboratorio5.Clases;

import Laboratorio5.Interfaces.Ibeber;

import java.util.Random;

public class BeberVikingoImp implements Ibeber {

    public Integer beber(Integer extra){
        Random r = new Random();
        Integer numero = r.nextInt(20) + (extra*2);


        /*COMPRUEBO QUE EL NUMERO SEA PAR, SINO LE SUMO UNO PARA QUE SE VUEVLA PAR */
        if((numero%2) != 0){
            numero++;
        }

        return numero;
    }


}
