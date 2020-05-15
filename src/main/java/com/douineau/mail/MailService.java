package com.douineau.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.douineau.utils.ConfigReader;

public class MailService {

	public static void sendMessage(String subject, String text, String destinataire, String copyDest) throws IOException {
	      // Sender's email ID needs to be mentioned
	      String from = "josselin.douineau.1987@gmail.com";
	      
	      Properties prop = ConfigReader.getProperties("resources.properties");

	      final String username = prop.getProperty("username");
	      final String password = prop.getProperty("password");

	      String host = "smtp.gmail.com";
//	      String host = " smtp.googlemail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
//	      props.put("mail.smtp.port", "25");
	      props.put("mail.smtp.port", "587");
//	      props.put("mail.smtp.port", "2525");
//	      props.put("mail.smtp.port", "465");
	      props.put("mail.debug", "true");

	      
//	      props.put("mail.smtp.socketFactory.class",
//	                "javax.net.ssl.SSLSocketFactory");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(destinataire));
		
		   // Set Subject: header field
		   message.setSubject("Testing Subject");
		
		   // Now set the actual message
		   message.setText("Hello, this is sample for to check send " +
			"email using JavaMailAPI ");

		   // Send message
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	    	 e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	   }

	}
