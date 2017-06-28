package View;

import Controler.C_Categoria;
import Controler.C_Producto;
import Render.ModelProducto;
import Render.Modelos_Combobox;
import Validations.Interface;
import Validations.WindowsDrive;
import static View.Principal.DesktopPane;
import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author AllanHavid
 */
public class V_Producto extends javax.swing.JInternalFrame implements Interface{

    /*       Solo para Producto        */
    boolean nuevo, editar;
    int idProducto;

    int top = 0;

    /*       Solo para Categoria       */
    boolean nuevoC, editarC;
    public static int idCategoriaC;

    ModelProducto mp;
    C_Producto cprod = new C_Producto();
    C_Categoria ccat = new C_Categoria();

    public V_Producto() {
        initComponents();
        
        mp = new ModelProducto(cprod.findAll());
        
        table_Producto.setModel(mp);
        mp.ColumnSize(table_Producto);
        this.EnableFields(false);
        this.cb_categoria.setVisible(false);
        loadCB();

        comb_Categoria.setModel(new DefaultComboBoxModel(ccat.getNombres().toArray()));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClicDerecho = new javax.swing.JPopupMenu();
        CambiarEstado = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JTextField();
        opcion_buscar = new javax.swing.JComboBox();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        cb_categoria = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombreProducto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_apellidosReprsentante = new javax.swing.JLabel();
        txt_Marca = new javax.swing.JTextField();
        txt_apellidosReprsentante1 = new javax.swing.JLabel();
        comb_Categoria = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        panelPrecios = new javax.swing.JPanel();
        lbl_PrecioVenta = new javax.swing.JLabel();
        lbl_PrecioCompra = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelTablaProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Producto = new javax.swing.JTable();

        CambiarEstado.setText("Cambiar Estado");
        CambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarEstadoActionPerformed(evt);
            }
        });
        ClicDerecho.add(CambiarEstado);

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestión de Producto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-app.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(760, 589));
        setMinimumSize(new java.awt.Dimension(760, 589));
        setPreferredSize(new java.awt.Dimension(760, 589));

        jPanel1.setPreferredSize(new java.awt.Dimension(838, 559));

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

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-edit.png"))); // NOI18N
        btn_editar.setToolTipText("Editar");
        btn_editar.setFocusable(false);
        btn_editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editar.setOpaque(false);
        btn_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_editar);

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

        jLabel2.setText("|");
        jToolBar3.add(jLabel2);

        jLabel1.setText("  ");
        jToolBar3.add(jLabel1);

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

        jLabel5.setText("Buscar por ");
        jToolBar3.add(jLabel5);

        jPanel3.setOpaque(false);

        textoBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoBuscarKeyPressed(evt);
            }
        });

        opcion_buscar.setToolTipText("Metodo de Busqueda de los Registros");
        opcion_buscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                opcion_buscarItemStateChanged(evt);
            }
        });

        cb_categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_categoriaItemStateChanged(evt);
            }
        });
        cb_categoria.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cb_categoriaComponentShown(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(opcion_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(opcion_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jToolBar3.add(jPanel3);

        jToolBar1.add(jToolBar3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setText("Nombre del Producto :");

        txt_nombreProducto.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setText("Descripcion :");

        txt_apellidosReprsentante.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_apellidosReprsentante.setText("Marca :");

        txt_Marca.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        txt_apellidosReprsentante1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_apellidosReprsentante1.setText("Categoria :");

        comb_Categoria.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comb_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria..." }));
        comb_Categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comb_CategoriaItemStateChanged(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_setting.png"))); // NOI18N
        jButton3.setToolTipText("Administrar todas las categorias");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_descripcion.setColumns(20);
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        panelPrecios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N

        lbl_PrecioVenta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_PrecioVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_PrecioCompra.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_PrecioCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Precio de Venta :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Precio de Compra :");

        javax.swing.GroupLayout panelPreciosLayout = new javax.swing.GroupLayout(panelPrecios);
        panelPrecios.setLayout(panelPreciosLayout);
        panelPreciosLayout.setHorizontalGroup(
            panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_PrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_PrecioVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPreciosLayout.createSequentialGroup()
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPreciosLayout.setVerticalGroup(
            panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreciosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_PrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_apellidosReprsentante1)
                    .addComponent(txt_apellidosReprsentante)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comb_Categoria, 0, 258, Short.MAX_VALUE)
                            .addComponent(txt_nombreProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apellidosReprsentante)
                    .addComponent(txt_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comb_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_apellidosReprsentante1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTablaProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N

        table_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_Producto.setComponentPopupMenu(ClicDerecho);
        table_Producto.getTableHeader().setResizingAllowed(false);
        table_Producto.getTableHeader().setReorderingAllowed(false);
        table_Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Producto);

        javax.swing.GroupLayout panelTablaProductosLayout = new javax.swing.GroupLayout(panelTablaProductos);
        panelTablaProductos.setLayout(panelTablaProductosLayout);
        panelTablaProductosLayout.setHorizontalGroup(
            panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelTablaProductosLayout.setVerticalGroup(
            panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTablaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        ///this.table.setModel(modelTableEmpleado);

        this.EnableFields(true);
        //this.EnableFind(true);
        //this.textoBuscar.requestFocus();
        nuevo = true;
        editar = false;
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        if (nuevo) {
            this.EnableFields(false);

            JOptionPane.showMessageDialog(null, cprod.create(txt_nombreProducto.getText(), txt_Marca.getText(), txt_descripcion.getText(), String.valueOf(comb_Categoria.getSelectedItem())));

            this.ClearFields();
            this.nuevo = false;
            this.editar = false;
        }
        if (editar) {
            this.EnableFields(false);

            try {
                String txt = cprod.update(idProducto, txt_nombreProducto.getText(), txt_Marca.getText(), txt_descripcion.getText(), String.valueOf(comb_Categoria.getSelectedItem()));
                this.ClearFields();
                System.out.println(txt);
                
            } catch (RuntimeException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
            
            
            this.nuevo = false;
            this.editar = false;
        }
        
        mp.Clear();
            
            mp = new ModelProducto(cprod.findAll());
            
            table_Producto.setModel(mp);
            mp.ColumnSize(table_Producto);

        idProducto = 0;
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        //this.EnableFields(false);
        //this.EnableFind(true);
        //this.Clear();
        top = 10;
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        //this.EnableFind(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    String tipoBusqueda = ""; // "PorCategoria", "PorNombre", "PorMarca"

    private void opcion_buscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_opcion_buscarItemStateChanged
        this.textoBuscar.setText("");

        mp.Clear();

        mp = new ModelProducto(cprod.findAll());

        table_Producto.setModel(mp);
        mp.ColumnSize(table_Producto);

        switch (opcion_buscar.getSelectedIndex()) {

            case 0: {
                textoBuscar.setVisible(true);
                cb_categoria.setVisible(false);
                tipoBusqueda = "PorNombre";
            }
            break;

            case 1: {
                textoBuscar.setVisible(true);
                cb_categoria.setVisible(false);
                tipoBusqueda = "PorMarca";
            }
            break;

            case 2: {
                textoBuscar.setVisible(false);
                cb_categoria.setVisible(true);
                tipoBusqueda = "PorCategoria";
            }
            break;

        }


    }//GEN-LAST:event_opcion_buscarItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new V_Categorias(), DesktopPane);
        });
        th.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        this.EnableFields(true);
        nuevo = false;
        editar = true;
    }//GEN-LAST:event_btn_editarActionPerformed

    private void table_ProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ProductoMouseClicked
        int NClic = evt.getClickCount();

        if (NClic >= 2) {

            txt_nombreProducto.setText((String) mp.getValueAt(table_Producto.getSelectedRow(), 1));
            txt_descripcion.setText((String) mp.getValueAt(table_Producto.getSelectedRow(), 2));
            txt_Marca.setText((String) mp.getValueAt(table_Producto.getSelectedRow(), 3));
            comb_Categoria.setSelectedItem((String) mp.getValueAt(table_Producto.getSelectedRow(), 4));
            
            
            if (mp.getValueAt(table_Producto.getSelectedRow(), 6) ==null) {
                lbl_PrecioCompra.setText("Ninguno");
            }else
                lbl_PrecioCompra.setText(String.valueOf(mp.getValueAt(table_Producto.getSelectedRow(), 6)));
            
            if (mp.getValueAt(table_Producto.getSelectedRow(), 7) == null) {
                lbl_PrecioVenta.setText("Ninguno");
            }else
                lbl_PrecioVenta.setText(String.valueOf(mp.getValueAt(table_Producto.getSelectedRow(), 7)));
                   
            
            
            idProducto = (Integer) mp.getValueAt(table_Producto.getSelectedRow(), 0);

        }
        
        
        
    }//GEN-LAST:event_table_ProductoMouseClicked

    private void cb_categoriaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cb_categoriaComponentShown
        cb_categoria.setModel(new DefaultComboBoxModel(ccat.getNombres().toArray()));
    }//GEN-LAST:event_cb_categoriaComponentShown

    private void textoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoBuscarKeyPressed

        if (!textoBuscar.getText().isEmpty()) {
            switch (tipoBusqueda) {
                case "PorNombre": {
                    mp.Clear();

                    mp = new ModelProducto(cprod.getProductosPorNombre(textoBuscar.getText()));

                    table_Producto.setModel(mp);
                    mp.ColumnSize(table_Producto);

                }
                break;

                case "PorMarca": {
                    mp.Clear();

                    mp = new ModelProducto(cprod.getProductosPorMarca(textoBuscar.getText()));

                    table_Producto.setModel(mp);
                    mp.ColumnSize(table_Producto);
                }
                break;

                case "PorCategoria": {
                    textoBuscar.setText("");
                }
                break;
            }
        } else {

            mp.Clear();

            mp = new ModelProducto(cprod.findAll());

            table_Producto.setModel(mp);
            mp.ColumnSize(table_Producto);
        }

    }//GEN-LAST:event_textoBuscarKeyPressed

    private void cb_categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_categoriaItemStateChanged

        int SelectedIndex = cb_categoria.getSelectedIndex();
        if (SelectedIndex != 0) {

            mp.Clear();

            mp = new ModelProducto(cprod.getProductosPorCategoria(ccat.getIdPorNombre(String.valueOf(cb_categoria.getSelectedItem()))));

            table_Producto.setModel(mp);
            mp.ColumnSize(table_Producto);
        } else {
            mp.Clear();

            mp = new ModelProducto(cprod.findAll());

            table_Producto.setModel(mp);
            mp.ColumnSize(table_Producto);
        }


    }//GEN-LAST:event_cb_categoriaItemStateChanged

    private void comb_CategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comb_CategoriaItemStateChanged
        
    }//GEN-LAST:event_comb_CategoriaItemStateChanged

    private void CambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarEstadoActionPerformed
        
        if (table_Producto.getSelectedRow()!=-1) {
            
            
            int opc = JOptionPane.showConfirmDialog(null, "Esta seguro en Habilitar/Deshabilitar el Producto "+ (String) mp.getValueAt(table_Producto.getSelectedRow(), 1), 
                    "Advertencia"
                    ,JOptionPane.YES_NO_OPTION);
            
            if (opc == JOptionPane.YES_OPTION) {
                cprod.CambiarEstado((Integer) mp.getValueAt(table_Producto.getSelectedRow(), 0));
                System.out.println("idProducto a Cambiar : " + (Integer) mp.getValueAt(table_Producto.getSelectedRow(), 0));
            }
            
            mp.Clear();
            
            mp = new ModelProducto(cprod.findAll());
            
            table_Producto.setModel(mp);
            mp.ColumnSize(table_Producto);
        }else{
            
        }
        
        
    }//GEN-LAST:event_CambiarEstadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CambiarEstado;
    private javax.swing.JPopupMenu ClicDerecho;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cb_categoria;
    private javax.swing.JComboBox<String> comb_Categoria;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lbl_PrecioCompra;
    private javax.swing.JLabel lbl_PrecioVenta;
    private javax.swing.JComboBox opcion_buscar;
    private javax.swing.JPanel panelPrecios;
    private javax.swing.JPanel panelTablaProductos;
    private javax.swing.JTable table_Producto;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JLabel txt_apellidosReprsentante;
    private javax.swing.JLabel txt_apellidosReprsentante1;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_nombreProducto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ClearFields() {
        txt_nombreProducto.setText("");
        txt_descripcion.setText("");
        txt_Marca.setText("");
        lbl_PrecioVenta.setText("");
        lbl_PrecioCompra.setText("");
    }

    @Override
    public void EnableFields(boolean option) {
        txt_nombreProducto.setEnabled(option);
        txt_descripcion.setEnabled(option);
        txt_Marca.setEnabled(option);
        comb_Categoria.setEnabled(option);
    }

    @Override
    public void LoadTable() {
        
    }

    @Override
    public void LoadFields() {
    }

    @Override
    public void Reset() {
    }

    @Override
    public void EnableButtoms(boolean option) {
        this.btn_nuevo.setEnabled(option);
        this.btn_editar.setEnabled(option);
        this.btn_imprimir.setEnabled(option);
        this.btn_buscar.setEnabled(option);
        this.opcion_buscar.setEnabled(option);

        this.btn_guardar.setEnabled(!option);
        this.btn_cancelar.setEnabled(!option);
    }

    @Override
    public boolean isValidate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCB() {
        opcion_buscar.setModel(new JComboBox(Modelos_Combobox.getBusquedaProducto()).getModel());
    }
}
