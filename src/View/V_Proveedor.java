/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.C_Proveedor;
import Controler.C_Representante;
import Render.ModelProveedores;
import Render.ModelRepresentanteProveedor;
import Validations.Validate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author AllanHavid
 */
public class V_Proveedor extends javax.swing.JInternalFrame {

    boolean nuevo, editar;
    int idProveedor = 0, idRepresentante = 0;
    int top = 0;
    Validate v = new Validate();
    C_Proveedor cprov = new C_Proveedor();
    C_Representante crep = new C_Representante();

    ModelProveedores model = new ModelProveedores(cprov.findAll());
    ModelRepresentanteProveedor mrp = new ModelRepresentanteProveedor(new ArrayList());

    public V_Proveedor() {
        initComponents();
        ini();
    }

    private void ini() {
        model.ColumnSize(table_Proveedor);
        mrp.ColumnSize(table_Representantes);
        this.Disable_FieldsProv();
        this.Disable_FieldsRep();
        rb_buscarProveedor.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PanelPrincipal = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_nuevo1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_guardar1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        rb_buscarProveedor = new javax.swing.JRadioButton();
        rb_buscarRepresentante = new javax.swing.JRadioButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btn_buscar1 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        cb_BuscarPor1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JTextField();
        panelDetalleProveedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombreProveedor = new javax.swing.JTextField();
        txt_RUC = new javax.swing.JTextField();
        txt_telefonoProveedor = new javax.swing.JFormattedTextField();
        btn_nuevoRepresentante = new javax.swing.JButton();
        panelTablaProveedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Proveedor = new javax.swing.JTable();
        panelTablaRepresentantes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Representantes = new javax.swing.JTable();
        panelDetalleRepresentante = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_apellidosReprsentante = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_nombreRepresentante = new javax.swing.JTextField();
        txt_apellidosRepresentante = new javax.swing.JTextField();
        txt_telefonoRepresentante = new javax.swing.JFormattedTextField();
        txt_apellidosReprsentante1 = new javax.swing.JLabel();
        txt_ncedulaRepresentante = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_direccionRepresentante = new javax.swing.JTextArea();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Gestion de Proveedores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/proveedor.png"))); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setOpaque(false);
        jToolBar3.add(jSeparator1);

        btn_nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/address-book-new.png"))); // NOI18N
        btn_nuevo1.setToolTipText("Nuevo Elemento");
        btn_nuevo1.setFocusable(false);
        btn_nuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevo1.setOpaque(false);
        btn_nuevo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_nuevo1);
        jToolBar3.add(jSeparator2);

