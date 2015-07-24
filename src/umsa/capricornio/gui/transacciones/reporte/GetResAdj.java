/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.reporte;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import umsa.capricornio.domain.Transaccion;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.utilitarios.herramientas.NumerosTextuales;

/**
 *
 * @author UMSA-JES
 */
public class GetResAdj {
    
    URL urlMaestro,urlImage,urlMaestro1,urlMaestro2,urlMaestro3,urlMaestro4,urlMaestro5;
    String dir_daf;
    public GetResAdj(){
        this.genera();
    }
    public void imprimePDF(URL url,Map parameters){
        JasperReport masterReport = null;
        try { masterReport = (JasperReport) JRLoader.loadObject(url);} 
        catch (JRException e) 
            { System.out.println("Error cargando el reporte maestro: " + e.getMessage());
              System.exit(3);
            }
        
        //parameters.put("imagen",urlImage.toString());
        //parameters.put("titulo",titulo);        

        JasperPrint masterPrint = null;
        try {
            System.out.println("Esta vivo weon¡!¡"+masterReport);
            masterPrint = JasperFillManager.fillReport(masterReport, parameters, new JREmptyDataSource());
        }
        catch (JRException e) {
        System.out.println("error nq "+e);
        }  
        System.out.println("el error debe estar por aqui---- "+masterPrint+" --sdfsd-- "+masterReport);
        JasperViewer.viewReport(masterPrint, false);
    }
    public void imprimePDF2(URL url,Map parameters){
        JasperReport masterReport = null;
        Connection conexion=null;
        try { 
            try {            
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                System.out.println("esto es un error");
                JOptionPane.showMessageDialog( null, "esto"+ex.getMessage());
                Logger.getLogger(GetResAdj.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conexion = DriverManager.getConnection("jdbc:oracle:thin:@200.7.160.25:1521:ADQUI", "ADQUISICIONES", "4dqu1_c3n72al");
            } catch (SQLException ex) {
                System.out.println("esto es un error1");
                JOptionPane.showMessageDialog( null, "esto1"+ex.getMessage());
                Logger.getLogger(GetResAdj.class.getName()).log(Level.SEVERE, null, ex);
            }
            masterReport = (JasperReport) JRLoader.loadObject(url);} 
        catch (JRException e) 
            { System.out.println("Error cargando el reporte maestro: " + e.getMessage());
              JOptionPane.showMessageDialog( null, "esto2"+e.getMessage());
              System.exit(3);
            }
        
        //parameters.put("imagen",urlImage.toString());
        //parameters.put("titulo",titulo);        

        JasperPrint masterPrint = null;
        try {
            System.out.println("Esta vivo weon¡!¡"+masterReport);
            masterPrint = JasperFillManager.fillReport(masterReport, parameters, conexion);
        }
        catch (JRException e) {
            JOptionPane.showMessageDialog( null, e.getMessage());
            System.out.println("el error debe estar "+ e.getMessage());
        }  
        //System.out.println("el error debe estar por aqui:---- "+masterPrint+" --sdfsd-- "+masterReport);
        JasperViewer.viewReport(masterPrint, false);
    }
    public void genera(){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            //dir_daf = puerto.getDatoGeneral("DIR_DAF");
            dir_daf = puerto.getDatoGeneral("DIR_DAF");
            
            System.out.println("DIR_DAF: "+dir_daf);
        } catch (Exception e) {
            System.out.println("Gravichimo error: "+e);
        }
    }
    public void reporteppto(Date fi,Date ff,int cod_user,int estado)
    {
        Map parameters = new HashMap();
        parameters.put("FECHA_INICIO", fi);
        parameters.put("FECHA_FINAL", ff);
        parameters.put("COD_USER", cod_user);
        parameters.put("ESTADO", estado);        
        RepTransaccion t1 = new RepTransaccion();
    }
    
