package Lav;

import java.util.Observable;

public class Auto extends Observable {
    private String patente;
    private String marca;
    private String modelo;
    private Integer nivelAceite;
    private Integer presionNeumaticos;
    private Integer nivelAgua;

    public Auto(String patente, String marca, String modelo, Integer nivelAceite, Integer presionNeumaticos, Integer nivelAgua) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.nivelAceite = nivelAceite;
        this.presionNeumaticos = presionNeumaticos;
        this.nivelAgua = nivelAgua;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNivelAceite() {
        return nivelAceite;
    }

    public void setNivelAceite(Integer nivelAceite) {
        String msj = "El nivel antiguo del aceite era de: "+this.nivelAceite;
        this.nivelAceite = nivelAceite;
        setChanged();
        notifyObservers(msj);
    }

    public Integer getPresionNeumaticos() {
        return presionNeumaticos;
    }

    public void setPresionNeumaticos(Integer presionNeumaticos) {
        String msj = "La presion antigua de los neumaticos era de: "+this.presionNeumaticos;
        this.presionNeumaticos = presionNeumaticos;
        setChanged();
        notifyObservers(msj);
    }

    public Integer getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(Integer nivelAgua) {
        String msj = "El nivel antiguo del agua era de: "+this.nivelAgua;
        this.nivelAgua = nivelAgua;
        setChanged();
        notifyObservers(msj);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", nivelAceite=" + nivelAceite +
                ", presionNeumaticos=" + presionNeumaticos +
                ", nivelAgua=" + nivelAgua +
                "} " + super.toString();
    }
}
