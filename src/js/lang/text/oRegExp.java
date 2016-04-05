package js.lang.text;
import java.util.regex.*;

/**
 * Creates a regular expression object for matching text with a pattern.
 */
public class oRegExp {
	
	/* static data */
	private final static int GLOBAL = 0x10000;
	private final static int IGNORE_CASE = Pattern.CASE_INSENSITIVE;
	private final static int MULTILINE = Pattern.MULTILINE;
	private final static int UNICODE = Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE;
	private final static int STICKY = 0x20000;
	
	
	/* data */
	private Pattern p;
	private Matcher matcher;
	private String string;
	private int lastIndex;
	
	
	/* constructor */
	/**
	 * 
	 * @param pattern
	 * @param flags 
	 */
	public oRegExp(String pattern, String flags) {
		this.p = Pattern.compile(pattern, _flags(flags));
	}
	/**
	 * Creates a regular expression object from an existing Pattern object.
	 * @param pattern Pattern object.
	 */
	public oRegExp(Pattern pattern) {
		p = pattern;
	}
	
	
	/* property */
	/**
	 * Returns the index at which the next match will start.
	 * @return Index of next match start.
	 */
	public int lastIndex() {
		return lastIndex;
	}
	/**
	 * Specifies the index at which to start the next match.
	 * @param value New index from where to start the next match.
	 */
	public void lastIndex(int value) {
		lastIndex = value;
	}
	
	/**
	 * Returns a string consisting of the flags of the current regular expression
	 * object.
	 * @return Flags used for this regular expression object.
	 */
	public String flags() {
		return (global()? "g":"")+(ignoreCase()? "i":"")+(multiline()? "m":"")+(unicode()? "u":"")+(sticky()? "y":"");
	}
	
	/**
	 * Indicates whether or not the "g" flag is used with the regular expression.
	 * @return True if is global, otherwise false.
	 */
	public boolean global() {
		return (p.flags() & GLOBAL)!=0;
	}
	
	/**
	 * Indicates whether or not the "i" flag is used with the regular expression.
	 * @return True if is ignore case, otherwise false.
	 */
	public boolean ignoreCase() {
		return (p.flags() & IGNORE_CASE)!=0;
	}
	
	/**
	 * Indicates whether or not the "m" flag is used with the regular expression.
	 * @return True if is multi-line, otherwise false.
	 */
	public boolean multiline() {
		return (p.flags() & MULTILINE)!=0;
	}
	
	/**
	 * Returns a String containing the source text of the regexp object, and it
	 * doesn't contain the two forward slashes on both sides and any flags.
	 * @return Source text.
	 */
	public String source() {
		return p.pattern();
	}
	
	/**
	 * Reflects whether or not the search is sticky (searches in strings only
	 * from the index indicated by the lastIndex property of this regular
	 * expression).
	 * @return True if is sticky, otherwise false.
	 */
	public boolean sticky() {
		return (p.flags() & STICKY)!=0;
	}
	
	/**
	 * Indicates whether or not the "u" flag is used with a regular expression.
	 * @return True if is unicode, otherwise false.
	 */
	public boolean unicode() {
		return (p.flags() & UNICODE)!=0;
	}
	
	
	/* method */
	/**
	 * Executes a search for a match between a regular expression and a specified string. Returns true or false.
	 * @param str The string against which to match the regular expression.
	 * @return True if found, otherwise false.
	 */
	public boolean test(String str) {
		return p.matcher(str).find();
	}
	
	public Object exec(String str) {
		
		return null;
	}
	
	/**
	 * Returns the integer flags value for Pattern object.
	 * @param f String flags value.
	 * @return Flags for Pattern object.
	 */
	private static int _flags(String f) {
		return (f.contains("g")? GLOBAL:0) | (f.contains("i")? IGNORE_CASE:0) | (f.contains("m")? MULTILINE:0) |
			(f.contains("u")? UNICODE:0) | (f.contains("y")? STICKY:0);
	}
	
	
	/* super method */
	@Override
	public String toString() {
		return "/"+source()+"/"+flags();
	}
}
