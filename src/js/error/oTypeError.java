package js;

/**
 * Represents an error when a value is not of the expected type.
 */
public class oTypeError extends oError {
	
	/* data */
	/** Default name of this Error. */
	private final static String NAME = "TypeError";
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oTypeError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oTypeError() {
		name = NAME;
	}
}
