import Clases.City;
import Clases.Event;
import Clases.ListEvents;
import Clases.Location;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*LISTA QUE VA A CONTENER TODOS LOS EVENTOS */
        ListEvents eventos = new ListEvents();

        /*TODAS LAS CIUDADES */

        City city1 = new City(1,"Mar del Plata");
        City city2 = new City(2,"Buenos Aires");
        City city3 = new City(3,"La Pampa");
        City city4 = new City(4,"Cordoba");


        /* LOCACIONES POSIBLES*/
        Location location1 = new Location(1,"Libertadores de America",city2);
        Location location2 = new Location(2,"Islas Malvinas",city1);
        Location location3 = new Location(3,"Pepino 4",city1);
        Location location4 = new Location(4,"Ya no se",city3);
        Location location5 = new Location(5,"Federico Elias",city3);
        Location location6 = new Location(6,"Ronpe 99",city4);

        /*EVENTOS*/
        Event event = new Event(5, "Raptinencia",location2);
        eventos.add(event);

        event = new Event(2,"Canta mi chopa",location1);
        eventos.add(event);

        event = new Event(1,"Federico manda",location3);
        eventos.add(event);

        event = new Event(4,"Quilmes correcamino",location6);
        eventos.add(event);

        event = new Event(3,"Racing mi puta loca",location1);
        eventos.add(event);

        event = new Event(6,"Boca la concha de tu madre",location4);
        eventos.add(event);

        /*Listar todos los eventos*/
        System.out.println("LISTADOS");
        eventos.listEvents();

        /*Listar eventos ordenador por id*/
        System.out.println("LISTADOS POR ORDEN SEGUN SU ID");
        eventos.getOrdenarById();
        eventos.listEvents();

        /*LISTADOS ALFABETICAMENTE*/
        System.out.println("LISTADOS ALFABETICAMENTE");
        eventos.getOrdenarAlfabeticamente();
        eventos.listEvents();

        /*LOS PRIMEROS CINCO EVENTOS*/
        System.out.println("SOLO LOS PRIMEROS CINCO EVENTOS \n");
        List<Event> firstFive = eventos.listFiveFirstEvent();
        firstFive.forEach((e)-> System.out.println(e.getId()+" "+e.getName()));

        /*OBTENERLO POR ID*/
        System.out.println("Evento obtenido por id \n");
        System.out.println(eventos.getEventById(1));




    }
}
