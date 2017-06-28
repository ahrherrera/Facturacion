package Render;

import Model.Empleado;
import ResultClass.EmpleadoCompleto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/*@author Jairo Martinez
 */
public class ModelTableEmpleado extends AbstractTableModel{
    List<Empleado> empleados ;
    String[] header ;
    
    public ModelTableEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
        this.header = new String []{"idCliente", "Número de Cédula", "Nombres",
        "Apellidos", "Teléfono", "Dirección", "Fecha Ingreso", "Estado", "Foto", "Cargo"};
    }
    
    @Override
    public int getRowCount() {
        return empleados.size();
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
        for(int indice=empleados.size()-1; indice>=0; indice--){
            empleados.remove(indice);
        this.fireTableDataChanged();
        }
    }

    public void addRow(Empleado empleado) {
        empleados.add(empleado);
        this.fireTableDataChanged();
    }

    public List<Empleado> listaClientes() {
        return empleados;
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc2 = table.getColumn("idCliente");
        tc2.setMinWidth(0);
        tc2.setMaxWidth(0); 
        
        TableColumn tc3 = table.getColumn("Número de Cédula");
        tc3.setMinWidth(110);
        tc3.setMaxWidth(120); 
        
        TableColumn tc4 = table.getColumn("Nombres");
        tc4.setMinWidth(150);
        //tc4.setMaxWidth(160); 
        
        TableColumn tc5 = table.getColumn("Apellidos");
        tc5.setMinWidth(150);
        //tc5.setMaxWidth(160); */
        
        TableColumn tc6 = table.getColumn("Teléfono");
        tc6.setMinWidth(70);
        tc6.setMaxWidth(75); 
        
        TableColumn tc7 = table.getColumn("Dirección");
        tc7.setMinWidth(150);
        //tc7.setMaxWidth(150); 
        
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
        switch(columnIndex){    
                    case 0:     return empleados.get(rowIndex).getIdEmpleado();
                    case 1:     return empleados.get(rowIndex).getNumeroCedula();
                    case 2:     return empleados.get(rowIndex).getNombre();
                    case 3:     return empleados.get(rowIndex).getApellido();
                    case 4:     return empleados.get(rowIndex).getTelefono();
                    case 5:     return empleados.get(rowIndex).getDireccion();
                    case 6:     return empleados.get(rowIndex).getFechaIngreso();
                    case 7:     return empleados.get(rowIndex).getEstado();
                    case 8:     return empleados.get(rowIndex).getFoto();
                    case 9:    return empleados.get(rowIndex).getCargo();
        }
        return null;
    }
    
}
