package DAO;

import Hibernate.HibernateFactory;
import View.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class AbstractDAO {
    public static  Session session;
    public static Transaction tx;
    private static final String ip      = "localhost";
    private static final String url     = "jdbc:mysql://"+ip+":3306/facturacion?zeroDateTimeBehavior=convertToNull";
    private static final String user    = "jairo";
    private static final String password= "Sistemas.93";
    private static Connection connection = null;
    
    public AbstractDAO() {
        HibernateFactory.buildIfNeeded();
    }
    
    protected Integer onlySave(Object obj){
        int idCompra =-1;
        try {
            startOperation();
            idCompra = (Integer) session.save(obj);
            tx.commit();
            
        } catch (HibernateException e) {
            handleException(e);
            
        } finally {
            HibernateFactory.close(session);
        }
        
        return idCompra;
    }

    protected int save(Object obj) {
        int id=0;
        try {
            startOperation();
            id = (int) session.save(obj);
            System.out.println("");
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return id;
    }
    
      protected String saveOrUpdate(Object obj) {
        
        try {
            startOperation();
            session.saveOrUpdate(obj);
            tx.commit();
            return "Insertado exitosamente";
        } catch (HibernateException e) {
            e.printStackTrace();
            return "Error";
        } finally {
            HibernateFactory.close(session);
        }
    }
    
    protected String  update(Object obj) {
        try {
            startOperation();
            session.update(obj);
            System.out.println("");
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return "";
    }

    protected String  delete(Object obj) {
        try {
            startOperation();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return "";
    }

    protected Object find(Class clazz, int id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }
    
    protected List findAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            System.out.println("Ejecutando HQL");
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }

    protected static void handleException(HibernateException e) throws DataAccessLayerException {
        HibernateFactory.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    protected static  void startOperation() throws HibernateException {
        session = HibernateFactory.openSession();
        tx = session.beginTransaction();
    }
    
    protected static void closeOperation() throws HibernateException{
        session.close();
        tx.commit();
    }
 
    
    public static Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver de Conexiòn no Encontrado", "Error de Driver", JOptionPane.ERROR_MESSAGE);
            System.err.println("Driver de Conexiòn no Encontrado \n"+ex.getMessage());}   
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Coneccion establecida..!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexiòn en la Base de Datos del Sistema...", "Error de Conexiòn", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error de Conexiòn con la Base de Datos del Sistema...\n"+ex.getMessage());} 
        return connection;
    } 
    
    public static void CloseConnection(){
        try {
            connection.close();
            System.out.println("Cierre de conexion..!");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        conexion();
        System.out.println("conectado a la DB");
        CloseConnection();
    }
}
