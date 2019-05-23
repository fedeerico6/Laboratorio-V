package Clases;

import java.util.*;
import java.util.stream.Collectors;

public class ListEvents {

    private List<Event> events = null;

    public ListEvents(){
        this.events = new ArrayList<Event>();
    }

    public void add(Event event){
        events.add(event);
    }

    public List<Event> getEvents(){
        return this.events;
    }

    public List<Event> getOrdenarById(){
        events.sort(Comparator.comparingInt(Event::getId));
        return events;
    }

    public List<Event> getOrdenarAlfabeticamente(){
        Collections.sort(events,(Event e1,Event e2)->{
            return e1.getName().compareToIgnoreCase(e2.getName());
        });
        return events;
    }

    public List<Event> listFiveFirstEvent(){
        List<Event> firstFive= this.events.stream().limit(5).collect(Collectors.toList());
        return firstFive;
    }

    public void listEvents(){
        events.forEach(event -> System.out.println(event.getId() + " " + event.getName()));
    }

    public Event getEventById(Integer id){
        Optional<Event> event = events.stream()
                                .filter(e->e.getId() == id)
                                .findFirst();

        return event.isPresent() ? event.get() : null;
    }
}
