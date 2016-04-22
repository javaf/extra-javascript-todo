package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a no input subroutine that can be called.
 */
public interface iSub0 extends iProc {
	
	/* static data */
	/** Signature of this interface. */
	static MethodType TYPE = iProc.type(false, 0);
	
	
	/* super property */
	@Override
	default MethodType type() {
		return TYPE;
	}
	
	
	/* method */
	/**
	 * Represents the subroutine to be defined.
	 */
	void accept();
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		accept();
		return null;
	}
}
