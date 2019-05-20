/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Animal;
import static Pers.BaseDAO.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class PrincipalDAO extends BaseDAO {

    public PrincipalDAO() {
        connect();
    }
    
    /**
     * Devuelve un arraylist con todos los animales
     * @return
     * @throws SQLException 
     */
    
    public ArrayList getAnimales() throws SQLException{
        ArrayList<M_Animal> animales = new ArrayList<M_Animal>();
        
        ResultSet rs; // Guardará el resultado de la query
        String query = "select a.id, a.nombre, a.especie, c.DNI, c.nombre, c.direccion, c.telefono from Animal a left join animal_cuidador ac on ac.idAnimal=a.id left join Cuidador c on ac.DNICuidador=c.DNI;";
        PreparedStatement stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery(); // Conseguir los datos de todos los animales
        
        // Mientras haya animales
        while(rs.next()){
            
            M_Animal animal = new M_Animal();
            animal.setId(rs.getInt("id"));
            animal.setNombre(rs.getString("nombre"));
            animal.setEspecie(rs.getString("especie"));
            animal.setDNICuidador(rs.getString("DNI"));
            
            animales.add(animal);
        }
        rs.close();
        stmt.close();
        
        return animales;
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
    
    /**
     * Comprueba que un animal tenga visitas
     * @param id
     * @return 
     */
    
    public boolean hasVisits(int id) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        query = "select count(*) from (select v.* from Visita v inner join Animal a on a.id=v.idAnimal where v.idAnimal = ?) t;";
        
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        rs.next();
        
        if(rs.getInt(1) > 0){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Comprueva si el animal tiene cuidadores
     * @param id
     * @return 
     */
    
    public boolean hasKeepers(int id) throws SQLException{
        
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
