/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author noelia
 */
public class V_EditAnimal extends javax.swing.JFrame {

    /**
     * Creates new form V_AddAnimal
     */
    public V_EditAnimal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        input_nombreAnimal = new javax.swing.JTextField();
        bttn_modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        select_cuidador = new javax.swing.JComboBox();
        input_especie = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir animal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Especie");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        input_nombreAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nombreAnimalActionPerformed(evt);
            }
        });
        getContentPane().add(input_nombreAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 140, -1));

        bttn_modificar.setText("Editar");
        getContentPane().add(bttn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 80, 40));

        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Cuidador");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        select_cuidador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguno" }));
        getContentPane().add(select_cuidador, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 120, -1));

        input_especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_especieActionPerformed(evt);
            }
        });
        getContentPane().add(input_especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 140, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jPanel2.setBackground(new Color(255,255,255, 180));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 300, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/fondoperros.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_nombreAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nombreAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_nombreAnimalActionPerformed

    private void input_especieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_especieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_especieActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(V_EditAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_EditAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_EditAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_EditAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_EditAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttn_modificar;
    public javax.swing.JTextField input_especie;
    public javax.swing.JTextField input_nombreAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JComboBox select_cuidador;
    // End of variables declaration//GEN-END:variables
}
