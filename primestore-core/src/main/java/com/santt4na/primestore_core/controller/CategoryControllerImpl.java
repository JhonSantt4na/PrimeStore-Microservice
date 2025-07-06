package com.santt4na.primestore_core.controller;

import com.santt4na.primestore_core.controller.docs.CategoryControllerDocs;
import com.santt4na.primestore_core.dto.request.Category.CategoryCreateDTO;
import com.santt4na.primestore_core.dto.request.Category.CategoryUpdateDTO;
import com.santt4na.primestore_core.dto.response.CategoryResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CategoryControllerImpl implements CategoryControllerDocs {
	
	@Override
	public ResponseEntity<CategoryResponseDTO> createCategory(CategoryCreateDTO dto) {
		return null;
	}
	
	@Override
	public ResponseEntity<CategoryResponseDTO> updateCategory(Long id, CategoryUpdateDTO dto) {
		return null;
	}
	
	@Override
	public ResponseEntity<CategoryResponseDTO> findByIdCategory(Long id) {
		return null;
	}
	
	@Override
	public ResponseEntity<List<CategoryResponseDTO>> findAllCategory() {
		return null;
	}
	
	@Override
	public ResponseEntity<Void> deleteCategory(Long doctorId) {
		return null;
	}
}
