package ResultClass;

import Model.Empleado;
import java.math.BigDecimal;
import java.util.Date;

/*@author Jairo Martinez*/
public class UsuarioCompleto extends EmpleadoCompleto{
     private Integer idusuario, idEmpleado;
     private String nombreUsuario, roll, cargo, nombre, apellido, direccion, telefono, numeroCedula;
     private Date fechaIngreso;
     private BigDecimal salarioBasico;
     private Boolean estado, estadoEmpleado;
     private byte[] foto, contraseña;

    public UsuarioCompleto() {}

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public BigDecimal getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(BigDecimal salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(Boolean estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getContraseña() {
        return contraseña;
    }

    public void setContraseña(byte[] contraseña) {
        this.contraseña = contraseña;
    }

    
    
    
}
