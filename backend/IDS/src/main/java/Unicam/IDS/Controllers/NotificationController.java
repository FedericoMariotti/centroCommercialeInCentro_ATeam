package Unicam.IDS.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

@RestController
public class NotificationController {
    //@Autowired
    //EmailNotification emailNotification;

    // This Method Is Used To Prepare The Email Message And Send It To The Client
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public void sendEmailToClient(HttpServletRequest request) {

        // Reading Email Form Input Parameters
        String emailSubject = request.getParameter("subject");
        String emailMessage = request.getParameter("message");
        String emailToRecipient = request.getParameter("mailTo");
        String emailFromSender = request.getParameter("mailFrom");

        send(emailToRecipient,emailFromSender,emailSubject,emailMessage);




    }

    public void send(String recipient, String sender,String title, String body) {
        Properties properties = System.getProperties();
        String host = "localhost:8080";
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(title);
            message.setText("HAI UNA NUOVA NOTIFICA DALLA PIATTAFORMA CENTROCOMMERCIALEINCENTRO:" + "/n" + body +"/n questo messaggio è stato inviato a:" + recipient);

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
