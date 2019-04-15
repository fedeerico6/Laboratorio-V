package App;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*PRIMERA VERSION */
       /* try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/equipos", "root","");
            Statement stm = con.createStatement();
            String sql = "Select * from equipo;";
            ResultSet result = stm.executeQuery(sql);
            Equipo equipo = new Equipo();
            List<Equipo> equipos = new ArrayList<Equipo>();
            while(result.next())
            {
                Integer id = result.getInt("id");
                String nombre_equipo = result.getString("nombre_equipo");
                equipo.setNombre(nombre_equipo);
                equipo.setId_equipo(id);
                equipos.add(equipo);
                System.out.println(equipo.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Falta agregar la Libreria");
        }*/


       /* USANDO LA CLASE CONECTARMYSQL */
        try {
            Connection conn = ConectarMysql.conectar();
            Statement stm = conn.createStatement();
            String sql = "Select * from equipo;";
            ResultSet result = stm.executeQuery(sql);
            Equipo equipo = new Equipo();
            List<Equipo> equipos = new ArrayList<Equipo>();
            while(result.next())
            {
                Integer id = result.getInt("id");
                String nombre_equipo = result.getString("nombre_equipo");
                equipo.setNombre(nombre_equipo);
                equipo.setId_equipo(id);
                equipos.add(equipo);
                System.out.println(equipo.toString());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}
