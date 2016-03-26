package js;
import java.util.*;


public interface iObject extends Map<String, Object>, Iterable<String> {

	/* property */
	/**
	 * Do not use. Returns Internal object value.
	 * @return Internal object value.
	 */
	default zObjectValue zvalue() {
		return null;
	}
	
	/**
	 * Get the object value of a property.
	 * @param key Name of the property.
	 * @return Property value.
	 */
	@Override
	default Object get(Object key) {
		return zvalue()!=null? zvalue().prop(key.toString()) : null;
	}
	
	/**
	 * Set object value value of a property.
	 * @param key Name of the property.
	 * @param value Value to store.
	 * @return The stored value.
	 */
	default Object set(Object key, Object value) {
		return zvalue()!=null? zvalue().prop(key.toString(), value) : null;
	}
	/**
	 * Set object value value of a property.
	 * @param key Name of the property.
	 * @param value Value to store.
	 * @return The stored value.
	 */
	@Override
	default Object put(String key, Object value) {
		return set(key, value);
	}

	/**
	 * Remove a property from Object, if possible.
	 * @param key Name of key.
	 * @return Old value.
	 */
	default Object delete(Object key) {
		return zvalue()!=null? zvalue().delete(key.toString()) : null;
	}
	/**
	 * Remove a property from Object, if possible.
	 * @param key Name of key.
	 * @return Old value.
	 */
	@Override
	default Object remove(Object key) {
		return delete(key);
	}

	
	/**
	 * Returns the Object's prototype object.
	 * @return Prototype of this Object.
	 */
	default iObject prototype() {
		return zvalue()!=null? zvalue().prototype : null;
	}
	/**
	 * Sets the Object's prototype object
	 * @param value New prototype of this Object.
	 * @return Same as value.
	 */
	default iObject prototype(iObject value){
		return (zvalue().prototype = value);
	}
	
	
	/* method */
	/**
	 * Returns a boolean indicating whether the Object has the specified property.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether an Object contains the specified
	 * property as a direct property of that Object and not inherited through
	 * the prototype chain.
	 */
	default boolean hasOwnProperty(String prop) {
		return zvalue()!=null? zvalue().containsKey(prop) : false;
	}
	
	/**
	 * Tests for an Object in another Object's prototype chain.
	 * @param obj The Object whose prototype chain will be searched.
	 * @return Boolean indicating whether an Object contains the specified
	 * property as a direct property of that Object and not inherited through
	 * the prototype chain.
	 */
	default boolean isPrototypeOf(iObject obj) {
		for(; obj!=null && obj.zvalue()!=null; obj=obj.zvalue().prototype)
			if(obj == this) return true;
		return false;
	}
	
	/**
	 * Returns a Boolean indicating whether the specified property is enumerable.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether the specified property is enumerable.
	 */
	default boolean propertyIsEnumerable(String prop) {
		return hasOwnProperty(prop) && (!zvalue().descriptor.containsKey(prop) || zvalue().descriptor.get(prop).enumerable);
	}
	
	/**
	 * Returns a string representing the Object. This method is meant to be
	 * overridden by derived objects for locale-specific purposes.
	 * @return Locale-specific string value.
	 */
	default String toLocaleString() {
		return toString();
	}
	
	
	/**
	 * Returns a string representing Object.
	 * @return String representation of the Object.
	 */
	default String __toString__() {
		return zvalue()!=null? (zvalue().primitive!=null? zvalue().primitive.toString() : Map.super.toString()) : "null";
	}
	
	/**
	 * Returns the primitive value of the specified Object.
	 * @return Primitive value of the specified Object.
	 */
	default Object valueOf() {
		return this;
	}
	
	/**
	 * Returns the number of Object's own properties.
	 * @return Size of Object's own property map.
	 */
	@Override
	default int size() {
		return zvalue()!=null? zvalue().size() : 0;
	}
	
	/**
	 * Checks whether Object has no own properties.
	 * @return Whether Object own properties is empty.
	 */
	@Override
	default boolean isEmpty() {
		return zvalue()!=null? zvalue().isEmpty() : true;
	}
	
	/**
	 * Checks for the key in Object's own properties.
	 * @param key Key to check for.
	 * @return Whether key is this Object's own property.
	 */
	@Override
	default boolean containsKey(Object key) {
		return zvalue()!=null? zvalue().containsKey(key.toString()) : false;
	}

	/**
	 * Checks for the value in Object's own properties.
	 * @param value Value to check for.
	 * @return Whether value is in this Object's own property.
	 */
	@Override
	default boolean containsValue(Object value) {
		return zvalue()!=null? zvalue().containsValue(value) : false;
	}
	
	/**
	 * Adds values in Map as Object's own properties.
	 * @param m Map to take entries from.
	 */
	@Override
	default void putAll(Map m) {
		if(zvalue()!=null) for(Object k : m.keySet())
			zvalue().put(k.toString(), m.get(k));
	}

	/**
	 * Removes the Object's own properties.
	 */
	@Override
	default void clear() {
		if(zvalue()!=null) { zvalue().clear(); zvalue().descriptor.clear(); }
	}

	/**
	 * Returns the key set of Object's own properties.
	 * @return Key set of Object.
	 */
	@Override
	default Set<String> keySet() {
		return zvalue()!=null? zvalue().keySet() : new HashSet<>();
	}

	/**
	 * Returns the values of Object's own properties.
	 * @return Values collection of Object.
	 */
	@Override
	default Collection<Object> values() {
		return zvalue()!=null? zvalue().values() : new ArrayList<>();
	}

	/**
	 * Returns the entry set of Object's own properties.
	 * @return Entry set of Object.
	 */
	@Override
	default Set<Entry<String, Object>> entrySet() {
		return zvalue()!=null? zvalue().entrySet() : new HashSet<>();
	}
	
	/**
	 * Returns an iterator to enable use of Object with for-each loop.
	 * @return Iterator value.
	 */
	@Override
	default Iterator<String> iterator() {
		return keySet().iterator();
	}
}
