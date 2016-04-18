package js.lang.function;
import java.util.function.*;
import java.lang.reflect.*;

/**
 * The oFunction class represents generic functions.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TE> Input argument 5 type.
 * @param <TF> Input argument 6 type.
 * @param <TG> Input argument 7 type.
 * @param <TR> Return type.
 * @author Didier L, wolfram77
 */
public class oFunction<TA, TB, TC, TD, TE, TF, TG, TR> extends cMethod implements
	iConsumer0, iConsumer1<TA>, iConsumer2<TA, TB>, iConsumer3<TA, TB, TC>, iConsumer4<TA, TB, TC, TD>,
	iConsumer5<TA, TB, TC, TD, TE>, iConsumer6<TA, TB, TC, TD, TE, TF>, iConsumer7<TA, TB, TC, TD, TE, TF, TG>,
	iFunction0<TR>, iFunction1<TA, TR>, iFunction2<TA, TB, TR>, iFunction3<TA, TB, TC, TR>, iFunction4<TA, TB, TC, TD, TR>,
	iFunction5<TA, TB, TC, TD, TE, TR>, iFunction6<TA, TB, TC, TD, TE, TF, TR>, iFunction7<TA, TB, TC, TD, TE, TF, TG, TR>,
	Consumer<TA>, BiConsumer<TA, TB>, Supplier<TR>, Function<TA, TR>, BiFunction<TA, TB, TR> {
	
	/* constructor */
	/**
	 * Create a callable oFunction object from object implementing iMethod interface.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(iMethod function) {
		super(function);
	}
	/**
	 * Create a callable oFunction object from object implementing Consumer interface.
	 * @param m Consumer implementing object.
	 */
	public oFunction(Consumer<TA> m) {
		super((iConsumer1<TA>) (TA a) -> m.accept(a));
	}
	/**
	 * Create a callable oFunction object from object implementing BiConsumer interface.
	 * @param m BiConsumer implementing object.
	 */
	public oFunction(BiConsumer<TA, TB> m) {
		super((iConsumer2<TA, TB>) (TA a, TB b) -> m.accept(a, b));
	}
	/**
	 * Create a callable oFunction object from object implementing Supplier interface.
	 * @param m Supplier implementing object.
	 */
	public oFunction(Supplier<TR> m) {
		super((iFunction0<TR>) () -> m.get());
	}
	/**
	 * Create a callable oFunction object from object implementing Function interface.
	 * @param m Function implementing object.
	 */
	public oFunction(Function<TA, TR> m) {
		super((iFunction1<TA, TR>) (TA a) -> m.apply(a));
	}
	/**
	 * Create a callable oFunction object from object implementing BiFunction interface.
	 * @param m BiFunction implementing object.
	 */
	public oFunction(BiFunction<TA, TB, TR> m) {
		super((iFunction2<TA, TB, TR>) (TA a, TB b) -> m.apply(a, b));
	}
	/**
	 * Creates a callable oFunction object from a specific field reflectively..
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param clazz Class which contains the field.
	 * @param field Field object of the field.
	 * @param set If true, setter is used, otherwise getter is used.
	 */
	public oFunction(Object thisArg, Class<?> clazz, Field field, boolean set) {
		super(thisArg, clazz, field, set);
	}
	/**
	 * Creates a callable oFunction object from a specific field reflectively..
	 * @param clazz Class which contains the field.
	 * @param field Field object of the field.
	 * @param set If true, setter is used, otherwise getter is used.
	 */
	public oFunction(Class<?> clazz, Field field, boolean set) {
		this(null, clazz, field, set);
	}
	/**
	 * Creates a callable oFunction object from a specific field reflectively..
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param clazz Class which contains the field.
	 * @param field Name of the field.
	 * @param set If true, setter is used, otherwise getter is used.
	 */
	public oFunction(Object thisArg, Class<?> clazz, String field, boolean set) {
		this(thisArg, clazz, cMethod.field(clazz, field), set);
	}
	/**
	 * Creates a callable oFunction object from a specific field reflectively..
	 * @param clazz Class which contains the field.
	 * @param field Name of the field.
	 * @param set If true, setter is used, otherwise getter is used.
	 */
	public oFunction(Class<?> clazz, String field, boolean set) {
		this(null, clazz, field, set);
	}
	/**
	 * Creates a callable oFunction object from a specific method reflectively..
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param clazz Class which contains the method.
	 * @param method Method object.
	 */
	public oFunction(Object thisArg, Class<?> clazz, Method method) {
		super(thisArg, clazz, method);
	}
	/**
	 * Creates a callable oFunction object from a specific method reflectively..
	 * @param clazz Class which contains the method.
	 * @param method Method object.
	 */
	public oFunction(Class<?> clazz, Method method) {
		this(null, clazz, method);
	}
	/**
	 * Creates a callable oFunction object from a specific method reflectively..
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param clazz Class which contains the method.
	 * @param method Name of the method.
	 * @param parameterTypes Parameter types of the method.
	 */
	public oFunction(Object thisArg, Class<?> clazz, String method, Class<?>... parameterTypes) {
		this(thisArg, clazz, cMethod.method(clazz, method, parameterTypes));
	}
	/**
	 * Creates a callable oFunction object from a specific method reflectively.
	 * If this method is not static, then bind must be used to bind it to an
	 * object of the same class.
	 * @param clazz Class which contains the method.
	 * @param method Name of the method.
	 * @param parameterTypes Parameter types of the method.
	 */
	public oFunction(Class<?> clazz, String method, Class<?>... parameterTypes) {
		this(null, clazz, method, parameterTypes);
	}
	/**
	 * Creates a callable oFunction object from a String specification of the function.
	 * @param args Names to be used by the function as formal argument names.
	 * Each must be a string that corresponds to a valid Java identifier or a
	 * list of such strings separated with a comma; for example "x", "theValue",
	 * or "a,b". The last argument should be a string containing the Java
	 * statements comprising the function definition.
	 */
	public oFunction(String... args) {
		super(args.length-1, args, args[args.length-1]);
	}
	/**
	 * Super copy constructor
	 * @param o cMethod object.
	 */
	private oFunction(cMethod o) {
		super(o);
	}
	
	
	/* super method */
	@Override
	public final oFunction<TA, TB, TC, TD, TE, TF, TG, TR> bind(Object thisArg, Object... args) {
		return new oFunction<>(super.bind(thisArg, args));
	}
	
	@Override
	public final void accept() {
		apply();
	}

	@Override
	public final void accept(TA a) {
		apply(a);
	}

	@Override
	public final void accept(TA a, TB b) {
		apply(a, b);
	}

	@Override
	public final void accept(TA a, TB b, TC c) {
		apply(a, b, c);
	}

	@Override
	public final void accept(TA a, TB b, TC c, TD d) {
		apply(a, b, c, d);
	}

	@Override
	public final void accept(TA a, TB b, TC c, TD d, TE e) {
		apply(a, b, c, d, e);
	}

	@Override
	public final void accept(TA a, TB b, TC c, TD d, TE e, TF f) {
		apply(a, b, c, d, e, f);
	}

	@Override
	public final void accept(TA a, TB b, TC c, TD d, TE e, TF f, TG g) {
		apply(a, b, c, d, e, f, g);
	}
	
	@Override
	public final TR get() {
		return apply();
	}

	@Override
	public final TR apply() {
		return (TR)((iMethod)valueOf()).run();
	}

	@Override
	public final TR apply(TA a) {
		return (TR)((iMethod)valueOf()).run(a);
	}

	@Override
	public final TR apply(TA a, TB b) {
		return (TR)((iMethod)valueOf()).run(a, b);
	}

	@Override
	public final TR apply(TA a, TB b, TC c) {
		return (TR)((iMethod)valueOf()).run(a, b, c);
	}

	@Override
	public final TR apply(TA a, TB b, TC c, TD d) {
		return (TR)((iMethod)valueOf()).run(a, b, c, d);
	}

	@Override
	public final TR apply(TA a, TB b, TC c, TD d, TE e) {
		return (TR)((iMethod)valueOf()).run(a, b, c, d, e);
	}

	@Override
	public final TR apply(TA a, TB b, TC c, TD d, TE e, TF f) {
		return (TR)((iMethod)valueOf()).run(a, b, c, d, e, f);
	}

	@Override
	public final TR apply(TA a, TB b, TC c, TD d, TE e, TF f, TG g) {
		return (TR)((iMethod)valueOf()).run(a, b, c, d, e, f, g);
	}
	
	@Override
	public final <TV> oFunction<TA, TB, TC, TD, TE, TF, TG, TV> andThen(Function<? super TR, ? extends TV> after) {
		return new oFunction<>((iMethod)(Object... args) -> after.apply((TR)((iMethod)valueOf()).run(args)));
	}
}
