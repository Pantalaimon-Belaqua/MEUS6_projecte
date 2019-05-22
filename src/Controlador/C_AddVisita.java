/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Visita;
import Pers.AddVisitaDAO;
import Vista.V_AddVisita;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.SoundUtils;

/**
 *
 * @author noelia
 */
public class C_AddVisita {

    public V_AddVisita v_addVisita;
    private AddVisitaDAO visitaDAO = new AddVisitaDAO();
    M_Visita m_visita;
    private int idAnimal;

    public C_AddVisita(V_AddVisita v_addVisita, int idAnimal) {
        this.v_addVisita = v_addVisita;
        this.idAnimal = idAnimal;

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
                    String tipoVisita, resultado;
                    Double precio;
                    M_Visita m_visita = new M_Visita();

                    // Coger los datos que haya puesto el usuario
                    tipoVisita = v_addVisita.input_tipo.getText().trim();
                    resultado = v_addVisita.input_resultado.getText().trim();
                    precio = Double.parseDouble(v_addVisita.input_precio.getText());

                    // Añadir los datos al objeto de Visita
                    m_visita.setTipoVisita(tipoVisita);
                    m_visita.setResultado(resultado);
                    m_visita.setPrecio(precio);

                    // Añadir la visita a la BD.
                    try {
                        visitaDAO.addVisita(m_visita, idAnimal);
                        SoundUtils.playSuccessSound();
                        JOptionPane.showMessageDialog(v_addVisita, "La visita ha sido añadida correctamente", "", JOptionPane.INFORMATION_MESSAGE);                        
                        v_addVisita.dispatchEvent(new WindowEvent(v_addVisita, WindowEvent.WINDOW_CLOSING));
                    } catch (Exception ex) {
                        SoundUtils.playErrorSound();
                        JOptionPane.showMessageDialog(v_addVisita, "Ha habido un error al añadir la visita", "", JOptionPane.ERROR_MESSAGE);                        
                        Logger.getLogger(C_AddVisita.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        // Poner la ventana al medio
        v_addVisita.setLocationRelativeTo(null);
    }

    private boolean check() {
        boolean error = false;

        // Tipo
        if (v_addVisita.input_tipo.getText().isEmpty()) {

            v_addVisita.input_tipo.setBackground(Color.red);
            error = true;
        } else {
            v_addVisita.input_tipo.setBackground(Color.white);
        }

        // Resultado
        if (v_addVisita.input_resultado.getText().isEmpty()) {
            v_addVisita.input_resultado.setBackground(Color.red);
        } else {
            v_addVisita.input_resultado.setBackground(Color.white);
        }

        // Precio
        if (v_addVisita.input_precio.getText().isEmpty()) {
            v_addVisita.input_precio.setBackground(Color.red);
        } else {
            v_addVisita.input_precio.setBackground(Color.white);
        }

        return error;
    }

    private boolean allInputsFull() {
        if (!v_addVisita.input_tipo.getText().isEmpty()
                || v_addVisita.input_resultado.getText().isEmpty() || v_addVisita.input_precio.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
