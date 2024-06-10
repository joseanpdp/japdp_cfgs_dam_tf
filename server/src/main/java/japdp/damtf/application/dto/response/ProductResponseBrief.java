package japdp.damtf.application.dto.response;

import japdp.damtf.application.persistence.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para representar una respuesta breve de un producto.
 * Contiene los campos ID, nombre, precio, descripción y cantidad.
 */
@Getter
@Setter
@NoArgsConstructor

public class ProductResponseBrief {

	private long id;
	private String name;
	private double price;
	private String description;
	private int quantity;

	public ProductResponseBrief(Product product) {

		id = product.getId();
		name = product.getName();
		price = product.getPrice();
		description = product.getDescription();
		quantity = product.getQuantity();

	}
}
