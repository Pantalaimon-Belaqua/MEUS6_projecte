/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Cuidador;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class DelCuidadorDAO extends BaseDAO {

    public DelCuidadorDAO() {
        connect();
    }
    
    /**
     * Elimina a un cuidador por su objeto
     * @param cuidador
     * @throws SQLException 
     */
    
    public void deleteCuidador(M_Cuidador cuidador) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        // Eliminar las entradas de animal_cuidador
        query = "DELETE FROM animal_cuidador WHERE DNI = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, cuidador.getDNI());
        stmt.executeUpdate();
        stmt.close();
        
        query = "DELETE FROM Cuidador WHERE DNI = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, cuidador.getDNI());
        stmt.executeUpdate();
        stmt.close();
        
    }
    
    /**
     * Elimina a un cuidador por su DNI
     * @param DNI
     * @throws SQLException 
     */
    
    public void deleteCuidador(String DNI) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        // Eliminar las entradas de animal_cuidador
        query = "DELETE FROM animal_cuidador WHERE DNI = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, DNI);
        stmt.executeUpdate();
        stmt.close();
        
        query = "DELETE FROM Cuidador WHERE DNI = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, DNI);
        stmt.executeUpdate();
        stmt.close();
        
    }
    
    
}
