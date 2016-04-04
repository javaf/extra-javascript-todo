package js.lang.function;

/**
 * Represents a single output and 1-input method that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TR> Return type.
 */
public interface iFunction4<TA, TB, TC, TD, TR> extends iMethod {
	
	/* method */
	/**
	 * Represents then method to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @param d Input argument 4.
	 * @return The output value of method.
	 */
	TR apply(TA a, TB b, TC c, TD d);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		return apply((TA)args[0], (TB)args[1], (TC)args[2], (TD)args[3]);
	}
}
