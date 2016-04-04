package js.lang.function;
import java.util.function.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TR> Return type.
 */
public interface iFunction1<TA, TR> extends iMethod, Function<TA, TR> {
	
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
	@Override
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
