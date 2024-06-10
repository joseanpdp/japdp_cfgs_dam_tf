package japdp.damtf.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para la solicitud de creación de detalles de pedido.
 * Contiene los campos necesarios para crear un nuevo detalle de pedido.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailRequest {

	private long orderId;
	private long productId;
	private int quantity;

}
