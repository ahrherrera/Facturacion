package View;

import Controler.*;
import Model.Detallecompra;
import Render.ModelCompras;
import Render.ModelTableCompraProducto;
import java.util.ArrayList;
import Validations.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*@author Allan Ramirez
 */
public class Manejo_Inventario extends javax.swing.JInternalFrame {

    public static ModelTableCompraProducto model_compraProducto;
    public static ModelCompras model_compras;
    Validate v = new Validate();
    C_DetalleCompra detalleCompra = new C_DetalleCompra();
    C_Producto producto = new C_Producto();
    public static int idEmpleado, idRepresentante, idProducto = 0;
    private final int BUSCAR_REPRESENTANTE = 0;

    public Manejo_Inventario() {
        model_compraProducto = new ModelTableCompraProducto(new ArrayList());
        model_compras = new ModelCompras(new ArrayList());
        initComponents();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = new Date();
        txt_Fecha.setText(dateFormat.format(date));
        table.setModel(model_compraProducto);
        model_compraProducto.ColumnSize(table);
        idEmpleado = Principal.getUser().getIdEmpleado();
        txt_nombreEmp.setText(Principal.getUser().getNombre() + " " + Principal.getUser().getApellido());
        agregarListener();
        txt_factura.setDocument(new JTextFieldLimit(20));
    }

    public void agregarListener() {
        txt_nuevoPrecioVenta.getDocument()
                .addDocumentListener(new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        try {
                            BigDecimal PC = v.String_BigDecimal(txt_nuevoPrecioVenta.getText());
                            txt_precioVenta.setText(agregarPorcentaje(PC) + "");

                        } catch (NumberFormatException nfe) {
                            System.out.println("Excepcion de Numeros");
                            txt_precioVenta.setText("0.00");
                        }
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        try {
                            BigDecimal PC = v.String_BigDecimal(txt_nuevoPrecioVenta.getText());
                            txt_precioVenta.setText(agregarPorcentaje(PC) + "");
                        } catch (NumberFormatException nfe) {
                            System.out.println("Excepcion de Numeros");
                            txt_precioVenta.setText("0.00");
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        try {

                            BigDecimal PC = v.String_BigDecimal(txt_nuevoPrecioVenta.getText());

                            txt_precioVenta.setText(agregarPorcentaje(PC) + "");

                        } catch (NumberFormatException nfe) {
                            System.out.println("Excepcion de Numeros --onUpdate");
                        }

                    }
                });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabPrincipal = new javax.swing.JTabbedPane();
        panelCompras = new javax.swing.JPanel();
        panelDatosCompras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombreRep = new javax.swing.JTextField();
        txt_Fecha = new javax.swing.JFormattedTextField();
        txt_NombreProv = new javax.swing.JTextField();
        txt_nombreEmp = new javax.swing.JTextField();
        btn_BuscarRepresentante = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        panelTablaCompras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_quitar = new javax.swing.JButton();
        btn_editarCantidad = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        panelAbastecer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombreProd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_stockActual = new javax.swing.JFormattedTextField();
        txt_PrecioCompra = new javax.swing.JTextField();
        panelRadiobtn = new javax.swing.JPanel();
        rb_promPrecio = new javax.swing.JRadioButton();
        rb_useMay = new javax.swing.JRadioButton();
        rb_useMen = new javax.swing.JRadioButton();
        rb_custom = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_precioVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nuevoPrecioVenta = new javax.swing.JTextField();
        btn_BuscarProducto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_agregar1 = new javax.swing.JButton();
        btn_quitar1 = new javax.swing.JButton();
        btn_editarCantidad1 = new javax.swing.JButton();
        btn_Guardar1 = new javax.swing.JButton();
        btn_Cancelar1 = new javax.swing.JButton();
        PanelTablaInventario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComprasG = new javax.swing.JTable();

        jRadioButton3.setText("jRadioButton3");

