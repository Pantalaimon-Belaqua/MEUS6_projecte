/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author darwing30
 */
public class V_AddVisita extends javax.swing.JFrame {

    /**
     * Creates new form V_Partida
     */
    public V_AddVisita() {
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

        jLabel2 = new javax.swing.JLabel();
        label_tipo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        input_numero = new javax.swing.JTextField();
        input_tipo = new javax.swing.JTextField();
        input_precio = new javax.swing.JTextField();
        bttn_addVisita = new javax.swing.JButton();
        label_resultado = new javax.swing.JLabel();
        input_resultado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 28, 9));
        jLabel2.setText("Informe");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        label_tipo.setFont(new java.awt.Font("TlwgTypewriter", 0, 18)); // NOI18N
        label_tipo.setForeground(new java.awt.Color(1, 1, 1));
        label_tipo.setText("Tipo");
        getContentPane().add(label_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("TlwgTypewriter", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Número");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("TlwgTypewriter", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Precio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        input_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_numeroActionPerformed(evt);
            }
        });
        getContentPane().add(input_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 44, -1));

        input_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_tipoActionPerformed(evt);
            }
        });
        getContentPane().add(input_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 80, -1));

        input_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_precioActionPerformed(evt);
            }
        });
        getContentPane().add(input_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 70, 30));

        bttn_addVisita.setText("Añadir");
        bttn_addVisita.setToolTipText("");
        getContentPane().add(bttn_addVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 90, 30));

        label_resultado.setFont(new java.awt.Font("TlwgTypewriter", 0, 18)); // NOI18N
        label_resultado.setForeground(new java.awt.Color(1, 1, 1));
        label_resultado.setText("Resultado");
        getContentPane().add(label_resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        input_resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_resultadoActionPerformed(evt);
            }
        });
        getContentPane().add(input_resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 130, 30));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 290, 210));

        jLabel13.setBackground(new java.awt.Color(240, 244, 245));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/fondoanimales.jpg"))); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_numeroActionPerformed

    private void input_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_tipoActionPerformed

    private void input_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_precioActionPerformed

    private void input_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_resultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_resultadoActionPerformed

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
            java.util.logging.Logger.getLogger(V_AddVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_AddVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_AddVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_AddVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_AddVisita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttn_addVisita;
    public javax.swing.JTextField input_numero;
    public javax.swing.JTextField input_precio;
    public javax.swing.JTextField input_resultado;
    public javax.swing.JTextField input_tipo;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_resultado;
    private javax.swing.JLabel label_tipo;
    // End of variables declaration//GEN-END:variables
}
