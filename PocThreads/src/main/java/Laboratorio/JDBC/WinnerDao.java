package Laboratorio.JDBC;

import Laboratorio.Clases.Winner;

import java.sql.*;

public class WinnerDao {

    public static void create(Winner winner){
        Connection conn = Connect.connect();
        try{
            String query = "INSERT INTO winners(name,word,fecha) VALUES (?,?,?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1,winner.getName());
            stm.setString(2,winner.getWord());
            stm.setDate(1, (Date) winner.getFecha());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void read(){
        Connection conn = Connect.connect();
        try{
            String query = "SELECT * FROM winner";
            Statement st = conn.createStatement();
            ResultSet rlt = st.executeQuery(query);
            while(rlt.next()){
                System.out.println("Nombre: "+rlt.getString("name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
