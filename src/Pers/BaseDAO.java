/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

/**
 *
 * @author David
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class BaseDAO {

    static String url = "jdbc:mysql://192.168.55.120:3306/";
    static String db = "Productos_UF6EX2";
    static String user = "master";
    static String pass = "daw1234";

    protected static Connection conn = null;
    //  private static DataSource ds;

    

    
    
    public static void connect() {       
        
        try {
            conn = DriverManager.getConnection(url + db, user, pass);
            System.out.println("Conexión realizada");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public static Connection getConn() {
        return conn;
    }

    public static void close() throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("Conexión cerrada");
        }
        conn = null;
    }

}
