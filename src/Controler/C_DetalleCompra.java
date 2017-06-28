/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.DetalleCompraDAO;
import DAO.ProductoDAO;
import Model.*;
import Model.Producto;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Allan Ramirez
 */
public class C_DetalleCompra {
    DetalleCompraDAO dc= new DetalleCompraDAO();
    
    public Detallecompra setDetalleCompra(int idProducto, BigDecimal costo, Integer cantidad){
        
        DetallecompraId det= new DetallecompraId();
        det.setIdProducto(idProducto);
        ProductoDAO prodao = new ProductoDAO();
        
        Producto prod = prodao.find(idProducto);
        
        Detallecompra dcompra= new Detallecompra();
        dcompra.setProducto(prod);
        dcompra.setCantidad(cantidad);
        dcompra.setCantidadDisponible(cantidad);
        dcompra.setCosto(costo);
        dcompra.setId(det);
        
        return dcompra;
    }
    
    public List<Detallecompra> findByProducto(int idProducto){
        return dc.buscarPorIDProducto(idProducto);
    }
    
    public Detallecompra buscarCompraYProducto(int idCompra, int idProducto){
        return dc.findbyCompraAndProducto(idCompra, idProducto);
    }
    
    public void update(Detallecompra dt){
        dc.update(dt);
    }
    
   
    
}
