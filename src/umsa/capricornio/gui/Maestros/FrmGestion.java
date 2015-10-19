/*
 * FrmIndicadores.java
 *
 * Created on 24 de julio de 2008, 9:21
 */

package umsa.capricornio.gui.Maestros;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.Map;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.xml.rpc.ServiceException;
import umsa.capricornio.gui.ConnectADQUI.AdquiWSServiceLocator;
import umsa.capricornio.gui.ConnectADQUI.AdquiWS_PortType;
import umsa.capricornio.gui.Maestros.tablas.TablaGestion;
import umsa.capricornio.gui.menu.FrmMenu;
import umsa.capricornio.utilitarios.herramientas.validacion;

/**
 *
 * @author  julian
 */
public class FrmGestion extends javax.swing.JInternalFrame {
    
    TablaGestion gestion;    
        
    Runtime r;
    FrmMenu menu;
    private int fila;
    
    /** Creates new form FrmIndicadores */
    public FrmGestion(FrmMenu menu) {
        this.menu=menu;
        initComponents();
        ConstruyeTablaGestion();
    }

    private void ConstruyeTablaGestion(){        
        gestion = new TablaGestion();        
        TblGestion.setAutoCreateColumnsFromModel(false);
        TblGestion.setModel(gestion); 
        
        for (int k = 0; k < TablaGestion.m_columns.length; k++) {               
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(TablaGestion.m_columns[k].m_alignment);
            TableColumn column = new TableColumn(k, TablaGestion.m_columns[k].m_width, renderer, null);
            TblGestion.addColumn(column);                           
        }        
        JTableHeader header = TblGestion.getTableHeader();
        header.setUpdateTableInRealTime(true);
        header.setReorderingAllowed(true);

        PnlGestion.getViewport().add(TblGestion);        
        //getContentPane().add(PnlTechos, BorderLayout.CENTER);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlGestion = new javax.swing.JScrollPane();
        TblGestion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TxtGestion = new javax.swing.JTextField();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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
        getContentPane().setLayout(null);

        PnlGestion.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion"));

        TblGestion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TblGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblGestionMousePressed(evt);
            }
        });
        PnlGestion.setViewportView(TblGestion);

        getContentPane().add(PnlGestion);
        PnlGestion.setBounds(0, 0, 220, 180);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Administracion de Usuarios"));
        jPanel1.setLayout(null);

        BtnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/page.png"))); // NOI18N
        BtnNuevo.setToolTipText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnNuevo);
        BtnNuevo.setBounds(10, 50, 30, 25);

        BtnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/disk_multiple.png"))); // NOI18N
        BtnGuardar.setToolTipText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnGuardar);
        BtnGuardar.setBounds(40, 50, 30, 25);

        BtnModificar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/page_edit.png"))); // NOI18N
        BtnModificar.setToolTipText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar);
        BtnModificar.setBounds(70, 50, 30, 25);

        BtnEliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/eliminar.gif"))); // NOI18N
        BtnEliminar.setToolTipText("Eliminar");
        BtnEliminar.setEnabled(false);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar);
        BtnEliminar.setBounds(100, 50, 30, 25);

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umsa/capricornio/gui/images/arrow_left.png"))); // NOI18N
        jButton5.setMnemonic('S');
        jButton5.setText("Salir");
        jButton5.setToolTipText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(130, 50, 80, 25);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Gestion");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 80, 20);

        TxtGestion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        TxtGestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtGestionKeyPressed(evt);
            }
        });
        jPanel1.add(TxtGestion);
        TxtGestion.setBounds(100, 20, 60, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 190, 220, 90);

        setBounds(0, 0, 240, 315);
    }// </editor-fold>//GEN-END:initComponents

private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
    BtnEliminar.setEnabled(false);
    BtnModificar.setEnabled(false);
    BtnGuardar.setEnabled(true); 
    TblGestion.setEnabled(true);
    TxtGestion.setText("");    
    TxtGestion.requestFocus(); 
}//GEN-LAST:event_BtnNuevoActionPerformed

