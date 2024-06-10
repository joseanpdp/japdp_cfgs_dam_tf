package japdp.damtf.application.exception;

/**
 * Excepción lanzada cuando no se encuentra un producto.
 */
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(long id) {
		super("Product not found: " + id);
	}

	public ProductNotFoundException(String name) {
		super("Product not found: " + name);
	}
}
