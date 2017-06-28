/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import Controler.C_Cedula;
import Model.Cliente;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan Ramirez
 */
public class ModelClienteFactura extends AbstractTableModel{
    
    List<Cliente> lista;
    String [] header;
    
    public ModelClienteFactura(List<Cliente> lista){
        this.lista=lista;
        header = new String[]{"idCliente","Nombres y Apellidos","Dirección","Teléono", "Numero de Cédula"};
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idCliente");
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
    public String getColumnName(int columnIndex){
        return header[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String NombreYApellidos;
        String nombre, apellido;
        nombre = lista.get(rowIndex).getNombre();
        apellido = lista.get(rowIndex).getApellido();
        NombreYApellidos = nombre + " "+ apellido;
        
        String numeroCedula = C_Cedula.NumeroCedula(lista.get(rowIndex).getIdCliente());
        
        if (numeroCedula==null) {
            numeroCedula="Ninguna";
        }
        
        switch(columnIndex){
            case 0:{
                return lista.get(rowIndex).getIdCliente();
            }
            case 1:{
                return NombreYApellidos;
            }
            case 2:{
                return lista.get(rowIndex).getDireccion();
            }
            case 3:{
                return lista.get(rowIndex).getTelefono();
            }
            case 4:{
                return numeroCedula;    
            }
        }
        
        return null;
    }
    
    
}
