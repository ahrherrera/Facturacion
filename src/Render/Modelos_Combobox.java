/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

/**
 *
 * @author ahrhe
 */
public class Modelos_Combobox {
    
    static String [] busquedaProducto = new String[]{"nombre","marca","categoría"};
    static String [] busquedaCliente = new String[]{"nombre","cédula"};
    static String [] busquedaProveedor = new String[]{"nombre","RUC"};
    static String [] busquedaRepresentantes = new String[]{"nombre","proveedor"};
    static String [] busquedaEmpleado = new String[]{"nombre","cédula"};
    static String [] busquedaCompra = new String[]{"proveedor","fecha"};

    public static String[] getBusquedaProducto() {
        return busquedaProducto;
    }

    public static String[] getBusquedaCliente() {
        return busquedaCliente;
    }

    public static String[] getBusquedaProveedor() {
        return busquedaProveedor;
    }

    public static String[] getBusquedaRepresentantes() {
        return busquedaRepresentantes;
    }

    public static String[] getBusquedaEmpleado() {
        return busquedaEmpleado;
    }
    
    
    
    
}
