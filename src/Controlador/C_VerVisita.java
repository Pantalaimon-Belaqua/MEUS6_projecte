/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Visita;
import Pers.VerVisitaDAO;
import Vista.V_VerVisita;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.SoundUtils;

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
        
        // Al cargar la ventana, cargar las visitas del animal
        this.v_verVisita.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                updateTable();
            }
            
        });
        
        // Poner la ventana al medio
        v_verVisita.setLocationRelativeTo(null);
    }

    
    private void updateTable(){
        DefaultTableModel model = (DefaultTableModel) v_verVisita.tabla_visitas.getModel();
        
        // Borrar visitas
        int nRows = model.getRowCount();
        for (int i = nRows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        ArrayList<M_Visita> visitas = null;
                
        try {
            visitas = verVisitaDAO.getVisitas(idAnimal);
        } catch (SQLException ex) {
            Logger.getLogger(C_VerVisita.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(visitas != null){

            for (M_Visita visita : visitas) {
                model.addRow(new Object[]{visita.getId(), visita.getTipoVisita(), visita.getResultado(), visita.getPrecio()});
            }

        } else {
            SoundUtils.playErrorSound();
            JOptionPane.showMessageDialog(v_verVisita, "No se han podido cargar las visitas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
}
