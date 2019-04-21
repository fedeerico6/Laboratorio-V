package Laboratorio.Clases;

import java.util.Date;

public class Winner {
    private String name;
    private Date fecha;
    private String word;

    public Winner(String name, Date fecha, String word) {
        this.name = name;
        this.fecha = fecha;
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
