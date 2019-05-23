package Laboratorio5;

import Laboratorio5.Clases.*;

import java.awt.image.RescaleOp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Equipo vikingos = new Equipo();
        Equipo espartanos = new Equipo();

        Humano vikingo = new Vikingo("Federico Elias",21,77,78);
        vikingos.add(vikingo);
        vikingo = new Vikingo("Maia Luques",20,55,80);
        vikingos.add(vikingo);
        vikingo = new Vikingo("Patricia Prieto",50,62,60);
        vikingos.add(vikingo);
        Humano espertano = new Espartano("Javier Elias",24,99,74);
        espartanos.add(espertano);
        espertano = new Espartano("Ariel Elias",52,86,66);
        espartanos.add(espertano);
        espertano = new Espartano("Leonardo Izurieta",48,69,79);
        espartanos.add(espertano);
        Humano jefeTaberna = new JefeTaberna("Soy el puto amo",44,110,111,120);
        vikingos.ordenarPorPeso();
        espartanos.ordenarPorPeso();
        vikingos.listarEquipo();
        espartanos.listarEquipo();
        vikingos.retirarPrimeroDelEquipo();
        espartanos.retirarPrimeroDelEquipo();

        vikingos.combatir(espartanos.getEquipo(),jefeTaberna);
        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tp1_lab", "root", "federico");
            String quey = "Select * from ganadores";
            Statement stm = conn.createStatement();
            ResultSet resul = stm.executeQuery(quey);
            while (resul.next()){
                System.out.println("Nombre: "+resul.getString("nombre_ganador"));
            }
        } catch (ClassNotFoundException e){
            System.out.println("No se agrego la libreria SQL correctamente");
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }*/

    }
}
