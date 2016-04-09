package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TR> Return type.
 */
public interface iFunction4<TA, TB, TC, TD, TR> extends iFunction {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(Object.class, Object.class, Object.class, Object.class, Object.class);

	
	/* super property */
	@Override
	default int length() {
		return 4;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @param d Input argument 4.
	 * @return The output value of method.
	 */
	TR apply(TA a, TB b, TC c, TD d);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		return apply((TA)args[0], (TB)args[1], (TC)args[2], (TD)args[3]);
	}
	
	@Override
	default String ztoString() {
		return "TR "+name()+"(TA a, TB b, TC c, TD d) { [native code] }";
	}
}