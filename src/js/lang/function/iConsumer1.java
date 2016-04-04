package js.lang.function;
import java.util.function.*;

/**
 * Represents a no-output and 1 input method that can be called.
 * @param <TA> Input Argument 1 type.
 */
public interface iConsumer1<TA> extends iMethod, Consumer<TA> {
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 */
	@Override
	void accept(TA a);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept((TA)args[0]);
		return null;
	}
}
