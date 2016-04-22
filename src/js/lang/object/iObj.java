package js.lang.object;

/**
 * Defines fundamental object operations, which can implemented by any interface.
 * @param <T> Datatype of base value of this object.
 */
public interface iObj<T> {
	
	/* method */
	/**
	 * Returns the base value of this object.
	 * @return Base value.
	 */
	default T valueOf() {
		return (T)this;
	}

	/**
	 * Returns string representation of the object.
	 * @return String representation of object.
	 */
	default String z_toString() {
		return toString();
	}
}
