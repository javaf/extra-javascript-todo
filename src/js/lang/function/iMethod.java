package js.lang.function;

/**
 * Represents a method which can be called with variable arguments, and it
 * returns a value.
 */
public interface iMethod {
	
	/* method */
	/**
	 * Calls the (main) method of this object defined in a class, which implements
	 * a super-interface to this interface.
	 * @param args The input arguments to pass to the function.
	 * @return The output value.
	 */
	Object call(Object... args);
}
