/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pers.VerCuidadorDAO;
import Vista.V_VerCuidador;

/**
 *
 * @author daniel
 */
public class C_VerCuidador {
    
    public V_VerCuidador v_verCuidador;
    private VerCuidadorDAO verCuidadorDAO = new VerCuidadorDAO();
    private int idAnimal;

    public C_VerCuidador(V_VerCuidador v_verCuidador, int idAnimal) {
        this.v_verCuidador = v_verCuidador;
        this.idAnimal = idAnimal;
    }
    
    
    
}
