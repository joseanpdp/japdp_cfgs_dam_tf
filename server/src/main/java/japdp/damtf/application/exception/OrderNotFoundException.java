package japdp.damtf.application.exception;

/**
 * Excepción lanzada cuando no se encuentra un pedido.
 */
public class OrderNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
    
	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(long id) {
		super("Order not found: " + id);
	}
}
