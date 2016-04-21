package js.lang.function;
import js.lang.code.compile.*;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a method which can be called.
 */
public class cMethod implements iProc {
	
	/* static data */
	/** Array defining all iSub interfaces in order of input parameters */
	private static final Class<?>[] CONSUMER_INTERFACE = new Class<?>[] {
		iSub0.class, iSub1.class, iSub2.class, iSub3.class,
		iSub4.class, iSub5.class, iSub6.class, iSub7.class
	};
	/** Array defining all iFn interfaces in order of input parameters */
	private static final Class<?>[] FUNCTION_INTERFACE = new Class<?>[] {
		iFn0.class, iFn1.class, iFn2.class, iFn3.class,
		iFn4.class, iFn5.class, iFn6.class, iFn7.class
	};
	/** Array defining all iSub method signatures in order of input parameters */
	private static final MethodType[] CONSUMER_SIGNATURE = new MethodType[] {
		iSub0.SIGNATURE, iSub1.SIGNATURE, iSub2.SIGNATURE, iSub3.SIGNATURE,
		iSub4.SIGNATURE, iSub5.SIGNATURE, iSub6.SIGNATURE, iSub7.SIGNATURE
	};
	/** Array defining all iFn method signatures in order of input parameters */
	private static final MethodType[] FUNCTION_SIGNATURE = new MethodType[] {
		iFn0.SIGNATURE, iFn1.SIGNATURE, iFn2.SIGNATURE, iFn3.SIGNATURE,
		iFn4.SIGNATURE, iFn5.SIGNATURE, iFn6.SIGNATURE, iFn7.SIGNATURE
	};
	/** Indicates the number of dynamically generated classes. */
	public static long classNumber;
	
	
	/* data */
	/** Object implementing iProc interface which can be called. */
	private final iProc method;
	/** Original method handle that can be used to generate iProc object after binding. */
	private final MethodHandle handle;
	
	
	/* constructor */
	/**
	 * Create a callable Method object from object implementing iProc interface.
	 * @param m iProc implementing object.
	 */
	public cMethod(iProc m) {
		method = m;
		handle = null;
	}
	/**
	 * Create a callable Method object from class, method name, and parameter types.
	 * @param obj Object bound to function. Can be null if method is static, or
	 * binding is to be done later using bind().
	 * @param f Field to be made callable.
	 * @param set If true, setter is used, else getter is used.
	 */
	public cMethod(Object obj, Field f, boolean set) {
		try {
			MethodHandles.Lookup l = MethodHandles.lookup();
			MethodHandle mh = set? l.unreflectSetter(f) : l.unreflectSetter(f);
			handle = Modifier.isStatic(f.getModifiers()) || obj==null? mh : mh.bindTo(obj);
			if(set) method = (iSub1)(v) -> { try { handle.invokeExact(v); } catch(Throwable e) { throw new RuntimeException(e); } };
			else method = (iFn0)() -> { try { return handle.invokeExact(); } catch(Throwable e) { throw new RuntimeException(e); } };
		}
		catch(IllegalAccessException e) { throw new RuntimeException(e); }
	}
	/**
	 * Create a callable Method object from class, method name, and parameter types.
	 * @param obj Object bound to function. Can be null if method is static, or
	 * binding is to be done later using bind().
	 * @param m Method to be made callable.
	 */
	public cMethod(Object obj, Method m) {
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
	public cMethod(int argn, String[] argv, String code) {
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
	private cMethod(iProc m, MethodHandle f) {
		method = m;
		handle = f;
	}
	/**
	 * Copy constructor.
	 * @param o cMethod object
	 */
	protected cMethod(cMethod o) {
		method = o.method;
		handle = o.handle;
	}
	
	
	/* static property */
	/**
	 * Returns number of dynamically generated classes, and increments it.
	 * @return Number of dynamically generated classes.
	 */
	private static synchronized long classNumber() {
		return classNumber++;
	}
	
	
	/* super property */
	@Override
	public int length() {
		return method.length();
	}
	
	@Override
	public String name() {
		return method.name();
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
		Class<?> dCls = tRet==void.class? CONSUMER_INTERFACE[n] : FUNCTION_INTERFACE[n];
		MethodType dSig = tRet==void.class? CONSUMER_SIGNATURE[n] : FUNCTION_SIGNATURE[n];
		String dMthd = tRet==void.class? iSub.NAME : iFn.NAME;
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
		s.append("public ").append(isvoid? "void "+iSub.NAME : "Object "+iFn.NAME).append("(");
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
	public cMethod bind(Object thisArg, Object... args) {
		try {
			MethodHandle fctry = handle.bindTo(thisArg);
			MethodHandles.insertArguments(fctry, 0, args);
			return new cMethod((iProc)fctry.invoke(), fctry);
		}
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	
	
	/* super method */
	@Override
	public final Object call(Object... args) {
		return method.call(args);
	}
	
	@Override
	public final String z_toString() {
		return method.z_toString();
	}
	
	@Override
	public final String toString() {
		return z_toString();
	}
	
	// TODO:
	public final Object valueOf() {
		return method;
	}
}
