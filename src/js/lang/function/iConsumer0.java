package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a no-output and no-input method that can be called.
 */
public interface iConsumer0 extends iConsumer {
	
	/* static data */
	/** Method signature of this interface. */
	static MethodType SIGNATURE = MethodType.methodType(void.class);
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 */
	void accept();
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		accept();
		return null;
	}
	
	@Override
	default String ztoString() {
		return "void "+name()+"() { [native code] }";
	}
}
