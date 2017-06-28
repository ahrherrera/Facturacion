/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validations;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

/**
 *
 * @author ahrhe
 */
public class TaskbarNotification {
    
    static Image image = Toolkit.getDefaultToolkit().getImage("Images\\errorAcces.png");

    static TrayIcon trayIcon = new TrayIcon(image, "Notificador");

    public TaskbarNotification() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            trayIcon.setImageAutoSize(true);
            try {
                tray.add(trayIcon);
                
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }
        }
    }
    
    public void mostrarNotificacion(String titulo, String detalle, String tipo){
        switch(tipo){
            case "INFO":{
                trayIcon.displayMessage(titulo, detalle, TrayIcon.MessageType.INFO);
            }break;
            case "ADVERT":{
                trayIcon.displayMessage(titulo, detalle, TrayIcon.MessageType.WARNING);
            }break;
            case "ERROR":{
                trayIcon.displayMessage(titulo, detalle, TrayIcon.MessageType.ERROR);
            }break;
        }
    }
    
}
