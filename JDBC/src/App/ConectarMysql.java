package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarMysql {

    public String driver = "com.mysql.jdbc.Driver";
    public String database = "equipo";
    public String host = "localhost";
    public String url = "jdbc:mysql://"+host+"/"+database;

    public ConectarMysql(){}

    public static Connection conectar(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/equipos","root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("No se agrego la libreria correctamente");
        } catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }
}
