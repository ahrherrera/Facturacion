/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;


import Model.*;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan Ramirez
 */
public class ModelTableCompraProducto extends AbstractTableModel {
    
    List<Detallecompra> lista;
    String [] header =null;

    public ModelTableCompraProducto(List<Detallecompra> prod) {
        this.lista=prod;
         header = new String [] {"idProducto", "Nombre del Producto", "Marca", "Categoría", "Cantidad", "Precio"};
    }

    @Override
    public int getRowCount() {
        
        return lista.size();
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idProducto");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
      @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public void addRow(Detallecompra prod){
        this.lista.add(prod);
        this.fireTableDataChanged();
    }

    public void Clear(){
        for(int indice=lista.size()-1; indice>=0; indice--){
            lista.remove(indice);
        this.fireTableDataChanged();
        }
    }
    
    public void removeRow(int rowIndex){
        lista.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    public void editCantidad(int rowIndex, int cantidad){
        lista.get(rowIndex).setCantidad(cantidad);
        this.fireTableDataChanged();
    }
    
    public Detallecompra getDetalleCompra(int rowIndex){
        return lista.get(rowIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        switch(columnIndex){
            case 0:{
                return lista.get(rowIndex).getProducto().getIdProducto();
            }
            case 1:{
                return lista.get(rowIndex).getProducto().getNombreProducto();
            }
            case 2:{
                return lista.get(rowIndex).getProducto().getMarca();
            }
            case 3:{
                return lista.get(rowIndex).getProducto().getCategoria().getNombre();
            }
            case 4:{
                return lista.get(rowIndex).getCantidad();
            }
            case 5:{
                return lista.get(rowIndex).getCosto();
            }
              
            
        }
        return null;
    }
    
    
    
    
    
    
    
}
