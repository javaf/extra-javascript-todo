package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TR> Return type.
 */
public interface iFunction2<TA, TB, TR> extends iFunction {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(Object.class, cArray.fill(new Class<?>[2], Object.class));
	
	
	/* super property */
	@Override
	default int length() {
		return 2;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @return The output value of method.
	 */
	TR apply(TA a, TB b);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		return apply((TA)args[0], (TB)args[1]);
	}
	
	@Override
	default String ztoString() {
		return "TR "+name()+"(TA a, TB b) { [native code] }";
	}
}
