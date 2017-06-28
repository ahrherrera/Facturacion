package Validations;

import DAO.AbstractDAO;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*@author Jairo Martinez */

public class Validate {
    
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public  final String si         = "s";
    public  final String no         = "n";
    public  final int nuevo         = 1;
    public  final int guardar       = 2;
    public  final int editar        = 3;
    public  final int deshabilitar  = 4;
    public  final int cancelar      = 5;
    public  final int insert        = 6;
    public  final int update        = 7;
    public  final int ok            = 8;
    public  final int error         = 9;
    public  final int buscarPorId               = 10;
    public  final int buscarPorsCedula          = 11;
    public  final int buscarPorNombre           = 12;
    public  final int buscarPorApellido         = 13;
    public  final int buscarPorCargo            = 14;
    public  final int buscarPorFechaRegistro    = 15;
    public  final int buscarTodo                = 16;
    public final int buscarPorProveedor         = 17;
    public final int buscarPorCategoria         = 18;
    
    
    public  final int info_Message      = 31;
    public  final int warning_Message   = 32;
    public  final int error_Message     = 33;
    
    public int Valor = 20;
    
    
    
    public  String ReplaceSpace(String s){
        return (s.trim().replaceAll(" ", ""));
    }
    
    
    public  String ReplaceGuion(String s){
        return (s.trim().replaceAll("-", ""));
    }
    