    public void ReporteUnidad(Date fi,Date ff,int cod_user,int cod_rol)
    {
        Map parameters = new HashMap();
        parameters.put("FECHA_INICIO", fi);
        parameters.put("FECHA_FINAL", ff);
        //int x=18;
        parameters.put("COD_USER", cod_user);
        RepTransaccion t1 = new RepTransaccion();
        if(cod_rol==2)
        {
           urlMaestro2 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompraSA.jasper");
           urlMaestro4 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompraCA.jasper");
           urlMaestro5 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra3.jasper");
           parameters.put("DIR1", urlMaestro2.toString());
           parameters.put("DIR2", urlMaestro4.toString());
           parameters.put("DIR5", urlMaestro5.toString());
           System.out.println("jaja");
        }
        else{
        urlMaestro1 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra.jasper");
        urlMaestro2 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompraS.jasper");
        urlMaestro3 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompraO.jasper");
        urlMaestro4 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompraC.jasper");
        urlMaestro5 = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompra3.jasper");
        parameters.put("DIR1", urlMaestro1.toString());
        parameters.put("DIR2", urlMaestro2.toString());
        parameters.put("DIR3", urlMaestro3.toString());
        parameters.put("DIR4", urlMaestro4.toString());
        parameters.put("DIR5", urlMaestro5.toString());      
        System.out.println("jaja2");
        }
        urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReporteCompraP.jasper");
        this.imprimePDF2(urlMaestro, parameters);
    }
    
    public void invitacion(int cod_w,String nota,String detalle,String destino,String nro_propuesta,String fecha,String fecha_reunion,String jefe_adq,String nombre,String casa,String metodo)
    {
        Map parameters = new HashMap();
        parameters.put("NOTA", nota);
        parameters.put("DETALLE", detalle);
        parameters.put("NRO_PROPUESTA", nro_propuesta);
        parameters.put("DESTINO", destino);
        parameters.put("FECHA", fecha);
        parameters.put("JEFE_ADQ", jefe_adq);
        parameters.put("METODO", metodo);
        if(cod_w==4)
        {
            parameters.put("FECHA_REUNION", fecha_reunion);
        }
        if(casa.equals("Sin Nombre Comercial"))
        {
            parameters.put("INVITADO", nombre);
        }
        else
        {
            parameters.put("INVITADO", casa);
        }
        RepTransaccion t1 = new RepTransaccion();
        if(cod_w==1)
        {
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/invitacionBien.jasper");
        }
        if(cod_w==6)
        {
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/invitacionServ.jasper");
        }
        if(cod_w==3)
        {
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/invitacionCons.jasper");
        }
        if(cod_w==4)
        {
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/invitacionObra.jasper");
        }
        
        this.imprimePDF(urlMaestro, parameters);
        
    }
    public void reporte15(String hr,String ep,String c,String det,String dest,String obj,String prev,String m,String part,String sc,String cot,String prov,String dias,String cite,String nro_res,int estado,String doc,String fec_ini)
    {
        Map parameters = new HashMap();
        parameters.put("HOJA_RUTA", hr);
        parameters.put("ENVIADO_POR", ep);
        parameters.put("CARGO", c);
        parameters.put("DETALLE", det);
        parameters.put("DESTINO", dest);
        parameters.put("OBJETIVO", obj);
        parameters.put("PREVENTIVO", prev);
        parameters.put("MONTO", m);
        parameters.put("PARTIDA", part);
        parameters.put("SOL_COMPRA", sc);
        parameters.put("COTIZACION", cot);
        parameters.put("PROVEEDOR", prov);
        parameters.put("DIAS", dias);
        parameters.put("CITE", cite);
        parameters.put("NRO_RES", nro_res);
        parameters.put("DIR_DAF", this.dir_daf);
        parameters.put("ESTADO", estado);
        parameters.put("DOCUMENTOS", doc);
        parameters.put("FECHA", fec_ini);
        RepTransaccion t1 = new RepTransaccion(); 
        urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReportMay15Cons.jasper");
        this.imprimePDF(urlMaestro, parameters);
    }
    public void ReporteAdjServ(String det_adc,String res_adm,String fecha_cc,String inf_div_adq,String proveedor,String detalle,String num_resol,String det_conc_prop,String modo_eval,String destino,String cargo,String actividad,String prop_proveedor,String proponentes, String cuce, String monto){
        Map parameters = new HashMap();
        
        //parameters.put("num_res_adm", res_adm);
        parameters.put("INF-TEC", det_adc);
        parameters.put("num_res_adm", res_adm);
        //parameters.put("adc", det_adc);
        parameters.put("fecha_calificacion", fecha_cc);
        parameters.put("inf_div_adqui", inf_div_adq);
        parameters.put("proveedor", proveedor);
        parameters.put("detalle", detalle);
        parameters.put("num_resol", num_resol);
        
        parameters.put("det_conc_prop", det_conc_prop);
        parameters.put("modo_eval", modo_eval);
        parameters.put("destino", destino);
        parameters.put("cargo", cargo);
        parameters.put("actividad", actividad);
        parameters.put("prop_proveedor", prop_proveedor);
        parameters.put("proponentes", proponentes);
        parameters.put("DIR_DAF", this.dir_daf);
        parameters.put("CUCE", cuce);
        System.out.println(cuce+"   sdfjsdfoisdjfoisjdoifjds");
        parameters.put("MONTO", monto);
        
        RepTransaccion t1 = new RepTransaccion(); 
        urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjServ.jasper");
        this.imprimePDF(urlMaestro, parameters);
    }
    public void ReporteAdjBien(String res_adm,String fecha_cc,String inf_div_adq,String proveedor,String detalle,String num_resol,String det_conc_prop,String modo_eval,String destino,String cargo,String actividad,String prop_proveedor,String proponentes, String cuce, String monto, String adc){
        Map parameters = new HashMap();
        
        parameters.put("num_res_adm", res_adm);
        parameters.put("inf_tec", adc);
        parameters.put("fecha_calificacion", fecha_cc);
        parameters.put("inf_div_adqui", inf_div_adq);
        parameters.put("proveedor", proveedor);
        parameters.put("detalle", detalle);
        parameters.put("num_resol", num_resol);
        
        parameters.put("det_conc_prop", det_conc_prop);
        parameters.put("modo_eval", modo_eval);
        parameters.put("destino", destino);
        parameters.put("cargo", cargo);
        parameters.put("actividad", actividad);
        parameters.put("prop_proveedor", prop_proveedor);
        parameters.put("proponentes", proponentes);
        parameters.put("DIR_DAF", this.dir_daf);
        parameters.put("CUCE", cuce);
        System.out.println(cuce+"   sdfjsdfoisdjfoisjdoifjds");
        parameters.put("MONTO", monto);
        
        
        RepTransaccion t1 = new RepTransaccion(); 
        urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjBien.jasper");
        this.imprimePDF(urlMaestro, parameters);
    }
    
