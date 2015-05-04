/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.Adquisiciones.tramites;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import javax.swing.JFormattedTextField;

/**
 *
 * @author UMSA-JES
 */
public class JD_FECH_ANPE extends javax.swing.JDialog {

    /**
     * Creates new form JD_FECH_ANPE
     */
    private int cod_trans_nro, cod_transaccion;
    boolean sw_datos = true;
    public JD_FECH_ANPE(java.awt.Frame parent, boolean modal, int cod_trans_nro, int cod_transaccion) {
        super(parent, modal);
        initComponents();
//        EstiloFechaInput();
        this.cod_trans_nro = cod_trans_nro;
        this.cod_transaccion = cod_transaccion;
        LlenaFormulario();
        this.JT_CUCE.setText(getCuce());
        this.setLocationRelativeTo(null);
    }
    private void LlenaFormulario(){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos = puerto.getRestriccionFechas(cod_trans_nro);
            if (datos != null) {
                for (int f = 0; f < datos.length; f++) {
//                    System.out.println(f+" -->" + datos[f].get("COD_RES_FEC_PRO").toString());
//                    System.out.println(f+" -->" + datos[f].get("COD_TIPO_RESF").toString());
//                    System.out.println(f+" -->" + datos[f].get("FECHA_CONCLUSION").toString());
//                    System.out.println(f+" -->" + datos[f].get("LUGAR").toString());
                    
                    switch(f){
                        case 0:
                            this.Fecha1.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar1.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 1:
                            this.Fecha2.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar2.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 2:
                            this.Fecha3.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar3.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 3:
                            this.Fecha4.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar4.setText(datos[f].get("LUGAR").toString());
                            this.hora1.setText(datos[f].get("HORA_INICIO").toString());
                            //
                            break;
                        case 4:
                            this.Fecha5.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar5.setText(datos[f].get("LUGAR").toString());
                            this.hora2.setText(datos[f].get("HORA_INICIO").toString());
                            //
                            break;
                        case 5:
                            this.Fecha6.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar6.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 6:
                            this.Fecha7.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar7.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 7:
                            this.Fecha8.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar8.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 8:
                            this.Fecha9.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar9.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 9:
                            this.Fecha10.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar10.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 10:
                            this.Fecha11.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            this.JTlugar11.setText(datos[f].get("LUGAR").toString());
                            break;
                        case 11:
                            this.Fecha_GI.setValue(new Date(datos[f].get("FECHA_INICIO").toString()));
                            this.Fecha_GF.setValue(new Date(datos[f].get("FECHA_CONCLUSION").toString()));
                            break;
                    }
                            
                }
//                BloqueaInputs();
            }
            else{
                System.out.println("Vacio :0");
                this.sw_datos = false;
            }
                
            
        } catch (Exception e) {
        }
    }
    private void BloqueaInputs(){
        this.Fecha1.setEnabled(false);
        this.Fecha2.setEnabled(false);
        this.Fecha3.setEnabled(false);
        this.Fecha4.setEnabled(false);
        this.Fecha5.setEnabled(false);
        this.Fecha6.setEnabled(false);
        this.Fecha7.setEnabled(false);
        this.Fecha8.setEnabled(false);
        this.Fecha9.setEnabled(false);
        this.Fecha10.setEnabled(false);
        this.Fecha11.setEnabled(false);
        this.Fecha_GI.setEnabled(false);
        this.Fecha_GF.setEnabled(false);
        /***************************/
        this.JTlugar1.setEnabled(false);
        this.JTlugar2.setEnabled(false);
        this.JTlugar3.setEnabled(false);
        this.JTlugar4.setEnabled(false);
        this.JTlugar5.setEnabled(false);
        this.JTlugar6.setEnabled(false);
        this.JTlugar7.setEnabled(false);
        this.JTlugar8.setEnabled(false);
        this.JTlugar9.setEnabled(false);
        this.JTlugar10.setEnabled(false);
        this.JTlugar11.setEnabled(false);
        /*******************************/
        this.hora1.setEnabled(false);
        this.hora2.setEnabled(false);
        
    }
    private void DesbloqueaInputs(){
        this.Fecha1.setEnabled(true);
        this.Fecha2.setEnabled(true);
        this.Fecha3.setEnabled(true);
        this.Fecha4.setEnabled(true);
        this.Fecha5.setEnabled(true);
        this.Fecha6.setEnabled(true);
        this.Fecha7.setEnabled(true);
        this.Fecha8.setEnabled(true);
        this.Fecha9.setEnabled(true);
        this.Fecha10.setEnabled(true);
        this.Fecha11.setEnabled(true);
        this.Fecha_GI.setEnabled(true);
        this.Fecha_GF.setEnabled(true);
        /***************************/
        this.JTlugar1.setEnabled(true);
        this.JTlugar2.setEnabled(true);
        this.JTlugar3.setEnabled(true);
        this.JTlugar4.setEnabled(true);
        this.JTlugar5.setEnabled(true);
        this.JTlugar6.setEnabled(true);
        this.JTlugar7.setEnabled(true);
        this.JTlugar8.setEnabled(true);
        this.JTlugar9.setEnabled(true);
        this.JTlugar10.setEnabled(true);
        this.JTlugar11.setEnabled(true);
        /*******************************/
        this.hora1.setEnabled(true);
        this.hora2.setEnabled(true);
    }
    private void EstiloFechaInput(){
        Date hoy = new Date();
        Fecha1.setValue(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(hoy));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Fecha1 = new net.sf.nachocalendar.components.DateField();
        Fecha2 = new net.sf.nachocalendar.components.DateField();
        Fecha4 = new net.sf.nachocalendar.components.DateField();
        Fecha11 = new net.sf.nachocalendar.components.DateField();
        Fecha7 = new net.sf.nachocalendar.components.DateField();
        Fecha8 = new net.sf.nachocalendar.components.DateField();
        Fecha9 = new net.sf.nachocalendar.components.DateField();
        Fecha10 = new net.sf.nachocalendar.components.DateField();
        Fecha3 = new net.sf.nachocalendar.components.DateField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Fecha5 = new net.sf.nachocalendar.components.DateField();
        Fecha6 = new net.sf.nachocalendar.components.DateField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        JTlugar1 = new javax.swing.JTextField();
        JTlugar2 = new javax.swing.JTextField();
        JTlugar3 = new javax.swing.JTextField();
        JTlugar4 = new javax.swing.JTextField();
        JTlugar5 = new javax.swing.JTextField();
        JTlugar6 = new javax.swing.JTextField();
        JTlugar7 = new javax.swing.JTextField();
        JTlugar8 = new javax.swing.JTextField();
        JTlugar9 = new javax.swing.JTextField();
        JTlugar10 = new javax.swing.JTextField();
        JTlugar11 = new javax.swing.JTextField();
        hora2 = new javax.swing.JTextField();
        hora1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Fecha_GI = new net.sf.nachocalendar.components.DateField();
        Fecha_GF = new net.sf.nachocalendar.components.DateField();
        jLabel19 = new javax.swing.JLabel();
        JT_CUCE = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("1. Publicacion DBC SICOES y convocatoria a mesa de partes");

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("2. Consultas escritas (*)");

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("3. Reunion Informativa de Aclaracion (*)");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("6. Fecha limite de presentacion y apertura de proupuestas");

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("7. Presentacion del informe de Evaluacion y recomendacion al RPA");

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("8. Adjudicacion o Declaratoria Desierta");

        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("9. Notificacion de la adjudicacion o declaratoria desierta");

        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("10. Presentacion de documentos para la suscripcion del contrato");

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("11. Suscripcion del contrato");

        Fecha1.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha1KeyPressed(evt);
            }
        });

        Fecha2.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha2KeyPressed(evt);
            }
        });

        Fecha4.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha4KeyPressed(evt);
            }
        });

        Fecha11.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha11KeyPressed(evt);
            }
        });

        Fecha7.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha7KeyPressed(evt);
            }
        });

        Fecha8.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha8KeyPressed(evt);
            }
        });

        Fecha9.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha9KeyPressed(evt);
            }
        });

        Fecha10.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha10KeyPressed(evt);
            }
        });

        Fecha3.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha3KeyPressed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setText("--> 4. Aprobacion del DBC con las enmiendas si hubieran:");

        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("--> 5. Notificacion de aprobación del DBC:");

        Fecha5.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha5KeyPressed(evt);
            }
        });

        Fecha6.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha6KeyPressed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("ACTIVIDAD");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("FECHA");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("LUGAR");

        JTlugar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTlugar11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTlugar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTlugar11ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("HORA");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel12)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha11, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hora2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTlugar2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTlugar11, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                .addComponent(JTlugar10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTlugar1, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Fecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Fecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Fecha6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fecha7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fecha8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(Fecha9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fecha10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Fecha11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTlugar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(JTlugar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JTlugar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JTlugar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTlugar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTlugar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JTlugar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTlugar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(JTlugar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JTlugar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTlugar11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("FECHAS GARANTIA");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Fecha Inicio:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Fecha Final:");

        Fecha_GI.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha_GI.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha_GI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha_GIKeyPressed(evt);
            }
        });

        Fecha_GF.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        Fecha_GF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Fecha_GF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Fecha_GFKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("CUCE SICOES: ");

        JT_CUCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_CUCEActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton5.setText("Guardar Cuce");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(41, 41, 41)
                                .addComponent(Fecha_GF, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Fecha_GI, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JT_CUCE, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(196, 196, 196))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Fecha_GF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(Fecha_GI, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(JT_CUCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(578, 578, 578))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JTlugar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTlugar11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTlugar11ActionPerformed

    private void Fecha6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha6KeyPressed

    private void Fecha5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha5KeyPressed

    private void Fecha3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha3KeyPressed

    private void Fecha10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha10KeyPressed

    private void Fecha9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha9KeyPressed

    private void Fecha8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha8KeyPressed

    private void Fecha7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha7KeyPressed

    private void Fecha11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha11KeyPressed

    private void Fecha4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha4KeyPressed

    private void Fecha2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha2KeyPressed

    private void Fecha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //            TxtMemo.requestFocus();
        }
    }//GEN-LAST:event_Fecha1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Aqui vamos a guardar las fechas si señor");
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        //this.guarda_restriccion_fecha(cod_trans_nro, cod_trans_nro, null, null);
        
        String fecha1 = "'" + form.format(this.Fecha1.getValue()) + "'";
        String lugar1 = this.JTlugar1.getText();
        this.guarda_restriccion_fecha(1, cod_trans_nro, fecha1, lugar1);
