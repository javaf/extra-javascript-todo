package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a method which can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TE> Input argument 5 type.
 * @param <TF> Input argument 6 type.
 * @param <TG> Input argument 7 type.
 * @param <TR> Return type. 
 */
public class cMethod implements iMethod {
	
	/* static data */
	/** Array defining all iConsumer interfaces in order of input parameters */
	private static final Class<?>[] CONSUMER_INTERFACE = new Class<?>[] {
		iConsumer0.class, iConsumer1.class, iConsumer2.class, iConsumer3.class,
		iConsumer4.class, iConsumer5.class, iConsumer6.class, iConsumer7.class
	};
	/** Array defining all iFunction interfaces in order of input parameters */
	private static final Class<?>[] FUNCTION_INTERFACE = new Class<?>[] {
		iFunction0.class, iFunction1.class, iFunction2.class, iFunction3.class,
		iFunction4.class, iFunction5.class, iFunction6.class, iFunction7.class
	};
	
	
	/* data */
	protected final iMethod mthd;
	private final String name;
	
	/* constructor */
	public cMethod(iMethod method) {
		mthd = method;
		name = null;
	}
	public cMethod(Object obj, Class cls, String method, Class... types) throws Throwable {
		Method m = cls.getMethod(method, types);
		int nArg = m.getParameterCount();
		Class tRet = m.getReturnType();
		Class cTgt = tRet==void.class? CONSUMER_INTERFACE[nArg] : FUNCTION_INTERFACE[nArg];
		String mTgt = tRet==void.class? "accept" : "apply";
		boolean isstatic = Modifier.isStatic(m.getModifiers());
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodType invType = obj==null? MethodType.methodType(cTgt) : MethodType.methodType(cTgt, cls);
		MethodType getter = MethodType.methodType(tRet, m.getParameterTypes());
		MethodHandle factory = LambdaMetafactory.metafactory(lookup, mTgt, invType, MethodType.methodType(Object.class, Object.class, Object.class), lookup.unreflect(m), getter).getTarget();
		if(!isstatic && obj!=null) factory = factory.bindTo(obj);
		mthd = (iMethod)factory.invoke();
		name = method;
	}
 	
	
	/* super property */
	@Override
	public int length() {
		return mthd.length();
	}
	
	@Override
	public String name() {
		return name!=null? name : mthd.name();
	}
	
	
	/* method */
	/**
	 * Calls a function with a given this value and arguments provided as an
	 * array.
	 * @param thisArg The value of this provided for the call to function.
	 * @param argsArray Arguments for the object.
	 * @return Return value of function.
	 */
	public Object apply(Object thisArg, Object[] argsArray) {
		return run(argsArray);
	}
	
	/**
	 * Calls a function with a given this value and arguments provided
	 * individually.
	 * @param thisArg The value of this provided for the call to function.
	 * @param args Arguments for the object.
	 * @return Return value of function.
	 */
	public Object call(Object thisArg, Object... args) {
		return run(args);
	}
	
	
	/* super method */
	@Override
	public Object run(Object... args) {
		return mthd.run(args);
	}
	
	@Override
	public String _toString() {
		return mthd._toString();
	}
	
	@Override
	public String toString() {
		return _toString();
	}
}
