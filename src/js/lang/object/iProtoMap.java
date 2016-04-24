package js.lang.object;
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
	iProtoMap prototype();
	
	/**
	 * Sets the prototype of this object.
	 * @param prototype This object's prototype
	 * @return This object's prototype.
	 */
	iProtoMap prototype(iProtoMap prototype);
	
	
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
}
