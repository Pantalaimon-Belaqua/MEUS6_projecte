/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Animal;
import Pers.AddAnimalDAO;
import Vista.V_AddAnimal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class C_AddAnimal {

    public V_AddAnimal v_addAnimal;
    private AddAnimalDAO animalDAO = new AddAnimalDAO();
    M_Animal m_animal;
    
    

    public C_AddAnimal(V_AddAnimal v_addAnimal) {
        this.v_addAnimal = v_addAnimal;
        
        // Al cargar la ventana
        this.v_addAnimal.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                
                v_addAnimal.bttn_addAnimal.setEnabled(false);
                
                try {
                    ArrayList<String> cuidadores = animalDAO.getCuidadores();
                    
                    for (String cuidador : cuidadores) {
                        v_addAnimal.select_cuidador.addItem(cuidador);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(C_AddAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
            

        });
        
        // Al escribir en nombre
        v_addAnimal.input_nombreAnimal.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(!(v_addAnimal.input_nombreAnimal.getText().isEmpty() || v_addAnimal.input_especie.getText().isEmpty())){
                    v_addAnimal.bttn_addAnimal.setEnabled(true);
                }
            }

            
            
        });
        
        // Al escribir en especie
        v_addAnimal.input_especie.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(!(v_addAnimal.input_nombreAnimal.getText().isEmpty() || v_addAnimal.input_especie.getText().isEmpty())){
                    v_addAnimal.bttn_addAnimal.setEnabled(true);
                }
            }

            
            
        });

        // Al pulsar añadir
        this.v_addAnimal.bttn_addAnimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    String nombre, especie;

                    nombre = v_addAnimal.input_nombreAnimal.getText();
                    especie = v_addAnimal.input_especie.getText();

                    //m_animal = new M_Animal();
                    //animalDAO.addAnimal(m_animal);
                }
            }
        });
        
        
    }

    public boolean check() {
        boolean error = false;

        if (v_addAnimal.input_nombreAnimal.getText().isEmpty()) {
            v_addAnimal.input_nombreAnimal.setBackground(Color.red);
            error = true;
        } else {
            v_addAnimal.input_nombreAnimal.setBackground(Color.WHITE);
        }

        if (v_addAnimal.input_especie.getText().isEmpty()) {
            v_addAnimal.input_especie.setBackground(Color.red);
            error = true;
        } else {
            v_addAnimal.input_especie.setBackground(Color.WHITE);
        }

        return error;
    }

}
