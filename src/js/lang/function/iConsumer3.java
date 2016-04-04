package js.lang.function;

/**
 * Represents a no-output and 3 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 * @param <TC> Input Argument 3 type.
 */
public interface iConsumer3<TA, TB, TC> extends iMethod {
	
	/* super property */
	@Override
	default int length() {
		return 3;
	}
	
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 */
	void accept(TA a, TB b, TC c);
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		accept((TA)args[0], (TB)args[1], (TC)args[2]);
		return null;
	}
	
	@Override
	default String _toString() {
		return "void "+name()+"(TA a, TB b, TC c) { [native code] }";
	}
}
