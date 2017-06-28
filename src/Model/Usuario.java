package Model;
// Generated 11-22-2016 04:28:26 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private Empleado empleado;
     private String nombreUsuario;
     private byte[] contrasenia;
     private String correo;
     private Boolean estado;
     private String roll;

    public Usuario() {
    }

	
    public Usuario(String nombreUsuario, byte[] contrasenia, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }
    public Usuario(Empleado empleado, String nombreUsuario, byte[] contrasenia, String correo, Boolean estado, String roll) {
       this.empleado = empleado;
       this.nombreUsuario = nombreUsuario;
       this.contrasenia = contrasenia;
       this.correo = correo;
       this.estado = estado;
       this.roll = roll;
    }
   
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public byte[] getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(byte[] contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getRoll() {
        return this.roll;
    }
    
    public void setRoll(String roll) {
        this.roll = roll;
    }




}


