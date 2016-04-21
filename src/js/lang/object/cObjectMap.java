package js.lang.object;
import java.lang.reflect.*;
import java.util.AbstractMap.*;
import java.util.*;
import js.lang.function.*;
import js.lang.coll.*;

/**
 * Defines a map interface for a object of normal or access-controlled class.
 * @author wolfram77
 */
public class cObjectMap implements iMap<String, Object> {
	
	/* data */
	/** Object that is reflectively connected to this map. */
	private final Object value;
	/** Contains all properties which are enumerable. */
	private final Set<String> enumerable;
	/** Contains connected fields and methods to given object. */
	private final Map<String, Object[]> map;
	
	
	/* constructor */
	public cObjectMap(Object v) {
		map = new HashMap<>();
		enumerable = new HashSet<>();
		Class<?> c = v.getClass();
		aAccess a = c.getAnnotation(aAccess.class);
		boolean enu = a!=null && a.enumerable();
		for(Field f : c.getFields())
			_addField(enu, f);
		for(Method m : c.getMethods())
			_addMethod(v, c, m);
		value = v;
	}
	
	
	/* super property */
	@Override
	public Object get(Object k) {
		Object[] o = map.get(k);
		try { return o!=null && o[0]!=null? (o[0] instanceof Field? ((Field)o[0]).get(value) : ((iMethod)o[0]).call()) : null; }
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	@Override
	public Object put(String k, Object v) {
		Object[] o = map.get(k);
		if(o==null || o[1]==null) return null;
		try {
			if(o[1] instanceof Field) ((Field)o[1]).set(value, v);
			else ((iMethod)o[1]).call(v);
			return v;
		}
		catch(IllegalArgumentException | IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	
	/* method */
	/**
	 * Add an access-class field.
	 * @param f The field to add.
	 */
	private void _addField(boolean enu, Field f) {
		aAccess a = f.getAnnotation(aAccess.class);
		a = a==null? aAccess.DEFAULT : a;
		if(enu) { if(a!=null && a.value().length()==0) return; }
		else if(a==null || a.value().length()==0) return;
		String name = (a==null? "." : a.value()).replace(".", f.getName());
		if(a==null || a.enumerable()) enumerable.add(name);
		Object[] v = map.get(name);
		v = v==null? new Object[2] : v;
		if(a==null || a.writable()) v[1] = f;
		v[0] = f;
		map.put(name, v);
	}
	/**
	 * Add an access-class method.
	 * @param o Object of this class.
	 * @param c This class.
	 * @param m Method to add.
	 */
	private void _addMethod(Object o, Class<?> c, Method m) {
		int ps = m.getParameterCount();
		aAccess a = m.getAnnotation(aAccess.class);
		if(ps>1 || a==null || a.value().length()==0) return;
		String name = a.value().replace(".", m.getName());
		Object[] v = map.get(name);
		v = v==null? new Object[2] : v;
		if(a.enumerable()) enumerable.add(name);
		v[ps] = new cMethod(o, m);
		map.put(name, v);
	}
	
	
	/* super method */
	@Override
	public void clear() {
	}
	
	@Override
	public Object remove(Object v) {
		return null;
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
