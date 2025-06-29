package com.santt4na.primestore_core.controller.docs;

import com.santt4na.primestore_core.dto.request.Product.ProductCreateDTO;
import com.santt4na.primestore_core.dto.request.Product.ProductUpdateDTO;
import com.santt4na.primestore_core.dto.response.ProductResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductControllerDocs {
	
	ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductCreateDTO dto);
	
	ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductUpdateDTO dto);
	
	ResponseEntity<ProductResponseDTO> findByIdProduct(@PathVariable Long id);
	
	ResponseEntity<List<ProductResponseDTO>> findAllProduct();
	
	ResponseEntity<Void> deleteProduct(@PathVariable Long doctorId);
}