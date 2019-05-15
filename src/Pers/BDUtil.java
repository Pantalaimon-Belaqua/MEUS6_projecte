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
        String query;
        
        query = "CREATE TABLE Animal "
                + "(id INT NOT NULL AUTO_INCREMENT,"
                + " nombre varchar(30) NOT NULL,"
                + " especie varchar(30) NOT NULL,"
                + " PRIMARY KEY (id)"
                + "  )";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        
        query = "CREATE TABLE Visita "
                + "(id INT NOT NULL AUTO_INCREMENT,"
                + " idAnimal INT NOT NULL,"
                + " tipoVisita varchar(30) NOT NULL,"
                + " resultado varchar(30) NOT NULL,"
                + " precio decimal(8,2),"
                + " PRIMARY KEY (id),"
                + "FOREIGN KEY (idAnimal) references Animal (id)"
                + "  )";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        
        query = "CREATE TABLE Cuidador "
                + "(DNI varchar(9) NOT NULL,"
                + " nombre varchar(30) NOT NULL,"
                + " direccion varchar(90) NOT NULL,"
                + " telefono varchar(20) NOT NULL,"
                + " PRIMARY KEY (DNI)"
                + ")";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        
        query = "CREATE TABLE animal_cuidador "
                + "(idAnimal INT NOT NULL,"
                + " DNICuidador varchar(9) NOT NULL,"
                + " PRIMARY KEY (idAnimal, DNICuidador),"
                + " FOREIGN KEY (idAnimal) references Animal (id),"
                + " FOREIGN KEY (DNICuidador) references Cuidador (DNI)"
                + ")";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        
        System.out.println("Estructura creada");
        
        BaseDAO.close();
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
