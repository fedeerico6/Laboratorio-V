package Clases;

public class Event {

    private Integer id;
    private String name;
    private Location location;

    public Event() {
        this.id = 0;
        this.name = "";
        this.location = null;
    }

    public Event(Integer id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
