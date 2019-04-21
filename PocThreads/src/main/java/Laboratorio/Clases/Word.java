package Laboratorio.Clases;

import Laboratorio.JDBC.WordDao;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;

    }

    public Word(){
        word = WordDao.readWord();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char[] stringToChar(){
        char[] array = word.toCharArray();
        return array;
    }

    public Integer quantityRepetitions(char letter){
        String letterWord = Character.toString(letter);
        char[] arrayChar = stringToChar();
        Integer count = 0;
        if(word.contains(letterWord)){
            for(int i=0; i<word.length(); i++){
                if(arrayChar[i] == letter){
                    count++;
                }
            }
        }
        return count;
    }

    public char[] replaceLetter(char letter){
        char[] arrayChar = stringToChar();
        for(int i=0; i<arrayChar.length; i++){
            if(arrayChar[i] == letter){
                arrayChar[i] = '*';
            }
        }
        return arrayChar;
    }

    public boolean haveLetters(){
        boolean flag = Boolean.FALSE;
        Integer i = 0;
        char[] arrayChar = stringToChar();
        while ((i<arrayChar.length) && (!flag)){
            if(arrayChar[i] != '*'){
                flag = true;
            }
            i++;
        }
        return flag;
    }



}
