package js.lang.function;

/**
 * Represents a no-output and 1 input method that can be called.
 * @param <TA> Input Argument 1 type.
 */
public interface iConsumer1<TA> extends iMethod {
	
	/* super property */
	@Override
	default int length() {
		return 1;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 */
	void accept(TA a);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		accept((TA)args[0]);
		return null;
	}
	
	@Override
	default String _toString() {
		return "void "+name()+"(TA a) { [native code] }";
	}
}
