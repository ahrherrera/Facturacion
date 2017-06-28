package View;

import Controler.C_Empleado;
import Controler.C_Factura;
import Controler.C_Usuario;
import DAO.AbstractDAO;
import Hibernate.HibernateFactory;
import Model.Empleado;
import ResultClass.UsuarioCompleto;
import Validations.BackgroundPanel;
import Validations.GUIUtils;
import Validations.Mensajero;
import Validations.TaskbarNotification;
import Validations.Validate;
import Validations.WindowsDrive;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*@author Jairo Martinez */
public class Principal extends javax.swing.JFrame {

    private static UsuarioCompleto currentUser;
    static Session SActual;
    Validate v = new Validate();
    static int idEmpelado;
    private boolean isAdmin = true;
    public static TaskbarNotification mensaje = new TaskbarNotification();

    /*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static Configuration config = null;
    private static SessionFactory sessionfactory = null;
    private static Session session = null;
    /*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    public static UsuarioCompleto user;

    public Principal(UsuarioCompleto currentUser) {
        initComponents();
        ((BackgroundPanel) this.panel_central).setImagen("../Images/fondo.jpg");
        this.setLocationRelativeTo(null);
//        this.setTitle("Sistema de  Facturacion e Inventario...      "+empleado.getNombre()+" "+empleado.getApellidos());
        this.setExtendedState(MAXIMIZED_BOTH);

        SessionFactory sf = HibernateFactory.buildIfNeeded();
        SActual = sf.openSession();
        this.currentUser = currentUser;
        ini();
        
    }

    public static UsuarioCompleto getUser() {
        return currentUser;
    }

    private void ini() {
        AccessMode();
    }
//    public Principal(){
//         initComponents();
//        ((BackgroundPanel) this.panel).setImagen("../Images/fondo.jpg");
//        //OpenSession();
////        findEmpleado(user_idEmpleado);
//        this.setLocationRelativeTo(null);
////        this.setTitle("Sistema de  Facturacion e Inventario...      "+empleado.getNombre()+" "+empleado.getApellidos());
//        this.setExtendedState(MAXIMIZED_BOTH);
////        this.add(new MyBackGround("imageFondo", "png"));
//        //this.DesktopPane.setBorder(new Icons.Border("Laptops.png"));
//        
//        SessionFactory sf= HibernateFactory.buildIfNeeded();
//        SActual = sf.openSession();
//    }

    public static Session getSession() {
        //System.out.println("conexion establecida");
        if (SActual.isOpen()) {
            return SActual;
        }else{
            SessionFactory sf = HibernateFactory.buildIfNeeded();
            SActual = sf.openSession();
            return SActual;
        }
        
    }
    public static void closeSession(){
        if (SActual.isOpen()) {
            SActual.close();
        }else{
            System.err.println("No hay conexion para cerrar");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        panel_central = new BackgroundPanel();
        panel_imagen = new javax.swing.JPanel();
        DesktopPane = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu_Cliente = new javax.swing.JMenuItem();
        Menu_Producto = new javax.swing.JMenuItem();
        Menu_Proveedor = new javax.swing.JMenuItem();
        Menu_Empleado = new javax.swing.JMenuItem();
        Menu_Usuario = new javax.swing.JMenuItem();
        Menu_CerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Menu_GestionFactura = new javax.swing.JMenuItem();
        Menu_ManejoInventario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menu_cp = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 51, 255));

        panel_central.setLayout(new java.awt.BorderLayout());

        panel_imagen.setOpaque(false);

        DesktopPane.setOpaque(false);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1325, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_imagenLayout = new javax.swing.GroupLayout(panel_imagen);
        panel_imagen.setLayout(panel_imagenLayout);
        panel_imagenLayout.setHorizontalGroup(
            panel_imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_imagenLayout.createSequentialGroup()
                .addComponent(DesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        panel_imagenLayout.setVerticalGroup(
            panel_imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );

        panel_central.add(panel_imagen, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panel_central, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Catálogos");

        Menu_Cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        Menu_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/text-x-ldif2px.png"))); // NOI18N
        Menu_Cliente.setText("Clientes");
        Menu_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ClienteActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Cliente);

        Menu_Producto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        Menu_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_producto.png"))); // NOI18N
        Menu_Producto.setText("Productos");
        Menu_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ProductoActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Producto);

        Menu_Proveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        Menu_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resource-group.png"))); // NOI18N
        Menu_Proveedor.setText("Proveedor");
        Menu_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ProveedorActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Proveedor);

        Menu_Empleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        Menu_Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/meeting-participant22px.png"))); // NOI18N
        Menu_Empleado.setText("Empleados");
        Menu_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_EmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Empleado);

        Menu_Usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        Menu_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/system-users_22px.png"))); // NOI18N
        Menu_Usuario.setText("Usuarios");
        Menu_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_UsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Usuario);

        Menu_CerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Menu_CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/system-shutdown.png"))); // NOI18N
        Menu_CerrarSesion.setText("Cerrar Sesión");
        Menu_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_CerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_CerrarSesion);

        MenuBar.add(jMenu1);

        jMenu2.setText("Facturación");

        Menu_GestionFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Menu_GestionFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_factura.png"))); // NOI18N
        Menu_GestionFactura.setText("Facturar Venta");
        Menu_GestionFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_GestionFacturaActionPerformed(evt);
            }
        });
        jMenu2.add(Menu_GestionFactura);

        Menu_ManejoInventario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        Menu_ManejoInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_inventario.png"))); // NOI18N
        Menu_ManejoInventario.setText("Manejo de Inventario");
        Menu_ManejoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ManejoInventarioActionPerformed(evt);
            }
        });
        jMenu2.add(Menu_ManejoInventario);

        MenuBar.add(jMenu2);

        jMenu3.setText("Informes");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_truck.png"))); // NOI18N
        jMenuItem1.setText("Reporte de Inventario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        MenuBar.add(jMenu3);

        jMenu5.setText("Mi Cuenta");

        menu_cp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/meeting-participant22px.png"))); // NOI18N
        menu_cp.setText("Panel de Control");
        menu_cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cpActionPerformed(evt);
            }
        });
        jMenu5.add(menu_cp);

        MenuBar.add(jMenu5);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Could not get constructor for org.hibernate.persister.entity.SingleTableEntityPersister


    private void Menu_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ClienteActionPerformed
        Thread th = new Thread(()
                -> {
            if (!V_Cliente.isOpen) {
                new WindowsDrive().WindowDriver(new V_Cliente(), DesktopPane);
            } else {
                String mensaje = "La ventana ya há sido abierta...";
                mensaje += "\n    ¡Maximiza la ventana..!";
                v.ShowMessage(mensaje, ALLBITS);
            }
        });
        th.start();
    }//GEN-LAST:event_Menu_ClienteActionPerformed

    private void Menu_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ProveedorActionPerformed
        Thread th = new Thread(()
                -> {
            V_Proveedor vprov = new V_Proveedor();
            new WindowsDrive().WindowDriver(vprov, DesktopPane);
            GUIUtils.moveToFront(vprov);
        });
        th.start();
    }//GEN-LAST:event_Menu_ProveedorActionPerformed

    private void Menu_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ProductoActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new V_Producto(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_Menu_ProductoActionPerformed

    private void Menu_GestionFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_GestionFacturaActionPerformed
       Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new V_Factura(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_Menu_GestionFacturaActionPerformed

    private void Menu_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_EmpleadoActionPerformed
        Thread th = new Thread(() -> {
            new WindowsDrive().WindowDriver(new V_Empleados(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_Menu_EmpleadoActionPerformed

    private void Menu_ManejoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ManejoInventarioActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new Manejo_Inventario(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_Menu_ManejoInventarioActionPerformed

    private void Menu_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_UsuarioActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new V_Usuario(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_Menu_UsuarioActionPerformed

    private void Menu_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_CerrarSesionActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_Menu_CerrarSesionActionPerformed

    private void menu_cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cpActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new V_PanelControl(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_menu_cpActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        C_Factura.ReporteInventario();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            //@Override

            public void run() {
                new Principal(currentUser).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Menu_CerrarSesion;
    private javax.swing.JMenuItem Menu_Cliente;
    private javax.swing.JMenuItem Menu_Empleado;
    private javax.swing.JMenuItem Menu_GestionFactura;
    private javax.swing.JMenuItem Menu_ManejoInventario;
    private javax.swing.JMenuItem Menu_Producto;
    private javax.swing.JMenuItem Menu_Proveedor;
    private javax.swing.JMenuItem Menu_Usuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menu_cp;
    private javax.swing.JPanel panel_central;
    private javax.swing.JPanel panel_imagen;
    // End of variables declaration//GEN-END:variables

    
    private void AccessMode() {
        this.setTitle("Sistemas de Facturacion e Inventario :: " + currentUser.getNombre() + " " + currentUser.getApellido() + " de Sistemas Point S.A.");
        
        this.Menu_CerrarSesion.setVisible(true);
        switch (currentUser.getRoll()) {
            case "Gerente": {
                this.Menu_Cliente.setVisible(true);
                this.Menu_Empleado.setVisible(true);
                this.Menu_Producto.setVisible(true);
                this.Menu_Proveedor.setVisible(true);
                this.Menu_Usuario.setVisible(true);
                this.Menu_ManejoInventario.setVisible(true);
                this.Menu_GestionFactura.setVisible(true);
                //Incluir Informes
            }
            break;
            case "Agente de Ventas": {
                this.Menu_Cliente.setVisible(true);
                this.Menu_Empleado.setVisible(false);
                this.Menu_Producto.setVisible(false);
                this.Menu_Proveedor.setVisible(false);
                this.Menu_Usuario.setVisible(false);
                this.Menu_ManejoInventario.setVisible(false);
                this.Menu_GestionFactura.setVisible(true);
                jMenu3.setVisible(false);
            }
            break;
            case "Bodega": {
                this.Menu_Cliente.setVisible(false);
                this.Menu_Empleado.setVisible(false);
                this.Menu_Producto.setVisible(true);
                this.Menu_Proveedor.setVisible(true);
                this.Menu_Usuario.setVisible(false);
                this.Menu_ManejoInventario.setVisible(true);
                this.Menu_GestionFactura.setVisible(false);
            }
            break;
            default:{
                this.setVisible(false);
                new Login().setVisible(true);
            }
        }
        this.panel_central.add(new BackgroundPanel("../Images/imageFondo.png"));
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon-app.png"));
        setIconImage(icon);
        setVisible(true);

    }
    
    
    
    

}
