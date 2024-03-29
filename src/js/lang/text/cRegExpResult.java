package js.lang.text;
import java.util.regex.*;

/**
 * Defines the result of executing a regular expression on a string (RegExp).
 */
public class cRegExpResult {
	
	/* data */
	/** Represents the match result of execution of regular expression on a string. */
	private final Matcher m;
	/** Original input string given to regular expression for matching. */
	private final String in;
	
	
	/* constructor */
	/**
	 * Create a regular expression result object from a matcher object and input
	 * string.
	 * @param match Matcher object.
	 * @param input Input string.
	 */
	public cRegExpResult(Matcher match, String input) {
		m = match;
		in = input;
	}
	
	
	/* property */
	/**
	 * Returns 1 (matched value) + number of matched parenthesized substring
	 * values.
	 * @return Total number of indexes for get() and index().
	 */
	public int length() {
		return 1+m.groupCount();
	}
	
	/**
	 * Returns the matched value after executing regular expression on a string.
	 * @return Matched value.
	 */
	public String get() {
		return m.group();
	}
	/**
	 * Returns the matched value for index 0, else returns the nth parenthesized
	 * substring value in the regular expression, if any.
	 * @param index 0 for matched value, n for nth parenthesized substring value.
	 * @return Matched value or a parenthesized substring value.
	 */
	public String get(int index) {
		return m.group(index);
	}
	/**
	 * Returns the named parenthesized substring value in the regular expression,
	 * if any.
	 * @param string Name of the parenthesized substring.
	 * @return Parenthesized substring value.
	 */
	public String get(String string) {
		return m.group(string);
	}
	
	/**
	 * Returns the index of matched value after executing regular expression on
	 * a string.
	 * @return Index of matched value.
	 */
	public int index() {
		return m.start();
	}
	/**
	 * Returns the index of matched value for index 0, else returns the index of
	 * nth parenthesized substring value in the regular expression, if any.
	 * @param index 0 for index of matched value, n for index of nth
	 * parenthesized substring value.
	 * @return Index of matched value or a parenthesized substring value.
	 */
	public int index(int index) {
		return m.start(index);
	}
	/**
	 * Returns the index of named parenthesized substring value in the regular
	 * expression, if any.
	 * @param string Name of the parenthesized substring.
	 * @return Index of parenthesized substring.
	 */
	public int index(String string) {
		return m.start(string);
	}
	
	/**
	 * Return the original input string.
	 * @return Input string.
	 */
	public String input() {
		return in;
	}
}
