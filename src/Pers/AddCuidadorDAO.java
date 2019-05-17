/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Cuidador;
import static Pers.BaseDAO.conn;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class AddCuidadorDAO extends BaseDAO {

    public AddCuidadorDAO() {
        connect();
    }
    
    public void addCuidador(M_Cuidador cuidador) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        query = "INSERT INTO Cuidador VALUES (?,?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, cuidador.getDNI());
        stmt.setString(2, cuidador.getNombre());
        stmt.setString(3, cuidador.getDireccion());
        stmt.setString(4, cuidador.getTelefono());
        stmt.executeUpdate();
        
        stmt.close();
        
        System.out.println("   " + cuidador.getNombre() + " añadido");
        
    }
    
}
