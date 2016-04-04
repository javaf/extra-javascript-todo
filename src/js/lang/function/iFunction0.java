package js.lang.function;
import java.util.function.*;

/**
 * Represents a single output and no-input method that can be called.
 * @param <TR> Return type.
 */
public interface iFunction0<TR> extends iMethod, Supplier<TR> {
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @return The output value of method.
	 */
	TR apply();
	
	
	/* super method */
	@Override
	default TR get() {
		return apply();
	}
	
	@Override
	default Object call(Object... args) {
		return apply();
	}
}
