package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a no-output and 4 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 * @param <TC> Input Argument 3 type.
 * @param <TD> Input Argument 4 type.
 * @param <TE> Input Argument 5 type.
 * @param <TF> Input Argument 6 type.
 * @param <TG> Input Argument 7 type.
 * @param <TH> Input Argument 8 type.
 */
public interface iConsumer8<TA, TB, TC, TD, TE, TF, TG, TH> extends iConsumer {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(void.class, cArray.fill(new Class<?>[8], Object.class));

	
	/* super property */
	@Override
	default int length() {
		return 8;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @param d Input argument 4.
	 * @param e Input argument 5.
	 * @param f Input argument 6.
	 * @param g Input argument 7.
	 * @param h Input argument 8.
	 */
	void accept(TA a, TB b, TC c, TD d, TE e, TF f, TG g, TH h);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		accept((TA)args[0], (TB)args[1], (TC)args[2], (TD)args[3], (TE)args[4], (TF)args[5], (TG)args[6], (TH)args[7]);
		return null;
	}
	
	@Override
	default String ztoString() {
		return "void "+name()+"(TA a, TB b, TC c, TD d, TE e, TF f, TG g, TH h) { [native code] }";
	}
}