package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a method which can be called.
 * @param <TR> Return type of method.
 */
public class cMethodProc<TR> implements iProc<TR> {
	
	/* static data */
	/** Array defining all iSub interfaces in order of input parameters */
	private static final Class<?>[] SUB_CLASS = new Class<?>[] {
		iSub0.class, iSub1.class, iSub2.class, iSub3.class,
		iSub4.class, iSub5.class, iSub6.class, iSub7.class
	};
	/** Array defining all iFn interfaces in order of input parameters */
	private static final Class<?>[] FN_CLASS = new Class<?>[] {
		iFn0.class, iFn1.class, iFn2.class, iFn3.class,
		iFn4.class, iFn5.class, iFn6.class, iFn7.class
	};
	
	
	/* data */
	/** Defines the method call procedure for the specified method. */
	private final iProc proc;
	
	
	/* constructor */
	/**
	 * Creates method call procedure for specified method. If the passed method is
	 * static or it is an instance method and the passed object is not null, then
	 * a bound procedure is returned which the same generic signature as the original
	 * method. However, if the passed method is an instance method and the passed
	 * object is null, then an unbound procedure is returned which takes the object
	 * to which the field belongs as the 1st parameter and the remaining parameters
	 * are the same as the original function.
	 * @param m Reflected method.
	 * @param obj Object to which the method belongs. Can be null.
	 */
	public cMethodProc(Method m, Object obj) {
		try {
			MethodHandles.Lookup l = MethodHandles.lookup();
			MethodHandle fctry, mh = l.unreflect(m);
			boolean stc = Modifier.isStatic(m.getModifiers());
			boolean ret = m.getReturnType()==void.class;
			int n = m.getParameterCount() + (!stc && obj==null? 1 : 0);
			Class<?> dCls = ret? FN_CLASS[n] : SUB_CLASS[n];
			MethodType dType = stc || obj==null? MethodType.methodType(dCls) : MethodType.methodType(dCls, m.getClass());
			fctry = LambdaMetafactory.metafactory(l, ret? "apply" : "accept", dType, iProc.type(ret, n), mh, mh.type()).getTarget();
			proc = (iProc)(stc || obj==null? fctry.invoke() : fctry.invoke(obj));
		}
		catch(Throwable e) { throw new RuntimeException(e); }
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
