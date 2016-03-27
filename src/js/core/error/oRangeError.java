package js.core.error;

/**
 * Indicates an error when a value is not in the set or range of allowed
 * values.
 */
public class oRangeError extends oError {
	
	/* data */
	/** Default name of this Error. */
	private final static String NAME = "RangeError";
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oRangeError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oRangeError() {
		name = NAME;
	}
}
