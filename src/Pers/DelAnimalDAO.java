/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class DelAnimalDAO extends BaseDAO {

    public DelAnimalDAO() {
        connect();
    }
    
    /**
     * Elimina un animal por su objeto
     * @param animal 
     */
    
    public void deleteAnimal(M_Animal animal) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        // Eliminar primero las entradas en animal_cuidador
        query = "delete from animal_cuidador where idAnimal = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, animal.getId());
        stmt.executeUpdate();
        stmt.close();
        
        query = "DELETE FROM Animal WHERE id=?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, animal.getId());
        stmt.executeUpdate();
        stmt.close();
        
    }
    
    /**
     * Elimina un animal por su ID
     * @param animal
     * @throws SQLException 
     */
    
    public void deleteAnimal(int id) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        // Eliminar primero las entradas en animal_cuidador
        query = "delete from animal_cuidador where idAnimal = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        
        query = "DELETE FROM Animal WHERE id=?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        
    }
    
}
