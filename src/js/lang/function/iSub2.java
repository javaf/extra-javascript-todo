package js.lang.function;
import java.util.function.*;
import java.lang.invoke.*;

/**
 * Represents a 2 input subroutine that can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 */
public interface iSub2<TA, TB> extends iProc, BiConsumer<TA, TB> {
	
	/* static data */
	/** Signature of this interface. */
	static MethodType TYPE = iProc.type(false, 2);
	
	
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
	 */
	@Override
	void accept(TA a, TB b);
	
	
	/* super method */
	@Override
	default Object call(Object... a) {
		accept((TA)a[0], (TB)a[1]);
		return null;
	}
}
