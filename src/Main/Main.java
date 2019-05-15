/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.M_Animal;
import Modelo.M_Cuidador;
import Pers.BDUtil;
import Pers.AddAnimalDAO;
import Pers.AddCuidadorDAO;
import java.sql.SQLException;
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
        
        AddAnimalDAO addAnimalDAO = new AddAnimalDAO();
        AddCuidadorDAO addCuidadorDAO = new AddCuidadorDAO();
        
        // Crear animales
        M_Animal a1 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a2 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a3 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a4 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a5 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        M_Animal a6 = new M_Animal(GenerateAnimals.generateName(), GenerateAnimals.generateSpecies(), "");
        
        // Crear cuidadores
        M_Cuidador c1 = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
        M_Cuidador c2 = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
        M_Cuidador c3 = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
        M_Cuidador c4 = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
        M_Cuidador c5 = new M_Cuidador(GeneratePeople.generateDNI(), GeneratePeople.generateName(), GeneratePeople.generateAddress(), String.valueOf(GeneratePeople.generatePhoneNumber()));
        
        
        try {
            // Añadir animales
            addAnimalDAO.addAnimal(a1);
            addAnimalDAO.addAnimal(a2);
            addAnimalDAO.addAnimal(a3);
            addAnimalDAO.addAnimal(a4);
            addAnimalDAO.addAnimal(a5);
            addAnimalDAO.addAnimal(a6);
            
            // Añadir cuidadores
            addCuidadorDAO.addCuidador(c1);
            addCuidadorDAO.addCuidador(c2);
            addCuidadorDAO.addCuidador(c3);
            addCuidadorDAO.addCuidador(c4);
            addCuidadorDAO.addCuidador(c5);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
