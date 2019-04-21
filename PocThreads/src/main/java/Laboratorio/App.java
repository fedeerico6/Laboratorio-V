package Laboratorio;

import Laboratorio.Clases.Game;
import Laboratorio.Clases.Player;
import Laboratorio.Clases.Winner;
import Laboratorio.JDBC.WinnerDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game ahorcado = new Game();
        Thread[] players = new Thread[2];
        Player[] playersAux = new Player[2];
        playersAux[0] = new Player("Federico Elias",ahorcado);
        playersAux[1] = new Player("Maia Luques Fiumidinisi",ahorcado);

        for(int i=0; i < players.length; i++){
            players[i] = new Thread(playersAux[i]);
            players[i].start();
        }

        WinnerDao.read();

    }
}
