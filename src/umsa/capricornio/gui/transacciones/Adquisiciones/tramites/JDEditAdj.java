/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.Adquisiciones.tramites;

import umsa.capricornio.domain.Proveedor;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;

/**
 *
 * @author UMSA-JES
 */
public class JDEditAdj extends javax.swing.JDialog {

    /**
     * Creates new form JDEditAdj
     */
    private int cod_trans_nro;
    public JDEditAdj(java.awt.Frame parent, boolean modal, int cod_trans_nro, Proveedor proveedor) {
        super(parent, modal);
        initComponents();
        LLenaDatos(proveedor);
        this.setLocationRelativeTo(null);
        this.cod_trans_nro = cod_trans_nro;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JL_Nit = new javax.swing.JLabel();
        JL_Nombre = new javax.swing.JLabel();
        JL_NombreComercial = new javax.swing.JLabel();
        JL_Direccion = new javax.swing.JLabel();
        JL_Telefono = new javax.swing.JLabel();
        JT_Nit = new javax.swing.JTextField();
        JT_Nombre = new javax.swing.JTextField();
        JT_NombreComercial = new javax.swing.JTextField();
        JT_Direccion = new javax.swing.JTextField();
        JT_Telefono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 224, 240));

        JL_Nit.setText("NIT:");

        JL_Nombre.setText("NOMBRE:");

        JL_NombreComercial.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        JL_NombreComercial.setForeground(new java.awt.Color(255, 0, 0));
        JL_NombreComercial.setText("NOMBRE COMERCIAL:");

        JL_Direccion.setText("DIRECCION:");

        JL_Telefono.setText("TELEFONO:");

        JT_Nit.setText(":D");
        JT_Nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_NitMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JT_NitMouseExited(evt);
            }
        });
        JT_Nit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_NitActionPerformed(evt);
            }
        });
        JT_Nit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_NitFocusLost(evt);
            }
        });

        JT_Nombre.setText(":D");
        JT_Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_NombreFocusLost(evt);
            }
        });
        JT_Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_NombreMouseClicked(evt);
            }
        });
        JT_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_NombreActionPerformed(evt);
            }
        });

        JT_NombreComercial.setForeground(new java.awt.Color(255, 0, 0));
        JT_NombreComercial.setText(":D");
        JT_NombreComercial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_NombreComercialMouseClicked(evt);
            }
        });
        JT_NombreComercial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_NombreComercialFocusLost(evt);
            }
        });

        JT_Direccion.setText(":D");
        JT_Direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_DireccionMouseClicked(evt);
            }
        });
        JT_Direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_DireccionFocusLost(evt);
            }
        });

        JT_Telefono.setText(":D");
        JT_Telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_TelefonoMouseClicked(evt);
            }
        });
        JT_Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_TelefonoFocusLost(evt);
            }
        });

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("INFORMACION DEL PROVEEDOR ADJUDICADO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Telefono)
                    .addComponent(JL_Nombre)
                    .addComponent(JL_Nit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_NombreComercial)
                    .addComponent(JL_Direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JT_Nit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(JT_Nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JT_NombreComercial, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JT_Direccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JT_Telefono, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(82, 82, 82)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nit)
                    .addComponent(JT_Nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nombre)
                    .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_NombreComercial)
                    .addComponent(JT_NombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Direccion)
                    .addComponent(JT_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Telefono)
                    .addComponent(JT_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(102, 102, 102))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JT_NitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_NitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_NitActionPerformed

    private void JT_NitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_NitMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            System.out.println("Se ha realizado un doble click");
            this.JT_Nit.setEditable(true);
        } 
    }//GEN-LAST:event_JT_NitMouseClicked

    private void JT_NitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_NitMouseExited
        // TODO add your handling code here:
        //this.JT_Nit.setEditable(false);
    }//GEN-LAST:event_JT_NitMouseExited

    private void JT_NitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_NitFocusLost
        // TODO add your handling code here:
        //this.JT_Nit.setEditable(false);
    }//GEN-LAST:event_JT_NitFocusLost

    private void JT_NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_NombreMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            System.out.println("Se ha realizado un doble click");
            this.JT_Nombre.setEditable(true);
        } 
    }//GEN-LAST:event_JT_NombreMouseClicked

    private void JT_NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_NombreFocusLost
        // TODO add your handling code here:
        //this.JT_Nombre.setEditable(false);
    }//GEN-LAST:event_JT_NombreFocusLost

    private void JT_NombreComercialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_NombreComercialMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            System.out.println("Se ha realizado un doble click");
            this.JT_NombreComercial.setEditable(true);
        } 
    }//GEN-LAST:event_JT_NombreComercialMouseClicked

    private void JT_NombreComercialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_NombreComercialFocusLost
        // TODO add your handling code here:
        //this.JT_NombreComercial.setEditable(false);
    }//GEN-LAST:event_JT_NombreComercialFocusLost

    private void JT_DireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_DireccionMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            System.out.println("Se ha realizado un doble click");
            this.JT_Direccion.setEditable(true);
        } 
    }//GEN-LAST:event_JT_DireccionMouseClicked

    private void JT_DireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_DireccionFocusLost
        // TODO add your handling code here:
        //this.JT_Direccion.setEditable(false);
    }//GEN-LAST:event_JT_DireccionFocusLost

    private void JT_TelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_TelefonoMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            System.out.println("Se ha realizado un doble click");
            this.JT_Telefono.setEditable(true);
        } 
    }//GEN-LAST:event_JT_TelefonoMouseClicked

    private void JT_TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_TelefonoFocusLost
        // TODO add your handling code here:
        //this.JT_Telefono.setEditable(false);
    }//GEN-LAST:event_JT_TelefonoFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UpdateADJ();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JT_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_NombreActionPerformed
    private void UpdateADJ(){
        int res = javax.swing.JOptionPane.showConfirmDialog(this, "¿Desea modificar la información del proveedor adjudicado?",
                "MENSAJE CAPRICORNIO", javax.swing.JOptionPane.YES_NO_OPTION);
        if (res == javax.swing.JOptionPane.YES_OPTION) {
            Proveedor new_proveedor = new Proveedor();
            new_proveedor.setCod_proveedor(this.JT_Nit.getText());
            new_proveedor.setNombre(this.JT_Nombre.getText());
            new_proveedor.setCasa_comercial(this.JT_NombreComercial.getText());
            new_proveedor.setDireccion(this.JT_Direccion.getText());
            new_proveedor.setTelefono(this.JT_Telefono.getText());

            try {
                AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
                AdquiWS_PortType puerto = servicio.getAdquiWS();
                puerto.setProponenteADJ(this.cod_trans_nro, new_proveedor.getCod_proveedor(), new_proveedor.getNombre(), new_proveedor.getCasa_comercial(), new_proveedor.getDireccion(), new_proveedor.getTelefono());
            }catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,"Error de conexión: "+e,"SYSTEM CAPRICORN",
                                javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
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
            java.util.logging.Logger.getLogger(JDEditAdj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEditAdj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEditAdj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEditAdj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEditAdj dialog = new JDEditAdj(new javax.swing.JFrame(), true,0,null);
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
    private javax.swing.JLabel JL_Direccion;
    private javax.swing.JLabel JL_Nit;
    private javax.swing.JLabel JL_Nombre;
    private javax.swing.JLabel JL_NombreComercial;
    private javax.swing.JLabel JL_Telefono;
    private javax.swing.JTextField JT_Direccion;
    private javax.swing.JTextField JT_Nit;
    private javax.swing.JTextField JT_Nombre;
    private javax.swing.JTextField JT_NombreComercial;
    private javax.swing.JTextField JT_Telefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void LLenaDatos(Proveedor proveedor) {
        //BlockJT();
        this.JT_Nit.setText(proveedor.getCod_proveedor());
        this.JT_Nombre.setText(proveedor.getNombre());
        this.JT_NombreComercial.setText(proveedor.getCasa_comercial());
        this.JT_Direccion.setText(proveedor.getDireccion());
        this.JT_Telefono.setText(proveedor.getTelefono());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void BlockJT(){
        this.JT_Nit.setEditable(false);
        this.JT_Nombre.setEditable(false);
        this.JT_NombreComercial.setEditable(false);
        this.JT_Direccion.setEditable(false);
        this.JT_Telefono.setEditable(false);
    }
}