    public void ReporteAdjObra(String res_adm,String fecha_cc,String inf_div_adq,String proveedor,String detalle,String num_resol,String det_conc_prop,String modo_eval,String destino,String cargo,String actividad,String prop_proveedor,String proponentes, String cuce, String monto,String adc,String a,String b,int cod,int total){
        Map parameters = new HashMap();
        parameters.put("cod", cod);
        parameters.put("num_res_adm", res_adm);
        parameters.put("INF_TEC", adc);
        parameters.put("emitido_por", actividad);
        parameters.put("fecha_calificacion", fecha_cc);
        parameters.put("inf_div_adqui", inf_div_adq);
        parameters.put("proveedor", proveedor);
        parameters.put("detalle", detalle);
        parameters.put("num_resol", num_resol);
        
        parameters.put("det_conc_prop", det_conc_prop);
        parameters.put("modo_eval", modo_eval);
        //parameters.put("fila", a);
        parameters.put("cargo", cargo);
        //parameters.put("cumple", b);
        parameters.put("prop_proveedor", prop_proveedor);
        parameters.put("proponentes", proponentes);
        parameters.put("DIR_DAF", this.dir_daf);
        parameters.put("CUCE", cuce);
        
        //parameters.put("total",total);
        System.out.println(cuce+"   sdfjsdfoisdjfoisjdoifjds");
        parameters.put("MONTO", monto);
        System.out.println(cod);
        System.out.println(res_adm);
        System.out.println(adc);
        System.out.println(actividad);
        System.out.println(fecha_cc);
        System.out.println(inf_div_adq);
        System.out.println(proveedor);
        System.out.println(detalle);
        System.out.println(num_resol);
        System.out.println(det_conc_prop);
        System.out.println(modo_eval);
        System.out.println(cargo);
        System.out.println(prop_proveedor);
        System.out.println(proponentes);
        System.out.println(cuce);
        RepTransaccion t1 = new RepTransaccion(); 
        urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjObra.jasper");
        urlMaestro1 = t1.getClass().getResource("/umsa/capricornio/gui/reports/RO2.jasper");
        urlMaestro2 = t1.getClass().getResource("/umsa/capricornio/gui/reports/report2.jasper");
        urlMaestro3 = t1.getClass().getResource("/umsa/capricornio/gui/reports/report3.jasper");
        /*String path = urlMaestro1.getPath();
        File temp=null,temp1=null,file=null;
        try{
        file = new File("C:\\Users\\javieralex\\Documents\\tempcapri");
        file.mkdirs();
        file.setWritable(true);
        String archivo = file.getCanonicalPath() + "\\RO2.jasper";
        String archivo1 = file.getCanonicalPath() + "\\report2.jasper";
        temp = new File(archivo);
        temp1 = new File(archivo1);
        InputStream is = this.getClass().getResourceAsStream("/umsa/capricornio/gui/reports/RO2.jasper");
        FileOutputStream archivoDestino = new FileOutputStream(temp);
        FileWriter fw = new FileWriter(temp);
        byte[] buffer = new byte[512*1024];
        int nbLectura;
            while ((nbLectura = is.read(buffer)) != -1)
                archivoDestino.write(buffer, 0, nbLectura);
            //cierras el archivo,el inputS y el FileW
            fw.close();
            archivoDestino.close();
            is.close();
        
        }
        catch(Exception e){System.out.println("Problema abriendo el pdf de erfc");}
        try{
            String archivo1 = file.getCanonicalPath() + "\\report2.jasper";
            temp1 = new File(archivo1);
            InputStream is1 = this.getClass().getResourceAsStream("/umsa/capricornio/gui/reports/report2.jasper");
            FileOutputStream archivoDestino1 = new FileOutputStream(temp1);
            FileWriter fw1 = new FileWriter(temp1);
            byte[] buffer1 = new byte[512*1024];
            int nbLectura1;
            while ((nbLectura1 = is1.read(buffer1)) != -1)
                archivoDestino1.write(buffer1, 0, nbLectura1);    
            fw1.close();
            archivoDestino1.close();
            is1.close();
        }catch(Exception e){
        
        }
        System.out.println(temp.getPath()+" orale!!!!");
        System.out.println(temp1.getPath()+" orale!!!!");
        System.out.println(file.getAbsolutePath()+" orales!!!!");*/
        //JOptionPane.showMessageDialog( null, file.getPath());
        //file = file.getAbsoluteFile();
        //ServletContext scontext = (ServletContext)context.getExternalContext().getContext(); 
        //parameters.put("SUBREPORT_DIR", scontext.getRealPath("CAMINHODODIRETORIORELATIVOAQUI/")+"/"); 
        //System.out.println("muestra amigo "+System.getProperty("user.dir")+"\\umsa\\capricornio\\gui\\reports"); 
        parameters.put("DIR", urlMaestro3.toString());
        parameters.put("DIR1", urlMaestro1.toString());
        parameters.put("DIR2", urlMaestro2.toString());
        this.imprimePDF2(urlMaestro, parameters);
        System.out.println(cuce+"   sdfjsdfoisdjfoisjdoifjds");
    }
    
