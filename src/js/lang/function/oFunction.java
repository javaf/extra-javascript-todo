package js.lang.function;
import java.util.function.*;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * The oFunction class represents generic functions.
 * @param <TR> Return type of function.
 */
public class oFunction<TR> implements iProc<TR> {
	
	/* data */
	/** Defines the procedure for the specified object. */
	private final iProc proc;
	/** Contains reflected handle required for binding. */
	private Object handle;
	
	
	/* constructor */
	/**
	 * Create a callable oFunction object from object implementing iProc interface.
	 * @param function Function as lambda expression or object.
	 */
	public oFunction(iProc function) {
		proc = function;
	}
	/**
	 * Create a callable oFunction object from object implementing Consumer interface.
	 * @param function Consumer implementing object.
	 */
	public oFunction(Consumer function) {
		proc = (iSub1)(a)->function.accept(a);
	}
	/**
	 * Create a callable oFunction object from object implementing BiConsumer interface.
	 * @param function BiConsumer implementing object.
	 */
	public oFunction(BiConsumer function) {
		proc = (iSub2)(a, b)->function.accept(a, b);
	}
	/**
	 * Create a callable oFunction object from object implementing Supplier interface.
	 * @param function Supplier implementing object.
	 */
	public oFunction(Supplier function) {
		proc = (iFn0)()->function.get();
	}
	/**
	 * Create a callable oFunction object from object implementing Function interface.
	 * @param function Function implementing object.
	 */
	public oFunction(Function function) {
		proc = (iFn1)(a)->function.apply(a);
	}
	/**
	 * Create a callable oFunction object from object implementing BiFunction interface.
	 * @param function BiFunction implementing object.
	 */
	public oFunction(BiFunction function) {
		proc = (iFn2)(a, b)->function.apply(a, b);
	}
	/**
	 * Creates a callable oFunction object from a specific field reflectively..
	 * @param thisArg The value to be passed as the this parameter to the target
	 * function when the bound function is called.
	 * @param field Field object of the field.
	 * @param set If true, setter is used, otherwise getter is used.
	 */
	public oFunction(Object thisArg, Field field, boolean set) {
		proc = set? new cSetterProc(field, thisArg) : new cGetterProc(field, thisArg);
		handle = field;
	}
	/**
	 * Creates a callable oFunction object from a specific field reflectively..
	 * @param field Field object of the field.
	 * @param set If true, setter is used, otherwise getter is used.
	 */
	public oFunction(Field field, boolean set) {
		this(null, field, set);
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
		this(thisArg, iProc.field(clazz, field), set);
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
	 * @param method Method object.
	 */
	public oFunction(Object thisArg, Method method) {
		proc = new cMethodProc(method, thisArg);
		handle = method;
	}
	/**
	 * Creates a callable oFunction object from a specific method reflectively..
	 * @param method Method object.
	 */
	public oFunction(Method method) {
		this(null, method);
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
		this(thisArg, iProc.method(clazz, method, parameterTypes));
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
		proc = new cStrMethodProc(args);
	}
	/**
	 * Copy constructor.
	 * @param o oFunction object.
	 */
	private oFunction(oFunction o) {
		proc = o.proc;
	}
	
	
	/* super property */
	@Override
	public final MethodType type() {
		return proc.type();
	}
	
	
	/* method */
	/**
	 * Bind an object to this function, if it is unbound.
	 * @param obj Object to bind to.
	 * @return Bound function.
	 */
	public final oFunction<TR> bind(Object obj) {
		if(proc instanceof cGetterProc) return new oFunction(obj, (Field)handle, false);
		else if(proc instanceof cSetterProc) return new oFunction(obj, (Field)handle, true);
		else if(proc instanceof cMethodProc) return new oFunction(obj, (Method)handle);
		return this;
	}
	
	
	/* super method */
	@Override
	public final TR call(Object... a) {
		return (TR)proc.call(a);
	}
	
	@Override
	public final iProc valueOf() {
		return proc;
	}
	
	@Override
	public final String z_toString() {
		return proc.z_toString();
	}
	
	@Override
	public final String toString() {
		return z_toString();
	}
}
