package js.core.error;

/**
 * Indicates an error regarding the global eval() function. This exception is
 * not thrown by JavaScript anymore, however the EvalError object remains for
 * compatibility.
 */
public class oEvalError extends oError {
	
	/* data */
	/** Default name of this Error. */
	private final static String NAME = "EvalError";
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oEvalError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oEvalError() {
		name = NAME;
	}
}
