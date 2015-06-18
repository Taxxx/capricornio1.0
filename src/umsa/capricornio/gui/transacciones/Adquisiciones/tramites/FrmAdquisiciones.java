/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmTransacciones.java
 *
 * Created on 24-jun-2011, 17:12:59
 */
package umsa.capricornio.gui.transacciones.Adquisiciones.tramites;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.xml.rpc.ServiceException;
import umsa.capricornio.domain.Transaccion;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.gui.menu.FrmMenu;
import umsa.capricornio.gui.transacciones.Adquisiciones.tramites.tablas.ItemCellEditor;
import umsa.capricornio.gui.transacciones.Adquisiciones.tramites.tablas.TablaTransaccionBandeja;
import umsa.capricornio.gui.transacciones.reporte.RepTransaccion;
import umsa.capricornio.gui.transacciones.reporte.Reportes;
import umsa.capricornio.gui.transacciones.tablas.TablaTransaccionEstados;
import umsa.capricornio.utilitarios.herramientas.MiRenderer;
import umsa.capricornio.utilitarios.herramientas.i_formatterDate;

/**
 *
 * @author julian
 */
public class FrmAdquisiciones extends javax.swing.JInternalFrame {

    TablaTransaccionBandeja bandeja;
    TablaTransaccionEstados estados;
    int pasa=0;
    FrmMenu menu;
    private Reportes reportes;
    int cod_usuario,cod_rol,gestion,x,tope,ini,fin,cod_almacen;
    private Runtime r;
    private int cod_tramite;
    /** Creates new form FrmTransacciones */
    public FrmAdquisiciones(FrmMenu menu,int cod_usuario,int cod_rol,int gestion,int cod_almacen) {
        this.menu=menu;
        this.cod_usuario=cod_usuario;
        this.cod_rol=cod_rol;
        this.gestion=gestion;
        this.cod_almacen=cod_almacen;
        reportes = new Reportes(cod_almacen);
        initComponents();
        ConstruyeTablaTransacciones();
        ConstruyeTablaEstados();
    }
    
    private void ConstruyeTablaTransacciones(){
        bandeja = new TablaTransaccionBandeja();
        TblTransaccionBandeja.setAutoCreateColumnsFromModel(false);
        TblTransaccionBandeja.setModel(bandeja);

        for (int k = 0; k < TablaTransaccionBandeja.m_columns.length; k++) {
            TableCellRenderer renderer = new MiRenderer(TablaTransaccionBandeja.m_columns[k].m_alignment);
            /*DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(DatosTablaObligacionBandeja.m_columns[k].m_alignment);*/
            //TableCellEditor edit =new ItemCellEditor(null);
            TableColumn column = new TableColumn(k, TablaTransaccionBandeja.m_columns[k].m_width, renderer, null);
            //column.setMaxWidth(TablaTransaccionBandeja.m_columns[k].m_width);
            column.setMinWidth(TablaTransaccionBandeja.m_columns[k].m_width);
            //column.setResizable(true);
            
            TblTransaccionBandeja.addColumn(column);
        }
        JTableHeader header = TblTransaccionBandeja.getTableHeader();
        header.setUpdateTableInRealTime(true);
        header.setReorderingAllowed(true);
        PnlTransaccionBandeja.getViewport().add(TblTransaccionBandeja);
    }
    
    private void ConstruyeTablaEstados(){
        estados = new TablaTransaccionEstados();
        TblTransaccionEstado.setAutoCreateColumnsFromModel(false);
        TblTransaccionEstado.setModel(estados);

        for (int k = 0; k < TablaTransaccionEstados.m_columns.length; k++) {
            TableCellRenderer renderer = new MiRenderer(TablaTransaccionEstados.m_columns[k].m_alignment);
            /*DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(DatosTablaObligacionBandeja.m_columns[k].m_alignment);*/
            TableColumn column = new TableColumn(k, TablaTransaccionEstados.m_columns[k].m_width, renderer, null);
            TblTransaccionEstado.addColumn(column);
        }
        JTableHeader header = TblTransaccionEstado.getTableHeader();
        header.setUpdateTableInRealTime(true);
        header.setReorderingAllowed(true);
        PnlTransaccionEstado.getViewport().add(TblTransaccionEstado);
    }
        
