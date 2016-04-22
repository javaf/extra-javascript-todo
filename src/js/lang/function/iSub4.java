package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a 4 input subroutine that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 */
public interface iSub4<TA, TB, TC, TD> extends iProc {
	
	/* static data */
	/** Signature of this interface. */
	static MethodType TYPE = iProc.type(false, 4);
	
	
	/* super property */
	@Override
	default MethodType type() {
		return TYPE;
	}
	
	
	/* method */
	/**
	 * Represents the subroutine to be defined.
	 * @param a Input argument 1.
	 * @param b Input argument 2.
	 * @param c Input argument 3.
	 * @param d Input argument 4.
	 */
	void accept(TA a, TB b, TC c, TD d);
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		accept((TA)a[0], (TB)a[1], (TC)a[2], (TD)a[3]);
		return null;
	}
}
