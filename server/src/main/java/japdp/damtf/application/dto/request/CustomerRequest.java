package japdp.damtf.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para la solicitud de creación de clientes.
 * Contiene los campos necesarios para crear un nuevo cliente.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

	private String name;
	private String surname;
	private String address;

}