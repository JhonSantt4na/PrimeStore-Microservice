package com.santt4na.primestore_core.controller;

import com.santt4na.primestore_core.controller.docs.OrderControllerDocs;
import com.santt4na.primestore_core.dto.request.Order.OrderCreateDTO;
import com.santt4na.primestore_core.dto.request.Order.OrderUpdateDTO;
import com.santt4na.primestore_core.dto.response.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderControllerImpl implements OrderControllerDocs {
	
	@Override
	public ResponseEntity<OrderResponseDTO> createOrder(OrderCreateDTO dto) {
		return null;
	}
	
	@Override
	public ResponseEntity<OrderResponseDTO> updateOrder(Long id, OrderUpdateDTO dto) {
		return null;
	}
	
	@Override
	public ResponseEntity<OrderResponseDTO> findByIdOrder(Long id) {
		return null;
	}
	
	@Override
	public ResponseEntity<List<OrderResponseDTO>> findAllOrder() {
		return null;
	}
	
	@Override
	public ResponseEntity<Void> deleteOrder(Long doctorId) {
		return null;
	}
}