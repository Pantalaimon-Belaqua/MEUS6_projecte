/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class AddAnimalDAO extends BaseDAO {

    public AddAnimalDAO() {
        connect();
    }
    
    /**
     * Añade un animal a la base de datos
     * @param animal 
     */
    
    public void addAnimal(M_Animal animal) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        query = "INSERT INTO Animal(nombre, especie) VALUES (?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, animal.getNombre());
        stmt.setString(2, animal.getEspecie());
        stmt.executeUpdate();

        // Si el animal tiene un cuidador, añade la relación en la tabla animal_cuidador
        if(animal.getDNICuidador() != null && !animal.getDNICuidador().isEmpty()){
            query = "INSERT INTO animal_cuidador VALUES (?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, getAnimalId(animal));
            stmt.setString(2, animal.getDNICuidador());
            
            stmt.executeUpdate();
            
        }
        
        stmt.close();
        System.out.println("   " + animal.getEspecie() + " añadido");
    }
    
    /**
     * Devuelve el ID del animal que se le pase.
     * Devolverá siempre el primero que encuentre en caso de que haya más de uno 
     * con el mismo nombre y especie.
     * @param animal
     * @return 
     */
    
    public int getAnimalId(M_Animal animal){
        String query;
        ResultSet rs;
        PreparedStatement stmt;
        int id = 0;
        
        query = "SELECT id FROM Animal WHERE nombre = ? and especie = ? limit 1;";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, animal.getNombre());
            stmt.setString(2, animal.getEspecie());
            rs = stmt.executeQuery();
            rs.next();
            
            id = rs.getInt(1);
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddAnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    /**
     * Devuelve una lista con los nombres de los cuidadores
     * @return 
     */
    
    public ArrayList<String> getCuidadores() throws SQLException{
        
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<String> cuidadores = new ArrayList<>();
        
        query = "SELECT DNI, nombre FROM Cuidador";
        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            String cuidador;
            cuidador =  rs.getString("nombre") + " - " + rs.getString("DNI");
            cuidadores.add(cuidador);
        }
        
        stmt.close();
        
        return cuidadores;
        
    }
    
}
