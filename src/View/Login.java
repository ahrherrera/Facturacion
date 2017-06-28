package View;

import Controler.C_Usuario;
import DAO.AbstractDAO;
import ResultClass.UsuarioCompleto;
import Validations.BackgroundPanel;
import Validations.Cifrado;
import Validations.Validate;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/*@author Jairo Martinez*/
public class Login extends javax.swing.JFrame {

    JProgressBar ProgressBar = new JProgressBar();
    Validate v = new Validate();
    int idEmpleado = 0;
    String userName="", password="";
    boolean isAdmin = true;
    static UsuarioCompleto currentUser = null;
    List<UsuarioCompleto> usuarios = null;
    
    static PreparedStatement preparedStatement = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static ResultSetMetaData rsmd= null;
    
    public Login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Autenticacion de Usuario");
        ini();
    }

    private void ini(){
        try{
            usuarios = C_Usuario.findAll();
        }catch(ExceptionInInitializerError ex){
            v.ShowMessage("¡Error de conexión a la Base de Datos..!", v.error_Message);
            ex.printStackTrace();
            this.btn_Aceptar.setEnabled(false);
            this.V_Contraseña.setEnabled(false);
            this.V_Usuario.setEnabled(false);
            this.A_Contraseña.setEnabled(false);
            this.A_Usuario.setEnabled(false);
        }
        v.CargarImagen(new File("src/Images/AdminKey.png"), pn_IconAdm);
        v.CargarImagen(new File("src/Images/userSecurity.png"), pn_IconVend);
        ((BackgroundPanel) this.centralPanel).setImagen("../Images/login_background.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon-app.png"));
        setIconImage(icon);
        setVisible(true);
        this.V_Contraseña.addKeyListener(new KeyAdapter() {     @Override public void keyPressed(KeyEvent e) {  if (e.getKeyCode() == KeyEvent.VK_ENTER) {  btn_AceptarActionPerformed(null);   }   }        });
        this.A_Contraseña.addKeyListener(new KeyPressed());
        this.V_Usuario.requestFocus();
        this.UsuarioIncorrecto.setVisible(false);
        this.WindowsClosing();
        //*** QUIARLO ANTES DE ENTREGAR ***//
        /*TabbedPane.setSelectedIndex(1);             //          ◄
        A_Usuario.setText("jairo");                 //  ◄◄◄◄◄◄◄
        A_Contraseña.setText("12345");              //◄◄◄◄◄◄◄◄
                                                    //  ◄◄◄◄◄◄◄
        btn_Aceptar.doClick();                      //          ◄
        
        */
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelShadow6 = new org.edisoncor.gui.panel.PanelShadow();
        centralPanel = new BackgroundPanel();
        panelShadow = new org.edisoncor.gui.panel.PanelShadow();
        TabbedPane = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panelShadow3 = new org.edisoncor.gui.panel.PanelShadow();
        V_Contraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        V_Usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_IconVend = new org.edisoncor.gui.panel.PanelShadow();
        panelShadow4 = new org.edisoncor.gui.panel.PanelShadow();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        A_Usuario = new javax.swing.JTextField();
        A_Contraseña = new javax.swing.JPasswordField();
        pn_IconAdm = new org.edisoncor.gui.panel.PanelShadow();
        panelShadow5 = new org.edisoncor.gui.panel.PanelShadow();
        btn_Aceptar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        panelShadow7 = new org.edisoncor.gui.panel.PanelShadow();
        UsuarioIncorrecto = new javax.swing.JLabel();

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelShadow6Layout = new javax.swing.GroupLayout(panelShadow6);
        panelShadow6.setLayout(panelShadow6Layout);
        panelShadow6Layout.setHorizontalGroup(
            panelShadow6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );
        panelShadow6Layout.setVerticalGroup(
            panelShadow6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        centralPanel.setBackground(new java.awt.Color(0, 0, 0));
        centralPanel.setLayout(new java.awt.BorderLayout());

        panelShadow.setOpaque(true);

        TabbedPane.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N

        panelShadow3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acceso de Vendedor");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        V_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V_UsuarioKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña :");

        pn_IconVend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pn_IconVend.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(V_Usuario)
                            .addComponent(V_Contraseña)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_IconVend, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(V_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(V_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
            .addComponent(pn_IconVend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Vendedor", panelShadow3);

        panelShadow4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Acceso de Administrador");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña :");

        A_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A_UsuarioKeyReleased(evt);
            }
        });

        pn_IconAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pn_IconAdm.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow4Layout.createSequentialGroup()
                        .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A_Contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(A_Usuario)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_IconAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(A_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(A_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
            .addComponent(pn_IconAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Administrador y Bodega", panelShadow4);

        panelShadow5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        btn_Salir.setText("Salir..");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        panelShadow7.setLayout(new java.awt.BorderLayout());

        UsuarioIncorrecto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        UsuarioIncorrecto.setForeground(new java.awt.Color(153, 0, 0));
        UsuarioIncorrecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UsuarioIncorrecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/errorAcces.png"))); // NOI18N
        UsuarioIncorrecto.setText("Usuario Contraseña Incorrecta");
        UsuarioIncorrecto.setIconTextGap(30);
        panelShadow7.add(UsuarioIncorrecto, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout panelShadow5Layout = new javax.swing.GroupLayout(panelShadow5);
        panelShadow5.setLayout(panelShadow5Layout);
        panelShadow5Layout.setHorizontalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow5Layout.createSequentialGroup()
                .addComponent(panelShadow7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Salir)
                .addContainerGap())
        );
        panelShadow5Layout.setVerticalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow5Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Aceptar)
                            .addComponent(btn_Salir)))
                    .addComponent(panelShadow7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelShadowLayout = new javax.swing.GroupLayout(panelShadow);
        panelShadow.setLayout(panelShadowLayout);
        panelShadowLayout.setHorizontalGroup(
            panelShadowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelShadow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelShadowLayout.setVerticalGroup(
            panelShadowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadowLayout.createSequentialGroup()
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPane.getAccessibleContext().setAccessibleName("Administrador");

        centralPanel.add(panelShadow, java.awt.BorderLayout.CENTER);

        getContentPane().add(centralPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        this.Access();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void V_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V_UsuarioKeyReleased
        this.UsuarioIncorrecto.setVisible(false);
        this.V_Contraseña.setText("");
    }//GEN-LAST:event_V_UsuarioKeyReleased

    private void A_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A_UsuarioKeyReleased
        this.UsuarioIncorrecto.setVisible(false);
        this.A_Contraseña.setText("");
    }//GEN-LAST:event_A_UsuarioKeyReleased

    private void Access(){
        try{
            if(TabbedPane.getSelectedIndex()==0){System.out.println("Vendedor...");
                Vendedor();
            }
            if(TabbedPane.getSelectedIndex()==1){System.out.println("Administrador y Bodega");
                Adiministrador();
            }
        }catch(ExceptionInInitializerError ex){
            v.ShowMessage("¡Error de conexión a la Base de Datos..!", v.error_Message);
        }
    }
    
    private void Vendedor(){
        boolean exist = false;
        userName = this.V_Usuario.getText();
        password = new String(this.V_Contraseña.getPassword());
        for(UsuarioCompleto u : usuarios){
            if(u.getRoll().equalsIgnoreCase("Agente de Ventas")){
                System.out.println(u.getRoll());
                try {
                    if(u.getNombreUsuario().equals(userName) && Cifrado.descifra(u.getContraseña()).equals(password)){
                        System.out.println("\n"+u.getNombreUsuario()+"\t"+u.getRoll());
                        exist = true;
                        LoadProgressBar(u);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(exist==false){
            this.UsuarioIncorrecto.setText("Vendedor no existente..!");
            this.UsuarioIncorrecto.setVisible(true);
        }
    }
    
    private void Adiministrador(){
        boolean exist = false;
        userName = this.A_Usuario.getText();
        password = new String(this.A_Contraseña.getPassword());
        for(UsuarioCompleto u : usuarios){
            if(u.getRoll().equalsIgnoreCase("Gerente")){
                System.out.println(u.getRoll());
                try {
                    if(u.getNombreUsuario().equals(userName) && Cifrado.descifra(u.getContraseña()).equals(password)){
                        System.out.println("\n"+u.getNombreUsuario()+"\t"+u.getRoll());
                        exist = true;
                        LoadProgressBar(u);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(u.getRoll().equals("Bodega")){
                System.out.println(u.getRoll());
                try {
                    if(u.getNombreUsuario().equals(userName) && Cifrado.descifra(u.getContraseña()).equals(password)){
                        System.out.println("\n"+u.getNombreUsuario()+"\t"+u.getRoll());
                        exist = true;
                        LoadProgressBar(u);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(exist==false){
            this.UsuarioIncorrecto.setText("Administrador no existente..!");
            this.UsuarioIncorrecto.setVisible(true);
        }
    }
    
    private int i =0;
    private void LoadProgressBar(UsuarioCompleto currentUser){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(i<100){
                        i++;
                        ProgressBar.setValue(i);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {}
                    }else{
                        Ir(currentUser);
                        return;
                    }
                }
            }
        });
        thread.start();
    }
    
    private void Ir(UsuarioCompleto currentUser){
        this.dispose();
        new Principal(currentUser).setVisible(true);
    }
    
    public class KeyPressed extends KeyAdapter {
      @Override
      public void keyPressed(KeyEvent ke) {
          if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
              btn_AceptarActionPerformed(null);
          }
      }
    }
    
    private void WindowsClosing(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(new JFrame(), "¿Salir del sistema..?", "¿Salir..?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
            
        });
    }
    
    public static void main(String args[]) {
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
        //<
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField A_Contraseña;
    private javax.swing.JTextField A_Usuario;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader TabbedPane;
    private javax.swing.JLabel UsuarioIncorrecto;
    private javax.swing.JPasswordField V_Contraseña;
    private javax.swing.JTextField V_Usuario;
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JPanel centralPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private org.edisoncor.gui.panel.PanelShadow panelShadow;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow3;
    private org.edisoncor.gui.panel.PanelShadow panelShadow4;
    private org.edisoncor.gui.panel.PanelShadow panelShadow5;
    private org.edisoncor.gui.panel.PanelShadow panelShadow6;
    private org.edisoncor.gui.panel.PanelShadow panelShadow7;
    private org.edisoncor.gui.panel.PanelShadow pn_IconAdm;
    private org.edisoncor.gui.panel.PanelShadow pn_IconVend;
    // End of variables declaration//GEN-END:variables
}
