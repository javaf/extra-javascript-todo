package js.lang.function;
import java.util.function.*;
import java.lang.invoke.*;

/**
 * Represents a 1 input subroutine that can be called.
 * @param <TA> Input argument 1 type.
 */
public interface iSub1<TA> extends iProc, Consumer<TA> {
	
	/* static data */
	/** Signature of this interface. */
	static MethodType TYPE = iProc.type(false, 1);
	
	
	/* super property */
	@Override
	default MethodType type() {
		return TYPE;
	}
	
	
	/* method */
	/**
	 * Represents the subroutine to be defined.
	 * @param a Input argument 1.
	 */
	@Override
	void accept(TA a);
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		accept((TA)a[0]);
		return null;
	}
}
