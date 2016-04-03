package js.lang.function;

/**
 * Represents a no-output and 4 input method that can be called.
 * @param <TA> Input Argument 1 type.
 * @param <TB> Input Argument 2 type.
 * @param <TC> Input Argument 3 type.
 * @param <TD> Input Argument 4 type.
 * @param <TE> Input Argument 5 type.
 * @param <TF> Input Argument 6 type.
 */
public interface iConsumer6<TA, TB, TC, TD, TE, TF> extends iMethod {
	
	/* method */
	/**
	 * Represents then function to the called when "call" is called.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @param d Input argument 4.
	 * @param e Input argument 5.
	 * @param f Input argument 6.
	 */
	void accept(TA a, TB b, TC c, TD d, TE e, TF f);
	
	
	/* super method */
	@Override
	default Object call(Object... args) {
		accept((TA)args[0], (TB)args[1], (TC)args[2], (TD)args[3], (TE)args[4], (TF)args[5]);
		return null;
	}
}
