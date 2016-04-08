package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TR> Return type.
 */
public interface iFunction3<TA, TB, TC, TR> extends iFunction {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(Object.class, Object.class, Object.class, Object.class);
	
	
	/* super property */
	@Override
	default int length() {
		return 3;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @return The output value of method.
	 */
	TR apply(TA a, TB b, TC c);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		return apply((TA)args[0], (TB)args[1], (TC)args[2]);
	}
	
	@Override
	default String ztoString() {
		return "TR "+name()+"(TA a, TB b, TC c) { [native code] }";
	}
}
