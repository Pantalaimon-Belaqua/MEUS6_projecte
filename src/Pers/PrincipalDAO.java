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
    
    public ArrayList getAnimales() throws SQLException{
        ArrayList<M_Animal> animales = new ArrayList<M_Animal>();
        
        ResultSet rs; // Guardará el resultado de la query
        String query = "select p.code, p.descripcion, c.categoria, p.precio, p.ubicacion, p.tipo, p.oferta from Producto p\n" +
"	inner join Categoria c on c.code=p.categoria";
        PreparedStatement stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery(); // Conseguir los datos de todos los productos
        
        // Mientras haya animales
        while(rs.next()){
            
            /***
             * Coger las cosas del RS y añadirlas al modelo de Animal
             */
            
        }
        rs.close();
        stmt.close();
        
        return animales;
    }
    
    
    
}