    public void ReporteAdjConsul(String res_adm,String fecha_cc,String inf_div_adq,String proveedor,String detalle,String num_resol,String det_conc_prop,String modo_eval,String destino,String cargo,String actividad,String prop_proveedor,String proponentes, String cuce, String monto){
        Map parameters = new HashMap();
        
        parameters.put("ResAdm", res_adm);
        //parameters.put("adc", det_adc);
        parameters.put("FechaComisionCalf", fecha_cc);
        parameters.put("InfAdq", inf_div_adq);
        parameters.put("Profesional", proveedor);
        parameters.put("Titulo_trans", detalle);
        parameters.put("Num_Resol", num_resol);
        
        parameters.put("ADCAnpe", det_conc_prop);
        parameters.put("InfHP", modo_eval);
        parameters.put("Destino", destino);
        parameters.put("CARGO", cargo);
        parameters.put("NotasAdqInv", actividad);
        //parameters.put("prop_proveedor", prop_proveedor);
        //parameters.put("proponentes", proponentes);
        parameters.put("DIR_DAF", this.dir_daf);
        parameters.put("CUCE", cuce);
        System.out.println(cuce+"   sdfjsdfoisdjfoisjdoifjds");
        parameters.put("MONTO", monto);
        
        
        RepTransaccion t1 = new RepTransaccion(); 
        urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjCons.jasper");
        this.imprimePDF(urlMaestro, parameters);
    }
    public void Reporte (String ResAdm,String Num_Resol, String Titulo_trans, String NotasAdqInv, String ADCAnpe, String Convocatoria, String FechaComisionCalf, String InfAdq, String InfHP, String Profesional, String Destino, String Actividad,int cod_trans_nro, int cod_w)
    {
        Transaccion trans = new Transaccion();
        trans.setDetalle("Transporte y deposito de remesas de las cajas del Departamento de Tesoro Universitario");
        
        //System.out.println("Probando --> "+prueba);
        RepTransaccion t1 = new RepTransaccion(); 
        Map parameters = new HashMap();
        
        /*
        parameters.put("Num_Resol", "60/2014");
        parameters.put("Titulo_trans", "Consultor(a) por Producto en redes inalámbricas para realizar el desarrollo y mantenimiento de las soluciones WIFI de la UMSA");
        parameters.put("ResAdm", "53/14");
        parameters.put("NotasAdqInv", "Nº384, 385 y 386/14");
        parameters.put("Convocatoria", "Primera");
        parameters.put("FechaComisionCalf", "fecha 14 de febrero");
        parameters.put("InfAdq", "15/14");
        parameters.put("InfHP", "31/14");
        parameters.put("Profesional", "Ing. Oscar Sergio Blass Chambi");
        parameters.put("Destino", "Departamento de Tecnologías de Información y Comunicación");
        parameters.put("Actividad", "Fortalecimiento del WIFI UMSA del Programa del Sistema UMSATIC I, TGN – Coparticipación Tributaria");
        */
        parameters.put("Num_Resol", Num_Resol);
        parameters.put("Titulo_trans", Titulo_trans);
        parameters.put("ResAdm", ResAdm);
        parameters.put("NotasAdqInv", NotasAdqInv);
        parameters.put("ADCAnpe", ADCAnpe);
        parameters.put("Convocatoria", Convocatoria);
        parameters.put("FechaComisionCalf", FechaComisionCalf);
        parameters.put("InfAdq", InfAdq);
        parameters.put("InfHP", InfHP);
        parameters.put("Profesional", Profesional);
        parameters.put("Destino", Destino);
        parameters.put("Actividad", Actividad);
        
        System.out.println("El cod_w es --> "+cod_w);
        switch(cod_w){
            case 6:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjServ.jasper");
                break;
            case 3:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjCons.jasper");
                break;
            case 4:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjObra.jasper");
                break;
            case 7:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ResAdjBien.jasper");
                break;
        }
        
        //urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/IngresoMaterial.jasper");
        
         //JRBeanCollectionDataSource ds =new JRBeanCollectionDataSource(aux);  
                               
        JasperReport masterReport = null;
        try { masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);} 
        catch (JRException e) 
            { System.out.println("Error cargando el reporte maestro: " + e.getMessage());
              System.exit(3);
            }
        
        //parameters.put("imagen",urlImage.toString());
        //parameters.put("titulo",titulo);        

        JasperPrint masterPrint = null;
        try {
            System.out.println("Esta vivo weon¡¡");
            masterPrint = JasperFillManager.fillReport(masterReport, parameters, new JREmptyDataSource());
        }
        catch (JRException e) {}  
        
        JasperViewer.viewReport(masterPrint, false);
                
        /*
        final String reportSource = getClass().getClassLoader().getResource(reportName).getPath();
         
        final JasperDesign jd = JRXmlLoader.load(reportSource);
 
        final JasperReport report = JasperCompileManager.compileReport(jd);
 
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
 
        final String reportTarget = reportSource.substring(0,reportSource.lastIndexOf('/')).concat(reportName).concat(".pdf");
         
        JasperExportManager.exportReportToPdfFile(print, reportTarget);
                */
                
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
   }/*
   public static void main(String arg[]) {
       System.out.println("Wolasss");
       GetResoluciones x = new  GetResoluciones();
       x.Reporte("DPTO.T.U. Nº115/14", "Depto.Ppto.Nº404/14", "Jefe del Departamento de Tesoro Universitario","Detalle",4,0);
       System.out.println("Wolass2");
   }*/

    
}
