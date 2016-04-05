package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;
import java.util.function.*;

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
public class cMethod<TA, TB, TC, TD, TE, TF, TG, TR> implements iMethod,
	iConsumer0, iConsumer1<TA>, iConsumer2<TA, TB>, iConsumer3<TA, TB, TC>, iConsumer4<TA, TB, TC, TD>,
	iConsumer5<TA, TB, TC, TD, TE>, iConsumer6<TA, TB, TC, TD, TE, TF>, iConsumer7<TA, TB, TC, TD, TE, TF, TG>,
	iFunction0<TR>, iFunction1<TA, TR>, iFunction2<TA, TB, TR>, iFunction3<TA, TB, TC, TR>, iFunction4<TA, TB, TC, TD, TR>,
	iFunction5<TA, TB, TC, TD, TE, TR>, iFunction6<TA, TB, TC, TD, TE, TF, TR>, iFunction7<TA, TB, TC, TD, TE, TF, TG, TR>,
	Consumer<TA>, BiConsumer<TA, TB>, Supplier<TR>, Function<TA, TR>, BiFunction<TA, TB, TR> {
	
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
	 * Create a callable Method object from object implementing Consumer interface.
	 * @param m Consumer implementing object.
	 */
	public cMethod(Consumer<TA> m) {
		this((iConsumer1<TA>) (TA a) -> m.accept(a));
	}
	/**
	 * Create a callable Method object from object implementing BiConsumer interface.
	 * @param m BiConsumer implementing object.
	 */
	public cMethod(BiConsumer<TA, TB> m) {
		this((iConsumer2<TA, TB>) (TA a, TB b) -> m.accept(a, b));
	}
	/**
	 * Create a callable Method object from object implementing Supplier interface.
	 * @param m Supplier implementing object.
	 */
	public cMethod(Supplier<TR> m) {
		this((iFunction0<TR>) () -> m.get());
	}
	/**
	 * Create a callable Method object from object implementing Function interface.
	 * @param m Function implementing object.
	 */
	public cMethod(Function<TA, TR> m) {
		this((iFunction1<TA, TR>) (TA a) -> m.apply(a));
	}
	/**
	 * Create a callable Method object from object implementing BiFunction interface.
	 * @param m BiFunction implementing object.
	 */
	public cMethod(BiFunction<TA, TB, TR> m) {
		this((iFunction2<TA, TB, TR>) (TA a, TB b) -> m.apply(a, b));
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
	protected cMethod(cMethod o, String n) {
		method = o.method;
		factory = o.factory;
		name = n!=null? n: o.name;
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
	public Object apply(Object thisArg, Object[] argsArray) {
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
		catch(Throwable e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Calls a function with a given this value and arguments provided
	 * individually.
	 * @param thisArg The value of this provided for the call to function.
	 * @param args Arguments for the object.
	 * @return Return value of function.
	 */
	public Object call(Object thisArg, Object... args) {
		return thisArg!=null? bind(thisArg).run(args) : run(args);
	}
	
	
	/* super method */
	@Override
	public Object run(Object... args) {
		return method.run(args);
	}
	
	@Override
	public String _toString() {
		return method._toString();
	}
	
	@Override
	public void accept() {
		((iConsumer0)valueOf()).accept();
	}

	@Override
	public void accept(TA a) {
		((iConsumer1<TA>)valueOf()).accept(a);
	}

	@Override
	public void accept(TA a, TB b) {
		((iConsumer2<TA, TB>)valueOf()).accept(a, b);
	}

	@Override
	public void accept(TA a, TB b, TC c) {
		((iConsumer3<TA, TB, TC>)valueOf()).accept(a, b, c);
	}

	@Override
	public void accept(TA a, TB b, TC c, TD d) {
		((iConsumer4<TA, TB, TC, TD>)valueOf()).accept(a, b, c, d);
	}

	@Override
	public void accept(TA a, TB b, TC c, TD d, TE e) {
		((iConsumer5<TA, TB, TC, TD, TE>)valueOf()).accept(a, b, c, d, e);
	}

	@Override
	public void accept(TA a, TB b, TC c, TD d, TE e, TF f) {
		((iConsumer6<TA, TB, TC, TD, TE, TF>)valueOf()).accept(a, b, c, d, e, f);
	}

	@Override
	public void accept(TA a, TB b, TC c, TD d, TE e, TF f, TG g) {
		((iConsumer7<TA, TB, TC, TD, TE, TF, TG>)valueOf()).accept(a, b, c, d, e, f, g);
	}
	
	@Override
	public TR get() {
		return apply();
	}

	@Override
	public TR apply() {
		return ((iFunction0<TR>)valueOf()).apply();
	}

	@Override
	public TR apply(TA a) {
		return ((iFunction1<TA, TR>)valueOf()).apply(a);
	}

	@Override
	public TR apply(TA a, TB b) {
		return ((iFunction2<TA, TB, TR>)valueOf()).apply(a, b);
	}

	@Override
	public TR apply(TA a, TB b, TC c) {
		return ((iFunction3<TA, TB, TC, TR>)valueOf()).apply(a, b, c);
	}

	@Override
	public TR apply(TA a, TB b, TC c, TD d) {
		return ((iFunction4<TA, TB, TC, TD, TR>)valueOf()).apply(a, b, c, d);
	}

	@Override
	public TR apply(TA a, TB b, TC c, TD d, TE e) {
		return ((iFunction5<TA, TB, TC, TD, TE, TR>)valueOf()).apply(a, b, c, d, e);
	}

	@Override
	public TR apply(TA a, TB b, TC c, TD d, TE e, TF f) {
		return ((iFunction6<TA, TB, TC, TD, TE, TF, TR>)valueOf()).apply(a, b, c, d, e, f);
	}

	@Override
	public TR apply(TA a, TB b, TC c, TD d, TE e, TF f, TG g) {
		return ((iFunction7<TA, TB, TC, TD, TE, TF, TG, TR>)valueOf()).apply(a, b, c, d, e, f, g);
	}
	
	@Override
	public <TV> cMethod<TA, TB, TC, TD, TE, TF, TG, TV> andThen(Function<? super TR, ? extends TV> after) {
		return new cMethod<>((iMethod)(Object... args) -> after.apply((TR)((iMethod)valueOf()).run(args)));
	}
	
	@Override
	public String toString() {
		return _toString();
	}
	
	// TODO:
	public Object valueOf() {
		return method;
	}
}
