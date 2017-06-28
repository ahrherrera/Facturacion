package Controler;

import DAO.CedulaDAO;
import Model.Cedula;
import Model.CedulaId;
import View.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Jairo Martinez
 */
public class C_Cedula {

    Session session = null;
    static CedulaDAO cdao = new CedulaDAO();

    public C_Cedula(Session session) {
        this.session = session;
    }

    public static String Insert_Update(int idCliente, String cedula) {
        CedulaId c = new CedulaId();
        c.setIdCliente(idCliente);
        c.setNumeroCedula(cedula);
        return null; //cdao.create(c);
    }

    public static List<CedulaId> findAll() {
        return cdao.findAll();
    }

    //Solo para extraer una cedula en el Set
    public static String NumeroCedula(int idCliente) {
        return cdao.getCedula(idCliente);
    }

}
