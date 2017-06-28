package DAO;

import static DAO.AbstractDAO.startOperation;
import Hibernate.HibernateFactory;
import Model.*;
import View.Principal;
import org.hibernate.HibernateException;

/**
 *
 * @author Allan Ramirez
 */
public class DetalleFacturaDAO extends AbstractDAO{

    
    public String create(Detallefatura detalleFactura) throws DataAccessLayerException {
        return super.saveOrUpdate(detalleFactura);
    }
    
}
