package Render;

import ResultClass.ClienteCompleto;
import Model.*;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/*@author Jairo Martinez*/

public class ModelTableCliente extends AbstractTableModel{
    
    List<ClienteCompleto> clientes ;
    String[] header ;
    
    public ModelTableCliente(List<ClienteCompleto> clientes) {
        this.clientes = clientes;
        this.header = new String []{"idCliente", "Cédula", "Nombres", "Apellidos", "Teléfono", "Dirección", "Fecha Ingreso", "Estado", "Foto"};
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }
    
    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public void Clear(){
        for(int indice=clientes.size()-1; indice>=0; indice--){
            clientes.remove(indice);
        this.fireTableDataChanged();
        }
    }

    public void addRow(ClienteCompleto cliente) {
        clientes.add(cliente);
        this.fireTableDataChanged();
    }

    public List<ClienteCompleto> listaClientes() {
        return clientes;
    }
    
    public void ColumnSize(JTable table){
        //"idCliente", "Cedula", "Nombres", "Apellidos", "Teléfono", "Dirección", "Fecha Ingreso", "Estado", "Foto"
        TableColumn tc2 = table.getColumn("idCliente");
        tc2.setMinWidth(0);
        tc2.setMaxWidth(0); 
        
        TableColumn tc3 = table.getColumn("Cédula");
        tc3.setMinWidth(110);
        tc3.setMaxWidth(120); 
        
        TableColumn tc4 = table.getColumn("Nombres");
        tc4.setMinWidth(150);
        //tc4.setMaxWidth(160); 
        
        TableColumn tc5 = table.getColumn("Apellidos");
        tc5.setMinWidth(150);
        //tc5.setMaxWidth(160); 
        
        TableColumn tc6 = table.getColumn("Teléfono");
        tc6.setMinWidth(70);
        tc6.setMaxWidth(75); 
        
        TableColumn tc7 = table.getColumn("Dirección");
        tc7.setMinWidth(150);
        //tc7.setMaxWidt150); 
        
        TableColumn tc8 = table.getColumn("Fecha Ingreso");
        tc8.setMinWidth(140);
        tc8.setMaxWidth(140); 
        
        TableColumn tc9 = table.getColumn("Estado");
        tc9.setMinWidth(0);
        tc9.setMaxWidth(0); 
        
        TableColumn tc10 = table.getColumn("Foto");
        tc10.setMinWidth(0);
        tc10.setMaxWidth(0); 
    }
      
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){//"idCliente", "Cedula", "Nombres", "Apellidos", "Teléfono", "Dirección", "Fecha Ingreso", "Estado", "Foto"
            case 0:     return clientes.get(rowIndex).getIdCliente(); 
            case 1:     return clientes.get(rowIndex).getNumeroCedula();
            case 2:     return clientes.get(rowIndex).getNombre();
            case 3:     return clientes.get(rowIndex).getApellido();
            case 4:     return clientes.get(rowIndex).getTelefono();
            case 5:     return clientes.get(rowIndex).getDireccion();
            case 6:     return clientes.get(rowIndex).getFechaIngreso();
            case 7:     return clientes.get(rowIndex).isEstado();
            case 8:     return clientes.get(rowIndex).getFoto();
        }
        return null;
    }
    
}
