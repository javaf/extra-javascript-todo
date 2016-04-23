package js.lang.object;
import java.util.*;

/**
 * Defines a map-like object.
 * @param <K> Key datatype.
 * @param <V> Value datatype.
 */
public interface iProtoMap<K, V> extends iEnumMap<K, V> {
	
	/* property */
	/**
	 * Returns the prototype of this object.
	 * @return This object's prototype.
	 */
	iProtoMap prototype();
	
	/**
	 * Sets the prototype of this object.
	 * @param prototype This object's prototype
	 * @return This object's prototype.
	 */
	iProtoMap prototype(iProtoMap prototype);
	
	
	/* method */
	/**
	 * Returns a boolean indicating whether the object has the specified property.
	 * @param prop The name of the property to test.
	 * @return Whether the object has the specified own property.
	 */
	default boolean hasOwnProperty(K prop) {
		return this.containsKey(prop);
	}
	
	/**
	 * Tests for an object in another object's prototype chain.
	 * @param obj The object whose prototype chain will be searched.
	 * @return Whether this object is the specified object's prototype.
	 */
	default boolean isPrototypeOf(iProtoMap obj) {
		for(; obj!=null; obj=obj.prototype())
			if(obj==this) return true;
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
	 * @return Locale-specific string.
	 */
	default String toLocaleString() {
		return toString();
	}
	
	/**
	 * Returns a key set containing all own keys of this object, including those
	 * which are not enumerable. Own keys are those which are part of this object,
	 * not of its prototype object.
	 * @return Own key set of all keys.
	 */
	Set<K> ownKeySetAll();
	
	/**
	 * Returns a key set containing only enumerable own keys of this object. Own
	 * keys are those which are part of this object, not of its prototype object.
	 * @return Own key set of enumerable keys.
	 */
	Set<K> ownKeySet();
}
