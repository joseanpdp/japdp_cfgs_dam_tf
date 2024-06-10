package japdp.damtf.application.exception;

/**
 * Excepción lanzada cuando no se encuentra un cliente.
 */
public class CustomerNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(long id) {
		super("Customer not found: " + id);
	}

	public CustomerNotFoundException(String name, String surname) {
		super("Customer not found: " + name + ", " + surname);
	}
}
