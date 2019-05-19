/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Main.Main;
import Modelo.M_Animal;
import Modelo.M_Cuidador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Pers.BaseDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.GenerateAnimals;
import utils.GeneratePeople;

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
            
        AddAnimalDAO addAnimalDAO = new AddAnimalDAO();
        AddCuidadorDAO addCuidadorDAO = new AddCuidadorDAO();
        
        try {
            
            // Crear y añadir cuidadores
            // Hay que añadirlos antes que los animales de otro modo no se podrá crear la relación
            // ya que el DNI no existirá.
            for (int i = 0; i < 30; i++) {
                M_Cuidador c = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
                addCuidadorDAO.addCuidador(c);
            }
            
            // Crear y añadir animales
            for (int i = 0; i < 30; i++) {
                M_Animal a = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
                addAnimalDAO.addAnimal(a);
            }
            
            // Crear y añadir animales que tienen cuidadores
            for (int i = 0; i < 10; i++) {
                M_Cuidador c = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
                addCuidadorDAO.addCuidador(c);
                M_Animal a = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), c.getDNI());
                addAnimalDAO.addAnimal(a);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        };
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
