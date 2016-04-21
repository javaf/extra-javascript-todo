package js.lang.function;

/**
 * Defines root interface of all iFn interfaces.
 */
public interface iFn extends iProc {
	
	/* static data */
	/** Defines the default name of (main) function of all iFn interfaces. */
	static String NAME = "apply";
	
	
	/* super property */
	@Override
	default String name() {
		return NAME;
	}
}
