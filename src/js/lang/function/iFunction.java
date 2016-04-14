package js.lang.function;

/**
 * Defines root interface of all iFunction interfaces.
 */
public interface iFunction extends iMethod {
	
	/* static data */
	/** Defines the default name of (main) function of all iFunction interfaces. */
	static String NAME = "apply";
	
	
	/* super property */
	@Override
	default String name() {
		return NAME;
	}
}
