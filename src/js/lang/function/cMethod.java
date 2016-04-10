package js.lang.function;
import js.lang.code.compile.*;
import java.lang.reflect.*;
import java.lang.invoke.*;
import js.lang.error.*;

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
	private final iMethod method;
	/** MethodHandle factory that can be used to generate iMethod object. */
	private final MethodHandle factory;
	/** Name of the callable method. */
	private final String name;
	
	
	/* constructor */
	/**
	 * Create a callable Method object from object implementing iMethod interface.
	 * @param m iMethod implementing object.
	 */
	public cMethod(iMethod m) {
		method = m;
		factory = null;
		name = m.name();
	}
	/**
	 * Create a callable Method object from class, method name, and parameter types.
	 * @param obj Object bound to function. Can be null if method is static, or
	 * binding is to be done later using bind().
	 * @param cls Class which contains the method.
	 * @param mthd Name of the method.
	 * @param types Parameter types of the method.
	 */
	public cMethod(Object obj, Class<?> cls, String mthd, Class<?>... types) {
		try {
			Method m = cls.getMethod(mthd, types);
			int nArg = m.getParameterCount();
			Class<?> tRet = m.getReturnType();
			Class<?> dCls = tRet==void.class? CONSUMER_INTERFACE[nArg] : FUNCTION_INTERFACE[nArg];
			MethodType sSig = MethodType.methodType(tRet, m.getParameterTypes());
			MethodType dSig = tRet==void.class? CONSUMER_SIGNATURE[nArg] : FUNCTION_SIGNATURE[nArg];
			String dMthd = tRet==void.class? iConsumer.NAME : iFunction.NAME;
			boolean isstatic = Modifier.isStatic(m.getModifiers());
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			MethodType dType = isstatic? MethodType.methodType(dCls) : MethodType.methodType(dCls, cls);
			MethodHandle fctry = LambdaMetafactory.metafactory(lookup, dMthd, dType, dSig, lookup.unreflect(m), sSig).getTarget();
			factory = !isstatic && obj!=null? fctry.bindTo(obj) : fctry;
			method = isstatic || obj!=null? (iMethod)factory.invoke() : null;
			name = mthd;
		}
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	public cMethod(Object obj, Class<?> cls, Method m) {
		try {
			int nArg = m.getParameterCount();
			Class<?> tRet = m.getReturnType();
			Class<?> dCls = tRet==void.class? CONSUMER_INTERFACE[nArg] : FUNCTION_INTERFACE[nArg];
			MethodType sSig = MethodType.methodType(tRet, m.getParameterTypes());
			MethodType dSig = tRet==void.class? CONSUMER_SIGNATURE[nArg] : FUNCTION_SIGNATURE[nArg];
			String dMthd = tRet==void.class? iConsumer.NAME : iFunction.NAME;
			boolean isstatic = Modifier.isStatic(m.getModifiers());
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			MethodType dType = isstatic? MethodType.methodType(dCls) : MethodType.methodType(dCls, cls);
			MethodHandle fctry = LambdaMetafactory.metafactory(lookup, dMthd, dType, dSig, lookup.unreflect(m), sSig).getTarget();
			factory = !isstatic && obj!=null? fctry.bindTo(obj) : fctry;
			method = isstatic || obj!=null? (iMethod)factory.invoke() : null;
			name = m.getName();
		}
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	/**
	 * Creates a callable oFunction object from a String specification of the function.
	 * @param args Names to be used by the function as formal argument names.
	 * Each must be a string that corresponds to a valid Java identifier or a
	 * list of such strings separated with a comma; for example "x", "theValue",
	 * or "a,b". The last argument should be a string containing the Java
	 * statements comprising the function definition.
	 */
	public cMethod(String... args) {
		name = "";
		factory = null;
		if(args.length==0) { method = (Object... a) -> null; return; }
		String code = args[args.length-1], className = "c"+classNumber();
		boolean isvoid = !code.contains("return") || code.replace(" ", "").contains("return;");
		StringBuilder s = new StringBuilder("package js.lang.function.dynamic;");
		s.append("public class ").append(className).append(" implements js.lang.function.");
		s.append(isvoid? "iConsumer" : "iFunction").append(args.length-1).append(" {");
		s.append("public ").append(isvoid? "void "+iConsumer.NAME : "Object "+iFunction.NAME).append("(");
		for(int i=0; i<args.length-1; i++)
			s.append("Object ").append(args[i]).append(", ");
		if(args.length>1) s.delete(s.length()-2, s.length());
		s.append(") {").append(code).append("} }");
		System.out.println(s);
		try { method = (iMethod)cJavaMemoryCompiler.compile("js.lang.function.dynamic."+className, s.toString()).newInstance(); }
		catch(Exception e) { throw new RuntimeException(e); }
	}
	/**
	 * Internal. Direct field constructor.
	 * @param m iMethod object.
	 * @param f MethodHandle factory.
	 * @param n Method name.
	 */
	private cMethod(iMethod m, MethodHandle f, String n) {
		method = m;
		factory = f;
		name = n;
	}
	/**
	 * Internal. Copy constructor.
	 * @param o cMethod object
	 * @param n New method name.
	 */
	protected cMethod(cMethod o) {
		method = o.method;
		factory = o.factory;
		name = o.name;
	}
	
	
	/* property */
	/**
	 * Returns number of dynamically generated classes, and increments it.
	 * @return Number of dynamically generated classes.
	 */
	private synchronized long classNumber() {
		return classNumber++;
	}
	
	
	/* super property */
	@Override
	public int length() {
		return method.length();
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
			MethodHandle fctry = factory.bindTo(thisArg);
			MethodHandles.insertArguments(fctry, 0, args);
			return new cMethod((iMethod)fctry.invoke(), fctry, name);
		}
		catch(NullPointerException e) { throw new oError("Cannot bind any object to this already bound oFunction."); }
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
		return method.run(args);
	}
	
	@Override
	public final String ztoString() {
		return method.ztoString();
	}
	
	@Override
	public final String toString() {
		return ztoString();
	}
	
	// TODO:
	public final Object valueOf() {
		return method;
	}
}
