package japdp.damtf.application.dto.response;

import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para representar una respuesta breve de un pedido.
 * Contiene los campos ID, fecha, dirección de envío, ID del cliente, 
 * nombre del cliente, apellido del cliente y estado del pedido.
 */
@Getter
@Setter
@NoArgsConstructor

public class OrderResponseBrief {

	private long id;
	private String date;
	private String shipAddress;
	private long customerId;
	private String customerName;
	private String customerSurname;
	private OrderStatus status;

	public OrderResponseBrief(Order order) {
		id = order.getId();
		date = order.getDate();
		shipAddress = order.getShipAddress();
		status = order.getStatus();

		customerId = order.getCustomer().getId();
		customerName = order.getCustomer().getName();
		customerSurname = order.getCustomer().getSurname();
	}
}