    private void LlenaBandeja(){        
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            System.out.println("DENTRO DEL POPULAR LLENA BANDEJA --> cod_rol: "+cod_rol+"cod_almacen: "+cod_almacen+" cod_tramite: "+cod_tramite+"gestion: "+gestion+" ini: "+ini+" fin: "+fin);
            System.out.println("Lo que se le envia al query --> gestion: "+gestion+" cod_almacen:"+cod_almacen+" cod_usuario: "+cod_usuario+" cod_tramite: "+cod_tramite);
            Map[] datos=puerto.getTransaccionBandejaAdqui(gestion,cod_almacen,cod_usuario,cod_tramite);
            CerearTablaBandeja();
            
            if (datos!=null){
                for (int c=0;c<datos.length;c++){
                    bandeja.insert(c);
                    TblTransaccionBandeja.tableChanged(new TableModelEvent(bandeja, c, c, TableModelEvent.ALL_COLUMNS,TableModelEvent.INSERT));
                    TblTransaccionBandeja.setValueAt(datos[c].get("COD_TRANS_NRO"),c,0);
                    TblTransaccionBandeja.setValueAt(datos[c].get("COD_ESTADO"),c,1);
                    TblTransaccionBandeja.setValueAt(datos[c].get("COD_W"),c,2);
                    TblTransaccionBandeja.setValueAt(datos[c].get("NRO_TRAMITE"),c,3);
                    TblTransaccionBandeja.setValueAt(datos[c].get("TIPO_TRAMITE"),c,4);
                    TblTransaccionBandeja.setValueAt(datos[c].get("DETALLE"),c,5);
                    TblTransaccionBandeja.setValueAt(datos[c].get("UNIDAD_SOL"),c,6);
                    TblTransaccionBandeja.setValueAt(datos[c].get("UNIDAD_DES"),c,7);
                    TblTransaccionBandeja.setValueAt(datos[c].get("ESTADO"),c,8);
                    TblTransaccionBandeja.setValueAt(datos[c].get("CUANTIA"),c,9);
                    TblTransaccionBandeja.setValueAt(datos[c].get("DEL"),c,10);
                    TblTransaccionBandeja.setValueAt(datos[c].get("HASTA"),c,11);
                }
            }
        }
        catch (RemoteException e){
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println(e);}        
    }
            
    void CerearTablaBandeja(){
        int f = TblTransaccionBandeja.getRowCount();
        for (int i=f-1;i>=0;i--){
             if (bandeja.delete(i)) {
                TblTransaccionBandeja.tableChanged(new TableModelEvent(
                bandeja, i, i, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
             }
        }
    }    
    
    private void LlenaEstados(){
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            
            Map[] datos=puerto.getTransaccionEstado(cod_almacen,cod_tramite,gestion,ini,fin);
            CerearTablaEstados();
            if (datos!=null){
                for (int c=0;c<datos.length;c++){
                    estados.insert(c);
                    TblTransaccionEstado.tableChanged(new TableModelEvent(estados, c, c, TableModelEvent.ALL_COLUMNS,TableModelEvent.INSERT));
                    //TblTransaccionEstado.setValueAt(datos[c].get("COD_TRANSACCION"),c,0);
                    TblTransaccionEstado.setValueAt(datos[c].get("COD_TRANS_NRO"),c,0);
                    TblTransaccionEstado.setValueAt(datos[c].get("COD_ESTADO"),c,1);
                    TblTransaccionEstado.setValueAt(datos[c].get("COD_TRAMITE"),c,2);
                    TblTransaccionEstado.setValueAt(datos[c].get("NRO"),c,3);
                    TblTransaccionEstado.setValueAt(datos[c].get("TRAMITE"),c,4);
                    TblTransaccionEstado.setValueAt(datos[c].get("DETALLE"),c,5);
                    TblTransaccionEstado.setValueAt(datos[c].get("UNIDAD_SOL"),c,6);
                    TblTransaccionEstado.setValueAt(datos[c].get("UNIDAD_DES"),c,7);
                    TblTransaccionEstado.setValueAt(datos[c].get("ESTADO"),c,8);                    
                }
            }
        }
        catch (RemoteException e){
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println(e);}
    }
    
    void CerearTablaEstados(){
        int f = TblTransaccionEstado.getRowCount();
        for (int i=f-1;i>=0;i--){
             if (estados.delete(i)) {
                TblTransaccionEstado.tableChanged(new TableModelEvent(
                estados, i, i, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
             }
        }
    }
    
    private void CalculaElementosListar(){
       int nro_reg=5;
       try{ AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();                  
            Map[] datos= puerto.getNroTransacciones(gestion,cod_tramite,cod_almacen);            
            if (datos!=null){
                System.out.println("con datos");
                try{
                    nro_reg= Integer.parseInt(datos[0].get("LINENUM").toString());
                } catch (Exception e) {
                    System.out.println("Error al generar R.A.B :(");
                    nro_reg=5;  
                }
                
                /*for (int c=0;c<datos.length;c++){
                    nro_reg= Integer.parseInt(datos[c].get("LINENUM").toString());
                    System.out.println("nro_reg: "+nro_reg);
                    //nro_reg=5;
                }*/
            }
            else
                nro_reg=5;
            
            tope=nro_reg;
            ini=1;
            x=100;
            fin=ini+x-1;            
            //String ultin=cant_sol.substring(n_dig-2, n_dig);
            if (nro_reg<= x){
                BtnInicio.setEnabled(false);
                BtnAtras.setEnabled(false);
                BtnAdelante.setEnabled(false);
                BtnFinal.setEnabled(false);
            }
            else  {BtnInicio.setEnabled(false);
                   BtnAtras.setEnabled(false);
            }
        }
        catch (RemoteException e){
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"Proyectos Presupuestarios",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println(e);}
    }
     private void verificadias(FrmMenu menu, int cod_almacen, int cod_trans_nro, int cod_rol, String tramite, int gestion, int cod_w, String origen, String detalle, String unidad_sol, String unidad_des, String nro, String cuantia, String del, String hasta)
    {
        //if(tab_habil==0)
           // {
                int t=15;
                try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getDias(cod_trans_nro);
            t=15;
            if(!datos[0].get("DIAS").toString().equals(""))
            { 
                System.out.println("ttttt ya tiene dias");
            }
            else
            {
                boolean sw12=true;
                do{
                String resp=JOptionPane.showInputDialog("escribe el tiempo de entrega en caso de ser mayor a 15 dias\nsi es menor deje en blanco y click en aceptar");
                if(resp==null)
                {
                    //this.setVisible(false);
                    this.setVisible(true);
                    //BtnSalir1.doClick();
                    System.err.println("jajaja si detecto el cancel");
                    pasa=-1;
                    return;
                    
                }
                if(resp.equals(""))
                {
                    System.out.println("s 15");
                }
                else{
                    try{
                    t=Integer.parseInt(resp);
                    System.out.println("ttttt "+t);
                    sw12=true;
                    }
                    catch(Exception e){JOptionPane.showMessageDialog (null, "El dato digitado no es un número", "Error", JOptionPane.ERROR_MESSAGE);
                    sw12=false;}
                }
                }while(sw12==false);
                int res1 = javax.swing.JOptionPane.showConfirmDialog(this, "Esta seguro de que el tiempo de duracion se "+t+" dias",
                    "MENSAJE CAPRICORNIO", javax.swing.JOptionPane.YES_NO_OPTION);
                if (res1 != javax.swing.JOptionPane.YES_OPTION) {
                    pasa=-1;
                    return;
                }
                Map[] datos1=puerto.setDias(cod_trans_nro,t);
            }
        }
        catch(Exception e)
        {}
              try{
              if(cod_w==6 && cuantia.equals("COMPRA MENOR") && t<=15)
              {
                  int cod_alternativo=cod_w;
              }
              }catch(Exception e)
              {}
        //}
    }
        
    void AbreItems(){
        int fila = TblTransaccionBandeja.getSelectedRow();
        int cod_trans_nro = Integer.parseInt(TblTransaccionBandeja.getValueAt(fila, 0).toString());        
        //menu.AbrirOtroFrame(this, new FrmOrdenesDetalle(menu, this,cod_almacen, cod_trans_nro,cod_rol,  TblTransaccionBandeja.getValueAt(fila, 4).toString(), gestion, Integer.parseInt(TblTransaccionBandeja.getValueAt(fila, 2).toString()),TblTransaccionBandeja.getValueAt(fila, 1).toString(),TblTransaccionBandeja.getValueAt(fila, 5).toString(),TblTransaccionBandeja.getValueAt(fila, 6).toString(),TblTransaccionBandeja.getValueAt(fila, 7).toString()));
        String cuantia=TblTransaccionBandeja.getValueAt(fila, 9).toString();
        if(!cuantia.equals("ANPE"))
        {
            verificadias(menu,cod_almacen, cod_trans_nro,cod_rol,  TblTransaccionBandeja.getValueAt(fila, 4).toString(), gestion, Integer.parseInt(TblTransaccionBandeja.getValueAt(fila, 2).toString()),TblTransaccionBandeja.getValueAt(fila, 1).toString(),TblTransaccionBandeja.getValueAt(fila, 5).toString(),TblTransaccionBandeja.getValueAt(fila, 6).toString(),TblTransaccionBandeja.getValueAt(fila, 7).toString(),TblTransaccionBandeja.getValueAt(fila, 3).toString(),TblTransaccionBandeja.getValueAt(fila, 9).toString(),TblTransaccionBandeja.getValueAt(fila, 10).toString(),TblTransaccionBandeja.getValueAt(fila, 11).toString());
        }
        System.out.println("la cuantia: "+cuantia);
        if(pasa==-1 && !cuantia.equals("ANPE"))
        {
            System.out.println("no tiene que abrir");
            pasa=0;
        }else
        {
            DiagOrdenesDetalle ordenes= new DiagOrdenesDetalle(this,menu,cod_almacen, cod_trans_nro,cod_rol,  TblTransaccionBandeja.getValueAt(fila, 4).toString(), gestion, Integer.parseInt(TblTransaccionBandeja.getValueAt(fila, 2).toString()),TblTransaccionBandeja.getValueAt(fila, 1).toString(),TblTransaccionBandeja.getValueAt(fila, 5).toString(),TblTransaccionBandeja.getValueAt(fila, 6).toString(),TblTransaccionBandeja.getValueAt(fila, 7).toString(),TblTransaccionBandeja.getValueAt(fila, 3).toString(),TblTransaccionBandeja.getValueAt(fila, 9).toString(),TblTransaccionBandeja.getValueAt(fila, 10).toString(),TblTransaccionBandeja.getValueAt(fila, 11).toString());
            ordenes.AbreDialogo();
            pasa=0;
        }
        
//        ordenes.setVisible(true);
        System.out.println("Se cerro la ventanita");
        BtnActualizar.doClick();
    }
    
    void CerrarFrame(){
        menu.CerrarFrameInterno(this);
        System.gc();
        r = Runtime.getRuntime();
        long mem1 = r.freeMemory();
    }
    
    void MostrarReporte(int cod_trans_nro,String cod_estado,int cod_tramite,String titulo){
        System.out.println("cod_trans_nro: "+cod_trans_nro);
        System.out.println("cod_estado: "+cod_estado);
        System.out.println("cod_tramite: "+cod_tramite);
        System.out.println("titulo: "+titulo);
        List list=new ArrayList();
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            Map[] datos=puerto.getReporteOrden(cod_trans_nro,cod_estado,cod_tramite);
            
            if (datos!=null){                 
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
                    trans.setTipo_item(datos[f].get("TIPO_ITEM").toString());
                    trans.setArticulo(datos[f].get("ARTICULO").toString());
                    trans.setDetalle_solicitud(datos[f].get("DETALLE_SOLICITUD").toString());
                    //hoja_ruta,cbte,casa_comercial,direccion,telefono,nit,precio_unit
                    trans.setHoja_ruta(datos[f].get("HOJA_RUTA").toString());
                    trans.setCbte(datos[f].get("CBTE").toString());
                    trans.setCasa_comercial(datos[f].get("CASA_COMERCIAL").toString());
                    trans.setDireccion(datos[f].get("DIRECCION").toString());
                    trans.setTelefono(datos[f].get("TELEFONO").toString());
                    trans.setNit(datos[f].get("NIT").toString());
                    trans.setPrecio_unit(Double.parseDouble(datos[f].get("PRECIO_UNIT").toString()));
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
                    //trans.setCod_trans_detalle(datos[f].get("COD_TRANS_DETALLE").toString());
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
            /*for (int i = 0; i < list.size(); i++) {
                Transaccion aux = (Transaccion) list.get(i);t           
                System.out.println(aux.getNro_gestion()+" "+aux.getFecha_creacion()+" "+ aux.getFecha_envio()+" "+aux.getUnidad_sol()+" "+aux.getUnidad_des()+" "+aux.getUsuario_sol()+" "+aux.getUnidad_medida()+" "+aux.getCantidad_pedido()+" "+aux.getTipo_item()+" "+aux.getArticulo()+" "+aux.getDetalle_solicitud());
            }  */      
        }
        catch (RemoteException e){
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (ServiceException e){ System.out.println("error 1:"+e);} 
        catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this,"LA ORDEN NO FUE APROBADA O \n NO ELIJIO UNA FILA PARA PODER IMPRIMIR EL REPORTE","SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    void MostrarReporte(){
        int fila=TblTransaccionEstado.getSelectedRow();
        int cod_trans_nro=Integer.parseInt(TblTransaccionEstado.getValueAt(fila, 0).toString()); 
        String cod_estado=TblTransaccionEstado.getValueAt(fila, 1).toString();
        //String cod_estado="ALM1";        
        String titulo=TblTransaccionEstado.getValueAt(fila, 4).toString();
        //if ((cod_rol==2 && cod_tramite==3)|| (cod_rol==5 && cod_tramite==2))
            System.out.println(":D :D :D cod_trans: "+cod_trans_nro+" cod_estado: "+cod_estado+" cod_tramite: "+cod_tramite+" titulo: "+titulo);
            reportes.MostrarOrden(cod_trans_nro, "ADQ", 2, "ORDEN DE COMPRA Y/U ORDEN DE SERVICIO");
            //MostrarReporte(cod_trans_nro, cod_estado, cod_tramite, titulo);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnSalir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        PnlTransaccionBandeja = new javax.swing.JScrollPane();
        TblTransaccionBandeja = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnActualizar = new javax.swing.JButton();
        BtnOrdenes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PnlTransaccionEstado = new javax.swing.JScrollPane();
        TblTransaccionEstado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BtnInicio = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnAdelante = new javax.swing.JButton();
        BtnFinal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTF_nroOrden = new javax.swing.JTextField();
        JTF_hojaRuta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(104, 129, 156));
        setClosable(true);
        setTitle("ESTADO DE TRANSACCIONES Y BANDEJA DE ENTRADA");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        BtnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnSalir.setForeground(new java.awt.Color(255, 0, 0));
        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/book_previous.png"))); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSalir);
        BtnSalir.setBounds(510, 640, 150, 25);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(null);

        TblTransaccionBandeja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TblTransaccionBandeja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblTransaccionBandejaMousePressed(evt);
            }
        });
        TblTransaccionBandeja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TblTransaccionBandejaKeyPressed(evt);
            }
        });
        PnlTransaccionBandeja.setViewportView(TblTransaccionBandeja);

        jPanel4.add(PnlTransaccionBandeja);
        PnlTransaccionBandeja.setBounds(20, 60, 1100, 480);

        jPanel1.setBackground(new java.awt.Color(185, 203, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        BtnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnActualizar.setForeground(new java.awt.Color(42, 78, 42));
        BtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/action_refresh_blue.gif"))); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnActualizar);
        BtnActualizar.setBounds(30, 10, 120, 25);

        BtnOrdenes.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        BtnOrdenes.setForeground(new java.awt.Color(0, 102, 153));
        BtnOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/page.png"))); // NOI18N
        BtnOrdenes.setText("Crear Ordenes");
        BtnOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOrdenesActionPerformed(evt);
            }
        });
        jPanel1.add(BtnOrdenes);
        BtnOrdenes.setBounds(170, 10, 140, 25);

        jPanel4.add(jPanel1);
        jPanel1.setBounds(20, 10, 1100, 50);

        jTabbedPane1.addTab("Borrador", jPanel4);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(null);

        TblTransaccionEstado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TblTransaccionEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblTransaccionEstadoMousePressed(evt);
            }
        });
        TblTransaccionEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TblTransaccionEstadoKeyPressed(evt);
            }
        });
        PnlTransaccionEstado.setViewportView(TblTransaccionEstado);

        jPanel3.add(PnlTransaccionEstado);
        PnlTransaccionEstado.setBounds(10, 80, 1120, 470);

        jPanel2.setBackground(new java.awt.Color(185, 203, 221));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        BtnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/resultset_first.png"))); // NOI18N
        BtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioActionPerformed(evt);
            }
        });
        jPanel2.add(BtnInicio);
        BtnInicio.setBounds(40, 30, 30, 25);

        BtnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/resultset_previous.png"))); // NOI18N
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        jPanel2.add(BtnAtras);
        BtnAtras.setBounds(70, 30, 30, 25);

        BtnAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/resultset_next.png"))); // NOI18N
        BtnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdelanteActionPerformed(evt);
            }
        });
        jPanel2.add(BtnAdelante);
        BtnAdelante.setBounds(100, 30, 30, 25);

        BtnFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/resultset_last.png"))); // NOI18N
        BtnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinalActionPerformed(evt);
            }
        });
        jPanel2.add(BtnFinal);
        BtnFinal.setBounds(130, 30, 30, 25);

        jLabel1.setText("Nro. Orden de Compra:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(230, 24, 140, 14);

        jLabel2.setText("Nro. Hoja de Ruta: ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(540, 24, 120, 14);
        jPanel2.add(JTF_nroOrden);
        JTF_nroOrden.setBounds(370, 20, 110, 20);
        jPanel2.add(JTF_hojaRuta);
        JTF_hojaRuta.setBounds(650, 20, 100, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/search_16.png"))); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(800, 5, 140, 25);

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("MOSTRAR TODO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(960, 10, 140, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/info_16.png"))); // NOI18N
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(800, 30, 140, 25);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(10, 20, 1120, 60);

        jTabbedPane1.addTab("Enviados", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 50, 1150, 590);

        setBounds(0, 0, 1193, 706);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        CerrarFrame();
    }//GEN-LAST:event_formInternalFrameClosed

    private void BtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioActionPerformed
        ini=1;fin=ini+x-1;
        LlenaEstados();
        BtnAdelante.setEnabled(true);
        BtnFinal.setEnabled(true);
        BtnInicio.setEnabled(false);
        BtnAtras.setEnabled(false);
    }//GEN-LAST:event_BtnInicioActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        ini=ini-x;
        fin=ini+x-1;
        BtnAdelante.setEnabled(true);
        BtnFinal.setEnabled(true);
        LlenaEstados();
        if (ini==1){
            BtnInicio.setEnabled(false);
            BtnAtras.setEnabled(false);
        }
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdelanteActionPerformed
        ini=fin+1;
        fin=ini+x-1;
        BtnInicio.setEnabled(true);
        BtnAtras.setEnabled(true);
        LlenaEstados();
        if (fin>=tope){
            BtnAdelante.setEnabled(false);
            BtnFinal.setEnabled(false);
        }
    }//GEN-LAST:event_BtnAdelanteActionPerformed

    private void BtnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinalActionPerformed
        ini=((tope/x)*x)+1;
        if (ini>tope)
            ini=tope-x+1;
        fin=ini+x-1;
        LlenaEstados();
        BtnInicio.setEnabled(true);
        BtnAtras.setEnabled(true);
        BtnFinal.setEnabled(false);
        BtnAdelante.setEnabled(false);
    }//GEN-LAST:event_BtnFinalActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        if (cod_rol==4) cod_tramite=1;
        else if(cod_rol==5) cod_tramite=2;
        else if(cod_rol==2) cod_tramite=3;
        System.out.println("rol es: "+cod_rol+" y cod_tramite es:"+cod_tramite);
        CalculaElementosListar();       
    }//GEN-LAST:event_formInternalFrameOpened

    private void TblTransaccionBandejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblTransaccionBandejaMousePressed
        if (evt.getClickCount() == 2)
            AbreItems();
    }//GEN-LAST:event_TblTransaccionBandejaMousePressed

    private void TblTransaccionBandejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblTransaccionBandejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )  {
            AbreItems();
        }
    }//GEN-LAST:event_TblTransaccionBandejaKeyPressed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        CerrarFrame();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        LlenaBandeja();
        LlenaEstados();
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOrdenesActionPerformed
        //menu.AbrirOtroFrame(this, new FrmOrdenesGenera(menu, this, gestion,cod_almacen,cod_usuario ));
        
        DiagOrdenesGenera ordenes= new DiagOrdenesGenera(this,menu,gestion,cod_almacen,cod_usuario);
        this.setVisible(false);
        ordenes.AbreDialogo(); 
        LlenaBandeja();
    }//GEN-LAST:event_BtnOrdenesActionPerformed

    private void TblTransaccionEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblTransaccionEstadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER )  {
            MostrarReporte();
        }
    }//GEN-LAST:event_TblTransaccionEstadoKeyPressed

    private void TblTransaccionEstadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblTransaccionEstadoMousePressed
        if (evt.getClickCount() == 2)
            MostrarReporte();
    }//GEN-LAST:event_TblTransaccionEstadoMousePressed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        LlenaBandeja();
        LlenaEstados();
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();
            System.out.println("Antes de intentar buscar .... :P");
            String nro = "%"+this.JTF_nroOrden.getText().trim()+"%";
            String hoja_ruta = "%"+this.JTF_hojaRuta.getText().trim()+"%";
            
            Map[] datos = puerto.busquedaAdquiOrdenC(gestion, cod_almacen, cod_tramite, nro, hoja_ruta);
            CerearTablaEstados();
            
            if(datos !=null){
                System.out.println("Con datos :D :D :D ..... datos-length: "+datos.length);
                for (int c=0;c<datos.length;c++){
                    estados.insert(c);
                    TblTransaccionEstado.tableChanged(new TableModelEvent(estados, c, c, TableModelEvent.ALL_COLUMNS,TableModelEvent.INSERT));
                    //TblTransaccionEstado.setValueAt(datos[c].get("COD_TRANSACCION"),c,0);
                    TblTransaccionEstado.setValueAt(datos[c].get("COD_TRANS_NRO"),c,0);
                    TblTransaccionEstado.setValueAt(datos[c].get("COD_ESTADO"),c,1);
                    TblTransaccionEstado.setValueAt(datos[c].get("COD_TRAMITE"),c,2);
                    TblTransaccionEstado.setValueAt(datos[c].get("NRO"),c,3);
                    TblTransaccionEstado.setValueAt(datos[c].get("TRAMITE"),c,4);
                    TblTransaccionEstado.setValueAt(datos[c].get("DETALLE"),c,5);
                    TblTransaccionEstado.setValueAt(datos[c].get("UNIDAD_SOL"),c,6);
                    TblTransaccionEstado.setValueAt(datos[c].get("UNIDAD_DES"),c,7);
                    TblTransaccionEstado.setValueAt(datos[c].get("ESTADO"),c,8);                    
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LlenaEstados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.JTF_hojaRuta.setText("");
        this.JTF_nroOrden.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAdelante;
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnFinal;
    private javax.swing.JButton BtnInicio;
    private javax.swing.JButton BtnOrdenes;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTextField JTF_hojaRuta;
    private javax.swing.JTextField JTF_nroOrden;
    private javax.swing.JScrollPane PnlTransaccionBandeja;
    private javax.swing.JScrollPane PnlTransaccionEstado;
    private javax.swing.JTable TblTransaccionBandeja;
    private javax.swing.JTable TblTransaccionEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
