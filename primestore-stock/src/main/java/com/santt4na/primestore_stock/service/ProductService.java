package com.santt4na.primestore_stock.service;

import com.santt4na.primestore_stock.Models.Product;
import com.santt4na.primestore_stock.dto.StockDecreaseRequest;
import com.santt4na.primestore_stock.repository.CategoryRepository;
import com.santt4na.primestore_stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repository;
	private final CategoryRepository categoryRepository;
	
	public Product save(Product product) {
		return repository.save(product);
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product updateQuantity(Long productId, Integer quantity) {
		Product product = repository.findById(productId)
			.orElseThrow(() -> new RuntimeException("Product not found"));
		product.setQuantity(quantity);
		return repository.save(product);
	}
	
	public void decreaseStock(StockDecreaseRequest request) {
		for (StockDecreaseRequest.ItemRequest item : request.getItems()) {
			Product product = repository.findById(item.getProductId())
				.orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.getProductId()));
			
			if (product.getQuantity() < item.getQuantity()) {
				throw new RuntimeException("Estoque insuficiente para o produto: " + product.getName());
			}
			
			product.setQuantity(product.getQuantity() - item.getQuantity());
			repository.save(product);
		}
	}
	
}