package com.util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailReport {

	static String hostName = "smtp.gmail.com";
	static final String fromUser = "xxxx";
	static final String fromPassword = "xxxx";

	public static void sendReport() {

		String[] toEmails = { "praveen.4705@gmail.com" };

		Properties properties = new Properties();

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", hostName);
		properties.put("mail.smtp.user", fromUser);
		properties.put("mail.smtp.password", fromPassword);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Create session
		Session mailSession = Session.getDefaultInstance(properties, null);

		// Create Message
		Message message = new MimeMessage(mailSession);

		try {

			// Set from address
			message.setFrom(new InternetAddress(fromUser));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[0]));

			// Set Subject
			message.setSubject("Automation Report");

			// Set Date
			message.setSentDate(new Date());

			// Set Content
			message.setContent("Test Message", "text/html; charset=utf-8");

			// Set Body Part
			BodyPart bodyPart = new MimeBodyPart();

			bodyPart.setText("Please Find The Attached Report File!");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(bodyPart);

			bodyPart = new MimeBodyPart();

			// Set path to the HTML report file
			String filename = System.getProperty("user.dir") + "/src/test/java/com/reports/AutomationReport.html";

			// Create data source to attach the file in mail
			DataSource source = new FileDataSource(filename);

			bodyPart.setDataHandler(new DataHandler(source));

			bodyPart.setFileName(filename);

			multipart.addBodyPart(bodyPart);

			message.setContent(multipart);

			Transport transport = mailSession.getTransport("smtp");

			transport.connect(hostName, fromUser, fromPassword);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
			
			System.out.println("Email Sent Successfully!!!!!");

		} catch (AddressException addressException) {

			addressException.printStackTrace();
		} catch (MessagingException messagingException) {

			messagingException.printStackTrace();
		}

	}

}
