package com.santt4na.primestore_stock.service;

import com.santt4na.primestore_stock.Models.Category;
import com.santt4na.primestore_stock.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository repository;
	
	public Category save(Category category) {
		return repository.save(category);
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
}