package Laboratorio5.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    public static Connection conectar(){
         Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tp1_lab","root", "federico");
        } catch (ClassNotFoundException e){
            System.out.println("No se agrego la libreria SQL correctamente");
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }


}
