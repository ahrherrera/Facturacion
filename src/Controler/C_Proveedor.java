package Controler;


import DAO.ProveedorDAO;
import Model.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C_Proveedor{

    private static ProveedorDAO prodao = new ProveedorDAO();

    public String insert(String nombreProveedor, String telefono, String ruc){
      Proveedor prov = new Proveedor();
      prov.setNombreProveedor(nombreProveedor);
      prov.setTelefono(telefono);
      prov.setRuc(ruc);

      return prodao.insertar(prov);
    }

    public String update(int idProveedor, String nombreProveedor, String telefono, String ruc){
      Proveedor prov = new Proveedor();
      prov.setIdProveedor(idProveedor);
      prov.setNombreProveedor(nombreProveedor);
      prov.setTelefono(telefono);
      prov.setRuc(ruc);
      prov.setFechaRegistro(new Timestamp(System.currentTimeMillis()));

      return prodao.update(prov);
    }

    public Proveedor find(int idProveedor){
      return (Proveedor) prodao.find(idProveedor);
    }

    public List<Proveedor> findAll(){
      return prodao.findAll();
    }
    
    /*
        public int getProveedor(int idRepresentante){  
        return prodao.getProveedor(idRepresentante);
    }
    

    */    public List<Representante> getRepresentantes(int idProveedor){
        return prodao.getRepresentantes(idProveedor);
    }
    
    public String [] Busqueda(){
        String [] Buscar = new String[3];
        Buscar[0] = "Por Nombre";
        Buscar[1] = "Por Teléfono";
        Buscar[2] = "Por RUC";
        return Buscar;
    }

    public List<Proveedor> buscarPorNombre(String nombre){
        return prodao.getProvByName(nombre);
    }
    
    public List<Proveedor> buscarPorRUC(String ruc){
        return prodao.getProvByRUC(ruc);
    }
    
    public List<Proveedor> buscarPorTelefono(String ruc){
        return prodao.getProvByTel(ruc);
    }
    
    
    public static void Representantes_Proveedor() {
        prodao.PrintReport();
    }

    public int getProveedor(int idRepresentante){
        return prodao.getProveedor(idRepresentante);
    }

}
