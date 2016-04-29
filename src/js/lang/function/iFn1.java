package js.lang.function;
import java.util.function.*;
import java.lang.invoke.*;

/**
 * Represents a 1 input function that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TR> Return type.
 */
public interface iFn1<TA, TR> extends iFn<TR>, Function<TA, TR> {
	
	/* static data */
	/** Signature of this function. */
	static MethodType TYPE = iProc.type(true, 1);
	
	
	/* super property */
	@Override
	default MethodType type() {
		return TYPE;
	}
	
	
	/* method */
	/**
	 * Represents the function to be defined.
	 * @param a Input argument 1.
	 * @return The output value of function.
	 */
	@Override
	TR apply(TA a);
	
	
	/* super method */
	@Override
	default TR call(Object... a) {
		return apply((TA)a[0]);
	}
}
