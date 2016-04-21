package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a no input function that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TR> Return type.
 */
public interface iFn3<TA, TB, TC, TR> extends iProc {
	
	/* static data */
	/** Signature of this function. */
	static MethodType TYPE = MethodType.genericMethodType(3);
	
	
	/* super property */
	@Override
	default MethodType type() {
		return TYPE;
	}
	
	
	/* method */
	/**
	 * Represents the function to be defined.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @return The output value of function.
	 */
	TR apply(TA a, TB b, TC c);
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		return apply((TA)a[0], (TB)a[1], (TC)a[2]);
	}
}
