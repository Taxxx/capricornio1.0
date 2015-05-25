/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package umsa.capricornio.gui.transacciones.reporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import static umsa.capricornio.gui.menu.FrmMenu.usuario;
import umsa.capricornio.utilitarios.herramientas.NumerosTextuales;

/**
 *
 * @author julian
 */
public class RepTransaccion {     
      
    URL urlMaestro,urlImage,firma_usr,firma2,firma_rpa;
    private String usuariox;
    public String generaUsuario(int cod_transaccion){
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            return puerto.getNombreUsuario1(String.valueOf(cod_transaccion));
            //System.out.println("El codigo de usuario es: "+cod_usuario);
        } catch (Exception e) {
            System.out.println("El error es: "+e);
            return null;
        }
    }
    
    public void Reporte (List aux,String titulo,int cod_tramite,int cod_trans_nro,int cod_almacen)
    {
        this.usuariox = this.generaUsuario(cod_trans_nro);
        System.out.println("Generando Reporte, del tipo --> "+titulo);
        RepTransaccion t1 = new RepTransaccion(); 
        Map parameters = new HashMap();
        if (cod_tramite==1){
            
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/SolicitudCompra.jasper"); 
            //System.out.println("Entro a la opción 1 y urlmaestro es: "+urlMaestro);
            /*try{ AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
                AdquiWS_PortType puerto = servicio.getAdquiWS();                  
                Map[] datos= puerto.getTotal(cod_trans_nro);
                if (datos!=null)
                    parameters.put("TxtTotal",TotalTexto(datos[0].get("TOTAL").toString()));
                else
                    System.out.println("upsi Vacio¡¡¡");
            }
            catch (RemoteException e){System.out.println(e);
            }
            catch (ServiceException e){ System.out.println(e);}*/
        }
        if (cod_tramite==2){
            this.usuariox=usuario;
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/OrdenCompra.jasper");
            try{ AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
                AdquiWS_PortType puerto = servicio.getAdquiWS();                  
                Map[] datos= puerto.getTotal(cod_trans_nro);
                if (datos!=null){
                    //System.out.println("............................ El total es: "+datos[0].get("TOTAL").toString());
                    //System.out.println("............................ El total redondeado es: "+this.Redondear(datos[0].get("TOTAL").toString(),2));
                    parameters.put("TxtTotal",TotalTexto(this.Redondear(datos[0].get("TOTAL").toString(),2)));
                }
                      
            }
            catch (RemoteException e){System.out.println(e);
            }
            catch (ServiceException e){ System.out.println(e);}
        }
        if (cod_tramite==3)
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/IngresoMaterial.jasper");
        if (cod_tramite==4)
            urlMaestro = t1.getClass().getResource("/umsa/capricornio/gui/reports/PedidoMateriales.jasper");
        urlImage=t1.getClass().getResource("/umsa/capricornio/gui/images/umsa.jpg");
        
        firma2=t1.getClass().getResource("/umsa/capricornio/gui/images/liliana.jpg");
        try {
            
            System.out.println("el cod_trans_nro es: "+cod_trans_nro);
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            String ubi_rpa = puerto.getDatosGenerales2(cod_almacen)[0].get("FIRMA_RPA").toString();
             String ubi_usr;
            if (cod_tramite==2){
                ubi_usr = puerto.getFirmaUsuario(cod_trans_nro)[0].get("FIRMA").toString();
            }
            else{
                ubi_usr = puerto.getFirmaUsuario2(cod_trans_nro)[0].get("FIRMA").toString();
            }
                
            
            //        firma_rpa=t1.getClass().getResource("/umsa/capricornio/gui/images/firma_MonicaDiaz.jpg");
            //firma_rpa=t1.getClass().getResource("/../../../firmas/2015-rpa-3.jpg");
            
            if(ubi_rpa.trim().length()!=0){
                firma_rpa = new URL("http://200.7.160.25"+ubi_rpa);
                parameters.put("firma_rpa",firma_rpa.toString());
            }
            
            if(ubi_usr.trim().length()!=0){
                firma_usr = new URL("http://200.7.160.25"+ubi_usr);
                parameters.put("firma_usr",firma_usr.toString());
            }
            
  //        parameters.put("firma2",firma2.toString());
            
            
            
            
//            firma_rpa= new URL("http://200.7.160.25/firmas/2015-rpa-3.jpg");
//        firma_rpa=t1.getClass().getResource("");
//        firma_rpa = "http://200.7.160.25/prueba/";
        } catch (MalformedURLException ex) {
            Logger.getLogger(RepTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e){
            
        }
        
        System.out.println("----->>>>  Wujuuu la ruta de la firma es: "+firma_rpa);
        System.out.println("----->>>>  Wujuuu la ruta de la otra firma es: "+firma_usr);

        // Recuperamos el fichero fuente el xml para la compilacion interna
        /*File rep = new File(urlMaestro.getFile());
        JasperDesign jd=JRXmlLoader.load(rep)); 
        JasperReport report = JasperCompileManager.compileReport(jd);  
        JasperPrint masterPrint = null;
        try { masterPrint = JasperFillManager.fillReport(report,parameters, ds); } 
        catch (JRException e) { }              
        JasperViewer.viewReport(masterPrint, false);*/
        
        JRBeanCollectionDataSource ds =new JRBeanCollectionDataSource(aux);  
                               
        JasperReport masterReport = null;
        try { masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);} 
        catch (JRException e) 
            { System.out.println("Error cargando el reporte maestro: " + e.getMessage());
              System.exit(3);
            }
        
        parameters.put("imagen",urlImage.toString());
        
        parameters.put("titulo",titulo);
        //parameters.put("titulo",titulo);
        parameters.put("usuario",usuariox);

        JasperPrint masterPrint = null;
        try { masterPrint = JasperFillManager.fillReport(masterReport, parameters,ds);}
        catch (JRException e) {}  
        
        JasperViewer.viewReport(masterPrint, false);  
    }
    public String Redondear(String numero, int pow)
    {
           Double num_deci = Math.pow(10, pow);
           return String.valueOf(Math.rint(Double.parseDouble(numero)*num_deci)/num_deci);
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
}