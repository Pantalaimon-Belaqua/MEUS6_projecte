/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Cuidador;
import Pers.AddCuidadorDAO;
import Vista.V_AddCuidador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
                }

            }
        });

    }

    public boolean check() {
        boolean error = false;

        return error;
    }

}
