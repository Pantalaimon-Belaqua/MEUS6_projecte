/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 *
 * @author noelia
 */
public class V_AddCuidador extends javax.swing.JFrame {

    Color panelColor = new Color(240,240,240, 200);
    
    /**
     * Creates new form V_AddCuidador
     */
    public V_AddCuidador() {
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

        input_dni = new javax.swing.JTextField();
        input_nombreCuidador = new javax.swing.JTextField();
        input_direccion = new javax.swing.JTextField();
        input_telefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bttn_addCuidador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir cuidador");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(input_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 73, 115, -1));
        getContentPane().add(input_nombreCuidador, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 118, 133, -1));
        getContentPane().add(input_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 163, 161, -1));
        getContentPane().add(input_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 208, 115, -1));

        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("DNI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jPanel1.setBackground(panelColor);

        bttn_addCuidador.setText("Añadir");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");

        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Dirección");

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Teléfono");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(bttn_addCuidador)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(bttn_addCuidador)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 290, 250));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/dog-foodprint.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 610, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(V_AddCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_AddCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_AddCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_AddCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_AddCuidador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttn_addCuidador;
    public javax.swing.JTextField input_direccion;
    public javax.swing.JTextField input_dni;
    public javax.swing.JTextField input_nombreCuidador;
    public javax.swing.JTextField input_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
