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
	 * Create a callable Method object from class, method name, and parameter types.
	 * @param obj Object bound to function. Can be null if method is static, or
	 * binding is to be done later using bind().
	 * @param m Method to be made callable.
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
	public MethodType type() {
		return proc.type();
	}
	
	
	/* super method */
	@Override
	public final TR call(Object... a) {
		return (TR)proc.call(a);
	}
	
	@Override
	public final String z_toString() {
		return proc.z_toString();
	}
	
	@Override
	public final String toString() {
		return z_toString();
	}
	
	@Override
	public final Object valueOf() {
		return proc;
	}
}
