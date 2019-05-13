/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pers.BaseDAO;
import Pers.PrincipalDAO;
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
                
                // Borra todas las filas de la tabla (por si acaso)
                DefaultTableModel model = (DefaultTableModel) v_principal.tablaProductos.getModel();
                int nRows = model.getRowCount();
                for (int i = nRows - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                
                try {
                    // Recoge la lista de productos de la BBDD
                    ArrayList<M_Animal> animales = principalDAO.getProducts();
                    
                    // Añade las filas a la tabla
                    for (M_Animal animal : animales) {
                        
                        /***
                         * Añadir las cosas en orden del arraylist al row
                         */
                        
                        model.addRow(new Object[]{producto.getCode(), producto.getDescripcion(), 
                            producto.getCategoria(), producto.getPrecio(), producto.getUbicacion(), 
                            producto.getTipo(), producto.getOferta()});
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        
        // Filtrar por juguetes
        this.v_principal.catJuguete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Está el checkbox seleccionado?
                boolean isChecked = v_principal.catJuguete.isSelected();
                
                if(isChecked){
                    
                    // Coger el modelo de la tabla
                    TableModel model = v_principal.tablaProductos.getModel();
                    
                    // Filtar por la palabra "Juguete"
                    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                    sorter.setRowFilter(RowFilter.regexFilter("Juguete"));
                    v_principal.tablaProductos.setRowSorter(sorter);
                    
                } else {
                    v_principal.tablaProductos.setRowSorter(null);
                }
                
            }
        });
        
        // Filtrar por electronica
        this.v_principal.catElectronica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Está el checkbox seleccionado?
                boolean isChecked = v_principal.catElectronica.isSelected();
                
                if(isChecked){
                    
                    // Coger el modelo de la tabla
                    TableModel model = v_principal.tablaProductos.getModel();
                    
                    // Filtar por la palabra "Juguete"
                    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                    sorter.setRowFilter(RowFilter.regexFilter("Electrónica"));
                    v_principal.tablaProductos.setRowSorter(sorter);
                    
                } else {
                    v_principal.tablaProductos.setRowSorter(null);
                }
                
            }
        });
        
        // Filtrar por ropa
        this.v_principal.catRopa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           
                // Está el checkbox seleccionado?
                boolean isChecked = v_principal.catRopa.isSelected();
                
                if(isChecked){
                    
                    // Coger el modelo de la tabla
                    TableModel model = v_principal.tablaProductos.getModel();
                    
                    // Filtar por la palabra "Juguete"
                    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                    sorter.setRowFilter(RowFilter.regexFilter("Ropa"));
                    v_principal.tablaProductos.setRowSorter(sorter);
                    
                } else {
                    v_principal.tablaProductos.setRowSorter(null);
                }
                
            }
        });
        
        // Filtrar por cocina
        this.v_principal.catCocina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Está el checkbox seleccionado?
                boolean isChecked = v_principal.catCocina.isSelected();
                
                if(isChecked){
                    
                    // Coger el modelo de la tabla
                    TableModel model = v_principal.tablaProductos.getModel();
                    
                    // Filtar por la palabra "Juguete"
                    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                    sorter.setRowFilter(RowFilter.regexFilter("Cocina"));
                    v_principal.tablaProductos.setRowSorter(sorter);
                    
                } else {
                    v_principal.tablaProductos.setRowSorter(null);
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
                    TableModel model = v_principal.tablaProductos.getModel();
                    
                    // Filtar por la palabra "Juguete"
                    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                    sorter.setRowFilter(RowFilter.regexFilter(texto));
                    v_principal.tablaProductos.setRowSorter(sorter);
                } else {
                    v_principal.tablaProductos.setRowSorter(null);
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
                V_addProducto v_addProducto = new V_addProducto();
                C_addProducto c_addProducto = new C_addProducto(v_addProducto);
                v_addProducto.setVisible(true);
            }
        });
        
        // Al pulsar eliminar
        this.v_principal.botonEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                V_Eliminar v_eliminar = new V_Eliminar();
                C_Eliminar c_eliminar = new C_Eliminar(v_eliminar);
                v_eliminar.setVisible(true);
            }
        });
        
        // Poner la ventana al medio
        v_principal.setLocationRelativeTo(null);
        
    }
    
    
    
}
