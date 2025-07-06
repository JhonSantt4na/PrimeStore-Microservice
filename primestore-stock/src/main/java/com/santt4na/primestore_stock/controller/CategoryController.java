package com.santt4na.primestore_stock.controller;

import com.santt4na.primestore_stock.Models.Category;
import com.santt4na.primestore_stock.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService service;
	
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(category));
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}