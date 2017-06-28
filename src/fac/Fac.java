/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jairo Martinez
 */
public class Fac {

    /**
     * @param args the command line arguments
     */
    static Configuration config ;
    static Session session;
    static SessionFactory sessionfactory;
    
    public static void main(String[] args) {
        config = new Configuration().configure("Hibernate//hibernate.cfg.xml");
        sessionfactory = config.buildSessionFactory();
        
        try{
        session = sessionfactory.openSession();
        System.out.println("conexion establecida");
        }catch(Exception ex){
            System.out.println("No hay conexion");
        }
        
    }
    
}
