package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.damtf.application.dto.request.ProductRequest;
import japdp.damtf.application.dto.response.ProductResponse;
import japdp.damtf.application.dto.response.ProductResponseBrief;
import japdp.damtf.application.exception.CategoryNotFoundException;
import japdp.damtf.application.exception.ProductNotFoundException;
import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Product;
import japdp.damtf.application.persistence.repository.CategoryRepository;
import japdp.damtf.application.persistence.repository.ProductRepository;

/**
 * La clase ProductServiceImpl implementa la interfaz ProductService y proporciona
 * métodos para gestionar productos en la aplicación.
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	OrderDetailService orderDetailService;

	@Override
	public List<ProductResponse> getAll() {
		List<Product> products = productRepository.findAll();
		List<ProductResponse> productsDTO = new ArrayList<>();
		for (Product product : products) {
			ProductResponse productDTO = new ProductResponse(product);
			productsDTO.add(productDTO);
		}
		return productsDTO;
	}

	@Override
	public List<ProductResponseBrief> getByCategoryId(long id) {
		List<Product> products = productRepository.findByCategoryId(id);
		List<ProductResponseBrief> productsResponseBrief = new ArrayList<>();
		for (Product product : products) {
			ProductResponseBrief productResponseBrief = new ProductResponseBrief(product);
			productsResponseBrief.add(productResponseBrief);
		}
		return productsResponseBrief;
	}

	@Override
	public ProductResponse getById(long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			return new ProductResponse(product);
		} else {
			throw new ProductNotFoundException(id);
		}
	}

	@Override
	public ProductResponse getByName(String name) {
		Optional<Product> optionalProduct = productRepository.findByName(name);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			return new ProductResponse(product);
		} else {
			throw new ProductNotFoundException(name);
		}
	}

	@Override
	public ProductResponse create(ProductRequest productRequest) {
		long categoryId = productRequest.getCategoryId();
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			Product product = new Product(productRequest.getName(), productRequest.getPrice(),
					productRequest.getDescription(), category, productRequest.getQuantity());
			productRepository.save(product);
			return new ProductResponse(product);
		} else {
			throw new CategoryNotFoundException(categoryId);
		}
	}

	@Override
	public ProductResponse update(long id, ProductRequest productRequest) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setName(productRequest.getName());
			product.setDescription(productRequest.getDescription());
			product.setPrice(productRequest.getPrice());
			product.setQuantity(productRequest.getQuantity());
			Optional<Category> optionalCategory = categoryRepository.findById(productRequest.getCategoryId());
			if (optionalCategory.isPresent()) {
				product.setCategory(optionalCategory.get());
			} else {
				throw new CategoryNotFoundException(productRequest.getCategoryId());
			}
			productRepository.save(product);
			return new ProductResponse(product);
		} else {
			throw new ProductNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			orderDetailService.deleteByProductId(id);
			productRepository.deleteById(optionalProduct.get().getId());
		}
	}

	public void deleteByCategoryId(long id) {
		List<Product> products = productRepository.findByCategoryId(id);
		for (Product product : products) {
			this.delete(product.getId());
		}
	}

}
