package js.lang.object;
import js.lang.coll.map.iMap;
import java.util.*;

/**
 * Defines an access-controlled map where not all keys are enumerable.
 * @param <K> Datatype of key.
 * @param <V> Datatype of value.
 */
public interface iEnumMap<K, V> extends iMap<K, V> {
	
	/* method */
	/**
	 * Returns a key set containing all keys of this object, including those which
	 * are not enumerable.
	 * @return Key set of all keys.
	 */
	Set<K> keySetAll();
	
	
	/* super method */
	/**
	 * Returns a key set containing only the enumerable keys of this object.
	 * @return Key set of enumerable keys.
	 */
	@Override
	Set<K> keySet();
}
