package js.lang.coll;
import java.util.function.*;
import java.util.*;

/**
 * Represents an easily extensible map implementation.
 * @param <K> Datatype of the key.
 * @param <V> Datatype of the value.
 */
public class cMap<K, V> extends HashMap<K, V> {
	
	/* super method */
	@Override
	public V compute(K k, BiFunction<? super K, ? super V, ? extends V> f) {
		return put(k, f.apply(k, get(k)));
	}
	
	@Override
	public V computeIfAbsent(K k, Function<? super K, ? extends V> f) {
		V v = get(k);
		return k==null? put(k, f.apply(k)) : v;
	}
	
	@Override
	public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> f) {
		V v = get(k);
		return k!=null? put(k, f.apply(k, v)) : v;
	}
	
	@Override
	public boolean containsValue(Object v) {
		for(K k : keySet())
			if(get(k)==v) return true;
		return false;
	}
	
	@Override
	public void forEach(BiConsumer<? super K, ? super V> f) {
		for(Entry<K, V> e : entrySet())
			f.accept(e.getKey(), e.getValue());
	}
	
	@Override
	public V getOrDefault(Object k, V dv) {
		V v = get((K)k);
		return v!=null? v : dv;
	}
	
	@Override
	public V merge(K k, V dv, BiFunction<? super V, ? super V, ? extends V> f) {
		V v = get(k);
		return put(k, v!=null? f.apply(v, dv) : dv);
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for(Entry<? extends K, ? extends V> e : m.entrySet())
			put(e.getKey(), e.getValue());
	}
	
	@Override
	public V putIfAbsent(K k, V dv) {
		V v = get(k);
		return v!=null? v : put(k, dv);
	}
	
	@Override
	public boolean remove(Object k, Object dv) {
		V v = get((K)k);
		if(v!=dv) return false;
		remove((K)k);
		return true;
	}
	
	@Override
	public V replace(K k, V v) {
		return containsKey(k)? put(k, v) : null;
	}
	
	@Override
	public boolean replace(K k, V ov, V nv) {
		V v = get(k);
		if(v!=ov) return false;
		put(k, nv);
		return true;
	}
	
	@Override
	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> f) {
		for(Entry<K, V> e : entrySet())
			put(e.getKey(), f.apply(e.getKey(), e.getValue()));
	}
	
	@Override
	public Collection<V> values() {
		Collection<V> o = new ArrayList<>();
		for(Entry<K, V> e : entrySet())
			o.add(e.getValue());
		return o;
	}
}
