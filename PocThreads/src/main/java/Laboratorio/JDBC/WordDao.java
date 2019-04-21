package Laboratorio.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WordDao {

    public static String readWord(){
        Connection conn = Connect.connect();
        String word = null;
        try {
            String query = "SELECT * FROM words ORDER BY rand() limit 1";
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                word = result.getString("word");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return word;
    }

}
