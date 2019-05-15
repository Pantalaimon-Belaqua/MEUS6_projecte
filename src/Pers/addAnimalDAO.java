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
public class addAnimalDAO extends BaseDAO {

    public addAnimalDAO() {
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
        
        stmt.close();
        
        /***
         * TODO
         * SI DNI NOT EMPTY
         *   crear una query para añadir el DNI y el idAnimal a la tabla animal_cuidador
         *   ejecutar query
         *   cerrar conexión
         * 
         * No comprovamos que el DNI exista porque el usuario sólo puede escojer DNIs existentes del selectbox
         */
    }
    
}
