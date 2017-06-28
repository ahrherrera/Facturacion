/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.*;
import Controler.*;
import DAO.ProductoDAO;
import java.math.BigDecimal;

/*@author Allan Ramirez
 */
public class C_DetalleFactura {
    C_Factura factura = new C_Factura();
    
    public Detallefatura setDetallefatura(int idProducto, BigDecimal precio, int Cantidad, Float descuento){
        
        DetallefaturaId dfid = new DetallefaturaId();
        dfid.setIdProducto(idProducto);
        
        ProductoDAO cprod = new ProductoDAO();
        Producto prod = cprod.find(idProducto);
        
        Detallefatura df = new Detallefatura();
        df.setId(dfid);
        df.setCantidad(Cantidad);
        df.setPrecioUnitario(precio);
        df.setDescuento(descuento);
        df.setProducto(prod);
        //df.setFactura(factura.);
        
        return df;
    }
    
    
}
