package js.lang.function;
import js.lang.object.*;

/**
 * Represents a procedure which can be called with variable arguments, and it
 * returns a value or null.
 */
public interface iProc extends iToString {

	/* property */
	/**
	 * Specifies the number of arguments expected by the procedure.
	 * @return Number of input arguments.
	 */
	default int length() {
		return 0;
	}
	
	/**
	 * Returns the name of the procedure.
	 * @return Procedure name.
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
	@Override
	default String z_toString() {
		return "? "+name()+"(...) { [native code] }";
	}
}
