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

import japdp.damtf.application.dto.request.ProductRequest;
import japdp.damtf.application.dto.response.ProductResponse;
import japdp.damtf.application.dto.response.ProductResponseBrief;
import japdp.damtf.application.exception.ProductNotFoundException;
import japdp.damtf.application.service.ProductService;

/**
 * Controlador REST para la gestión de productos.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar productos.
 * Maneja la excepción lanzada cuando no se encuentra un producto.
 */
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleProductNotFoundException(Exception e) {
		LOGGER.info("Producto no encontrado: {}",e.getMessage());   
		return "Producto no encontrado: " + e;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAll() {
		LOGGER.info("Solicitados todos los productos");   
		return productService.getAll();
	}

	@GetMapping("/bycategory/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponseBrief> getByCategoryId(@PathVariable long id) {
		LOGGER.info("Solicitado los productos de la categoría id={}", id);   
		return productService.getByCategoryId(id);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getById(@PathVariable long id) {
		LOGGER.info("Solicitado el producto con id={}", id);   
		return productService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		LOGGER.info("Solicitada la creación de un producto de la categoría con id={}", productRequest.getCategoryId());   
		return productService.create(productRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse updateProduct(@PathVariable long id, @RequestBody ProductRequest productRequest) {
		LOGGER.info("Solicitada la actualización del producto con id={}", id);   
		return productService.update(id, productRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable long id) {
		LOGGER.info("Solicitada la eliminación del producto con id={}", id);   
		productService.delete(id);
	}

}
