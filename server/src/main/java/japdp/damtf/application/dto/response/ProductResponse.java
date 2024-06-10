package japdp.damtf.application.dto.response;

import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para representar la respuesta de un producto.
 * Contiene los campos ID, nombre, precio, descripción, ID de categoría, 
 * nombre de categoría y cantidad.
 */
@Getter
@Setter
@NoArgsConstructor

public class ProductResponse {

	private long id;
	private String name;
	private double price;
	private String description;
	private long categoryId;
	private String categoryName;
	private int quantity;

	public ProductResponse(Product product) {

		id = product.getId();
		name = product.getName();
		price = product.getPrice();
		description = product.getDescription();
		quantity = product.getQuantity();

		Category category = product.getCategory();
		categoryId = category.getId();
		categoryName = category.getName();

	}
}
