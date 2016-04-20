package js.lang.function;
import js.lang.code.compile.*;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a method which can be called.
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
	/** Indicates the number of dynamically generated classes. */
	public static long classNumber;
	
	
	/* data */
	/** Object implementing iMethod interface which can be called. */
	private final iMethod imethod;
	/** MethodHandle methodHandle that can be used to generate iMethod object. */
	private final MethodHandle handle;
	
	
	/* constructor */
	/**
	 * Create a callable Method object from object implementing iMethod interface.
	 * @param m iMethod implementing object.
	 */
	public cMethod(iMethod m) {
		imethod = m;
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
			if(set) imethod = (iConsumer1)(v) -> { try { handle.invokeExact(v); } catch(Throwable e) { throw new RuntimeException(e); } };
			else imethod = (iFunction0)() -> { try { return handle.invokeExact(); } catch(Throwable e) { throw new RuntimeException(e); } };
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
			imethod = Modifier.isStatic(m.getModifiers()) || obj!=null? (iMethod)handle.invoke() : null;
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
		if(code.length()==0) { imethod = (Object... a) -> null; return; }
		String className = "c"+classNumber(), content = _methodContent(className, argn, argv, code);
		try { imethod = (iMethod)cJavaMemoryCompiler.compile("js.lang.function.dynamic."+className, content).newInstance(); }
		catch(Exception e) { throw new RuntimeException(e); }
	}
	/**
	 * Direct field constructor.
	 * @param m iMethod object.
	 * @param f MethodHandle methodHandle.
	 * @param n Method name.
	 */
	private cMethod(iMethod m, MethodHandle f) {
		imethod = m;
		handle = f;
	}
	/**
	 * Copy constructor.
	 * @param o cMethod object
	 */
	protected cMethod(cMethod o) {
		imethod = o.imethod;
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
		return imethod.length();
	}
	
	@Override
	public String name() {
		return imethod.name();
	}
	
	
	/* static method */
	/**
	 * Get a method object from class and its specified name. The returned method
	 * object is obtained through reflection.
	 * @param cls Class object which contains the method.
	 * @param mn Name of the method.
	 * @param types Parameter types of the method.
	 * @return Field object.
	 */
	public final static Method method(Class<?> cls, String mn, Class<?>[] types) {
		try { return cls.getMethod(mn, types); }
		catch(NoSuchMethodException | SecurityException e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Get a field object from class and its specified name. The returned field
	 * object is obtained through reflection.
	 * @param cls Class object which contains the field.
	 * @param fn Name of the field.
	 * @return Field object.
	 */
	public final static Field field(Class<?> cls, String fn) {
		try { return cls.getField(fn); }
		catch(NoSuchFieldException | SecurityException e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Get Lambda function factory from specified method handle. Invoking the returned
	 * factory with object yields an iMethod object which can be directly called.
	 * @param o Object which the interface object is to be bound to (can be null).
	 * @param m Reflected method object.
	 * @return Method handle factory.
	 * @throws LambdaConversionException When conversion to iMethod fails.
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
		String dMthd = tRet==void.class? iConsumer.NAME : iFunction.NAME;
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
		s.append("public ").append(isvoid? "void "+iConsumer.NAME : "Object "+iFunction.NAME).append("(");
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
			return new cMethod((iMethod)fctry.invoke(), fctry);
		}
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Calls a function with a given this value and arguments provided
	 * individually.
	 * @param thisArg The value of this provided for the call to function.
	 * @param args Arguments for the object.
	 * @return Return value of function.
	 */
	public final Object call(Object thisArg, Object... args) {
		return thisArg!=null? bind(thisArg).run(args) : run(args);
	}
	
	
	/* super method */
	@Override
	public final Object run(Object... args) {
		return imethod.run(args);
	}
	
	@Override
	public final String ztoString() {
		return imethod.ztoString();
	}
	
	@Override
	public final String toString() {
		return ztoString();
	}
	
	// TODO:
	public final Object valueOf() {
		return imethod;
	}
}
