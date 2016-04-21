package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a no-output and 1 input method that can be called.
 * @param <TA> Input Argument 1 type.
 */
public interface iSub1<TA> extends iSub {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(void.class, cArray.fill(new Class<?>[1], Object.class));
	
	
	/* super property */
	@Override
	default int length() {
		return 1;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 */
	void accept(TA a);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept((TA)args[0]);
		return null;
	}
	
	@Override
	default String z_toString() {
		return "void "+name()+"(TA a) { [native code] }";
	}
}