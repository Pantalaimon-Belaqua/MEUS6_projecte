/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pers;

import Modelo.M_Cuidador;
import Modelo.M_Visita;
import static Pers.BaseDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class VerCuidadorDAO extends BaseDAO {

    public VerCuidadorDAO() {
        connect();
    }
    
    public ArrayList<M_Cuidador> getCuidadores(int idAnimal) throws SQLException{
        ArrayList<M_Cuidador> cuidadores = new ArrayList<>();
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        
        query = "select c.* from Cuidador c inner join animal_cuidador ac on ac.DNICuidador=c.DNI where ac.idAnimal = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, idAnimal);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            M_Cuidador cuidador = new M_Cuidador();
            
            cuidador.setDNI(rs.getString("DNI"));
            cuidador.setNombre(rs.getString("nombre"));
            cuidador.setDireccion(rs.getString("direccion"));
            cuidador.setTelefono(rs.getString("telefono"));            
            
            cuidadores.add(cuidador);
        }
        
        stmt.close();
        return cuidadores;
    }
    
    public void deleteCuidador(String DNI) throws SQLException{
        
        String query;
        PreparedStatement stmt;
        
        query = "DELETE FROM animal_cuidador WHERE DNICuidador = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, DNI);
        stmt.executeUpdate();
        stmt.close();
    }
    
}
