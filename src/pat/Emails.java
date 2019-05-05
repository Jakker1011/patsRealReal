/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

/**
 *
 * @author Jacob Sacks
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Emails { // main method 

    public Emails(String toAddress, String Text, String subject) {//This is a Parametised constructor. It assigns the values of the parameters to an objects fields. This Method is used to send an email to the entered email address
        final String username = "DR.AbramowitzInvoice@gmail.com"; // username for the sending email address 
        final String password = "ITproject"; // password for the sending email address

        Properties props = new Properties();//creates a new propties class
        props.put("mail.smtp.auth", "true");//adds to the mail setup 
        props.put("mail.smtp.starttls.enable", "true");//adds to the mail setup 
        props.put("mail.smtp.host", "smtp.gmail.com");//adds to the mail setup 
        props.put("mail.smtp.port", "587");//adds to the mail setup 

        Session session = Session.getInstance(props,//creats a new session instance
                new javax.mail.Authenticator() {//creates a new email using the java code for mails
            protected PasswordAuthentication getPasswordAuthentication() {//authenticates the password
                return new PasswordAuthentication(username, password);//if itis correct it returndns the username and the password
            }
        });

        try {

            Message message = new MimeMessage(session);//creates a ne message 
            message.setFrom(new InternetAddress("DR.AbramowitzInvoice@gmail.com"));////stes the sender adress to DR.AbramowitzInvoice@gmail.com
            message.setRecipients(Message.RecipientType.TO,//stes the reciprcant
                    InternetAddress.parse(toAddress));//sets who the email will be sent to
            message.setSubject(subject);//sets the subject of the email
            message.setText(Text);//sets the text of the email

            Transport.send(message);//seds the message 

            JOptionPane.showMessageDialog(new JFrame(), "Email was sent ", "Success",// alerts the user that it the mailwas sent
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(new JFrame(), "could not send email", "Error",//alerts the user that the mail was not sent
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
