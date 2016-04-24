package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a getter procedure interface for a field which can be called.
 * @param <TR> Datatype of field.
 */
public class cGetterProc<TR> implements iProc<TR> {
	
	/* data */
	/** Defines the getter procedure for the specified field. */
	private final iProc proc;
	
	
	/* constructor */
	/**
	 * Creates getter procedure for specified field. If the passed field is static
	 * or it is an instance field and the passed object is not null, then a bound
	 * procedure is returned which takes no parameters and returns the value of the
	 * field. However, if the passed field is an instance field and the passed object
	 * is null, then an unbound procedure is returned which takes the object to which
	 * the field belongs as the only parameter.
	 * @param f Reflected field.
	 * @param obj Object to which the field belongs. Can be null.
	 */
	public cGetterProc(Field f, Object obj) {
		try {
			boolean stc = Modifier.isStatic(f.getModifiers());
			MethodHandle mh = MethodHandles.lookup().unreflectGetter(f);
			if(stc) proc = (iFn0)()->{ try { return mh.invoke(); } catch(Throwable e) { throw new RuntimeException(e); } };
			else if(obj==null) proc = (iFn1)(o)->{ try { return mh.invoke(o); } catch(Throwable e) { throw new RuntimeException(e); } };
			else proc = (iFn0)()->{ try { return mh.invoke(obj); } catch(Throwable e) { throw new RuntimeException(e); } };
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
