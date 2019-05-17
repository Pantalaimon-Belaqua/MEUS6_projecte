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

        //Al escribir en dni
        this.v_addCuidador.input_dni.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (allInputsFull()) {
                    v_addCuidador.bttn_addCuidador.setEnabled(true);
                } else {
                    v_addCuidador.bttn_addCuidador.setEnabled(false);
                }
            }
        });

        //Al escribir en nombre
        this.v_addCuidador.input_nombreCuidador.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (allInputsFull()) {
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

                if (allInputsFull()) {
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

                if (allInputsFull()) {
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
                    M_Cuidador m_cuidador = new M_Cuidador();

                    // Coger los datos que haya puesto el usuario.
                    dni = v_addCuidador.input_dni.getText().trim().toUpperCase();
                    nombre = v_addCuidador.input_nombreCuidador.getText().trim();
                    direccion = v_addCuidador.input_direccion.getText().trim();
                    telefono = v_addCuidador.input_telefono.getText().trim();

                    // Añadir los datos al objeto al Cuidador
                    m_cuidador.setDNI(dni);
                    m_cuidador.setNombre(nombre);
                    m_cuidador.setDireccion(direccion);
                    m_cuidador.setTelefono(telefono);

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

    private boolean check() {
        boolean error = false;

        // DNI
        if (v_addCuidador.input_dni.getText().length() > 9 || v_addCuidador.input_dni.getText().isEmpty()) {
            
            v_addCuidador.input_dni.setBackground(Color.red);
            error = true;
        }else{
            if(isDNIRight(v_addCuidador.input_dni.getText())){
                v_addCuidador.input_dni.setBackground(Color.white);
            } else {
                v_addCuidador.input_dni.setBackground(Color.red);
                error = true;
            }
            
        }

        //NOMBRE
        if (v_addCuidador.input_nombreCuidador.getText().isEmpty()) {
            v_addCuidador.input_nombreCuidador.setBackground(Color.red);
            error = true;
        }else{
            v_addCuidador.input_nombreCuidador.setBackground(Color.white);
        }
        
        // DIRECCIÓN
        if (v_addCuidador.input_direccion.getText().isEmpty()) {
            v_addCuidador.input_direccion.setBackground(Color.red);
            error = true;
        }else{
            v_addCuidador.input_direccion.setBackground(Color.white);
        }
        
        // TELÉFONO
        if (v_addCuidador.input_telefono.getText().isEmpty()) {
            v_addCuidador.input_telefono.setBackground(Color.red);
            error = true;
        }else{
            
            try {
                String tel = v_addCuidador.input_telefono.getText().trim();
                int _ = Integer.parseInt(tel);
            } catch (NumberFormatException e) {
                error = true;
                v_addCuidador.input_telefono.setBackground(Color.red);
            }
            
            
        }
                
        return error;
    }
    
    private boolean allInputsFull(){
        if(!v_addCuidador.input_dni.getText().isEmpty() || v_addCuidador.input_nombreCuidador.getText().isEmpty()
                        || v_addCuidador.input_direccion.getText().isEmpty() || v_addCuidador.input_telefono.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isDNIRight(String DNI){
        String[] letters = "T,R,W,A,G,M,Y,F,P,D,X,B,N,J,Z,S,Q,V,H,L,C,K,E".split(",");
        
        
        // Si la letra del DNI es la que debería ser
        if(letters[Integer.parseInt(DNI.substring(0, DNI.length()-1))%23].equals(DNI.substring(DNI.length()-1).toUpperCase())){
            return true;
        } else {
            return false;
        }
    }
}
