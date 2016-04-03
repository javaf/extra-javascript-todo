package js.core;
import java.util.*;

/**
 * The Map object is a simple key/value map. Any value (both objects and
 * primitive values) may be used as either a key or a value.
 * @param <T> Optional. Value type of Map. Key type is always String.
 */
public class oMap<T> extends HashMap<String, T> implements Iterable<String> {
	
	/**
	 * Creates a new Map from an iterable object.
	 * @param iterable Iterable object.
	 */
	public oMap(Iterable<Entry<String, T>> iterable) {
		for(Entry<String, T> e : iterable)
			super.put(e.getKey(), e.getValue());
	}
	/**
	 * Creates a new Map from a map object.
	 * @param map Existing map object.
	 */
	public oMap(Map map) {
		super(map);
	}
	/**
	 * Creates a new Map from an iterable object.
	 */
	public oMap() {
	}
	
	/**
	 * Removes any value associated to the key.
	 * @param key Name of key, whose associated value to delete.
	 * @return Value that Map.prototype.has(key) would have previously returned.
	 * Map.prototype.has(key) will return false afterwards.
	 */
	public final boolean delete(String key) {
		boolean has = super.containsKey(key);
		super.remove(key);
		return has;
	}
	
	/**
	 * Returns an iterable set of key-value pairs.
	 * @return Iterator object that contains an array of [key, value] for each
	 * element in the Map object in insertion order.
	 */
	public final Set<Entry<String, T>> entries() {
		return super.entrySet();
	}
	
	/**
	 * Returns a boolean asserting whether a value has been associated to the key
	 * in the Map object or not.
	 * @param key The key to look for in the Map.
	 * @return Whether the key-value pair exists in Map.
	 */
	public final boolean has(String key) {
		return super.containsKey(key);
	}
	
	/**
	 * Sets the value for the key in the Map object. Returns the Map object.
	 * @param key Name of key for the value.
	 * @param value Value to associate key.
	 * @return This Map object.
	 */
	public final oMap set(String key, T value) {
		super.put(key, value);
		return this;
	}
	
	/**
	 * Returns a new Iterator object that contains an array of [key, value] for
	 * each element in the Map object in insertion order.
	 * @return Key-value pairs in insertion order.
	 */
	@Override
	public final Iterator<String> iterator() {
		return super.keySet().iterator();
	}
}
