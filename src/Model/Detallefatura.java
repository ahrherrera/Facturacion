package Model;
// Generated 11-22-2016 04:28:26 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Detallefatura generated by hbm2java
 */
public class Detallefatura  implements java.io.Serializable {


     private DetallefaturaId id;
     private Factura factura;
     private Producto producto;
     private Integer cantidad;
     private Float descuento;
     private BigDecimal precioUnitario;

    public Detallefatura() {
    }

	
    public Detallefatura(DetallefaturaId id, Factura factura, Producto producto) {
        this.id = id;
        this.factura = factura;
        this.producto = producto;
    }
    public Detallefatura(DetallefaturaId id, Factura factura, Producto producto, Integer cantidad, Float descuento, BigDecimal precioUnitario) {
       this.id = id;
       this.factura = factura;
       this.producto = producto;
       this.cantidad = cantidad;
       this.descuento = descuento;
       this.precioUnitario = precioUnitario;
    }
   
    public DetallefaturaId getId() {
        return this.id;
    }
    
    public void setId(DetallefaturaId id) {
        this.id = id;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Float getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }
    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }




}


