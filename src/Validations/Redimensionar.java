package Validations;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*@author Jairo Martinez */
 
public class Redimensionar {
       
    public Image bufferedImageToImage(BufferedImage bufferImage) {
        Image imgReturn = (Image) bufferImage;
        return imgReturn;
    }

    public ImageIcon bufferedImageToImageIcon(BufferedImage bufferImage) {
        ImageIcon imgIconReturn = new ImageIcon(bufferImage);
        return imgIconReturn;
    }

    public Icon bufferedImageToIcon(BufferedImage bufferImage) {
        ImageIcon imgIcon = new ImageIcon(bufferImage);
        Icon iconReturn = (Icon) (imgIcon);
        return iconReturn;
    }

    public BufferedImage iconToBufferedImage(Icon icon) {
        BufferedImage bufferImage = (BufferedImage) this.iconToImage(icon);
        return bufferImage;
    }

    public Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }

    public ImageIcon iconToImageIcon(Icon icon) {
        ImageIcon imageIconRetur = new ImageIcon(this.iconToImage(icon));
        return imageIconRetur;
    }

    public BufferedImage imageToBufferedImage(Image image) {
        BufferedImage bufferReturn = (BufferedImage) image;
        return bufferReturn;
    }

    public ImageIcon imageToImageIcon(Image image) {
        ImageIcon imageIconReturn = new ImageIcon(image);
        return imageIconReturn;
    }

    public Icon imageToIcon(Image image) {
        ImageIcon imgIcon = new ImageIcon(image);
        Icon iconReturn = (Icon) imgIcon;
        return iconReturn;
    }

    public BufferedImage imageIconToBufferedImage(ImageIcon imageIcon) {
        BufferedImage bufferReturn = (BufferedImage) ((Image) imageIcon.getImage());
        return bufferReturn;
    }

    public Image imageIconToImage(ImageIcon imageIcon) {
        Image imgReturn = (Image) imageIcon.getImage();
        return imgReturn;
    }

    public Icon imageIconToIcon(ImageIcon imageIcon) {
        Icon iconReturn = (Icon) imageIcon;
        return iconReturn;
    }
    
}
