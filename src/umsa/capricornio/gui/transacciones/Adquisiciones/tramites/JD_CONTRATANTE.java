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
public class JD_CONTRATANTE extends javax.swing.JDialog {

    /**
     * Creates new form JD_CONTRATADO
     */
    private int cod_transaccion;
    public JD_CONTRATANTE(java.awt.Frame parent, boolean modal, int cod_transaccion) {
        super(parent, modal);
        initComponents();
        this.cod_transaccion = cod_transaccion;
        this.setLocationRelativeTo(null);
        CargaContratante(this.cod_transaccion);
    }
    private void CargaContratante(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            Map[] datos = puerto.getContratoContratante(cod_transaccion);
            if (datos != null) {
                System.err.println("Con Datos");
                
                this.JTF_RSOCIAL_CONTRATANTE.setText(datos[0].get("RAZON_SOCIAL_CONTRATANTE").toString());
                this.JTF_NIT_CONTRATANTE.setText(datos[0].get("NIT_CONTRATANTE").toString());
                this.JTF_DIRECCION_CONTRATANTE.setText(datos[0].get("DIRECCION_CONTRATANTE").toString());
                this.JTF_CIUDAD_CONTRATANTE.setText(datos[0].get("CIUDAD_CONTRATANTE").toString());
                this.JTF_NOMBRE_RPA_RPC.setText(datos[0].get("REP_LEG_CONTRATANTE").toString());
                this.JTF_CI_RPC_RPA.setText(datos[0].get("CI_REP_LEG_CONTRATANTE").toString());
                this.JTF_CARGO_RPC_RPA.setText(datos[0].get("CARGO_REP_LEG_CONTRATANTE").toString());
            }
            else
                System.err.println("Vacio!!!");
        } catch (Exception e) {
            System.err.println("Error :O");          
        }
    }
    private void GuardaContratante(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            Map[] datos = puerto.updateContratoContratante(cod_transaccion
                    ,this.JTF_RSOCIAL_CONTRATANTE.getText()
                    ,this.JTF_NIT_CONTRATANTE.getText()
                    ,this.JTF_DIRECCION_CONTRATANTE.getText()
                    ,this.JTF_CIUDAD_CONTRATANTE.getText()
                    ,this.JTF_NOMBRE_RPA_RPC.getText()
                    ,this.JTF_CARGO_RPC_RPA.getText()
                    ,this.JTF_CI_RPC_RPA.getText()
            );
            javax.swing.JOptionPane.showMessageDialog(this, "Se actualizo el tramite de forma exitosa!!! ", "SYSTEM CAPRICORN",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
//            if (datos != null) {
//                System.err.println("Con Datos");
//            }
//            else
//                System.err.println("Vacio!!!");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "<html> error :O <br> " + e, "SYSTEM CAPRICORN",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
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
        jLabel5 = new javax.swing.JLabel();
        JTF_RSOCIAL_CONTRATANTE = new javax.swing.JTextField();
        JTF_NIT_CONTRATANTE = new javax.swing.JTextField();
        JTF_DIRECCION_CONTRATANTE = new javax.swing.JTextField();
        JTF_CIUDAD_CONTRATANTE = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        JD_GUARDAR = new javax.swing.JButton();
        JD_SALIR = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTF_NOMBRE_RPA_RPC = new javax.swing.JTextField();
        JTF_CI_RPC_RPA = new javax.swing.JTextField();
        JTF_CARGO_RPC_RPA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATOS CONTRATANTE");

        jLabel1.setText("RAZON SOCIAL:");

        jLabel2.setText("DIRECCION:");

        jLabel3.setText("CIUDAD:");

        jLabel5.setText("NIT:");

        JTF_RSOCIAL_CONTRATANTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_RSOCIAL_CONTRATANTEActionPerformed(evt);
            }
        });

        JTF_NIT_CONTRATANTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NIT_CONTRATANTEActionPerformed(evt);
            }
        });

        JTF_DIRECCION_CONTRATANTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_DIRECCION_CONTRATANTEActionPerformed(evt);
            }
        });

        JTF_CIUDAD_CONTRATANTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_CIUDAD_CONTRATANTEActionPerformed(evt);
            }
        });

        JD_GUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/save_16.png"))); // NOI18N
        JD_GUARDAR.setText("Guardar");
        JD_GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JD_GUARDARActionPerformed(evt);
            }
        });

        JD_SALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/book_previous.png"))); // NOI18N
        JD_SALIR.setText("SALIR");
        JD_SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JD_SALIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JD_GUARDAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JD_SALIR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JD_GUARDAR)
                    .addComponent(JD_SALIR))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel6.setText("NOMBRE (RPC/RPA):");

        jLabel7.setText("C.I. (RPC/RPA):");

        jLabel8.setText("CARGO (RPC/RPA):");

        JTF_NOMBRE_RPA_RPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NOMBRE_RPA_RPCActionPerformed(evt);
            }
        });

        JTF_CI_RPC_RPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_CI_RPC_RPAActionPerformed(evt);
            }
        });

        JTF_CARGO_RPC_RPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_CARGO_RPC_RPAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_CIUDAD_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_DIRECCION_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_NIT_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_RSOCIAL_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_CI_RPC_RPA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_NOMBRE_RPA_RPC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_CARGO_RPC_RPA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTF_RSOCIAL_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTF_NIT_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTF_DIRECCION_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTF_CIUDAD_CONTRATANTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTF_NOMBRE_RPA_RPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JTF_CI_RPC_RPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(JTF_CARGO_RPC_RPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_RSOCIAL_CONTRATANTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_RSOCIAL_CONTRATANTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_RSOCIAL_CONTRATANTEActionPerformed

    private void JTF_NIT_CONTRATANTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NIT_CONTRATANTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NIT_CONTRATANTEActionPerformed

    private void JTF_DIRECCION_CONTRATANTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_DIRECCION_CONTRATANTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_DIRECCION_CONTRATANTEActionPerformed

    private void JTF_CIUDAD_CONTRATANTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_CIUDAD_CONTRATANTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_CIUDAD_CONTRATANTEActionPerformed

    private void JTF_NOMBRE_RPA_RPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NOMBRE_RPA_RPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NOMBRE_RPA_RPCActionPerformed

    private void JTF_CI_RPC_RPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_CI_RPC_RPAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_CI_RPC_RPAActionPerformed

    private void JTF_CARGO_RPC_RPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_CARGO_RPC_RPAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_CARGO_RPC_RPAActionPerformed

    private void JD_GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JD_GUARDARActionPerformed
        // TODO add your handling code here:
        GuardaContratante(this.cod_transaccion);
    }//GEN-LAST:event_JD_GUARDARActionPerformed

    private void JD_SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JD_SALIRActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_JD_SALIRActionPerformed

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
                JD_CONTRATANTE dialog = new JD_CONTRATANTE(new javax.swing.JFrame(), true,0);
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
    private javax.swing.JButton JD_GUARDAR;
    private javax.swing.JButton JD_SALIR;
    private javax.swing.JTextField JTF_CARGO_RPC_RPA;
    private javax.swing.JTextField JTF_CIUDAD_CONTRATANTE;
    private javax.swing.JTextField JTF_CI_RPC_RPA;
    private javax.swing.JTextField JTF_DIRECCION_CONTRATANTE;
    private javax.swing.JTextField JTF_NIT_CONTRATANTE;
    private javax.swing.JTextField JTF_NOMBRE_RPA_RPC;
    private javax.swing.JTextField JTF_RSOCIAL_CONTRATANTE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
