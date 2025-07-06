package com.santt4na.primestore_pay.controller;

import com.santt4na.primestore_pay.dto.PaymentRequestDTO;
import com.santt4na.primestore_pay.dto.PaymentResponseDTO;
import com.santt4na.primestore_pay.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
	
	private final PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO dto) {
		PaymentResponseDTO response = paymentService.processPayment(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentResponseDTO> getById(@PathVariable UUID id) {
		return ResponseEntity.ok(paymentService.getPaymentById(id));
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<PaymentResponseDTO> getByOrderId(@PathVariable String orderId) {
		return ResponseEntity.ok(paymentService.getPaymentByOrderId(orderId));
	}
}