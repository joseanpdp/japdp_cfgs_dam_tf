package japdp.damtf.application.exception;

/**
 * Excepción lanzada cuando no se encuentra una categoría.
 */
public class CategoryNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException() {
		super();
	}

	public CategoryNotFoundException(long id) {
		super("Category not found: " + id);
	}
}
