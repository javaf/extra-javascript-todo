package js.lang.function;
import java.lang.invoke.*;
import js.lang.array.*;

/**
 * Represents a single output and no-input method that can be called.
 * @param <TR> Return type.
 */
public interface iFn0<TR> extends iFn {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(Object.class, cArray.fill(new Class<?>[0], Object.class));

	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @return The output value of method.
	 */
	TR apply();
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		return apply();
	}
	
	@Override
	default String z_toString() {
		return "TR "+name()+"() { [native code] }";
	}
}
