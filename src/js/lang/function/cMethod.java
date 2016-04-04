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
	/** Array defining all iConsumer method signatures in order of input parameters */
	private static final MethodType[] CONSUMER_SIGNATURE = new MethodType[] {
		iConsumer0.SIGNATURE, iConsumer1.SIGNATURE, iConsumer2.SIGNATURE, iConsumer3.SIGNATURE,
		iConsumer4.SIGNATURE, iConsumer5.SIGNATURE, iConsumer6.SIGNATURE, iConsumer7.SIGNATURE
	};
	/** Array defining all iFunction method signatures in order of input parameters */
	private static final MethodType[] FUNCTION_SIGNATURE = new MethodType[] {
		iFunction0.SIGNATURE, iFunction1.SIGNATURE, iFunction2.SIGNATURE, iFunction3.SIGNATURE,
		iFunction4.SIGNATURE, iFunction5.SIGNATURE, iFunction6.SIGNATURE, iFunction7.SIGNATURE
	};
	
	
	/* data */
	protected final iMethod mthd;
	private final String name;
	
	/* constructor */
	public cMethod(iMethod method) {
		mthd = method;
		name = method.name();
	}
	public cMethod(Object obj, Class cls, String method, Class... types) throws Throwable {
		Method m = cls.getMethod(method, types);
		int nArg = m.getParameterCount();
		Class tRet = m.getReturnType();
		Class dCls = tRet==void.class? CONSUMER_INTERFACE[nArg] : FUNCTION_INTERFACE[nArg];
		MethodType sSig = MethodType.methodType(tRet, m.getParameterTypes());
		MethodType dSig = tRet==void.class? CONSUMER_SIGNATURE[nArg] : FUNCTION_SIGNATURE[nArg];
		String dMthd = tRet==void.class? iConsumer.NAME : iFunction.NAME;
		boolean isstatic = Modifier.isStatic(m.getModifiers());
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodType dType = obj==null? MethodType.methodType(dCls) : MethodType.methodType(dCls, cls);
		MethodHandle factory = LambdaMetafactory.metafactory(lookup, dMthd, dType, dSig, lookup.unreflect(m), sSig).getTarget();
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
		return name;
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
