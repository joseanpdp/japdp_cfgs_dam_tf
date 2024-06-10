package japdp.damtf.application.dto.request;

import japdp.damtf.application.persistence.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * DTO para la solicitud de creación de pedidos.
 * Contiene los campos necesarios para crear un nuevo pedido.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
	private String date;
	private String shipAddress;
	private long customerId;
	private OrderStatus status;
}