package js;
import java.util.*;


public interface iObject extends Map, Iterable {
	
	default Object constructor(Entry... nameValuePairs) {
		pObjectValue value = new pObjectValue();
		for(Entry p : nameValuePairs)
			value.put(p.getKey(), p.getValue());
		return value;
	}
	
	default Object constructor(Object value) {
		pObjectValue v = new pObjectValue();
		if(value==null) return v;
		v = new pObjectValue();
		v.put("[[PrimitiveValue]]", value);
		v.descriptor.put("[[PrimitiveValue]]", new pObjectDescriptor());
		return v;
	}
	
	default Object constructor() {
		return new pObjectValue();
	}
	
	
	/* method */
	/**
	 * Get the value of a property.
	 * @param key Name of the property.
	 * @return Property value.
	 */
	@Override
	default Object get(Object key) {
		return value()!=null? value().prop(key) : null;
	}

	
	/**
	 * Set value stored in a key.
	 * @param key Name of key.
	 * @param value Value to store.
	 * @return The stored value.
	 */
	default Object set(Object key, Object value) {
		return cvalue().prop(key, value);
	}
	/**
	 * Set value stored in a key.
	 * @param key Name of key.
	 * @param value Value to store.
	 * @return The stored value.
	 */
	@Override
	default Object put(Object key, Object value) {
		return set(key, value);
	}

	
	/**
	 * Remove a property from object, if possible.
	 * @param key Name of key.
	 * @return Old value.
	 */
	default Object delete(Object key) {
		return remove(key);
	}
	/**
	 * Remove a property from object, if possible.
	 * @param key Name of key.
	 * @return Old value.
	 */
	@Override
	default Object remove(Object key) {
		return value()!=null? value().delete(key) : null;
	}

	
	/**
	 * Represents the oObject's prototype object.
	 * @return Prototype of this object.
	 */
	default iObject prototype() {
		return value()!=null? value().prototype : null;
	}
	/**
	 * Sets the oObject's prototype object
	 * @param value New prototype of this object.
	 * @return Same as value.
	 */
	default final oObject prototype(oObject value){
		return (data().prototype = value);
	}
	
	
	/**
	 * Returns a reference to the Object function that created the instance prototype. Note that the
	 * value of this property is a reference to the function itself, not a string containing the function's
	 * name. The value is only read-only for primitive values such as 1, true and "test".
	 * @return Reference to the Object function that created the instance prototype.
	 */
	default Object constructor() {
		return null;
	}
	
	
	
	/**
	 * Returns a boolean indicating whether the oObject has the specified property.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether an oObject contains the specified
	 * property as a direct property of that oObject and not inherited through
	 * the prototype chain.
	 */
	default final boolean hasOwnProperty(Object prop) {
		return value.containsKey(prop);
	}
	
	
	/**
	 * Tests for an oObject in another oObject's prototype chain.
	 * @param obj The oObject whose prototype chain will be searched.
	 * @return Boolean indicating whether an oObject contains the specified
	 * property as a direct property of that oObject and not inherited through
	 * the prototype chain.
	 */
	default final boolean isPrototypeOf(oObject obj) {
		for(; obj!=null && obj.value!=null; obj = obj.value.prototype)
			if(obj == this) return true;
		return false;
	}
	
	
	/**
	 * Returns a Boolean indicating whether the specified property is enumerable.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether the specified property is enumerable.
	 */
	default final boolean propertyIsEnumerable(Object prop) {
		return hasOwnProperty(prop) && (!value.descriptor.containsKey(prop) || value.descriptor.get(prop).enumerable);
	}
	
	
	/**
	 * Returns a string representing the oObject. This method is meant to be
	 * overridden by derived objects for locale-specific purposes.
	 * @return Calls toString()
	 */
	default String toLocaleString() {
		return toString();
	}
	
	
	/**
	 * Returns a string representing oObject.
	 * @return String representation of the oObject.
	 */
	@Override
	default String toString() {
		return value!=null? (value.containsKey("[[PrimitiveValue]]")? value.get("[[PrimitiveValue]]").toString() : null) : "null";
	}
	
	
	/**
	 * Returns the primitive value of the specified oObject.
	 * @return Primitive value of the specified oObject.
	 */
	default Object valueOf() {
		return value;
	}

	
	/* static method */
	/**
	 * Copy the values of all enumerable own properties from one or more source
	 * objects to a target object. It will return the target object.
	 * @param target The target object.
	 * @param sources The source object(s).
	 * @return The target object.
	 */
	default static oObject assign(oObject target, oObject... sources) {
		for(oObject s : sources)
			for(Object k : s.keySet())
				if(s.hasOwnProperty(k)) target.put(k, s.get(k));
		return target;
	}
	
	
	default static oObject create(oObject proto, Map propertiesObject) {
		oObject obj = new oObject();
		// for(Object key : propertiesObject)
		return null;
	}
	
	
	default static void defineProperties(oObject obj, Map props) {
		
	}
	
	
	default static void defineProperty(oObject obj, Object prop, Map descriptor) {
		
	}
	
	/**
	 * Freezes an object: that is, prevents new properties from being added to
	 * it; prevents existing properties from being removed; and prevents existing
	 * properties, or their enumerability, configurability, or writability, from
	 * being changed. In essence the object is made effectively immutable. The
	 * method returns the object being frozen.
	 * @param obj 
	 */
	default static void freeze(oObject obj) {
		obj.data().lock(3);
	}
	
