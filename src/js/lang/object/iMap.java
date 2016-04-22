package js.lang.object;
import java.util.function.*;
import java.util.*;

/**
 * Represents an easily implementable map interface.
 * @param <K> Datatype of the key.
 * @param <V> Datatype of the value.
 */
public interface iMap<K, V> extends Map<K, V> {
	
	/* super method */
	@Override
	default void clear() {
		for(K k : keySet())
			remove(k);
	}
	
	@Override
	default V compute(K k, BiFunction<? super K, ? super V, ? extends V> f) {
		return put(k, f.apply(k, get(k)));
	}
	
	@Override
	default V computeIfAbsent(K k, Function<? super K, ? extends V> f) {
		V v = get(k);
		return k==null? put(k, f.apply(k)) : v;
	}
	
	@Override
	default V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> f) {
		V v = get(k);
		return k!=null? put(k, f.apply(k, v)) : v;
	}
	
	@Override
	default boolean containsKey(Object k) {
		return keySet().contains((K)k);
	}
	
	@Override
	default boolean containsValue(Object v) {
		for(K k : keySet())
			if(get(k)==v) return true;
		return false;
	}
	
	@Override
	default Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> o = new HashSet<>();
		for(K k : keySet())
			o.add(new AbstractMap.SimpleEntry<>(k, get(k)));
		return o;
	}
	
	@Override
	default void forEach(BiConsumer<? super K, ? super V> f) {
		for(Entry<K, V> e : entrySet())
			f.accept(e.getKey(), e.getValue());
	}
	
	@Override
	default V getOrDefault(Object k, V dv) {
		V v = get((K)k);
		return v!=null? v : dv;
	}
	
	@Override
	default boolean isEmpty() {
		return size()==0;
	}
	
	@Override
	default V merge(K k, V dv, BiFunction<? super V, ? super V, ? extends V> f) {
		V v = get(k);
		return put(k, v!=null? f.apply(v, dv) : dv);
	}
	
	@Override
	default void putAll(Map<? extends K, ? extends V> m) {
		for(Entry<? extends K, ? extends V> e : m.entrySet())
			put(e.getKey(), e.getValue());
	}
	
	@Override
	default V putIfAbsent(K k, V dv) {
		V v = get(k);
		return v!=null? v : put(k, dv);
	}
	
	@Override
	default boolean remove(Object k, Object dv) {
		V v = get((K)k);
		if(v!=dv) return false;
		remove((K)k);
		return true;
	}
	
	@Override
	default V replace(K k, V v) {
		return containsKey(k)? put(k, v) : null;
	}
	
	@Override
	default boolean replace(K k, V ov, V nv) {
		V v = get(k);
		if(v!=ov) return false;
		put(k, nv);
		return true;
	}
	
	@Override
	default void replaceAll(BiFunction<? super K, ? super V, ? extends V> f) {
		for(Entry<K, V> e : entrySet())
			put(e.getKey(), f.apply(e.getKey(), e.getValue()));
	}
	
	@Override
	default int size() {
		return keySet().size();
	}
	
	@Override
	default Collection<V> values() {
		Collection<V> o = new ArrayList<>();
		for(Entry<K, V> e : entrySet())
			o.add(e.getValue());
		return o;
	}
}
