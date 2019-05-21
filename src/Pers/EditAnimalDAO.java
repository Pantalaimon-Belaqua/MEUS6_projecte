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
    

    public void EditAnimal(int idAnimal) throws SQLException{
        
    }
    
    public M_Animal getAnimal(int idAnimal) throws SQLException{
        
        M_Animal animal = new M_Animal();
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        query = "select a.*, c.DNI from Animal a left join animal_cuidador ac on a.id=ac.idAnimal left join Cuidador c on ac.DNICuidador=c.DNI limit 1;";
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
}
