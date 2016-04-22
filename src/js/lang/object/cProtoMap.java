package js.lang.object;
import java.util.*;
import js.lang.coll.*;


/**
 * Defines a prototypal and access-controlled map implementation.
 * @param <K> Datatype of the key.
 * @param <V> Datatype of the value.
 */
public class cProtoMap<K, V> implements iProtoMap<K, V>, iMap<K, V> {
	
	/* data */
	/** Defines the prototype of this object. */
	protected iProtoMap prototype;
	/** Tells whether this object is extensible. */
	protected boolean extensible;
	/** Describes the accessibility of properties. */
	protected final Map<K, cAccess> access;
	/** Stores the actual map values. */
	protected final Map value;
	/** Defines enumerable key set for this object. */
	protected final Set<K> keySet;
	
	
	/* constructor */
	/**
	 * Creates a new object value.
	 * @param v Object value.
	 */
	public cProtoMap(Map v) {
		access = new HashMap<>();
		keySet = v.keySet();
		value = v;
	}
	
	
	/* property */
	/**
	 * Set the access-control of a specific property.
	 * @param k Name of the property.
	 * @param v Access control values to change.
	 */
	public final void access(K k, Map v) {
		cAccess a = access.get(k);
		a = a!=null? a : new cAccess();
		if(a.configurable) a.set(v);
		if(!value.containsKey(k)) value.put(k, null);
		if(a.writable && a.value!=null) { value.put(k, a.value); a.value = null; }
		access.put(k, a);
		if(a.enumerable) keySet.add(k);
		else keySet.remove(k);
	}
	/**
	 * Get the access-control of a specific property.
	 * @param k Name of the property.
	 * @return Access control object.
	 */
	public final cAccess access(K k) {
		return access.get(k);
	}
	
	
	/* super property */
		@Override
	public iProtoMap prototype() {
		return prototype;
	}

	@Override
	public iProtoMap prototype(iProtoMap prototype) {
		return this.prototype=prototype;
	}

	@Override
	public V get(Object key) {
		cAccess d = access.get(key);
		if(d!=null && !d.isData()) return d.get!=null? (V)d.get.get() : null;
		return value.containsKey(key)? (V)value.get(key) : (prototype!=null? (V)prototype.get(key) : null);
	}

	@Override
	public V put(K key, V value) {
		cAccess desc = access.get(key);
		if(desc==null) return !this.value.containsKey(key) && prototype!=null && prototype.containsKey((String)key)?	(V)prototype.put((String)key, (V)value) : (V)this.value.put((Object)key, value);
		if(desc.isData()) { if(desc.writable) return (V)this.value.put(key, value); }
		else if(desc.set!=null) desc.set.accept(value);
		return null;
	}
	
	
	/* method */
	/**
	 * Checks if object data is locked upto a certain level.
	 * @param l Lock level (0: unlock, 1: preventExtensions, 2: seal, 3: freeze)
	 * @return Whether the property is locked.
	 */
	public final boolean isLocked(int l) {
		if(l>0 && extensible) return false;
		if(l>1 && size()>access.size()) return false;
		if(l>1) for(cAccess d : access.values())
			if(d.configurable || (l>2 && d.isData() && d.writable)) return false;
		return true;
	}
	
	/**
	 * Locks or unlocks this object data.
	 * @param l Lock level (0: unlock, 1: preventExtensions, 2: seal, 3: freeze)
	 */
	public final void lock(int l) {
		extensible = l>0;
		for(K key : keySet()) {
			cAccess d = access.get(key);
			if(d!=null) { d.configurable = l<2; if(d.isData()) d.writable = l>0? (l<3? d.writable : false) : true; }
			else if(l>1) access.put(key, new cAccess(false, true, l<3, null, null, null));
		}
	}
	
	
	/* super method */
	@Override
	public V remove(Object key) {
		boolean hasd = access.containsKey((K)key);
		if(!containsKey((K)key) || hasd && !access.get((K)key).configurable) return null;
		if(hasd) access.remove(key);
		return (V)value.remove(key);
	}
	
	@Override
	public Set<K> keySet() {
		if(prototype==null) return keySet;
		Set<K> s = prototype.keySet();
		s.addAll(keySet);
		return s;
	}
}
