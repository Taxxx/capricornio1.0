/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.tablas;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import umsa.capricornio.domain.OrdenesTblData;
import umsa.capricornio.utilitarios.herramientas.ColumnData;

/**
 *
 * @author julian
 */
public class TablaOrdenes extends AbstractTableModel 
{
  static final public ColumnData m_columns[] = {
    new ColumnData( "ctd", 0, JLabel.RIGHT ),
    new ColumnData( "ce", 0, JLabel.RIGHT ),
    new ColumnData( "Orden", 100, JLabel.LEFT ),
    new ColumnData( "Articulo", 400, JLabel.LEFT )    
  };

  protected ArrayList lista;
  
  public TablaOrdenes() {    
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
    OrdenesTblData row = (OrdenesTblData)lista.get(nRow);
    switch (nCol) {
      case 0: return row.cod_trans_detalle;
      case 1: return row.cod_estado;
      case 2: return row.nro_orden;
      case 3: return row.articulo;      
    }
    return "";          
  }             
  
    @Override
  public void setValueAt(Object value, int nRow, int nCol) {
    if (nRow < 0 || nRow>=getRowCount())
      return;    
    OrdenesTblData row = (OrdenesTblData)lista.get(nRow);
    String svalue = value.toString();
    
    switch (nCol) {
      case 0:
        row.cod_trans_detalle = svalue;
        break;      
      case 1:
        row.cod_estado = svalue;
        break;      
      case 2:
        row.nro_orden = svalue;
        break;      
      case 3:
        row.articulo = svalue;
        break;            
    }
  }
  
  public void insert(int row) {
    if (row < 0)
      row = 0;
    if (row > lista.size())
      row = lista.size();    
    lista.add(row,new OrdenesTblData());
  }

  public boolean delete(int row) {
    if (row < 0 || row >= lista.size())
      return false;
    lista.remove(row);
      return true;
  }  
}
