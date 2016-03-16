package js;
import java.util.*;

/**
 * The object constructor creates an object wrapper.
 */
public class object extends HashMap<String, Object> implements Iterable<String> {
	
	/* static method */
	/**
	 * Returns an array of a given object's own enumerable properties, in the same
	 * order as that provided by a for...in loop (the difference being that a
	 * for-in loop enumerates properties in the prototype chain as well).
	 * @param obj Object whose keys to get.
	 * @return Array whose elements are strings corresponding to the enumerable
	 * properties found directly upon object.
	 */
	public static String[] keys(object obj) {
		return (String[]) obj.keySet().toArray();
	}
	
	/* constructor */
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 * @param nameValuePairs Pairs of names (strings) and values (any value) where
	 * the name is separated from the value by a colon.
	 */
	public object(Entry... nameValuePairs) {
		for(Entry pair : nameValuePairs)
			put(pair.getKey().toString(), pair.getValue());
	}
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 * @param value Optional. If the value is null or undefined, it will create
	 * and return an empty object, otherwise, it will return an object of a Type
	 * that corresponds to the given value. If the value is an object already, it
	 * will return the value.
	 */
	public object(Object value) {
		if(value != null) put("[[PrimitiveValue]]", value);
	}
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 * @param value Optional. If the value is null or undefined, it will create
	 * and return an empty object, otherwise, it will return an object of a Type
	 * that corresponds to the given value. If the value is an object already, it
	 * will return the value.
	 */
	public object() {
	}
	
	/* method */
	/**
	 * Set value stored in a key.
	 * @param key Name of key.
	 * @param value Value to store.
	 */
	public void set(Object key, Object value) {
		put(key.toString(), value);
	}
	
	
	/**
	 * Returns a reference to the Object function that created the instance prototype. Note that the
	 * value of this property is a reference to the function itself, not a string containing the function's
	 * name. The value is only read-only for primitive values such as 1, true and "test".
	 * @return Reference to the Object function that created the instance prototype.
	 */
	public Object constructor() {
		return null;
	}
	
	
	/**
	 * Returns a boolean indicating whether the object has the specified property.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether an object contains the specified
	 * property as a direct property of that object and not inherited through
	 * the prototype chain.
	 */
	public boolean hasOwnProperty(String prop) {
		return propertyIsEnumerable(prop);
	}
	
	
	/**
	 * Tests for an object in another object's prototype chain.
	 * @param obj The object whose prototype chain will be searched.
	 * @return Boolean indicating whether an object contains the specified
	 * property as a direct property of that object and not inherited through
	 * the prototype chain.
	 */
	public boolean isPrototypeOf(object obj) {
		for(; obj != null && obj.hasOwnProperty("prototype"); obj = (object)obj.get("prototype"))
			if(obj == this) return true;
		return false;
	}
	
	
	/**
	 * Returns a Boolean indicating whether the specified property is enumerable.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether the specified property is enumerable.
	 */
	public boolean propertyIsEnumerable(String prop) {
		return containsKey(prop);
	}
	
	
	/**
	 * Returns a string representing the object. This method is meant to be
	 * overridden by derived objects for locale-specific purposes.
	 * @return Calls toString()
	 */
	public String toLocaleString() {
		return toString();
	}
	
	
	/**
	 * Returns a string representing object.
	 * @return String representation of the object.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{");
		for(Entry pair : entrySet())
			str.append(pair.getKey()).append(": ").append(pair.getValue()).append(", ");
		if(str.length() > 1) str.delete(str.length()-2, str.length());
		return str.append("}").toString();
	}
	
	
	/**
	 * Returns the primitive value of the specified object.
	 * @return Primitive value of the specified object.
	 */
	public Object valueOf() {
		return this;
	}
	
	
	/**
	 * Returns keys in an object that can be used in a for..in loop.
	 * @return Enumerated keys.
	 */
	@Override
	public Iterator<String> iterator() {
		return keySet().iterator();
	}
}
