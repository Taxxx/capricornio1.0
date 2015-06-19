/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmReportesAlmacen.java
 *
 * Created on 24-11-2011, 06:28:20 PM
 */
package umsa.capricornio.gui.Almacen;

import umsa.capricornio.gui.Juridica.*;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import umsa.capricornio.domain.Transaccion;
import umsa.capricornio.gui.Almacen.reportes.RepDocsEnviados;
import umsa.capricornio.gui.Almacen.reportes.RepIngresoMatPeriodico;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.gui.menu.FrmMenu;
import umsa.capricornio.gui.transacciones.Adquisiciones.tramites.JD_Reporte1;
import umsa.capricornio.utilitarios.herramientas.i_formatterDate;

/**
 *
 * @author julian
 */
public class FrmReportesItems extends javax.swing.JInternalFrame {

    FrmMenu menu;
    private Runtime r;
    /** Creates new form FrmReportesAlmacen */
    public FrmReportesItems(FrmMenu menu) {
        this.menu=menu;
        initComponents();
    }

    void MostrarReporteIngMaterial(){
        List list=new ArrayList();        
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getReporteIngMaterialesAlmacen(DatFec_ini.getValue().toString(),DatFec_fin.getValue().toString(),2011);            
            if (datos!=null){                 
                Map map = new HashMap();
                for (int f=0;f<datos.length;f++){
                    Transaccion trans = new Transaccion();
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_ENVIO").toString()));
                    trans.setUnidad_sol(datos[f].get("DE").toString());
                    trans.setUnidad_medida(datos[f].get("UNIDAD_MEDIDA").toString());
                    trans.setCantidad_pedido(Integer.parseInt(datos[f].get("CANTIDAD_PEDIDO").toString()));
                    trans.setNro_ingreso(Integer.parseInt(datos[f].get("NRO").toString()));
                    trans.setCbte(datos[f].get("CBTE").toString());
                    trans.setMemo(datos[f].get("MEMO").toString());
                    trans.setNro_orden_compra(Integer.parseInt(datos[f].get("NRO_ORDEN").toString()));
                    trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
                    trans.setEstado(datos[f].get("ESTADO").toString());
                    list.add(trans);
                } 
                RepIngresoMatPeriodico rep = new RepIngresoMatPeriodico();
                rep.Reporte(list);
            }                         
        }
        catch (RemoteException e){
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println(e);} 
        catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this,"DEBE ELEJIR UNA FILA PARA PODER IMPRIMIR EL REPORTE","SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }  
    }
        
    void MostrarReporteEnvioDocs(){
        List list=new ArrayList();        
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getReporteDocsEnviados(DatFec_ini.getValue().toString(),DatFec_fin.getValue().toString(),2011);            
            if (datos!=null){                 
                Map map = new HashMap();
                for (int f=0;f<datos.length;f++){
                    Transaccion trans = new Transaccion();
                    //t1.estado,t1.fecha_envio,t8.articulo,t2.cantidad_pedido,t2.precio_unit ,t4.nro,t4.memo,T5.DE,t5.cbte,t5.hoja_ruta, t6.casa_comercial
                    trans.setEstado(datos[f].get("ESTADO").toString());
                    trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_ENVIO").toString()));
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setCantidad_pedido(Integer.parseInt(datos[f].get("CANTIDAD_PEDIDO").toString()));
                    trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
                    trans.setNro_ingreso(Integer.parseInt(datos[f].get("NRO").toString()));
                    trans.setMemo(datos[f].get("MEMO").toString());
                    trans.setUnidad_sol(datos[f].get("DE").toString());
                    trans.setCbte(datos[f].get("CBTE").toString());
                    trans.setHoja_ruta(datos[f].get("HOJA_RUTA").toString());
                    trans.setCasa_comercial(datos[f].get("CASA_COMERCIAL").toString());
                    list.add(trans);
                } 
                RepDocsEnviados rep = new RepDocsEnviados();
                rep.Reporte(list);
            }                         
        }
        catch (RemoteException e){
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println(e);} 
        catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this,"DEBE ELEJIR UNA FILA PARA PODER IMPRIMIR EL REPORTE","SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }  
    }
        
    void CerrarFrame(){
        menu.CerrarFrameInterno(this);
        System.gc();
        r = Runtime.getRuntime();
        long mem1 = r.freeMemory();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGrpReporte = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        DatFec_ini = new net.sf.nachocalendar.components.DateField();
        jLabel2 = new javax.swing.JLabel();
        DatFec_fin = new net.sf.nachocalendar.components.DateField();
        BtnSalir = new javax.swing.JButton();
        BtnReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Rad1 = new javax.swing.JRadioButton();
        Rad2 = new javax.swing.JRadioButton();

        setTitle("Reportes Boletas de Garantia");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Del :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 70, 20);

        DatFec_ini.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        DatFec_ini.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(DatFec_ini);
        DatFec_ini.setBounds(110, 20, 100, 18);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Al :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 20, 70, 20);

        DatFec_fin.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        DatFec_fin.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(DatFec_fin);
        DatFec_fin.setBounds(280, 20, 100, 18);

        BtnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSalir);
        BtnSalir.setBounds(240, 160, 150, 23);

        BtnReporte.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnReporte.setText("Ver Reporte");
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(BtnReporte);
        BtnReporte.setBounds(60, 160, 150, 23);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        Rad1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        Rad1.setText("Usuarios - Items");
        jPanel2.add(Rad1);
        Rad1.setBounds(30, 20, 150, 23);

        Rad2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        Rad2.setText("Items - Usuarios");
        jPanel2.add(Rad2);
        Rad2.setBounds(210, 20, 117, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 60, 390, 70);

        setBounds(0, 0, 481, 239);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        CerrarFrame();
    }//GEN-LAST:event_BtnSalirActionPerformed

    void mostrarreporteya(String e,int ts,Date fi,Date ff)
    {
        if(fi.toString().equals(ff.toString()))
            {
                //fi.setDate(fi.getDate()-1);
                ff.setDate(ff.getDate()+1);
                System.out.println(fi);
                System.out.println(ff);
                //JOptionPane.showMessageDialog(this, "Las fechas deben ser diferentes aun si es de un dia");
                
            }
            else
            {
                System.out.println("no muestra"+fi);
                //mostrarreporteya(e,ts,fi,ff);
            }
        URL urlMaestro,urlMaestro1,urlMaestro2;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");            
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@200.7.160.25:1521:ADQUI", "ADQUISICIONES", "4dqu1_c3n72al");
            JD_Reporte1 t1 = new JD_Reporte1();
            Map parameters = new HashMap();
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra.jasper");
            urlMaestro1 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra2.jasper");
            urlMaestro2 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra3.jasper");
            parameters.put("ESTADO",e);
            parameters.put("TIPO_SOL",ts);
            parameters.put("FECHA_INICIO",fi);
            parameters.put("FECHA_FINAL",ff);
            parameters.put("DIR", urlMaestro1.toString());
            parameters.put("DIR1", urlMaestro2.toString());
            JasperReport reporte = (JasperReport) JRLoader.loadObject(urlMaestro); 
            System.out.println("realizo el jasper reporte");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters, conexion);
            System.out.println("realizo el jasper print");
            JasperViewer.viewReport(jasperPrint, false);  
            System.out.println("realizo el jasper view");
            
        } catch (Exception ec) {
            System.out.println("Error Gravichimo: "+ec);
        }
    }
    
    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed

        if(Rad1.isSelected())
            MostrarReporteItems(1);
        if(Rad2.isSelected())
            MostrarReporteItems(2);
        
        
        //JD_Reporte1 r = new JD_Reporte1(this.menu,false,e,ts,fi,ff);
        //r.setVisible(true);
    }//GEN-LAST:event_BtnReporteActionPerformed

    private void MostrarReporteItems(int cod_tipo_reporte){
        URL urlMaestro,urlImage,urlMaestro2;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");            
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@200.7.160.25:1521:ADQUI", "ADQUISICIONES", "4dqu1_c3n72al");
            JD_Reporte1 t1 = new JD_Reporte1();
            Map parameters = new HashMap();
            
            if(cod_tipo_reporte==1)
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteItems3.jasper");
            else
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteItems4.jasper");
            
            urlImage=t1.getClass().getResource("/umsa/capricornio/gui/images/umsa.jpg");
//            urlMaestro1 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra2.jasper");
//            urlMaestro2 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra3.jasper");
            parameters.put("imagen",urlImage.toString());
//            parameters.put("TIPO_SOL",ts);
//            parameters.put("FECHA_INICIO",fi);
//            parameters.put("FECHA_FINAL",ff);
//            parameters.put("DIR", urlMaestro1.toString());
//            parameters.put("DIR1", urlMaestro2.toString());
            JasperReport reporte = (JasperReport) JRLoader.loadObject(urlMaestro); 
            System.out.println("realizo el jasper reporte");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters, conexion);
            System.out.println("realizo el jasper print");
            JasperViewer.viewReport(jasperPrint, false);  
            System.out.println("realizo el jasper view");
            
        } catch (Exception ec) {
            System.out.println("Error Gravichimo: "+ec);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGrpReporte;
    private javax.swing.JButton BtnReporte;
    private javax.swing.JButton BtnSalir;
    private net.sf.nachocalendar.components.DateField DatFec_fin;
    private net.sf.nachocalendar.components.DateField DatFec_ini;
    private javax.swing.JRadioButton Rad1;
    private javax.swing.JRadioButton Rad2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
