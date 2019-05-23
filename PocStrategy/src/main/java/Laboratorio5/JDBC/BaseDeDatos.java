package Laboratorio5.JDBC;

import java.sql.*;

public class BaseDeDatos {

    public static void insertar(String nombre, int bebida){

        Connection conn = Conectar.conectar();
        String sql = "Insert into ganadores(nombre_ganador,bebida_en_cuerpo) values (?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,nombre);
            stm.setInt(2,bebida);

            stm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void leer(){
        Connection conn = Conectar.conectar();
        String sql = "Select * from ganadores";
        try{
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()){
                System.out.println("Nombre: "+result.getString("nombre_ganador"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
