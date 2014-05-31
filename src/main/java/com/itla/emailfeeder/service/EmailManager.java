package com.itla.emailfeeder.service;

import com.itla.emailfeeder.domain.*;
import com.itla.emailfeeder.repository.JPASuscriberDAO;
import com.itla.emailfeeder.repository.SuscriberDAO;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Pimp on 19/05/2014.
 */
public class EmailManager {

    private static SuscriberDAO suscriberDao = new JPASuscriberDAO();

    public static void sendHelloEmail(com.itla.emailfeeder.domain.Suscriber suscriber) {
        Properties props = new Properties();

        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");

        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");

        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");

        // Nombre del usuario
        props.setProperty("mail.smtp.user", "itla.emailapp@gmail.com");

        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        try {
            // Quien envia el correo
            message.setFrom(new InternetAddress("itla.emailapp@gmail.com"));

            // A quien va dirigido
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress("pimp@kekomundo.com"));
                message.addRecipient(Message.RecipientType.BCC, new InternetAddress(suscriber.getEmail()));

            message.setSubject("Nuevo contenido en el blog!");
            message.setText(
                    "<b>" + suscriber.getName() + "</b>, Vemos que te has suscrito al blog! <br>" +
                            "El registro fue hecho " + suscriber.getSuscribedDate() +
                            "<br>Haz click en el siguiente enlace para dejar de recibir notifaciones de este tipo " +
                            "<a href=\"http://google.com/#q=" + suscriber.getId() + "\"><b>Unsuscribe</b></a>" +
                            "<br><i><b><u>Hecho por Enmanuel Reyes</u></b></i> ;)",
                    "ISO-8859-1",
                    "html");

            javax.mail.Transport t = session.getTransport("smtp");
            t.connect("itla.emailapp@gmail.com", "emailapp03");

            t.sendMessage(message, message.getAllRecipients());

            t.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void sendEmails(Post post) {
        if (!suscriberDao.findAll().isEmpty()) {

            Properties props = new Properties();

            // Nombre del host de correo, es smtp.gmail.com
            props.setProperty("mail.smtp.host", "smtp.gmail.com");

            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", "true");

            // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.port", "587");

            // Nombre del usuario
            props.setProperty("mail.smtp.user", "itla.emailapp@gmail.com");

            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            MimeMessage message = new MimeMessage(session);
            try {
                // Quien envia el correo
                message.setFrom(new InternetAddress("itla.emailapp@gmail.com"));

                // A quien va dirigido
                for (com.itla.emailfeeder.domain.Suscriber suscriber1 : suscriberDao.findAll()) {
                    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(suscriber1.getEmail()));
                }
                message.setSubject("Nuevo contenido en el blog!");
                message.setText(
                        "<a href=\"http://google.com/#q=loquesea\"><b>" + post.getSubject() + "</b></a> <-- De eso se trata" +
                                " el nuevo articulo del blog!<br>"
                                + "Haz click en la oracion que se encuentra en negrita para ver de que se trata!." +
                                "<br><i><b><u>Hecho por Enmanuel Reyes</u></b></i> ;)",
                        "ISO-8859-1",
                        "html"
                );

                javax.mail.Transport t = session.getTransport("smtp");
                t.connect("itla.emailapp@gmail.com", "emailapp03");

                t.sendMessage(message, message.getAllRecipients());

                t.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
