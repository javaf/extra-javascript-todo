package js.lang.object;
import js.lang.coll.map.iEnumMap;
import java.util.*;

/**
 * Defines a map-like object.
 * @param <K> Key datatype.
 * @param <V> Value datatype.
 */
public interface iProtoMap<K, V> extends iEnumMap<K, V> {
	
	/* property */
	/**
	 * Returns the prototype of this object.
	 * @return This object's prototype.
	 */
	iProtoMap<K, V> prototype();
	
	/**
	 * Sets the prototype of this object.
	 * @param prototype This object's prototype
	 * @return This object's prototype.
	 */
	iProtoMap<K, V> prototype(iProtoMap<K, V> prototype);
	
	
	/* method */
	/**
	 * Returns a key set containing all own keys of this object, including those
	 * which are not enumerable. Own keys are those which are part of this object,
	 * not of its prototype object.
	 * @return Own key set of all keys.
	 */
	Set<K> ownKeySetAll();
	
	/**
	 * Returns a key set containing only enumerable own keys of this object. Own
	 * keys are those which are part of this object, not of its prototype object.
	 * @return Own key set of enumerable keys.
	 */
	Set<K> ownKeySet();
	
	
	/* super method */
	@Override
	default Set<K> keySetAll() {
		if(prototype()==null) return ownKeySetAll();
		Set<K> s = new HashSet<>(ownKeySetAll());
		for(iProtoMap<K, V> m=prototype(); m!=null; m=m.prototype())
			s.addAll(m.ownKeySetAll());
		return s;
	}
	
	@Override
	default Set<K> keySet() {
		if(prototype()==null) return ownKeySet();
		Set<K> s = new HashSet<>(ownKeySet());
		for(iProtoMap<K, V> m=prototype(); m!=null; m=m.prototype())
			s.addAll(m.ownKeySet());
		return s;
	}
}
