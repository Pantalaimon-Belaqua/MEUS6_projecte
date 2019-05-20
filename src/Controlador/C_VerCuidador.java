/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Cuidador;
import Pers.VerCuidadorDAO;
import Vista.V_VerCuidador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author noelia
 */
public class C_VerCuidador {
    
    public V_VerCuidador v_verCuidador;
    private VerCuidadorDAO verCuidadorDAO = new VerCuidadorDAO();
    private int idAnimal;

    public C_VerCuidador(V_VerCuidador v_verCuidador, int idAnimal) {
        this.v_verCuidador = v_verCuidador;
        this.idAnimal = idAnimal;
        
        // Al cargar la ventana, cargar las visitas del cuidador
        this.v_verCuidador.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                updateTable();
            }
            
        });
        
        // Poner la ventana al medio
        v_verCuidador.setLocationRelativeTo(null);
    }
    
    private void updateTable(){
        DefaultTableModel model = (DefaultTableModel) v_verCuidador.tabla_verCuidador.getModel();
        
        ArrayList<M_Cuidador> cuidadores = null;
                
        try {
            cuidadores = verCuidadorDAO.getCuidadores(idAnimal);
        } catch (SQLException ex) {
            Logger.getLogger(C_VerVisita.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(cuidadores != null){

            for (M_Cuidador cuidador : cuidadores) {
                model.addRow(new Object[]{cuidador.getDNI(), cuidador.getNombre(), cuidador.getDireccion(), cuidador.getTelefono()});
            }

        } else {
            JOptionPane.showMessageDialog(v_verCuidador, "No se han podido cargar a los cuidadores", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
}

