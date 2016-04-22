package js.lang.function;
import js.lang.code.compile.*;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a method which can be called.
 * @param <TR> Return type of method.
 */
public class cStrMethodProc<TR> implements iProc<TR> {
	
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
	/** Array defining all iSub method signatures in order of input parameters */
	private static final MethodType[] SUB_TYPE = new MethodType[] {
		iSub0.TYPE, iSub1.TYPE, iSub2.TYPE, iSub3.TYPE,
		iSub4.TYPE, iSub5.TYPE, iSub6.TYPE, iSub7.TYPE
	};
	/** Array defining all iFn method signatures in order of input parameters */
	private static final MethodType[] FN_TYPE = new MethodType[] {
		iFn0.TYPE, iFn1.TYPE, iFn2.TYPE, iFn3.TYPE,
		iFn4.TYPE, iFn5.TYPE, iFn6.TYPE, iFn7.TYPE
	};
	/** Indicates the number of dynamically generated classes. */
	private static long classNo;
	
	
	/* data */
	/** Object implementing iProc interface which can be called. */
	private final iProc method;
	/** Original method handle that can be used to generate iProc object after binding. */
	private final MethodHandle handle;
	
	
	/* constructor */
	/**
	 * Create a callable Method object from class, method name, and parameter types.
	 * @param obj Object bound to function. Can be null if method is static, or
	 * binding is to be done later using bind().
	 * @param m Method to be made callable.
	 */
	public cStrMethodProc(Method m, Object obj) {
		try {
			handle = _factory(obj, m);
			method = Modifier.isStatic(m.getModifiers()) || obj!=null? (iProc)handle.invoke() : null;
		}
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	/**
	 * Creates a callable oFunction object from a String specification of the function.
	 * @param argn Number of arguments to the function.
	 * @param argv Names to be used by the function as formal argument names. Each must
	 * be a string that corresponds to a valid Java identifier or a list of such strings
	 * separated with a comma; for example "x", "theValue", or "a,b".
	 * @param code A string containing the Java statements comprising the function definition.
	 */
	public cStrMethodProc(int argn, String[] argv, String code) {
		handle = null;
		if(code.length()==0) { method = (Object... a) -> null; return; }
		String className = "c"+classNumber(), content = _methodContent(className, argn, argv, code);
		try { method = (iProc)cJavaMemoryCompiler.compile("js.lang.function.dynamic."+className, content).newInstance(); }
		catch(Exception e) { throw new RuntimeException(e); }
	}
	/**
	 * Direct field constructor.
	 * @param m iProc object.
	 * @param f MethodHandle methodHandle.
	 * @param n Method name.
	 */
	private cStrMethodProc(iProc m, MethodHandle f) {
		method = m;
		handle = f;
	}
	/**
	 * Copy constructor.
	 * @param o cMethod object
	 */
	protected cStrMethodProc(cStrMethodProc o) {
		method = o.method;
		handle = o.handle;
	}
	
	
	/* static property */
	/**
	 * Returns number of dynamically generated classes, and increments it.
	 * @return Number of dynamically generated classes.
	 */
	private static synchronized long classNumber() {
		return classNo++;
	}
	
	
	/* super property */
	@Override
	public MethodType type() {
		return method.type();
	}
	
	
	/* static method */
	/**
	 * Get a method object from class and its specified name. The returned method
	 * object is obtained through reflection.
	 * @param clazz Class object which contains the method.
	 * @param method Name of the method.
	 * @param parameterTypes Parameter types of the method.
	 * @return Field object.
	 */
	public final static Method method(Class<?> clazz, String method, Class<?>[] parameterTypes) {
		try { return clazz.getMethod(method, parameterTypes); }
		catch(NoSuchMethodException | SecurityException e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Get a field object from class and its specified name. The returned field
	 * object is obtained through reflection.
	 * @param clazz Class object which contains the field.
	 * @param field Name of the field.
	 * @return Field object.
	 */
	public final static Field field(Class<?> clazz, String field) {
		try { return clazz.getField(field); }
		catch(NoSuchFieldException | SecurityException e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Get Lambda function factory from specified method handle. Invoking the returned
 factory with object yields an iProc object which can be directly called.
	 * @param o Object which the interface object is to be bound to (can be null).
	 * @param m Reflected method object.
	 * @return Method handle factory.
	 * @throws LambdaConversionException When conversion to iProc fails.
	 * @throws IllegalAccessException When method is not accessible.
	 */
	private static MethodHandle _factory(Object o, Method m) throws LambdaConversionException, IllegalAccessException {
		int n = m.getParameterCount();
		Class<?> tRet = m.getReturnType();
		MethodHandles.Lookup l = MethodHandles.lookup();
		boolean stc = Modifier.isStatic(m.getModifiers());
		MethodType sSig = MethodType.methodType(tRet, m.getParameterTypes());
		Class<?> dCls = tRet==void.class? SUB_CLASS[n] : FN_CLASS[n];
		MethodType dSig = tRet==void.class? SUB_TYPE[n] : FN_TYPE[n];
		String dMthd = tRet==void.class? "accept" : "apply";
		MethodType dType = stc? MethodType.methodType(dCls) : MethodType.methodType(dCls, m.getClass());
		MethodHandle fctry = LambdaMetafactory.metafactory(l, dMthd, dType, dSig, l.unreflect(m), sSig).getTarget();
		return !stc && o!=null? fctry.bindTo(o) : fctry;
	}
	
	/**
	 * Generated dynamic function code from given class name, function arguments and code
	 * @param className Name of the class.
	 * @param args Function arguments (without type), and code (last).
	 * @return Generated function code.
	 */
	private static String _methodContent(String className, int argn, String[] argv, String code) {
		boolean isvoid = !code.contains("return") || code.replace(" ", "").contains("return;");
		StringBuilder s = new StringBuilder("package js.lang.function.dynamic;");
		s.append("public class ").append(className).append(" implements js.lang.function.");
		s.append(isvoid? "iConsumer" : "iFunction").append(argn).append(" {");
		s.append("public ").append(isvoid? "void accept(" : "Object apply(");
		for(int i=0; i<argn; i++)
			s.append("Object ").append(argv[i]).append(", ");
		if(argn>0) s.delete(s.length()-2, s.length());
		s.append(") {").append(code).append("} }");
		return s.toString();
	}
	
	
	/* method */
	/**
	 * Calls a function with a given this value and arguments provided as an
	 * array.
	 * @param thisArg The value of this provided for the call to function.
	 * @param argsArray Arguments for the object.
	 * @return Return value of function.
	 */
	public final Object apply(Object thisArg, Object[] argsArray) {
		return call(thisArg, argsArray);
	}
	
	/**
	 * Creates a new function that, when called, has its "this" set to the
	 * provided value, with a given sequence of arguments preceding any provided
	 * when the new function is called.
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param args Arguments to prepend to arguments provided to the bound
	 * function when invoking the target function.
	 * @return Function with bound "this" and any arguments.
	 */
	public cStrMethodProc bind(Object thisArg, Object... args) {
		try {
			MethodHandle fctry = handle.bindTo(thisArg);
			MethodHandles.insertArguments(fctry, 0, args);
			return new cStrMethodProc((iProc)fctry.invoke(), fctry);
		}
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	
	
	/* super method */
	@Override
	public final TR call(Object... a) {
		return (TR)method.call(a);
	}
	
	@Override
	public final String z_toString() {
		return method.z_toString();
	}
	
	@Override
	public final String toString() {
		return z_toString();
	}
	
	@Override
	public final Object valueOf() {
		return method;
	}
}
