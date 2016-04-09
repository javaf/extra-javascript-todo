package js.lang.object;
import java.util.function.*;
import java.lang.reflect.*;
import java.util.*;
import js.lang.coll.*;

public class cObject extends cMap<String, Object> {
	
	/* data */
	/** Object that is reflectively connected to this object. */
	private final Object value;
	
	
	/* constructor */
	public cObject(Object v) {
		for(Field f : v.getClass().getFields())
			super.put(f.getName(), f);
		value = v;
	}
	
	
	/* super property */
	@Override
	public Object get(Object k) {
		try {	Field f = (Field)super.get(k); return k!=null? f.get(value) : null; }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	@Override
	public Object put(String k, Object v) {
		try { ((Field)super.get(k)).set(value, v); return v; }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	
	/* super method */
	@Override
	public void clear() {
	}
	
	@Override
	public boolean containsValue(Object v) {
		return values().contains(v);
	}
	
	@Override
	public Set<Entry<String, Object>> entrySet() {
		Set<Entry<String, Object>> o = new HashSet<>();
		for(String k : super.keySet())
			o.add(new SimpleEntry<>(k, get(k)));
		return o;
	}
	
	@Override
	public void forEach(BiConsumer<? super String, ? super Object> f) {
		for(Entry<String, Object> o : entrySet())
			f.accept(o.getKey(), o.getValue());
	}
	
	@Override
	public Object getOrDefault(Object k, Object v) {
		Object o = get(k.toString());
		return o!=null? o : v;
	}
	
	@Override
	public void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> f) {
		
	}
	
	@Override
	public Collection<Object> values() {
		Collection<Object> o = new ArrayList<>();
		for(String k : super.keySet())
			o.add(get(k));
		return o;
	}
}
