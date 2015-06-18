/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsa.capricornio.gui.transacciones.Adquisiciones.tramites;

import java.text.DecimalFormat;
import java.util.Map;
import javax.swing.JOptionPane;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.gui.transacciones.reporte.GetResAdj;
import umsa.capricornio.utilitarios.herramientas.NumerosTextuales;

/**
 *
 * @author alex
 */
public class ResMay15 extends javax.swing.JDialog {

    /**
     * Creates new form ResMay15
     */
    GetResAdj genera_res_15 = new GetResAdj();
    String hoja_ruta;
    String enviado_por;
    String cargo;
    String detalle;
    String destino;
    String objetivo;
    String preventivo;
    String monto;
    String partida;
    String sol_compra;
    String cotizacion;
    String proveedor;
    String dias;
    String cite;
    String nro_res;
    int cod_transaccion,cod_trans_nro,gestion;
    public ResMay15(java.awt.Frame parent, boolean modal,String x, int a, int b, int c) 
    {
        super(parent, modal);
        initComponents();
        proveedor=x;
        cod_transaccion=a;
        cod_trans_nro=b;
        gestion=c;
        llenadatos();
    }
    public void bloquea()
    {
        jTextField1.setEnabled(false);
        //jTextField4.setEnabled(false);
        //jTextField5.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextArea2.setEnabled(false);
        jTextField6.setEnabled(false);
        jButton1.setEnabled(false);
        jButton4.setVisible(true);
        jButton5.setVisible(true);
        
    }
    public void bloquea_botones()
    {
        jButton4.setVisible(false);
        jButton5.setVisible(false);
    }
    public void llenadatos()
    {
        try
        {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getres15(cod_transaccion,cod_trans_nro);
            if(datos!=null)
            {
                jTextField1.setText(datos[0].get("CITE").toString());
                //jTextField4.setText(datos[0].get("DESTINO").toString());
                //jTextField5.setText(datos[0].get("OBJETIVO").toString());
                jTextArea1.setText(datos[0].get("DESTINO").toString());
                jTextArea2.setText(datos[0].get("OBJETIVO").toString());
                jTextField6.setText(datos[0].get("COTIZACION").toString());
                nro_res=datos[0].get("NRO").toString();
                bloquea();
            }
            else
            {
            bloquea_botones();
            }
        }catch(Exception e)
        {
            
        }
    }
    String TotalTexto(String total){
        double m=Double.parseDouble(total);                          
        
        long valor =(long)m;
        double var= m-valor;
        
        DecimalFormat formato_decimal = new DecimalFormat("0.00");        
        String decimal =formato_decimal.format(var);
      
        String montoLetra=NumerosTextuales.NumTextuales(valor);
        
        if ((m>=1000 && m<2000) || (m>=1000000 && m<2000000)){ montoLetra="UN "+montoLetra;}        
        if (var ==0.0) montoLetra=montoLetra+" 00/100";
        else montoLetra=montoLetra+" "+decimal.substring(2, 4)+"/100";
       return montoLetra;
   }
    private void montocompleto()
    {
        System.out.println("monto "+monto);
        System.out.println("hr "+hoja_ruta);
        System.out.println("envia "+enviado_por);
        System.out.println("cargo "+cargo);
        System.out.println("detalle "+detalle);
        System.out.println("destino "+destino);
        System.out.println("objetivo "+objetivo);
        System.out.println("preventivo "+preventivo);
        System.out.println("partida "+partida);
        System.out.println("sol "+sol_compra);
        System.out.println("cot "+cotizacion);
        System.out.println("prov "+proveedor);
        System.out.println("dias "+dias);
        System.out.println("cite "+cite);
        monto=monto+" "+TotalTexto(monto);
    }
    private void habilita()
    {
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
    }
    private void llena_campos()
    {
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            System.out.println(cod_transaccion);
            Map[] datos=puerto.getdatosres15(cod_transaccion);
            if(datos!=null)
            {
                hoja_ruta=datos[0].get("HOJA_RUTA").toString();
                enviado_por=datos[0].get("USUARIO_SOL").toString();
                detalle=datos[0].get("DET").toString();
                preventivo=datos[0].get("COD_PREVENTIVO").toString();
                monto=datos[0].get("TOTAL").toString();
                cargo=datos[0].get("CARGO").toString();
                sol_compra=datos[0].get("SOL").toString();
            }
            else
                System.out.println("nookokokok");
            
        }catch(Exception e)
        {
            
        }
    }
    private String obtenerpartidas()
    {
        String t="";
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getPartidas1(cod_transaccion);
            if(datos!=null)
            {
                System.out.println("nro de partidas "+datos.length);
                for(int i=0;i<datos.length;i++)
                {
                    t=t+"-"+datos[i].get("PARTIDA").toString()+"-"+datos[i].get("DETALLE").toString()+", ";
                }
            }
        }catch(Exception e)
        {
            
        }
        return t;
    }
    private String total_dias()
    {
        String t="";
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getDias(cod_trans_nro);
            t=datos[0].get("DIAS").toString();
        }catch(Exception e)
        {
            
        }
        return t;
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESOLUCION MAYOR A 15 DIAS");

        jLabel2.setText("CITE:");

        jLabel5.setText("DESTINO:");

        jLabel6.setText("OBJETIVO:");

        jLabel7.setText("COTIZACION:");

        jTextField1.setToolTipText("EJEMPLO: 162/2015 ");

        jButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/accept.png"))); // NOI18N
        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/book_previous.png"))); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/printer.png"))); // NOI18N
        jButton3.setText("IMPRIMIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/action_refresh_blue.gif"))); // NOI18N
        jButton4.setText("ACTUALIZAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/disk (2).png"))); // NOI18N
        jButton5.setText("GUARDAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setText("215/2015");

        jLabel11.setText("mejoras del wifi");

        jLabel12.setText("obtener una mayor ancho de banda");

        jLabel13.setText("CS-038/15");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dias=total_dias();
        partida=obtenerpartidas();
        cite=jTextField1.getText();
        //destino=jTextField4.getText();
        //objetivo=jTextField5.getText();
        destino=jTextArea1.getText();
        objetivo=jTextArea2.getText();
        cotizacion=jTextField6.getText();
        llena_campos();
        montocompleto();
        if(cite.equals("") || destino.equals("") || objetivo.equals("") || cotizacion.equals(""))
        {
            JOptionPane.showMessageDialog(null, "todos los campos deben ser llenados");
        }
        else
        {
            try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            puerto.generaRes15(cod_transaccion,cod_trans_nro,dias,cite,destino,objetivo,cotizacion,detalle,enviado_por,cargo,gestion);
            llenadatos();
            }catch(Exception e)
            {
            
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dias=total_dias();
        partida=obtenerpartidas();
        cite=jTextField1.getText();
        /*destino=jTextField4.getText();
        objetivo=jTextField5.getText();*/
        destino=jTextArea1.getText();
        objetivo=jTextArea2.getText();
        cotizacion=jTextField6.getText();
        llena_campos();
        montocompleto();
        if(cite.equals("") || destino.equals("") || objetivo.equals("") || cotizacion.equals(""))
        {
            JOptionPane.showMessageDialog(null, "todos los campos deben ser llenados");
        }
        else
        {
            try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            puerto.updateRes15(cod_transaccion,cod_trans_nro,cite,destino,objetivo,cotizacion);
            llenadatos();
            }catch(Exception e)
            {
            
            }
        }
        habilita();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jTextField1.setEnabled(true);
        //jTextField4.setEnabled(true);
        //jTextField5.setEnabled(true);
        jTextArea1.setEnabled(true);
        jTextArea2.setEnabled(true);
        jTextField6.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dias=total_dias();
        partida=obtenerpartidas();
        cite=jTextField1.getText();
        destino=jTextArea1.getText();
        objetivo=jTextArea2.getText();
        cotizacion=jTextField6.getText();
        llena_campos();
        montocompleto();
        try{
            this.genera_res_15.reporte15(hoja_ruta,enviado_por,cargo,detalle,destino,objetivo,preventivo,monto,partida,sol_compra,cotizacion,proveedor,dias,cite,nro_res);
        }catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
