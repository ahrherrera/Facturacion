/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import Model.Categoria;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan Ramirez
 */
public class ModelCategoria extends AbstractTableModel {

    String[] header;
    List<Categoria> lista;

    public ModelCategoria(List<Categoria> lista) {
        this.lista = lista;
        header = new String[]{"idCategoria", "Nombre", "Descripción"};
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

    public void addRow(Categoria prod) {
        this.lista.add(prod);
        this.fireTableDataChanged();
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idCategoria");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
    }

    public void Clear() {
        for (int indice = lista.size() - 1; indice >= 0; indice--) {
            lista.remove(indice);
            this.fireTableDataChanged();
        }
        
        
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:{
                return lista.get(rowIndex).getIdCategoria();
            }
            
            case 1:{
                return lista.get(rowIndex).getNombre();
            }
            
            case 2:{
                return lista.get(rowIndex).getDescripcion();
            }
        }
        return null;
    }

}
