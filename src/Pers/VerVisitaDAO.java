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
public class VerVisitaDAO extends BaseDAO {

    public VerVisitaDAO() {
        connect();
    }
    
    /**
     * Devuelve las visitas 
     * @param id
     * @return 
     */
    
    public ArrayList<M_Visita> getVisitas(int id) throws SQLException {
        ArrayList<M_Visita> visitas = new ArrayList<>();
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        query = "select v.* from Visita v inner join Animal a on a.id=v.idAnimal where v.idAnimal = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            M_Visita visita = new M_Visita();
            
            visita.setId(rs.getInt("id"));
            visita.setPrecio(rs.getDouble("precio"));
            visita.setResultado(rs.getString("resultado"));
            visita.setTipoVisita(rs.getString("tipoVisita"));
            
            visitas.add(visita);
        }
        
        stmt.close();
        return visitas;
    }
    
}
