package js.lang.object;

/**
 * Defines a object to string conversion interface, which can implemented by any interface.
 */
public interface iToString {
	
	/* method */
	/**
	 * Returns string representation of the object.
	 * @return String representation of object.
	 */
	default String z_toString() {
		return toString();
	}
}
