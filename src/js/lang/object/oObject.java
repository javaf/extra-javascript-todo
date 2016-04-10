package js.lang.object;
import java.lang.reflect.*;
import java.util.*;

/**
 * Creates an object which contains properties.
 * @param <K> Datatype of property name.
 * @param <V> Datatype of property value.
 */
public class oObject<K, V> extends cProtoMap<K, V> {
	
	public oObject(Object v) {
		super(v);
	}
	
	/* static method */
	public static oObject assign(Object target, Object... sources) {
		return null;
	}
	
	public static oObject create(Object proto, Object propertiesObject) {
		return null;
	}
	public static oObject create(Object proto) {
		return create(proto, null);
	}
	
	public static oObject defineProperties(Object obj, Object props) {
		return null;
	}
	
	public static oObject defineProperty(Object obj, Object prop, Object descriptor) {
		return null;
	}
	
	/**
	 * 
	 * @return 
	 */
	public static Set<Map.Entry<String,Object>> entries() {
		return null;
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
	 * Returns a property descriptor for an own property (that is, one directly
	 * present on an object, not present by dint of being along an object's
	 * prototype chain) of a given object.
	 * @param obj The object in which to look for the property.
	 * @param prop The name of the property whose description is to be retrieved.
	 * @return Descriptor of specified property.
	 */
	public static Map getOwnPropertyDescriptor(oObject obj, Object prop) {
		return ((cAccess)obj.descriptor.get(prop)).get(new HashMap());
	}
	
	/**
	 * Returns an array of all properties (enumerable or not) found directly upon a given object.
	 * @param obj The object whose enumerable and non-enumerable own properties are to be returned.
	 * @return All own properties of object.
	 */
	public static Set<String> getOwnPropertyNames(oObject obj) {
		return obj.value.keySet();
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
	 * Returns the prototype of the specified object.
	 * @param obj The object whose prototype is to be returned.
	 * @return Prototype of the specified object.
	 */
	public static oObject getPrototypeOf(oObject obj) {
		return (oObject)obj.prototype();
	}
	
	/**
	 * Determines whether two values are the same value.
	 * @param value1 The first value to compare.
	 * @param value2 The second value to compare.
	 * @return Whether the two arguments are the same value.
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
	 * order as that provided by a for...in loop (the difference being that a
	 * for-in loop enumerates properties in the prototype chain as well).
	 * @param obj The object whose enumerable own properties are to be returned.
	 * @return Own enumerable key-set of object.
	 */
	public static Set<String> keys(oObject obj) {
		return obj.value.keySet();
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
	 * Sets the prototype of a specified object to another object or null.
	 * @param obj The object which is to have its prototype set.
	 * @param prototype The object's new prototype (an object or null).
	 * @return Object whose prototype was set.
	 */
	public static oObject setPrototypeOf(oObject obj, oObject prototype) {
		obj.prototype(prototype);
		return obj;
	}
	
	/**
	 * Returns an array of a given object's own enumerable property values, in the
	 * same order as that provided by a for...in loop (the difference being that 
	 * for-in loop enumerates properties in the prototype chain as well).
	 * @param obj The object whose enumerable own property values are to be returned.
	 * @return Array of values.
	 */
	public static Collection<Object> values(oObject obj) {
		return obj.value.values();
	}
	
	/* method */
	public Constructor<?> constructor() {
		try { return this.getClass().getConstructor(); }
		catch(NoSuchMethodException e) { throw new RuntimeException(e); }
	}
}
