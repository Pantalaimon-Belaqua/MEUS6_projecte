/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.V_AddAnimal;
import Vista.V_AddCuidador;
import Vista.V_AddVisita;
import Vista.V_OptionAdd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import utils.SoundUtils;

/**
 *
 * @author noelia
 */
public class C_OptionAdd {

    V_OptionAdd v_optionAdd;
    int idAnimal;

    public C_OptionAdd(V_OptionAdd v_optionAdd, int idAnimal) {
        this.v_optionAdd = v_optionAdd;
        this.idAnimal = idAnimal;

        // Al pulsar (añadir) Animal
        this.v_optionAdd.bttn_addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundUtils.pop();
                V_AddAnimal v_addAnimal = new V_AddAnimal();
                C_AddAnimal c_addAnimal = new C_AddAnimal(v_addAnimal);
                v_addAnimal.setVisible(true);
                v_optionAdd.dispatchEvent(new WindowEvent(v_optionAdd, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Al pulsar Cuidador
        this.v_optionAdd.bttn_addCuidador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SoundUtils.pop();
                V_AddCuidador v_addCuidador = new V_AddCuidador();
                C_AddCuidador c_addCuidador = new C_AddCuidador(v_addCuidador);
                v_addCuidador.setVisible(true);
                v_optionAdd.dispatchEvent(new WindowEvent(v_optionAdd, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Al pulsar Visita
        this.v_optionAdd.bttn_addVisita.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SoundUtils.pop();
                V_AddVisita v_addVisita = new V_AddVisita();
                C_AddVisita c_addVisita = new C_AddVisita(v_addVisita, idAnimal);
                v_addVisita.setVisible(true);
                v_optionAdd.dispatchEvent(new WindowEvent(v_optionAdd, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        // Poner la ventana al medio
        v_optionAdd.setLocationRelativeTo(null);

    }

}
