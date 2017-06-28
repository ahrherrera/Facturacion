package DAO;

import Hibernate.HibernateFactory;
import Model.Detallefatura;
import Model.Factura;
import Validations.Validate;
import View.Principal;
import View.V_Factura;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Projections;
import static java.lang.Math.toIntExact;

/*@author Allan Ramirez
 */
public class FacturaDAO extends AbstractDAO{
    
    private static Validate v = new Validate();
    
    public FacturaDAO(){
        super();
    }
    
    public Integer insertarFactura(Factura fact){
        return super.onlySave(fact);
    }
    
    private static JasperPrint print = null;
    private static JasperViewer view = null;
    public static  void PrintReport(BigDecimal subTotal, BigDecimal iva, BigDecimal total) {
        try{
        String path = "src\\Reports\\Factura.jasper";
        try{System.out.println("idfactura a imprimir: "+V_Factura.idFactura);
            Map parameter = new HashMap();
            parameter.put("idFactura", V_Factura.idFactura);
            parameter.put("st", subTotal);
            parameter.put("iva", iva);
            parameter.put("t", total);
            print = JasperFillManager.fillReport(path, parameter, AbstractDAO.conexion());
            view  = new JasperViewer(print, false);
            view.setTitle("Sistema de facturación :: Detalle de factura");
            view.setIconImage(v.IconReport());
            view.setVisible(true);
            AbstractDAO.CloseConnection();
        }catch(JRException je){
            v.ShowMessage("Error al mostrar Detalle de factura: "+je.getMessage(), v.error_Message);
            je.printStackTrace();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public static  void ReporteInventario() {
        try{
        String path = "src\\Reports\\ReporteInventario.jasper";
        try{            
            print = JasperFillManager.fillReport(path, null, AbstractDAO.conexion());
            view  = new JasperViewer(print, false);
            view.setTitle("Sistema de facturación :: Detalle de Inventario");
            view.setIconImage(v.IconReport());
            view.setVisible(true);
            AbstractDAO.CloseConnection();
        }catch(JRException je){
            v.ShowMessage("Error al mostrar Detalle de inventario: "+je.getMessage(), v.error_Message);
            je.printStackTrace();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     
    public int getSigFactura(){
        startOperation();
        long n= (long) session.createCriteria(Factura.class).setProjection(Projections.rowCount()).uniqueResult();
        
        int numero = toIntExact(n);
        return numero +1 ;
    }
    
    public static void main(String[] args) {
        //PrintReport(v.String_BigDecimal("458"), v.String_BigDecimal("42"),v.String_BigDecimal("600"));
        
        /*ClienteDAO cdao = new ClienteDAO();
        ProductoDAO pdao = new ProductoDAO();
        EmpleadoDAO edao = new EmpleadoDAO();
        DetalleFacturaDAO dfdao = new DetalleFacturaDAO();
        Set<Detallefatura> setDetalleFactura = new HashSet<Detallefatura>();
        
        Detallefatura det1 = new Detallefatura();
        Detallefatura det2 = new Detallefatura();
        
        Factura fac = new Factura();
        fac.setCliente(cdao.find(1));
        fac.setEmpleado(edao.find(1));
        System.out.println("Empleado: "+fac.getEmpleado().getNombre()
                        +"\n Cliente: "+fac.getCliente().getNombre());
        
        det1.setProducto(pdao.find(5));
        det1.setCantidad(5);
        det1.setPrecioUnitario(pdao.find(5).getPrecioVenta());
        det1.setDescuento(Float.parseFloat("0.0"));
        det1.setFactura(fac);
        setDetalleFactura.add(det1);
        System.out.println("Producto facturado = " + det1.getProducto().getNombreProducto() 
                        +"\ncon ID = " + det1.getProducto().getIdProducto());
        
        det2.setProducto(pdao.find(4));
        det2.setCantidad(5);
        det2.setPrecioUnitario(pdao.find(4).getPrecioVenta());
        det2.setDescuento(Float.parseFloat("0.0"));
        det2.setFactura(fac);
        setDetalleFactura.add(det2);
        System.out.println("Producto facturado = " + det2.getProducto().getNombreProducto() 
                        +"\ncon ID = " + det2.getProducto().getIdProducto());        
        
        fac.setDetallefaturas(setDetalleFactura);
        fac.setFecha(new Timestamp(System.currentTimeMillis()));
        
        DetalleFacturaDAO dfDAO = new DetalleFacturaDAO();
        dfDAO.create(det1);
        dfDAO.create(det2);
        //HibernateFactory.buildIfNeeded().openSession().saveOrUpdate(fac);
        //System.out.println("IDFactura: " + idFactura);
        //Integer idFactura = (Integer) 
        
        System.out.println("Agregado!");*/
    }
}
