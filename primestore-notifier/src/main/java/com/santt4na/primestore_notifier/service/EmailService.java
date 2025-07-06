package com.santt4na.primestore_notifier.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
	
	private final JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String body) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, false); // false = texto simples, true = HTML
			helper.setFrom("seuemail@gmail.com");
			
			mailSender.send(message);
			System.out.println("E-mail enviado com sucesso para: " + to);
			
		} catch (MessagingException e) {
			throw new RuntimeException("Erro ao enviar e-mail", e);
		}
	}
	
	public void sendHtmlEmail(String to, String subject, String htmlBody) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(htmlBody, true); // true = corpo é HTML
			helper.setFrom("seuemail@provedor.com");
			
			mailSender.send(message);
			System.out.println("E-mail HTML enviado com sucesso para: " + to);
			
		} catch (MessagingException e) {
			throw new RuntimeException("Erro ao enviar e-mail HTML", e);
		}
	}
}

