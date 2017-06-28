package Controler;

import DAO.UsuarioDAO;
import Controler.*;
import DAO.*;
import Model.*;
import ResultClass.*;
import Validations.Cifrado;
import Validations.Mensajero;
import Validations.Validate;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

/*@author Allan Ramirez
 */
public class C_Usuario {

    static final UsuarioDAO udao = new UsuarioDAO();
    static Validate v = new Validate();
    
    public static String Insertar(Empleado emp, String nombreUsuario, String rol, String correo){
        //Generar contrasenia aleatoria
        String pass = RandomStringUtils.randomAlphabetic(8);
        
        
        
        Usuario usuario = new Usuario();
        usuario.setEmpleado(emp);
        usuario.setCorreo(correo);
        usuario.setNombreUsuario(nombreUsuario);
        try{
        usuario.setContrasenia(Cifrado.cifra(pass));
        }catch(Exception ex){
            System.err.println("Error al cifrar password");
            
            v.ShowMessage(ex.getMessage(), v.warning_Message);
        }
        usuario.setRoll(rol);
        usuario.setEstado(Boolean.TRUE);
        try{
        udao.save(usuario);
        
        String mensaje = "Bienvenidos a Sistemas Point S.A, ustedes ahora parte de nuestra empresa"
                + "\n\nSus credenciales de autenticacion son las siguientes:"
                + "\nEMPLEADO: \nNombre y Apellidos: "
                + emp.getNombre() +" "+ emp.getApellido()+ "\n"
                + "Número de cédula: "+ emp.getNumeroCedula()+ "\n"
                + "Cargo: " + emp.getCargo()+"\n"
                + "... puede ver más detalles puede ingresar al sistema de información de la empresa.\n"
                + "\nCREDENCIALES DE AUTENTICACION\n"
                + "Nombre de Usuario: " + usuario.getNombreUsuario()+"\n"
                + "Contraseña: "+ pass+"\n"
                + "\nINDICACIONES:\n"
                + "Luego de iniciar sesión por primera vez en el sistema, debe cambiar la contraseña\n"
                + "que le hemos indicado anteriormente. Puede hacerlo en Mi Cuenta > Panel de Control\n\n"
                + "Este mensaje fue enviado automáticamente por el Sistema de Informacion de Sistemas Point";
        List<String> lista = new ArrayList<String>();
        lista.add(correo);
        Mensajero.enviarMensaje(mensaje, lista);
        
        return "Ingresado correctamente";
        }catch(Exception ex){
            ex.printStackTrace();
            return "Error";
        }
        
        //Enviar contrasenia al correo
        
        
        
    }
    
    public static String insert_update(boolean isNuevo, int IDU, Empleado empleado, String nombreUsuario, String contraseña, String roll){
        if(isNuevo){
            try {
                //  Insertar
                Usuario usuario = new Usuario();
                usuario.setEmpleado(empleado);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setContrasenia(Cifrado.cifra(contraseña));
                usuario.setRoll(roll);
                usuario.setEstado(true);
                udao.save(usuario);
            } catch (Exception ex) {
                v.ShowMessage(ex.getMessage(), v.warning_Message);
            }
        }
        if(!isNuevo){ 
            try {
                //    Actualizar
                Usuario usuario = new Usuario();
                usuario.setIdusuario(IDU);
                usuario.setEmpleado(empleado);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setContrasenia(Cifrado.cifra(contraseña));
                usuario.setRoll(roll);
                usuario.setEstado(true);
                udao.update(usuario);
            } catch (Exception ex) {
                v.ShowMessage(ex.getMessage(), v.warning_Message);
            }
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
//        return udao.delete(null);
//    }
    
    public static Usuario find(int idUsuario){
        return udao.find(idUsuario);
    }
    
    public static List<UsuarioCompleto> findAll(){
        return udao.findAll();
    }
    
    public static List<UsuarioCompleto> matchfind(int option, String texto){
        return udao.matchfind(option, texto);
    }
    
    public static List<String> listar(){
        return udao.getCorreosBodega();
    }
    
    public static String updatePassword(Usuario user, String password){
        Usuario usern = user;
        try{
        usern.setContrasenia(Cifrado.cifra(password));
        }catch(Exception ex){
            ex.printStackTrace();
            System.err.println("Error descifrando");
        }
        return udao.update(usern);
    }
    
    public static String updateEmail(int idUsuario, String email){
        Usuario user = find(idUsuario);
        user.setCorreo(email);
        return udao.update(user);
    }
    
    
//    public static void main(String[] args) {
//        findusuario();
////        insert();
//    }
    
//    private static  void findusuario(){
//        Empleado e = C_Empleado.find(1);
//        Usuario u = find(1);
//        try {
//            System.out.println("contraseña: "+Cifrado.descifra(u.getContrasenia()));
//        } catch (Exception ex) {
//            Logger.getLogger(C_Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private static  void insert(){
//        try {
//            UsuarioDAO dao = new UsuarioDAO();
//            Empleado e = C_Empleado.find(1);
//            Usuario u = new Usuario();
//            u.setEmpleado(e);
//            u.setRol("Vendedor");
//            u.setNombreUsuario("Jairo123");
//            u.setContrasenia(Cifrado.cifra("Sistemas.93"));
//            dao.save(u);
//            System.out.println("Usuario agregado");
//        } catch (Exception ex) {
//            Logger.getLogger(C_Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
}
