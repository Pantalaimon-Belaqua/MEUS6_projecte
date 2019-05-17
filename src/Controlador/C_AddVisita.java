/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Visita;
import Vista.V_AddVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author noelia
 */
public class C_AddVisita {

    public V_AddVisita v_addVisita;
    // private AddVisitaDAO visitaDAO = new AddVisitaDAO();
    M_Visita m_visita;

    public C_AddVisita(V_AddVisita v_addVisita) {
        this.v_addVisita = v_addVisita;

        // Al cargar la ventana
        this.v_addVisita.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                v_addVisita.bttn_addVisita.setEnabled(false);
            }

        });

        // Al escribir en el tipo
        this.v_addVisita.input_tipo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (allInputsFull()) {
                    v_addVisita.bttn_addVisita.setEnabled(true);
                } else {
                    v_addVisita.bttn_addVisita.setEnabled(false);
                }
            }
        });

        // Al escribir en el resultado
        this.v_addVisita.input_resultado.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (allInputsFull()) {
                    v_addVisita.bttn_addVisita.setEnabled(true);
                } else {
                    v_addVisita.bttn_addVisita.setEnabled(false);
                }
            }
        });

        // Al escribir en el precio
        this.v_addVisita.input_precio.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (allInputsFull()) {
                    v_addVisita.bttn_addVisita.setEnabled(true);
                } else {
                    v_addVisita.bttn_addVisita.setEnabled(false);
                }
            }
        });

        // Al pulsar añadir
        this.v_addVisita.bttn_addVisita.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!check()) {
                    String tipoVisita, resultado, precio;
                    M_Visita m_visita = new M_Visita();
    
                    // Coger los datos que haya puesto el usuario
                    tipoVisita = v_addVisita.input_tipo.getText().trim();
                    resultado = v_addVisita.input_resultado.getText().trim();
                    
                    

                    
                }
            }

        });

    }

    private boolean check() {
        boolean error = false;

        return error;
    }

    private boolean allInputsFull() {
        if (!v_addVisita.input_numero.getText().isEmpty() || v_addVisita.input_tipo.getText().isEmpty()
                || v_addVisita.input_resultado.getText().isEmpty() || v_addVisita.input_precio.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
