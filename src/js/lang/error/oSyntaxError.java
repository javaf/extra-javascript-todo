package js.lang.error;

/**
 * Represents an error when trying to interpret syntactically invalid code.
 */
public class oSyntaxError extends oError {
	
	/* data */
	/** Default name of this Error. */
	private final static String NAME = "SyntaxError";
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oSyntaxError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oSyntaxError() {
		name = NAME;
	}
}
