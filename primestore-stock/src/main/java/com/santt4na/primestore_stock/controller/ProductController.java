package com.santt4na.primestore_stock.controller;

import com.santt4na.primestore_stock.Models.Product;
import com.santt4na.primestore_stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PatchMapping("/{id}/quantity")
	public ResponseEntity<Product> updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
		return ResponseEntity.ok(service.updateQuantity(id, quantity));
	}
}