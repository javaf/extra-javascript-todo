package js;
import java.util.*;


/**
 * The oObject constructor creates an oObject wrapper.
 */
public class oObject implements Map, Iterable {
	
	/* data */
	/** Internal. Defines this oObject actual values. */
	private pObjectValue value;
	
	
	/* constructor */
	/**
	 * The oObject constructor creates an object wrapper for the given value.
	 * @param nameValuePairs Pairs of names (strings) and values (any value).
	 */
	public oObject(Entry... nameValuePairs) {
		value = new pObjectValue();
		for(Entry p : nameValuePairs)
			value.put(p.getKey(), p.getValue());
	}
	/**
	 * The oObject constructor creates an object wrapper for the given value.
	 * @param value Optional. It will return an object of a Type that corresponds
	 * to the given value. If the value is an object already, it will return
	 * the value.
	 */
	public oObject(Object value) {
		if(value==null) return;
		this.value = new pObjectValue();
		this.value.put("[[PrimitiveValue]]", value);
		this.value.descriptor.put("[[PrimitiveValue]]", new pObjectDescriptor());
	}
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 */
	public oObject() {
		value = new pObjectValue();
	}
	
	
	/* method */
	/**
	 * Get the value of a property.
	 * @param key Name of the property.
	 * @return Property value.
	 */
	@Override
	public Object get(Object key) {
		return value!=null? value.prop(key) : null;
	}

	
	/**
	 * Set value stored in a key.
	 * @param key Name of key.
	 * @param value Value to store.
	 * @return The stored value.
	 */
	public Object set(Object key, Object value) {
		return data().prop(key, value);
	}
	/**
	 * Set value stored in a key.
	 * @param key Name of key.
	 * @param value Value to store.
	 * @return The stored value.
	 */
	@Override
	public Object put(Object key, Object value) {
		return set(key, value);
	}

	
	/**
	 * Remove a property from object, if possible.
	 * @param key Name of key.
	 * @return Old value.
	 */
	public Object delete(Object key) {
		return remove(key);
	}
	/**
	 * Remove a property from object, if possible.
	 * @param key Name of key.
	 * @return Old value.
	 */
	@Override
	public Object remove(Object key) {
		return value!=null? value.delete(key) : null;
	}

	
	/**
	 * Represents the oObject's prototype object.
	 * @return Prototype of this object.
	 */
	public final oObject prototype() {
		return value!=null? value.prototype : null;
	}
	/**
	 * Sets the oObject's prototype object
	 * @param value New prototype of this object.
	 * @return Same as value.
	 */
	public final oObject prototype(oObject value){
		return (data().prototype = value);
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
	public final boolean hasOwnProperty(Object prop) {
		return value.containsKey(prop);
	}
	
	
	/**
	 * Tests for an oObject in another oObject's prototype chain.
	 * @param obj The oObject whose prototype chain will be searched.
	 * @return Boolean indicating whether an oObject contains the specified
	 * property as a direct property of that oObject and not inherited through
	 * the prototype chain.
	 */
	public final boolean isPrototypeOf(oObject obj) {
		for(; obj!=null && obj.value!=null; obj = obj.value.prototype)
			if(obj == this) return true;
		return false;
	}
	
	
	/**
	 * Returns a Boolean indicating whether the specified property is enumerable.
	 * @param prop The name of the property to test.
	 * @return Boolean indicating whether the specified property is enumerable.
	 */
	public final boolean propertyIsEnumerable(Object prop) {
		return hasOwnProperty(prop) && (!value.descriptor.containsKey(prop) || value.descriptor.get(prop).enumerable);
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
		return value!=null? (value.containsKey("[[PrimitiveValue]]")? value.get("[[PrimitiveValue]]").toString() : null) : "null";
	}
	
	
	/**
	 * Returns the primitive value of the specified oObject.
	 * @return Primitive value of the specified oObject.
	 */
	public Object valueOf() {
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
	public static oObject assign(oObject target, oObject... sources) {
		for(oObject s : sources)
			for(Object k : s.keySet())
				if(s.hasOwnProperty(k)) target.put(k, s.get(k));
		return target;
	}
	
	
	public static oObject create(oObject proto, Map propertiesObject) {
		oObject obj = new oObject();
		// for(Object key : propertiesObject)
		return null;
	}
	
	
	public static void defineProperties(oObject obj, Map props) {
		
	}
	
	
	public static void defineProperty(oObject obj, Object prop, Map descriptor) {
		
	}
	
	/**
	 * Freezes an object: that is, prevents new properties from being added to
	 * it; prevents existing properties from being removed; and prevents existing
	 * properties, or their enumerability, configurability, or writability, from
	 * being changed. In essence the object is made effectively immutable. The
	 * method returns the object being frozen.
	 * @param obj 
	 */
	public static void freeze(oObject obj) {
		obj.data().lock(3);
	}
	
	public static Map getOwnPropertyDescriptor() {
		return null;
	}
	
	public static String[] getOwnPropertyNames() {
		return null;
	}
	
	public static String[] getOwnPropertySymbols() {
		return null;
	}
	
	
	/**
	 * Returns the prototype of the specified object.
	 * @param obj The object whose prototype is to be returned.
	 * @return Prototype of object if it exists, otherwise null.
	 */
	public static oObject getPrototypeOf(oObject obj) {
		return obj!=null? obj.prototype() : null;
	}
	
	
	/**
	 * Determines whether two values are the same value.
	 * @param value1 The first value to compare.
	 * @param value2 The second value to compare.
	 * @return A Boolean indicating whether or not the two arguments are the same
	 * value.
	 */
	public static boolean is(Object value1, Object value2) {
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
	public static boolean isExtensible(oObject obj) {
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
	public static boolean isFrozen(oObject obj) {
		return obj!=null? obj.value!=null && obj.value.isLocked(3) : true;
	}
	
	
	/**
	 * Determines if an object is sealed. An object is sealed if it is not
	 * extensible and if all its properties are non-configurable and therefore
	 * not removable (but not necessarily non-writable).
	 * @param obj The object which should be checked.
	 * @return Returns true if the object is sealed, otherwise false.
	 */
	public static boolean isSealed(oObject obj) {
		return obj!=null? obj.value!=null && obj.value.isLocked(2) : true;
	}
	
	
	public static Set<Object> keys(oObject obj) {
		return obj!=null? obj.keySet() : new HashSet<>();
	}
	
	
	/**
	 * Prevents new properties from ever being added to an object (i.e. prevents
	 * future extensions to the object).
	 * @param obj The object which should be made non-extensible.
	 * @return Returns a reference to the passed Object.
	 */
	public static oObject preventExtensions(oObject obj) {
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
	public static oObject seal(oObject obj) {
		obj.data().lock(2);
		return obj;
	}

	
	@Override
	public int size() {
		return value!=null? value.size() + (prototype()!=null? prototype().size() : 0) : 0;
	}

	
	@Override
	public boolean isEmpty() {
		return value==null || (value.isEmpty() && (prototype()==null || prototype().isEmpty()));
	}

	
	@Override
	public boolean containsKey(Object key) {
		return value!=null && (value.containsKey(key) || (prototype()!=null && prototype().containsKey(key)));
	}

	
	@Override
	public boolean containsValue(Object value) {
		return this.value!=null && (this.value.containsValue(value) || (prototype()!=null && prototype().containsValue(value)));
	}

	
	@Override
	public void putAll(Map m) {
		for(Object k : m.keySet())
			put(k, m.get(k));
	}

	
	@Override
	public void clear() {
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) remove(k);
	}

	
	@Override
	public Set<Object> keySet() {
		Set<Object> v = prototype()!=null? prototype().keySet() : new HashSet<>();
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) v.add(k);
		return v;
	}

	
	@Override
	public List<Object> values() {
		List<Object> v = prototype()!=null? prototype().values() : new ArrayList<>();
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) v.add(value.prop(k));
		return v;
	}

	
	@Override
	public Set<Entry> entrySet() {
		Set<Entry> v = prototype()!=null? prototype().entrySet() : new HashSet<>();
		if(value!=null) for(Object k : value.keySet())
			if(propertyIsEnumerable(k)) v.add(new AbstractMap.SimpleEntry(k, value.prop(k)));
		return v;
	}

	
	@Override
	public Iterator<Object> iterator() {
		return keySet().iterator();
	}
	
	// is equals required here?
	
	
	/**
	 * Creates oObject data, if required, and returns it.
	 * @return oObject data.
	 */
	private pObjectValue data() {
		return (value = value==null? new pObjectValue() : value);
	}
}
