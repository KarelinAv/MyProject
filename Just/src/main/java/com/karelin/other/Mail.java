package com.karelin.other;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	private static final String USERS_LOGIN = "k5465272@gmail.com";
	private static final String USERS_PASSWORD = "5465272qwerty";

	public static void sendMail(String email, long number) {

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", USERS_LOGIN);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtp.sendpartial", "true");

		Session session = Session.getDefaultInstance(props);

		try {
			Transport transport = session.getTransport();
			transport.connect("smtp.gmail.com", 465, USERS_LOGIN, USERS_PASSWORD);

			MimeMessage message = new MimeMessage(session);
			message.setSubject("Подтверждение регистрации");
			message.setText("http://localhost:8080/Just/confirmRegistration?number=" + number);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}