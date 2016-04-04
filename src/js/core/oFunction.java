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
public class oFunction<TA, TB, TC, TD, TE, TF, TG, TR> extends cMethod implements iConsumer0 {
	
	/* constructor */
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing Consumer, or a lambda
	 * expression.
	 */
	public oFunction(iMethod function) {
		super(function);
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing Consumer, or a lambda
	 * expression.
	 */
	public oFunction(Consumer<TA> function) {
		super((iConsumer1<TA>) (TA a) -> function.accept(a));
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing BiConsumer, or a lambda
	 * expression.
	 */
	public oFunction(BiConsumer<TA, TB> function) {
		super((iConsumer2<TA, TB>) (TA a, TB b) -> function.accept(a, b));
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing Function, or a lambda
	 * expression.
	 */
	public oFunction(Supplier<TR> function) {
		super((iFunction0<TR>) () -> function.get());
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing Function, or a lambda
	 * expression.
	 */
	public oFunction(Function<TA, TR> function) {
		super((iFunction1<TA, TR>) (TA a) -> function.apply(a));
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing BiFunction, or a lambda
	 * expression.
	 */
	public oFunction(BiFunction<TA, TB, TR> function) {
		super((iFunction2<TA, TB, TR>) (TA a, TB b) -> function.apply(a, b));
	}
	public oFunction(Object obj, Class cls, String mthd, Class... types) throws Throwable {
		super(obj, cls, mthd, types);
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
	}
	/**
	 * Creates a new Function object.
	 * @param cls Class the method belongs to.
	 * @param method Name of the method.
	 * @param parameterTypes Optional. Parameter types of method to choose an
	 * appropriate overloaded method.
	 */
	public oFunction(Class cls, String method, Class... parameterTypes) {
		super(null);
	}
	/**
	 * Internal. Initializes Function object.
	 * @param func something.
	 * @param len something.
	 */
	private oFunction(Object func, int len) {
		super(null);
	}

	@Override
	public void accept() {
		((iConsumer0)mthd).accept();
	}
}
