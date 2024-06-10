package japdp.damtf.application.dto.response;

import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para representar una respuesta breve de un detalle de pedido.
 * Contiene los campos ID, cantidad, ID del producto, nombre del producto y precio del producto.
 */
@Getter
@Setter
@NoArgsConstructor

public class OrderDetailResponseBrief {

	private long id;
	private int quantity;

	private long productId;
	private String productName;
	private double productPrice;

	public OrderDetailResponseBrief(OrderDetail orderDetail) {

		id = orderDetail.getId();
		quantity = orderDetail.getQuantity();

		Product product = orderDetail.getProduct();

		productId = product.getId();
		productName = product.getName();
		productPrice = product.getPrice();

	}
}
