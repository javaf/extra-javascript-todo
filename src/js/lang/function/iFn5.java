package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a 5 input function that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TE> Input argument 5 type.
 * @param <TR> Return type.
 */
public interface iFn5<TA, TB, TC, TD, TE, TR> extends iFn<TR> {
	
	/* static data */
	/** Signature of this function. */
	static MethodType TYPE = iProc.type(true, 5);
	
	
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
	 * @param d Input argument 4.
	 * @param e Input argument 5.
	 * @return The output value of function.
	 */
	TR apply(TA a, TB b, TC c, TD d, TE e);
	
	
	/* super method */
	@Override
	default TR call(Object... a) {
		return apply((TA)a[0], (TB)a[1], (TC)a[2], (TD)a[3], (TE)a[4]);
	}
}
