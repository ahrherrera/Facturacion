package Model;
// Generated 11-22-2016 04:28:26 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer idEmpleado;
     private Date fechaIngreso;
     private String cargo;
     private Boolean estado;
     private String nombre;
     private String apellido;
     private String direccion;
     private String telefono;
     private String numeroCedula;
     private byte[] foto;
     private Set compras = new HashSet(0);
     private Set facturas = new HashSet(0);
     private Set usuarios = new HashSet(0);

    public Empleado() {
    }

	
    public Empleado(Date fechaIngreso, String cargo) {
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }
    public Empleado(Date fechaIngreso, String cargo, Boolean estado, String nombre, String apellido, String direccion, String telefono, String numeroCedula, byte[] foto, Set compras, Set facturas, Set usuarios) {
       this.fechaIngreso = fechaIngreso;
       this.cargo = cargo;
       this.estado = estado;
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
       this.telefono = telefono;
       this.numeroCedula = numeroCedula;
       this.foto = foto;
       this.compras = compras;
       this.facturas = facturas;
       this.usuarios = usuarios;
    }
   
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNumeroCedula() {
        return this.numeroCedula;
    }
    
    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public Set getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set compras) {
        this.compras = compras;
    }
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


