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

/**
 *
 * @author noelia
 */
public class EditAnimalDAO  extends BaseDAO {

    public EditAnimalDAO() {
        connect();
    }
    

    public void editAnimal(M_Animal animal, int idAnimal) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        // Actualizar la tabla Animal
        query = "UPDATE Animal SET nombre=?, especie=? WHERE id=?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, animal.getNombre());
        stmt.setString(2, animal.getEspecie());
        stmt.setInt(3, idAnimal);
        stmt.executeUpdate();
        
        // Si hay DNI, actualizar la tabla animal_cuidador
        if(animal.getDNICuidador() != null && !animal.getDNICuidador().isEmpty()){
            
            // Si ya tiene cuidadores, actualiza
            if(hasKeepers(idAnimal)){
                query = "UPDATE animal_cuidador SET DNICuidador=? WHERE idAnimal=?";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, animal.getDNICuidador());
                stmt.setInt(2, idAnimal);
                stmt.executeUpdate();
            } else {
            // Si no, añade
                query = "INSERT INTO animal_cuidador VALUES(?,?)";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, idAnimal);
                stmt.setString(2, animal.getDNICuidador());
                stmt.executeUpdate();
            }
            
            
        }
        
        stmt.close();
    }
    
    public M_Animal getAnimal(int idAnimal) throws SQLException{
        
        M_Animal animal = new M_Animal();
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        query = "select a.*, c.DNI from Animal a left join animal_cuidador ac on a.id=ac.idAnimal left join Cuidador c on ac.DNICuidador=c.DNI where a.id = ? limit 1;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, idAnimal);
        
        rs = stmt.executeQuery();
        rs.next();
        
        animal.setId(idAnimal);
        animal.setNombre(rs.getString("nombre"));
        animal.setEspecie(rs.getString("especie"));
        animal.setDNICuidador(rs.getString("DNI"));
        
        return animal;
    }
    
    /**
     * Comprueva si el animal tiene cuidadores
     * @param id
     * @return 
     */
        
    private boolean hasKeepers(int id) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        query = "select count(*) from (select c.* from Cuidador c inner join animal_cuidador ac on ac.DNICuidador=c.DNI where ac.idAnimal = ?) t;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        rs.next();
        
        if (rs.getInt(1) > 0) {
            return true;
        } else {
            return false;
        }
        
        
    }
}
