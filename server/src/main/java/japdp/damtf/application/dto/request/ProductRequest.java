package japdp.damtf.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para crear o actualizar un producto.
 * Contiene campos para el nombre, precio, descripción, ID de categoría y cantidad del producto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductRequest {

	private String name;
	private double price;
	private String description;
	private long categoryId;
	private int quantity;

}
