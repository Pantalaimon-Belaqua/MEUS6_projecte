/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.C_Principal;
import Modelo.M_Animal;
import Modelo.M_Cuidador;
import Pers.BDUtil;
import Pers.AddAnimalDAO;
import Pers.AddCuidadorDAO;
import Pers.PrincipalDAO;
import Vista.V_Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.GenerateAnimals;
import utils.GeneratePeople;

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ///////////////////////////////////
        // EJECUTAR SI ES LA PRIMERA VEZ //
        ///////////////////////////////////
        
//        try {
//            BDUtil.createEstructuraMysql();
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        BDUtil.insertarDatos();      
        
        V_Principal v_principal = new V_Principal();
        C_Principal c_principal = new C_Principal(v_principal);
        v_principal.setVisible(true);
        
        
    }
    
}
