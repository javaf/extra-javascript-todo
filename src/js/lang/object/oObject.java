package js.lang.object;
import java.lang.reflect.*;
import java.util.*;

/**
 * Creates an object which contains properties.
 * @param <K> Datatype of property name.
 * @param <V> Datatype of property value.
 */
public class oObject<K, V> {
	
	/* data */
	private Object obj;
	private Map<K, Field> map;
	private oObject proto;
	
	/* property */
	/**
	 * Get the value of the specified property.
	 * @param prop Name of the property.
	 * @return Value of the property.
	 */
	public V get(K prop) {
		try { return (V)map.get(prop).get(obj); }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	public V set(K prop, V value) {
		try { map.get(prop).set(obj, value); }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
		return value;
	}
	
	/**
	 * Get the prototype of this object.
	 * @return Prototype object.
	 */
	public oObject prototype() {
		return proto;
	}
	/**
	 * Set the prototype of the object.
	 * @param obj New prototype object.
	 * @return New prototype object.
	 */
	public oObject prototype(oObject obj) {
		return proto = obj;
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
	
	public static Set<Map.Entry<String,Object>> entries() {
		return null;
	}
	
	public static oObject freeze(Object obj) {
		return null;
	}
	
	public static oObject getOwnPropertyDescriptor(Object obj, Object prop) {
		return null;
	}
	
	public static Set<String> getOwnPropertyNames(Object obj) {
		return null;
	}
	
	public static Set<String> getOwnPropertySymbols(Object obj) {
		return null;
	}
	
	public static Object getPrototypeOf(Object obj) {
		return null;
	}
	
	public static boolean is(Object value1, Object value2) {
		return false;
	}
	
	public static boolean isExtensible(Object obj) {
		return false;
	}
	
	public static boolean isFrozen(Object obj) {
		return false;
	}
	
	public static boolean isSealed(Object obj) {
		return false;
	}
	
	public static Set<String> keys(Object obj) {
		return null;
	}
	
	public static Object preventExtensions(Object obj) {
		return null;
	}
	
	public static Object seal(Object obj) {
		return null;
	}
	
	public static oObject setPrototypeOf(Object obj, Object prototype) {
		return null;
	}
	
	public static List<Object> values(Object obj) {
		return null;
	}
	
	/* method */
	public Constructor<?> constructor() {
		try { return this.getClass().getConstructor(); }
		catch(NoSuchMethodException e) { throw new RuntimeException(e); }
	}
	
	
	
	/**
	 * Returns a locale-specific string representing the object.
	 * @return Locale-specific string.
	 */
	public String toLocaleString() {
		return toString();
	}
	
	/**
	 * Returns the primitive value of the specified object.
	 * @return Object.
	 */
	public Object valueOf() {
		return obj;
	}
	
	
	/* super method */
	// TODO: circular check parameter
	@Override
	public String toString() {
		return null;
	}
}
