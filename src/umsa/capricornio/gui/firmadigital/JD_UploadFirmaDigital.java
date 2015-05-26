/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.firmadigital;

import com.caucho.hessian.client.HessianProxyFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import javax.swing.JFileChooser;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.gui.menu.FrmMenu;
import umsa.capricornio.service.HelloService;
import umsa.capricornio.utilitarios.herramientas.Archivos;

/**
 *
 * @author Usuario
 */
public class JD_UploadFirmaDigital extends javax.swing.JDialog {

    /**
     * Creates new form JD_UploadFirmaDigital
     */
    FrmMenu menu;
    private File rutaArchivo;
    private String lectura;
    private int cod_almacen;
    private int gestion;
    
    public JD_UploadFirmaDigital(FrmMenu menu, boolean modal, int cod_almacen, int gestion) {
        super(menu, modal);
        initComponents();
        this.gestion=gestion;
        this.cod_almacen=cod_almacen;
        this.setLocationRelativeTo(null);
    }
    boolean AdjuntarArchivo(String ruta_archivo, String nombre_archivo) {
        boolean sw = false;
        HessianProxyFactory proxy = new HessianProxyFactory();
        try {
            //call proxy for Upload
            HelloService x = (HelloService) proxy.create(HelloService.class, "http://200.7.160.25/HessianServerI/HelloServlet");
            InputStream in;
            try {
                in = new FileInputStream(ruta_archivo);
                x.upload("/opt/tomcat/webapps/firmas/" + nombre_archivo, in);
                sw = true;
            } catch (FileNotFoundException ex) {
                sw = false;
                //Logger.getLogger(HessianFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            sw = false;
            //Logger.getLogger(HessianFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sw;
    }

    public static String getExtension(String filename) {
        int index = filename.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else {
            return filename.substring(index + 1);
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JT_FIRMA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(185, 203, 221));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/find.png"))); // NOI18N
        jButton1.setText("Examinar");
        jButton1.setPreferredSize(new java.awt.Dimension(103, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/add.png"))); // NOI18N
        jButton2.setText("Adjuntar Firma");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Archivo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JT_FIRMA, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JT_FIRMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] csv = new String[]{"csv", "txt", "jpg", "doc", "xls", "pdf"};
        JFileChooser FileAdjuntaArchivo = new JFileChooser();
        FileAdjuntaArchivo.setAcceptAllFileFilterUsed(false);
        //FileImportaVeneficiarios.addChoosableFileFilter(new SimpleFileFilter(csv,"Datos a IMPORTAR (*.csv, *.txt)"));
        int option = FileAdjuntaArchivo.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            rutaArchivo = FileAdjuntaArchivo.getSelectedFile();
            if (FileAdjuntaArchivo.getSelectedFile() != null) {
                lectura = null;
                Archivos archivo = Archivos.getInstance();
                try {
                    lectura = archivo.leerArchivo(rutaArchivo.getAbsolutePath()).trim();
                    this.JT_FIRMA.setText(rutaArchivo.getAbsolutePath());
//                    nombre_archivo = rutaArchivo.getName();
                    //MigraDatosTabla("\\|"); // ESTE METODO TAMBIEN FUNCIONA, ambos son validos
                } catch (FileNotFoundException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se encontro el archivo \n" + e, "CAPRICORNIO",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                } catch (IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error de Flujo Entrada Salida \n" + e, "CAPRICORNIO",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            //MigraDatosTabla("|");
        } else {
            System.out.println("Cancelado.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String ext = getExtension(this.JT_FIRMA.getText().trim());
        String nombre = String.valueOf(gestion)+"-rpa-"+cod_almacen+"."+ext;
        if(AdjuntarArchivo(this.JT_FIRMA.getText(), nombre)){
            GuardarRutaFirma(nombre);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void GuardarRutaFirma(String nombre){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
//            puerto.getc
            puerto.updateRutaFirmaDigital(puerto.getCodFacultad(cod_almacen),"/opt/tomcat/webapps/firmas/"+nombre);
            javax.swing.JOptionPane.showMessageDialog(this, "Se adiciono la firma de manera exitosa", "CAPRICORNIO",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
//            javax.swing.JOptionPane.showMessageDialog(this, "nO SE ", "CAPRICORNIO",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(JD_UploadFirmaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_UploadFirmaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_UploadFirmaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_UploadFirmaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JD_UploadFirmaDigital dialog = new JD_UploadFirmaDigital(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JT_FIRMA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
