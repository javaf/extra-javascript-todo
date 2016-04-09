package js.lang.object;
import java.lang.reflect.*;
import java.util.*;

/*

*/
public class oObject<K, V> {
	
	/* property */
	public V get(K prop) {
		return null;
	}
	public V set(K prop, V value) {
		return null;
	}
	
	public oObject prototype() {
		return null;
	}
	public oObject prototype(Object obj) {
		return null;
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
	
	public static Object setPrototypeOf(Object obj, Object prototype) {
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
}
