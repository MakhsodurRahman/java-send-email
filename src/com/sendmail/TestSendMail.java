/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sendmail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestSendMail
{
    public static void sendMail(String to_email) throws Exception
    {
        Properties props=new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        String from_email="from_email_id@gmail.com";
        String from_email_pass="from_password";

        //1. create Session object
        Session session=Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from_email, from_email_pass);
            }
        });

        //2. compose the message
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(from_email));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
        message.setSubject("hello");
        message.setText("this is my first mail demo message...!!");

        // 3. send the message
        Transport.send(message);

        System.out.println("message sended successfully");
    }
}
