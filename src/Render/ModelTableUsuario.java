package Render;

import ResultClass.ClienteCompleto;
import Model.*;
import ResultClass.UsuarioCompleto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/*@author Jairo Martinez*/

public class ModelTableUsuario extends AbstractTableModel{
    
    List<UsuarioCompleto> usuarios ;
    String[] header ;
   
    public ModelTableUsuario(List<UsuarioCompleto> usuarios) {
        this.usuarios = usuarios;
        this.header = new String []{"idEmpleado", "idUsuario", 
        "Nombre Usuario", "Contraseña", "Roll", "Estado",  "Numero de Cédula", "Nombres",
        "Apellidos", "Teléfono", "Dirección", "Fecha Ingreso", "Cargo", "Estado Empleado", "Foto"};
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
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
        for(int indice=usuarios.size()-1; indice>=0; indice--){
            usuarios.remove(indice);
        this.fireTableDataChanged();
        }
    }

    public void addRow(UsuarioCompleto usuario) {
        usuarios.add(usuario);
        this.fireTableDataChanged();
    }

    public List<UsuarioCompleto> listaUsuarios() {
        return usuarios;
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc2 = table.getColumn("idEmpleado");
        tc2.setMinWidth(0);
        tc2.setMaxWidth(0); 
        
        TableColumn tc3 = table.getColumn("idUsuario");
        tc3.setMinWidth(0);
        tc3.setMaxWidth(0); 
        
        TableColumn tc4 = table.getColumn("Nombre Usuario");
        tc4.setMinWidth(150);
        //tc4.setMaxWidth(160); 
        
        TableColumn tc5 = table.getColumn("Contraseña");
        tc5.setMinWidth(150);
        //tc5.setMaxWidth(160); 
        
        TableColumn tc6 = table.getColumn("Roll");
        tc6.setMinWidth(100);
        tc6.setMaxWidth(110); 
        
        TableColumn tc7 = table.getColumn("Estado");
        tc7.setMinWidth(0);
        tc7.setMaxWidth(0); 

        TableColumn tc8 = table.getColumn("Numero de Cédula");
        tc8.setMinWidth(0);
        tc8.setMaxWidth(0); 
        
        TableColumn tc9 = table.getColumn("Nombres");
        tc9.setMinWidth(0);
        tc9.setMaxWidth(0); 
        
        TableColumn tc10 = table.getColumn("Apellidos");
        tc10.setMinWidth(0);
        tc10.setMaxWidth(0);
        
        TableColumn tc11 = table.getColumn("Teléfono");
        tc11.setMinWidth(0);
        tc11.setMaxWidth(0);
        
        TableColumn tc12 = table.getColumn("Dirección");
        tc12.setMinWidth(0);
        tc12.setMaxWidth(0);
        
        TableColumn tc13 = table.getColumn("Fecha Ingreso");
        tc13.setMinWidth(0);
        tc13.setMaxWidth(0);
        
        TableColumn tc14 = table.getColumn("Cargo");
        tc14.setMinWidth(0);
        tc14.setMaxWidth(0);
        
        TableColumn tc15 = table.getColumn("Salario Básico");
        tc15.setMinWidth(0);
        tc15.setMaxWidth(0);
        
        TableColumn tc16 = table.getColumn("Estado Empleado");
        tc16.setMinWidth(0);
        tc16.setMaxWidth(0);
        
        TableColumn tc17 = table.getColumn("Foto");
        tc17.setMinWidth(0);
        tc17.setMaxWidth(0);        
    }
      
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
                    case 0:     return usuarios.get(rowIndex).getIdEmpleado();
                    case 1:     return usuarios.get(rowIndex).getIdusuario();
                    case 2:     return usuarios.get(rowIndex).getNombreUsuario();
                    case 3:     return usuarios.get(rowIndex).getContraseña();
                    case 4:     return usuarios.get(rowIndex).getRoll();
                    case 5:     return usuarios.get(rowIndex).getEstado();
                    
                    case 6:     return usuarios.get(rowIndex).getNumeroCedula();
                    case 7:     return usuarios.get(rowIndex).getNombre();
                    case 8:     return usuarios.get(rowIndex).getApellido();
                    case 9:     return usuarios.get(rowIndex).getTelefono();
                    case 10:     return usuarios.get(rowIndex).getDireccion();
                    case 11:     return usuarios.get(rowIndex).getFechaIngreso();
                    case 12:     return usuarios.get(rowIndex).getCargo();
                    case 13:     return usuarios.get(rowIndex).getSalarioBasico();
                    case 14:     return usuarios.get(rowIndex).getEstadoEmpleado();
                    case 15:     return usuarios.get(rowIndex).getFoto();
        }
        return null;
    }
    
}
