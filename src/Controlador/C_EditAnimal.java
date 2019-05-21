/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Animal;
import Pers.AddAnimalDAO;
import Pers.EditAnimalDAO;
import Vista.V_EditAnimal;
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
public class C_EditAnimal {

    public V_EditAnimal v_editAnimal;
    private EditAnimalDAO editAnimalDAO = new EditAnimalDAO();
    private AddAnimalDAO animalDAO = new AddAnimalDAO();
    private int idAnimal;
    M_Animal m_animal;
    
    

    public C_EditAnimal(V_EditAnimal v_editAnimal, int idAnimal) {
        this.v_editAnimal = v_editAnimal;
        this.idAnimal = idAnimal;
        
        // Al cargar la ventana
        this.v_editAnimal.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                
                v_editAnimal.bttn_modificar.setEnabled(false);
                
                try {
                    
                    ArrayList<String> cuidadores = animalDAO.getCuidadores();
                    
                    for (String cuidador : cuidadores) {
                        v_editAnimal.select_cuidador.addItem(cuidador);
                    }
                    
                    // Rellenar campos
                    setCampos();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(C_EditAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
            

        });
        
        // Al escribir en nombre
        v_editAnimal.input_nombreAnimal.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(!(v_editAnimal.input_nombreAnimal.getText().isEmpty() || v_editAnimal.input_especie.getText().isEmpty())){
                    v_editAnimal.bttn_modificar.setEnabled(true);
                } else {
                    v_editAnimal.bttn_modificar.setEnabled(false);
                }
            }

            
            
        });
        
        // Al escribir en especie
        v_editAnimal.input_especie.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if(!(v_editAnimal.input_nombreAnimal.getText().isEmpty() || v_editAnimal.input_especie.getText().isEmpty())){
                    v_editAnimal.bttn_modificar.setEnabled(true);
                } else {
                    v_editAnimal.bttn_modificar.setEnabled(false);
                }
            }

            
            
        });

        // Al pulsar añadir
        this.v_editAnimal.bttn_modificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!check()) {
                    String nombre, especie, DNI;
                    M_Animal m_animal = new M_Animal();

                    // Coger lo que haya puesto el usuario
                    nombre = v_editAnimal.input_nombreAnimal.getText().trim();
                    especie = v_editAnimal.input_especie.getText().trim();
                    DNI = (String) v_editAnimal.select_cuidador.getSelectedItem();

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
                        editAnimalDAO.addAnimal(m_animal);
                        JOptionPane.showMessageDialog(v_editAnimal, "El animal ha sido editado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                        v_editAnimal.dispatchEvent(new WindowEvent(v_editAnimal, WindowEvent.WINDOW_CLOSING));
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(v_editAnimal, "Ha habido un error al añadir el animal", "", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(C_EditAnimal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            }
        });
                
        // Poner la ventana al medio
        v_editAnimal.setLocationRelativeTo(null);
        
    }

    private boolean check() {
        boolean error = false;

        if (v_editAnimal.input_nombreAnimal.getText().isEmpty()) {
            v_editAnimal.input_nombreAnimal.setBackground(Color.red);
            error = true;
        } else {
            v_editAnimal.input_nombreAnimal.setBackground(Color.WHITE);
        }

        if (v_editAnimal.input_especie.getText().isEmpty()) {
            v_editAnimal.input_especie.setBackground(Color.red);
            error = true;
        } else {
            v_editAnimal.input_especie.setBackground(Color.WHITE);
        }

        return error;
    }
    
    private void setCampos() throws SQLException{
        
        M_Animal animal = editAnimalDAO.getAnimal(idAnimal);
        
        v_editAnimal.input_especie.setText(animal.getEspecie());
        v_editAnimal.input_nombreAnimal.setText(animal.getNombre());
        
        // Seleccionar el DNI correcto
        if(animal.getDNICuidador() == null){
            v_editAnimal.select_cuidador.setSelectedIndex(0);
        }
    }

}
