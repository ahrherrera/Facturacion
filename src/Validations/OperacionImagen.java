package Validations;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/* @author AllanHavid */
public class OperacionImagen {

    public static Image redimensionarImagen(String url, int width, int height) {
        BufferedImage bimage = loadImage(url);

        bimage = resize(bimage, width, height);

    return bimage;
    }

    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
    
    public static Image resizeIMG(Image img, int newW, int newH){
        Image imag= null;
        try{
            imag =img.getScaledInstance(newW, newH, Image.SCALE_DEFAULT);
        }catch(NullPointerException nfe){
            JOptionPane.showMessageDialog(null, "Error al redimensionar Imagen");}
    return imag;
    }

    public static BufferedImage loadImage(String pathName) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(new File(pathName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }

//    public static JLabel bytesToIMG(int idCliente) {
//            JLabel lab = new JLabel(new ImageIcon(D_ClienteNatural.getImageBytes(idCliente)));
//            return lab;
//    }

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

    public static JLabel URLaImg(String path) {
        JLabel picLabel = null;
        try {
            BufferedImage myPicture = resize(ImageIO.read(new File(path)), 200, 200);
            picLabel = new JLabel(new ImageIcon(myPicture));

        } catch (IOException ex) {
            Logger.getLogger(OperacionImagen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return picLabel;
    }

}
