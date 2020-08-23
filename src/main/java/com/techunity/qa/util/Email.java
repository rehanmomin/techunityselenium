package com.techunity.qa.util;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session; 
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class Email {

	public static Logger log = Logger.getLogger(Email.class);
	public static void SendEmail(String to,String cc,String subject,String msgFormat,String msgBody,String opt_attachmentFile) {

		String host="10.1.21.83";

		// Get system properties
		try {
			System.out.println(Inet4Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Create object of Property file
		Properties properties = System.getProperties();

		properties.setProperty("java.net.preferIPv4Stack" , "true");
		properties.setProperty("mail.smtp.host", host);
		
		// Setup mail server
		properties.setProperty("java.net.preferIPv4Stack" , "true");
		properties.setProperty("mail.smtp.host", host);
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		
		try{

			MimeMessage message = new MimeMessage(session);      // Create a default MimeMessage object


			//----------------------------------from + To + CC logic
			message.setFrom(new InternetAddress("rehan.momin@sterlingts.com"));   
			if (!to.isEmpty()) {
				//message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.addRecipients(Message.RecipientType.TO, to);
			}
			if (!cc.isEmpty()) {
				//message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));  
				message.addRecipients(Message.RecipientType.CC, cc);
			} 
			message.addRecipients(Message.RecipientType.BCC, "rehan.momin@sterlingts.com");
			message.setSubject(subject);
			//-----------------------------------------------------


			//----------------------------------message Body + Attachment Logic 
			// Create a multipart message
			Multipart multipart = new MimeMultipart();
			
			//1 - Msg Part
			BodyPart BodyPart_msg = new MimeBodyPart();
			if (msgFormat.equalsIgnoreCase("html")) {
				BodyPart_msg.setContent(msgBody, "text/html"); //Please note "text/html" argument means html- There is different method to set html and text message  
			} else {
				BodyPart_msg.setText(msgBody);
			}
			multipart.addBodyPart(BodyPart_msg); 
						

			// Mention the file which you want to send
			String filename = opt_attachmentFile;

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			BodyPart_msg.setDataHandler(new DataHandler(source));

			// set the file
			BodyPart_msg.setFileName(filename);

			
			// add body part 1
			multipart.addBodyPart(BodyPart_msg);

			// set the content
			message.setContent(multipart);

		
			
			//Send message
			Transport.send(message);          

			log.info("Sent message successfully....");
			System.out.println("Sent message successfully....");


		}catch (MessagingException mex) {
			mex.printStackTrace();
			log.error("Exception occurred while sending email.Exception "+mex.getMessage());

		}catch (Exception e){
			log.error("Exception occurred while sending email.Exception "+e.getMessage());
		}
	}

}