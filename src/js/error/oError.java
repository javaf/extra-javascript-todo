package js;

/**
 * Instances of Error objects are thrown when runtime errors occur. The Error
 * object can also be used as a base object for user-defined exceptions.
 */
public class oError extends RuntimeException {
	
	/* data */
	/** Name for the type of error. The initial value is "Error". */
	protected String name;
	/** Default name of this Error. */
	private final static String NAME = "Error";
	
	
	/* properties */
	/**
	 * Returns a human-readable description of the error.
	 * @return Error description string.
	 */
	public final String message() {
		return super.getMessage();
	}
	
	/**
	 * Returns name for the type of error. The initial value is "Error".
	 * @return Error name as string.
	 */
	public final String name() {
		return name;
	}
	/**
	 * Sets the new name for this error, and return it.
	 * @param value New name for the type of error
	 * @return Error name as string.
	 */
	public final String name(String value) {
		return (name = value);
	}
	
	
	/* constructor */
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 * @param message Optional. Human-readable description of the error.
	 */
	public oError(String message) {
		super(message);
		name = NAME;
	}
	/**
	 * Creates an error object, which is thrown when runtime error occurs.
	 */
	public oError() {
		name = NAME;
	}
	
	
	/* method */
	/**
	 * Returns a string representing the specified Error object.
	 * @return Error details as string.
	 */
	@Override
	public String toString() {
		return name+": "+message();
	}
}
