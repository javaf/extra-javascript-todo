package js.lang.object;

/**
 * Defines a object to string conversion interface, which can implemented by any interface.
 * @param <T> Datatype of base value of this object.
 */
public interface iObj<T> {
	
	/* method */
	/**
	 * Returns string representation of the object.
	 * @return String representation of object.
	 */
	default String z_toString() {
		return toString();
	}
	
	/**
	 * Returns the base value of this object.
	 * @return Base value.
	 */
	default T valueOf() {
		return (T)this;
	}
}
