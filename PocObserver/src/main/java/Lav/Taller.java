package Lav;

public class Taller {
    private Mecanico mecanico;
    private Auto auto;

    public Taller(Mecanico m, Auto a){
        mecanico = m;
        auto = a;
    }

    public void asignarObserver(){
        auto.addObserver(mecanico);
    }

    public void setNivelAgua(Integer nivelAgua){
        auto.setNivelAgua(nivelAgua);
    }

    public void setPresionNeumaticos(Integer presionNeumaticos){
        auto.setPresionNeumaticos(presionNeumaticos);
    }

    public void setNivelAceite(Integer nivelAceite){
        auto.setNivelAceite(nivelAceite );
    }
}
