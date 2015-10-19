/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsa.capricornio.gui.transacciones.Adquisiciones.tramites;

import java.util.Map;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;

/**
 *
 * @author Henrry
 */
public class JD_CONTRATADO extends javax.swing.JDialog {

    /**
     * Creates new form JD_CONTRATADO
     */
    private int cod_transaccion;
    
    public JD_CONTRATADO(java.awt.Frame parent, boolean modal, int cod_transaccion) {
        super(parent, modal);
        initComponents();
        this.cod_transaccion = cod_transaccion;
        this.setLocationRelativeTo(null);
    }
    private void CargaContratado(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            Map[] datos = null;
            if (datos != null) {
                System.err.println("Con Datos");
            }
            else
                System.err.println("Vacio!!!");
        } catch (Exception e) {
            System.err.println("Error :O");          
        }
    }
    private void GuardaContratado(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            Map[] datos = null;
            if (datos != null) {
                System.err.println("Con Datos");
            }
            else
                System.err.println("Vacio!!!");
        } catch (Exception e) {
            System.err.println("Error :O");          
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTF_NOMBRE_CONTRATADO = new javax.swing.JTextField();
        JTF_NEMPRESA_CONTRATADO = new javax.swing.JTextField();
        JTF_CI_CONTRATADO = new javax.swing.JTextField();
        JTF_DIRECCION_CONTRATADO = new javax.swing.JTextField();
        JTF_DENOMINACION_CONTRATADO = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        JB_IMPRIMIR = new javax.swing.JButton();
        JD_GUARDAR = new javax.swing.JButton();
        JD_SALIR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATOS CONTRATADO");

        jLabel1.setText("NOMBRE:");

        jLabel2.setText("C.I.:");

        jLabel3.setText("DIRECCION:");

        jLabel4.setText("DENOMINACION:");

        jLabel5.setText("NOMBRE EMPRESA:");

        JTF_NOMBRE_CONTRATADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NOMBRE_CONTRATADOActionPerformed(evt);
            }
        });

        JTF_NEMPRESA_CONTRATADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NEMPRESA_CONTRATADOActionPerformed(evt);
            }
        });

        JTF_CI_CONTRATADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_CI_CONTRATADOActionPerformed(evt);
            }
        });

        JTF_DIRECCION_CONTRATADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_DIRECCION_CONTRATADOActionPerformed(evt);
            }
        });

        JTF_DENOMINACION_CONTRATADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_DENOMINACION_CONTRATADOActionPerformed(evt);
            }
        });

        JB_IMPRIMIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/printer.png"))); // NOI18N
        JB_IMPRIMIR.setText("Imprimir");

        JD_GUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/save_16.png"))); // NOI18N
        JD_GUARDAR.setText("Guardar");

        JD_SALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/book_previous.png"))); // NOI18N
        JD_SALIR.setText("SALIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JB_IMPRIMIR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JD_GUARDAR))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(JD_SALIR)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_IMPRIMIR)
                    .addComponent(JD_GUARDAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JD_SALIR)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_NOMBRE_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_NEMPRESA_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_CI_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_DIRECCION_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_DENOMINACION_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTF_NOMBRE_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(JTF_NEMPRESA_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(JTF_CI_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(JTF_DIRECCION_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JTF_DENOMINACION_CONTRATADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_NOMBRE_CONTRATADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NOMBRE_CONTRATADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NOMBRE_CONTRATADOActionPerformed

    private void JTF_NEMPRESA_CONTRATADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NEMPRESA_CONTRATADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NEMPRESA_CONTRATADOActionPerformed

    private void JTF_CI_CONTRATADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_CI_CONTRATADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_CI_CONTRATADOActionPerformed

    private void JTF_DIRECCION_CONTRATADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_DIRECCION_CONTRATADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_DIRECCION_CONTRATADOActionPerformed

    private void JTF_DENOMINACION_CONTRATADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_DENOMINACION_CONTRATADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_DENOMINACION_CONTRATADOActionPerformed

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
            java.util.logging.Logger.getLogger(JD_CONTRATADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_CONTRATADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_CONTRATADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_CONTRATADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_CONTRATADO dialog = new JD_CONTRATADO(new javax.swing.JFrame(), true,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_IMPRIMIR;
    private javax.swing.JButton JD_GUARDAR;
    private javax.swing.JButton JD_SALIR;
    private javax.swing.JTextField JTF_CI_CONTRATADO;
    private javax.swing.JTextField JTF_DENOMINACION_CONTRATADO;
    private javax.swing.JTextField JTF_DIRECCION_CONTRATADO;
    private javax.swing.JTextField JTF_NEMPRESA_CONTRATADO;
    private javax.swing.JTextField JTF_NOMBRE_CONTRATADO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
