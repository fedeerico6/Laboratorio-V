package Laboratorio.Clases;

import Laboratorio.JDBC.WinnerDao;

import java.util.Date;
import java.util.Random;

public class Player implements Runnable{
    private boolean status = Boolean.FALSE;
    private String name;
    private Integer lives;
    private Game game;
    private Winner winner;

    public Player(String name, Game game){
        this.name = name;
        this.lives = 7;
        this.game = game;
        winner = null;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public String getNamePlayer() {
        return name;
    }


    public void setNamePlayer(String name) {
        this.name = name;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }


    @Override
    public void run() {
        boolean estado = Boolean.FALSE;
        while((!status) && (getLives()>0)){

            estado = game.playGame();
            if((estado) && (!game.getWord().haveLetters())){

                status = Boolean.TRUE;
                Winner ganador = new Winner(name,new Date(),game.getWord().getWord());
                WinnerDao.create(ganador);
                System.out.println("Gano: " + name);
            } else {

                lives--;
                if(lives <= 0){
                    System.out.println("El juego finalizo porque el jugador "+name+"se quedo sin vidas");
                } else {
                    if(!game.getWord().haveLetters()){
                        System.out.println("El jugador "+name+"perdio");
                    }
                }
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
