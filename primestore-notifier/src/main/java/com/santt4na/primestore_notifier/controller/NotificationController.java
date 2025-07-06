package com.santt4na.primestore_notifier.controller;

import com.santt4na.primestore_notifier.dto.NotificationRequest;
import com.santt4na.primestore_notifier.service.EmailService;
import com.santt4na.primestore_notifier.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
	
	private final NotificationService notificationService;
	private final EmailService emailService;
	
	@PostMapping
	public ResponseEntity<Void> send(@RequestBody NotificationRequest request) {
		notificationService.sendNotification(request);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/email")
	public ResponseEntity<Void> sendEmail(@RequestBody NotificationRequest request) {
		emailService.sendEmail(request.getTo(), request.getSubject(), request.getMessage());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/email/html")
	public ResponseEntity<Void> sendHtmlEmail(@RequestBody NotificationRequest request) {
		String html = "<h1 style='color:blue;'>Confirmação de Pedido</h1>"
			+ "<p>Seu pedido foi confirmado com sucesso!</p>";
		
		emailService.sendHtmlEmail(request.getTo(), request.getSubject(), html);
		return ResponseEntity.ok().build();
	}

}