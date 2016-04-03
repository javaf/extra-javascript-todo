package js.lang.function;

/**
 * Represents a no-output and no-input method that can be called.
 */
public interface iConsumer0 extends iMethod {
	
	/* method */
	/**
	 * Represents then function to the called when "call" is called.
	 */
	void accept();
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept();
		return null;
	}
}
