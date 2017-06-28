package DAO;

import DAO.AbstractDAO;
import static DAO.AbstractDAO.session;
import static DAO.AbstractDAO.startOperation;
import DAO.DataAccessLayerException;
import Hibernate.HibernateFactory;
import Model.*;
import Validations.*;
import ResultClass.*;
import View.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/*@author Allan Ramirez
 */
public class UsuarioDAO extends AbstractDAO {

    public UsuarioDAO() {
        super();
    }

    public int save(Usuario u) {
        int id = 0;
        try {
            startOperation();
            id = (int) session.save(u);
            System.out.println("");
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        }
        
        return id;
    }

    public String update(Usuario u) {
        try {
//            startOperation();
//            session.update(u);
//            closeOperation();

            super.update(u);
            return "Lamentablemente no se pudo completar la accion.";
        } catch (HibernateException e) {
            e.printStackTrace();
            return "No cambiado";
        } 
        
        
    }

    public String create(Usuario u) {
        return super.saveOrUpdate(u);
    }

    public String delete(Usuario u) {
        return super.delete(u);
    }

    public Usuario find(int id) throws DataAccessLayerException {
        startOperation();
        Usuario u = (Usuario) session.get(Usuario.class, id);
        closeOperation();
        return u;
    }

    public List<UsuarioCompleto> matchfind(int option, String texto) {
        
        if (option == 1) {
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class);
            List<Empleado> list = crit.list();
            List<UsuarioCompleto> usuarios = new ArrayList();
            for (UsuarioCompleto usuario : UsuarioCompleto(list)) {
                System.out.println("usuario matchfind: " + usuario.getNombreUsuario());
                if (usuario.getNombreUsuario().toLowerCase().startsWith(texto.toLowerCase())
                        || usuario.getNombreUsuario().toLowerCase().contains(texto.toLowerCase())
                        || usuario.getNombreUsuario().toLowerCase().endsWith(texto.toLowerCase())) {
                    usuarios.add(usuario);
                }
            }
            
            return usuarios;
        }
        if (option == 2) {
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class)
                    .add(Restrictions.like("roll", texto, MatchMode.ANYWHERE));
            List<Empleado> list = crit.list();
            
            return UsuarioCompleto(list);
        }
        if (option == 3) {
            startOperation();
            Criteria crit = session.createCriteria(Empleado.class)
                    .add(Restrictions.like("cargo", texto, MatchMode.ANYWHERE));
            List<Empleado> list = crit.list();
            
            return UsuarioCompleto(list);
        }
        return null;
    }

    public static List<UsuarioCompleto> findAll() {
        startOperation();
        Criteria cp = session.createCriteria(Empleado.class);
        List<Empleado> list = cp.list();
        return UsuarioCompleto(list);
    }

    private static List<UsuarioCompleto> UsuarioCompleto(List<Empleado> list) {
        List<UsuarioCompleto> usuarios = new ArrayList();
        for (Empleado e : list) {
            UsuarioCompleto usuario = new UsuarioCompleto();
            usuario.setIdEmpleado(e.getIdEmpleado());
            usuario.setApellido(e.getApellido());
            usuario.setCargo(e.getCargo());
            usuario.setDireccion(e.getDireccion());
            usuario.setNombre(e.getNombre());
            usuario.setTelefono(e.getTelefono());
            usuario.setFoto(e.getFoto());
            usuario.setEstadoEmpleado(e.getEstado());
            usuario.setFechaIngreso(e.getFechaIngreso());
//            usuario.setSalarioBasico(e.getSalarioBasico());

            for (Iterator<Usuario> it = e.getUsuarios().iterator(); it.hasNext();) {
                Usuario u = it.next();
                usuario.setIdusuario(u.getIdusuario());
                usuario.setNombreUsuario(u.getNombreUsuario());
                usuario.setContraseña(u.getContrasenia());
                usuario.setRoll(u.getRoll());
                usuario.setEstado(u.getEstado());
            }
            
            if (usuario.getIdusuario() != null) {
                try {
                    if (usuario.getEstado()==true) {
                        usuarios.add(usuario);
                    }
                    System.out.println("idUsuario: " + usuario.getIdusuario() + "\t user: " + usuario.getNombreUsuario() + "\t pass: " + Cifrado.descifra(usuario.getContraseña()) + "\t Roll: " + usuario.getRoll());
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return usuarios;
    }

    //Trae los correos de los encargados de BODEGA
    public List<String> getCorreosBodega() {
        List<String> lista = new ArrayList<String>();
        startOperation();
        Criteria crit = session.createCriteria(Usuario.class)
                .add(Restrictions.like("roll", "Bodega", MatchMode.ANYWHERE));
        lista = crit.list();
        
        return lista;
    }

    public static void main(String[] args) {
        try{
        UsuarioDAO u = new UsuarioDAO();
        Usuario user = u.find(3);
        
        user.setContrasenia(Cifrado.cifra("allan"));
        
        u.update(user);
            System.out.println("usuario actualizado");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
