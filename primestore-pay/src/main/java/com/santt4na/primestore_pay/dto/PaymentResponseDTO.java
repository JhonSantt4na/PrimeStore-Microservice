package com.santt4na.primestore_pay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDTO {
	private UUID id;
	private String orderId;
	private BigDecimal amount;
	private String status;
	private String transactionId;
	private LocalDateTime createdAt;
}
