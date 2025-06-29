package com.santt4na.primestore_core.controller.docs;

import com.santt4na.primestore_core.dto.request.Category.CategoryCreateDTO;
import com.santt4na.primestore_core.dto.request.Category.CategoryUpdateDTO;
import com.santt4na.primestore_core.dto.response.CategoryResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryControllerDocs {
	
	ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryCreateDTO dto);
	
	ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryUpdateDTO dto);
	
	ResponseEntity<CategoryResponseDTO> findByIdCategory(@PathVariable Long id);
	
	ResponseEntity<List<CategoryResponseDTO>> findAllCategory();

	ResponseEntity<Void> deleteCategory(@PathVariable Long doctorId);
}
