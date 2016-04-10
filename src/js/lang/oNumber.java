package js.lang;

public class oNumber {
	
	/* static data */
	/** The difference between one and the smallest value greater than one that can be represented as a oNumber. */
	public static double EPSILON = Math.pow(2, -52);
	/** The maximum safe integer in JavaScript (2^53 - 1). */
	public static double MAX_SAFE_INTEGER = Math.pow(2, 53) - 1;
	/** The largest positive representable number. */
	public static double MAX_VALUE = Double.MAX_VALUE;
	/** The minimum safe integer in JavaScript (-(2^53 - 1)). */
	public static double MIN_SAFE_INTEGER = -(Math.pow(2, 53) - 1);
	/** The smallest positive representable number - that is, the positive number closest to zero (without actually being zero). */
	public static double MIN_VALUE = Double.MIN_VALUE;
	/** Special "not a number" value. */
	public static double NaN = Double.NaN;
	/** Special value representing negative infinity; returned on overflow. */
	public static double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
	/** Special value representing infinity; returned on overflow. */
	public static double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
	
	
	/* data */
	/** Internal value. */
	private double o;
	
	
	
	/* method */
	@Override
	public String toString() {
		return String.valueOf(o);
	}
	
	public Object valueOf() {
		return o;
	}
}
