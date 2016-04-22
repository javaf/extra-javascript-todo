package js.lang.function;
import java.util.function.*;
import java.lang.invoke.*;

/**
 * Represents a 2 input function that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TR> Return type.
 */
public interface iFn2<TA, TB, TR> extends iProc, BiFunction<TA, TB, TR> {
	
	/* static data */
	/** Signature of this function. */
	static MethodType TYPE = iProc.type(true, 2);
	
	
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
	 * @return The output value of function.
	 */
	@Override
	TR apply(TA a, TB b);
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		return apply((TA)a[0], (TB)a[1]);
	}
}
