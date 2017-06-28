package View;

import Controler.C_Cedula;
import Controler.C_Cliente;
import Model.Cliente;
import ResultClass.ClienteCompleto;
import Validations.Interface;
import Render.ModelTableCliente;
import Validations.BackgroundPanel;
import Validations.Validate;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.FileDialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import org.hibernate.Session;

/*@author Jairo Martinez*/

public class V_Cliente extends javax.swing.JInternalFrame implements Interface{
    
    Validate v = new Validate();
    ModelTableCliente model = new ModelTableCliente(new ArrayList());
    boolean isNuevo, isEditar=false, isSave=false;
    static boolean isOpen=false;
    JLabel labelFoto = new JLabel();
    Thread th;

    /*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
        Session session=null;
        int idPersona = 0;
        int idCliente = 0;
        byte [] foto = null;
    /*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    
    public V_Cliente() {
        ModelTableCliente model = new ModelTableCliente(new ArrayList());
        initComponents();
        init();
        LoadTable();
    }
    
    public void init(){
        this.setSize(950, 600);
        isOpen=true;
        this.ck_cedula.setSelected(false);
        this.txt_cedula.setEditable(false);
        this.txt_textoBuscar.setSize(20, 6);
        this.EnableFields(false);
        model.ColumnSize(tableCliente);
        this.panelFoto.setSize(160, 160);
        this.portadaClientes.setSize(230, 240);
        ((BackgroundPanel) this.panelCentral).setImagen("");
        v.CargarImagen(new File("src\\Images\\nofoto.png"), this.panelFoto);
        v.CargarImagen(new File("src\\Images\\Empleados.png"), this.portadaClientes);
//        WindowsClosing();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new BackgroundPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_nuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_editar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btn_guardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btn_cancelar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btn_imprimir = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        btn_buscar = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        cb_BuscarPor = new javax.swing.JComboBox();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        txt_textoBuscar = new javax.swing.JTextField();
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
        ck_cedula = new javax.swing.JCheckBox();
        panelFoto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_camara = new javax.swing.JButton();
        btn_explorar = new javax.swing.JButton();
        portadaClientes = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestion de Clientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/text-x-ldif2px.png"))); // NOI18N

        panelCentral.setPreferredSize(new java.awt.Dimension(838, 559));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setOpaque(false);
        jToolBar3.add(jSeparator1);

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
        jToolBar3.add(jSeparator2);

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
        jToolBar3.add(jSeparator3);

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
        jToolBar3.add(jSeparator4);

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
        jToolBar3.add(jSeparator6);

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-print.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir reporte individual");
        btn_imprimir.setFocusable(false);
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        jToolBar3.add(btn_imprimir);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(1, 0));
        jToolBar3.add(jSeparator5);

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
        jToolBar3.add(jSeparator7);

        cb_BuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "( Metodo de Busqueda )", "Nombres del cliente", "Apellidos del cliente", "Numero Cedula" }));
        cb_BuscarPor.setToolTipText("Metodo de Busqueda de los Registros");
        cb_BuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_BuscarPorItemStateChanged(evt);
            }
        });
        jToolBar3.add(cb_BuscarPor);
        jToolBar3.add(jSeparator8);

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
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txt_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txt_direccion.setRows(5);
        jScrollPane2.setViewportView(txt_direccion);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nombre :");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Apellidos :");

        jlabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jlabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel3.setText("Telefono :");

        jlabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jlabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel4.setText("Numero de Cédula :");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Dirección :");

        ck_cedula.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ck_cedula.setText("Si");
        ck_cedula.setOpaque(false);
        ck_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_cedulaActionPerformed(evt);
            }
        });

        panelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelFoto.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        btn_camara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/camera-photo.png"))); // NOI18N
        btn_camara.setText("Camara");
        btn_camara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_camara.setIconTextGap(0);
        btn_camara.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_camara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_camaraActionPerformed(evt);
            }
        });
        jPanel2.add(btn_camara);

        btn_explorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drive-removable-media-usb-pendrive.png"))); // NOI18N
        btn_explorar.setText("Explorar");
        btn_explorar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_explorar.setIconTextGap(0);
        btn_explorar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_explorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_explorarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_explorar);

        portadaClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vivaldi", 0, 18))); // NOI18N
        portadaClientes.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portadaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellido)
                            .addComponent(txt_nombre)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(txt_telefono)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ck_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(79, 79, 79)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ck_cedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(portadaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N
        panelTabla.setLayout(new java.awt.BorderLayout());

        tableCliente.setModel(model);
        tableCliente.getTableHeader().setResizingAllowed(false);
        tableCliente.getTableHeader().setReorderingAllowed(false);
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCliente);

        panelTabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        this.ClearFields();
        this.EnableFields(true);
        this.txt_nombre.requestFocus();
        isNuevo = true;      
        isEditar = false;
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        foto = v.BufferedImage_Byte(v.createImage(this.panelFoto));
        if(isNuevo){
            if(isValidate()){
                //try{
                    C_Cliente.Insert_Update(isNuevo,idCliente, this.txt_nombre.getText(), this.txt_apellido.getText(), this.txt_direccion.getText() ,
                                           v.ReplaceGuion(String.valueOf(this.txt_cedula.getText())), v.ReplaceGuion(String.valueOf(this.txt_telefono.getText())), foto);
                    v.ShowMessage("Ok", v.insert);
                    Reset();
                    LoadTable();
                //}catch(Exception e){    System.out.println(" Ocurrio una Ecxepcion"); v.ShowMessage("Error", v.insert);   }
            }
        }
        if(isEditar){
            if(isValidate()){
//                try{
                    C_Cliente.Insert_Update(isNuevo,idCliente, this.txt_nombre.getText(), this.txt_apellido.getText(), this.txt_direccion.getText() ,
                                           v.ReplaceGuion(String.valueOf(this.txt_cedula.getText())), v.ReplaceGuion(String.valueOf(this.txt_telefono.getText())), foto);
                    v.ShowMessage("Ok", v.update);
                    Reset();
                    LoadTable();
//                }catch(Exception e){    System.out.println(" Ocurrio una Ecxepcion"); v.ShowMessage("Error", v.insert);   }
                
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.EnableFields(false);
        this.Reset();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        this.txt_textoBuscar.setEditable(true);
        this.cb_BuscarPor.setEnabled(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void cb_BuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_BuscarPorItemStateChanged
        this.txt_textoBuscar.setText("");
    }//GEN-LAST:event_cb_BuscarPorItemStateChanged

    private void ck_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_cedulaActionPerformed
        if(ck_cedula.isSelected()){ // si
            this.txt_cedula.setEditable(true);
        }
        if(!ck_cedula.isSelected()){ // no
            this.txt_cedula.setValue("");
            this.txt_cedula.setEditable(false);
        }
    }//GEN-LAST:event_ck_cedulaActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        if(!this.txt_nombre.getText().isEmpty()){
            this.EnableFields(true);
            this.isEditar = true;
            this.isNuevo = false;
        }else{
            v.ShowMessage("¡Elije un cliente a editar..!", v.warning_Message);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void tableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseClicked
        int row = this.tableCliente.getSelectedRow();
        if(row != (-1)){
            if(evt.getClickCount() == 2){
                LoadFields();
            }
        }
    }//GEN-LAST:event_tableClienteMouseClicked

    private void btn_explorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_explorarActionPerformed
        FileDialog dialog = new FileDialog(new JFrame(), "Exportar", FileDialog.LOAD);
        //dialog.setIconImage(new ImageIcon(getClass().getResource("/Icons/Preview_24x24.png")).getImage());
        dialog.show();
        if (dialog.getFile() != null) {
            try {
                File file = new File(dialog.getDirectory() + dialog.getFile());
                v.LoadImagePanel(file, this.panelFoto, this.panelFoto.getWidth(), panelFoto.getHeight());
            } catch (Exception ex) {}
        }
    }//GEN-LAST:event_btn_explorarActionPerformed

    private void btn_camaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_camaraActionPerformed
        labelFoto.setSize(this.panelFoto.getWidth(), this.panelFoto.getHeight());
        new WebCam(new JFrame(), true, this).setVisible(true);
        if (labelFoto != null) {
            if (this.panelFoto.getComponentCount() > 0) {
                //System.out.println("Componentes : " + this.panelFoto.getComponentCount());
            }
            this.panelFoto.removeAll();
            //System.out.println("Componentes : " + this.panelFoto.getComponentCount());
            labelFoto.setSize(this.panelFoto.getWidth(), this.panelFoto.getHeight());
            this.panelFoto.add(labelFoto);
            this.panelFoto.revalidate();
            this.panelFoto.repaint();
            //System.out.println("Componentes : " + this.panelFoto.getComponentCount());
        } else {
            System.err.println("Label null.....................");
        }
    }//GEN-LAST:event_btn_camaraActionPerformed

    private void txt_textoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_textoBuscarKeyReleased
        if(this.cb_BuscarPor.getSelectedIndex()>0){
            matchfind();
        }else v.ShowMessage("¡Elija un método de busqueda..!", v.warning_Message);
    }//GEN-LAST:event_txt_textoBuscarKeyReleased

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        C_Cliente.PrintReport();
    }//GEN-LAST:event_btn_imprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_camara;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_explorar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox cb_BuscarPor;
    private javax.swing.JCheckBox ck_cedula;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel portadaClientes;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JFormattedTextField txt_cedula;
    private javax.swing.JTextArea txt_direccion;
    private javax.swing.JTextField txt_nombre;
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
        this.txt_textoBuscar.setText("");
    }
    
    @Override
    public void EnableFields(boolean option) {
        this.txt_apellido.setEditable(option);
        this.txt_direccion.setEditable(option);
        this.txt_nombre.setEditable(option);
        this.txt_telefono.setEditable(option);
        this.txt_textoBuscar.setEditable(option);
        this.EnableButtoms(!option);
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
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!C_Cliente.findAll().isEmpty()){
                    for(ClienteCompleto cliente : C_Cliente.findAll()){
                        model.addRow(cliente);
                    }
                }else{  v.ShowMessage("¡No existen registros de empleados..!", v.warning_Message);}
            }
        });
        th.start();
    }
    
    @Override
    public void LoadFields(){
        this.ClearFields();
        int row = this.tableCliente.getSelectedRow();
        idCliente = v.Integer((String.valueOf(this.tableCliente.getValueAt(row, 0))));
        foto = (byte []) this.tableCliente.getValueAt(row, 8);
        
        this.txt_cedula.setText(String.valueOf(this.tableCliente.getValueAt(row, 1)));
        this.txt_nombre.setText(String.valueOf(this.tableCliente.getValueAt(row, 2)));
        this.txt_apellido.setText(String.valueOf(this.tableCliente.getValueAt(row, 3)));
        this.txt_telefono.setText(String.valueOf(this.tableCliente.getValueAt(row, 4)));
        this.txt_direccion.setText(String.valueOf(this.tableCliente.getValueAt(row, 5)));
        v.LoadImagePanel(this.panelFoto, v.Byte_BufferedImage(foto));
    }
    
   
    @Override
    public void Reset(){
        model.Clear();
        ClearFields();
        EnableFields(false);
        this.ck_cedula.setSelected(false);
        this.txt_cedula.setEditable(false);
        isNuevo=false;
        isEditar=false;
        idPersona = 0;
        idCliente = 0;
        v.CargarImagen(new File("src\\Images\\nofoto.png"), panelFoto);
    }
    
    @Override
    public boolean isValidate(){
        if(v.isMaxString(txt_nombre.getText(), 50) || !txt_nombre.getText().isEmpty()){
           if(v.isMaxString(txt_apellido.getText(), 50) || !txt_apellido.getText().isEmpty()){
               if(v.isMaxString(txt_direccion.getText(), 200) || !txt_direccion.getText().isEmpty()){
                   if(v.isMinString(v.ReplaceGuion(txt_telefono.getText()), 8)){
                        if(ck_cedula.isSelected()){
                            if(this.ck_cedula.isSelected() && v.isMinString(v.ReplaceGuion(txt_cedula.getText()), 14)){
                                System.out.println("cedula validada: "+v.ReplaceGuion(txt_cedula.getText()));
                                return true;
                            }else{  v.ShowMessage("El numero de cédula no puede contener menos de 14 caracteres..!", v.warning_Message);  }
                        }else{
                            return true;
                        }
                        }else{  v.ShowMessage("El teléfono no puede contener menos de 8 caracteres..!", v.warning_Message);  }
                }else{  v.ShowMessage("La dirección no puede estar vacia o contener mas de 200 caracteres..!", v.warning_Message);  }
            }else{  v.ShowMessage("El apellido no puede estar vacio o contener mas de 50 caracteres..!", v.warning_Message);  }
        }else{  v.ShowMessage("El nombre no puede estar vacio o contener mas de 50 caracteres..!", v.warning_Message);  }
        return true;
    }
    
    
    private void matchfind(){
        model.Clear();
        for(ClienteCompleto cliente : C_Cliente.matchfind(this.cb_BuscarPor.getSelectedIndex(), this.txt_textoBuscar.getText())){
            model.addRow(cliente);
        } 
    }
    private void Close(){
        this.dispose();
    }
    
    private void WindowsClosing(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(new Login(), "¿Cerrar ventana..?", "¿Cerrar?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    isOpen=false;
                    Close();
                }
            }
            
        });
    }
    
}
