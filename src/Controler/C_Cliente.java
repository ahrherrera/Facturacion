package Controler;

import ResultClass.ClienteCompleto;
import DAO.*;
import Model.*;
import View.Principal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/*@author Jairo Martinez
 */
public class C_Cliente{
    Session session = null; 
    static ClienteDAO cdao = new ClienteDAO();
    static CedulaDAO cddao = new CedulaDAO();
    
    public C_Cliente() {
    }
    
    
    public static String Insert_Update(boolean isNuevo, int idC, String nombre, String apellido, String direccion ,  String numeroCedula, String telefono, byte [] foto){
        if(isNuevo){//     insertar nuevo registro
            int idCliente=0;
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setFoto(foto);
            cliente.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
            cliente.setEstado(true);
            idCliente = cdao.save(cliente);

            //      Cedula
            if(!numeroCedula.equalsIgnoreCase("")){
                CedulaId cedulaId = new CedulaId();
                cedulaId.setNumeroCedula(numeroCedula);

                Cedula cedula = new Cedula();
                cedula.setId(cedulaId);
                cedula.getId().setIdCliente(idCliente);
                cedula.setCliente(cliente);

                Set cedulas = new HashSet();
                cedulas.add(cedula);

                cliente.setCedulas(cedulas);
                cddao.save(cedula);
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(!isNuevo){  // editar registro
            //      Cliente
            Cliente cliente = new Cliente();
            cliente.setIdCliente(idC);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setFoto(foto);
            cliente.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
            cliente.setEstado(true);

            //      CedulaSystem.out.println("cedula editar: "+numeroCedula);
            if(!numeroCedula.equalsIgnoreCase("")){
                System.out.println("entro a editar cedula, idc="+idC);
                CedulaId cedulaId = new CedulaId();
                cedulaId.setNumeroCedula(numeroCedula);
                cedulaId.setIdCliente(idC);

                Cedula cedula = new Cedula();
                cedula.setId(cedulaId);
                cedula.setCliente(cliente);

                Set cedulas = new HashSet();
                cedulas.add(cedula);

                cliente.setCedulas(cedulas);
                System.out.println("before update: "+cedula.getId().getNumeroCedula());
                cddao.update(cedula);
                cdao.update(cliente);

            }
        }
        return "";
    }
    
    public static List<ClienteCompleto> findAll(){
        return cdao.findAll();
    }
    
    public List<Cliente> findTodos(){  //Porque esto me retorna la lista de tipo objeto que fue mapeado
        return cdao.findTodos();
    }
    
    public static List<ClienteCompleto> matchfind(int option, String texto){
        return cdao.matchfind(option, texto);
    }
    
    public Cliente find(int idCliente){
        return cdao.find(idCliente);
    }
    
    public List<Cliente> findByName(String nombre){
        return cdao.buscarPorNombre(nombre);
    }
    
    public static void PrintReport(){
        cdao.PrintReport();
    }
//    public static void main(String[] args) {
//        Insert_Update("FATIMA", "Lopez", "Direccion" ,  "0012324932211E", 87654321);
//        System.out.println("Ingresado");
//        findAll();
//    }
    
}
