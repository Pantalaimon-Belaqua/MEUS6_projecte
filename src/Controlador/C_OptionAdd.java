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

/**
 *
 * @author noelia
 */
public class C_OptionAdd {

    V_OptionAdd v_optionAdd;

    public C_OptionAdd(V_OptionAdd v_optionAdd) {
        this.v_optionAdd = v_optionAdd;

        // Al pulsar Animal
        this.v_optionAdd.bttn_addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                V_AddAnimal v_addAnimal = new V_AddAnimal();
                C_AddAnimal c_addAnimal = new C_AddAnimal(v_addAnimal);
                v_addAnimal.setVisible(true);
            }
        });

        // Al pulsar Cuidador
        this.v_optionAdd.bttn_addCuidador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                V_AddCuidador v_addCuidador = new V_AddCuidador();
                v_addCuidador.setVisible(true);
            }
        });

        // Al pulsar Visita
        this.v_optionAdd.bttn_addVisita.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                V_AddVisita v_addVisita = new V_AddVisita();
                v_addVisita.setVisible(true);
            }
        });

    }

}
