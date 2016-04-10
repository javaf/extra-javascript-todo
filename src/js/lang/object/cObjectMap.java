package js.lang.object;
import java.lang.reflect.*;
import java.util.*;
import js.lang.function.*;
import js.lang.coll.*;

/**
 * Defines a map interface for a object of normal or access-controlled class.
 * @author wolfram77
 */
public class cObjectMap extends cMap<String, Object> {
	
	/* data */
	/** Object that is reflectively connected to this object. */
	private final Object value;
	/** Contains all properties which are enumerable. */
	private final Set<String> enumerable;
	/** Contains all properties which are writable. */
	private final Set<String> writable;
	
	
	/* constructor */
	public cObjectMap(Object v) {
		enumerable = new HashSet<>();
		writable = new HashSet<>();
		Class<?> c = v.getClass();
		boolean norm = c.getAnnotation(aAccess.class)==null;
		for(Field f : c.getFields())
			if(norm) _normField(f); else _accField(f);
		if(!norm) for(Method m : c.getMethods())
			_accMethod(v, c, m);
		value = v;
	}
	
	
	/* super property */
	@Override
	public Object get(Object k) {
		Object o = super.get(k);
		if(o==null) return null;
		try { if(o instanceof Field) return ((Field)o).get(value); }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
		cMethod[] m = (cMethod[])o;
		return m[0]!=null? m[0].run() : null;
	}
	
	@Override
	public Object put(String k, Object v) {
		Object o = super.get(k);
		if(o==null || !writable.contains(k)) return null;
		try { if(o instanceof Field) { ((Field)o).set(value, v); return v; } }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
		cMethod[] m = (cMethod[])o;
		if(m[1]!=null) { m[1].run(v); return v; }
		return null;
	}
	
	
	/* static method */
	/**
	 * Add a normal-class field.
	 * @param f The field to add.
	 */
	private void _normField(Field f) {
		enumerable.add(f.getName());
		writable.add(f.getName());
		super.put(f.getName(), f);
	}
	/**
	 * Add a access-class field.
	 * @param f The field to add.
	 */
	private void _accField(Field f) {
		aAccess a = f.getAnnotation(aAccess.class);
		if(a==null) return;
		if(a.enumerable()) enumerable.add(f.getName());
		if(a.writeable()) writable.add(f.getName());
		super.put(f.getName(), f);
	}
	/**
	 * Add a access-class method.
	 * @param o Object of this class.
	 * @param c This class.
	 * @param m Method to add.
	 */
	private void _accMethod(Object o, Class<?> c, Method m) {
		int ps = m.getParameterCount();
		Object v = super.get(m.getName());
		aAccess a = m.getAnnotation(aAccess.class);
		if(a==null || (v!=null && !(v instanceof cMethod[])) || ps>1) return;
		if(a.enumerable()) enumerable.add(m.getName());
		if(a.writeable()) writable.add(m.getName());
		cMethod mt = new cMethod(o, c, m);
		cMethod[] mts = (cMethod[])v;
		mts = mts!=null? mts : new cMethod[2];
		mts[ps] = mt;
	}
	
	
	/* super method */
	@Override
	public void clear() {
	}
	
	@Override
	public Set<Entry<String, Object>> entrySet() {
		Set<Entry<String, Object>> o = new HashSet<>();
		for(String k : enumerable)
			o.add(new SimpleEntry<>(k, get(k)));
		return o;
	}
	
	@Override
	public Set<String> keySet() {
		return new HashSet<>(enumerable);
	}
}
