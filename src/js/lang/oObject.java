package js.lang;
import js.lang.object.zObjectValue;
import java.util.*;


/**
 * The oObject constructor creates an oObject wrapper.
 */
public class oObject implements iObject {
	
	/* data */
	/** Internal object value/map. */
	private final zObjectValue value;
	
	
	/* constructor */
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 * @param nameValuePairs Pairs of names (strings) and values (any value).
	 */
	public oObject(Entry... nameValuePairs) {
		value = new zObjectValue();
		for(Entry p : nameValuePairs)
			value.put(p.getKey().toString(), p.getValue());
	}
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 * @param value Optional. It will return an object of a Type that corresponds
	 * to the given value. If the value is an object already, it will return
	 * the value.
	 */
	public oObject(Object value) {
		this.value = new zObjectValue();
		this.value.primitive = value;
	}
	/**
	 * The Object constructor creates an object wrapper for the given value.
	 */
	public oObject() {
		value = new zObjectValue();
	}


	/* property */
	@Override
	public zObjectValue zvalue() {
		return value;
	}
	
	
	/* method */

	
	/* static method */
	/**
	 * Copy the values of all enumerable own properties from one or more source
	 * Objects to a target Object. It will return the target Object.
	 * @param target The target Object.
	 * @param sources The source Object(s).
	 * @return The target Object.
	 */
	static iObject assign(iObject target, iObject... sources) {
		for(iObject s : sources)
			for(String k : s.keySet())
				if(s.propertyIsEnumerable(k)) target.put(k, s.get(k));
		return target;
	}
	
	static iObject create(oObject proto, Map propertiesObject) {
		iObject obj = new oObject();
		
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
		obj.value.lock(3);
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
	public static iObject getPrototypeOf(iObject obj) {
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
	
	
	public static Set<String> keys(oObject obj) {
		return obj!=null? obj.keySet() : new HashSet<>();
	}
	
	
	/**
	 * Prevents new properties from ever being added to an object (i.e. prevents
	 * future extensions to the object).
	 * @param obj The object which should be made non-extensible.
	 * @return Returns a reference to the passed Object.
	 */
	public static oObject preventExtensions(oObject obj) {
		obj.value.lock(1);
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
		obj.value.lock(2);
		return obj;
	}
}
