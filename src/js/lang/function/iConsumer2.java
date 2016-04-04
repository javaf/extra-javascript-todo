package js.lang.function;
import java.util.function.*;

/**
 * Represents a no-output and 2 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 */
public interface iConsumer2<TA, TB> extends iMethod, BiConsumer<TA, TB> {
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 */
	@Override
	void accept(TA a, TB b);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept((TA)args[0], (TB)args[1]);
		return null;
	}
}
