/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controler.C_Categoria;
import Controler.C_Usuario;
import Hibernate.HibernateFactory;
import Model.Categoria;
import Model.Producto;
import Validations.Mensajero;
import View.Manejo_Inventario;
import View.Principal;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Allan Ramirez
 */
public class ProductoDAO extends AbstractDAO {

    C_Categoria ccat = new C_Categoria();

    public ProductoDAO() {
        super();
    }

    public String create(Producto producto) throws DataAccessLayerException {
        return super.saveOrUpdate(producto);
    }

    public String delete(Producto producto) throws DataAccessLayerException {
        return super.delete(producto);
    }

    public Producto find(int id) throws DataAccessLayerException {
        startOperation();
        Producto p = (Producto) session.get(Producto.class, id);
        
        return p;
    }

    public String update(Producto producto) throws DataAccessLayerException {
        return super.saveOrUpdate(producto);
    }

    public List<Producto> findAll() throws DataAccessLayerException {
        return super.findAll(Producto.class);
    }

    public void Actualizar(int idProducto, int Stock, BigDecimal PV, BigDecimal PC) {
        
        System.out.println("/**** Recibiendo de Actualizar ****/");
        System.out.println("idProducto= "+ idProducto+ "\nStock= "+ Stock+ "\nPrecioVenta= "+ PV+"\nPrecioCompra= "+ PC);
        
        
        HibernateFactory.close(session);
        
        try {
            Producto prod = (Producto) Principal.getSession().get(Producto.class, idProducto);
            Principal.closeSession();
            int nuevoStock;
            if (prod.getStock() == null) {
                nuevoStock = Stock;
            } else {
                nuevoStock = Stock + prod.getStock();
            }

            prod.setStock(nuevoStock);
            System.out.println("nuevoStock= "+ nuevoStock);

            if (prod.getPrecioVenta() == null) {
                prod.setUltimoPv(new BigDecimal(0.0));
            } else {
                prod.setUltimoPv(prod.getPrecioVenta());
            }

            prod.setPrecioVenta(PV);
            prod.setPrecioCompra(PC);
            prod.setEstado(Boolean.TRUE);
            
            super.update(prod);
            System.out.println("Actualizando detalle de producto");
            Principal.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Producto> getProdByCat(int idCategoria) {
        List<Producto> lista = new ArrayList<>();

        Categoria cat = ccat.find(idCategoria);

        Iterator it = cat.getProductos().iterator();

        while (it.hasNext()) {

            Producto prod1 = (Producto) it.next();

            Producto prod2 = this.find(prod1.getIdProducto());

            lista.add(prod2);

        }

        return lista;
    }

    public List<Producto> findByName(String Nombre) {
        List<Producto> lista = new ArrayList<>();
        startOperation();
        Criteria crit = session.createCriteria(Producto.class)
                .add(Restrictions.like("nombreProducto", Nombre, MatchMode.ANYWHERE));

        List<Producto> lista1 = crit.list();

        for (Producto prod : lista1) {

            lista.add(this.find(prod.getIdProducto()));

        }
        
        return lista;
    }

    public List<Producto> findByMarca(String marca) {
        List<Producto> lista = new ArrayList<>();
        startOperation();
        Criteria crit = session.createCriteria(Producto.class)
                .add(Restrictions.like("marca", marca, MatchMode.ANYWHERE));

        List<Producto> lista1 = crit.list();

        for (Producto prod : lista1) {

            lista.add(this.find(prod.getIdProducto()));

        }
        
        return lista;

    }

    public void Habilitar(Producto p) {

        startOperation();

        Query q = session.createSQLQuery("update Producto set estado = 1 where idProducto = " + p.getIdProducto() + ";");

        q.executeUpdate();

        

    }

    public void Deshabilitar(Producto p) {
        startOperation();
        Query q = session.createSQLQuery("update Producto set estado = 0 where idProducto = " + p.getIdProducto() + ";");

        q.executeUpdate();
        
    }

    public void ActualizarStock(int idProducto, int Stock) {
        Session s = Principal.getSession();
        try {
            Producto prod = (Producto) s.get(Producto.class, idProducto);
            int nuevoStock;
            if (prod.getStock() == null) {
                return;
            } else {
                nuevoStock = prod.getStock() - Stock;
            }

            prod.setStock(nuevoStock);
            
            //Insertar evaluacion de Stock
            if (nuevoStock<=5) {
                //Notificar a Bodega
                String mensaje = "ALERTA DE STOCK INSUFICIENTE!!"
                        + "\n"
                        + "El stock del Producto:\n" 
                        + "Código: " + prod.getIdProducto()+ "\n" 
                        + "Nombre: "+ prod.getNombreProducto()+ "\n"
                        + "Cantidad Actual: "+ prod.getStock()+ "\n"
                        + "\n"
                        + "Se esta agotando, necesita tomar acciones requeridas.\n"
                        + "No olvide registrar las compras en el sistema de información\n"
                        + "ó llame a su proveedorpara consultar el catalogo";
                
                List<String> lista = new ArrayList<String>();
                //Obtener los correos de los encargados de bodega
                lista.add("allanhavidramirez@gmail.com");
                
                
                Mensajero.enviarMensaje(mensaje,lista);
                
                
            }
            //Principal.mensaje.mostrarNotificacion(titulo, detalle, tipo);

            prod.setEstado(Boolean.TRUE);
            HibernateFactory.close(s);
            super.update(prod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
