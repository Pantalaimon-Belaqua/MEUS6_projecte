/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Visita;
import Vista.V_AddVisita;
import java.awt.event.WindowAdapter;

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
            
        });
        
        
    }
    
    
    
}
