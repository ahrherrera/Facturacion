package DAO;

import Controler.C_Cliente;
import static DAO.AbstractDAO.startOperation;
import Hibernate.HibernateFactory;
import Model.Cedula;
import Model.CedulaId;
import Model.Cliente;
import View.Principal;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Jairo Martinez
 */
public class CedulaDAO extends AbstractDAO{
    
    public CedulaDAO(){
        super();
    }
    
    public String save(Cedula cedula) throws DataAccessLayerException {
        try {
            startOperation();
            session.save(cedula);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            
        }
        return "";
    }
    
    public String update(Cedula cedula) throws DataAccessLayerException {
        super.update(cedula);
        return "";
    }

    /**
     * Delete a detached Event from the database.
     * @param cedula
     */
    public String delete(Cedula cedula) throws DataAccessLayerException {
        super.delete(cedula);
        return "";
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public CedulaId find(int id) throws DataAccessLayerException {
        return (CedulaId) super.find(CedulaId.class, id);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return null;
    }
    
    public String getCedula(int idCliente){
        C_Cliente cc = new C_Cliente();
        Cliente c = cc.find(idCliente);
        
        Iterator it = c.getCedulas().iterator();
        
        while(it.hasNext()){
            Cedula ced = (Cedula) it.next();
            return ced.getId().getNumeroCedula();
        }
        
        return null;        
    }
    
    
    
}
