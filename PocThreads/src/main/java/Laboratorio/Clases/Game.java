package Laboratorio.Clases;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Word word;
    private boolean status;
    private List<Character> alphabet;

    public Game(){
        word = new Word();
        status = Boolean.FALSE;
        alphabet = createAlphabet();
    }

    public List<Character> createAlphabet(){
        alphabet = new ArrayList<>();
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i < abecedario.length(); i++){
            alphabet.add(abecedario.charAt(i));
        }
        return alphabet;
    }

    public char chooseLetter(){
        int i=(int)(Math.random()*alphabet.size());
        char letter =alphabet.get(i);
        alphabet.remove(i);
        return letter;
    }

    public Word getWord(){ return this.word; }

    public synchronized Boolean playGame(){

        while (status){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        status = Boolean.TRUE;
        boolean success = Boolean.FALSE;
        if(word.haveLetters()){
            char letter = chooseLetter();
            if(word.quantityRepetitions(letter) > 0){
                word.replaceLetter(letter);
                success = true;
            }
        }

        status = Boolean.FALSE;
        notifyAll();
        return success;
    }







}
