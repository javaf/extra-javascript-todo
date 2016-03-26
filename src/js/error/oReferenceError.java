package js;

/**
 * Represents an error when a non-existent variable is referenced.
 */
public class oReferenceError extends oError {
	
	/* data */
	/** Default name of this Error. */
	private final static String NAME = "ReferenceError";
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oReferenceError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oReferenceError() {
		name = NAME;
	}
}
