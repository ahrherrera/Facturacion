/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateFactory;
import Model.*;
import View.Principal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Allan Ramirez
 */
public class RepresentanteDAO extends AbstractDAO {

    public RepresentanteDAO() {
        super();
    }

    public String create(Representante rep) {
        return super.saveOrUpdate(rep);
    }

    public Representante find(int id) throws DataAccessLayerException {
        
        Representante rep = (Representante) Principal.getSession().get(Representante.class, id);
        return rep;
    }

    public String update(Representante rep) throws DataAccessLayerException {
        return super.saveOrUpdate(rep);
    }

    public List<Representante> findAll() throws DataAccessLayerException {
        return super.findAll(Representante.class);
    }

    public List<Representante> findByName(String nombre) {
        List<Representante> lista = new ArrayList<>();

        Criteria crit = Principal.getSession().createCriteria(Representante.class)
                .add(Restrictions.like("nombre", nombre, MatchMode.ANYWHERE));

        List<Representante> lista1 = crit.list();

        for (Representante prod : lista1) {

            lista.add(this.find(prod.getIdRepresentante()));

        }
        return lista;
    }

    public List<Representante> findByProveedor(String proveedor, ProveedorDAO prodao) {
        List<Representante> lista = new ArrayList<>();

        try {
            Proveedor prov = prodao.getProvByName(proveedor).get(0);
            System.out.println("Cantidad de proveedores encontrados: " + prodao.getProvByName(proveedor).size());
            System.out.println("Id proveedor: "+ prov.getIdProveedor());
            Criteria crit = Principal.getSession().createCriteria(Representante.class)
                    .add(Restrictions.eq("proveedor", prov));

            List<Representante> lista1 = crit.list();

            for (Representante prod : lista1) {
                lista.add(this.find(prod.getIdRepresentante()));
            }
        } catch (Exception ex) {
            System.err.println("No se encontro Ninguno");
            ex.printStackTrace();
        }
        
        return lista;

    }

}
