/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import DAO.ProductoDAO;
import Model.*;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Allan
 */
public class C_Producto {
    ProductoDAO prodao = new ProductoDAO();
    C_Categoria ccat = new C_Categoria();
    
    public String create(String nombreProd, String marca, String descripcion, String NombreCategoria){
        Categoria cat = ccat.find(ccat.getIdPorNombre(NombreCategoria));
        Producto prod = new Producto();
        prod.setNombreProducto(nombreProd);
        prod.setDescripcion(descripcion);
        prod.setMarca(marca);
        prod.setCategoria(cat);
        prod.setUltimoPv(BigDecimal.ZERO);
        
        return prodao.create(prod);
    }
    
    public String update(int idProducto, String nombreProd, String marca, String descripcion, String NombreCategoria){
        Categoria cat = ccat.find(ccat.getIdPorNombre(NombreCategoria));
       
        Producto prod = new Producto();
        prod.setIdProducto(idProducto);
        prod.setNombreProducto(nombreProd);
        prod.setDescripcion(descripcion);
        prod.setMarca(marca);
        prod.setCategoria(cat);
        // Para obtener precios y que no llegen vacios
        
        Producto PP = this.find(idProducto);
        prod.setStock(PP.getStock());
        prod.setPrecioCompra(PP.getPrecioCompra());
        prod.setPrecioVenta(PP.getPrecioVenta());
        prod.setUltimoPv(PP.getUltimoPv());
        
        return prodao.update(prod);
    }
    
    public List<Producto> findAll(){
        return prodao.findAll();
    }
    
    public Producto find(int id){
        return prodao.find(id);
    }

    public void Actualizar(int idProducto, int stock, BigDecimal precioVenta, BigDecimal precioCompra){
        prodao.Actualizar(idProducto, stock, precioVenta, precioCompra);
    }
    
    public void ActualizarProducto(int idProducto, int stock){
        prodao.ActualizarStock(idProducto, stock);
    }
    
    
    
    public List<Producto> getProductosPorCategoria(int idCategoria){
        return prodao.getProdByCat(idCategoria);
    }
    
    public List<Producto> getProductosPorNombre(String nombre){
        return prodao.findByName(nombre);
    }
    
    public List<Producto> getProductosPorMarca(String marca){
        return prodao.findByMarca(marca);
    }
    
    public void CambiarEstado(int idProducto){
        
        
         Producto p = find(idProducto);
         
         if (p.getEstado()==true) {
             prodao.Deshabilitar(p);
         }else{
             prodao.Habilitar(p);
         }
         
}
}
