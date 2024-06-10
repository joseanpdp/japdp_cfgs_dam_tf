package japdp.damtf.application.dto.response;

import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para representar la respuesta de un detalle de pedido.
 * Contiene los campos ID, cantidad, ID del producto, nombre del producto, precio del producto,
 * ID del pedido, fecha del pedido, dirección de envío del pedido,
 * ID del cliente, nombre del cliente y apellido del cliente.
 */

@Getter
@Setter
@NoArgsConstructor

public class OrderDetailResponse {

	private long id;
	private int quantity;

	private long productId;
	private String productName;
	private double productPrice;

	private long orderId;
	private String orderDate;
	private String orderShipAddress;

	private long customerId;
	private String customerName;
	private String customerSurname;

	public OrderDetailResponse(OrderDetail orderDetail) {

		id = orderDetail.getId();
		quantity = orderDetail.getQuantity();

		Product product = orderDetail.getProduct();
		Order order = orderDetail.getOrder();
		Customer customer = order.getCustomer();

		productId = product.getId();
		productName = product.getName();
		productPrice = product.getPrice();

		orderId = order.getId();
		orderDate = order.getDate();
		orderShipAddress = order.getShipAddress();

		customerId = customer.getId();
		customerName = customer.getName();
		customerSurname = customer.getSurname();

	}
}
