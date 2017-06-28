/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validations;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

/**
 * Common GUI utilities accessed via static methods.
 * 
 * @author <A HREF="mailto:colbell@users.sourceforge.net">Colin Bell</A>
 */
public class GUIUtils {

  public static void moveToFront(final JInternalFrame fr) {
    if (fr != null) {
      processOnSwingEventThread(new Runnable() {
        public void run() {
          fr.moveToFront();
          fr.setVisible(true);
          try {
            fr.setSelected(true);
            if (fr.isIcon()) {
              fr.setIcon(false);
            }
            fr.setSelected(true);
          } catch (PropertyVetoException ex) {

          }
          fr.requestFocus();
        }
      });
    }

}
  public static void processOnSwingEventThread(Runnable todo) {
    processOnSwingEventThread(todo, false);
  }

  public static void processOnSwingEventThread(Runnable todo, boolean wait) {
    if (todo == null) {
      throw new IllegalArgumentException("Runnable == null");
    }

    if (wait) {
      if (SwingUtilities.isEventDispatchThread()) {
        todo.run();
      } else {
        try {
          SwingUtilities.invokeAndWait(todo);
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      }
    } else {
      if (SwingUtilities.isEventDispatchThread()) {
        todo.run();
      } else {
        SwingUtilities.invokeLater(todo);
      }
    }
  }
}