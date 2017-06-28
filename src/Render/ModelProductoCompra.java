/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;


import Controler.C_Categoria;
import Model.Categoria;
import Model.Detallecompra;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Producto;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan
 */
public class ModelProductoCompra extends AbstractTableModel{
    
    List<Producto> lista;
    String [] header =null;

    public ModelProductoCompra(List<Producto> prod) {
        this.lista=prod;
         header = new String [] {"idProducto", "Nombre del Producto", "Marca", "Categoría", "Stock"};
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
    
    public void addRow(Producto prod){
        this.lista.add(prod);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int idProducto){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Comparando producto con ID "+ lista.get(i).getIdProducto()+ "Con id Producto "+ idProducto);
            if (lista.get(i).getIdProducto()==idProducto) {
                System.out.println("Hay una coincidencia");
                lista.remove(i);
            }
        }
        this.fireTableDataChanged();
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idProducto");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
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
                return lista.get(rowIndex).getMarca();
            }
            case 3:{
                return lista.get(rowIndex).getCategoria().getNombre();
            }
            case 4:{
                return lista.get(rowIndex).getStock();
            }
            
                
              
            
        }
        return null;
    }
    
}
