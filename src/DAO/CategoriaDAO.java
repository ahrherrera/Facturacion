
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateFactory;
import Model.Categoria;
import View.Principal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Allan
 */
public class CategoriaDAO extends AbstractDAO {

    public CategoriaDAO() {
        super();
    }

    public String create(Categoria cat) throws DataAccessLayerException {
        return super.saveOrUpdate(cat);
    }

    public String update(Categoria cat) throws DataAccessLayerException {
        return super.saveOrUpdate(cat);
    }

    public Categoria find(int id) throws DataAccessLayerException {
        
        Categoria p = (Categoria) Principal.getSession().get(Categoria.class, id);
        
        return p;
    }

    public List<Categoria> findAll() throws DataAccessLayerException {
        return super.findAll(Categoria.class);
    }

    public List<Categoria> busquedaPorNombre(String nombreCategoria) throws DataAccessLayerException {
        startOperation();

        Criteria crit = session.createCriteria(Categoria.class)
                .add(Restrictions.like("nombre", nombreCategoria, MatchMode.ANYWHERE));
        
        return crit.list();
    }

    public List<String> RetornaCategoria() {
        startOperation();

        Criteria cr = session.createCriteria(Categoria.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("nombre"), "nombre"))
                .setResultTransformer(Transformers.aliasToBean(Categoria.class));

        List<Categoria> lista = cr.list();

        List<String> listaR = new ArrayList<>();

        listaR.add("Seleccione una Categoria...");

        for (Categoria c : lista) {
            listaR.add(c.getNombre());
        }
        
        return listaR;

    }

    public int getIdPorNombre(String nombreCategoria) {
        startOperation();

        Criteria cr = session.createCriteria(Categoria.class)
                .add(Restrictions.like("nombre", nombreCategoria, MatchMode.ANYWHERE));

        List<Categoria> lista = cr.list();
        
        return lista.get(0).getIdCategoria();
    }

}
