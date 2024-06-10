package japdp.damtf.application.service;

import java.util.List;

import japdp.damtf.application.dto.request.ProductRequest;
import japdp.damtf.application.dto.response.ProductResponse;
import japdp.damtf.application.dto.response.ProductResponseBrief;

/**
 * La interfaz ProductService define métodos para gestionar productos en la aplicación,
 * incluyendo la obtención de todos los productos, la obtención de productos por identificador
 * de categoría, la obtención de un producto por su nombre, la creación, actualización y eliminación
 * de productos, así como la eliminación de todos los productos asociados a una categoría específica.
 */
public interface ProductService {

	public List<ProductResponse> getAll();

	public List<ProductResponseBrief> getByCategoryId(long id);

	public ProductResponse getById(long id);

	public ProductResponse getByName(String name);

	public ProductResponse create(ProductRequest productRequest);

	public ProductResponse update(long id, ProductRequest productRequest);

	public void delete(long id);

	public void deleteByCategoryId(long id);

}
