package js.lang.coll;

/**
 * Represents a collection having a set of properties.
 * @param <K> Datatype of property name.
 * @param <V> Datatype of property value.
 */
public interface iColl<K, V> extends Iterable<K> {
	
	/**
	 * Gets the value of a property.
	 * @param prop Name of the property.
	 * @return Property value.
	 */
	V get(K prop);
	
	/**
	 * Sets the value of a property.
	 * @param prop Name of the property.
	 * @param value New property value.
	 * @return New property value.
	 */
	V put(K prop, V value);
}
