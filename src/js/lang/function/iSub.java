package js.lang.function;

/**
 * Defines root interface of all iSub interfaces.
 */
public interface iSub extends iProc {
	
	/* static data */
	/** Defines the default name of (main) function of all iSub interfaces. */
	static String NAME = "accept";
	
	
	/* super property */
	@Override
	default String name() {
		return NAME;
	}
}
