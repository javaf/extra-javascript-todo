package js.core;
import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.Locale;
import java.util.function.*;
import javax.tools.*;


/**
 * The oFunction class represents generic functions.
 */
public class oFunction<T, U, R> implements iFunction<T, U, R> {
	
	/* data */
	private Object fn;
	private boolean isStatic;
	/** Specifies the number of arguments expected by the function. */
	private final String name;
	/** Returns the name of the function. */
	private final int length;
	/** Error Message. ToolProvider.getSyatemJavaCompiler() returns null. */
	private static final String ERR_JAVA_COMPILER = "Java Compiler is not available. JDK might not be installed.";
	
	
	/* constructor */
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing Consumer, or a lambda
	 * expression.
	 */
	public oFunction(Consumer function) {
		this(function, 1);
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing BiConsumer, or a lambda
	 * expression.
	 */
	public oFunction(BiConsumer function) {
		this(function, 2);
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing Function, or a lambda
	 * expression.
	 */
	public oFunction(Function function) {
		this(function, 1);
	}
	/**
	 * Creates a new Function object.
	 * @param function Can be an object implementing BiFunction, or a lambda
	 * expression.
	 */
	public oFunction(BiFunction function) {
		this(function, 2);
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
		throw new UnsupportedOperationException("Not yet supported.");
	}
	/**
	 * Creates a new Function object.
	 * @param cls Class the method belongs to.
	 * @param method Name of the method.
	 * @param parameterTypes Optional. Parameter types of method to choose an
	 * appropriate overloaded method.
	 */
	public oFunction(Class cls, String method, Class... parameterTypes) {
		throw new UnsupportedOperationException("Not yet supported.");
	}
	/**
	 * Internal. Initializes Function object.
	 * @param func something.
	 * @param len something.
	 */
	private oFunction(Object func, int len) {
		fn = func;
		name = "";
		length = len;
	}
	
	
	/* property */
	/**
	 * Specifies the number of arguments expected by the function.
	 * @return Number of function arguments.
	 */
	public int length() {
		return length;
	}
	
	/**
	 * Returns the name of the function.
	 * @return Function name.
	 */
	public String name() {
		return name;
	}
	
	
	/* static method */

	
	/* method */
	/**
	 * Calls a function with a given this value and arguments provided as an array.
	 * @param thisArg The value of this provided for the call to function.
	 * @param argsArray An array, specifying the arguments with which function
	 * should be called, or null if no arguments should be provided to the
	 * function.
	 * @return Value returned by the function.
	 */
	public Object apply(Object thisArg, Object[] argsArray) {
		return null;
	}
	
	/**
	 * Calls a function with a given this value and arguments provided individually.
	 * @param thisArg The value of this provided for the call to function.
	 * @param args Arguments for the function.
	 * @return Value returned by the function.
	 */
	public Object call(Object thisArg, Object... args) {
		return apply(thisArg, args);
	}

	
	/* super method */
	@Override
	public void accept(T t) {
		((Consumer<T>)fn).accept(t);
	}
	
	@Override
	public void accept(T t, U u) {
		((BiConsumer<T, U>)fn).accept(t, u);
	}

	@Override
	public R apply(T t) {
		return ((Function<T, R>)fn).apply(t);
	}
	
	@Override
	public R apply(T t, U u) {
		return ((BiFunction<T, U, R>)fn).apply(t, u);
	}
	
	@Override
	public String toString() {
		if(fn instanceof Consumer) return "void "+name+"(Object arg0) { [native code] }";
		if(fn instanceof BiConsumer) return "void"+name+"(Object arg0, Object arg1) { [native code] }";
		if(fn instanceof Function) return "Object "+name+"(Object arg0) { [native code] }";
		if(fn instanceof BiFunction) return "Object "+name+"(Object arg0, Object arg1) { [native code] }";
		
		return null;
	}
}
