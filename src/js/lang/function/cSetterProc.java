package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a setter procedure interface for a field which can be called.
 * @param <TR> Datatype of field.
 */
public class cSetterProc<TR> implements iProc<TR> {
	
	/* data */
	/** Defines the setter procedure for the specified field. */
	private final iProc proc;
	
	
	/* constructor */
	/**
	 * Creates setter procedure for specified field. If the passed field is static
	 * or it is an instance field and the passed object is not null, then a bound
	 * procedure is returned which takes the new value for the field as the only
	 * parameter, and returns it. However, if the passed field is an instance field
	 * and the passed object is null, then an unbound procedure is returned which
	 * takes the object to which the field belongs as the 1st parameter and the new
	 * field value as 2nd parameter. It returns the new value.
	 * @param f Reflected field.
	 * @param obj Object to which the field belongs. Can be null.
	 */
	public cSetterProc(Field f, Object obj) {
		try {
			boolean stc = Modifier.isStatic(f.getModifiers());
			MethodHandle mh = MethodHandles.lookup().unreflectSetter(f);
			if(stc) proc = (iFn1)(v)->{ try { mh.invoke(v); return v; } catch(Throwable e) { throw new RuntimeException(e); } };
			else if(obj==null) proc = (iFn2)(o, v)->{ try { mh.invoke(o, v); return v; } catch(Throwable e) { throw new RuntimeException(e); } };
			else proc = (iFn1)(v)->{ try { mh.invoke(obj, v); return v; } catch(Throwable e) { throw new RuntimeException(e); } };
		}
		catch(IllegalAccessException e) { throw new RuntimeException(e); }
	}
	
	
	/* super property */
	@Override
	public final MethodType type() {
		return proc.type();
	}
	
	
	/* super method */
	@Override
	public final TR call(Object... a) {
		return (TR)proc.call(a);
	}
	
	@Override
	public final iProc valueOf() {
		return proc;
	}
	
	@Override
	public final String z_toString() {
		return proc.z_toString();
	}
	
	@Override
	public final String toString() {
		return z_toString();
	}
}
