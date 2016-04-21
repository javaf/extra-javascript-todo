package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a no-output and 4 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 * @param <TC> Input Argument 3 type.
 * @param <TD> Input Argument 4 type.
 */
public interface iConsumer4<TA, TB, TC, TD> extends iConsumer {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(void.class, cArray.fill(new Class<?>[4], Object.class));
	
	
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
	 */
	void accept(TA a, TB b, TC c, TD d);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		accept((TA)args[0], (TB)args[1], (TC)args[2], (TD)args[3]);
		return null;
	}
	
	@Override
	default String ztoString() {
		return "void "+name()+"(TA a, TB b, TC c, TD d) { [native code] }";
	}
}
