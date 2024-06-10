package japdp.damtf.application.service;

import java.util.List;

import japdp.damtf.application.dto.request.CategoryRequest;
import japdp.damtf.application.dto.response.CategoryResponse;

/**
 * La interfaz CategoryService define los métodos que pueden ser implementados para realizar
 * operaciones relacionadas con la entidad Category.
 */
public interface CategoryService {

	public List<CategoryResponse> getAll();

	public CategoryResponse getById(long id);

	public CategoryResponse create(CategoryRequest categoryRequest);

	public CategoryResponse update(long id, CategoryRequest categoryRequest);

	public void delete(long id);

}
