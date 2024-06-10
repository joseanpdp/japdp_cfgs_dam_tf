package japdp.damtf.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para la solicitud de creación de categorías.
 * Contiene los campos necesarios para crear una nueva categoría.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

	private String name;
	private String description;

}