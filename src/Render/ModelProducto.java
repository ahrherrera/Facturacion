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
public class ModelProducto extends AbstractTableModel {

    List<Producto> lista;
    String [] header;

    public ModelProducto (List<Producto> lista){
        this.lista=lista;
        header = new String []{"Código","Nombre del Producto","Descripción","Marca","Categoría","Stock","Precio de Venta","Precio de Compra"};
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
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("Código");
        tc1.setMinWidth(50);
        tc1.setMaxWidth(50);  
        TableColumn tc2 = table.getColumn("Stock");
        tc2.setMinWidth(50);
        tc2.setMaxWidth(50); 
    }
    
    public void addRow(Producto prod){
        this.lista.add(prod);
        this.fireTableDataChanged();
    }

    public void Clear(){
        for(int indice=lista.size()-1; indice>=0; indice--){
            lista.remove(indice);
        this.fireTableDataChanged();
        }
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
                return lista.get(rowIndex).getDescripcion();
            }
            case 3:{
                return  lista.get(rowIndex).getMarca();
            }
            case 4:{
                return lista.get(rowIndex).getCategoria().getNombre();
            }
            case 5:{
                if (lista.get(rowIndex).getStock()==null) {
                    return "Sin Existencia";
                }else{
                    return lista.get(rowIndex).getStock();
                }
            }
            case 6:{
                if (lista.get(rowIndex).getPrecioVenta()==null) {
                    return "Sin precio";
                }else{
                    return lista.get(rowIndex).getPrecioVenta();
                }
            }
            case 7:{
                if (lista.get(rowIndex).getPrecioCompra()==null) {
                    return "Sin precio";
                }else{
                    return lista.get(rowIndex).getPrecioCompra();
                }
                
            }

        }
        return null;
    }




}
