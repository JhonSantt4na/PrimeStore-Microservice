package com.santt4na.primestore_core.controller;

import com.santt4na.primestore_core.controller.docs.ProductControllerDocs;
import com.santt4na.primestore_core.dto.request.Product.ProductCreateDTO;
import com.santt4na.primestore_core.dto.request.Product.ProductUpdateDTO;
import com.santt4na.primestore_core.dto.response.ProductResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProductControllerImpl implements ProductControllerDocs {
	
	@Override
	public ResponseEntity<ProductResponseDTO> createProduct(ProductCreateDTO dto) {
		return null;
	}
	
	@Override
	public ResponseEntity<ProductResponseDTO> updateProduct(Long id, ProductUpdateDTO dto) {
		return null;
	}
	
	@Override
	public ResponseEntity<ProductResponseDTO> findByIdProduct(Long id) {
		return null;
	}
	
	@Override
	public ResponseEntity<List<ProductResponseDTO>> findAllProduct() {
		return null;
	}
	
	@Override
	public ResponseEntity<Void> deleteProduct(Long doctorId) {
		return null;
	}
}
