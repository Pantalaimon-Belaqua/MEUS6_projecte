/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Animal;
import Pers.BaseDAO;
import Pers.PrincipalDAO;
import Vista.V_AddAnimal;
import Vista.V_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author daniel
 */
public class C_Principal {
    
    public V_Principal v_principal;
    private PrincipalDAO principalDAO = new PrincipalDAO();

    public C_Principal(V_Principal v_principal) {
        this.v_principal = v_principal;
        
        // Listeners para la ventana
        this.v_principal.addWindowListener(new WindowAdapter() {

            // Cuando se abre la ventana
            @Override
            public void windowActivated(WindowEvent e) {
                
                // Oculta la nota del buscador
                v_principal.notaBuscador.setVisible(false);
                
                updateTable();
                
            }
            
            // Cuando se cierra la ventana, desconectar de la BBDD
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    BaseDAO.close();
                    PrincipalDAO.close();
                } catch (SQLException ex) {
                    Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
        });
        
        // Buscar
        this.v_principal.buscador.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                
                String texto = v_principal.buscador.getText();
                
                if(!texto.isEmpty()){
                    // Coger el modelo de la tabla
                    TableModel model = v_principal.tablaAnimales.getModel();
                    
                    // Filtar por la palabra buscada
                    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                    sorter.setRowFilter(RowFilter.regexFilter(texto));
                    v_principal.tablaAnimales.setRowSorter(sorter);
                } else {
                    v_principal.tablaAnimales.setRowSorter(null);
                }
                
            }
            
        });
        
        // Nota del buscador
        this.v_principal.buscador.addFocusListener(new FocusAdapter() {

            JLabel buscador = v_principal.notaBuscador;            
            
            @Override
            public void focusGained(FocusEvent e) {
                buscador.setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                buscador.setVisible(false);
            }
            
        
        });
        
        // Al pulsar añadir
        this.v_principal.botonAñadir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                V_AddAnimal v_addAnimal = new V_AddAnimal();
                C_AddAnimal c_addProducto = new C_AddAnimal(v_addAnimal);
                v_addAnimal.setVisible(true);
            }
        });
        
        // Al pulsar eliminar, coger el id del animal seleccionado y borrarlo
        this.v_principal.botonEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = v_principal.tablaAnimales.getSelectedRow();
                int id = (int) v_principal.tablaAnimales.getValueAt(fila, 0);
                
                try {
                    principalDAO.deleteAnimal(id);
                } catch (SQLException ex) {
                    Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // Refrescar la tabla
                updateTable();
            }
        });
        
        // Poner la ventana al medio
        v_principal.setLocationRelativeTo(null);
        
    }
    
    /**
     * Actualiza la tabla
     */
    
    private void updateTable(){
        
        // Borra todas las filas de la tabla (por si acaso)
        DefaultTableModel model = (DefaultTableModel) v_principal.tablaAnimales.getModel();
        int nRows = model.getRowCount();
        for (int i = nRows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
                
                
        
        try {
            // Recoge la lista de productos de la BBDD
            ArrayList<M_Animal> animales = principalDAO.getAnimales();

            // Añade las filas a la tabla
            for (M_Animal animal : animales) {

                /***
                 * Añadir las cosas en orden del arraylist al row
                 */

                model.addRow(new Object[]{animal.getId(), animal.getNombre(), animal.getEspecie()});
            }

        } catch (SQLException ex) {
            Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
