/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.AbstractDAO.startOperation;
import Hibernate.HibernateFactory;
import Model.*;
import View.Principal;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Allan Ramirez
 */
public class DetalleCompraDAO extends AbstractDAO{
    
    public DetalleCompraDAO(){
        super();
    }
    
    public String create(Detallecompra dc){
        return super.saveOrUpdate(dc);
    }
    
    public void update(Detallecompra dc){
        super.update(dc);
    }
    
    public List<Detallecompra> buscarPorIDProducto(int idProducto){
        startOperation();
        
        Query sql = session.createSQLQuery("Select dc.idCompra, c.fechaCompra, dc.costo, dc.cantidad, dc.`cantidadDisponible` from DetalleCompra dc\n" +
                                     "inner join Compra c\n" +
                                     "on c.idCompra = dc.idCompra\n" +
                                     "where dc.`idProducto`="+ idProducto+" and dc.cantidadDisponible > 0");
        List lista = sql.list();
        
        List<Detallecompra> listaD = new ArrayList<>();
        
        Iterator it=lista.iterator();
                    while(it.hasNext()){
                         Detallecompra dc = new Detallecompra();
                         Compra c = new Compra();
                         
                        Object obj[]=(Object[])it.next();
                        c.setIdCompra((Integer)obj[0]);
                        System.out.println("IDCOMPRA = "+c.getIdCompra());
                        Timestamp stamp = (Timestamp) obj[1];
                        Date dat = new Date(stamp.getTime());
                        
                        c.setFechaCompra(dat);
                        System.out.println("Fecha = "+c.getFechaCompra());
                        dc.setCosto((BigDecimal)obj[2]);
                        System.out.println("Costo = "+dc.getCosto());
                        dc.setCantidad((Integer) obj[3]);
                        System.out.println("Cantidad =" +dc.getCantidad());
                        dc.setCantidadDisponible((Integer) obj[4]);
                        System.out.println("Cant Dispo = "+dc.getCantidadDisponible());
                        dc.setCompra(c);
                        
                        listaD.add(dc);
                        // Solamente se lleno CompraID y el objeto de Detallecompra
                    }
                    
        
        
        return listaD;
    }
    
    public Detallecompra findbyCompraAndProducto(int idCompra, int idProducto){
        
        startOperation();
            Query query = session.createQuery("from "+ Detallecompra.class.getName() + " where idCompra = " + idCompra + " and idProducto = "+ idProducto);
            System.out.println("Ejecutando HQL");
            Detallecompra lista = (Detallecompra) query.uniqueResult();

        
        
        
        
        System.out.println("Detalle compra encontrada, idCompra = "+ lista.getId().getIdCompra() +
                            "\n idProducto = "+ lista.getProducto().getIdProducto() +
                            "\nCantidad = "+ lista.getCantidad() + " Cantidad Disponible = "+ lista.getCantidadDisponible() +
                            "\n Precio Comprado = "+ lista.getCosto() );
        
        HibernateFactory.close(session);
        Principal.closeSession();
        
        return lista;
        
        
        
    }
    
    
    
}
