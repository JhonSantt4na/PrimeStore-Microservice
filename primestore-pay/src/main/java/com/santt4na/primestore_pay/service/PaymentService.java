package com.santt4na.primestore_pay.service;

import com.santt4na.primestore_pay.dto.PaymentRequestDTO;
import com.santt4na.primestore_pay.dto.PaymentResponseDTO;

import java.util.UUID;

public interface PaymentService {
	
	PaymentResponseDTO processPayment(PaymentRequestDTO dto);
	PaymentResponseDTO getPaymentById(UUID id);
	PaymentResponseDTO getPaymentByOrderId(String orderId);
}
