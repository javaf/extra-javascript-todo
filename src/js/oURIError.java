package js;

/**
 * Represents an error when a global URI handling function was used in a wrong way.
 */
public class oURIError extends oError {
	
	/* data */
	/** Default name of this Error. */
	private final static String NAME = "URIError";
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oURIError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oURIError() {
		name = NAME;
	}
}
