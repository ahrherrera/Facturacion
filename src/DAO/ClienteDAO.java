package DAO;

import ResultClass.*;
import Hibernate.HibernateFactory;
import Model.*;
import Validations.Validate;
import View.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


import java.sql.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jairo Martinez
 */
public class ClienteDAO extends AbstractDAO{

    private static Validate v = new Validate();
    public ClienteDAO() {
        super();
    }
    
    
    public int save(Cliente cliente) throws DataAccessLayerException {
        int id=0;
        try {
            startOperation();
            id = (int) session.save(cliente);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            
        }
        return id;
    }
    
    public String update(Cliente cliente) throws DataAccessLayerException {
        try {
            startOperation();
            session.update(cliente);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            
        }
        return "";
    }
    
    public Cliente find(int idCliente){
        
        
        Cliente cl = (Cliente) Principal.getSession().get(Cliente.class, idCliente);
        
        return cl;
    } 


    /**
     * Delete a detached Event from the database.
     * @param cliente
     */
    public String delete(Cliente cliente) throws DataAccessLayerException {
        super.delete(cliente);
        return "";
    }

    public List<Cliente> findTodos(){
        return super.findAll(Cliente.class);
    }

    
    public static List<ClienteCompleto> matchfind(int option, String texto) throws DataAccessLayerException {
        startOperation();
        if(option == 1){
            Criteria crit = session.createCriteria(Cliente.class)
                .createAlias("cedulas", "Cedula", Criteria.LEFT_JOIN)
                .add(Restrictions.like("nombre", texto, MatchMode.ANYWHERE));
           
            List<Cliente> list = crit.list();
            return Empleados(list);
        }
        
        if(option == 2){
            Criteria crit = session.createCriteria(Cliente.class)
                .createAlias("cedulas", "Cedula", Criteria.LEFT_JOIN)
                .add(Restrictions.like("apellido", texto, MatchMode.ANYWHERE));
           
            List<Cliente> list = crit.list();
            return Empleados(list);
        }
        
//        if(option == 3){
//            Criteria crit = session.createCriteria(Cliente.class)
//                .createAlias("cedulas", "Cedula", Criteria.LEFT_JOIN)
//                .add(Restrictions.like("id.numeroCedula", texto, MatchMode.ANYWHERE));
//           
//            List<Cliente> list = crit.list();
//            return Empleados(list);
//        }
        
        return null;
    }
    
    public List<ClienteCompleto> findAll(){
        startOperation();
        Criteria crit = session.createCriteria(Cliente.class)
                .createAlias("cedulas", "Cedula", Criteria.LEFT_JOIN);

        List<Cliente> list = crit.list();
        
        return Empleados(list);
    }
    
    private static List<ClienteCompleto> Empleados(List<Cliente> list){
        List<ClienteCompleto> clientes = new ArrayList();
        for (Cliente  c : list) {
            ClienteCompleto cliente = new ClienteCompleto();
            cliente.setIdCliente(c.getIdCliente());
            cliente.setApellido(c.getApellido());
            cliente.setDireccion(c.getDireccion());
            cliente.setNombre(c.getNombre());
            cliente.setTelefono(c.getTelefono());
            cliente.setFoto(c.getFoto());
            cliente.setEstado(c.getEstado());  
            cliente.setFechaIngreso(c.getFechaIngreso());
            
            for (Iterator<Cedula> it = c.getCedulas().iterator(); it.hasNext();) {
                Cedula cd = it.next();
                cliente.setNumeroCedula(cd.getId().getNumeroCedula());
            }
            
            clientes.add(cliente);
        }
        return clientes;
    }
    
    private static JasperPrint print = null;
    private static JasperViewer view = null;
    
    public static void PrintReport(){
        v.PrintReport("ReporteClientes", "Reporte de clientes");
    }
    
    public List<Cliente> buscarPorNombre(String nombre) {
        List<Cliente> lista = new ArrayList<>();
         startOperation();
         Criteria crit = session.createCriteria(Cliente.class)
                 .add(Restrictions.like("nombre", nombre, MatchMode.ANYWHERE));
         
         List<Cliente> lista1 = crit.list();
         
         for (Cliente prod : lista1) {
             
             lista.add(this.find(prod.getIdCliente()));
             
         }
         
         return lista;
    }
    
}
