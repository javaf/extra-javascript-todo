package js.lang;

/**
 * Math is a built-in object that has properties and methods for mathematical constants and functions.
 */
public class oMath {
	
	/* data*/
	/** Euler's constant and the base of natural logarithms, approximately 2.718. */
	public static final double E = Math.E;
	/** Natural logarithm of 2, approximately 0.693. */
	public static final double LN2 = Math.log(2);
	/** Natural logarithm of 10, approximately 2.303. */
	public static final double LN10 = Math.log(10);
	/** Base 2 logarithm of E, approximately 1.443. */
	public static final double LOG2E = 1/Math.log(2);
	/** Base 10 logarithm of E, approximately 0.434. */
	public static final double LOG10E = 1/Math.log(10);
	/** Ratio of the circumference of a circle to its diameter, approximately 3.14159. */
	public static final double PI = Math.PI;
	/** Square root of 1/2; equivalently, 1 over the square root of 2, approximately 0.707. */
	public static final double SQRT1_2 = 1/Math.sqrt(2);
	/** Square root of 2, approximately 1.414. */
	public static final double SQRT2 = Math.sqrt(2);

	
	/* static method */
	/**
	 * Returns the absolute value of a number.
	 * @param x A number.
	 * @return Absolute value.
	 */
	public final static double abs(double x) {
		return Math.abs(x);
	}
	/**
	 * Returns the absolute value of a number.
	 * @param x A number.
	 * @return Absolute value.
	 */
	public final static long abs(long x) {
		return Math.abs(x);
	}
	
	
	/**
	 * Returns the arc-cosine of a number.
	 * @param x A number in the range [-1, 1].
	 * @return Arc-cosine value in radians.
	 */
	public final static double acos(double x) {
		return Math.acos(x);
	}
	
	/**
	 * Returns the hyperbolic arc-cosine of a number.
	 * @param x A number in the range [1, +inf].
	 * @return Hyperbolic arc-cosine value.
	 */
	public final static double acosh(double x) {
		return Math.log(x + Math.sqrt(x*x - 1));
	}
	
	/**
	 * Returns the arc-sine of a number.
	 * @param x A number in the range [-1, 1].
	 * @return Arc-sine value in radians.
	 */
	public final static double asin(double x) {
		return Math.asin(x);
	}
	
	/**
	 * Returns the hyperbolic arc-sine of a number.
	 * @param x A number.
	 * @return Hyperbolic arc-sine value.
	 */
	public final static double asinh(double x) {
		return Math.log(x + Math.sqrt(x*x + 1));
	}
	
	/**
	 * Returns the arc-tangent of a number.
	 * @param x A number.
	 * @return Arc-tangent value in radians.
	 */
	public final static double atan(double x) {
		return Math.atan(x);
	}
	
	/**
	 * Returns the hyperbolic arc-tangent of a number.
	 * @param x A number in the range (-1, 1).
	 * @return Hyperbolic arc-tangent value.
	 */
	public final static double atanh(double x) {
		return Math.log((1+x)/(1-x)) / 2;
	}
	
	/**
	 * Returns the arc-tangent of the quotient of its arguments.
	 * @param y First number.
	 * @param x Second number.
	 * @return Arc-tangent value in radians.
	 */
	public final static double atan2(double y, double x) {
		return Math.atan2(y, x);
	}
	
	/**
	 * Returns the cube root of a number.
	 * @param x A number.
	 * @return Cube root value.
	 */
	public final static double cbrt(double x) {
		return Math.cbrt(x);
	}
	
	/**
	 * Returns the smallest integer greater than or equal to a number.
	 * @param x A number.
	 * @return Ceiling value.
	 */
	public final static double ceil(double x) {
		return Math.ceil(x);
	}
	
	/**
	 * Returns the number of leading zero bits in the 32-bit binary
	 * representation of a number.
	 * @param x A number.
	 * @return Number of leading zeros.
	 */
	public final static double clz32(double x) {
		return clz32((int)x);
	}
	/**
	 * Returns the number of leading zero bits in the 32-bit binary
	 * representation of a number.
	 * @param x A number.
	 * @return Number of leading zeros.
	 */
	public final static int clz32(int x) {
		int c = 32;
		for(; x>0; x>>=1)
			c--;
		return c;
	}
	
	/**
	 * Returns the cosine of a number.
	 * @param x A number is radians.
	 * @return Cosine value.
	 */
	public final static double cos(double x) {
		return Math.cos(x);
	}
	
	/**
	 * Returns the hyperbolic cosine of a number.
	 * @param x A number.
	 * @return Hyperbolic cosine value in the range [1, +inf).
	 */
	public final static double cosh(double x) {
		return Math.cosh(x);
	}
	
	/**
	 * Returns E^x, where x is the argument, and E is Euler's constant (2.718…),
	 * the base of the natural logarithm.
	 * @param x A number.
	 * @return Exponent value.
	 */
	public final static double exp(double x) {
		return Math.exp(x);
	}
	
