package js.lang.object;
import java.util.*;

/**
 * Creates an object which contains properties.
 * @param <K> Datatype of property name.
 * @param <V> Datatype of property map.
 */
public class oObject<K, V> extends cProtoMap<K, V> {
	
	/* constructor */
	/**
	 * Create an oObject.
	 * @param nameValuePairs Pairs of names (strings) and values (any map) where
 the name is separated from the map by a colon.
	 */
	public oObject(Entry... nameValuePairs) {
		super(new HashMap<>());
		for(Entry e : nameValuePairs)
			map.put(e.getKey(), e.getValue());
	}
	/**
	 * Create an oObject.
	 * @param value Any map.
	 */
	public oObject(Object value) {
		super(value instanceof Map? (Map)value : new cObjMap(value));
	}
	
	
	/* static method */
	/**
	 * Copy the values of all enumerable own properties from one or more source
	 * objects to a target object. It will return the target object.
	 * @param target The target object.
	 * @param sources The source object(s).
	 * @return The target object which was assigned.
	 */
	public static oObject assign(oObject target, oObject... sources) {
		for(oObject s : sources)
			for(Object k : s.keySet)
				target.put(k, s.get(k));
		return target;
	}
	
	/**
	 * Creates a new object with the specified proto object and properties.
	 * @param proto The object which should be the proto of the newly-created object.
	 * @param propertiesObject Optional. If specified and not undefined, an object whose
 enumerable own properties (that is, those properties defined upon itself and not
 enumerable properties along its proto chain) specify property descriptors to
 be added to the newly-created object, with the corresponding property names. These
 properties correspond to the second argument of Object.defineProperties().
	 * @return Newly created object.
	 */
	public static oObject create(oObject proto, Map propertiesObject) {
		oObject o = new oObject(new HashMap<>(propertiesObject));
		o.prototype(proto);
		return o;
	}
	/**
	 * Creates a new object with the specified proto object and properties.
	 * @param proto The object which should be the proto of the newly-created object.
	 * @return Newly created object.
	 */
	public static oObject create(oObject proto) {
		return create(proto, null);
	}
	
	/**
	 * Defines new or modifies existing properties directly on an object, returning the object.
	 * @param obj The object on which to define or modify properties.
	 * @param props An object whose own enumerable properties constitute descriptors
	 * for the properties to be defined or modified. Property descriptors present in
	 * objects come in two main flavors: data descriptors and accessor descriptors
	 * (see Object.defineProperty() for more details).
	 * @return Object whose properties were defined.
	 */
	public static oObject defineProperties(oObject obj, Map props) {
		for(Object e : props.entrySet())
			defineProperty(obj, ((Entry)e).getKey(), (Map)((Entry)e).getValue());
		return null;
	}
	
	/**
	 * Defines a new property directly on an object, or modifies an existing
	 * property on an object, and returns the object.
	 * @param obj The object on which to define the property.
	 * @param prop The name of the property to be defined or modified.
	 * @param descriptor The descriptor for the property being defined or modified.
	 * @return Object whose property was defined.
	 */
	public static oObject defineProperty(oObject obj, Object prop, Map descriptor) {
		obj.access(prop, descriptor);;
		return obj;
	}
	
	/**
	 * Returns an array of a given object's own enumerable property [key, map] pairs,
 in the same order as that provided by a for...in loop (the difference being that
 a for-in loop enumerates properties in the proto chain as well).
	 * @param obj The object whose enumerable own property [key, map] pairs are to be returned.
	 * @return Set of object's own enumerable properties.
	 */
	public static Set<Map.Entry<String, Object>> entries(oObject obj) {
		Set<Map.Entry<String, Object>> o = new HashSet<>();
		for(Object k : obj.keySet)
			o.add(new AbstractMap.SimpleEntry<>(k.toString(), obj.get(k)));
		return o;
	}
	
	/**
	 * Freezes an object: that is, prevents new properties from being added to it;
	 * prevents existing properties from being removed; and prevents existing
	 * properties, or their enumerability, configurability, or writability, from
	 * being changed. In essence the object is made effectively immutable.
	 * The method returns the object being frozen.
	 * @param obj The object to freeze.
	 * @return Object that was frozen.
	 */
	public static oObject freeze(oObject obj) {
		obj.lock(3);
		return obj;
	}
	
