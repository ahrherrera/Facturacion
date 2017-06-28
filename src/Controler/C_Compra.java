/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.*;
import Model.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Allan Ramirez
 */
public class C_Compra {

    CompraDAO dao = new CompraDAO();
    EmpleadoDAO empdao = new EmpleadoDAO();
    RepresentanteDAO repdao = new RepresentanteDAO();
    Set<Detallecompra> detalleCompra = new HashSet(0);

    public C_Compra() {
    }

    /*      Se ejecuta esto cuando se termina de llenar la coleccion detalleCompra      */
    public String insertarCompra(int idEmpleado, int idRepresentante, String refer) {
        
        try{
        Compra c = new Compra();
        Empleado emp = empdao.find(idEmpleado);
        Representante rep = repdao.find(idRepresentante);
        c.setEmpleado(emp);
        c.setRepresentante(rep);
        c.setDetallecompras(detalleCompra);
        c.setFechaCompra(new Timestamp(System.currentTimeMillis()));
        c.setNumeroFactura(refer);
        
        Integer idCompra = dao.create(c);
        
        c.setIdCompra(idCompra);

        for (Detallecompra s : detalleCompra) {
            DetalleCompraDAO dcdao = new DetalleCompraDAO();
            s.getId().setIdCompra(idCompra);
            s.setCantidadDisponible(s.getCantidad());
            s.setCompra(c);
            dcdao.create(s);
        }
        
        
        return "Ingresado";
        
        }catch(RuntimeException re){
            re.printStackTrace();
            return "Error";
        }
        
        
    }

    public void nuevaCompra(Detallecompra dcompra) {
        detalleCompra.add(dcompra);
    }
    
    public Compra buscarCompra(int id){
        return dao.buscar(id);
    }
    
    

}
