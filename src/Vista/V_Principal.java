/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author daniel
 */
public class V_Principal extends javax.swing.JFrame {

    /**
     * Creates new form V_Principal
     */
    public V_Principal() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAnimales = new javax.swing.JTable();
        botonAñadir = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        buscador = new javax.swing.JTextField();
        notaBuscador = new javax.swing.JLabel();
        foto_gatito = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        bttn_verCuidador = new javax.swing.JButton();
        bttn_verVisita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tablaAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Especie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAnimales.setToolTipText("");
        tablaAnimales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaAnimales.setEnabled(false);
        jScrollPane1.setViewportView(tablaAnimales);

        botonAñadir.setText("Añadir");

        botonEliminar.setText("Eliminar");

        botonEditar.setText("Editar");

        buscador.setToolTipText("Buscar...");

        notaBuscador.setText("(Case sensitive)");
        notaBuscador.setToolTipText("");

        foto_gatito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/cutie_100.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Chilanka", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(39, 202, 177));
        titulo.setText("CENTRO DE ACOGIDA");

        bttn_verCuidador.setText("Ver Cuidador");
        bttn_verCuidador.setToolTipText("");

        bttn_verVisita.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(notaBuscador))
                            .addComponent(titulo))
                        .addGap(73, 73, 73)
                        .addComponent(foto_gatito, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonAñadir)
                            .addGap(41, 41, 41)
                            .addComponent(bttn_verCuidador)
                            .addGap(45, 45, 45)
                            .addComponent(botonEliminar)
                            .addGap(68, 68, 68)
                            .addComponent(bttn_verVisita)
                            .addGap(77, 77, 77)
                            .addComponent(botonEditar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(foto_gatito))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notaBuscador, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditar)
                    .addComponent(botonEliminar)
                    .addComponent(botonAñadir)
                    .addComponent(bttn_verCuidador)
                    .addComponent(bttn_verVisita))
                .addContainerGap(48, Short.MAX_VALUE))
        );

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
            java.util.logging.Logger.getLogger(V_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonAñadir;
    public javax.swing.JButton botonEditar;
    public javax.swing.JButton botonEliminar;
    public javax.swing.JButton bttn_verCuidador;
    public javax.swing.JButton bttn_verVisita;
    public javax.swing.JTextField buscador;
    private javax.swing.JLabel foto_gatito;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel notaBuscador;
    public javax.swing.JTable tablaAnimales;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
