/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Render;


import Model.Representante;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author Allan Ramirez
 */
public class ModelRepresentanteProveedor extends AbstractTableModel {

    List<Representante> lista;
    String [] header;

    public ModelRepresentanteProveedor (List<Representante> lista){
        this.lista=lista;
        header = new String []{"idRepresentante","Nombre","Apellidos","Dirección", "Teléfono", "Numero de Cédula"};
    }

     @Override
    public int getRowCount() {
        
        return lista.size();
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idRepresentante");
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
    
    public void addRow(Representante prod){
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
        switch(columnIndex){
            case 0:{
                return lista.get(rowIndex).getIdRepresentante();
            }
            case 1:{
                return lista.get(rowIndex).getNombre();
            }
            case 2:{
                return lista.get(rowIndex).getApellido();
            }
            case 3:{
                return lista.get(rowIndex).getDireccion();
            }
            case 4:{
                return lista.get(rowIndex).getTelefono();
            }
            case 5:{
                return lista.get(rowIndex).getNumeroCedula();
            }

        }
        return null;
    }




}
