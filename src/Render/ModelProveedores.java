/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import java.util.List;
import Model.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan Ramirez
 */
public class ModelProveedores extends AbstractTableModel{
     List<Proveedor> lista;
    String [] header;
    
    public ModelProveedores(List<Proveedor> lista){
        this.lista=lista;
        header = new String [] {"idProveedor","Nombre del Proveedor","Teléfono","RUC","Fecha del Registro"};
    }

    public void Clear(){
        for(int indice=lista.size()-1; indice>=0; indice--){
            lista.remove(indice);
        this.fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    @Override
    public String getColumnName(int columnIndex){
        return header[columnIndex];
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idProveedor");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:{
                return lista.get(rowIndex).getIdProveedor();
            }
            case 1:{
                return lista.get(rowIndex).getNombreProveedor();
            }
            case 2:{
                return lista.get(rowIndex).getTelefono();
            }
            case 3:{
                return lista.get(rowIndex).getRuc();
            }
            case 4:{
                return lista.get(rowIndex).getFechaRegistro();
            }
            
        }
        return null;
    }
    
    
}
