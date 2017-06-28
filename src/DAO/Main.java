/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import View.Principal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Allan Ramirez
 */
public class Main {

    public static void main(String[] args) {

        Configuration a = new Configuration().configure("Hibernate//hibernate.cfg.xml");

        SessionFactory s = a.buildSessionFactory();

        try {

            Session se = s.openSession();
        Criteria cr = se.createCriteria(Categoria.class)
                .add(Restrictions.like("nombre", "Ordenadores Portatiles", MatchMode.ANYWHERE));
        
        List<Categoria> lista = cr.list();
        
                
            System.out.println(lista.get(0).getIdCategoria());
            
        } catch (RuntimeException e) {
            throw new DataAccessLayerException(e);
        }

    }

}