	/**
	 * Returns subtracting 1 from exp(x).
	 * @param x A number.
	 * @return exps(x) - 1.
	 */
	public final static double expm1(double x) {
		return Math.expm1(x);
	}
	
	/**
	 * Returns the largest integer less than or equal to a number.
	 * @param x A number.
	 * @return Floor value.
	 */
	public final static double floor(double x) {
		return Math.floor(x);
	}
	
	/**
	 * Returns the nearest single precision float representation of a number.
	 * @param x A number.
	 * @return Nearest float value.
	 */
	public final static double fround(double x) {
		return (float)x;
	}
	
	/**
	 * Returns the square root of the sum of squares of its arguments.
	 * @param xs Numbers.
	 * @return Hypotenuse value. 
	 */
	public final static double hypot(double... xs) {
		double v = 0;
		for(double x : xs)
			v += x*x;
		return Math.sqrt(v);
	}
	
	/**
	 * Returns the result of a 32-bit integer multiplication.
	 * @param x First number.
	 * @param y Second number.
	 * @return Integer multiplied value.
	 */
	public final static double imul(double x, double y) {
		return (int)x*(int)y;
	}
	
	/**
	 * Returns the natural logarithm (loge, also ln) of a number.
	 * @param x A number in the range (0, +inf).
	 * @return Logarithm value.
	 */
	public final static double log(double x) {
		return Math.log(x);
	}
	
	/**
	 * Returns the natural logarithm of 1 + x (loge, also ln) of a number.
	 * @param x A number in the range (-1, +inf).
	 * @return Natural logarithm value of 1+x.
	 */
	public final static double log1p(double x) {
		return Math.log1p(x);
	}
	
	/**
	 * Returns the base 10 logarithm of a number.
	 * @param x A number in the range (0, +inf).
	 * @return Base 10 logarithm value.
	 */
	public final static double log10(double x) {
		return Math.log10(x);
	}
	
	/**
	 * Returns the base 2 logarithm of a number.
	 * @param x A number in the range (0, +inf).
	 * @return Base 2 logarithm value.
	 */
	public final static double log2(double x) {
		return Math.log(x)*LOG2E;
	}
	/**
	 * Returns the base 2 logarithm of a number.
	 * @param x A number in the range (0, +inf).
	 * @return Base 2 logarithm value, -1 if x is 0.
	 */
	public final static long log2(long x) {
		long v = -1;
		for(; x>0; x>>=1)
			v++;
		return v;
	}
	
	/**
	 * Returns the largest of zero or more numbers.
	 * @param xs Numbers.
	 * @return Maximum value of numbers.
	 */
	public final static double max(double... xs) {
		double v = Double.NEGATIVE_INFINITY;
		for(double x : xs)
			v = v>x? x : v;
		return v;
	}
	
	/**
	 * Returns the smallest of zero or more numbers.
	 * @param xs Numbers.
	 * @return Minimum value of numbers.
	 */
	public final static double min(double... xs) {
		double v = Double.POSITIVE_INFINITY;
		for(double x : xs)
			v = v<x? x : v;
		return v;
	}
	
	/**
	 * Returns a pseudo-random number between 0 and 1.
	 * @return Psuedo-random number.
	 */
	public final static double random() {
		return Math.random();
	}
	
	/**
	 * Returns the value of a number rounded to the nearest integer.
	 * @param x A number.
	 * @return Rounded value.
	 */
	public final static double round(double x) {
		return Math.round(x);
	}
	
	/**
	 * Returns the sign of the x, indicating whether x is positive, negative or
	 * zero.
	 * @param x A number.
	 * @return -1 if x<0, 0 if x==0, 1 if x>0.
	 */
	public final static double sign(double x) {
		return Math.signum(x);
	}
	
	/**
	 * Returns the sine of a number.
	 * @param x A number in radians.
	 * @return Sine value in the range [-1, 1].
	 */
	public final static double sin(double x) {
		return Math.sin(x);
	}
	
	/**
	 * Returns the hyperbolic sine of a number.
	 * @param x A number.
	 * @return Hyperbolic sine value.
	 */
	public final static double sinh(double x) {
		return Math.sinh(x);
	}
	
	/**
	 * Returns the positive square root of a number.
	 * @param x A number in the range [0, +inf).
	 * @return Square root value.
	 */
	public final static double sqrt(double x) {
		return Math.sqrt(x);
	}
	
	/**
	 * Returns the tangent of a number.
	 * @param x A number in radians.
	 * @return Tangent value.
	 */
	public final static double tan(double x) {
		return Math.tan(x);
	}
	
	/**
	 * Returns the hyperbolic tangent of a number.
	 * @param x A number.
	 * @return Hyperbolic tangent value.
	 */
	public final static double tanh(double x) {
		return Math.tanh(x);
	}
	
	/**
	 * Returns the integral part of the number x, removing any fractional digits.
	 * @param x A number.
	 * @return Integral part of number.
	 */
	public final static double trunc(double x) {
		return Math.floor(x) + x<0? 1 : 0;
	}
}
