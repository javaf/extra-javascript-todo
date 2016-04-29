package js.lang.object;
import js.lang.coll.map.iEnumMap;
import java.lang.reflect.*;
import java.util.*;
import js.lang.function.*;

/**
 * Defines a map interface for a object of normal or access-controlled class.
 * @author wolfram77
 */
public class cObjMap implements iEnumMap<String, Object> {
	
	/* data */
	/** Object that is reflectively connected to this map. */
	private final Object value;
	/** Contains all properties which are enumerable. */
	private final Set<String> enumerable;
	/** Contains connected fields and methods to given object. */
	private final Map<String, iProc[]> map;
	
	
	/* constructor */
	/**
	 * Creates a map interface for specified normal or access-controlled class object.
	 * @param v Object whose map interface is to be created.
	 */
	public cObjMap(Object v) {
		map = new HashMap<>();
		enumerable = new HashSet<>();
		Class<?> c = v.getClass();
		aAccess a = c.getAnnotation(aAccess.class);
		boolean enu = a!=null && a.enumerable();
		for(Field f : c.getFields())
			_addField(enu, f);
		for(Method m : c.getMethods())
			_addMethod(m);
		value = v;
	}
	
	
	/* super property */
	@Override
	public final Object get(Object k) {
		iProc[] o = map.get(k);
		return o==null && o[0]==null? null : o[0].call();
	}
	
	@Override
	public final Object put(String k, Object v) {
		iProc[] o = map.get(k);
		return o==null && o[0]==null? null : o[1].call(v);
	}
	
	
	/* method */
	/**
	 * Add an access-class field.
	 * @param f The field to add.
	 */
	private void _addField(boolean enu, Field f) {
		aAccess a = f.getAnnotation(aAccess.class);
		if(!enu && a==null) return;
		a = a==null? aAccess.DEFAULT : a;
		if(a.value().length()==0) return;
		String name = a.value().replace(".", f.getName());
		if(a.enumerable()) enumerable.add(name);
		iProc[] v = map.get(name);
		v = v==null? new iProc[2] : v;
		if(a.writable()) v[1] = new cSetterProc(f, value).valueOf();
		v[0] = new cGetterProc(f, value).valueOf();
		map.put(name, v);
	}
	/**
	 * Add an access-class method.
	 * @param o Object of this class.
	 * @param c This class.
	 * @param m Method to add.
	 */
	private void _addMethod(Method m) {
		int ps = m.getParameterCount();
		aAccess a = m.getAnnotation(aAccess.class);
		if(ps>1 || a==null || a.value().length()==0) return;
		String name = a.value().replace(".", m.getName());
		iProc[] v = map.get(name);
		v = v==null? new iProc[2] : v;
		if(a.enumerable()) enumerable.add(name);
		v[ps] = new cMethodProc(m, value).valueOf();
		map.put(name, v);
	}
	
	
	/* super method */
	@Override
	public final Set<String> keySetAll() {
		return map.keySet();
	}
	
	@Override
	public final Set<String> keySet() {
		return enumerable;
	}
	
	@Override
	public final Object remove(Object v) {
		return null;
	}
	
	@Override
	public final void clear() {
	}
}
