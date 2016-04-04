package js.lang.function;

/**
 * Represents a single output and no-input method that can be called.
 * @param <TR> Return type.
 */
public interface iFunction0<TR> extends iMethod {
	
	/* method */
	/**
	 * Represents then method to the called when "run" is called.
	 * @return The output value of method.
	 */
	TR apply();
	
	
	/* super method */
	@Override
	default Object run(Object... args) {
		return apply();
	}
	
	@Override
	default String _toString() {
		return "TR "+name()+"() { [native code] }";
	}
}
