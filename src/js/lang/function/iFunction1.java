package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TR> Return type.
 */
public interface iFunction1<TA, TR> extends iFunction {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(Object.class, Object.class);

	
	/* super property */
	@Override
	default int length() {
		return 1;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 * @return The output value of method.
	 */
	TR apply(TA a);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		return apply((TA)args[0]);
	}
	
	@Override
	default String _toString() {
		return "TR "+name()+"(TA a) { [native code] }";
	}
}
