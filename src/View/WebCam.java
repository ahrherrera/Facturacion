package View;

import Model.Cliente;
import Validations.Redimensionar;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* @author Jairo Martinez */
public class WebCam extends javax.swing.JDialog {
   
    public int NumeroCamara = 0;
    public opencv_core.IplImage img;
    public FrameGrabber frameGraber;
    boolean Flag = true;
    boolean ini = false;
    BufferedImage bi; 
    ImageIcon imageIcon;
    static V_Cliente cliente = new V_Cliente();
    
    public WebCam(java.awt.Frame parent, boolean modal, Object obj) {
        super(parent, modal);
        initComponents();
        if (obj instanceof V_Cliente) {
            this.cliente = (V_Cliente) obj;
        }
        this.setLocationRelativeTo(null);
        this.Capturar.setEnabled(false);
        this.Guardar.setEnabled(false);
        this.setResizable(false);
        LoadCamera();
        windowClosing();
    }
    

    private void windowClosing(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int selection = JOptionPane.showConfirmDialog(null, "Salir del modo Camara...?", "Cerrar...?",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
                if(selection == JOptionPane.YES_OPTION){
                    if(ini){
                        CloseCamera();
                    }
                    dispose();
                }
            }
        });
    }
    
    private void LoadCamera(){
        Drivers.removeAllItems();
        String[] Divices = null;
        
        try {
            Divices = VideoInputFrameGrabber.getDeviceDescriptions();
        } catch (FrameGrabber.Exception ex) {
            JOptionPane.showMessageDialog(this, "No se encontro Camara Conectada...!", "Aviso...!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(String drivers : Divices){
            Drivers.addItem(drivers);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        Drivers = new javax.swing.JComboBox();
        Iniciar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Capturar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        panelShadow2 = new org.edisoncor.gui.panel.PanelShadow();
        lblFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next_16x16.png"))); // NOI18N
        Iniciar.setText("Iniciar Camara");
        Iniciar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Iniciar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Iniciar.setIconTextGap(10);
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 18))); // NOI18N
        jPanel1.setOpaque(false);

        Capturar.setText("Capturar");
        Capturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapturarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Capturar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Capturar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        panelShadow2.setLayout(new java.awt.BorderLayout());

        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelShadow2.add(lblFoto, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(Drivers, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(Iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Drivers))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelShadow1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapturarActionPerformed
        this.CloseCamera();
        this.Iniciar.setEnabled(true);
        this.Iniciar.setText("Tomar otra vez");
    }//GEN-LAST:event_CapturarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(this.cliente!=null){
            this.SavePhoto();
        }
        
    }//GEN-LAST:event_GuardarActionPerformed

    public void SavePhoto() {
        try {
            Icon icono = lblFoto.getIcon();
            Redimensionar redimImagen = new Redimensionar();

            if (this.cliente != null) {
                icono = redimImagen.imageToIcon(redimImagen.iconToBufferedImage(icono).getScaledInstance(cliente.labelFoto.getWidth(), cliente.labelFoto.getHeight(), 0));       
                cliente.labelFoto.setIcon(icono);
                cliente.labelFoto.setText(null);
                cliente.isSave = true;
            }
            
            this.CloseCamera();
            this.dispose();
        } catch (Exception e) {
            System.err.println("Error : "+e.getMessage());
            JOptionPane.showMessageDialog(this, "Hà ocurrido un error al guardar la foto..!", "Error..!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        ini=true;
        Flag = true;
        NumeroCamara = Drivers.getSelectedIndex();
        InitCamara();
        Iniciar.setEnabled(false);
        this.setTitle(""+Drivers.getSelectedItem().toString());    
        this.lblFoto.setVisible(true);  
        this.Capturar.setEnabled(true);
        this.Guardar.setEnabled(true);
    }//GEN-LAST:event_IniciarActionPerformed

    private void InitCamara(){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                Graber();
            }
        });
        hilo.start();
    }
    
    
    public void Graber() {
        try 
        {   frameGraber = new OpenCVFrameGrabber(NumeroCamara);
            frameGraber.start();
            while(Flag) 
            {
                img = frameGraber.grab();
                if (img != null) { 
                    cvFlip(img, img, 1);
                }
                imageIcon = new ImageIcon(img.getBufferedImage());
                ImageIcon ic = new ImageIcon(Resize(img.getBufferedImage(), 330, 280));
                lblFoto.setIcon(ic);
            }
        } catch (FrameGrabber.Exception ex) {
            System.out.println(""+ex.getCause());
        }
    }
    
    public static BufferedImage Resize(BufferedImage bufferedImage, int newW, int newH) {
        try {
          int w = bufferedImage.getWidth();
          int h = bufferedImage.getHeight();
          
          BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
          Graphics2D g = bufim.createGraphics();
          g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
          g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
          g.dispose();
          
          return bufim;
        } catch (NullPointerException n) {  return null; }
    }

    public void CloseCamera(){
      try {
       Flag = false;
       frameGraber.release();
        } catch (FrameGrabber.Exception e) {}
      }
      
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                WebCam dialog = new WebCam(new javax.swing.JFrame(), true, cliente);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Capturar;
    private javax.swing.JComboBox Drivers;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Iniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow2;
    // End of variables declaration//GEN-END:variables
}
