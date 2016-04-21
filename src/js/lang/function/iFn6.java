package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TE> Input argument 5 type.
 * @param <TF> Input argument 6 type.
 * @param <TR> Return type.
 */
public interface iFn6<TA, TB, TC, TD, TE, TF, TR> extends iFn {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(Object.class, cArray.fill(new Class<?>[6], Object.class));

	
	/* super property */
	@Override
	default int length() {
		return 6;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @param d Input argument 4.
	 * @param e Input argument 5.
	 * @param f Input argument 6.
	 * @return The output value of method.
	 */
	TR apply(TA a, TB b, TC c, TD d, TE e, TF f);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		return apply((TA)args[0], (TB)args[1], (TC)args[2], (TD)args[3], (TE)args[4], (TF)args[5]);
	}
	
	@Override
	default String z_toString() {
		return "TR "+name()+"(TA a, TB b, TC c, TD d, TE e, TF f) { [native code] }";
	}
}