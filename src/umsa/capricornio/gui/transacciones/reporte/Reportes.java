/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.reporte;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.rpc.ServiceException;
import umsa.capricornio.domain.Transaccion;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.utilitarios.herramientas.i_formatterDate;

/**
 *
 * @author UMSA-JES
 **/
public class Reportes {
    private int cod_almacen;
    private RepTransaccion rep = new RepTransaccion();
    
    public Reportes(int cod_almacen){
        this.cod_almacen = cod_almacen;
    }
    public void MostrarPedido(int cod_trans_nro, String cod_estado, int cod_tramite){
        try {
            List list=new ArrayList();    
            
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            System.out.println("cod_trans_nro: "+cod_trans_nro);
            System.out.println("cod_Estado: "+cod_estado);
            System.out.println("cod_tramite: "+cod_tramite);
            
            Map[] datos=puerto.getReportePedidox(cod_trans_nro,cod_estado,cod_tramite);
            if (datos!=null){
                Map map = new HashMap();
                int i=0;
                String cod_trans_detalle,aux = null;
                for (int f=0;f<datos.length;f++){
                    Transaccion trans = new Transaccion();
                    trans.setNro_gestion(datos[f].get("NRO_GESTION").toString());
                    trans.setFecha_creacion(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_CREACION").toString()));
                    
                    //System.out.println("----->>>> Fecha de creacion: "+trans.getFecha_creacion());
                    
                    trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_ENVIO").toString()));
                    trans.setUnidad_sol(datos[f].get("UNIDAD_SOL").toString());
                    trans.setUnidad_des(datos[f].get("UNIDAD_DES").toString());
                    trans.setUsuario_sol(datos[f].get("USUARIO_SOL").toString());
                    trans.setDetalle(datos[f].get("DETALLE").toString());
                    trans.setUnidad_medida(datos[f].get("UNIDAD_MEDIDA").toString());
                    trans.setCantidad_pedido(Integer.parseInt(datos[f].get("CANTIDAD_PEDIDO").toString()));
                    //trans.setCantidad_pedido(datos[f].get("CANTIDAD_PEDIDO").toString());
                    //trans.setTipo_item(datos[f].get("TIPO_ITEM").toString());
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setDetalle_solicitud(datos[f].get("DETALLE_SOLICITUD").toString());                    
                    trans.setNro_transaccion(Integer.parseInt(datos[f].get("NRO_TRANSACCION").toString()));
                    trans.setNro(datos[f].get("NRO").toString());
                    
                    trans.setPreventivo(datos[f].get("CBTE").toString());
                    trans.setNum_ing(datos[f].get("NUM_ING").toString());
                    
                    if (!"".equals(datos[f].get("PRECIO_UNIT").toString())){
                        trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
                        trans.setSubtotal(0.0);
                    }
                    cod_trans_detalle=datos[f].get("COD_TRANS_DETALLE").toString();
                    if(!cod_trans_detalle.equals(aux)){
                        i++;
                        System.out.println("El indice es wujuuu: "+i);
                        trans.setIndice(String.valueOf(i));
                    }
                    aux=cod_trans_detalle;
                    trans.setCod_trans_detalle(cod_trans_detalle);
                    list.add(trans);
                }
                
                //System.out.println("titulo: "+"");
                System.out.println("cod_tramite: "+cod_tramite);
                System.out.println("cod_trans_nro: "+cod_trans_nro);
                
                rep.Reporte(list,"PEDIDO DE MATERIALES",cod_tramite,cod_trans_nro,cod_almacen);
            }
        } catch (Exception e) {
        }
    }
    public void MostrarSolicitud(int cod_trans_nro,String cod_estado,int cod_tramite,String titulo){
        List list=new ArrayList();
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            System.out.println("cod_trans_nro: "+cod_trans_nro+" cod_estado: "+cod_estado+" cod_tramite: "+cod_tramite+" titulo: "+titulo);
            //String nom_usuario = puerto.getNombreUsuario(String.valueOf(cod_transaccion));
            //System.out.println("WWAADSADASDA------> "+nom_usuario);
            Map[] datos=puerto.getReporteSolicitudx(cod_trans_nro,cod_estado,cod_tramite);
            if (datos!=null){
                System.out.println("Tiene Datos :D :D :D");
                Map map = new HashMap();
                int i=0;
                String cod_trans_detalle,aux = null;
                for (int f=0;f<datos.length;f++){
                    Transaccion trans = new Transaccion();
                    System.out.println("Tiene Datos :D :D :D -->"+datos[f].get("NRO_GESTION").toString());
                    trans.setNro_gestion(datos[f].get("NRO_GESTION").toString());
                    //System.out.println(datos[f].get("NRO_GESTION").toString());
                    trans.setFecha_creacion(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_CREACION").toString()));
                    trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_ENVIO").toString()));
                    trans.setUnidad_sol(datos[f].get("UNIDAD_SOL").toString());
                    trans.setUnidad_des(datos[f].get("UNIDAD_DES").toString());
                    trans.setUsuario_sol(datos[f].get("USUARIO_SOL").toString());
                    trans.setDetalle(datos[f].get("DETALLE").toString());
                    trans.setUnidad_medida(datos[f].get("UNIDAD_MEDIDA").toString());
                    trans.setUser_maker(datos[f].get("USER_MAKER").toString());
                    System.out.println("Sipiii "+datos[f].get("USER_MAKER").toString());
                    //trans.setCantidad_pedido(datos[f].get("CANTIDAD_PEDIDO").toString());
                    trans.setCantidad_pedido(Integer.parseInt(datos[f].get("CANTIDAD_PEDIDO").toString()));
                    //trans.setTipo_item(datos[f].get("TIPO_ITEM").toString());
                    //System.out.println("Articulo :D :D :D --> "+datos[f].get("ARTICULO").toString());
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setDetalle_solicitud(datos[f].get("DETALLE_SOLICITUD").toString());                    
                    trans.setNro_transaccion(Integer.parseInt(datos[f].get("NRO_TRANSACCION").toString()));
                    
                    //System.out.println("------------------ "+datos[f].get("COD_TRANS_DETALLE").toString()+"---------------------");
                    cod_trans_detalle=datos[f].get("COD_TRANS_DETALLE").toString();
                    if(!cod_trans_detalle.equals(aux)){
                        i++;
                        System.out.println("El indice es wujuuu: "+i);
                        trans.setIndice(String.valueOf(i));
                    }
                    aux=cod_trans_detalle;
                    trans.setCod_trans_detalle(cod_trans_detalle);
                    
                    list.add(trans);
                }
                RepTransaccion rep = new RepTransaccion();
                System.out.println("titulo: "+titulo);
                System.out.println("cod_tramite: "+cod_tramite);
                System.out.println("cod_trans_nro: "+cod_trans_nro);
                
                rep.Reporte(list,titulo,cod_tramite,cod_trans_nro,cod_almacen);
            }        
            else
                System.out.println("Vaciooooo :P");
               
        }
        catch (RemoteException e){
           System.out.println("nououououou -> "+e.getMessage());
        }
        catch (ServiceException e){ System.out.println("error 1:"+e);} 
        catch (NumberFormatException e) {
            System.out.println("nououououou jijijij-> "+e.getMessage());
        }  
    }
    public void MostrarOrden(int cod_trans_nro,String cod_estado,int cod_tramite,String titulo){
        System.out.println("====== Hola Camaron ================== cod_trans_nro: "+cod_trans_nro+"  cod_estado: "+cod_estado+" titulo: "+titulo+" cod_tramite: "+cod_tramite);
        List list=new ArrayList();
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getReporteOrdenx(cod_trans_nro,cod_estado,cod_tramite);
            
            if (datos!=null){
                System.out.println("Con Datos!!!");
                Map map = new HashMap();
                int i=0;
                String cod_trans_detalle,aux = null;
                for (int f=0;f<datos.length;f++){
                    Transaccion trans = new Transaccion();
                    trans.setNro_gestion(datos[f].get("NRO_GESTION").toString());
                    trans.setFecha_creacion(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_CREACION").toString()));
                    trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_ENVIO").toString()));
                    trans.setUnidad_sol(datos[f].get("UNIDAD_SOL").toString());
                    trans.setUnidad_des(datos[f].get("UNIDAD_DES").toString());
                    trans.setUsuario_sol(datos[f].get("USUARIO_SOL").toString());
                    trans.setDetalle(datos[f].get("DETALLE").toString());
                    trans.setUnidad_medida(datos[f].get("UNIDAD_MEDIDA").toString());
                    trans.setCantidad_pedido(Integer.parseInt(datos[f].get("CANTIDAD_PEDIDO").toString()));
                    //trans.setTipo_item(datos[f].get("TIPO_ITEM").toString());
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setDetalle_solicitud(datos[f].get("DETALLE_SOLICITUD").toString());
                    //hoja_ruta,cbte,casa_comercial,direccion,telefono,nit,precio_unit
                    trans.setHoja_ruta(datos[f].get("HOJA_RUTA").toString());
                    System.out.println("cbte es : "+datos[f].get("CBTE").toString());
                    trans.setCbte(datos[f].get("CBTE").toString());
                    trans.setCasa_comercial(datos[f].get("CASA_COMERCIAL").toString());
                    trans.setDireccion(datos[f].get("DIRECCION").toString());
                    trans.setTelefono(datos[f].get("TELEFONO").toString());
                    trans.setNit(datos[f].get("NIT").toString());
//                    trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
//                    if(Integer.parseInt(datos[f].get("COD_TRANS_DETALLE").toString())==2787)
//                        trans.setPrecio_unit(0.058338);
//                    else
                        trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
                    System.out.println("PRecio ------------------> "+Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
                    trans.setPartida(datos[f].get("PARTIDA").toString());
                    trans.setObs(datos[f].get("OBS").toString());
                    //trans.setSubtotal(Double.parseDouble(datos[f].get("SUBTOTAL").toString()));
                    
                    /*trans.setNro_orden_compra(Integer.parseInt(datos[f].get("NRO_ORDEN_COMPRA").toString()));
                    if (!(datos[f].get("FEC_ORDEN_COMPRA")==null || "".equals(datos[f].get("FEC_ORDEN_COMPRA"))))
                        trans.setFec_orden_compra(i_formatterDate.i_conveterStandardToDate(datos[f].get("FEC_ORDEN_COMPRA").toString()));
                    trans.setFactura(datos[f].get("FACTURA").toString());
                    if (!(datos[f].get("FECHA_FACT")==null || "".equals(datos[f].get("FECHA_FACT"))))
                        trans.setFecha_fact(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_FACT").toString()));
                    trans.setMemo(datos[f].get("MEMO").toString());*/
                    trans.setNro_transaccion(Integer.parseInt(datos[f].get("NRO_TRANSACCION").toString()));
                    
                    //System.out.println("------------------ "+datos[f].get("COD_TRANS_DETALLE").toString()+"---------------------");
                    cod_trans_detalle=datos[f].get("COD_TRANS_DETALLE").toString();
                    if(!cod_trans_detalle.equals(aux)){
                        i++;
                        System.out.println("El indice es wujuuu: "+i);
                        trans.setIndice(String.valueOf(i));
                    }
                    aux=cod_trans_detalle;
                    trans.setCod_trans_detalle(cod_trans_detalle);
                    list.add(trans);
                } 
                RepTransaccion rep = new RepTransaccion();
                System.out.println("titulo: "+titulo);
                System.out.println("cod_tramite: "+cod_tramite);
                System.out.println("cod_trans_nro: "+cod_trans_nro);
                
                rep.Reporte(list,titulo,cod_tramite,cod_trans_nro,cod_almacen);
            }
            else
                System.out.println("Sin Datos!!!");
            /*for (int i = 0; i < list.size(); i++) {
                Transaccion aux = (Transaccion) list.get(i);t           
                System.out.println(aux.getNro_gestion()+" "+aux.getFecha_creacion()+" "+ aux.getFecha_envio()+" "+aux.getUnidad_sol()+" "+aux.getUnidad_des()+" "+aux.getUsuario_sol()+" "+aux.getUnidad_medida()+" "+aux.getCantidad_pedido()+" "+aux.getTipo_item()+" "+aux.getArticulo()+" "+aux.getDetalle_solicitud());
            }  */      
        }
        catch (RemoteException e){
            System.out.println("erroooorrrr!!! "+e.getMessage());
//            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println("error 1:"+e);} 
        catch (NumberFormatException e) {
//            javax.swing.JOptionPane.showMessageDialog(this,"LA ORDEN NO FUE APROBADA O \n NO COMPLETO LOS DATOS NECESARIOS","SYSTEM CAPRICORN",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }  
    }
    public void MostrarIngreso(int cod_trans_nro,String cod_estado,int cod_tramite){
        List list=new ArrayList();
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            System.out.println("_>_>_>_>El cod_trans_nro es :"+cod_trans_nro+" cod_estado: "+cod_estado+" cod_tramite: "+cod_tramite);
            Map[] datos=puerto.getReporteIngresox(cod_trans_nro,cod_estado,cod_tramite);            
            int i=0;
            String cod_trans_detalle,aux = null;
            if (datos!=null){                 
                Map map = new HashMap();
                for (int f=0;f<datos.length;f++){
                    Transaccion trans = new Transaccion();
                    trans.setNro_gestion(datos[f].get("NRO_GESTION").toString());
                    trans.setFecha_creacion(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_CREACION").toString()));
                    trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_ENVIO").toString()));
                    //trans.setFecha_envio(i_formatterDate.i_conveterStandardToDate("13-04-91"));
                    trans.setUnidad_sol(datos[f].get("UNIDAD_SOL").toString());
                    trans.setUnidad_des(datos[f].get("UNIDAD_DES").toString());
                    trans.setUsuario_sol(datos[f].get("USUARIO_SOL").toString());
                    trans.setDetalle(datos[f].get("DETALLE").toString());
                    trans.setUnidad_medida(datos[f].get("UNIDAD_MEDIDA").toString());
                    trans.setCantidad_pedido(Integer.parseInt(datos[f].get("CANTIDAD_PEDIDO").toString()));
                    //trans.setTipo_item(datos[f].get("TIPO_ITEM").toString());
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setPartida(datos[f].get("PARTIDA").toString());
//                    System.out.println("El origen esta en: "+datos[f].get("ORIGEN").toString());
                    trans.setUnidad_sol(datos[f].get("ORIGEN").toString());
                    trans.setObs(datos[f].get("OBS").toString());
                    //trans.setCod_trans_detalle(datos[f].get("COD_TRANS_DETALLE").toString());
                    //System.out.println("________ Cod_trans_detalle: "+trans.getCod_trans_detalle());
                    cod_trans_detalle=datos[f].get("COD_TRANS_DETALLE").toString();
                    if(!cod_trans_detalle.equals(aux)){
                        i++;
                        System.out.println("El indice es wujuuu: "+i);
                        trans.setIndice(String.valueOf(i));
                    }
                    aux=cod_trans_detalle;
                    trans.setCod_trans_detalle(cod_trans_detalle);
                    
                    trans.setDetalle_solicitud(datos[f].get("DETALLE_SOLICITUD").toString());
                    //hoja_ruta,cbte,casa_comercial,direccion,telefono,nit,precio_unit
                    trans.setHoja_ruta(datos[f].get("HOJA_RUTA").toString());
                    trans.setCbte(datos[f].get("CBTE").toString());
                    trans.setCasa_comercial(datos[f].get("CASA_COMERCIAL").toString());
                    //trans.setDireccion(datos[f].get("DIRECCION").toString());
                    //trans.setTelefono(datos[f].get("TELEFONO").toString());
                    trans.setNit(datos[f].get("NIT").toString());
                    trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
                    //trans.setSubtotal(Double.parseDouble(datos[f].get("SUBTOTAL").toString()));
                    trans.setSubtotal(0.0);
                    
                    trans.setNro_orden_compra(Integer.parseInt(datos[f].get("NRO_ORDEN_COMPRA").toString()));
                    if (!(datos[f].get("FEC_ORDEN_COMPRA")==null || "".equals(datos[f].get("FEC_ORDEN_COMPRA"))))
                        trans.setFec_orden_compra(i_formatterDate.i_conveterStandardToDate(datos[f].get("FEC_ORDEN_COMPRA").toString()));
                    trans.setFactura(datos[f].get("FACTURA").toString());
                    if (!(datos[f].get("FECHA_FACT")==null || "".equals(datos[f].get("FECHA_FACT"))))
                        trans.setFecha_fact(i_formatterDate.i_conveterStandardToDate(datos[f].get("FECHA_FACT").toString()));
                    trans.setMemo(datos[f].get("MEMO").toString());
                    trans.setNro_transaccion(Integer.parseInt(datos[f].get("NRO_TRANSACCION").toString()));
                    list.add(trans);
                } 
                RepTransaccion rep = new RepTransaccion();
                rep.Reporte(list,"Ingreso Almacen", cod_tramite,cod_trans_nro,cod_almacen);
            }else{
                System.out.println("Vaciooooo");
            }                         
            /*for (int i = 0; i < list.size(); i++) {
                Transaccion aux = (Transaccion) list.get(i);t           
                System.out.println(aux.getNro_gestion()+" "+aux.getFecha_creacion()+" "+ aux.getFecha_envio()+" "+aux.getUnidad_sol()+" "+aux.getUnidad_des()+" "+aux.getUsuario_sol()+" "+aux.getUnidad_medida()+" "+aux.getCantidad_pedido()+" "+aux.getTipo_item()+" "+aux.getArticulo()+" "+aux.getDetalle_solicitud());
            }  */      
        }
        catch (RemoteException e){
//            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println(e);} 
        catch (NumberFormatException e) {
//            javax.swing.JOptionPane.showMessageDialog(this,"DEBE ELEJIR UNA FILA PARA PODER IMPRIMIR EL REPORTE","SYSTEM CAPRICORN",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }  
    }
}