        setClosable(true);
        setIconifiable(true);
        setTitle("Manejo de Inventario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_inventario.png"))); // NOI18N

        tabPrincipal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPrincipalStateChanged(evt);
            }
        });

        panelDatosCompras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Representante: ");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha : ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Proveedor: ");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Empleado: ");

        txt_nombreRep.setEditable(false);

        txt_Fecha.setEditable(false);
        txt_Fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("EEEE dd' de 'MMMM' de 'yyyy"))));

        txt_NombreProv.setEditable(false);

        txt_nombreEmp.setEditable(false);

        btn_BuscarRepresentante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resource-group.png"))); // NOI18N
        btn_BuscarRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarRepresentanteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Referencia de Compra : ");

        javax.swing.GroupLayout panelDatosComprasLayout = new javax.swing.GroupLayout(panelDatosCompras);
        panelDatosCompras.setLayout(panelDatosComprasLayout);
        panelDatosComprasLayout.setHorizontalGroup(
            panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_NombreProv, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(txt_nombreRep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BuscarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosComprasLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosComprasLayout.createSequentialGroup()
                        .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        panelDatosComprasLayout.setVerticalGroup(
            panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosComprasLayout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosComprasLayout.createSequentialGroup()
                                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nombreRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(14, 14, 14)
                                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txt_NombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(txt_nombreEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(panelDatosComprasLayout.createSequentialGroup()
                                .addGroup(panelDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addGroup(panelDatosComprasLayout.createSequentialGroup()
                        .addComponent(btn_BuscarRepresentante)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelTablaCompras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridLayout(5, 1, 10, 0));

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_addproduct.png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agregar);

        btn_quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_remove.png"))); // NOI18N
        btn_quitar.setText("Remover");
        btn_quitar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_quitar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_quitar);

        btn_editarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_editproduct.png"))); // NOI18N
        btn_editarCantidad.setText("Editar");
        btn_editarCantidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editarCantidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_editarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarCantidadActionPerformed(evt);
            }
        });
        jPanel2.add(btn_editarCantidad);

        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_save.png"))); // NOI18N
        btn_Guardar.setText("Guardar");
        btn_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Guardar);

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_cancel.png"))); // NOI18N
        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Cancelar);

        javax.swing.GroupLayout panelTablaComprasLayout = new javax.swing.GroupLayout(panelTablaCompras);
        panelTablaCompras.setLayout(panelTablaComprasLayout);
        panelTablaComprasLayout.setHorizontalGroup(
            panelTablaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaComprasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaComprasLayout.setVerticalGroup(
            panelTablaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaComprasLayout.createSequentialGroup()
                .addGroup(panelTablaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelComprasLayout = new javax.swing.GroupLayout(panelCompras);
        panelCompras.setLayout(panelComprasLayout);
        panelComprasLayout.setHorizontalGroup(
            panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatosCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTablaCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelComprasLayout.setVerticalGroup(
            panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprasLayout.createSequentialGroup()
                .addComponent(panelDatosCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablaCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPrincipal.addTab(" Comprar", panelCompras);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Producto :");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Stock :");

        txt_nombreProd.setEditable(false);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Precio de Compra :");

        txt_stockActual.setEditable(false);
        txt_stockActual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyYY"))));

        txt_PrecioCompra.setEditable(false);

        panelRadiobtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelRadiobtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRadiobtnMouseClicked(evt);
            }
        });

        buttonGroup1.add(rb_promPrecio);
        rb_promPrecio.setText("Promediar Precio");
        rb_promPrecio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_promPrecioStateChanged(evt);
            }
        });

        buttonGroup1.add(rb_useMay);
        rb_useMay.setText("Usar mayor precio");
        rb_useMay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_useMayStateChanged(evt);
            }
        });

        buttonGroup1.add(rb_useMen);
        rb_useMen.setText("Usar menor precio");
        rb_useMen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_useMenStateChanged(evt);
            }
        });

        buttonGroup1.add(rb_custom);
        rb_custom.setText("Personalizar");
        rb_custom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_customStateChanged(evt);
            }
        });
        rb_custom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_customActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRadiobtnLayout = new javax.swing.GroupLayout(panelRadiobtn);
        panelRadiobtn.setLayout(panelRadiobtnLayout);
        panelRadiobtnLayout.setHorizontalGroup(
            panelRadiobtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadiobtnLayout.createSequentialGroup()
                .addGroup(panelRadiobtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_useMay)
                    .addComponent(rb_useMen)
                    .addComponent(rb_custom)
                    .addComponent(rb_promPrecio))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        panelRadiobtnLayout.setVerticalGroup(
            panelRadiobtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadiobtnLayout.createSequentialGroup()
                .addComponent(rb_promPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_useMay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_useMen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_custom))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setText("Precio de Venta :");

        txt_precioVenta.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Incluido el margen de ganancia (25%)");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel12.setText("Nuevo Precio: "); // NOI18N

        txt_nuevoPrecioVenta.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txt_nuevoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precioVenta)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_precioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_nuevoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_BuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_producto.png"))); // NOI18N
        btn_BuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarProductoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione las compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        btn_agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_addproduct.png"))); // NOI18N
        btn_agregar1.setText("Agregar");
        btn_agregar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_agregar1.setIconTextGap(5);
        btn_agregar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_agregar1);

        btn_quitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_remove.png"))); // NOI18N
        btn_quitar1.setText("Remover");
        btn_quitar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_quitar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_quitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_quitar1);

        btn_editarCantidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_editproduct.png"))); // NOI18N
        btn_editarCantidad1.setText("Editar");
        btn_editarCantidad1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editarCantidad1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_editarCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarCantidad1ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_editarCantidad1);

        btn_Guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_save.png"))); // NOI18N
        btn_Guardar1.setText("Guardar");
        btn_Guardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Guardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Guardar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Guardar1);

        btn_Cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_cancel.png"))); // NOI18N
        btn_Cancelar1.setText("Cancelar");
        btn_Cancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Cancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Cancelar1);

        PanelTablaInventario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Compras del Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18))); // NOI18N
        PanelTablaInventario.setLayout(new java.awt.BorderLayout());

        tablaComprasG.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaComprasG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaComprasG.getTableHeader().setResizingAllowed(false);
        tablaComprasG.getTableHeader().setReorderingAllowed(false);
        tablaComprasG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaComprasGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaComprasG);

        PanelTablaInventario.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTablaInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTablaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAbastecerLayout = new javax.swing.GroupLayout(panelAbastecer);
        panelAbastecer.setLayout(panelAbastecerLayout);
        panelAbastecerLayout.setHorizontalGroup(
            panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbastecerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAbastecerLayout.createSequentialGroup()
                        .addComponent(txt_stockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_PrecioCompra))
                    .addComponent(txt_nombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelAbastecerLayout.createSequentialGroup()
                .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbastecerLayout.createSequentialGroup()
                        .addGap(0, 500, Short.MAX_VALUE)
                        .addComponent(panelRadiobtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAbastecerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAbastecerLayout.setVerticalGroup(
            panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbastecerLayout.createSequentialGroup()
                .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbastecerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_nombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbastecerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_BuscarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_PrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAbastecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRadiobtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPrincipal.addTab("Abastecer", panelAbastecer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*private void LoadProdCompra(String textoBuscar, int buscarPor){
       //v.Valor = 1;
        model.Clear();
        CompraDAO cdao= new CompraDAO();
        List <Model.Producto> lista =  cdao.findAll();
        if(lista.isEmpty()){    System.err.println("Lista Vacia");}
        for(Model.Producto p  : lista){
            model.addRow(p);
        }
    }*/

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

        if (txt_factura.getText().isEmpty()) { //Paso 2
            JOptionPane.showMessageDialog(this, "No se ha ingresado ninguna referencia de factura"); //paso 3
        } else if (idRepresentante != -1) { // paso 4
            
            C_Compra comp = new C_Compra();
            C_DetalleCompra cdet = new C_DetalleCompra();
            //paso 5
            for (int i = 0; i < table.getRowCount(); i++) {
                //paso 7
                Detallecompra det = cdet.setDetalleCompra((Integer) table.getValueAt(i, 0),
                        (BigDecimal) table.getValueAt(i, 5),
                        (Integer) table.getValueAt(i, 4));

                comp.nuevaCompra(det);
            }
            
            //paso 8
            JOptionPane.showMessageDialog(this, comp.insertarCompra(idEmpleado, idRepresentante, txt_factura.getText()));

            model_compraProducto.Clear();
            limpiaCampos();
            idRepresentante = -1;

        } else { //paso 3
            JOptionPane.showMessageDialog(panelCompras, "Debe seleccionar un Representante");
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed


    private void btn_BuscarRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarRepresentanteActionPerformed
        Thread th = new Thread(() -> {
            new WindowsDrive().WindowDriver(new Int_Popup(BUSCAR_REPRESENTANTE), this.getDesktopPane());
        });
        th.start();
    }//GEN-LAST:event_btn_BuscarRepresentanteActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed

        List<Integer> productos = new ArrayList<>();

        for (int i = 0; i < model_compraProducto.getRowCount(); i++) {
            productos.add((Integer) model_compraProducto.getValueAt(i, 0));
        }

        Int_Popup intp = new Int_Popup(1, productos);

        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(intp, this.getDesktopPane());
        });
        th.start();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
        int row = this.table.getSelectedRow();
        if (table.getSelectedRow() != -1) {
            model_compraProducto.removeRow(row);
        }
    }//GEN-LAST:event_btn_quitarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_editarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarCantidadActionPerformed
        int row = this.table.getSelectedRow();
        if (table.getSelectedRow() != -1) {
            boolean band = true;
            int cant = 0;
            do {
                try {
                    cant = v.Integer(JOptionPane.showInputDialog(null, "Ingrese nueva cantidad"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Ingrese solo Numeros");
                    band = false;
                }

            } while (band != true);

            model_compraProducto.editCantidad(row, cant);

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto primero");
        }
    }//GEN-LAST:event_btn_editarCantidadActionPerformed

    private void tabPrincipalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPrincipalStateChanged
        if (tabPrincipal.getSelectedIndex() == 1) {
            tablaComprasG.setModel(model_compras);

        }
    }//GEN-LAST:event_tabPrincipalStateChanged

    private void tablaComprasGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaComprasGMouseClicked

    }//GEN-LAST:event_tablaComprasGMouseClicked

    private void panelRadiobtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRadiobtnMouseClicked


    }//GEN-LAST:event_panelRadiobtnMouseClicked

    private void rb_promPrecioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_promPrecioStateChanged
        if (rb_promPrecio.isSelected()) {
            txt_nuevoPrecioVenta.setEditable(false);

            txt_nuevoPrecioVenta.setText("" + getPrecioPromedio(getPrecios()));

        }
    }//GEN-LAST:event_rb_promPrecioStateChanged

    private void rb_customStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_customStateChanged
        if (rb_custom.isSelected()) {
            txt_nuevoPrecioVenta.setEditable(true);
        }
    }//GEN-LAST:event_rb_customStateChanged

    private void btn_BuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarProductoActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new Int_Popup(1), this.getDesktopPane());
        });
        th.start();
    }//GEN-LAST:event_btn_BuscarProductoActionPerformed

    private void rb_customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_customActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_customActionPerformed

    private void btn_agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar1ActionPerformed
        Thread th = new Thread(()
                -> {
            new WindowsDrive().WindowDriver(new Int_Popup(4), this.getDesktopPane());
        });
        th.start();
    }//GEN-LAST:event_btn_agregar1ActionPerformed

    private void btn_quitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitar1ActionPerformed
        int row = this.tablaComprasG.getSelectedRow();
        if (tablaComprasG.getSelectedRow() != -1) {
            model_compras.removeRow(row);
        }
    }//GEN-LAST:event_btn_quitar1ActionPerformed

    private void btn_editarCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarCantidad1ActionPerformed
        int row = tablaComprasG.getSelectedRow();
        if (tablaComprasG.getSelectedRow() != -1) {
            boolean band = true;
            int cant = 0;
            do {
                try {
                    cant = v.Integer(JOptionPane.showInputDialog(null, "Ingrese nueva cantidad"));
                    model_compras.editCantidad(row, cant);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Ingrese solo Numeros");
                    band = false;
                }

            } while (band != true);

            model_compras.editCantidad(row, cant);

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto primero");
        }
    }//GEN-LAST:event_btn_editarCantidad1ActionPerformed

    private void btn_Guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Guardar1ActionPerformed
        //paso 2
        if (idProducto != -1) {
            //paso 3
            int acumuladorCantidad = 0;
            System.out.println("idProducto = " + idProducto);
            for (int i = 0; i < tablaComprasG.getRowCount(); i++) {
                //paso 5
                int idCompra = (Integer) model_compras.getValueAt(i, 0);
                Detallecompra det = detalleCompra.buscarCompraYProducto(idCompra, idProducto);
                det.setCantidadLlevar((Integer) model_compras.getValueAt(i, 5));
                
                det.setCantidadDisponible(det.getCantidadDisponible() - det.getCantidadLlevar());
                detalleCompra.update(det);

                acumuladorCantidad += det.getCantidadLlevar();
            }
            System.out.println("detCantLlevarAcumulador = "+ acumuladorCantidad );
            //paso 6
            producto.Actualizar(idProducto, acumuladorCantidad, v.String_BigDecimal(txt_precioVenta.getText()), v.String_BigDecimal(txt_nuevoPrecioVenta.getText()));
            v.ShowMessage("Abastecimiento Existoso!", v.info_Message);
            Clear();

        } else {
            //paso 4
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un producto");
        }

    }//GEN-LAST:event_btn_Guardar1ActionPerformed

    private void btn_Cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_Cancelar1ActionPerformed

    public void Clear() {
        model_compras.Clear();
        idProducto = -1;
        txt_nombreProd.setText("");
        txt_PrecioCompra.setText("");
        txt_stockActual.setText("");
        txt_nuevoPrecioVenta.setText("");
    }

    private void rb_useMayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_useMayStateChanged

        if (rb_useMay.isSelected()) {
            txt_nuevoPrecioVenta.setText("" + getMayorPrecio(getPrecios()));
        }
    }//GEN-LAST:event_rb_useMayStateChanged

    private void rb_useMenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_useMenStateChanged
        if (rb_useMen.isSelected()) {
            txt_nuevoPrecioVenta.setText("" + getMenorPrecio(getPrecios()));
        }
    }//GEN-LAST:event_rb_useMenStateChanged

    private BigDecimal getMenorPrecio(Double[] precios) {
        Double mayor;
        mayor = precios[0];

        for (int f = 0; f < precios.length; f++) {
            if (precios[f] < mayor) {
                mayor = precios[f];
            }
        }
        return v.Double_BigDecimal(mayor);
    }

    private BigDecimal getMayorPrecio(Double[] precios) {
        Double mayor;
        mayor = precios[0];

        for (int f = 0; f < precios.length; f++) {
            if (precios[f] > mayor) {
                mayor = precios[f];
            }
        }
        return v.Double_BigDecimal(mayor);
    }

    private BigDecimal getPrecioPromedio(Double[] precios) {
        Double acumulador = 0.0;

        for (Double precio : precios) {
            acumulador += precio;
        }
        Double Tacumulador = acumulador / precios.length;
        System.out.println("Tacumulador = "+Tacumulador);
        //return new BigDecimal(Tacumulador);
        return v.Round(v.Double_BigDecimal(Tacumulador));

    }

    private Double[] getPrecios() {
        int N = tablaComprasG.getRowCount();
        Double arreglo[] = new Double[N];

        for (int i = 0; i < tablaComprasG.getRowCount(); i++) {
            BigDecimal bd = (BigDecimal) model_compras.getValueAt(i, 3);
            arreglo[i] = bd.doubleValue();
        }

        return arreglo;
    }

    public BigDecimal agregarPorcentaje(BigDecimal monto) {
        return monto.multiply(new BigDecimal(1.25));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablaInventario;
    private javax.swing.JButton btn_BuscarProducto;
    private javax.swing.JButton btn_BuscarRepresentante;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Cancelar1;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Guardar1;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_agregar1;
    private javax.swing.JButton btn_editarCantidad;
    private javax.swing.JButton btn_editarCantidad1;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JButton btn_quitar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelAbastecer;
    private javax.swing.JPanel panelCompras;
    private javax.swing.JPanel panelDatosCompras;
    private javax.swing.JPanel panelRadiobtn;
    private javax.swing.JPanel panelTablaCompras;
    private javax.swing.JRadioButton rb_custom;
    private javax.swing.JRadioButton rb_promPrecio;
    private javax.swing.JRadioButton rb_useMay;
    private javax.swing.JRadioButton rb_useMen;
    public static javax.swing.JTabbedPane tabPrincipal;
    public static javax.swing.JTable tablaComprasG;
    private javax.swing.JTable table;
    private javax.swing.JFormattedTextField txt_Fecha;
    public static javax.swing.JTextField txt_NombreProv;
    public static javax.swing.JTextField txt_PrecioCompra;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JTextField txt_nombreEmp;
    public static javax.swing.JTextField txt_nombreProd;
    public static javax.swing.JTextField txt_nombreRep;
    private javax.swing.JTextField txt_nuevoPrecioVenta;
    private javax.swing.JTextField txt_precioVenta;
    public static javax.swing.JFormattedTextField txt_stockActual;
    // End of variables declaration//GEN-END:variables

    private void limpiaCampos() {
        txt_NombreProv.setText("");
        txt_nombreRep.setText("");
        idRepresentante = 0;
    }
}