	/**
	 * Returns a property access for an own property (that is, one directly
 present on an object, not present by dint of being along an object's
 proto chain) of a given object.
	 * @param obj The object in which to look for the property.
	 * @param prop The name of the property whose description is to be retrieved.
	 * @return Descriptor of specified property.
	 */
	public static Map getOwnPropertyDescriptor(oObject obj, Object prop) {
		return obj.access(prop).get(new HashMap<>());
	}
	
	/**
	 * Returns an array of all properties (enumerable or not) found directly upon a given object.
	 * @param obj The object whose enumerable and non-enumerable own properties are to be returned.
	 * @return All own properties of object.
	 */
	public static Set<String> getOwnPropertyNames(oObject obj) {
		return obj.map.keySet();
	}
	
	/**
	 * Returns an array of all symbol properties found directly upon a given object.
	 * @param obj The object whose symbol properties are to be returned.
	 * @return Set of keys.
	 */
	public static Set<String> getOwnPropertySymbols(oObject obj) {
		return getOwnPropertyNames(obj);
	}
	
	/**
	 * Returns the proto of the specified object.
	 * @param obj The object whose proto is to be returned.
	 * @return Prototype of the specified object.
	 */
	public static oObject getPrototypeOf(oObject obj) {
		return (oObject)obj.prototype();
	}
	
	/**
	 * Determines whether two values are the same map.
	 * @param value1 The first map to compare.
	 * @param value2 The second map to compare.
	 * @return Whether the two arguments are the same map.
	 */
	public static boolean is(Object value1, Object value2) {
		return value1.equals(value2);
	}
	
	/**
	 * Determines if an object is extensible (whether it can have new properties added to it).
	 * @param obj The object which should be checked.
	 * @return Whether the object is extensible.
	 */
	public static boolean isExtensible(oObject obj) {
		return obj.isLocked(1);
	}
	
	/**
	 * Determines if an object is frozen.
	 * @param obj The object which should be checked.
	 * @return Whether object is frozen.
	 */
	public static boolean isFrozen(oObject obj) {
		return obj.isLocked(3);
	}
	
	/**
	 * Determines if an object is sealed.
	 * @param obj The object which should be checked.
	 * @return Whether the object id sealed.
	 */
	public static boolean isSealed(oObject obj) {
		return obj.isLocked(2);
	}
	
	/**
	 * Returns an array of a given object's own enumerable properties, in the same
 order as that provided by a for...in loop (the difference being that a
 for-in loop enumerates properties in the proto chain as well).
	 * @param obj The object whose enumerable own properties are to be returned.
	 * @return Own enumerable key-set of object.
	 */
	public static Set<String> keys(oObject obj) {
		return obj.keySet;
	}
	
	/**
	 * Prevents new properties from ever being added to an object
	 * (i.e. prevents future extensions to the object).
	 * @param obj The object which should be made non-extensible.
	 * @return Object that was made non-extensible.
	 */
	public static oObject preventExtensions(oObject obj) {
		obj.lock(1);
		return obj;
	}
	
	/**
	 * Seals an object, preventing new properties from being added to it and marking
	 * all existing properties as non-configurable. Values of present properties can
	 * still be changed as long as they are writable.
	 * @param obj The object which should be sealed.
	 * @return Object that was sealed.
	 */
	public static oObject seal(oObject obj) {
		obj.lock(2);
		return obj;
	}
	
	/**
	 * Sets the proto of a specified object to another object or null.
	 * @param obj The object which is to have its proto set.
	 * @param prototype The object's new proto (an object or null).
	 * @return Object whose proto was set.
	 */
	public static oObject setPrototypeOf(oObject obj, oObject prototype) {
		obj.prototype(prototype);
		return obj;
	}
	
	/**
	 * Returns an array of a given object's own enumerable property values, in the
 same order as that provided by a for...in loop (the difference being that 
 for-in loop enumerates properties in the proto chain as well).
	 * @param obj The object whose enumerable own property values are to be returned.
	 * @return Array of values.
	 */
	public static Collection<Object> values(oObject obj) {
		Collection<Object> o = new ArrayList<>();
		for(Object k : obj.keySet)
			o.add(obj.get(k));
		return o;
	}
}
