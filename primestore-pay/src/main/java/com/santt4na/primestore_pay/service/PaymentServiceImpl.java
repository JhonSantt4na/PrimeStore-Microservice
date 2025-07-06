package com.santt4na.primestore_pay.service;

import com.santt4na.primestore_pay.dto.PaymentRequestDTO;
import com.santt4na.primestore_pay.dto.PaymentResponseDTO;
import com.santt4na.primestore_pay.entity.Payment;
import com.santt4na.primestore_pay.enus.PaymentStatus;
import com.santt4na.primestore_pay.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentRepository repository;
	
	@Override
	public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
		Payment payment = Payment.builder()
			.orderId(dto.getOrderId())
			.amount(dto.getAmount())
			.status(PaymentStatus.APPROVED)
			.createdAt(LocalDateTime.now())
			.build();
		
		payment = repository.save(payment);
		
		return mapToResponse(payment);
	}
	
	@Override
	public PaymentResponseDTO getPaymentById(UUID id) {
		Payment payment = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
		return mapToResponse(payment);
	}
	
	@Override
	public PaymentResponseDTO getPaymentByOrderId(String orderId) {
		Payment payment = repository.findByOrderId(orderId)
			.orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
		return mapToResponse(payment);
	}
	
	private PaymentResponseDTO mapToResponse(Payment payment) {
		return PaymentResponseDTO.builder()
			.id(payment.getId())
			.orderId(payment.getOrderId())
			.amount(payment.getAmount())
			.status(payment.getStatus().name())
			.transactionId(payment.getTransactionId())
			.createdAt(payment.getCreatedAt())
			.build();
	}
}
