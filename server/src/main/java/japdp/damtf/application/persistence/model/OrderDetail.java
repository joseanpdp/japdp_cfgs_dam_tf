package japdp.damtf.application.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase OrderDetail representa un detalle de un pedido, que consiste en un producto 
 * junto con su cantidad. Cada detalle de pedido tiene un identificador único, una 
 * referencia al pedido al que pertenece y una referencia al producto que se está 
 * ordenando. Además, cada detalle de pedido tiene una cantidad que indica la cantidad
 * de ese producto que se está solicitando en el pedido.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "T_ORDERDETAIL")
@Entity
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "OrderDetail order cannot be null")
	@ManyToOne
	private Order order;

	@NotNull(message = "OrderDetail product cannot be null")
	@ManyToOne
	private Product product;

	@Min(1)
	private int quantity;

	public OrderDetail(Order order, Product product, int quantity) {
		this();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
}
