package js.core;
import java.util.function.*;
import js.lang.function.*;

/**
 * The oFunction class represents generic functions.
 * @param <TA>
 * @param <TB>
 * @param <TC>
 * @param <TD>
 * @param <TR>
 * @param <TE>
 * @param <TF>
 * @param <TG>
 */
public class oFunction<TA, TB, TC, TD, TE, TF, TG, TR> extends cMethod implements
	iConsumer0, iConsumer1<TA>, iConsumer2<TA, TB>, iConsumer3<TA, TB, TC>, iConsumer4<TA, TB, TC, TD>,
	iConsumer5<TA, TB, TC, TD, TE>, iConsumer6<TA, TB, TC, TD, TE, TF>, iConsumer7<TA, TB, TC, TD, TE, TF, TG>,
	iFunction0<TR>, iFunction1<TA, TR>, iFunction2<TA, TB, TR>, iFunction3<TA, TB, TC, TR>, iFunction4<TA, TB, TC, TD, TR>,
	iFunction5<TA, TB, TC, TD, TE, TR>, iFunction6<TA, TB, TC, TD, TE, TF, TR>, iFunction7<TA, TB, TC, TD, TE, TF, TG, TR>,
	Consumer<TA>, BiConsumer<TA, TB>, Supplier<TR>, Function<TA, TR>, BiFunction<TA, TB, TR> {
	
	/* constructor */
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(iMethod function) {
		super(function);
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(Consumer<TA> function) {
		super((iConsumer1<TA>) (TA a) -> function.accept(a));
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(BiConsumer<TA, TB> function) {
		super((iConsumer2<TA, TB>) (TA a, TB b) -> function.accept(a, b));
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(Supplier<TR> function) {
		super((iFunction0<TR>) () -> function.get());
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(Function<TA, TR> function) {
		super((iFunction1<TA, TR>) (TA a) -> function.apply(a));
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(BiFunction<TA, TB, TR> function) {
		super((iFunction2<TA, TB, TR>) (TA a, TB b) -> function.apply(a, b));
	}
	/**
	 * Creates a new Function object.
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param clazz Class which contains the method.
	 * @param method Name of the method.
	 * @param parameterTypes Parameter types of the method.
	 */
	public oFunction(Object thisArg, Class clazz, String method, Class... parameterTypes) {
		super(thisArg, clazz, method, parameterTypes);
	}
	/**
	 * Creates a new Function object.
	 * @param clazz Class which contains the method.
	 * @param method Name of the method.
	 * @param parameterTypes Parameter types of the method.
	 */
	public oFunction(Class clazz, String method, Class... parameterTypes) {
		super(null, clazz, method, parameterTypes);
	}
	/**
	 * Creates a new Function object.
	 * @param args Names to be used by the function as formal argument names.
	 * Each must be a string that corresponds to a valid Java identifier or a
	 * list of such strings separated with a comma; for example "x", "theValue",
	 * or "a,b". The last argument should be a string containing the Java
	 * statements comprising the function definition.
	 */
	public oFunction(String... args) {
		super(null);
		throw new UnsupportedOperationException("Not supported yet.");
	}
	/**
	 * Internal. Super copy constructor
	 * @param o cMethod object.
	 */
	private oFunction(cMethod o) {
		super(o);
	}

	
	/* super method */
	@Override
	public oFunction<TA, TB, TC, TD, TE, TF, TG, TR> bind(Object thisArg, Object... args) {
		return new oFunction<>(super.bind(thisArg, args));
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
	public <TV> oFunction<TA, TB, TC, TD, TE, TF, TG, TV> andThen(Function<? super TR, ? extends TV> after) {
		return new oFunction<>((iMethod)(Object... args) -> after.apply((TR)((iMethod)valueOf()).run(args)));
	}
}
