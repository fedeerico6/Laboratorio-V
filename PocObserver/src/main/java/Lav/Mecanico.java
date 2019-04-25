package Lav;

import java.util.Observable;
import java.util.Observer;

public class Mecanico implements Observer {

    public Mecanico() { }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        System.out.println("El auto con sus modiciaciones quedo de la siguiente manera: ");
        System.out.println(o.toString());
    }
}
