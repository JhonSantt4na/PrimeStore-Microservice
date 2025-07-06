package com.santt4na.primestore_notifier.service;

import com.santt4na.primestore_notifier.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	public void sendNotification(NotificationRequest request) {
		// Aqui pode ser integração real com serviço de e-mail, SMS, etc.
		System.out.println("== Enviando Notificação ==");
		System.out.println("Para: " + request.getTo());
		System.out.println("Assunto: " + request.getSubject());
		System.out.println("Mensagem: " + request.getMessage());
	}
}