/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Pers.BaseDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class BDUtil {

    public static void createEstructuraMysql() throws SQLException {

        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();

        PreparedStatement stmt;
        
        String query = "CREATE TABLE Categoria "
                + "(code INT NOT NULL AUTO_INCREMENT,"
                + " categoria varchar(30) NOT NULL,"
                + " PRIMARY KEY (code)"
                + "  )";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        
        query = "CREATE TABLE Producto "
                + "(code INT NOT NULL, "
                + " descripcion text,"
                + " categoria INT,"
                + " precio DECIMAL(18,2),"
                + " ubicacion varchar(3),"
                + " tipo varchar(25),"
                + " oferta DECIMAL(3,2),"
                + " PRIMARY KEY (code),"
                + " FOREIGN KEY (categoria) references Categoria (code)"
                + ")";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
    }
    
    public static void insertarDatos(){
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();
        
        
        
        try {
            String query = "INSERT INTO Categoria(categoria) VALUES (\"Juguete\")";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Categoria(categoria) VALUES (\"Electrónica\")";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Categoria(categoria) VALUES (\"Cocina\")";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Categoria(categoria) VALUES (\"Ropa\")";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Producto VALUES (1, \"Un juguete\", 1, 3.4, \"LEL\", \"Tipo1\", 0.20)";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Producto VALUES (2, \"Un ordenador\", 2, 50.6, \"LEL\", \"Tipo2\", 0.30)";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Producto VALUES (3, \"Un batidor\", 3, 5.6, \"LEL\", \"Tipo3\", 0.05)";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            query = "INSERT INTO Producto VALUES (4, \"Un pantalón\", 4, 20.1, \"LEL\", \"Tipo4\", 0.15)";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void netejaTaules() {
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();
        PreparedStatement stmt;
        try {
            String query = "drop table Producto";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            stmt = conn.prepareStatement("drop table Categoria");
            stmt.executeUpdate();
            stmt.close();
            
            createEstructuraMysql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
