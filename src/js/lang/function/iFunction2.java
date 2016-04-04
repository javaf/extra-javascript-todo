package js.lang.function;
import java.util.function.*;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TR> Return type.
 */
public interface iFunction2<TA, TB, TR> extends iMethod, BiFunction<TA, TB, TR> {
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @return The output value of method.
	 */
	@Override
	TR apply(TA a, TB b);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		return apply((TA)args[0], (TB)args[1]);
	}
}
