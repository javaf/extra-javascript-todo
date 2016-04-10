package js.lang.object;
import java.util.*;
import js.lang.coll.*;


/**
 * Defines a prototypal and access-controlled map implementation.
 * @param <K> Datatype of the key.
 * @param <V> Datatype of the value.
 */
public class cProtoMap<K, V> implements iObject<K, V>, iMap<K, V> {
	
	/* data */
	/** Defines the prototype of this object. */
	protected iObject prototype;
	/** Tells whether this object is extensible. */
	protected boolean extensible;
	/** Describes the state of properties. */
	protected final Map<K, cAccess> descriptor;
	/** Stores the actual map values. */
	protected final Map value;
	
	
	/* constructor */
	/**
	 * Creates a new object value.
	 * @param v Object value.
	 */
	public cProtoMap(Object v) {
		descriptor = new HashMap<>();
		value = v instanceof Map? (Map)v : new cObject(v);
	}
	
	
	/* static method */
	
	/* method */
	/**
	 * Checks if object data is locked upto a certain level.
	 * @param l Lock level (0: unlock, 1: preventExtensions, 2: seal, 3: freeze)
	 */
	protected final boolean isLocked(int l) {
		if(l>0 && extensible) return false;
		if(l>1 && size()>descriptor.size()) return false;
		if(l>1) for(cAccess d : descriptor.values())
			if(d.configurable || (l>2 && d.isData() && d.writeable)) return false;
		return true;
	}
	
	/**
	 * Locks or unlocks this object data.
	 * @param l Lock level (0: unlock, 1: preventExtensions, 2: seal, 3: freeze)
	 */
	protected final void lock(int l) {
		extensible = l>0;
		for(K key : keySet()) {
			cAccess d = descriptor.get(key);
			if(d!=null) { d.configurable = l<2; if(d.isData()) d.writeable = l>0? (l<3? d.writeable : false) : true; }
			else if(l>1) descriptor.put(key, new cAccess(false, true, l<3, null, null, null));
		}
	}
	
	
	/* super method */
	@Override
	public iObject prototype() {
		return prototype;
	}

	@Override
	public iObject prototype(iObject prototype) {
		return this.prototype=prototype;
	}

	@Override
	public V get(Object key) {
		cAccess d = descriptor.get(key);
		if(d!=null && !d.isData()) return d.get!=null? (V)d.get.get() : null;
		return value.containsKey(key)? (V)value.get(key) : (prototype!=null? (V)prototype.get(key) : null);
	}

	@Override
	public V put(K key, V value) {
		cAccess desc = descriptor.get(key);
		if(desc==null) return !this.value.containsKey(key) && prototype!=null && prototype.containsKey((String)key)?	(V)prototype.put((String)key, (V)value) : (V)this.value.put((Object)key, value);
		if(desc.isData()) { if(desc.writeable) return (V)this.value.put(key, value); }
		else if(desc.set!=null) desc.set.accept(value);
		return null;
	}

	@Override
	public V remove(Object key) {
		boolean hasd = descriptor.containsKey((K)key);
		if(!containsKey((K)key) || hasd && !descriptor.get((K)key).configurable) return null;
		if(hasd) descriptor.remove(key);
		return (V)value.remove(key);
	}

	@Override
	public Set<K> keySet() {
		if(prototype==null) return value.keySet();
		Set<K> s = prototype.keySet();
		s.addAll(value.keySet());
		return s;
	}
}
