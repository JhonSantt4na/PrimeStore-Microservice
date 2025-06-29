package com.santt4na.primestore_core.controller.docs;

import com.santt4na.primestore_core.dto.request.Order.OrderCreateDTO;
import com.santt4na.primestore_core.dto.request.Order.OrderUpdateDTO;
import com.santt4na.primestore_core.dto.response.OrderResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderControllerDocs {
	
	ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderCreateDTO dto);
	
	ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderUpdateDTO dto);
	
	ResponseEntity<OrderResponseDTO> findByIdOrder(@PathVariable Long id);
	
	ResponseEntity<List<OrderResponseDTO>> findAllOrder();
	
	ResponseEntity<Void> deleteOrder(@PathVariable Long doctorId);
}