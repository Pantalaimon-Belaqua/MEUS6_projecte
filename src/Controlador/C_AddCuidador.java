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
        this.v_addCuidador.addWindowListener(new WindowListener() {

            @Override
            public void windowActivated(WindowEvent e) {
                
                v_addCuidador.bttn_añadir.setEnabled(false);
                      
            }

        }
       
        );

    }

}
