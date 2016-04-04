package js.lang.function;

/**
 * Defines root interface of all iConsumer interfaces.
 */
public interface iConsumer extends iMethod {
	
	/* static data */
	/** Defines the name of (main) function of all iConsumer interfaces. */
	static String NAME = "accept";
	
	
	/* super property */
	@Override
	default String name() {
		return NAME;
	}
}
