/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.CategoriaDAO;
import Model.*;
import java.util.List;

/**
 *
 * @author Allan
 */
public class C_Categoria {
    CategoriaDAO catdao = new CategoriaDAO();
    
    public String create(String nombre, String descripcion){
        Categoria cat = new Categoria();
        cat.setNombre(nombre);
        cat.setDescripcion(descripcion);
        cat.setEstado(Boolean.TRUE);
        
        return catdao.create(cat);
    }
    
    public String update(int idCategoria, String nombre, String descripcion){
        Categoria cat = new Categoria();
        cat.setIdCategoria(idCategoria);
        cat.setNombre(nombre);
        cat.setDescripcion(descripcion);
        
        return catdao.update(cat);
    }
    
    public Categoria find(int idCategoria){
        return catdao.find(idCategoria);
    }
    
    public List<Categoria> findAll(){
        return catdao.findAll();
    }
    
    public List<Categoria> busquedaporNombre(String nombreCategoria){
        return catdao.busquedaPorNombre(nombreCategoria);
    }
    
    public List<String> getNombres(){
        return catdao.RetornaCategoria();
    }
    
    public int getIdPorNombre(String nombre){
        return catdao.getIdPorNombre(nombre);
    }
    
}
