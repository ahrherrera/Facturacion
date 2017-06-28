package Render;

import Controler.C_Compra;
import Controler.C_Proveedor;
import Controler.C_Representante;
import Model.Compra;
import Model.Detallecompra;
import Model.Proveedor;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/*@author Allan Ramirez
 */
public class ModelCompras extends AbstractTableModel {
    List<Detallecompra> lista;
    String [] header;
    
    public ModelCompras(List<Detallecompra> listaR){
        this.lista=listaR;
        header = new String [] {"idCompra","Fecha de Compra","Cantidad","Precio","Nombre del Proveedor", "Cantidad a Pasar"};
    }
    
    @Override
    public int getRowCount() {
        
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    public void editCantidad(int rowIndex, int cantidad){
        lista.get(rowIndex).setCantidadLlevar(cantidad);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex){
        lista.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    public Detallecompra getDetalleCompra(int rowIndex){
        return lista.get(rowIndex);
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("Cantidad a Pasar");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
        
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int idCompra = lista.get(rowIndex).getCompra().getIdCompra();
        C_Compra cc= new C_Compra();
        Compra c = cc.buscarCompra(idCompra);
        lista.get(rowIndex).setCompra(c);
        C_Proveedor prov = new C_Proveedor();
        C_Representante rep = new C_Representante();
        int idRepre = c.getRepresentante().getIdRepresentante();
        int idProv = prov.getProveedor(rep.find(idRepre).getIdRepresentante());
        Proveedor p = prov.find(idProv);
        switch(columnIndex){
            case 0:{
                return lista.get(rowIndex).getCompra().getIdCompra();
            }
            case 1:{
                return lista.get(rowIndex).getCompra().getFechaCompra();
            }
            case 2:{
                return lista.get(rowIndex).getCantidadDisponible();
            }
            case 3:{
                return lista.get(rowIndex).getCosto();
            }
            case 4:{
                return p.getNombreProveedor();
            }
            case 5:{
                return lista.get(rowIndex).getCantidadLlevar();
            }
        }
        return null;
    }
    
    
    
}
