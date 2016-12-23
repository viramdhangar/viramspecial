package com.waio.mail;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	public boolean sendEmail(String subject,String body){
		
		try
		  {
		  Properties props=new Properties();
		   props.put("mail.smtp.host", "waio.in");
		  // props.put("mail.smtp.host","localhost");   //  'localhost' for testing
		   Session   session1  =  Session.getDefaultInstance(props);
		   String s1 = "viram@waio.in"; //sender (from)
		   String s2 = "viram@waio.in";
		  // String s3 = request.getParameter("name");
		  // String s4 = request.getParameter("messagevalue");
		   MimeMessage message =new MimeMessage(session1);
		   message.setFrom(new InternetAddress(s1));
		   message.addRecipient(Message.RecipientType.TO,
                 new InternetAddress(s2));
		   message.setSubject(subject);
		   message.setText(body);  
		   Transport.send(message);
		  }
		  catch(Exception ex)
		  {
		   System.out.println("ERROR....."+ex);
		  }
		return true;
	}
	public boolean sendResetEmail(String subject,String body, String email){
		
		String host = "waio.in";

		try {

			boolean sessionDebug = true;
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");

			props.put("mail.smtp.host", host);
			props.put("mail.transport.protocol.", "smtp");
			props.put("mail.smtp.user", "support@waio.in"); // User name
			props.put("mail.smtp.password", "Ramkishan@1"); // password

			props.put("mail.smtp.auth", "true");
			// props.put("mail.smtp.", "true");
			props.put("mail.smtp.port", "587");

			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("support@waio.in", "Ramkishan@1");
				}
			});
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("support@waio.in"));
			InternetAddress[] address = { new InternetAddress(email) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			msg.setContent(multipart, "text/html"); // use setText if you want
													// to send text
			Transport.send(msg);
			System.out.println("sent");
			// WasEmailSent = true; // assume it was sent
		} catch (Exception err) {
			// WasEmailSent = false; // assume it's a fail
			System.out.println("Error" + err.getMessage());
		}
		return true;
	}
}
