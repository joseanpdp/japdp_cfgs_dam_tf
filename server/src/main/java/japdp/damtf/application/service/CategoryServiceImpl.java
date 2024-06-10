package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.damtf.application.dto.request.CategoryRequest;
import japdp.damtf.application.dto.response.CategoryResponse;
import japdp.damtf.application.exception.CategoryNotFoundException;
import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.repository.CategoryRepository;
import japdp.damtf.application.persistence.repository.ProductRepository;

/**
 * La clase CategoryServiceImpl implementa la interfaz CategoryService y proporciona
 * la lógica de negocio para realizar operaciones relacionadas con las categorías.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@Override
	public List<CategoryResponse> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryResponse> categoriesDTO = new ArrayList<>();
		for (Category category : categories) {
			CategoryResponse categoryDTO = new CategoryResponse(category.getId(), category.getName(),
					category.getDescription());
			categoriesDTO.add(categoryDTO);
		}
		return categoriesDTO;
	}

	@Override
	public CategoryResponse getById(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			return new CategoryResponse(category.getId(), category.getName(), category.getDescription());
		} else {
			throw new CategoryNotFoundException(id);
		}
	}

	@Override
	public CategoryResponse create(CategoryRequest categoryRequest) {
		Category category = new Category(categoryRequest.getName(), categoryRequest.getDescription());
		categoryRepository.save(category);
		return new CategoryResponse(category);
	}

	@Override
	public CategoryResponse update(long id, CategoryRequest categoryRequest) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setName(categoryRequest.getName());
			category.setDescription(categoryRequest.getDescription());
			categoryRepository.save(category);
			return new CategoryResponse(category);
		} else {
			throw new CategoryNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			productService.deleteByCategoryId(id);
			categoryRepository.deleteById(optionalCategory.get().getId());
		}
	}

}
