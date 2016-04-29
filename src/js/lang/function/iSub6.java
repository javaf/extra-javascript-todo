package js.lang.function;
import java.lang.invoke.*;

/**
 * Represents a 6 input subroutine that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TE> Input argument 5 type.
 * @param <TF> Input argument 6 type.
 */
public interface iSub6<TA, TB, TC, TD, TE, TF> extends iSub {
	
	/* static data */
	/** Signature of this interface. */
	static MethodType TYPE = iProc.type(false, 6);
	
	
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
	 * @param e Input argument 5.
	 * @param f Input argument 6.
	 */
	void accept(TA a, TB b, TC c, TD d, TE e, TF f);
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		accept((TA)a[0], (TB)a[1], (TC)a[2], (TD)a[3], (TE)a[4], (TF)a[5]);
		return null;
	}
}
