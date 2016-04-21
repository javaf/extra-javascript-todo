package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a no-output and 2 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 */
public interface iConsumer2<TA, TB> extends iConsumer {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(void.class, cArray.fill(new Class<?>[2], Object.class));
	
	
	/* super property */
	@Override
	default int length() {
		return 2;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 */
	void accept(TA a, TB b);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept((TA)args[0], (TB)args[1]);
		return null;
	}
	
	@Override
	default String ztoString() {
		return "void "+name()+"(TA a, TB b) { [native code] }";
	}
}
