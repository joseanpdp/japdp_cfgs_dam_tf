package japdp.damtf.application.dto.response;

import japdp.damtf.application.persistence.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para representar la respuesta de una categoría.
 * Contiene los campos ID, nombre y descripción de la categoría.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
	private long id;
	private String name;
	private String description;

	public CategoryResponse(Category category) {
		id = category.getId();
		name = category.getName();
		description = category.getDescription();
	}
}