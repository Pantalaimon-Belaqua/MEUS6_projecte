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
    
    
    
}
