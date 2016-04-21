package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a no-output and 3 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 * @param <TC> Input Argument 3 type.
 */
public interface iSub3<TA, TB, TC> extends iSub {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(void.class, cArray.fill(new Class<?>[3], Object.class));
	
	
	/* super property */
	@Override
	default int length() {
		return 3;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 */
	void accept(TA a, TB b, TC c);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept((TA)args[0], (TB)args[1], (TC)args[2]);
		return null;
	}
	
	@Override
	default String z_toString() {
		return "void "+name()+"(TA a, TB b, TC c) { [native code] }";
	}
}