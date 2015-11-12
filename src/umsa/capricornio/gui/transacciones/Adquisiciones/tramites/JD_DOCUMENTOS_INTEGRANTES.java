/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsa.capricornio.gui.transacciones.Adquisiciones.tramites;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Map;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;

/**
 *
 * @author Henrry
 */
public class JD_DOCUMENTOS_INTEGRANTES extends javax.swing.JDialog {

    /**
     * Creates new form JD_CONTRATADO
     */
    private int cod_transaccion;
    public JD_DOCUMENTOS_INTEGRANTES(java.awt.Frame parent, boolean modal, int cod_transaccion) {
        super(parent, modal);
        initComponents();
        this.cod_transaccion = cod_transaccion;
        this.setLocationRelativeTo(null);
        CargaDocumentos_Integrantes(cod_transaccion);
    }
    private void CargaDocumentos_Integrantes(int cod_transaccion){
        try {
            
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            Map[] datos = puerto.getContratoDocumentosIntegrantes(cod_transaccion);
            if (datos != null) {
                SimpleDateFormat formatoDeFecha = new SimpleDateFormat("MM/dd/yyyy");
                System.err.println("Cargando..."+datos[0].get("NOTA_SOL_ADQ").toString());
                System.err.println("Cargando..."+formatoDeFecha.parse(datos[0].get("FECHA_HOJA_RUTA").toString()));
                
                this.JTF_NOTA_ADQ.setText(datos[0].get("NOTA_SOL_ADQ").toString());
                this.FECHA_NOTA_ADQ.setValue(formatoDeFecha.parse(datos[0].get("FECHA_NOTA_SOL_ADQ").toString()));
                
                this.JTF_CERT_PPTA.setText(datos[0].get("NRO_CERT_PPTA").toString());
                this.FECHA_CERT_PPTA.setValue(formatoDeFecha.parse(datos[0].get("FECHA_CERT_PPTA").toString()));
                
                this.JTF_RESOLUCION_INICIO.setText(datos[0].get("NRO_RES_INI").toString());
                this.FECHA_RESOLUCION_INICIO.setValue(formatoDeFecha.parse(datos[0].get("FECHA_RES_INI").toString()));
                
                this.JTF_INF_COM_CALF.setText(datos[0].get("NRO_INF_COM_CALF").toString());
                this.FECHA_INF_COM_CALF.setValue(formatoDeFecha.parse(datos[0].get("FECHA_INF_COM_CALF").toString()));
                
                this.JTF_RES_ADJ.setText(datos[0].get("NRO_RES_ADJ").toString());
                this.FECHA_RES_ADJ.setValue(formatoDeFecha.parse(datos[0].get("FECHA_RES_ADJ").toString()));
                
                this.JTF_TPGA.setText(datos[0].get("NRO_TPGA").toString());
                this.FECHA_TPGA.setValue(formatoDeFecha.parse(datos[0].get("FECHA_TPGA").toString()));
                
                this.JTF_NOTFEPUB.setText(datos[0].get("NRO_NOTFEPUB").toString());
                this.JTF_DOC_NOTFEPUB.setText(datos[0].get("DOC_NOTFEPUB").toString());
                
                this.JTF_HOJA_RUTA.setText(datos[0].get("NRO_HOJA_RUTA").toString());
                this.FECHA_HOJA_RUTA.setValue(formatoDeFecha.parse(datos[0].get("FECHA_HOJA_RUTA").toString()));
                
                this.JTF_BOLETA_GARANTIA.setText(datos[0].get("NRO_BOLETA_GARANTIA").toString());
                this.FECHA_BOLETA_GARANTIA.setValue(formatoDeFecha.parse(datos[0].get("FECHA_BOLETA_GARANTIA").toString()));
                this.JTF_EMIT_BOLETA_GARANTIA.setText(datos[0].get("EMIT_BOLETA_GARANTIA").toString());
            }
            else
                System.err.println("Vacio!!!");
        } catch (Exception e) {
            System.err.println("Error :O");          
        }
    }
    private void GuardaDocumentos_Integrantes(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            
            System.err.println("vamo a darle: "+formatoDeFecha.format(this.FECHA_NOTA_ADQ.getValue()));
            System.err.println("Vamooos: "+formatoDeFecha.format(this.FECHA_HOJA_RUTA.getValue()));
            
            Map[] datos = puerto.updateContratoDocumentosIntegrantes(cod_transaccion
                    ,this.JTF_NOTA_ADQ.getText(),formatoDeFecha.format(this.FECHA_NOTA_ADQ.getValue())
                    ,this.JTF_CERT_PPTA.getText(),formatoDeFecha.format(this.FECHA_CERT_PPTA.getValue())
                    ,this.JTF_RESOLUCION_INICIO.getText(),formatoDeFecha.format(this.FECHA_RESOLUCION_INICIO.getValue())
                    ,this.JTF_INF_COM_CALF.getText(),formatoDeFecha.format(this.FECHA_INF_COM_CALF.getValue())
                    ,this.JTF_RES_ADJ.getText(),formatoDeFecha.format(this.FECHA_RES_ADJ.getValue())
                    ,this.JTF_TPGA.getText(),formatoDeFecha.format(this.FECHA_TPGA.getValue())
                    ,this.JTF_NOTFEPUB.getText(),this.JTF_DOC_NOTFEPUB.getText()
                    ,this.JTF_HOJA_RUTA.getText(),formatoDeFecha.format(this.FECHA_HOJA_RUTA.getValue())
                    ,this.JTF_BOLETA_GARANTIA.getText(),formatoDeFecha.format(this.FECHA_BOLETA_GARANTIA.getValue())
                    ,this.JTF_EMIT_BOLETA_GARANTIA.getText()
                  
            );
            
             javax.swing.JOptionPane.showMessageDialog(this, "Se actualizo el tramite de forma exitosa!!! ", "SYSTEM CAPRICORN",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            
//            Map[] datos = puerto.updateContratoDocumentosIntegrantes(cod_transaccion
//                    ,this.JTF_NOTA_ADQ.getText(),"16/04/1991"
//                    ,this.JTF_CERT_PPTA.getText(),"13/04/1991"
//                    ,this.JTF_RESOLUCION_INICIO.getText(),"13/04/1991"
//                    ,this.JTF_INF_COM_CALF.getText(),"13/04/1991"
//                    ,this.JTF_RES_ADJ.getText(),"13/04/1991"
//                    ,this.JTF_TPGA.getText(),"13/04/1991"
//                    ,this.JTF_NOTFEPUB.getText(),this.JTF_DOC_NOTFEPUB.getText()
//                    ,this.JTF_HOJA_RUTA.getText(),"13/04/1991"
//                    ,this.JTF_BOLETA_GARANTIA.getText(),"13/04/1991"
//                    ,this.JTF_EMIT_BOLETA_GARANTIA.getText()
//                  
//            );
            
            
            
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTF_NOTA_ADQ = new javax.swing.JTextField();
        JTF_CERT_PPTA = new javax.swing.JTextField();
        JTF_RESOLUCION_INICIO = new javax.swing.JTextField();
        JTF_INF_COM_CALF = new javax.swing.JTextField();
        JTF_RES_ADJ = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        JD_GUARDAR = new javax.swing.JButton();
        JD_SALIR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JTF_TPGA = new javax.swing.JTextField();
        JTF_NOTFEPUB = new javax.swing.JTextField();
        JTF_HOJA_RUTA = new javax.swing.JTextField();
        JTF_BOLETA_GARANTIA = new javax.swing.JTextField();
        FECHA_NOTA_ADQ = new net.sf.nachocalendar.components.DateField();
        FECHA_CERT_PPTA = new net.sf.nachocalendar.components.DateField();
        FECHA_RESOLUCION_INICIO = new net.sf.nachocalendar.components.DateField();
        FECHA_INF_COM_CALF = new net.sf.nachocalendar.components.DateField();
        FECHA_RES_ADJ = new net.sf.nachocalendar.components.DateField();
        FECHA_TPGA = new net.sf.nachocalendar.components.DateField();
        FECHA_HOJA_RUTA = new net.sf.nachocalendar.components.DateField();
        FECHA_BOLETA_GARANTIA = new net.sf.nachocalendar.components.DateField();
        JTF_DOC_NOTFEPUB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JTF_EMIT_BOLETA_GARANTIA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DOCUMENTOS INTEGRANTES");

        jLabel1.setText("No. NOTA ADQUISICIONES:");

        jLabel2.setText("No. RESOLUCION INICIO:");

        jLabel3.setText("No. INF.COM.CALIFICACION:");

        jLabel4.setText("No. RESOLUCION ADJUDICACION:");

        jLabel5.setText("No. CERT.PPTA.:");

        JTF_NOTA_ADQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NOTA_ADQActionPerformed(evt);
            }
        });

        JTF_CERT_PPTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_CERT_PPTAActionPerformed(evt);
            }
        });

        JTF_RESOLUCION_INICIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_RESOLUCION_INICIOActionPerformed(evt);
            }
        });

        JTF_INF_COM_CALF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_INF_COM_CALFActionPerformed(evt);
            }
        });

        JTF_RES_ADJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_RES_ADJActionPerformed(evt);
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
                .addGap(17, 17, 17)
                .addComponent(JD_GUARDAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JD_SALIR)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JD_GUARDAR)
                    .addComponent(JD_SALIR))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel6.setText("No. TESTIMONIO DE PODER G.A.:");

        jLabel7.setText("No. NOTARIA FE PUBLICA:");

        jLabel9.setText("DR.");

        jLabel10.setText("No. HOJA DE RUTA:");

        jLabel11.setText("No. BOLETA GARANTIA:");

        JTF_TPGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_TPGAActionPerformed(evt);
            }
        });

        JTF_NOTFEPUB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NOTFEPUBActionPerformed(evt);
            }
        });

        JTF_HOJA_RUTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_HOJA_RUTAActionPerformed(evt);
            }
        });

        JTF_BOLETA_GARANTIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_BOLETA_GARANTIAActionPerformed(evt);
            }
        });

        FECHA_NOTA_ADQ.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_NOTA_ADQ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_NOTA_ADQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_NOTA_ADQKeyPressed(evt);
            }
        });

        FECHA_CERT_PPTA.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_CERT_PPTA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_CERT_PPTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_CERT_PPTAKeyPressed(evt);
            }
        });

        FECHA_RESOLUCION_INICIO.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_RESOLUCION_INICIO.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_RESOLUCION_INICIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_RESOLUCION_INICIOKeyPressed(evt);
            }
        });

        FECHA_INF_COM_CALF.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_INF_COM_CALF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_INF_COM_CALF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_INF_COM_CALFKeyPressed(evt);
            }
        });

        FECHA_RES_ADJ.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_RES_ADJ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_RES_ADJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_RES_ADJKeyPressed(evt);
            }
        });

        FECHA_TPGA.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_TPGA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_TPGA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_TPGAKeyPressed(evt);
            }
        });

        FECHA_HOJA_RUTA.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_HOJA_RUTA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_HOJA_RUTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_HOJA_RUTAKeyPressed(evt);
            }
        });

        FECHA_BOLETA_GARANTIA.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        FECHA_BOLETA_GARANTIA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA_BOLETA_GARANTIA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHA_BOLETA_GARANTIAKeyPressed(evt);
            }
        });

        JTF_DOC_NOTFEPUB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_DOC_NOTFEPUBActionPerformed(evt);
            }
        });

        jLabel12.setText("BOLETA GARANTIA EMITIDA POR:");

        JTF_EMIT_BOLETA_GARANTIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_EMIT_BOLETA_GARANTIAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JTF_NOTA_ADQ, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FECHA_NOTA_ADQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JTF_INF_COM_CALF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FECHA_INF_COM_CALF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTF_BOLETA_GARANTIA, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_HOJA_RUTA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(FECHA_HOJA_RUTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(FECHA_BOLETA_GARANTIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(JTF_EMIT_BOLETA_GARANTIA)
                            .addComponent(JTF_DOC_NOTFEPUB, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTF_NOTFEPUB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(JTF_RESOLUCION_INICIO, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_RES_ADJ)
                                    .addComponent(JTF_TPGA, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_CERT_PPTA, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(FECHA_RES_ADJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(FECHA_CERT_PPTA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(FECHA_RESOLUCION_INICIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(FECHA_TPGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(FECHA_NOTA_ADQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTF_NOTA_ADQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(JTF_CERT_PPTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(FECHA_CERT_PPTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(JTF_RESOLUCION_INICIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(FECHA_RESOLUCION_INICIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(JTF_INF_COM_CALF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(FECHA_INF_COM_CALF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(FECHA_RES_ADJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JTF_RES_ADJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel6))
                                .addComponent(FECHA_TPGA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTF_TPGA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JTF_NOTFEPUB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(JTF_DOC_NOTFEPUB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_HOJA_RUTA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FECHA_HOJA_RUTA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JTF_BOLETA_GARANTIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(FECHA_BOLETA_GARANTIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(JTF_EMIT_BOLETA_GARANTIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_NOTA_ADQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NOTA_ADQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NOTA_ADQActionPerformed

    private void JTF_CERT_PPTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_CERT_PPTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_CERT_PPTAActionPerformed

    private void JTF_RESOLUCION_INICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_RESOLUCION_INICIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_RESOLUCION_INICIOActionPerformed

    private void JTF_INF_COM_CALFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_INF_COM_CALFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_INF_COM_CALFActionPerformed

    private void JTF_RES_ADJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_RES_ADJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_RES_ADJActionPerformed

    private void JTF_TPGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_TPGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_TPGAActionPerformed

    private void JTF_NOTFEPUBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NOTFEPUBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NOTFEPUBActionPerformed

    private void JTF_HOJA_RUTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_HOJA_RUTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_HOJA_RUTAActionPerformed

    private void JTF_BOLETA_GARANTIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_BOLETA_GARANTIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_BOLETA_GARANTIAActionPerformed

    private void FECHA_NOTA_ADQKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_NOTA_ADQKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_NOTA_ADQKeyPressed

    private void FECHA_CERT_PPTAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_CERT_PPTAKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_CERT_PPTAKeyPressed

    private void FECHA_RESOLUCION_INICIOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_RESOLUCION_INICIOKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_RESOLUCION_INICIOKeyPressed

    private void FECHA_INF_COM_CALFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_INF_COM_CALFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_INF_COM_CALFKeyPressed

    private void FECHA_RES_ADJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_RES_ADJKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_RES_ADJKeyPressed

    private void FECHA_TPGAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_TPGAKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_TPGAKeyPressed

    private void FECHA_HOJA_RUTAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_HOJA_RUTAKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_HOJA_RUTAKeyPressed

    private void FECHA_BOLETA_GARANTIAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHA_BOLETA_GARANTIAKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHA_BOLETA_GARANTIAKeyPressed

    private void JTF_DOC_NOTFEPUBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_DOC_NOTFEPUBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_DOC_NOTFEPUBActionPerformed

    private void JTF_EMIT_BOLETA_GARANTIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_EMIT_BOLETA_GARANTIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_EMIT_BOLETA_GARANTIAActionPerformed

    private void JD_GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JD_GUARDARActionPerformed
        // TODO add your handling code here:
        
        GuardaDocumentos_Integrantes(this.cod_transaccion);
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
                JD_DOCUMENTOS_INTEGRANTES dialog = new JD_DOCUMENTOS_INTEGRANTES(new javax.swing.JFrame(), true,0);
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
    private net.sf.nachocalendar.components.DateField FECHA_BOLETA_GARANTIA;
    private net.sf.nachocalendar.components.DateField FECHA_CERT_PPTA;
    private net.sf.nachocalendar.components.DateField FECHA_HOJA_RUTA;
    private net.sf.nachocalendar.components.DateField FECHA_INF_COM_CALF;
    private net.sf.nachocalendar.components.DateField FECHA_NOTA_ADQ;
    private net.sf.nachocalendar.components.DateField FECHA_RESOLUCION_INICIO;
    private net.sf.nachocalendar.components.DateField FECHA_RES_ADJ;
    private net.sf.nachocalendar.components.DateField FECHA_TPGA;
    private javax.swing.JButton JD_GUARDAR;
    private javax.swing.JButton JD_SALIR;
    private javax.swing.JTextField JTF_BOLETA_GARANTIA;
    private javax.swing.JTextField JTF_CERT_PPTA;
    private javax.swing.JTextField JTF_DOC_NOTFEPUB;
    private javax.swing.JTextField JTF_EMIT_BOLETA_GARANTIA;
    private javax.swing.JTextField JTF_HOJA_RUTA;
    private javax.swing.JTextField JTF_INF_COM_CALF;
    private javax.swing.JTextField JTF_NOTA_ADQ;
    private javax.swing.JTextField JTF_NOTFEPUB;
    private javax.swing.JTextField JTF_RESOLUCION_INICIO;
    private javax.swing.JTextField JTF_RES_ADJ;
    private javax.swing.JTextField JTF_TPGA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
