package View;

import Controler.*;
import Model.*;
import Render.*;
import Validations.*;
import static View.Principal.DesktopPane;
import static View.V_Factura.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*@author Allan
 */
public class Int_Popup extends javax.swing.JInternalFrame {

    List<Integer> idProductos = new ArrayList<>();
    String tipoTabla;
    Validate v = new Validate();
    //Inicializacion de Modelos de Tablas;
    ModelRepresentantes model_representante;
    ModelProductoCompra model_productoCompra;
    ModelProductoFactura model_productoFactura;
    ModelClienteFactura model_clienteFactura;
    ModelCompras model_compras;

    int idCompra = 0;
    int OPC = 0;

    public Int_Popup(int opc) {
        initComponents();
        LoadOPC(opc);
        btn_Seleccionar.setEnabled(false);
        OPC = opc;

    }

    public Int_Popup(int opc, List<Integer> productos) {
        initComponents();
        this.idProductos = productos;
        LoadOPC(opc);
        btn_Seleccionar.setEnabled(false);
        OPC = opc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btn_Seleccionar = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        opcion_busqueda = new javax.swing.JComboBox<>();
        lbl_redirect = new LinkLabel("Prueba");

        setTitle("Menú de búsqueda...");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_popup.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menú de selección...", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Monotype Corsiva", 2, 16), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione un....");

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dialog-cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setToolTipText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_Seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fac_ok.png"))); // NOI18N
        btn_Seleccionar.setText("Seleccionar");
        btn_Seleccionar.setToolTipText("Seleccionar");
        btn_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeleccionarActionPerformed(evt);
            }
        });

        txt_busqueda.setToolTipText("Ingrese el texto a buscar");
        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Búsqueda por");

        opcion_busqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                opcion_busquedaItemStateChanged(evt);
            }
        });

        lbl_redirect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_redirect.setText("¿No Encontró lo que buscaba? Agréguelo");
        lbl_redirect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_redirectMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opcion_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbl_redirect, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Seleccionar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcion_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Seleccionar)
                    .addComponent(jButton2)
                    .addComponent(lbl_redirect))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Todos", jPanel1);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private final String TABLA_REPRESENTANTE = "Representante";
    private final String TABLA_CLIENTE = "Cliente";
    private final String TABLA_PRODUCTO = "Producto";
    private final String TABLA_COMPRAS = "Compras";

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {
            switch (tipoTabla) {
                case TABLA_REPRESENTANTE: {
                    int idRepresentante = (Integer) model_representante.getValueAt(table.getSelectedRow(), 0);
                    Manejo_Inventario.idRepresentante = idRepresentante;
                    btn_Seleccionar.setEnabled(true);
                }
                break;

                case TABLA_PRODUCTO: {
                    int idProducto = (Integer) model_productoCompra.getValueAt(table.getSelectedRow(), 0);
                    Manejo_Inventario.idProducto = idProducto;
                    btn_Seleccionar.setEnabled(true);
                }
                break;

                case "Producto1": {
                    int idProducto = (Integer) model_productoFactura.getValueAt(table.getSelectedRow(), 0);
                    btn_Seleccionar.setEnabled(true);
                }
                break;

                case TABLA_CLIENTE: {
                    int idCliente = (Integer) model_clienteFactura.getValueAt(table.getSelectedRow(), 0);
                    V_Factura.idCliente = idCliente;
                    btn_Seleccionar.setEnabled(true);
                }
                break;

                case TABLA_COMPRAS: {
                    idCompra = (Integer) model_compras.getValueAt(table.getSelectedRow(), 0);
                    btn_Seleccionar.setEnabled(true);
                }

            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btn_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeleccionarActionPerformed
        // Si la busqueda es de representante
        if (tipoTabla == "Representante") {
            String nombre, apellido, nombreProveedor;
            nombre = (String) table.getModel().getValueAt(table.getSelectedRow(), 1);
            apellido = (String) table.getModel().getValueAt(table.getSelectedRow(), 2);
            nombreProveedor = (String) table.getModel().getValueAt(table.getSelectedRow(), 5);
            Manejo_Inventario.txt_nombreRep.setText(nombre + " " + apellido);
            Manejo_Inventario.txt_NombreProv.setText(nombreProveedor);
        } else // Si la busqueda es de prodictos
        {
            if (tipoTabla == "Producto") {
                //Mandar a pedir con JOptionPane el precio de Compra y la cantidad
                C_Producto c = new C_Producto();
                int idProducto = 0;

                if (Manejo_Inventario.tabPrincipal.getSelectedIndex() == 1) {

                    Producto producto = c.find((Integer) table.getModel().getValueAt(table.getSelectedRow(), 0));
                    Manejo_Inventario.txt_stockActual.setText("" + producto.getStock());
                    idProducto = producto.getIdProducto();
                    if (producto.getPrecioCompra() != null) {
                        Manejo_Inventario.txt_PrecioCompra.setText("" + producto.getPrecioCompra());
                    } else {
                        Manejo_Inventario.txt_PrecioCompra.setText("SIN PRECIO");
                    }

                    if (producto.getStock() != null) {
                        Manejo_Inventario.txt_stockActual.setText("" + producto.getStock());
                    } else {
                        Manejo_Inventario.txt_stockActual.setText("No hay Stock");
                    }
                    C_DetalleCompra cdc = new C_DetalleCompra();
                    Manejo_Inventario.txt_nombreProd.setText(producto.getNombreProducto());
                    /*
                Manejo_Inventario.tablaComprasG.setModel(Manejo_Inventario.mc);
                
                
                
                for(Detallecompra dc : cdc.findByProducto(idProducto)){
                    System.out.println("IDCOMPRA RECIBIDO =" +dc.getCompra().getIdCompra());
                    Manejo_Inventario.mc.addRow(dc);
                }
                     */

                } else {

                    Model.Producto prods = c.find((Integer) table.getModel().getValueAt(table.getSelectedRow(), 0));
                    int cant = 0;
                    boolean band = true;
                    do {
                        try {
                            cant = v.Integer(JOptionPane.showInputDialog(null, "Ingrese la cantidad"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(this, "Ingrese solo Numeros");
                            band = false;
                        }

                    } while (band != true);
                    BigDecimal bd = new BigDecimal(0);
                    do {
                        try {
                            bd = v.String_BigDecimal(JOptionPane.showInputDialog(null, "Ingrese el costo"));
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(this, "Ingrese solo Numeros");
                            band = false;
                        }
                    } while (band != true);

                    prods.setPrecioCompra(BigDecimal.ZERO);
                    Detallecompra detCompra = new Detallecompra();

                    detCompra.setCantidad(cant);
                    detCompra.setCosto(bd);

                    DetallecompraId did = new DetallecompraId();
                    did.setIdProducto(prods.getIdProducto());
                    detCompra.setProducto(prods);

                    detCompra.setId(did);

                    Manejo_Inventario.model_compraProducto.addRow(detCompra);
                }
            } else if ("Producto1".equals(tipoTabla)) {

                C_Producto c = new C_Producto();

                Model.Producto prods = c.find((Integer) model_productoFactura.getValueAt(table.getSelectedRow(), 0));
                int cant = 0;
                boolean band = true;
                do {
                    try {
                        cant = v.Integer(JOptionPane.showInputDialog(null, "Ingrese la cantidad"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Ingrese solo Numeros");
                        band = false;
                    }

                } while (band != true);

                V_Factura.model.addRow(prods.getIdProducto(), cant, prods.getPrecioVenta());

                BigDecimal subtotal = BigDecimal.ZERO;
                BigDecimal impuesto;
                BigDecimal total = new BigDecimal(0);
                BigDecimal monto = BigDecimal.ZERO;

                for (int i = 0; i < model.getRowCount(); i++) {
                    monto = (BigDecimal) model.getValueAt(i, 5);
                    subtotal = (subtotal.add(monto));
                }

                impuesto = subtotal.multiply(new BigDecimal(0.15));
                System.out.println("Table listener");

                total = subtotal.add(impuesto);

                V_Factura.lbl_Subtotal.setText("" + subtotal.setScale(2, RoundingMode.DOWN));
                V_Factura.lbl_IVA.setText("" + impuesto.setScale(2, RoundingMode.DOWN));
                V_Factura.lbl_Total.setText("" + total.setScale(2, RoundingMode.DOWN));

            } else if (tipoTabla == "Cliente") {

                V_Factura.txt_nombreCliente.setText((String) model_clienteFactura.getValueAt(table.getSelectedRow(), 1));
                V_Factura.txt_NumeroCedula.setText((String) model_clienteFactura.getValueAt(table.getSelectedRow(), 4));
                V_Factura.txt_Telefono.setText(model_clienteFactura.getValueAt(table.getSelectedRow(), 3) + "");

            } else if (tipoTabla == "Compras") {
                //Enviar la compra seleccionada al modelo de tabla

                C_DetalleCompra cc = new C_DetalleCompra();

                Manejo_Inventario.model_compras.addRow(cc.buscarCompraYProducto(idCompra, Manejo_Inventario.idProducto));

            }
        }

        this.dispose();
    }//GEN-LAST:event_btn_SeleccionarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_busquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyPressed

        if (txt_busqueda.getText().isEmpty()) {
            LoadOPC(OPC);
        } else if (evt.getKeyCode() == 10) {

            switch (tipoTabla) {
                case "Representante": {

                    if (opcion_busqueda.getSelectedIndex() == 0) {
                        C_Representante crep = new C_Representante();
                        model_representante.Clear();
                        model_representante = new ModelRepresentantes(crep.findByName(txt_busqueda.getText()));
                        table.setModel(model_representante);
                    }
                    if (opcion_busqueda.getSelectedIndex() == 1) {
                        C_Representante crep = new C_Representante();
                        model_representante.Clear();
                        model_representante = new ModelRepresentantes(crep.findByProveedor(txt_busqueda.getText()));
                        table.setModel(model_representante);
                    }

                    model_representante.ColumnSize(table);

                }
                break;

                case "Producto": {
                    C_Producto cprod = new C_Producto();
                    model_productoCompra.Clear();
                    model_productoCompra = new ModelProductoCompra(cprod.getProductosPorNombre(txt_busqueda.getText()));
                    table.setModel(model_productoCompra);
                    model_productoCompra.ColumnSize(table);

                }
                break;

                case "Producto1": {
                    C_Producto cprod = new C_Producto();
                    model_productoFactura.Clear();
                    model_productoFactura = new ModelProductoFactura(cprod.getProductosPorNombre(txt_busqueda.getText()));
                    table.setModel(model_productoFactura);
                    model_productoFactura.ColumnSize(table);
                }
                break;

                case "Cliente": {
                    C_Cliente cc = new C_Cliente();
                    model_clienteFactura.Clear();
                    model_clienteFactura = new ModelClienteFactura(cc.findByName(txt_busqueda.getText()));
                    table.setModel(model_clienteFactura);
                    model_clienteFactura.ColumnSize(table);

                }
                break;

                case "Compra": {
                    C_DetalleCompra cc = new C_DetalleCompra();

                    Manejo_Inventario.model_compras.addRow(cc.buscarCompraYProducto(idCompra, Manejo_Inventario.idProducto));

                }
                break;
            }
        }

    }//GEN-LAST:event_txt_busquedaKeyPressed

    private void opcion_busquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_opcion_busquedaItemStateChanged
        if (!txt_busqueda.getText().isEmpty()) {
            //Buscar por el que se ha cambiado

            int index = opcion_busqueda.getSelectedIndex();

        }
    }//GEN-LAST:event_opcion_busquedaItemStateChanged

    private void lbl_redirectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_redirectMouseClicked

        switch (tipoTabla) {
            case "Representante": {

                V_Proveedor vprov = new V_Proveedor();
                Thread th = new Thread(()
                        -> {
                    new WindowsDrive().WindowDriver(vprov, DesktopPane);
                });
                th.start();

                GUIUtils.moveToFront(vprov);
            }
            break;

            case "Producto": {
                Thread th = new Thread(()
                        -> {
                    new WindowsDrive().WindowDriver(new V_Producto(), DesktopPane);
                });
                th.start();
            }
            break;

            case "Producto1": {
                Thread th = new Thread(()
                        -> {
                    new WindowsDrive().WindowDriver(new V_Producto(), DesktopPane);
                });
                th.start();
            }
            break;

            case "Cliente": {
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
            }
            break;
        }


    }//GEN-LAST:event_lbl_redirectMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Seleccionar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_redirect;
    private javax.swing.JComboBox<String> opcion_busqueda;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables

    private final int BUSCAR_REPRESENTANTE = 0;
    private final int BUSCAR_PRODUCTO = 1;
    private final int BUSCAR_CLIENTE = 3;
    private final int BUSCAR_DETALLE_COMPRA = 4;

    private void LoadOPC(int opc) {

        switch (opc) {
            case BUSCAR_REPRESENTANTE: { // Busqueda de representante 
                C_Representante rep = new C_Representante();
                model_representante = new ModelRepresentantes(rep.findAll());
                jLabel1.setText("Seleccione un Representante...");
                tipoTabla = "Representante";
                table.setModel(model_representante);
                model_representante.ColumnSize(table);
                if (opcion_busqueda.getItemCount() == 0) {
                    opcion_busqueda.setModel(new JComboBox(Modelos_Combobox.getBusquedaRepresentantes()).getModel());
                }

            }
            break;
            case BUSCAR_PRODUCTO: {   // Busqueda de productos
                C_Producto prod = new C_Producto();
                model_productoCompra = new ModelProductoCompra(prod.findAll());
                jLabel1.setText("Seleccione un Producto...");
                tipoTabla = "Producto";
                try {
                    for (int i = 0; i < idProductos.size(); i++) {
                        model_productoCompra.removeRow(idProductos.get(i));
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                table.setModel(model_productoCompra);
                model_productoCompra.ColumnSize(table);

                if (opcion_busqueda.getItemCount() == 0) {
                    opcion_busqueda.setModel(new JComboBox(Modelos_Combobox.getBusquedaProducto()).getModel());
                }
            }
            break;
            case 2: {    // Busqueda de producto
                C_Producto prod = new C_Producto();
                model_productoFactura = new ModelProductoFactura(prod.findAll());
                jLabel1.setText("Seleccione un Producto...");
                tipoTabla = "Producto1";
                for (int i = 0; i < idProductos.size(); i++) {
                    model_productoCompra.removeRow(idProductos.get(i));
                    System.out.println("Int_PopUp For " + idProductos.get(i));
                }
                table.setModel(model_productoFactura);
                model_productoFactura.ColumnSize(table);
                if (opcion_busqueda.getItemCount() == 0) {
                    opcion_busqueda.setModel(new JComboBox(Modelos_Combobox.getBusquedaProducto()).getModel());
                }
            }
            break;

            case BUSCAR_CLIENTE: { //     Busqueda de clientes
                C_Cliente cliente = new C_Cliente();
                model_clienteFactura = new ModelClienteFactura(cliente.findTodos());
                jLabel1.setText("Seleccione un Cliente...");
                tipoTabla = "Cliente";
                table.setModel(model_clienteFactura);
                model_clienteFactura.ColumnSize(table);
                if (opcion_busqueda.getItemCount() == 0) {
                    opcion_busqueda.setModel(new JComboBox(Modelos_Combobox.getBusquedaCliente()).getModel());
                }
            }
            break;

            case BUSCAR_DETALLE_COMPRA: { //     Busqueda de Detalles de compra
                C_DetalleCompra cc = new C_DetalleCompra();
                System.out.println("Id PRODUCTO = " + Manejo_Inventario.idProducto);
                model_compras = new ModelCompras(cc.findByProducto(Manejo_Inventario.idProducto));
                jLabel1.setText("Seleccione una Compra");
                tipoTabla = "Compras";

                table.setModel(model_compras);
                model_compras.ColumnSize(table);
                opcion_busqueda.setEnabled(true);
            }

            //Se puede agregar mas para multi-usos
            //Se puede agregar mas para multi-usos
        }
    }
}
