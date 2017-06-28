/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.*;
import Model.Cliente;
import Model.Detallefatura;
import Model.Empleado;
import Model.Factura;
import View.V_Factura;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Allan Ramirez
 */
public class C_Factura {
    Set<Detallefatura> detallesFactura = new HashSet(0);
    FacturaDAO fdao = new FacturaDAO();
    EmpleadoDAO empdao = new EmpleadoDAO();
    ClienteDAO cldao = new ClienteDAO();
    
    public C_Factura(){
        
    }
    
    public String guardarFactura(int idCliente, int idEmpleado){
        try{
            
            Factura f = new Factura();
            Empleado emp = empdao.find(idEmpleado);
            Cliente cliente = cldao.find(idCliente);
            
            f.setEmpleado(emp);
            f.setCliente(cliente);
            f.setDetallefaturas(detallesFactura);
            f.setFecha(new Timestamp(System.currentTimeMillis()));
            
            int idFactura = fdao.insertarFactura(f);
            V_Factura.idFactura = idFactura;
            f.setIdFactura(idFactura);
            
            for (Detallefatura de: detallesFactura) {
                DetalleFacturaDAO dfdao = new DetalleFacturaDAO();
                de.getId().setIdFactura(idFactura);
                de.setFactura(f);
                dfdao.create(de);
                C_Producto cp = new C_Producto();
                cp.ActualizarProducto(de.getProducto().getIdProducto(), de.getCantidad());
            }
            
            return "¡Factura realizada exitosamente..!";
        }catch(RuntimeException re){
            re.printStackTrace();
            return "¡Error al realizar la factura..!";
        }
    }
    
    public int siguienteFactura(){
        return fdao.getSigFactura();
    }
    
    public static void PrintReport(BigDecimal subTotal, BigDecimal iva, BigDecimal total){
        FacturaDAO.PrintReport(subTotal, iva, total);
    }

    public static void ReporteInventario(){
        FacturaDAO.ReporteInventario();
    }
    public void nuevaFactura(Detallefatura detfa) {
        detallesFactura.add(detfa);
    }
}
