/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validations;

import View.Principal;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahrhe
 */
public class Mensajero {
    
    public Mensajero(){
        
    }

    public static void enviarMensaje(String mensaje, List<String> destinatarios){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //FIN recolecion de propiedades
        try {
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(
                  "sistemaspointsa@gmail.com", "Sistemas.93");
            }
            });

        

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sistemaspointsa@gmail.com"));
            
            
            
            for(String destinatario : destinatarios){
                message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            }
            
            message.setSubject("Notificación de Sistemas Point");
            message.setText(mensaje);

            Transport.send(message);

            System.out.println("Done");
            Principal.mensaje.mostrarNotificacion("Notificacion enviada", "", "INFO");

        } catch (MessagingException e) {
            Principal.mensaje.mostrarNotificacion("Error al enviar email", "Favor, revise su conexión a Internet", "ERROR");
            throw new RuntimeException(e);
        }
        }
    

}