private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
     if ("".equals(TxtGestion.getText()) || !(validacion.valNumero(TxtGestion.getText(), 4, 4))) {
        javax.swing.JOptionPane.showMessageDialog(this,"Debe introducir datos numericos","SYSTEM CAPRICORN SYSTEM",
        javax.swing.JOptionPane.ERROR_MESSAGE);  
        TxtGestion.requestFocus();        
        return;
    }
    
    int res = javax.swing.JOptionPane.showConfirmDialog( this,"¿Desea guardar los datos?",
                "Traspasos Presupuestarios",javax.swing.JOptionPane.YES_NO_OPTION );
    if (res == javax.swing.JOptionPane.NO_OPTION) return;
    try {   AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();                
            Map[] datos = datos=puerto.setGestion("SET-insDataGes",Integer.parseInt(TxtGestion.getText().trim()));                
            javax.swing.JOptionPane.showMessageDialog(this,"Gestion registrada","SYSTEM CAPRICORN SYSTEM",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);              
            LlenaGestion();                          
            TxtGestion.setText("");                    
            TxtGestion.requestFocus();                                                     
        } catch (RemoteException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+ex,"SYSTEM CAPRICORN SYSTEM",
                            javax.swing.JOptionPane.ERROR_MESSAGE);    } 
        catch (ServiceException ex) {}
}//GEN-LAST:event_BtnGuardarActionPerformed

void CerearTablaGestion(){
        int f = TblGestion.getRowCount();
        for (int i=f;i>=0;i--){
             if (gestion.delete(i)) {
                TblGestion.tableChanged(new TableModelEvent(
                gestion, i, i, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)); 
             }
        }
    }

private void LlenaGestion(){
    CerearTablaGestion();    
        try{
            AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();             
            Map[] datos= puerto.getGestion();
            if (datos!=null){
                for (int c=0;c<datos.length;c++){
                    gestion.insert(c);                    
                    TblGestion.tableChanged(new TableModelEvent(gestion, c, c, TableModelEvent.ALL_COLUMNS,TableModelEvent.INSERT)); 
                    TblGestion.setValueAt(datos[c].get("COD_GESTION"),c,0);
                    TblGestion.setValueAt(datos[c].get("GESTION"),c,1);                    
                }                
            }                    
        }
        catch (RemoteException e){ 
            javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+e,"SYSTEM CAPRICORN SYSTEM",
                        javax.swing.JOptionPane.ERROR_MESSAGE);           
        }
        catch (ServiceException e){ System.out.println(e);}        
    }

private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
    int res = javax.swing.JOptionPane.showConfirmDialog( this,"¿Desea Modificar esta Gestion?",
                "SYSTEM CAPRICORN SYSTEM",javax.swing.JOptionPane.YES_NO_OPTION );
    if (res == javax.swing.JOptionPane.NO_OPTION) return;
    
    int f = TblGestion.getSelectedRow();
    int cod_gestion=Integer.parseInt(TblGestion.getValueAt(f, 0).toString());
    try {   AdquiWSServiceLocator servicio = new AdquiWSServiceLocator();
            AdquiWS_PortType puerto = servicio.getAdquiWS();                      
            Map[] datos = puerto.setGestionModif("SET-insDataGes",cod_gestion,Integer.parseInt(TxtGestion.getText().trim()));            
            javax.swing.JOptionPane.showMessageDialog(this,"Datos modificados","SYSTEM CAPRICORN SYSTEM",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);                      
            LlenaGestion();                
            BtnEliminar.setEnabled(false);
            BtnModificar.setEnabled(false);
            BtnGuardar.setEnabled(true);  
            TblGestion.setEnabled(true);
            TxtGestion.setText("");
            TxtGestion.requestFocus();
    } catch (RemoteException ex) {
        javax.swing.JOptionPane.showMessageDialog(this,"<html> error de conexion con el servidor <br> "+ex,"SYSTEM CAPRICORN SYSTEM",
                        javax.swing.JOptionPane.ERROR_MESSAGE);    } 
    catch (ServiceException ex) {}
}//GEN-LAST:event_BtnModificarActionPerformed

private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
  // 
}//GEN-LAST:event_BtnEliminarActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    menu.CerrarFrameInterno(this);
    System.gc();
    r = Runtime.getRuntime();
    long mem1 = r.freeMemory();
}//GEN-LAST:event_jButton5ActionPerformed

private void TxtGestionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtGestionKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER )  {
        if (BtnModificar.isEnabled()==true)
            BtnModificar.doClick();
        else BtnGuardar.doClick();
    }
}//GEN-LAST:event_TxtGestionKeyPressed
    
private void TblGestionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblGestionMousePressed
    if (evt.getClickCount() == 2) {        
        BtnModificar.setEnabled(true);
        BtnGuardar.setEnabled(false);
        TblGestion.setEnabled(false);
        fila=TblGestion.getSelectedRow();    
        TxtGestion.setText(TblGestion.getValueAt(fila,1).toString()); 
    }
}//GEN-LAST:event_TblGestionMousePressed

private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
    LlenaGestion();
    BtnGuardar.setEnabled(true);
    BtnModificar.setEnabled(false);
    BtnEliminar.setEnabled(false);
}//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JScrollPane PnlGestion;
    private javax.swing.JTable TblGestion;
    private javax.swing.JTextField TxtGestion;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
