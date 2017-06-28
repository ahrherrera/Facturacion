package Validations;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WindowsDrive {
    
      public void WindowDriver(JInternalFrame internal, JDesktopPane DesktopPane){
        boolean mostrar = true;
        String Nombre=internal.getTitle();
        for (int i=0; i<DesktopPane.getComponentCount(); i++)
        {
            if( internal.getClass().isInstance( DesktopPane.getComponent(i) ))
            {
                JOptionPane.showMessageDialog(null, "La ventana "+Nombre+" ya há sido abierta...!");
                internal.toFront();
                DesktopPane.moveToFront(internal);
                mostrar=false;
            }
        }
        if(mostrar){
            internal.setLocation(Center(internal,DesktopPane));
            DesktopPane.add(internal);
        }
        internal.show();
    }
    
    private Point Center(JInternalFrame internal, JDesktopPane DesktopPane)
    {
        Point p = new Point(0,0);
        //se obtiene dimension del contenedor
        Dimension pantalla = DesktopPane.getSize();
        //se obtiene dimension del JInternalFrame
        Dimension ventana = internal.getSize();
        //se calcula posiciÃ³n para el centrado
        p.x = (pantalla.width - ventana.width) / 2;
        p.y = (pantalla.height - ventana.height) / 2;
    return p;
    }
    
    public static Component My_BackGround(String name){
        return new BackGround(name);
    }
    
    public static class BackGround extends JPanel{
        String name;
        
        public BackGround(String name) {
            this.name= (name);
            this.setOpaque(false);
        }
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("src\\Icons\\"+name)).getImage());
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
        
        
        
    }
    
}