	default static Map getOwnPropertyDescriptor() {
		return null;
	}
	
	static String[] getOwnPropertyNames() {
		return null;
	}
	
	static String[] getOwnPropertySymbols() {
		return null;
	}
	
	
	/**
	 * Returns the prototype of the specified object.
	 * @param obj The object whose prototype is to be returned.
	 * @return Prototype of object if it exists, otherwise null.
	 */
	static oObject getPrototypeOf(oObject obj) {
		return obj!=null? obj.prototype() : null;
	}
	
	
	/**
	 * Determines whether two values are the same value.
	 * @param value1 The first value to compare.
	 * @param value2 The second value to compare.
	 * @return A Boolean indicating whether or not the two arguments are the same
	 * value.
	 */
	static boolean is(Object value1, Object value2) {
		return value1.equals(value2);
	}
	
	
	/**
	 * Determines if an object is extensible (whether it can have new properties
	 * added to it). Objects are extensible by default: they can have new
	 * properties added to them, and can be modified. An object can be marked as
	 * non-extensible using Object.preventExtensions(), Object.seal(), or
	 * Object.freeze().
	 * @param obj The object which should be checked.
	 * @return Returns true if the object is extensible, otherwise false.
	 */
	static boolean isExtensible(oObject obj) {
		return obj!=null? obj.value!=null && obj.value.isLocked(1) : false;
	}
	
	
	/**
	 * Determines if an object is frozen. An object is frozen if and only if it
	 * is not extensible, all its properties are non-configurable, and all its
	 * data properties (that is, properties which are not accessor properties
	 * with getter or setter components) are non-writable.
	 * @param obj The object which should be checked.
	 * @return Returns true if the object is frozen, otherwise false.
	 */
	static boolean isFrozen(oObject obj) {
		return obj!=null? obj.value!=null && obj.value.isLocked(3) : true;
	}
	
	
	/**
	 * Determines if an object is sealed. An object is sealed if it is not
	 * extensible and if all its properties are non-configurable and therefore
	 * not removable (but not necessarily non-writable).
	 * @param obj The object which should be checked.
	 * @return Returns true if the object is sealed, otherwise false.
	 */
	static boolean isSealed(oObject obj) {
		return obj!=null? obj.value!=null && obj.value.isLocked(2) : true;
	}
	
	
	static Set<Object> keys(oObject obj) {
		return obj!=null? obj.keySet() : new HashSet<>();
	}
	
	
	/**
	 * Prevents new properties from ever being added to an object (i.e. prevents
	 * future extensions to the object).
	 * @param obj The object which should be made non-extensible.
	 * @return Returns a reference to the passed Object.
	 */
	default static oObject preventExtensions(oObject obj) {
		obj.data().lock(1);
		return obj;
	}
	
	
	/**
	 * Seals an object, preventing new properties from being added to it and
	 * marking all existing properties as non-configurable. Values of present
	 * properties can still be changed as long as they are writable.
	 * @param obj The object which should be sealed.
	 * @return Returns a reference to the passed Object.
	 */
	default static oObject seal(oObject obj) {
		obj.data().lock(2);
		return obj;
	}

	
	@Override
	default int size() {
		return value!=null? value.size() + (prototype()!=null? prototype().size() : 0) : 0;
	}

	
	@Override
	default boolean isEmpty() {
		return value==null || (value.isEmpty() && (prototype()==null || prototype().isEmpty()));
	}

	
	@Override
	default boolean containsKey(Object key) {
		return value!=null && (value.containsKey(key) || (prototype()!=null && prototype().containsKey(key)));
	}

	
	@Override
	default boolean containsValue(Object value) {
		return this.value!=null && (this.value.containsValue(value) || (prototype()!=null && prototype().containsValue(value)));
	}

	
	@Override
	default void putAll(Map m) {
		for(Object k : m.keySet())
			put(k, m.get(k));
	}

	
	@Override
	default void clear() {
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) remove(k);
	}

	
	@Override
	default Set<Object> keySet() {
		Set<Object> v = prototype()!=null? prototype().keySet() : new HashSet<>();
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) v.add(k);
		return v;
	}

	
	@Override
	default List<Object> values() {
		List<Object> v = prototype()!=null? prototype().values() : new ArrayList<>();
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) v.add(value.prop(k));
		return v;
	}

	
	@Override
	default Set<Entry> entrySet() {
		Set<Entry> v = prototype()!=null? prototype().entrySet() : new HashSet<>();
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) v.add(new AbstractMap.SimpleEntry(k, value.prop(k)));
		return v;
	}

	
	@Override
	default Iterator<Object> iterator() {
		return keySet().iterator();
	}
	
	// is equals required here?
	/**
	 * Get the internal value of this object.
	 * @return Internal value.
	 */
	pObjectValue value();
	/**
	 * Set the internal value of this object.
	 * @param value New internal value.
	 * @return Internal value.
	 */
	pObjectValue value(pObjectValue value);
	
	/**
	 * Creates internal value, if required, and returns it.
	 * @return Internal value.
	 */
	default pObjectValue cvalue() {
		return value(value()==null? new pObjectValue() : value());
	}
}
