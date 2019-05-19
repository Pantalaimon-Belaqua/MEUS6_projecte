/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Visita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class AddVisitaDAO extends BaseDAO {

    public AddVisitaDAO() {
        connect();
    }
    
    public void addVisita(M_Visita visita, int idAnimal) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        query = "INSERT INTO Visita VALUES (?,?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, idAnimal);
        stmt.setString(2, visita.getTipoVisita());
        stmt.setString(3, visita.getResultado());
        stmt.setDouble(4, visita.getPrecio());
        stmt.executeUpdate();
        
        stmt.close();
        System.out.println("Visita añadida");
        
    }
    
    public ArrayList<M_Visita> getVisitas(){
        ArrayList<M_Visita> visitas = new ArrayList<>();
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        
        
        
        return visitas;
    }
    
}
