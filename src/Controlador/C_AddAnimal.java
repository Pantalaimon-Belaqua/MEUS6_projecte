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
import javax.swing.JOptionPane;

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
                } else {
                    v_addAnimal.bttn_addAnimal.setEnabled(false);
                }
            }

            
            
        });
        
        // Al escribir en especie
        v_addAnimal.input_especie.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(!(v_addAnimal.input_nombreAnimal.getText().isEmpty() || v_addAnimal.input_especie.getText().isEmpty())){
                    v_addAnimal.bttn_addAnimal.setEnabled(true);
                } else {
                    v_addAnimal.bttn_addAnimal.setEnabled(false);
                }
            }

            
            
        });

        // Al pulsar añadir
        this.v_addAnimal.bttn_addAnimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!check()) {
                    String nombre, especie, DNI;
                    M_Animal m_animal = new M_Animal();

                    // Coger lo que haya puesto el usuario
                    nombre = v_addAnimal.input_nombreAnimal.getText();
                    especie = v_addAnimal.input_especie.getText();
                    DNI = (String) v_addAnimal.select_cuidador.getSelectedItem();

                    // Si el cuidador es Ninguno, lo intertarás en la BBDD como Null
                    if(DNI.equals("Ninguno")){
                        DNI = null;
                    } else {
                        // Si no, separa el nombre del DNI
                        DNI = DNI.replaceAll(" ", "").split("-")[1];
                    }
                    
                    // Añade los datos al objeto del animal
                    m_animal.setDNICuidador(DNI);
                    m_animal.setNombre(nombre);
                    m_animal.setEspecie(especie);
                    
                    // Y añade el animal a la BBDD
                    try {
                        animalDAO.addAnimal(m_animal);
                        JOptionPane.showMessageDialog(v_addAnimal, "El animal ha sido añadido correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                        v_addAnimal.dispatchEvent(new WindowEvent(v_addAnimal, WindowEvent.WINDOW_CLOSING));
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(v_addAnimal, "Ha habido un error al añadir el animal", "", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(C_AddAnimal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            }
        });
        
        // Al recibir "cerrar ventana", dispatch
        v_addAnimal.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                v_addAnimal.dispose();
            }

            
            
        });
        
        // Poner la ventana al medio
        v_addAnimal.setLocationRelativeTo(null);
        
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
