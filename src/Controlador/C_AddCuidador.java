/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Cuidador;
import Pers.AddCuidadorDAO;
import Vista.V_AddCuidador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class C_AddCuidador {

    public V_AddCuidador v_addCuidador;
    private AddCuidadorDAO cuidadorDAO = new AddCuidadorDAO();
    M_Cuidador m_cuidador;

    public C_AddCuidador(V_AddCuidador v_addCuidador) {
        this.v_addCuidador = v_addCuidador;

        //Al cargar la ventana
        this.v_addCuidador.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {

                v_addCuidador.bttn_addCuidador.setEnabled(false);

            }

        });

        //Al escribir el dni
        this.v_addCuidador.input_dni.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (!v_addCuidador.input_dni.getText().isEmpty() || v_addCuidador.input_nombreCuidador.getText().isEmpty()
                        || v_addCuidador.input_direccion.getText().isEmpty() || v_addCuidador.input_telefono.getText().isEmpty()) {
                    v_addCuidador.bttn_addCuidador.setEnabled(true);
                } else {
                    v_addCuidador.bttn_addCuidador.setEnabled(false);
                }
            }
        });

        //Al escribir el nombre
        this.v_addCuidador.input_nombreCuidador.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (!v_addCuidador.input_dni.getText().isEmpty() || v_addCuidador.input_nombreCuidador.getText().isEmpty()
                        || v_addCuidador.input_direccion.getText().isEmpty() || v_addCuidador.input_telefono.getText().isEmpty()) {
                    v_addCuidador.bttn_addCuidador.setEnabled(true);
                } else {
                    v_addCuidador.bttn_addCuidador.setEnabled(false);
                }
            }
        });

        //Al escribir la dirección
        this.v_addCuidador.input_direccion.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (!v_addCuidador.input_dni.getText().isEmpty() || v_addCuidador.input_nombreCuidador.getText().isEmpty()
                        || v_addCuidador.input_direccion.getText().isEmpty() || v_addCuidador.input_telefono.getText().isEmpty()) {
                    v_addCuidador.bttn_addCuidador.setEnabled(true);
                } else {
                    v_addCuidador.bttn_addCuidador.setEnabled(false);
                }
            }
        });

        //Al escribir el telefono
        this.v_addCuidador.input_telefono.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (!v_addCuidador.input_dni.getText().isEmpty() || v_addCuidador.input_nombreCuidador.getText().isEmpty()
                        || v_addCuidador.input_direccion.getText().isEmpty() || v_addCuidador.input_telefono.getText().isEmpty()) {
                    v_addCuidador.bttn_addCuidador.setEnabled(true);
                } else {
                    v_addCuidador.bttn_addCuidador.setEnabled(false);
                }
            }
        });

        // Al pulsar Añadir
        this.v_addCuidador.bttn_addCuidador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!check()) {
                    String dni, nombre, direccion, telefono;
                    M_Cuidador m_Cuidador = new M_Cuidador();

                    // Coger los datos que haya puesto el usuario.
                    dni = v_addCuidador.input_dni.getText();
                    nombre = v_addCuidador.input_nombreCuidador.getText();
                    direccion = v_addCuidador.input_direccion.getText();
                    telefono = v_addCuidador.input_telefono.getText();

                    // Añadir los datos al objeto al Cuidador
                    m_Cuidador.setDNI(dni);
                    m_Cuidador.setNombre(nombre);
                    m_Cuidador.setDireccion(direccion);
                    m_Cuidador.setTelefono(telefono);

                    // Añadir el cuidador a la BBDD.
                    try {
                        cuidadorDAO.addCuidador(m_cuidador);
                        JOptionPane.showMessageDialog(v_addCuidador, "El cuidador ha sido añadido correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                        v_addCuidador.dispatchEvent(new WindowEvent(v_addCuidador, WindowEvent.WINDOW_CLOSING));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(v_addCuidador, "Ha habido un error al añadir el cuidador", "", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(C_AddCuidador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        // Poner la ventana al medio
        v_addCuidador.setLocationRelativeTo(null);
    }

    public boolean check() {
        boolean error = false;

        if (v_addCuidador.input_dni.getText().length() > 9 || v_addCuidador.input_dni.getText().isEmpty()) {
            v_addCuidador.input_dni.setBackground(Color.red);
            error = true;
        }else{
            v_addCuidador.input_dni.setBackground(Color.white);
        }

        if (v_addCuidador.input_nombreCuidador.getText().isEmpty()) {
            v_addCuidador.input_nombreCuidador.setBackground(Color.red);
            error = true;
        }else{
            v_addCuidador.input_nombreCuidador.setBackground(Color.white);
        }
        
        if (v_addCuidador.input_direccion.getText().isEmpty()) {
            v_addCuidador.input_direccion.setBackground(Color.red);
            error = true;
        }else{
            v_addCuidador.input_direccion.setBackground(Color.white);
        }
        
        if (v_addCuidador.input_telefono.getText().isEmpty()) {
            v_addCuidador.input_telefono.setBackground(Color.red);
            error = true;
        }else{
            v_addCuidador.input_telefono.setBackground(Color.white);
        }
                
        return error;
    }
}
