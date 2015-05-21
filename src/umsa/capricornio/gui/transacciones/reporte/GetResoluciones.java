/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.reporte;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.rpc.ServiceException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.utilitarios.herramientas.NumerosTextuales;
import net.sf.jasperreports.engine.JREmptyDataSource;
import umsa.capricornio.domain.Transaccion;
/**
 *
 * @author UMSA-JES
 */
public class GetResoluciones {
    
    URL urlMaestro,urlImage;
    String envia,dns,dnp,destino,num_resolucion,monto_ppto,dir_daf,monto;
    private double total,ti;
    private String Monto,mon;
    private int cod_almacen;
    public GetResoluciones(int cod_almacen){
        this.cod_almacen=cod_almacen;
    }
    public void arma(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos1=puerto.getPreventivos(cod_transaccion);
            if (datos1!=null)
            {
                for (int c=0;c<datos1.length;c++)
                {
                    total=total+Double.parseDouble(datos1[c].get("TOTAL").toString().trim().replace(",", "."));
                    //ti=ti+Double.parseDouble(datos1[c].get("TOTAL").toString());
                }
            }
            monto=String.valueOf(total);
            //mon=String.valueOf(ti);
            //Monto="168.202,32 ("+this.TotalTexto(monto)+")";
            Monto=this.formato(monto)+" ("+this.TotalTexto(monto)+" BOLIVIANOS)";
            System.out.println("----- "+this.formato(monto));
            System.out.println("esto sale aqui "+Monto);
            //Monto=" ("+this.TotalTexto(monto)+")";
            //System.out.println("Para cod_transaccion: "+cod_transaccion);
            //System.out.println("El cod_transaccion --> "+cod_transaccion+" y el cod_w: "+cod_w);
            Map[] datos = puerto.getResIni(cod_transaccion);
            
//            dir_daf = puerto.getDatoGeneral("DIR_DAF");
            Map[] datos2 = puerto.getDatosGenerales2(this.cod_almacen);
            if (datos2!=null){
                   dir_daf = datos2[0].get("RPA").toString();
            }
            
            
            //System.out.println("Dir Daf es: "+dir_daf);
            if(datos!=null){
                
                envia=datos[0].get("ENVIA").toString();
                dns=datos[0].get("DETALLE_NOTA_SOLICITUD").toString();
                dnp=datos[0].get("DETALLE_NOTA_PRESUPUESTO").toString();
                destino=datos[0].get("DESTINO").toString();
                int cod_res_ini=Integer.parseInt(datos[0].get("COD_RES_INI").toString());
                num_resolucion=datos[0].get("NUM_RESOLUCION").toString();
                monto_ppto=datos[0].get("MONTO_PPTO").toString();
                
//                datos=puerto.getDatosGenerales();
//                String dir_daf = datos[0].get("DIR_DAF").toString();
//                System.out.println("Dir Daf es: "+dir_daf);
                
                //this.setModal(false);
                //this.genera_reportes.Reporte(cod_transaccion,this.cod_w,num_resolucion,this.detalle,monto_ppto,envia,dns,dnp,destino,dir_daf);
                //this.setVisible(false);
                
            }
        } catch (Exception e) {
            System.out.println("esto sale"+Monto);
            System.out.println("esto sale "+e.getMessage());
        }
    }
    public void Reporte (int cod_transaccion, int cod_w, String Detalle)
    {
        Transaccion trans = new Transaccion();
        trans.setDetalle("Transporte y deposito de remesas de las cajas del Departamento de Tesoro Universitario");
        this.arma(cod_transaccion);
        //System.out.println("Probando --> "+prueba);
        RepTransaccion t1 = new RepTransaccion(); 
        Map parameters = new HashMap();
        
        //String NotaS = "DPTO.T.U. Nº115/14";
        //String NotaP = "Depto.Ppto.Nº404/14";
        //String Num_Resol = "16/2014";
        //String Num_Resol = "16/2014";
        String Fecha = "04  de Febrero de 2014";
        //String Envia = "Jefe del Departamento de Tesoro Universitario";
        //String Titulo_trans = "Transporte y deposito de remesas de las cajas del Departamento de Tesoro Universitario";
//        String Monto = this.TotalTexto(this.monto_ppto.replace(",", "."));
//        String Monto = null;
        
        
        parameters.put("NotaS", this.dns);
        parameters.put("NotaP", this.dnp);
        parameters.put("Num_Resol", this.num_resolucion);
        parameters.put("Fecha", Fecha);
        parameters.put("Envia", this.envia);
        parameters.put("Titulo_trans", Detalle);
        parameters.put("Monto", Monto);
        /*System.out.println(monto);
        Number m=Integer.parseInt(monto);
        parameters.put("monto_num",m);*/
        parameters.put("DIR_DAF", this.dir_daf);
        parameters.put("DESTINO", destino);
        //parameters.put("Destino", this.destino);
        
        System.out.println("El cod_w es --> "+cod_w+", y el destino es: "+destino);
        //urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReIniServ.jasper");
        switch(cod_w){
            case 6:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReIniServ.jasper");
                break;
            case 1:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReIniBien.jasper");
                break;
            case 3:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReIniConsu.jasper");
                break;
            case 4:
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReIniObra.jasper");
                break;
            case 7:
                System.out.println("Entro al 7");
                urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/ReIniBien.jasper");
                break;
        }
        
        //urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/IngresoMaterial.jasper");
        
         //JRBeanCollectionDataSource ds =new JRBeanCollectionDataSource(aux);  
                               
        JasperReport masterReport = null;
        try {
            System.out.println("El urlMaestro es --> "+urlMaestro);
            masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
        } 
        catch (JRException e) 
            { System.out.println("Error cargando el reporte maestro: " + e.getMessage());
              System.exit(3);
            }
        
        //parameters.put("imagen",urlImage.toString());
        //parameters.put("titulo",titulo);        

        JasperPrint masterPrint = null;
        try {
            System.out.println("Probando de numero a literal --> "+this.TotalTexto("1000000"));
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
   }
    String formato(String t)
    {
        System.out.println("aejrhaeusdhuiasdfhiudshf "+t);
        try{
           double m=Double.parseDouble(t);  
        DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
        System.out.println("swdasda"+formato_decimal.format(m));
        //String d=formato_decimal.format(t).toString();
        return (String.valueOf(formato_decimal.format(m)).toString());
        }
        catch(Exception e)
        {
            System.out.println("este mensaje jejeje"+e.getMessage());
            return "hola";
        }
        
    }
   /*public static void main(String arg[]) {
       System.out.println("Wolasss");
       GetResoluciones x = new  GetResoluciones();
       x.Reporte("DPTO.T.U. Nº115/14", "Depto.Ppto.Nº404/14", "Jefe del Departamento de Tesoro Universitario","Detalle","sads",4,0);
       System.out.println("Wolass2");
   }*/
}
