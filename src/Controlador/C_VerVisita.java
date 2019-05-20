/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pers.VerVisitaDAO;
import Vista.V_VerVisita;

/**
 *
 * @author daniel
 */
public class C_VerVisita {
    
    public V_VerVisita v_verVisita;
    private VerVisitaDAO verVisitaDAO = new VerVisitaDAO();
    private int idAnimal;

    public C_VerVisita(V_VerVisita v_verVisita, int idAnimal) {
        this.v_verVisita = v_verVisita;
        this.idAnimal = idAnimal;
    }

    
    
    
    
}
