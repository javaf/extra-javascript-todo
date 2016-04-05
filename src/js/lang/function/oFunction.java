package js.lang.function;
import java.util.function.*;

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
public class oFunction<TA, TB, TC, TD, TE, TF, TG, TR> extends cMethod {
	
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
		super(function);
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(BiConsumer<TA, TB> function) {
		super(function);
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(Supplier<TR> function) {
		super(function);
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(Function<TA, TR> function) {
		super(function);
	}
	/**
	 * Creates a new Function object.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(BiFunction<TA, TB, TR> function) {
		super(function);
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
		super(null, null);
		throw new UnsupportedOperationException("Not supported yet.");
	}
	/**
	 * Internal. Super copy constructor
	 * @param o cMethod object.
	 */
	private oFunction(cMethod o, String n) {
		super(o, n);
	}
	
	
	/* super method */
	@Override
	public oFunction<TA, TB, TC, TD, TE, TF, TG, TR> bind(Object thisArg, Object... args) {
		return new oFunction<>(super.bind(thisArg, args), null);
	}
}
