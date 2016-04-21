package js.lang.function;

/**
 * Represents a method which can be called with variable arguments, and it
 * returns a value.
 */
public interface iMethod {
	
	/* property */
	/**
	 * Specifies the number of arguments expected by the function.
	 * @return Number of function arguments.
	 */
	default int length() {
		return 0;
	}
	
	/**
	 * Returns the name of the function.
	 * @return Function name.
	 */
	default String name() {
		return "";
	}
	
	
	/* method */
	/**
	 * Calls the (main) method of this object defined in a class, which implements
	 * a super-interface to this interface.
	 * @param args The input arguments to pass to the function.
	 * @return The output value.
	 */
	Object call(Object... args);
	
	/**
	 * Returns string representation of the method.
	 * @return String representation of method.
	 */
	default String ztoString() {
		return "? "+name()+"(...) { [native code] }";
	}
}
