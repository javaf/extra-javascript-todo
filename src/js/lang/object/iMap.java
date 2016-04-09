package js.lang.object;
import java.util.*;

/**
 * Defines a map type thing.
 * @param <K> Key datatype.
 * @param <V> Value datatype.
 */
public interface iMap<K, V> extends Map<K, V> {
	
	/* property */
	/**
	 * Returns this object's prototype
	 * @return Prototype object.
	 */
	default Object prototype() {
		return null;
	}
	/**
	 * Sets the prototype of this object.
	 * @param obj Object's prototype.
	 * @return Object's prototype.
	 */
	default Object prototype(Object obj) {
		return obj;
	}
	
	
	/* method */
	/**
	 * Returns a boolean indicating whether the object has the specified property.
	 * @param prop The name of the property to test.
	 * @return Whether the object has the specified own property.
	 */
	default boolean hasOwnProperty(String prop) {
		return false;
	}
	
	/**
	 * Tests for an object in another object's prototype chain.
	 * @param obj The object whose prototype chain will be searched.
	 * @return Whether this object is the specified object's prototype.
	 */
	default boolean isPrototypeOf(Object obj) {
		return false;
	}
	
	/**
	 * Returns a Boolean indicating whether the specified property is enumerable.
	 * @param prop The name of the property to test.
	 * @return Whether property is iterable.
	 */
	default boolean propertyIsEnumerable(String prop) {
		return false;
	}
	
	/**
	 * Returns a locale-specific string representing the object.
	 * @return Locale specific string.
	 */
	default String toLocaleString() {
		return toString();
	}
	
	/**
	 * Returns the primitive value of the specified object.
	 * @return Primitive value.
	 */
	default Object valueOf() {
		return null;
	}
}
