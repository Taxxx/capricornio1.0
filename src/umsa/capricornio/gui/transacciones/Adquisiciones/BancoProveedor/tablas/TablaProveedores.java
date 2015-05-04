/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.Adquisiciones.BancoProveedor.tablas;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import umsa.capricornio.domain.ProveedoresData;
import umsa.capricornio.utilitarios.herramientas.ColumnData;

/**
 *
 * @author julian
 */
public class TablaProveedores extends AbstractTableModel 
{
  static final public ColumnData m_columns[] = {
    new ColumnData( "cp", 0, JLabel.RIGHT ),
    new ColumnData( "ce", 0, JLabel.RIGHT ),    
    new ColumnData( "web", 0, JLabel.RIGHT ),
    new ColumnData( "gran_act", 0, JLabel.RIGHT ),
    new ColumnData( "razon_nit", 0, JLabel.RIGHT ),
    new ColumnData( "partida", 50, JLabel.CENTER ),
    new ColumnData( "Casa Comercial",280, JLabel.LEFT ),
    new ColumnData( "Servicio",150, JLabel.LEFT ),
    new ColumnData( "Direccion",150, JLabel.LEFT ),
    new ColumnData( "Telefono", 80, JLabel.CENTER ),   
    new ColumnData( "FAX", 80, JLabel.CENTER ),   
    new ColumnData( "NIT", 80, JLabel.CENTER ),       
    new ColumnData( "estado", 80, JLabel.CENTER )
  };

  protected ArrayList lista;  
  
  public TablaProveedores() {    
      lista = new ArrayList();
  }

  public int getRowCount() {    
    return lista==null ? 0 : lista.size(); 
  }

  public int getColumnCount() { 
    return m_columns.length; 
  } 

    @Override
  public String getColumnName(int column) {
    String str = m_columns[column].m_title;
    return str;
  }
  
    @Override
  public boolean isCellEditable(int nRow, int nCol) {        
        return false;
  }

  public Object getValueAt(int nRow, int nCol) {
    if (nRow < 0 || nRow>=getRowCount())
      return "";
    ProveedoresData row = (ProveedoresData)lista.get(nRow);
    switch (nCol) {
      case 0: return row.cod_proveedor;
      case 1: return row.cod_estado;      
      case 2: return row.web;
      case 3: return row.gran_act;
      case 4: return row.razon_nit;
      case 5: return row.partida;
      case 6: return row.casa_comercial;
      case 7: return row.servicio;
      case 8: return row.direccion;
      case 9: return row.telefono;
      case 10: return row.fax;
      case 11: return row.nit;
      case 12: return row.estado;
    }
    return "";          
  }             
  
    @Override
  public void setValueAt(Object value, int nRow, int nCol) {
    if (nRow < 0 || nRow>=getRowCount())
      return;    
    ProveedoresData row = (ProveedoresData)lista.get(nRow);
    String svalue = value.toString();
    
    switch (nCol) {
      case 0:
        row.cod_proveedor = svalue;
        break;      
      case 1:
        row.cod_estado = svalue;
        break;       
      case 2:
        row.web = svalue;
        break;       
      case 3:
        row.gran_act = svalue;
        break;       
      case 4:
        row.razon_nit = svalue;
        break;       
      case 5:
        row.partida = svalue;
        break;       
      case 6:
        row.casa_comercial = svalue;
        break;       
      case 7:
        row.servicio = svalue;
        break;
      case 8:
        row.direccion = svalue;
        break;
      case 9:
        row.telefono = svalue;
        break;            
      case 10:
        row.fax = svalue;
        break;            
      case 11:
        row.nit = svalue;
        break;            
      case 12:
          row.estado = svalue;          
          break;        
    }
  }
  
  public void insert(int row) {
    if (row < 0)
      row = 0;
    if (row > lista.size())
      row = lista.size();    
    lista.add(row,new ProveedoresData());
  }

  public boolean delete(int row) {
    if (row < 0 || row >= lista.size())
      return false;
    lista.remove(row);
      return true;
  }  
}
