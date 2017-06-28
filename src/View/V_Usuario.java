package View;

import Controler.*;
import Model.*;
import Render.*;
import ResultClass.*;
import Validations.*;
import java.awt.FileDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.event.ListDataListener;
import org.hibernate.Session;
/*@author Jairo Martinez
 */
public class V_Usuario extends javax.swing.JInternalFrame implements Interface{

    /*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    ModelTableUsuario model = new ModelTableUsuario(new ArrayList());
    ModelTableEmpleado modelEmpleado = new ModelTableEmpleado(new ArrayList());

    Validate v = new Validate();
    JLabel labelFoto = new JLabel();
    Thread th = null;
    Empleado empleado = null;
    Session session=null;
    boolean isOpen=false, isSave=false, isNuevo=false, isEditar=false,  isAdmin=false;
    int idPersona = 0, idEmpleado=0, idUsuario = 0;
    byte [] foto = null, password = null;
    UsuarioCompleto currentuser = null;
    List<UsuarioCompleto> usuarios = null;
    List<UsuarioCompleto> matchusuarios = null;
    
    /*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    
    public V_Usuario() {
        initComponents();
        ini();
    }
    private void ini(){
        this.model.ColumnSize(table);
        isOpen=true;
        currentuser = Principal.getUser();
        this.txt_cedula.setEditable(false);
        this.panelFoto.setSize(160, 160);
        this.rb_usuario.setSelected(true);
        this.EnableFields(false);
        this.setSize(950, 650);
        this.Load();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelCentral = new BackgroundPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        rb_empleado = new javax.swing.JRadioButton();
        rb_usuario = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btn_buscar = new javax.swing.JButton();
        cb_BuscarPor = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        txt_textoBuscar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        panelDatos = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JFormattedTextField();
        txt_cedula = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_direccion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_nombreUsuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_contraseña = new javax.swing.JPasswordField();
        txt_cargo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cb_rollUsuario = new javax.swing.JComboBox<>();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_CargarMasProveedores = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestión de Usuarios ::   Búsqueda de Usuarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/system-users.png"))); // NOI18N
        setLayer(5);

        panelCentral.setPreferredSize(new java.awt.Dimension(838, 559));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setOpaque(false);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/address-book-new.png"))); // NOI18N
        btn_nuevo.setToolTipText("Nuevo Elemento");
        btn_nuevo.setFocusable(false);
        btn_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevo.setOpaque(false);
        btn_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_nuevo);

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-edit.png"))); // NOI18N
        btn_editar.setFocusable(false);
        btn_editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_editar);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-save-all.png"))); // NOI18N
        btn_guardar.setToolTipText("Guardar Datos");
        btn_guardar.setFocusable(false);
        btn_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar.setOpaque(false);
        btn_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_guardar);

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dialog-cancel.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar ");
        btn_cancelar.setFocusable(false);
        btn_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cancelar.setOpaque(false);
        btn_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_cancelar);

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-print.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir reporte individual");
        btn_imprimir.setFocusable(false);
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btn_imprimir);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(10, 10));
        jToolBar3.add(jSeparator5);

        buttonGroup1.add(rb_empleado);
        rb_empleado.setFont(new java.awt.Font("Monotype Corsiva", 2, 14)); // NOI18N
        rb_empleado.setForeground(new java.awt.Color(0, 0, 153));
        rb_empleado.setText("Empleado");
        rb_empleado.setToolTipText("Busqueda de empleados");
        rb_empleado.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        rb_empleado.setFocusable(false);
        rb_empleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rb_empleado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rb_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/text-x-ldif2px.png"))); // NOI18N
        rb_empleado.setOpaque(false);
        rb_empleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rb_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_empleadoActionPerformed(evt);
            }
        });
        jToolBar3.add(rb_empleado);

        buttonGroup1.add(rb_usuario);
        rb_usuario.setFont(new java.awt.Font("Monotype Corsiva", 2, 14)); // NOI18N
        rb_usuario.setForeground(new java.awt.Color(0, 0, 153));
        rb_usuario.setSelected(true);
        rb_usuario.setText("Usuario");
        rb_usuario.setToolTipText("Busqueda de usuarios");
        rb_usuario.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        rb_usuario.setFocusable(false);
        rb_usuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rb_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/system-users_22px.png"))); // NOI18N
        rb_usuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rb_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_usuarioActionPerformed(evt);
            }
        });
        jToolBar3.add(rb_usuario);

        jSeparator3.setPreferredSize(new java.awt.Dimension(10, 10));
        jToolBar3.add(jSeparator3);

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit-find-project.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar Registro");
        btn_buscar.setFocusable(false);
        btn_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_buscar.setOpaque(false);
        btn_buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_buscar);

        cb_BuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "( Metodo de Busqueda )" }));
        cb_BuscarPor.setToolTipText("Metodo de Busqueda de los Registros");
        cb_BuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_BuscarPorItemStateChanged(evt);
            }
        });
        jToolBar3.add(cb_BuscarPor);

        jPanel3.setOpaque(false);

        txt_textoBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_textoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_textoBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txt_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar3.add(jPanel3);

        jToolBar1.add(jToolBar3);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N

        try {
            txt_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txt_cedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txt_direccion.setColumns(20);
        txt_direccion.setRows(5);
        jScrollPane2.setViewportView(txt_direccion);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nombre :");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Apellidos :");

        jlabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jlabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel3.setText("Telefono :");

        jlabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jlabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel4.setText("Numero de Cédula :");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setText("Dirección :");

        panelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelFoto.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setText("Cargo :");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Usuario:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Contraseña:");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Rol:");

        cb_rollUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "( Rol de usuario )", "Vendedor", "Administrador" }));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_rollUsuario, 0, 195, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txt_contraseña)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_telefono)
                            .addComponent(txt_cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txt_apellido)))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cargo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlabel3)
                                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlabel4)
                                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cb_rollUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Empleados / Usuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N
        panelTabla.setLayout(new java.awt.BorderLayout());

        table.setModel(model);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        panelTabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btn_CargarMasProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add.png"))); // NOI18N
        btn_CargarMasProveedores.setText("Mostar mas...");
        btn_CargarMasProveedores.setToolTipText("Mostrar más registros");
        btn_CargarMasProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CargarMasProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_CargarMasProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_CargarMasProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Load(){
        usuarios =  C_Usuario.findAll();
        this.AccesMode();
    }
    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        if((empleado!= null) && (!this.txt_nombre.getText().isEmpty())){
            this.EnableFields(true);
            this.txt_nombreUsuario.requestFocus();
            this.txt_nombreUsuario.requestFocus();
            isNuevo = true;
            isEditar = false;
        }else{
            String  message = "Elija un Empleado para dar "; message+="\n  'Usuario y Contraseña'";
            v.ShowMessage(message, v.warning_Message);
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Load();
        if(empleado != null){
            if(isNuevo){
                if(isValidate()){
                    C_Usuario.insert_update(isNuevo, idUsuario, empleado , this.txt_nombreUsuario.getText(), new String(this.txt_contraseña.getText()), String.valueOf(this.cb_rollUsuario.getSelectedItem()));
                    v.ShowMessage("Ok", v.insert);
                    Reset();
                    LoadTable();
                }
            }
            if(isEditar){
                if(isValidate()){
                    C_Usuario.insert_update(isNuevo, idUsuario, empleado , this.txt_nombreUsuario.getText(), new String(this.txt_contraseña.getText()), String.valueOf(this.cb_rollUsuario.getSelectedItem()));
                    v.ShowMessage("Ok", v.update);
                    Reset();
                    LoadTable();
                }
            }
        }else {
            System.out.println("Empleado nulo");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.ClearFields();
        this.EnableFields(false);
        this.Reset();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void cb_BuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_BuscarPorItemStateChanged
        this.txt_textoBuscar.setText("");
    }//GEN-LAST:event_cb_BuscarPorItemStateChanged

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        this.txt_textoBuscar.setEditable(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_CargarMasProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CargarMasProveedoresActionPerformed
        LoadTable();
    }//GEN-LAST:event_btn_CargarMasProveedoresActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = this.table.getSelectedRow();
        if(row != (-1)){
            if(evt.getClickCount() == 2){
                LoadFields();
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void rb_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_empleadoActionPerformed
        Mode();
        this.setTitle("Gestión de Usuarios ::   Búsqueda de Empleados");
    }//GEN-LAST:event_rb_empleadoActionPerformed

    private void rb_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_usuarioActionPerformed
        Mode();
        this.setTitle("Gestión de Usuarios ::   Búsqueda de Usuarios");
    }//GEN-LAST:event_rb_usuarioActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        if(rb_usuario.isSelected()){
            if(!this.txt_nombre.getText().isEmpty()){
                this.EnableFields(true);
                this.txt_nombreUsuario.requestFocus();
                this.isEditar = true;
                this.isNuevo = false;
            }else{
                String  message = "Elija un Usuario para editar "; message+="\n  'Usuario y Contraseña'";
            v.ShowMessage(message, v.warning_Message);
            }
        }else{
                v.ShowMessage("¡Elija modo Usuario para editar los datos..!", v.warning_Message);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void txt_textoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_textoBuscarKeyReleased
        if(this.cb_BuscarPor.getSelectedIndex()>0){
            if(currentuser.getRoll().equalsIgnoreCase("Vendedor")){
                System.out.println("finder -> vendedor");
                matchfindVendedor();
            }else{
                System.out.println("finder -> admin");
                matchfind();
            }
        }else v.ShowMessage("¡Elija un método de busqueda..!", v.warning_Message);
    }//GEN-LAST:event_txt_textoBuscarKeyReleased

    private void Mode(){
        ModoBusqueda();
        if(this.rb_empleado.isSelected()){
            this.table.setModel(modelEmpleado);
            this.modelEmpleado.ColumnSize(table);
            this.ClearFields();
        }
        if(this.rb_usuario.isSelected()){
            this.table.setModel(model);
            this.model.ColumnSize(table);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CargarMasProveedores;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_BuscarPor;
    private javax.swing.JComboBox<String> cb_rollUsuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JRadioButton rb_empleado;
    private javax.swing.JRadioButton rb_usuario;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JFormattedTextField txt_cedula;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextArea txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreUsuario;
    private javax.swing.JFormattedTextField txt_telefono;
    private javax.swing.JTextField txt_textoBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ClearFields() {
        this.txt_nombre.setText("");
        this.txt_apellido.setText("");
        this.txt_cedula.setValue("");
        this.txt_direccion.setText("");
        this.txt_telefono.setValue("");
        this.txt_cargo.setText("");
        this.txt_textoBuscar.setText("");
        
        this.txt_nombreUsuario.setText("");
        this.txt_contraseña.setText("");
        this.cb_rollUsuario.setSelectedIndex(0);
    }
    
    @Override
    public void EnableFields(boolean option) {
        this.txt_apellido.setEditable(false);
        this.txt_direccion.setEditable(false);
        this.txt_nombre.setEditable(false);
        this.txt_telefono.setEditable(false);
        this.txt_textoBuscar.setEditable(false);
        this.txt_cedula.setEditable(false);
        this.txt_cargo.setEditable(false);
        
        this.txt_nombreUsuario.setEditable(option);
        this.txt_contraseña.setEditable(option);
        
        if(currentuser.getRoll().equalsIgnoreCase("Vendedor")){
            this.cb_rollUsuario.setEnabled(false);
        }else{
            this.cb_rollUsuario.setEnabled(option);
        }
        EnableButtoms(!option);
    }

    @Override
    public void EnableButtoms(boolean option) {
        this.btn_nuevo.setEnabled(option);
        this.btn_editar.setEnabled(option);
        this.btn_imprimir.setEnabled(option);
        this.btn_buscar.setEnabled(option);
        this.cb_BuscarPor.setEnabled(option);

        this.btn_guardar.setEnabled(!option);
        this.btn_cancelar.setEnabled(!option);
    }
    
   
    @Override
    public void LoadTable() {
        if(this.rb_usuario.isSelected()){
            this.model.Clear();
            th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(!C_Usuario.findAll().isEmpty()){
                        for(UsuarioCompleto usuario : usuarios){
                            model.addRow(usuario);
                        } 
                    }else{
                        v.ShowMessage("¡No existen registros de usuarios..!", v.warning_Message);
                    }
                    
                }
            });
            th.start();
        }
        if(this.rb_empleado.isSelected()){
            this.modelEmpleado.Clear();
            th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(!C_Empleado.findAll().isEmpty()){
                        for(Empleado empleado : C_Empleado.findAll()){
                            modelEmpleado.addRow(empleado);
                        } 
                    }else{
                        v.ShowMessage("¡No existen registros de empleados..!", v.warning_Message);
                    }
                }
            });
        th.start();
        }
    }
    
    @Override
    public void LoadFields(){
        if(this.rb_usuario.isSelected()){
            try {
                int row = this.table.getSelectedRow();
                idEmpleado  = v.Integer((String.valueOf(this.table.getValueAt(row, 0))));
                idUsuario   = v.Integer((String.valueOf(this.table.getValueAt(row, 1))));
                foto = (byte []) this.table.getValueAt(row, 15);
                password = (byte []) this.table.getValueAt(row, 3);
                empleado = C_Empleado.find(idEmpleado);
                
                this.txt_nombreUsuario.setText(String.valueOf(this.table.getValueAt(row, 2)));
                this.txt_contraseña.setText(Cifrado.descifra(password));
//                System.out.println("Contraseña Desifrada: "+Cifrado.descifra(password));
                this.cb_rollUsuario.setSelectedItem(String.valueOf(this.table.getValueAt(row, 4)));
                
                this.txt_cedula.setText(String.valueOf(this.table.getValueAt(row, 6)));
                this.txt_nombre.setText(String.valueOf(this.table.getValueAt(row, 7)));
                this.txt_apellido.setText(String.valueOf(this.table.getValueAt(row, 8)));
                this.txt_telefono.setText(String.valueOf(this.table.getValueAt(row, 9)));
                this.txt_direccion.setText(String.valueOf(this.table.getValueAt(row, 10)));
                this.txt_cargo.setText(String.valueOf(this.table.getValueAt(row, 12)));
            } catch (Exception ex) {
                Logger.getLogger(V_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        if(this.rb_empleado.isSelected()){
            int row = this.table.getSelectedRow();
            idEmpleado = v.Integer((String.valueOf(this.table.getValueAt(row, 0))));
            foto = (byte []) this.table.getValueAt(row, 8);   
//            System.out.println("idEmpleado: "+idEmpleado);            
            empleado = C_Empleado.find(idEmpleado);
//                System.out.println("modo empleado-> nombre : "+empleado.getNombre());

            this.txt_cedula.setText(String.valueOf(this.table.getValueAt(row, 1)));
            this.txt_nombre.setText(String.valueOf(this.table.getValueAt(row, 2)));
            this.txt_apellido.setText(String.valueOf(this.table.getValueAt(row, 3)));
            this.txt_telefono.setText(String.valueOf(this.table.getValueAt(row, 4)));
            this.txt_direccion.setText(String.valueOf(this.table.getValueAt(row, 5)));
            this.txt_cedula.setText(String.valueOf(this.table.getValueAt(row, 6)));
            
            this.txt_cargo.setText(String.valueOf(this.table.getValueAt(row, 10)));
        }
        v.LoadImagePanel(this.panelFoto, v.Byte_BufferedImage(foto));
    }
   
    @Override
    public void Reset(){
        ClearFields();
        model.Clear();
        modelEmpleado.Clear();
        isNuevo=false;
        isEditar=false;
        idPersona = 0;
        idEmpleado = 0;
        idUsuario = 0;
        empleado = null;
    }
    
    @Override
    public boolean isValidate(){
        /*if(v.isMaxString(txt_nombre.getText(), 50) || !txt_nombre.getText().isEmpty()){
           if(v.isMaxString(txt_apellido.getText(), 50) || !txt_apellido.getText().isEmpty()){
               if(v.isMaxString(txt_direccion.getText(), 200) || !txt_direccion.getText().isEmpty()){
                   if(v.isMinString(v.ReplaceGuion(txt_telefono.getText()), 8)){
                        if(v.isMinString(v.ReplaceGuion(txt_cedula.getText()), 14)){
                            return true;
                        }else{  v.ShowMessage("El numero de cedula no puede contener menos de 14 caracteres..!", v.warning_Message);  }
                    }else{  v.ShowMessage("El telefono no puede contener menos de 8 caracteres..!", v.warning_Message);  }
                }else{  v.ShowMessage("La direccion no puede estar vacia o contener mas de 200 caracteres..!", v.warning_Message);  }
            }else{  v.ShowMessage("El apellido no puede estar vacio o contener mas de 50 caracteres..!", v.warning_Message);  }
        }else{  v.ShowMessage("El nombre no puede estar vacio o contener mas de 50 caracteres..!", v.warning_Message);  }
        */
        return true;
    }
    
    String[] modelUsr = new String[]{"Nombre de usuario", "Roll", "Cargo"};
    String[] modelEmp = new String[]{"Nombres del empleado", "Apellidos del empleado", "Cargo"};
    
    private void ModoBusqueda(){
        DefaultComboBoxModel modelcomoboBox = new DefaultComboBoxModel(){
            @Override
            public int getSize() {
                return super.getSize()+1; 
            }
            @Override
            public Object getElementAt(int index) {
                if(index==0){
                    return "( Método de búsqueda )";
                }else{
                    return super.getElementAt(index-1);
                }
            }
            };
            this.cb_BuscarPor.setModel(modelcomoboBox);
            if(this.rb_usuario.isSelected()){
                for(String item: modelUsr){
                    modelcomoboBox.addElement(item);
                }
            }
        
            if(this.rb_empleado.isSelected()){
                for(String item: modelEmp){
                    modelcomoboBox.addElement(item);
                }
            }
            this.cb_BuscarPor.setSelectedIndex(0);
    }
    
    private void matchfind(){
        model.Clear();
        for(UsuarioCompleto u : C_Usuario.matchfind(this.cb_BuscarPor.getSelectedIndex(), this.txt_textoBuscar.getText())){
            model.addRow(u);
        }
    }
    
    private void matchfindVendedor(){
        model.Clear();
        for(UsuarioCompleto u : C_Usuario.matchfind(this.cb_BuscarPor.getSelectedIndex(), this.txt_textoBuscar.getText())){
            if(Objects.equals(currentuser.getIdusuario(), u.getIdusuario())){
                model.addRow(u);
            }
        }
    }
    
    private void AccesMode(){
        List<UsuarioCompleto> users = new ArrayList();
        if(currentuser.getRoll().equalsIgnoreCase("Vendedor")){
            for(UsuarioCompleto user : usuarios){
                if(currentuser.getIdusuario() == user.getIdusuario()){
                    users.add(user);
                }
            }
            usuarios = users;
        }
    }
    
    
}
