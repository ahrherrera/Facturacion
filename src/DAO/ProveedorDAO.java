package DAO;

import Controler.C_Empleado;
import Controler.C_Representante;
import static DAO.AbstractDAO.session;
import Hibernate.HibernateFactory;
import Model.Proveedor;
import Model.Representante;
import Validations.Validate;
import View.Principal;
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
public class ProveedorDAO extends AbstractDAO {

    private static Validate v = new Validate();
    
    public ProveedorDAO() {
        super();
    }

    public String insertar(Proveedor prov) {
        return super.saveOrUpdate(prov);
    }

    public String update(Proveedor prov) {
        return super.saveOrUpdate(prov);
    }

    public String delete(Proveedor prov) {
        return super.delete(prov);
    }

    public Proveedor find(int id) {
        startOperation();
        Proveedor p = (Proveedor) session.get(Proveedor.class, id);

        return p;
    }

    public List<Proveedor> findAll() {
        startOperation();

        List objects = null;
        Query query = session.createQuery("from " + Proveedor.class.getName());
        System.out.println("Ejecutando HQL");
        objects = query.list();
        
        return objects;

    }
    /*
    public int getProveedor(int idRepresentante){
        C_Representante cemp = new C_Representante();
        Representante emp = cemp.find(idRepresentante);
        System.out.println("ID Representante : " + idRepresentante);
        
        Iterator it = emp.getProveedors().iterator();

        Proveedor prov = new Proveedor();
        while(it.hasNext()){
            prov = (Proveedor) it.next();
            
        }
        
        System.out.println("ID Proveedor encontrado : "
            + prov.getIdProveedor());
        return prov.getIdProveedor();
    }
    */
    public List<Representante> getRepresentantes(int idProveedor){
        Proveedor prov = this.find(idProveedor);
        List<Representante> lista = new ArrayList<>();
        C_Representante crep = new C_Representante();
        
        Iterator it = prov.getRepresentantes().iterator();
        
        while(it.hasNext()){
            Representante rep = (Representante) it.next();
            Representante res = crep.find(rep.getIdRepresentante());
            lista.add(res);
        }
        return lista;
    }
    
    public List<Proveedor> getProvByName(String nombreProv){
        List<Proveedor> lista = new ArrayList<>();
        startOperation();
        Criteria crit = session.createCriteria(Proveedor.class)
                 .add(Restrictions.like("nombreProveedor", nombreProv, MatchMode.ANYWHERE));
         
         List<Proveedor> lista1 = crit.list();
         
         for (Proveedor prod : lista1) {
             
             lista.add(this.find(prod.getIdProveedor()));
             
         }
         return lista;

     }
    
    public List<Proveedor> getProvByRUC(String RUC){
        List<Proveedor> lista = new ArrayList<>();
        startOperation();
        Criteria crit = session.createCriteria(Proveedor.class)
                 .add(Restrictions.like("ruc", RUC, MatchMode.ANYWHERE));
         
         List<Proveedor> lista1 = crit.list();
         
         for (Proveedor prod : lista1) {
             
             lista.add(this.find(prod.getIdProveedor()));
             
         }
         return lista;

     }
        
    public List<Proveedor> getProvByTel(String telefono){
        List<Proveedor> lista = new ArrayList<>();
        startOperation();
        Criteria crit = session.createCriteria(Proveedor.class)
                 .add(Restrictions.like("telefono", telefono, MatchMode.ANYWHERE));
         
         List<Proveedor> lista1 = crit.list();
         
         for (Proveedor prod : lista1) {
             
             lista.add(this.find(prod.getIdProveedor()));
             
         }
         return lista;

     }

    public void PrintReport() {
        v.PrintReport("ProveedorRepresentante", "Representantes por proveedor");
    }

    public int getProveedor(int idRepresentante) {
        C_Representante crep = new C_Representante();
        Representante rep = crep.find(idRepresentante);
        return rep.getProveedor().getIdProveedor();
    }

}




