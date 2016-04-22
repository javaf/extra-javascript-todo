package js.lang.function;
import java.util.function.*;
import java.lang.invoke.*;

/**
 * Represents a no input function that can be called.
 * @param <TR> Return type.
 */
public interface iFn0<TR> extends iProc, Supplier<TR> {
	
	/* static data */
	/** Signature of this function. */
	static MethodType TYPE = iProc.type(true, 0);
	
	
	/* super property */
	@Override
	default MethodType type() {
		return TYPE;
	}
	
	
	/* method */
	/**
	 * Represents the function to be defined.
	 * @return The output value of function.
	 */
	TR apply();
	
	
	/* super method */
	@Override
	default TR get() {
		return apply();
	}
	
	@Override
	default Object call(Object... a) {
		return apply();
	}
}
