/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.AbstractDAO.session;
import Hibernate.HibernateFactory;
import Model.Compra;
import View.Principal;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author Allan Ramirez
 */
public class CompraDAO extends AbstractDAO{
    
    public CompraDAO() {
        super();
    }

    /**
     * Insert a new Event into the database.
     * @param compra     
     */
    public Integer create(Compra compra) throws DataAccessLayerException {
        return super.onlySave(compra);
    }

    public Compra buscar(int id) {

        Compra c = (Compra) Principal.getSession().get(Compra.class, id);
        Principal.closeSession();
        
        return c;
    }


    
    
    
}
