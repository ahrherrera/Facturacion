package Render;

import Model.*;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Controler.*;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Allan Ramirez
 */
public class ModelDetalleFactura extends AbstractTableModel {

    List<Detallefatura> lista;
    String[] header;

    public ModelDetalleFactura(List<Detallefatura> lista) {
        this.lista = lista;
        header = new String[]{"idProducto", "Nombre del Producto", "Descripción", "Cantidad", "Precio", "Subtotal"};
    }//                             0               1                   2               3           4       5           

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    public List<Detallefatura> getLista(){
        return lista;
    }

    public void addRow(int idProducto, int cantidad, BigDecimal precio) {
        C_Producto cp = new C_Producto();
        C_Categoria cc = new C_Categoria();
        Producto prodn = cp.find(idProducto);
        Categoria cat = cc.find(prodn.getCategoria().getIdCategoria());
        prodn.setCategoria(cat);
        Detallefatura df = new Detallefatura();
        DetallefaturaId dfid = new DetallefaturaId();

        df.setProducto(prodn);
        df.setCantidad(cantidad);
        df.setPrecioUnitario(precio);
        dfid.setIdProducto(idProducto);
        df.setId(dfid);
        lista.add(df);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public void removeRow(int RowIndex) {
        lista.remove(RowIndex);
        this.fireTableDataChanged();
    }
    
    public void ColumnSize(JTable table){
        TableColumn tc1 = table.getColumn("idProducto");
        tc1.setMinWidth(0);
        tc1.setMaxWidth(0);   
    }

    public void cambiarCantidad(int rowIndex, int Cantidad) {
        lista.get(rowIndex).setCantidad(Cantidad);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0: {
                return lista.get(rowIndex).getId().getIdProducto();
            }
            case 1: {
                return lista.get(rowIndex).getProducto().getNombreProducto();
            }
            case 2: {
                return lista.get(rowIndex).getProducto().getDescripcion();
            }
            case 3: {
                return lista.get(rowIndex).getCantidad();
            }
            case 4: {
                return lista.get(rowIndex).getPrecioUnitario();
            }
            case 5:{
                BigDecimal cantidad;
                BigDecimal PU;
                cantidad = new BigDecimal(lista.get(rowIndex).getCantidad());
                PU = lista.get(rowIndex).getPrecioUnitario();
                return PU.multiply(cantidad);
            }

        }

        return null;
    }

}
