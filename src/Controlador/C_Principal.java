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
import Vista.V_EditAnimal;
import Vista.V_OptionAdd;
import Vista.V_Principal;
import Vista.V_VerCuidador;
import Vista.V_VerVisita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import utils.SoundUtils;

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

                // Cambiar el tamaño de la primera columna
                v_principal.tablaAnimales.getColumnModel().getColumn(0).setPreferredWidth(5);

                // Poner todos los datos tipo String centrados
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                v_principal.tablaAnimales.setDefaultRenderer(String.class, centerRenderer);

                updateTable();

                // Selecciona la primera fila
                v_principal.tablaAnimales.setRowSelectionInterval(0, 0);
                
                SoundUtils.powerUp();
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

                if (!texto.isEmpty()) {
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

                if (v_principal.tablaAnimales.getSelectedRow() == -1) {

                    JOptionPane.showMessageDialog(v_principal, "Por favor, selecciona un animal primero", "", JOptionPane.WARNING_MESSAGE);
                    SoundUtils.playWarningSound();
                    
                } else {
                    SoundUtils.pop();
                    V_OptionAdd v_optionAdd = new V_OptionAdd();
                    C_OptionAdd c_optionAdd = new C_OptionAdd(v_optionAdd, getSelectedAnimalID());
                    v_optionAdd.setVisible(true);
                }

            }
        });

        // Al pulsar eliminar, coger el id del animal seleccionado y borrarlo
        this.v_principal.botonEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (v_principal.tablaAnimales.getSelectedRow() == -1) {

                    JOptionPane.showMessageDialog(v_principal, "Por favor, selecciona un animal primero", "", JOptionPane.WARNING_MESSAGE);
                    SoundUtils.playWarningSound();

                } else {
                    int id = getSelectedAnimalID();

                    try {
                        principalDAO.deleteAnimal(id);
                        SoundUtils.playAngryCatSound();
                    } catch (SQLException ex) {
                        Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Refrescar la tabla
                    updateTable();
                }

            }
        });

        // Al pulsar "ver visita"
        this.v_principal.bttn_verVisita.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (v_principal.tablaAnimales.getSelectedRow() == -1) {

                    JOptionPane.showMessageDialog(v_principal, "Por favor, selecciona un animal primero", "", JOptionPane.WARNING_MESSAGE);
                    SoundUtils.playWarningSound();
                } else {
                    // Coger el id del animal
                    int id = getSelectedAnimalID();

                    try {
                        if (principalDAO.hasVisits(id)) {
                            SoundUtils.pop();
                            V_VerVisita v_verVisita = new V_VerVisita();
                            C_VerVisita c_verVisita = new C_VerVisita(v_verVisita, id);
                            v_verVisita.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(v_principal, "El animal seleccionado no tiene visitas", "", JOptionPane.WARNING_MESSAGE);
                            SoundUtils.playErrorSound();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        
        // Al pulsar "Ver cuidador"
        v_principal.bttn_verCuidador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_principal.tablaAnimales.getSelectedRow() == -1) {

                    JOptionPane.showMessageDialog(v_principal, "Por favor, selecciona un animal primero", "", JOptionPane.WARNING_MESSAGE);
                    SoundUtils.playWarningSound();

                } else {
                    // Coger el id del animal
                    int id = getSelectedAnimalID();

                    try {
                        if(principalDAO.hasKeepers(id)){
                            
                            SoundUtils.pop();
                            V_VerCuidador v_verCuidador = new V_VerCuidador();
                            C_VerCuidador c_VerCuidador = new C_VerCuidador(v_verCuidador, id);
                            v_verCuidador.setVisible(true);
                            
                        } else {
                            JOptionPane.showMessageDialog(v_principal, "El animal seleccionado no tiene cuidadores", "", JOptionPane.WARNING_MESSAGE);
                            SoundUtils.playErrorSound();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        // Al pulsar "editar"
        v_principal.botonEditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_principal.tablaAnimales.getSelectedRow() == -1) {

                    JOptionPane.showMessageDialog(v_principal, "Por favor, selecciona un animal primero", "", JOptionPane.WARNING_MESSAGE);
                    SoundUtils.playWarningSound();

                } else {
                    int id = getSelectedAnimalID();
                    SoundUtils.pop();
                    V_EditAnimal v_editAnimal = new V_EditAnimal();
                    C_EditAnimal c_editAnimal = new C_EditAnimal(v_editAnimal, id);
                    v_editAnimal.setVisible(true);
                }
            }
        });

        // Poner la ventana al medio
        v_principal.setLocationRelativeTo(null);

    }

    /**
     * Actualiza la tabla
     */
    private void updateTable() {

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

                /**
                 * *
                 * Añadir las cosas en orden del arraylist al row
                 */
                model.addRow(new Object[]{animal.getId(), animal.getNombre(), animal.getEspecie()});
            }

        } catch (SQLException ex) {
            Logger.getLogger(C_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSelectedAnimalID() {
        int fila = v_principal.tablaAnimales.getSelectedRow();
        int id = (int) v_principal.tablaAnimales.getValueAt(fila, 0);

        return id;
    }

}
