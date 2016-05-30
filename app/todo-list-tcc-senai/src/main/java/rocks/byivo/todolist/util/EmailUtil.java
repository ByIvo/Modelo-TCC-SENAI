/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import rocks.byivo.todolist.model.Configuration;

/**
 *
 * @author byivo
 */
public class EmailUtil {

    private final Configuration config;
    private Session mailSession;

    public static void main(String[] args) {

        Properties mailInfo = new Properties();
        
        InputStream sbInfo = EmailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
        
        try {
            mailInfo.load(sbInfo);
        } catch (IOException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Configuration config = new Configuration();

        config.setServerHost("smtp.gmail.com");
        config.setSocketPort("465");
        config.setSocketFactory("javax.net.ssl.SSLSocketFactory");
        config.setAuth(Boolean.TRUE);
        config.setPort("465");

        config.setFromEmail(mailInfo.getProperty("from_address"));
        config.setFromPassword(mailInfo.getProperty("from_password"));

        EmailUtil mail = new EmailUtil(config);

        mail.sendAnEmail("Teste Subject", "OLHAA ELAAAA", "irbatistela@gmail.com");
    }

    public EmailUtil(Configuration config) {
        this.config = config;
        this.mailSession = createSession();
    }

    private Session createSession() {
        Properties props = new Properties();

        props.put("mail.smtp.host", config.getServerHost());
        props.put("mail.smtp.socketFactory.port", config.getSocketPort());
        props.put("mail.smtp.socketFactory.class", config.getSocketFactory());
        props.put("mail.smtp.auth", config.getAuth());
        props.put("mail.smtp.port", config.getPort());
        props.put("mail.smtp.socketFactory.fallback", "false");
        
        final Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(config.getFromEmail(), config.getFromPassword());
                    }

                });

        session.setDebug(true);

        return session;
    }

    public void sendAnEmail(String subject, String emailMessage, String... toEmails) {
        try {

            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(config.getFromEmail()));

            Address[] toUser = prepareToEmail(toEmails);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(subject);
            message.setText(emailMessage);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private InternetAddress[] prepareToEmail(String... toEmails) {
        InternetAddress[] adresses = new InternetAddress[toEmails.length];

        for (int i = 0; i < toEmails.length; i++) {
            try {
                adresses[i] = new InternetAddress(toEmails[i]);
            } catch (Exception ex) {
                String message = "O endereço de e-mail %s não é válido!";
                System.err.println(String.format(message, toEmails[i]));
            }
        }

        return adresses;
    }
}
