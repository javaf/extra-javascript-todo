package js.lang.function;

/**
 * Represents a subroutine that can be called.
 */
public interface iSub extends iProc {
	
	/* static data */
	/** Name of the procedure. */
	static String NAME = "accept";
	/** Array defining all iSub interfaces in order of input parameters */
	static Class<?>[] CLASS = new Class<?>[] {
		iSub0.class, iSub1.class, iSub2.class, iSub3.class,
		iSub4.class, iSub5.class, iSub6.class, iSub7.class
	};
}
