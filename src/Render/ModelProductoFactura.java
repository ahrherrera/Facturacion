/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import Controler.C_Categoria;
import Model.Categoria;
import Model.Producto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan Ramirez
 */
public class ModelProductoFactura extends AbstractTableModel{

    List<Producto> lista;
    String [] header;
    
    public ModelProductoFactura(List<Producto> lista){
        this.lista=lista;
         header = new String [] {"idProducto", "Nombre del Producto", "Marca", "Categoría", "Stock", "Precio Unitario"};
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
    public String getColumnName(int column) {
        return header[column];
    }
    
    public void removeRow(int idProducto){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdProducto()==idProducto) {
                lista.remove(i);
            }
        }
        this.fireTableDataChanged();
    }
    
    public void Clear(){
        for(int indice=lista.size()-1; indice>=0; indice--){
            lista.remove(indice);
        this.fireTableDataChanged();
        }
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idProducto");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        C_Categoria cat = new C_Categoria();
        Categoria cate = cat.find(lista.get(rowIndex).getCategoria().getIdCategoria());
        lista.get(rowIndex).setCategoria(cate);
        
        switch(columnIndex){
            case 0:{
                return lista.get(rowIndex).getIdProducto();
            }
            case 1:{
                return lista.get(rowIndex).getNombreProducto();
            }
            case 2:{
                return lista.get(rowIndex).getMarca();
            }            
            case 3:{
                return lista.get(rowIndex).getCategoria().getNombre();
            }
            case 4:{
                return lista.get(rowIndex).getStock();
            }
            case 5:{
                return lista.get(rowIndex).getPrecioVenta();
            }
        }
        return null;
    }
    
}
