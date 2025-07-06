package com.santt4na.primestore_stock.controller;

import com.santt4na.primestore_stock.dto.StockDecreaseRequest;
import com.santt4na.primestore_stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
	
	private final ProductService productService;
	
	@PostMapping("/decrease")
	public ResponseEntity<Void> decreaseStock(@RequestBody StockDecreaseRequest request) {
		productService.decreaseStock(request);
		return ResponseEntity.ok().build();
	}
}