package js.core;
import javax.script.*;

/**
 * Properties and functions in global scope.
 */
public class oGlobal {
	
	/* data */
	/** A numeric value representing infinity. */
	public static final double Infinity = Double.POSITIVE_INFINITY;
	/** A value representing Not-A-Number. */
	public static final double NaN = Double.NaN;
	/** Represents undefined value, which is the same as null in Java. */
	public static final Object undefined = null;
	/** Represents script engine for JavaScript */
	private static ScriptEngine js;
	
	/* static method */
	/**
	 * evaluates JavaScript code represented as a string.
	 * @param string A string representing a JavaScript expression, statement,
	 * or sequence of statements. The expression can include variables and
	 * properties of existing objects.
	 * @return Return The value returned from the execution of the script.
	 * @throws ScriptException If error occurs in script.
	 */
	public final static Object eval(String string) throws ScriptException {
		js = js==null? new ScriptEngineManager().getEngineByName("JavaScript") : js;
		return js.eval(string);
	}
	
	/**
	 * Determines whether the passed value is a finite number. If needed, the
	 * parameter is first converted to a number.
	 * @param testValue The value to be tested for finiteness.
	 * @return Whether testValue (converted to Number) is finite.
	 */
	public final static boolean isFinite(Object testValue) {
		return false;
	}
	
	/**
	 * Determines whether a value is NaN or not. Note: coercion inside the isNaN
	 * function has interesting rules; you may alternatively want to use
	 * Number.isNaN(), as defined in ECMAScript 6, or you can use typeof to
	 * determine if the value is Not-A-Number.
	 * @param testValue The value to be tested.
	 * @return Whether the value (converted to Number) is NaN.
	 */
	public final static boolean isNaN(Object testValue) {
		return false;
	}
	
	/**
	 * Parses a string argument and returns a floating point number.
	 * @param string A string that represents the value you want to parse.
	 * @return Parsed floating-point (double) number.
	 */
	public static double parseFloat(String string) {
		return 0;
	}
	
	/**
	 * Parses a string argument and returns an integer of the specified radix
	 * (the base in mathematical numeral systems).
	 * @param string The value to parse. If string is not a string, then it is
	 * converted to a string (using the ToString abstract operation). Leading
	 * whitespace in the string is ignored.
	 * @param radix An integer between 2 and 36 that represents the radix (the
	 * base in mathematical numeral systems) of the above mentioned string.
	 * Specify 10 for the decimal numeral system commonly used by humans.
	 * @return Parsed integer of specified radix.
	 */
	public static int parseInt(String string, int radix) {
		return 0;
	}
	
	/**
	 * Decodes a Uniform Resource Identifier (URI) previously created by
	 * encodeURI or by a similar routine.
	 * @param encodedURI A complete, encoded Uniform Resource Identifier.
	 * @return Decoded URI string.
	 */
	public static String decodeURI(String encodedURI) {
		return null;
	}
	
	/**
	 * Decodes a Uniform Resource Identifier (URI) component previously created
	 * by encodeURIComponent or by a similar routine.
	 * @param encodedURI An encoded component of a Uniform Resource Identifier.
	 * @return Decoded URI component string.
	 */
	public static String decodeURIComponent(String encodedURI) {
		return null;
	}
	
	/**
	 * Encodes a Uniform Resource Identifier (URI) by replacing each instance of
	 * certain characters by one, two, three, or four escape sequences
	 * representing the UTF-8 encoding of the character (will only be four
	 * escape sequences for characters composed of two "surrogate" characters).
	 * @param URI A complete Uniform Resource Identifier.
	 * @return Encoded URI string.
	 */
	public static String encodeURI(String URI) {
		return null;
	}
	
	/**
	 * Encodes a Uniform Resource Identifier (URI) component by replacing each
	 * instance of certain characters by one, two, three, or four escape
	 * sequences representing the UTF-8 encoding of the character (will only be
	 * four escape sequences for characters composed of two "surrogate"
	 * characters).
	 * @param str String. A component of a URI.
	 * @return Encoded URI component string.
	 */
	public static String encodeURIComponent(String str) {
		return null;
	}
}
