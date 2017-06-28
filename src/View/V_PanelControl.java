/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.C_Empleado;
import Controler.C_Usuario;
import Model.Empleado;
import Model.Usuario;
import Validations.Cifrado;
import Validations.Validate;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ahrhe
 */
public class V_PanelControl extends javax.swing.JInternalFrame {

    /**
     * Creates new form V_PanelControl
     */
    Validate v = new Validate();
    Usuario user = C_Usuario.find(Principal.getUser().getIdusuario());
    Empleado emp = C_Empleado.find(Principal.getUser().getIdEmpleado());

    public V_PanelControl() {
        initComponents();
        this.panelFoto.setSize(160, 160);
        try {
            v.LoadImagePanel(this.panelFoto, v.Byte_BufferedImage(emp.getFoto()));
        } catch (NullPointerException ne) {
            v.CargarImagen(new File("src\\Images\\nofoto.png"), this.panelFoto);
        }

        txt_nombres.setText(emp.getNombre() + " " + emp.getApellido());
        txt_cedula.setText(v.returnCedula(emp.getNumeroCedula()));
        txt_cargo.setText(emp.getCargo());
        txt_telefono.setText(emp.getTelefono());
        txt_direccion.setText(emp.getDireccion());
        String aviso = "Si es primera vez que inicia sesión con la contraseña que recibio en el correo, debe cambiarla inmediatamanete";
        txt_aviso.setText("<html>" + aviso + "</html>");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFoto = new javax.swing.JPanel();
        txt_cargo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_nombres = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_direccion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btn_pass = new javax.swing.JButton();
        btn_email = new javax.swing.JButton();
        txt_aviso = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Panel de Control de usuario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/system-users_22px.png"))); // NOI18N

        panelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelFoto.setLayout(new java.awt.BorderLayout());

        txt_cargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_cargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txt_nombres.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txt_cedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_direccion.setEditable(false);
        txt_direccion.setColumns(20);
        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_direccion.setLineWrap(true);
        txt_direccion.setRows(5);
        jScrollPane1.setViewportView(txt_direccion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control de Acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btn_pass.setText("Cambiar Contraseña");
        btn_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_passActionPerformed(evt);
            }
        });

        btn_email.setText("Cambiar Correo");
        btn_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_pass)
                .addGap(18, 18, 18)
                .addComponent(btn_email)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        txt_aviso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_aviso.setForeground(new java.awt.Color(255, 0, 0));
        txt_aviso.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_aviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_aviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_emailActionPerformed
       JTextField correo = new JTextField();
       int opc =JOptionPane.showConfirmDialog(null, correo,"Ingresa un email válido", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (opc== JOptionPane.OK_OPTION) {
            String email = correo.getText();
            if (v.validateEmail(email)) {
                v.ShowMessage(C_Usuario.updateEmail(user.getIdusuario(), email), v.info_Message);
            }else{
                v.ShowMessage("Email Invalido!", v.error_Message);
            }
        }
    }//GEN-LAST:event_btn_emailActionPerformed

    private void btn_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_passActionPerformed
        JPasswordField pf = new JPasswordField();
        int intentos = 0;
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Ingresa la contraseña actual", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            try {
                if (password.equals(Cifrado.descifra(user.getContrasenia()))) {
                    JPasswordField pf1 = new JPasswordField();
                    int reg = JOptionPane.showConfirmDialog(null, pf1, "Ingresa la contraseña nueva", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    
                    if (reg == JOptionPane.OK_OPTION) {
                        String pass = new String(pf1.getPassword());
                        v.ShowMessage(C_Usuario.updatePassword(user, pass), v.info_Message);
                        this.setVisible(false);
                        new Login().setVisible(true);
                        System.err.println();
                    }
                } else {
                    intentos++;
                    v.ShowMessage("Las contraseñas no coinciden. INTENTO: " + intentos, v.error_Message);
                    if (intentos >= 4) {
                        this.getParent().setVisible(false);
                        new Login().setVisible(true);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Error al descifrar");
            }
        }
        
        
    }//GEN-LAST:event_btn_passActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_email;
    private javax.swing.JButton btn_pass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JLabel txt_aviso;
    private javax.swing.JLabel txt_cargo;
    private javax.swing.JLabel txt_cedula;
    private javax.swing.JTextArea txt_direccion;
    private javax.swing.JLabel txt_nombres;
    private javax.swing.JLabel txt_telefono;
    // End of variables declaration//GEN-END:variables
}