    /*      Procedimientos de creacion de imagenes              */
    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);System.out.println("paint, return");
    return bi;
    }
    
    public static byte[] BufferedImage_Byte(BufferedImage bufferedImage) {
        byte[] imageByte = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write( bufferedImage, "jpg", baos);
            baos.flush();
            imageByte = baos.toByteArray();
            baos.close();
        } catch (IOException ex) {
            System.err.println( "______________________________________________________________________________________\n"
                                + "Error : "+ex.getMessage());
        }
    return imageByte;
    }

    public JLabel Byte_BufferedImage(byte[] image) {
        JLabel label=null;
        try{
            
            Image img = resizeIMG(Toolkit.getDefaultToolkit().createImage(image), 160, 160);
            label =  new JLabel(new ImageIcon(img));
            
        }catch(Exception e){  
            System.out.println("Error al cargar la imagen desde la BD\n");
            System.out.println(e.getMessage());
        }
        return label;
    }
    
    public static Image resizeIMG(Image img, int newW, int newH){
        Image imag= null;
        try{
            imag =img.getScaledInstance(newW, newH, Image.SCALE_DEFAULT);
        }catch(NullPointerException nfe){
            JOptionPane.showMessageDialog(null, "Error al redimensionar Imagen");}
    return imag;
    }
    
    public  void CargarImagen(File image, JPanel panelFoto){
        Thread thread = new Thread(new Runnable() {
            @Override   public void run() {
            BufferedImage bi = null;
            try
            {   if(image instanceof File){
                    bi = ImageIO.read(image);
                }   if(bi == null){        
                        return;
                    }
                Image imagen = bi.getScaledInstance(panelFoto.getWidth(), panelFoto.getHeight(), Image.SCALE_SMOOTH);
                JLabel label = new JLabel(new ImageIcon(imagen));
                panelFoto.removeAll();
                panelFoto.add(label);
                panelFoto.revalidate();
                panelFoto.repaint();
            } 
            catch (IOException | ClassCastException ioe){}  }   });
        thread.start();System.out.println("run LoadImage().......");
    }
    
    public  static void LoadImagePanel(File image, JPanel panel, int w, int h){
        Thread thread = new Thread(new Runnable() {// Inicia el hilo
            @Override   public void run() {
                BufferedImage bi = null;
                try
                {   bi = ImageIO.read(image);
                    if(bi == null){     return;     }

                     Image imagen = bi.getScaledInstance(w, h, Image.SCALE_SMOOTH);
                     JLabel label = new JLabel(new ImageIcon(imagen));
                     panel.removeAll();
                     panel.add(label);
                     panel.revalidate();
                     panel.repaint();
                } 
                catch (IOException | ClassCastException ioe){}  
            }   });     thread.start();System.out.println("Load Image...");
    }
    
    public void LoadImagePanel(JPanel panel , JLabel label){
        label.setSize(panel.getWidth(), panel.getHeight());
        panel.removeAll();
        panel.add(label);
        panel.revalidate();
        panel.repaint();
    }
    
    public Image IconReport() {
        Image img = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/text-x-sql.png"));
        return img;
    }
    /*____________________________________________________________________________        */
    
    public void ShowMessage(String message, int accion){
        if(message.equalsIgnoreCase("OK")){
            if(accion == this.insert)    JOptionPane.showMessageDialog(null, "Los datos se guadaron correctamente..!", "Guardado..!", JOptionPane.INFORMATION_MESSAGE);
            if(accion == this.update)     JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente..!", "Actualizado..!",JOptionPane.INFORMATION_MESSAGE);
        }
        if(message.equalsIgnoreCase("Error")){
            if(accion == this.insert)    JOptionPane.showMessageDialog(null, "Los datos no se guadaron correctamente..!", "No Guardado..!",  JOptionPane.ERROR_MESSAGE);
            if(accion == this.update)     JOptionPane.showMessageDialog(null, "Los datos no se actualizaron correctamente..!",  "No Actualizado..!",JOptionPane.ERROR_MESSAGE);
        }
        if(!message.equalsIgnoreCase("OK") || !message.equalsIgnoreCase("Error")){
            if(accion == this.info_Message)      JOptionPane.showMessageDialog(null, message, "Informacion..!", JOptionPane.INFORMATION_MESSAGE);
        }
        if(!message.equalsIgnoreCase("OK") || !message.equalsIgnoreCase("Error")){
            if(accion == this.warning_Message)      JOptionPane.showMessageDialog(null, message, "Aviso..!", JOptionPane.WARNING_MESSAGE);
        }
        if(!message.equalsIgnoreCase("OK") || !message.equalsIgnoreCase("Error")){
            if(accion == this.error_Message)      JOptionPane.showMessageDialog(null, message, "Error..!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public  boolean validateEmail(String email) {
            // Compiles the given regular expression into a pattern.
            Pattern pattern = Pattern.compile(PATTERN_EMAIL);
            // Match the given input against this pattern
            Matcher matcher = pattern.matcher(email);
    return matcher.matches();
    }
    
    public static BigDecimal Round(BigDecimal bd){                     
        BigDecimal b = bd.setScale(2, 2);                       
        BigDecimal bb = b.setScale(2, BigDecimal.ROUND_UP);     
        BigDecimal bbb = bb.setScale(2);                        
        return bbb;
    }
    
    public double BigDecimal_Double(BigDecimal bd){
        return Double.parseDouble(String.valueOf(Round(bd)));
    }
    
    public Float BigDecimal_Float(BigDecimal bd){
        return Float.parseFloat(String.valueOf(Round(bd)));
    }
    
    public BigDecimal String_BigDecimal(String s){
        return Round(new BigDecimal(s));
    }
    
    public BigDecimal Double_BigDecimal(double d){
        BigDecimal bd = new BigDecimal(String.valueOf(d));
    return Round(bd);
    }
    
    public  boolean isFloat(String numero){
        try{
            Float.parseFloat(String.valueOf(numero));
            return true;
        }catch(NumberFormatException nfe){
            //System.out.println(numero+" : No es un número decimal...!");
        }
    Toolkit.getDefaultToolkit().beep();    
    return false;
    }
    
    public boolean Verify_Format(String string){
        if(string.equals("")){
            return true;
        }else{
            if((isFloat(string))){
                    return true;
            }
        }
    return false;
    }
    public   boolean isInteger(String numero){
        try{
            Integer.parseInt(String.valueOf(numero));
            return  true;
        }catch(NumberFormatException nfe){
            //System.out.println(numero+" : No es un número entero...!");
        }
    Toolkit.getDefaultToolkit().beep();        
    return false;
    }
    
    public Float Float(String numero){
        float flotante=0;
        try{
            flotante = Float.parseFloat(numero);
        }catch(NumberFormatException nfe){
            //System.out.println(numero+" : No es un número decimal...!");
        }
    return flotante;
    }
    
    public Double Double(String numero){
        Double dob = 0.0;
        try{
            dob = Double.parseDouble(numero);
        }catch(NumberFormatException nfe){
            //System.out.println(numero+" : No es un número decimal...!");
        }
        return dob;
    }
    public Integer Integer(String numero){
        int entero = 0;
        try{
            entero = Integer.parseInt(numero);
        }catch(NumberFormatException nfe){
            //System.out.println(numero+" : No es un número entero...!");
        }
    return entero;
    }
    /*                      Convercion de String                                */
    public boolean isMaxString(String string, int max){
        if(string.length() <= max){
            return true;
        }
    Toolkit.getDefaultToolkit().beep();  
    return false;
    }
    
    public boolean isMinString(String string, int min){
        if(string.length() >= min){
            return true;
        }
    Toolkit.getDefaultToolkit().beep();  
    return false;
    }
    /*          Validaciones de fecchas                                  */
    
    
    public static String getNuevoDate(String fecha) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd"); // formato que entra
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");  //formato que sale
        String reformattedStr="";
        try {

             reformattedStr= myFormat.format(fromUser.parse(fecha));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reformattedStr;
    }
    
    public static String timestamp_fecha(String fecha) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // formato que entra
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");  //formato que sale
        String reformattedStr="";
        try {

             reformattedStr= myFormat.format(fromUser.parse(fecha));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reformattedStr;
    }
    
    public static int Año(String fecha){
        //01/01/2015
        //123456789*
        String f = fecha.substring(6, 10);
        int año = Integer.parseInt(f);
        return año;
    }
    
    public static int Mes(String fecha){
        //01/01/2015
        //123456789*
        String f = fecha.substring(3, 5);
        int año = Integer.parseInt(f);
        return año;
    }
    
    public static int Dia(String fecha){
        //01/01/2015
        //123456789*
        String f = fecha.substring(0, 2);
        int año = Integer.parseInt(f);
        return año;
    }
    public String SplitDate(String fecha){
        String date = fecha.substring(45);
    return date;
    }
    
    public  static String Date() {// 2015-12-02
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    public  static String DateNormal(String date) {// 2015-12-02
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(date));
    }
    
    public static String getDateFormat(String fechaNormal){   //MM-dd-yyyy
        Date now = new Date(fechaNormal);
        return DateFormat.getDateInstance(DateFormat.SHORT).format(now);
    }
    
    
    public static String fecha_timestamp(String fechaNormal){   //MM-dd-yyyy
        Date now = new Date(fechaNormal);
        return DateFormat.getDateInstance(DateFormat.SHORT).format(now);
    }
    
    public boolean isDate(String fecha){
        if(fecha == null) {
            System.out.println("la fech es nula");
            return false;
        }
        
        Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{2})$");
        Matcher m = p.matcher(fecha);
        if (!m.find()){
            System.out.println("no se encuentra");
            return false;
        }
            
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            if(!fecha.equals(df.format(df.parse(fecha)))){ 
                System.out.println("no es igual a una fecha");
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }
    return true;
    }
    
    public String returnCedula(String cedula){ //recibe cedula sin formato y la retorna formateada
        String nuevo = cedula.substring(0,3)+"-"+cedula.substring(3,9)+"-"+cedula.substring(9,14);
        return nuevo;
    }

    private static JasperPrint print = null;
    private static JasperViewer view = null;
    //
    public void PrintReport(String reportName, String reporTitle) {
        try{
        String path = "src\\Reports\\"+reportName+".jasper";
        try{
            
            print = JasperFillManager.fillReport(path, null, AbstractDAO.conexion());
            view  = new JasperViewer(print, false);
            view.setTitle("Sistema de facturación :: "+reporTitle);
            view.setIconImage(this.IconReport());
            view.setVisible(true);
            AbstractDAO.CloseConnection();
        }catch(JRException je){
            this.ShowMessage("Error al mostrar "+reporTitle, this.error_Message);
            je.printStackTrace();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
