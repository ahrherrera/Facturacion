package Controler;

import static Controler.C_Cliente.cddao;
import DAO.EmpleadoDAO;
import Model.*;
import ResultClass.EmpleadoCompleto;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*@author Allan Ramirez
 */
public class C_Empleado {
    private static EmpleadoDAO edao = new EmpleadoDAO();
    public static String insert_update(boolean isNuevo, int idE, String nombre, String apellido, String direccion ,  
            String numeroCedula, String telefono, String cargo, byte[] foto){
        if(isNuevo){//  Insertar
            /*      Empleado        */
            Empleado e= new Empleado();
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setNumeroCedula(numeroCedula);
            e.setFoto(foto);
            e.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
            e.setCargo(cargo);
            e.setEstado(true);
            
            edao.save(e);
        }
        
        if(!isNuevo){ //    Actualizar
            /*      Persona         */
            Empleado e= new Empleado();
            e.setIdEmpleado(idE);
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setNumeroCedula(numeroCedula);
            e.setFoto(foto);
            e.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
            e.setCargo(cargo);
            e.setEstado(true);
          
            edao.update(e);
        }
            
        return "";
    }
    
//    public static String delete(int idEmpleado, int idPersona, String nombre, String apellido, String direccion, Date FechaIngreso, String cargo, BigDecimal salarioBasico){
//        Persona per = new Persona();
//        
//        per.setIdPersona(idPersona);
//        per.setNombre(nombre);
//        per.setApellido(apellido);
//        per.setDireccion(direccion);
//        
//        Empleado emp = new Empleado();
//        emp.setIdEmpleado(idEmpleado);
//        emp.setPersona(per);
//        emp.setFechaIngreso(FechaIngreso);
//        emp.setCargo(cargo);
//        emp.setSalarioBasico(salarioBasico);
//        
//        return edao.delete(emp);
//    }
    
    public static Empleado find(int id){
        return edao.find(id);
    }
    
    public static Empleado findObject(int id){
        return edao.findObject(id);
    }
    
    public static List<Empleado> matchfind(int option, String texto){
        return edao.matchfind(option, texto);
    }
    
    public static List<Empleado> findAll(){
        return edao.findAll();
    }
    
    public static void PrintReport(){
        edao.PrintReport();
    } 
    
    public static void cambiarEstado(int idEmpleado){
        Empleado emp = find(idEmpleado);
        if (emp.getEstado()==true) {
            emp.setEstado(false);
        }else{
            emp.setEstado(true);
        }
        edao.updateEstado(emp);
    }
    
    public static Usuario retorna(int idEmpleado){
        Empleado emp = find(idEmpleado);
        
        Iterator it = emp.getUsuarios().iterator();
        Usuario user = new Usuario();
        while(it.hasNext()){
            user = (Usuario) it.next();
        }
        
        if(user==null){
            user.setNombreUsuario("Ninguno");
            user.setCorreo("Ninguno");
            System.err.println("Ningun Usuario Asignado");
        }
        
        return user;
    }
}
