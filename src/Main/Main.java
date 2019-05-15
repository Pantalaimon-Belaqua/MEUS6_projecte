/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.M_Animal;
import Pers.BDUtil;
import Pers.AddAnimalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.GenerateAnimals;

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
        
        AddAnimalDAO addAnimalDAO = new AddAnimalDAO();
        
        M_Animal a1 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a2 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a3 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a4 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a5 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        
        try {
            addAnimalDAO.addAnimal(a1);
            addAnimalDAO.addAnimal(a2);
            addAnimalDAO.addAnimal(a3);
            addAnimalDAO.addAnimal(a4);
            addAnimalDAO.addAnimal(a5);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
