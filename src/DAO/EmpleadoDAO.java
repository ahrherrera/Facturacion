package DAO;

import static DAO.AbstractDAO.startOperation;
import Hibernate.HibernateFactory;
import Model.*;
import ResultClass.EmpleadoCompleto;
import Validations.Validate;
import View.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author Allan Ramirez
 */
public class EmpleadoDAO extends AbstractDAO{
    private static Validate v = new Validate();
    public EmpleadoDAO(){
        super();
    }
    
    public String create(Empleado emp){
        return super.saveOrUpdate(emp);
    }
    
    public int save(Empleado e){
        int id=0;
        try {
            startOperation();
            id = (int) session.save(e);
            System.out.println("");
            tx.commit();
        } catch (HibernateException ex) {
            handleException(ex);
        } finally {
            
        }
        return id;
    }
    
    public String update(Empleado e){
        try {
            startOperation();
            session.update(e);
            System.out.println("");
            tx.commit();
        } catch (HibernateException ex) {
            handleException(ex);
        } finally {
            
        }
        return "";
    }
    
    public String updateEstado(Empleado emp){
        try{
            super.update(emp);
        }catch(HibernateException ex){
            handleException(ex);
        }
        return "";
    }
    
    public String delete(Empleado emp){
        return super.delete(emp);
    }
    
    public Empleado find(int id){
        startOperation();
        Empleado e = (Empleado) session.get(Empleado.class, id);
        
        return e;
    }
    
    public List<Empleado> matchfind(int option, String texto) throws DataAccessLayerException {
        
        if(option == 1){
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class)
                .add(Restrictions.like("nombre", texto, MatchMode.ANYWHERE));
           
            List<Empleado> list = crit.list();
            
            return Empleados(list);
        }
        
        if(option == 2){
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class)
                .add(Restrictions.like("apellido", texto, MatchMode.ANYWHERE));
            List<Empleado> list = crit.list();
            
            return Empleados(list);
        }
        
        
        if(option == 3){
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class)
                .add(Restrictions.like("numeroCedula", texto, MatchMode.ANYWHERE));
            List<Empleado> list = crit.list();
            
            return Empleados(list);
        }
        
        if(option == 4){
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class)
                .add(Restrictions.like("cargo", texto, MatchMode.ANYWHERE));
            List<Empleado> list = crit.list();
            
            return Empleados(list);
        }
        return null;
    }
    
    public static  List<Empleado> findAll(){
        startOperation();
        Criteria crt = session.createCriteria(Empleado.class);

        List<Empleado> empleados = crt.list();
        System.out.println("Numero de Empleados: " + empleados.size());
        
        return Empleados(empleados);
        
        
    }
    public static void main(String[] args) {
        for(Empleado e: findAll()){
            System.out.println("empleado -> "+e.getNombre());
        }
    }
    
    private static List<Empleado> Empleados(List<Empleado> list){
        List<Empleado> empleados = new ArrayList();
        for(Empleado e: list){
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(e.getIdEmpleado());
            empleado.setNombre(e.getNombre());
            empleado.setApellido(e.getApellido());
            empleado.setDireccion(e.getDireccion());
            empleado.setTelefono(e.getTelefono());
            empleado.setNumeroCedula(e.getNumeroCedula());
            empleado.setFoto(e.getFoto());
            empleado.setCargo(e.getCargo());
            empleado.setFechaIngreso(e.getFechaIngreso());
            empleado.setEstado(e.getEstado());
              
            empleados.add(empleado);
          }
          return empleados;
    }
    
    public static void PrintReport(){
        v.PrintReport("ReporteEmpleados", "Reporte de empleados");
    }

    public Empleado findObject(int id) {
        startOperation();
        Empleado emp = (Empleado) session.get(Empleado.class, id);
        
        return emp;
    }
}
