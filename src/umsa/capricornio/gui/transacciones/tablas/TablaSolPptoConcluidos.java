/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.gui.transacciones.tablas;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import umsa.capricornio.domain.SolicitudPptoConcluidosData;
import umsa.capricornio.utilitarios.herramientas.ColumnData;

/**
 *
 * @author julian
 */
public class TablaSolPptoConcluidos extends AbstractTableModel 
{
  static final public ColumnData m_columns[] = {
    new ColumnData( "Cert.Ppto.", 25, JLabel.CENTER ),
    new ColumnData( "Hoja Ruta", 25, JLabel.CENTER ),
    new ColumnData( "Actividad", 70, JLabel.CENTER ),
    new ColumnData( "Detalle", 350, JLabel.LEFT ),
    new ColumnData( "Fuente", 80, JLabel.CENTER ),
    new ColumnData( "Monto", 40, JLabel.RIGHT )   
  };

  protected ArrayList lista;

  public TablaSolPptoConcluidos() {    
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
    SolicitudPptoConcluidosData row = (SolicitudPptoConcluidosData)lista.get(nRow);
    switch (nCol) {
      case 0: return row.m_sol_ppto;
      case 1: return row.m_hoja_ruta;
      case 2: return row.m_apert_prog;      
      case 3: return row.m_detalle;
      case 4: return row.m_fuente;      
      case 5: return row.m_monto;      
    }
    return "";          
  }             
  
    @Override
  public void setValueAt(Object value, int nRow, int nCol) {
    if (nRow < 0 || nRow>=getRowCount())
      return;
    SolicitudPptoConcluidosData row = (SolicitudPptoConcluidosData)lista.get(nRow);
    String svalue = value.toString();
    
    switch (nCol) {
      case 0:
          row.m_sol_ppto = svalue;
        break;  
      case 1:        
          row.m_hoja_ruta = svalue;
        break;      
      case 2:        
          row.m_apert_prog = svalue;
        break;      
      case 3:
          row.m_detalle = svalue;
        break;
      case 4:
          row.m_fuente = svalue;
        break;      
      case 5:
          row.m_monto = svalue;
        break;      
    }
  }
  
  public void insert(int row) {
    if (row < 0)
      row = 0;
    if (row > lista.size())
      row = lista.size();
    lista.add(row,new SolicitudPptoConcluidosData());
  }

  public boolean delete(int row) {
    if (row < 0 || row >= lista.size())
      return false;
    lista.remove(row);
      return true;
  }  
}
