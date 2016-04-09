package js.lang.object;
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
		Field f = (Field)super.get(k);
		try { return k!=null? f.get(value) : null; }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	@Override
	public Object put(String k, Object v) {
		Field f = (Field)super.get(k);
		try { if(f!=null) { f.set(value, v); return v; } return null;  }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	
	/* super method */
	@Override
	public void clear() {
	}
	
	@Override
	public Set<Entry<String, Object>> entrySet() {
		Set<Entry<String, Object>> o = new HashSet<>();
		for(String k : super.keySet())
			o.add(new SimpleEntry<>(k, get(k)));
		return o;
	}
}
