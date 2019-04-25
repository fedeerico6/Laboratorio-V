package Lav;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Taller t1 = new Taller(new Mecanico(),new Auto("YOF791","Pegueot","207",10,10,10));
        t1.asignarObserver();
        t1.setNivelAceite(25);
    }
}
