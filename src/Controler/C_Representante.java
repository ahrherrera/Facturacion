/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;



import Model.*;
import Controler.*;
import DAO.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Allan Ramirez
 */
public class C_Representante {

    ProveedorDAO prodao = new ProveedorDAO();
    RepresentanteDAO repdao = new RepresentanteDAO();
    

    public String insert(int idProveedor, String nombre, String apellido, String direccion, String telefono, String Ncedula){
        Representante rep = new Representante();

        rep.setNombre(nombre);
        rep.setApellido(apellido);
        rep.setDireccion(direccion);
        rep.setTelefono(telefono);
        rep.setNumeroCedula(Ncedula);
        
        Proveedor prov = prodao.find(idProveedor);
        rep.setProveedor(prov);
        return repdao.create(rep);
    }


    public String update(int idRepresentante, int idProveedor, String nombre, String apellido, String direccion, String telefono, String Ncedula){
        Representante rep = new Representante();
        rep.setIdRepresentante(idRepresentante);
        rep.setNombre(nombre);
        rep.setApellido(apellido);
        rep.setDireccion(direccion);
        rep.setTelefono(telefono);
        rep.setNumeroCedula(Ncedula);
        Proveedor prov = prodao.find(idProveedor);
        Set representantes = new HashSet(0);
        representantes.add(prov);
        return repdao.update(rep);
    }
    
    public List<Representante> findByName(String nombre){
        return repdao.findByName(nombre);
    }
    
    public List<Representante> findByProveedor(String proveedor){
        return repdao.findByProveedor(proveedor, prodao);
    }
    

    public Representante find(int idRepresentnate){
        return repdao.find(idRepresentnate);
    }

    public List<Representante> findAll(){
        List<Representante> lista = repdao.findAll();
        return lista;
    }
    
    public String [] Busqueda(){
        String [] Buscar = new String[1];
        Buscar[0] = "Por Nombre";
        return Buscar;
    }
    

}
