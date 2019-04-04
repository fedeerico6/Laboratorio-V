package App;

import java.util.Objects;

public class Equipo {
    private Integer id_equipo;
    private String nombre;


    public Equipo(){
        id_equipo = null;
        nombre = null;
    }

    public Equipo(Integer id_equipo, String nombre) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo equipo = (Equipo) o;
        return getId_equipo().equals(equipo.getId_equipo()) &&
                getNombre().equals(equipo.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_equipo(), getNombre());
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id_equipo=" + id_equipo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
