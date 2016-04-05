package js.lang.text;
import java.util.regex.*;

/**
 * Creates a regular expression object for matching text with a pattern.
 */
public class oRegExp {
	
	/* static data */
	/** Internal. Global pattern flag. */
	private final static int GLOBAL = 0x10000;
	/** Internal. Ignore case pattern flag. */
	private final static int IGNORE_CASE = Pattern.CASE_INSENSITIVE;
	/** Internal. Multi-line pattern flag. */
	private final static int MULTILINE = Pattern.MULTILINE;
	/** Internal. Unicode pattern flag. */
	private final static int UNICODE = Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE;
	/** Internal. Sticky pattern flag. */
	private final static int STICKY = 0x20000;
	
	
	/* data */
	/** Specifies the pattern object for this regular expression. */
	private final Pattern p;
	/** Specifies the matcher object for this regular expression. */
	private final Matcher m;
	/** Specifies the original input string. */
	private String in;
	/** Specifies the index at which to start the next match. */
	private int off;
	
	
	/* constructor */
	/**
	 * Creates a regular expression object from specified pattern and flags.
	 * @param pattern Regular expression pattern string.
	 * @param flags Flags for regular expression "gimuy".
	 */
	public oRegExp(String pattern, String flags) {
		this(Pattern.compile(pattern, _flags(flags)));
	}
	/**
	 * Creates a regular expression object from an existing Pattern object.
	 * @param pattern Pattern object.
	 */
	public oRegExp(Pattern pattern) {
		p = pattern;
		m = p.matcher("");
	}
	
	
	/* property */
	/**
	 * Returns the index at which the next match will start.
	 * @return Index of next match start.
	 */
	public int lastIndex() {
		return off;
	}
	/**
	 * Specifies the index at which to start the next match.
	 * @param value New index from where to start the next match.
	 */
	public void lastIndex(int value) {
		off = value;
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
		m.reset(in = str);
		m.region(off, str.length());
		return m.find();
	}
	
	/**
	 * Executes a search for a match in a specified string. Returns a result
	 * array, or null.
	 * @param str The string against which to match the regular expression.
	 * @return If the match succeeds, the exec() method returns a cRegExpResult
	 * object and updates properties of the regular expression object. The
	 * returned object has the matched text as the first item, and then one item
	 * for each capturing parenthesis that matched containing the text that was
	 * captured. If the match fails, the exec() method returns null.
	 */
	public cRegExpResult exec(String str) {
		if(str==null) return null;
		else if(!str.equals(in) || !global()) m.reset((in = str));
		m.region(off, str.length());
		m.find();
		m.region(off = !m.hitEnd()? m.end() : 0, m.regionEnd());
		return !sticky() || m.start()==off? new cRegExpResult(m, in) : null;
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
	
	// TODO:
	public Object valueOf() {
		return p;
	}
}
