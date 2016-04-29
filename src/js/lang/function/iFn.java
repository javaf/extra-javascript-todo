package js.lang.function;

/**
 * Represents a function that can be called.
 * @param <TR> Return type.
 */
public interface iFn<TR> extends iProc<TR> {
	
	/* static data */
	/** Name of the procedure. */
	static String NAME = "apply";
	/** Array defining all iFn interfaces in order of input parameters */
	static Class<?>[] CLASS = new Class<?>[] {
		iFn0.class, iFn1.class, iFn2.class, iFn3.class,
		iFn4.class, iFn5.class, iFn6.class, iFn7.class
	};
}
