package japdp.damtf.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import japdp.damtf.application.dto.request.CategoryRequest;
import japdp.damtf.application.dto.response.CategoryResponse;
import japdp.damtf.application.exception.CategoryNotFoundException;
import japdp.damtf.application.service.CategoryService;

/**
 * Controlador REST para la gestión de categorías.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar categorías.
 * Maneja la excepción lanzada cuando no se encuentra una categoría.
 */
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleCategoryNotFoundException(Exception e) {
		LOGGER.info("Categoría no encontrada: {}",e.getMessage());   
		return "Category no encontrado: " + e;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryResponse> getAll() {
		LOGGER.info("Solicitadas todas las categorías");   
		return categoryService.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryResponse getById(@PathVariable long id) {
		LOGGER.info("Solicitada la categoría con id={}", id);   
		return categoryService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
		LOGGER.info("Solicitada la creación de una categoría: {}", categoryRequest.getName());   
		return categoryService.create(categoryRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryResponse updateCategory(@PathVariable long id, @RequestBody CategoryRequest categoryRequest) {
		LOGGER.info("Solicitada la actualización de la categoría con id={}", categoryRequest.getName());   
		return categoryService.update(id, categoryRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(@PathVariable long id) {
		LOGGER.info("Solicitada la eliminación de la categoría con id={}", id);   
		categoryService.delete(id);
	}

}
