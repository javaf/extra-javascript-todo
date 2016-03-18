package js;
import java.util.*;

/**
 * The oObject constructor creates an oObject wrapper.
 */
public class oObject implements Map {
	
	/* data */
	private oObjectData o;
	
	
	/* constructor */
	/**
	 * The oObject constructor creates an object wrapper for the given value.
	 * @param nameValuePairs Pairs of names (strings) and values (any value).
	 */
	public oObject(Entry... nameValuePairs) {
		for(Entry pair : nameValuePairs)
			map().put(pair.getKey(), pair.getValue());
	}
	/**
	 * The oObject constructor creates an object wrapper for the given value.
	 * @param value Optional. If the value is null or undefined, it will create
	 * and return an empty object, otherwise, it will return an object of a Type
	 * that corresponds to the given value. If the value is an object already, it
	 * will return the value.
	 */
	public oObject(Object value) {
		this.value = value == null? new HashMap() : value;
	}
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 */
	public oObject() {
		value = new HashMap();
	}
	
	
	/* method */
	/**
	 * Get value stored in a key.
	 * @param key Name of key.
	 * @return 
	 */
	@Override
	public Object get(Object key) {
		return containsKey(key)? super.get(key) : (prototype != null? prototype.get(key) : null);
	}

	
	/**
	 * Set value stored in a key.
	 * @param key Name of key.
	 * @param value Value to store.
	 */
	public void set(Object key, Object value) {
		put(key, value);
		super.
	}
	@Override
	public Object put(Object key, Object value) {
		if(containsKey(key) || prototype == null || !prototype.containsKey(key)) return super.put(key, value);
		return prototype.put(key, value);
	}

	
	/**
	 * Represents the oObject's prototype object.
	 * @return Prototype of this object.
	 */
	public final oObject prototype() {
		return data != null? data.prototype : null;
	}
	/**
	 * Sets the oObject's prototype object
	 * @param value New prototype of this object.
	 * @return Same as value.
	 */
	public final oObject prototype(oObject value){
		if(data == null) data = new oObjectData();
		return (data.prototype = value);
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
	 * Returns a boolean indicating whether the oObject has the specified property.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether an oObject contains the specified
	 * property as a direct property of that oObject and not inherited through
	 * the prototype chain.
	 */
	public boolean hasOwnProperty(Object prop) {
		return containsKey(prop);
	}
	
	
	/**
	 * Tests for an oObject in another oObject's prototype chain.
	 * @param obj The oObject whose prototype chain will be searched.
	 * @return Boolean indicating whether an oObject contains the specified
	 * property as a direct property of that oObject and not inherited through
	 * the prototype chain.
	 */
	public boolean isPrototypeOf(oObject obj) {
		for(; obj != null; obj = obj.prototype)
			if(obj == this) return true;
		return false;
	}
	
	
	/**
	 * Returns a Boolean indicating whether the specified property is enumerable.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether the specified property is enumerable.
	 */
	public boolean propertyIsEnumerable(Object prop) {
		return hasOwnProperty(prop) && (special==null || !special.contains(prop));
	}
	
	
	/**
	 * Returns a string representing the oObject. This method is meant to be
	 * overridden by derived objects for locale-specific purposes.
	 * @return Calls toString()
	 */
	public String toLocaleString() {
		return toString();
	}
	
	
	/**
	 * Returns a string representing oObject.
	 * @return String representation of the oObject.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{");
		/*
		for(Entry pair : entrySet())
			str.append(pair.getKey()).append(": ").append(pair.getValue()).append(", ");
		*/
		if(str.length() > 1) str.delete(str.length()-2, str.length());
		return str.append("}").toString();
	}
	
	
	/**
	 * Returns the primitive value of the specified oObject.
	 * @return Primitive value of the specified oObject.
	 */
	public Object valueOf() {
		return value;
	}
	protected final HashMap map() {
		return (HashMap)value;
	}
	
	
	/**
	 * Returns keys in an oObject that can be used in a for..in loop.
	 * @return Enumerated keys.
	 */
	@Override
	public Iterator<String> iterator() {
		return keySet().iterator();
	}
	
	/* static method */
	/**
	 * Returns an array of a given oObject's own enumerable properties, in the same
	 * order as that provided by a for...in loop (the difference being that a
	 * for-in loop enumerates properties in the prototype chain as well).
	 * @param obj Object whose keys to get.
	 * @return Array whose elements are strings corresponding to the enumerable
	 * properties found directly upon oObject.
	 */
	public static String[] keys(oObject obj) {
		return (String[]) obj.keySet().toArray();
	}
	
	
	/**
	 * Seals an object, preventing new properties from being added to it and
	 * marking all existing properties as non-configurable. Values of present 
	 * properties can still be changed as long as they are writable.
	 * @param obj The object which should be sealed.
	 */
	public static void seal(oObject obj) {
		obj.sealed = true;
	}
	
	
	/**
	 * Sets the prototype of a specified object to another object or null.
	 * @param obj The object which is to have its prototype set.
	 * @param prototype The object's new prototype (an object or null).
	 */
	public static void setPrototypeOf(oObject obj, oObject prototype) {
		obj.prototype = prototype;
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean containsKey(Object key) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Object remove(Object key) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void putAll(Map m) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set keySet() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Collection values() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set entrySet() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	/**
	 * Represents internal data for oObject
	 */
	private class oObjectData {
		/**  */
		public oObject prototype;
		public HashMap special;
		public boolean sealed;
	}
}
