/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Main.Main;
import Modelo.M_Animal;
import Modelo.M_Cuidador;
import Modelo.M_Visita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Pers.BaseDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.GenerateAnimals;
import utils.GeneratePeople;
import utils.GenerateVisit;

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
        AddVisitaDAO addVisitaDAO = new AddVisitaDAO();
        
        try {
            
            // Crear y añadir cuidadores
            // Hay que añadirlos antes que los animales de otro modo no se podrá crear la relación
            // ya que el DNI no existirá.
            for (int i = 0; i < 30; i++) {
                M_Cuidador c = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
                addCuidadorDAO.addCuidador(c);
                System.out.println("\tAñadido cuidador: " + c.getNombre());
            }
            
            // Crear y añadir animales
            for (int i = 0; i < 10; i++) {
                M_Animal a = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
                addAnimalDAO.addAnimal(a);
                System.out.println("\tAñadido " + a.getEspecie() + ": " + a.getNombre());
            }
            
            // Crear y añadir animales que tienen cuidadores
            for (int i = 0; i < 10; i++) {
                M_Cuidador c = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
                addCuidadorDAO.addCuidador(c);
                M_Animal a = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), c.getDNI());
                addAnimalDAO.addAnimal(a);
                System.out.println("\tAñadido " + a.getEspecie() + ": " + a.getNombre() + " con cuidador: " + c.getNombre());
            }
            
            // Crear y añadir animales que tienen visitas
            for (int i = 0; i < 10; i++) {
                M_Animal a = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
                addAnimalDAO.addAnimal(a);
                M_Visita v = new M_Visita(a.getId(), GenerateVisit.generateType(), GenerateVisit.generateResult(), GenerateVisit.generatePrice());
                addVisitaDAO.addVisita(v, addAnimalDAO.getAnimalId(a));
                System.out.println("\tAñadida visita " + v.getTipoVisita() + " para " + a.getEspecie() + " " + a.getNombre());
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
            String query = "drop table Visita";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            stmt = conn.prepareStatement("drop table animal_cuidador");
            stmt.executeUpdate();
            stmt = conn.prepareStatement("drop table Animal");
            stmt.executeUpdate();
            stmt = conn.prepareStatement("drop table Cuidador");
            stmt.executeUpdate();
            stmt.close();
            
            System.out.println("Datos eliminados, creado estructura...");
            createEstructuraMysql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