        btn_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-save-all.png"))); // NOI18N
        btn_guardar1.setToolTipText("Guardar Datos");
        btn_guardar1.setFocusable(false);
        btn_guardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar1.setOpaque(false);
        btn_guardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_guardar1);
        jToolBar3.add(jSeparator3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-edit.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton2);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(1, 0));
        jToolBar3.add(jSeparator5);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-print.png"))); // NOI18N
        jButton1.setToolTipText("Imprimir reporte individual");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton1);
        jToolBar3.add(jSeparator7);

        buttonGroup1.add(rb_buscarProveedor);
        rb_buscarProveedor.setFont(new java.awt.Font("Monotype Corsiva", 2, 14)); // NOI18N
        rb_buscarProveedor.setForeground(new java.awt.Color(0, 0, 153));
        rb_buscarProveedor.setText("Buscar Proveedor");
        rb_buscarProveedor.setContentAreaFilled(false);
        rb_buscarProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb_buscarProveedorItemStateChanged(evt);
            }
        });
        rb_buscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_buscarProveedorActionPerformed(evt);
            }
        });
        jToolBar3.add(rb_buscarProveedor);

        buttonGroup1.add(rb_buscarRepresentante);
        rb_buscarRepresentante.setFont(new java.awt.Font("Monotype Corsiva", 2, 14)); // NOI18N
        rb_buscarRepresentante.setForeground(new java.awt.Color(0, 0, 153));
        rb_buscarRepresentante.setText("Buscar Representante");
        rb_buscarRepresentante.setContentAreaFilled(false);
        rb_buscarRepresentante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb_buscarRepresentanteItemStateChanged(evt);
            }
        });
        rb_buscarRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_buscarRepresentanteActionPerformed(evt);
            }
        });
        jToolBar3.add(rb_buscarRepresentante);
        jToolBar3.add(jSeparator6);

        btn_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_find.png"))); // NOI18N
        btn_buscar1.setToolTipText("Buscar Registro");
        btn_buscar1.setFocusable(false);
        btn_buscar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_buscar1.setOpaque(false);
        btn_buscar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_buscar1);
        jToolBar3.add(jSeparator8);

        jLabel5.setText("  ");
        jToolBar3.add(jLabel5);

        cb_BuscarPor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "( Metodo de Busqueda )", "Codigo Socio", "Nombre del Socio", " " }));
        cb_BuscarPor1.setToolTipText("Metodo de Busqueda de los Registros");
        cb_BuscarPor1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_BuscarPor1ItemStateChanged(evt);
            }
        });
        jToolBar3.add(cb_BuscarPor1);

        jLabel1.setText("  ");
        jToolBar3.add(jLabel1);

        jPanel3.setOpaque(false);

        textoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar3.add(jPanel3);

        jToolBar1.add(jToolBar3);

        panelDetalleProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N
        panelDetalleProveedor.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Nombre :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Telefono :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("RUC :");

        try {
            txt_telefonoProveedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btn_nuevoRepresentante.setText("Nuevo representante");
        btn_nuevoRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoRepresentanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetalleProveedorLayout = new javax.swing.GroupLayout(panelDetalleProveedor);
        panelDetalleProveedor.setLayout(panelDetalleProveedorLayout);
        panelDetalleProveedorLayout.setHorizontalGroup(
            panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalleProveedorLayout.createSequentialGroup()
                        .addGroup(panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txt_RUC, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txt_telefonoProveedor))
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(panelDetalleProveedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_nuevoRepresentante)))
                .addContainerGap())
        );
        panelDetalleProveedorLayout.setVerticalGroup(
            panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_telefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_RUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_nuevoRepresentante)
                .addContainerGap())
        );

        panelTablaProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Proveedores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N

        table_Proveedor.setModel(model);
        table_Proveedor.getTableHeader().setResizingAllowed(false);
        table_Proveedor.getTableHeader().setReorderingAllowed(false);
        table_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Proveedor);

        javax.swing.GroupLayout panelTablaProveedoresLayout = new javax.swing.GroupLayout(panelTablaProveedores);
        panelTablaProveedores.setLayout(panelTablaProveedoresLayout);
        panelTablaProveedoresLayout.setHorizontalGroup(
            panelTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        panelTablaProveedoresLayout.setVerticalGroup(
            panelTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelTablaRepresentantes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Representantes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N

        table_Representantes.setModel(mrp);
        table_Representantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_RepresentantesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_Representantes);

        javax.swing.GroupLayout panelTablaRepresentantesLayout = new javax.swing.GroupLayout(panelTablaRepresentantes);
        panelTablaRepresentantes.setLayout(panelTablaRepresentantesLayout);
        panelTablaRepresentantesLayout.setHorizontalGroup(
            panelTablaRepresentantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaRepresentantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaRepresentantesLayout.setVerticalGroup(
            panelTablaRepresentantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaRepresentantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelDetalleRepresentante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Representante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N
        panelDetalleRepresentante.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setText("Nombre :");

        txt_apellidosReprsentante.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_apellidosReprsentante.setText("Telefono :");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setText("Apellidos :");

        try {
            txt_telefonoRepresentante.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txt_apellidosReprsentante1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_apellidosReprsentante1.setText("Numero de Cédula :");

        try {
            txt_ncedulaRepresentante.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setText("Dirección :");

        txt_direccionRepresentante.setColumns(20);
        txt_direccionRepresentante.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txt_direccionRepresentante.setRows(5);
        jScrollPane2.setViewportView(txt_direccionRepresentante);

        javax.swing.GroupLayout panelDetalleRepresentanteLayout = new javax.swing.GroupLayout(panelDetalleRepresentante);
        panelDetalleRepresentante.setLayout(panelDetalleRepresentanteLayout);
        panelDetalleRepresentanteLayout.setHorizontalGroup(
            panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleRepresentanteLayout.createSequentialGroup()
                .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDetalleRepresentanteLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellidosRepresentante)
                            .addComponent(txt_nombreRepresentante)))
                    .addGroup(panelDetalleRepresentanteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txt_apellidosReprsentante1)
                            .addComponent(txt_apellidosReprsentante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(txt_ncedulaRepresentante)
                            .addComponent(txt_telefonoRepresentante))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        panelDetalleRepresentanteLayout.setVerticalGroup(
            panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleRepresentanteLayout.createSequentialGroup()
                .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_apellidosRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apellidosReprsentante)
                    .addComponent(txt_telefonoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apellidosReprsentante1)
                    .addComponent(txt_ncedulaRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetalleRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalleRepresentanteLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDetalleProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTablaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 364, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDetalleRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTablaRepresentantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDetalleRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDetalleProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelTablaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelTablaRepresentantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 516, Short.MAX_VALUE)))
        );

        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo1ActionPerformed

        this.Clear_FieldsProv();
        this.Enable_FieldsProv();

        mrp.Clear();

        nuevo = true;
        editar = false;
    }//GEN-LAST:event_btn_nuevo1ActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        if (nuevo) {// Solo la edicion de proveedores

            JOptionPane.showMessageDialog(null, cprov.insert(txt_nombreProveedor.getText(), txt_telefonoProveedor.getText(), txt_RUC.getText()));

            this.nuevo = false;
            this.editar = false;

            mrp.Clear();

            model.Clear();

            model = new ModelProveedores(cprov.findAll());

            table_Proveedor.setModel(model);
            model.ColumnSize(table_Proveedor);
            mrp.ColumnSize(table_Representantes);
        }
        if (nuevoRep) {

            try {
                crep.insert(idProveedor, txt_nombreRepresentante.getText(),
                        txt_apellidosRepresentante.getText(),
                        txt_direccionRepresentante.getText(),
                        txt_telefonoRepresentante.getText(), v.ReplaceGuion(txt_ncedulaRepresentante.getText()));

                JOptionPane.showMessageDialog(null, "Se guardó Exitosamente");

                mrp.Clear();
                Clear_FieldsRep();
                mrp = new ModelRepresentanteProveedor(cprov.getRepresentantes(idProveedor));

                table_Representantes.setModel(mrp);
                mrp.fireTableDataChanged();

                //No actualiza tabla
                model.ColumnSize(table_Proveedor);
                mrp.ColumnSize(table_Representantes);

                idRepresentante = 0;

            } catch (RuntimeException re) {
                JOptionPane.showMessageDialog(null, "Error al Guardar Representante");
                re.printStackTrace();
            }

        }

        if (editar) {
            /* if (idRepresentante!=0) {
                
                System.out.println(crep.update(idRepresentante, idProveedor, txt_nombreRepresentante.getText()
                        , txt_apellidosRepresentante.getText(), txt_direccionRepresentante.getText(), txt_telefonoRepresentante.getText()));
                
            }else
                System.out.println(cprov.update(idProveedor, txt_nombreProveedor.getText(), txt_telefonoProveedor.getText()
                        , txt_RUC.getText()));*/

            if (idRepresentante == 0) {
                System.out.println(cprov.update(idProveedor, txt_nombreProveedor.getText(), txt_telefonoProveedor.getText(), txt_RUC.getText()));

            } else {
                System.out.println(cprov.update(idProveedor, txt_nombreProveedor.getText(), txt_telefonoProveedor.getText(), txt_RUC.getText()));
                System.out.println(crep.update(idRepresentante, idProveedor, txt_nombreRepresentante.getText(), txt_apellidosRepresentante.getText(),
                        txt_direccionRepresentante.getText(), txt_telefonoRepresentante.getText(), v.ReplaceGuion(txt_ncedulaRepresentante.getText())));
            }
            this.nuevo = false;
            this.editar = false;
        }

        idProveedor = 0;
        idRepresentante = 0;
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
        //this.EnableFind(true);
    }//GEN-LAST:event_btn_buscar1ActionPerformed

    private void cb_BuscarPor1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_BuscarPor1ItemStateChanged

    }//GEN-LAST:event_cb_BuscarPor1ItemStateChanged

    private void table_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ProveedorMouseClicked
        int N = evt.getClickCount();
        this.Disable_FieldsProv();
        this.Disable_FieldsRep();
        if (N >= 2) {

            txt_nombreProveedor.setText((String) model.getValueAt(table_Proveedor.getSelectedRow(), 1));
            txt_telefonoProveedor.setText((String) model.getValueAt(table_Proveedor.getSelectedRow(), 2));
            txt_RUC.setText((String) model.getValueAt(table_Proveedor.getSelectedRow(), 3));

            idProveedor = (Integer) model.getValueAt(table_Proveedor.getSelectedRow(), 0);

            mrp = new ModelRepresentanteProveedor(cprov.getRepresentantes(idProveedor));

            table_Representantes.setModel(mrp);
            idRepresentante = 0;
            this.Disable_FieldsProv();
            this.btn_nuevoRepresentante.setEnabled(true);
            model.ColumnSize(table_Proveedor);
            mrp.ColumnSize(table_Representantes);
        }


    }//GEN-LAST:event_table_ProveedorMouseClicked

    private void table_RepresentantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_RepresentantesMouseClicked
        int N = evt.getClickCount();

        if (N >= 2) {

            txt_nombreRepresentante.setText((String) table_Representantes.getValueAt(table_Representantes.getSelectedRow(), 1));
            txt_apellidosRepresentante.setText((String) table_Representantes.getValueAt(table_Representantes.getSelectedRow(), 2));
            txt_telefonoRepresentante.setText((String) table_Representantes.getValueAt(table_Representantes.getSelectedRow(), 4));
            txt_ncedulaRepresentante.setText((String) table_Representantes.getValueAt(table_Representantes.getSelectedRow(), 5));
            txt_direccionRepresentante.setText((String) table_Representantes.getValueAt(table_Representantes.getSelectedRow(), 3));

            idRepresentante = (Integer) table_Representantes.getValueAt(table_Representantes.getSelectedRow(), 0);
        }


    }//GEN-LAST:event_table_RepresentantesMouseClicked
    boolean nuevoRep = false;
    private void btn_nuevoRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoRepresentanteActionPerformed
        this.Clear_FieldsRep();

        this.Enable_FieldsRep();
        this.txt_nombreRepresentante.requestFocus();
        nuevoRep = true;
        editar = false;

    }//GEN-LAST:event_btn_nuevoRepresentanteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    boolean tipoBusqueda = false; //false = Proveedor ; true = Representantes

    private void rb_buscarProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb_buscarProveedorItemStateChanged
        tipoBusqueda = false;

        LoadComboboxProv();
    }//GEN-LAST:event_rb_buscarProveedorItemStateChanged

    public void LoadComboboxProv() {
        cb_BuscarPor1.setModel(new DefaultComboBoxModel(cprov.Busqueda()));

    }

    public void LoadComboboxRep() {
        cb_BuscarPor1.setModel(new DefaultComboBoxModel(crep.Busqueda()));
    }

    private void rb_buscarRepresentanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb_buscarRepresentanteItemStateChanged
        tipoBusqueda = true;

        LoadComboboxRep();
    }//GEN-LAST:event_rb_buscarRepresentanteItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        C_Proveedor.Representantes_Proveedor();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rb_buscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_buscarProveedorActionPerformed
        this.setTitle("Gestión de Proveedores");
    }//GEN-LAST:event_rb_buscarProveedorActionPerformed

    private void rb_buscarRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_buscarRepresentanteActionPerformed
        this.setTitle("Gestión de Representantes");
    }//GEN-LAST:event_rb_buscarRepresentanteActionPerformed

    private void textoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoBuscarKeyPressed

    }//GEN-LAST:event_textoBuscarKeyPressed

    private void textoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoBuscarKeyReleased

        if (rb_buscarProveedor.isSelected()) {
            System.out.println("BuscarProveedor Selected");
            switch (cb_BuscarPor1.getSelectedIndex()) {
                case 0: { //Por Nombre

                    model.Clear();
                    mrp.Clear();

                    model = new ModelProveedores(cprov.buscarPorNombre(textoBuscar.getText()));

                    table_Proveedor.setModel(model);
                    model.ColumnSize(table_Proveedor);
                    mrp.ColumnSize(table_Representantes);
                }
                break;

                case 1: { //Por telefono

                    model.Clear();
                    mrp.Clear();

                    model = new ModelProveedores(cprov.buscarPorTelefono(textoBuscar.getText()));

                    table_Proveedor.setModel(model);
                    model.ColumnSize(table_Proveedor);
                    mrp.ColumnSize(table_Representantes);

                }
                break;

                case 2: { //por RUC
                    model.Clear();
                    mrp.Clear();

                    model = new ModelProveedores(cprov.buscarPorRUC(textoBuscar.getText()));

                    table_Proveedor.setModel(model);
                    model.ColumnSize(table_Proveedor);
                    mrp.ColumnSize(table_Representantes);
                }
                break;
            }

        } else if (rb_buscarRepresentante.isSelected()) {
            System.out.println("Buscar Representante selected");
            switch (cb_BuscarPor1.getSelectedIndex()) {
                case 0: { // Por Nombre
                    model.Clear();
                    mrp.Clear();

                    mrp = new ModelRepresentanteProveedor(crep.findByName(textoBuscar.getText()));

                    table_Representantes.setModel(mrp);
                    model.ColumnSize(table_Proveedor);
                    mrp.ColumnSize(table_Representantes);
                }
                break;

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la búsqueda");
        }


    }//GEN-LAST:event_textoBuscarKeyReleased

    public void Clear_FieldsRep() {
        txt_nombreRepresentante.setText("");
        txt_apellidosRepresentante.setText("");
        txt_telefonoRepresentante.setText("");
        txt_ncedulaRepresentante.setText("");
        txt_direccionRepresentante.setText("");
    }

    public void Clear_FieldsProv() {
        txt_nombreProveedor.setText("");
        txt_telefonoProveedor.setText("");
        txt_RUC.setText("");
    }

    public void Enable_FieldsProv() {
        txt_nombreProveedor.setEnabled(true);
        txt_telefonoProveedor.setEnabled(true);
        txt_RUC.setEnabled(true);
        btn_nuevoRepresentante.setEnabled(true);
    }

    public void Disable_FieldsProv() {
        txt_nombreProveedor.setEnabled(false);
        txt_telefonoProveedor.setEnabled(false);
        txt_RUC.setEnabled(false);
        btn_nuevoRepresentante.setEnabled(false);
    }

    public void Enable_FieldsRep() {
        txt_nombreRepresentante.setEnabled(true);
        txt_apellidosRepresentante.setEnabled(true);
        txt_telefonoRepresentante.setEnabled(true);
        txt_ncedulaRepresentante.setEnabled(true);
        txt_direccionRepresentante.setEnabled(true);
    }

    public void Disable_FieldsRep() {
        txt_nombreRepresentante.setEnabled(false);
        txt_apellidosRepresentante.setEnabled(false);
        txt_telefonoRepresentante.setEnabled(false);
        txt_ncedulaRepresentante.setEnabled(false);
        txt_direccionRepresentante.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btn_buscar1;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_nuevo1;
    private javax.swing.JButton btn_nuevoRepresentante;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_BuscarPor1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JPanel panelDetalleProveedor;
    private javax.swing.JPanel panelDetalleRepresentante;
    private javax.swing.JPanel panelTablaProveedores;
    private javax.swing.JPanel panelTablaRepresentantes;
    private javax.swing.JRadioButton rb_buscarProveedor;
    private javax.swing.JRadioButton rb_buscarRepresentante;
    private javax.swing.JTable table_Proveedor;
    private javax.swing.JTable table_Representantes;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JTextField txt_RUC;
    private javax.swing.JTextField txt_apellidosRepresentante;
    private javax.swing.JLabel txt_apellidosReprsentante;
    private javax.swing.JLabel txt_apellidosReprsentante1;
    private javax.swing.JTextArea txt_direccionRepresentante;
    private javax.swing.JFormattedTextField txt_ncedulaRepresentante;
    private javax.swing.JTextField txt_nombreProveedor;
    private javax.swing.JTextField txt_nombreRepresentante;
    private javax.swing.JFormattedTextField txt_telefonoProveedor;
    private javax.swing.JFormattedTextField txt_telefonoRepresentante;
    // End of variables declaration//GEN-END:variables
}
