package japdp.damtf.application.exception;

/**
 * Excepción lanzada cuando no se encuentra un detalle de pedido.
 */
public class OrderDetailNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
	
	public OrderDetailNotFoundException() {
		super();
	}

	public OrderDetailNotFoundException(long id) {
		super("Order not found: " + id);
	}
}