//        System.out.println("La fecha1 es : "+fecha1+", El lugar es: "+lugar1);
        String fecha2 = "'" + form.format(this.Fecha2.getValue()) + "'";
        String lugar2 = this.JTlugar2.getText();
        this.guarda_restriccion_fecha(2, cod_trans_nro, fecha2, lugar2);
        
        String fecha3 = "'" + form.format(this.Fecha3.getValue()) + "'";
        String lugar3 = this.JTlugar3.getText();
        this.guarda_restriccion_fecha(3, cod_trans_nro, fecha3, lugar3);
        
        String fecha4 = "'" + form.format(this.Fecha4.getValue()) + "'";
        String lugar4 = this.JTlugar4.getText();
        String hora1 = this.hora1.getText();
        this.guarda_restriccion_fecha3(4, cod_trans_nro,fecha4, lugar4, hora1);
        
        String fecha5 = "'" + form.format(this.Fecha5.getValue()) + "'";
        String lugar5 = this.JTlugar5.getText();
        String hora2 = this.hora2.getText();
        this.guarda_restriccion_fecha3(5, cod_trans_nro,fecha5, lugar5, hora2);
        
        String fecha6 = "'" + form.format(this.Fecha6.getValue()) + "'";
        String lugar6 = this.JTlugar6.getText();
        this.guarda_restriccion_fecha(6, cod_trans_nro, fecha6, lugar6);
        
        String fecha7 = "'" + form.format(this.Fecha7.getValue()) + "'";
        String lugar7 = this.JTlugar7.getText();
        this.guarda_restriccion_fecha(7, cod_trans_nro, fecha7, lugar7);
        
        String fecha8 = "'" + form.format(this.Fecha8.getValue()) + "'";
        String lugar8 = this.JTlugar8.getText();
        this.guarda_restriccion_fecha(8, cod_trans_nro, fecha8, lugar8);
        
        String fecha9 = "'" + form.format(this.Fecha9.getValue()) + "'";
        String lugar9 = this.JTlugar9.getText();
        this.guarda_restriccion_fecha(9, cod_trans_nro, fecha9, lugar9);
        
        String fecha10 = "'" + form.format(this.Fecha10.getValue()) + "'";
        String lugar10 = this.JTlugar10.getText();
        this.guarda_restriccion_fecha(10, cod_trans_nro, fecha10, lugar10);
        
        String fecha11 = "'" + form.format(this.Fecha11.getValue()) + "'";
        String lugar11 = this.JTlugar11.getText();
        this.guarda_restriccion_fecha(11, cod_trans_nro, fecha11, lugar11);
        
        
        String fecha_GI = "'" + form.format(this.Fecha_GI.getValue()) + "'";
        String fecha_GF = "'" + form.format(this.Fecha_GF.getValue()) + "'";
        this.guarda_restriccion_fecha2(12, cod_trans_nro, fecha_GI,fecha_GF, "","");
        
        javax.swing.JOptionPane.showMessageDialog(this, "Las restricciones de tiempo se adicionaron correctamente", 
               "SYSTEM CAPRICORN",javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        BloqueaInputs();
//        String fec_ing = "'" + form.format(CalFechaIng.getValue()) + "'";
//        System.out.println("La fecha1 es : "+fecha1+", El lugar es: "+lugar1);
//        System.out.println("La fecha2 es : "+fecha2+", El lugar es: "+lugar2);
//        System.out.println("La fecha3 es : "+fecha3+", El lugar es: "+lugar3);
//        System.out.println("La fecha4 es : "+fecha4+", El lugar es: "+lugar4);
//        System.out.println("La fecha5 es : "+fecha5+", El lugar es: "+lugar5);
//        System.out.println("La fecha6 es : "+fecha6+", El lugar es: "+lugar6);
//        System.out.println("La fecha7 es : "+fecha7+", El lugar es: "+lugar7);
//        System.out.println("La fecha8 es : "+fecha8+", El lugar es: "+lugar8);
//        System.out.println("La fecha9 es : "+fecha9+", El lugar es: "+lugar9);
//        System.out.println("La fecha10 es : "+fecha10+", El lugar es: "+lugar10);
//        System.out.println("La fecha11 es : "+fecha11+", El lugar es: "+lugar11);
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Fecha_GIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha_GIKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha_GIKeyPressed

    private void Fecha_GFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fecha_GFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha_GFKeyPressed

    private void JT_CUCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_CUCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_CUCEActionPerformed

    private void guardaCuceSicoes(String cuce_sicoes){
        System.out.println("El cuce seria: "+cuce_sicoes);
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            puerto.addCuceSicoes("SET-addCuceSicoes", cod_transaccion, cuce_sicoes);
        } catch (Exception e) {
        }
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        guardaCuceSicoes(this.JT_CUCE.getText().trim());
    }//GEN-LAST:event_jButton5ActionPerformed

    private String getCuce(){
        String cuce_sicoes = "";
//        System.out.println("el cod_transaccion: "+cod_transaccion);
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos = puerto.getCuceSicoes(cod_transaccion);
            if(datos != null){
//                System.out.println("--> "+datos[0].get("CUCE_SICOES").toString());
                cuce_sicoes = datos[0].get("CUCE_SICOES").toString();
            }else{
//                System.out.println("Vacio ...");
            }
          
        } catch (Exception e) {
        }
        return cuce_sicoes;
    }    
    /**
     * @param args the command line arguments
     */
    private void guarda_restriccion_fecha(int cod_tipo_resf,int cod_trans_nro , String fecha_final, String lugar){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            puerto.addFechaRestriccion("SET-addFechaRestriccion", cod_tipo_resf, cod_trans_nro, fecha_final, lugar);
            System.out.println("Exito Wujuuuuuuuuu");
        } catch (Exception e) {
            System.out.println("Error en el servidor ..... :(");
        }
    }
    private void guarda_restriccion_fecha3(int cod_tipo_resf,int cod_trans_nro , String fecha_final, String lugar,String hora_inicio){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            puerto.addFechaRestriccion3("SET-addFechaRestriccion", cod_tipo_resf, cod_trans_nro, fecha_final, lugar, hora_inicio);
            System.out.println("Exito Wujuuuuuuuuu");
        } catch (Exception e) {
            System.out.println("Error en el servidor ..... :(");
        }
    }
     private void guarda_restriccion_fecha2(int cod_tipo_resf,int cod_trans_nro , String fecha_inicio ,String fecha_final, String lugar, String hora){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            puerto.addFechaRestriccion2("SET-addFechaRestriccion", cod_tipo_resf, cod_trans_nro, fecha_inicio,fecha_final, lugar,hora);
            System.out.println("Exito Wujuuuuuuuuu");
        } catch (Exception e) {
            System.out.println("Error en el servidor ..... :(");
        }
    }
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
            java.util.logging.Logger.getLogger(JD_FECH_ANPE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_FECH_ANPE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_FECH_ANPE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_FECH_ANPE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_FECH_ANPE dialog = new JD_FECH_ANPE(new javax.swing.JFrame(), true,0,0);
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
    private net.sf.nachocalendar.components.DateField Fecha1;
    private net.sf.nachocalendar.components.DateField Fecha10;
    private net.sf.nachocalendar.components.DateField Fecha11;
    private net.sf.nachocalendar.components.DateField Fecha2;
    private net.sf.nachocalendar.components.DateField Fecha3;
    private net.sf.nachocalendar.components.DateField Fecha4;
    private net.sf.nachocalendar.components.DateField Fecha5;
    private net.sf.nachocalendar.components.DateField Fecha6;
    private net.sf.nachocalendar.components.DateField Fecha7;
    private net.sf.nachocalendar.components.DateField Fecha8;
    private net.sf.nachocalendar.components.DateField Fecha9;
    private net.sf.nachocalendar.components.DateField Fecha_GF;
    private net.sf.nachocalendar.components.DateField Fecha_GI;
    private javax.swing.JTextField JT_CUCE;
    private javax.swing.JTextField JTlugar1;
    private javax.swing.JTextField JTlugar10;
    private javax.swing.JTextField JTlugar11;
    private javax.swing.JTextField JTlugar2;
    private javax.swing.JTextField JTlugar3;
    private javax.swing.JTextField JTlugar4;
    private javax.swing.JTextField JTlugar5;
    private javax.swing.JTextField JTlugar6;
    private javax.swing.JTextField JTlugar7;
    private javax.swing.JTextField JTlugar8;
    private javax.swing.JTextField JTlugar9;
    private javax.swing.JTextField hora1;
    private javax.swing.JTextField hora2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
