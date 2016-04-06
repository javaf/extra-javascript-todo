package js.lang.text;

/**
 * Constructor for strings, or a sequence of characters.
 */
public class oString {
	
	/* data */
	private String value;
	
	
	/* static method */
	/**
	 * Returns a string created by using the specified sequence of Unicode values.
	 * @param nums A sequence of numbers that are Unicode values.
	 * @return String representing the sequence of unicode values.
	 */
	public static String fromCharCode(char... nums)	 {
		return new String(nums);
	}
	
	/**
	 * Returns a string created by using the specified sequence of code points.
	 * @param nums A sequence of code points.
	 * @return String representation of given sequence of code points.
	 */
	public static String fromCodePoint(int... nums) {
		return new String(nums, 0, nums.length);
	}
	
	
	/* method */
	/**
	 * Creates an "a" HTML anchor element that is used as a hypertext target.
	 * @param name A string representing the name attribute of the a tag to be created.
	 * @return String value of the anchor.
	 */
	public String anchor(String name) {
		return "<a name=\""+name+"\">"+value+"</a>";
	}
	
	/**
	 * Returns the specified character from a string.
	 * @param index An integer between 0 and 1-less-than the length of the string.
	 * @return Character at specified index.
	 */
	public char charAt(int index) {
		return value.charAt(index);
	}
	
	/**
	 * Returns an integer between 0 and 65535 representing the UTF-16 code unit at
	 * the given index (the UTF-16 code unit matches the Unicode code point for code
	 * points representable in a single UTF-16 code unit, but might also be the first
	 * code unit of a surrogate pair for code points not representable in a single
	 * UTF-16 code unit, e.g. Unicode code points > 0x10000). If you want the entire
	 * code point value, use codePointAt().
	 * @param index An integer greater than or equal to 0 and less than the length
	 * of the string; if it is not a number, it defaults to 0.
	 * @return 16-bit character code at specified index.
	 */
	public int charCodeAt(int index) {
		return (int) value.charAt(index);
	}
	
	/**
	 * Returns a non-negative integer that is the Unicode code point value.
	 * @param pos Position of an element in the String to return the code point value from.
	 * @return Code point at specified position.
	 */
	public int codePointAt(int pos) {
		return value.codePointAt(pos);
	}
	
	/**
	 * Combines the text of two or more strings and returns a new string.
	 * @param strings Strings to concatenate to this string.
	 * @return Concatenated string.
	 */
	public String concat(String... strings) {
		StringBuilder s = new StringBuilder(value);
		for(String v : strings)
			s.append(v);
		return s.toString();
	}
	
	/**
	 * Determines whether a string ends with the characters of another string, returning
	 * true or false as appropriate.
	 * @param searchString The characters to be searched for at the end of this string.
	 * @param position Optional. Search within this string as if this string were only
	 * this long; defaults to this string's actual length, clamped within the range
	 * established by this string's length.
	 * @return True if the string ends with the specified search string, otherwise false.
	 */
	public boolean endsWith(String searchString, int position) {
		return value.substring(0, position).endsWith(searchString);
	}
	/**
	 * Determines whether a string ends with the characters of another string, returning
	 * true or false as appropriate.
	 * @param searchString The characters to be searched for at the end of this string.
	 * @return True if the string ends with the specified search string, otherwise false.
	 */
	public boolean endsWith(String searchString) {
		return value.endsWith(searchString);
	}
	
	/**
	 * Determines whether one string may be found within another string, returning
	 * true or false as appropriate.
	 * @param searchString A string to be searched for within this string.
	 * @param position Optional. The position in this string at which to begin
	 * searching for searchString; defaults to 0.
	 * @return Whether the string starts with the specified search string.
	 */
	public boolean includes(String searchString, int position) {
		return value.substring(position).contains(searchString);
	}
	/**
	 * Determines whether one string may be found within another string, returning
	 * true or false as appropriate.
	 * @param searchString A string to be searched for within this string.
	 * @return Whether the string starts with the specified search string.
	 */
	public boolean includes(String searchString) {
		return value.contains(searchString);
	}
	
	/**
	 * Returns the index within the calling String object of the first occurrence
	 * of the specified value, starting the search at fromIndex. Returns -1 if the
	 * value is not found.
	 * @param searchValue A string representing the value to search for.
	 * @param fromIndex The index at which to start the searching forwards in the
	 * string. It can be any integer. The default value is 0, so the whole array
	 * is searched. If fromIndex less than 0 the entire string is searched. If
	 * fromIndex greater of equals str.length, the string is not searched and -1 is
	 * returned. Unless searchValue is an empty string, then str.length is returned.
	 * @return Index of specified search value in string.
	 */
	public int indexOf(String searchValue, int fromIndex) {
		return value.indexOf(searchValue, fromIndex);
	}
	/**
	 * Returns the index within the calling String object of the first occurrence
	 * of the specified value, starting the search at fromIndex. Returns -1 if the
	 * value is not found.
	 * @param searchValue A string representing the value to search for.
	 * @param fromIndex The index at which to start the searching forwards in the
	 * string. It can be any integer. The default value is 0, so the whole array
	 * is searched. If fromIndex less than 0 the entire string is searched. If
	 * fromIndex greater of equals str.length, the string is not searched and -1 is
	 * returned. Unless searchValue is an empty string, then str.length is returned.
	 * @return Index of specified search value in string.
	 */
	public int indexOf(int searchValue, int fromIndex) {
		return value.indexOf(searchValue, fromIndex);
	}
	/**
	 * Returns the index within the calling String object of the first occurrence
	 * of the specified value, starting the search at fromIndex. Returns -1 if the
	 * value is not found.
	 * @param searchValue A string representing the value to search for.
	 * @return Index of specified search value in string.
	 */
	public int indexOf(String searchValue) {
		return value.indexOf(searchValue);
	}
	/**
	 * Returns the index within the calling String object of the first occurrence
	 * of the specified value, starting the search at fromIndex. Returns -1 if the
	 * value is not found.
	 * @param searchValue A string representing the value to search for.
	 * @return Index of specified search value in string.
	 */
	public int indexOf(int searchValue) {
		return value.indexOf(searchValue);
	}
	
	/**
	 * Returns the index within the calling String object of the last occurrence
	 * of the specified value, searching backwards from fromIndex. Returns -1
	 * if the value is not found.
	 * @param searchValue A string representing the value to search for. If
	 * searchValue is an empty string, then fromIndex is returned.
	 * @param fromIndex The index at which to start searching backwards in the
	 * string. It can be any integer. The default value is str.length - 1, so the
	 * whole array is searched. If fromIndex >= str.length, the whole string is
	 * searched. If fromIndex less than 0,  the behavior will be the same as
	 * if it would be 0.
	 * @return Last index of search value in the string.
	 */
	public int lastIndexOf(String searchValue, int fromIndex) {
		return value.lastIndexOf(searchValue, fromIndex);
	}
	/**
	 * Returns the index within the calling String object of the last occurrence
	 * of the specified value, searching backwards from fromIndex. Returns -1
	 * if the value is not found.
	 * @param searchValue A string representing the value to search for. If
	 * searchValue is an empty string, then fromIndex is returned.
	 * @param fromIndex The index at which to start searching backwards in the
	 * string. It can be any integer. The default value is str.length - 1, so the
	 * whole array is searched. If fromIndex >= str.length, the whole string is
	 * searched. If fromIndex less than 0,  the behavior will be the same as
	 * if it would be 0.
	 * @return Last index of search value in the string.
	 */
	public int lastIndexOf(int searchValue, int fromIndex) {
		return value.lastIndexOf(searchValue, fromIndex);
	}
	/**
	 * Returns the index within the calling String object of the last occurrence
	 * of the specified value, searching backwards from fromIndex. Returns -1
	 * if the value is not found.
	 * @param searchValue A string representing the value to search for. If
	 * searchValue is an empty string, then fromIndex is returned.
	 * @return Last index of search value in the string.
	 */
	public int lastIndexOf(String searchValue) {
		return value.lastIndexOf(searchValue);
	}
	/**
	 * Returns the index within the calling String object of the last occurrence
	 * of the specified value, searching backwards from fromIndex. Returns -1
	 * if the value is not found.
	 * @param searchValue A string representing the value to search for. If
	 * searchValue is an empty string, then fromIndex is returned.
	 * @return Last index of search value in the string.
	 */
	public int lastIndexOf(int searchValue) {
		return value.lastIndexOf(searchValue);
	}
	
	/**
	 * Creates a string representing the code for an "a" HTML element to be used
	 * as a hypertext link to another URL.
	 * @param url Any string that specifies the href attribute of the "a" tag;
	 * it should be a valid URL (relative or absolute), with any & characters
	 * escaped as &amp;, and any " characters escaped as &quot;.
	 * @return String value of text and URL as a link.
	 */
	public String link(String url) {
		return "<a href=\""+url+"\">"+value+"</a>";
	}
	
	/**
	 * Returns a number indicating whether a reference string comes before or after
	 * or is the same as the given string in sort order. The new locales and options
	 * arguments let applications specify the language whose sort order should be
	 * used and customize the behavior of the function. In older implementations,
	 * which ignore the locales and options arguments, the locale and sort order
	 * used are entirely implementation dependent.
	 * @param compareString The string against which the referring string is compared.
	 * @param locales Optional. A string with a BCP 47 language tag, or an array of
	 * such strings. For the general form and interpretation of the locales argument,
	 * see the Intl page. The following Unicode extension keys are allowed:
	 * co
	 * Variant collations for certain locales. Possible values include: "big5han",
	 * "dict", "direct", "ducet", "gb2312", "phonebk", "phonetic", "pinyin", "reformed",
	 * "searchjl", "stroke", "trad", "unihan". The "standard" and "search" values are
	 * ignored; they are replaced by the options property usage (see below).
	 * kn
	 * Whether numeric collation should be used, such that "1" less "2" less "10".
	 * Possible values are "true" and "false". This option can be set through an
	 * options property or through a Unicode extension key; if both are provided,
	 * the options property takes precedence.
	 * kf
	 * Whether upper case or lower case should sort first. Possible values are "upper",
	 * "lower", or "false" (use the locale's default). This option can be set through
	 * an options property or through a Unicode extension key; if both are provided,
	 * the options property takes precedence.
	 * @param options Optional. An object with some or all of the following properties:
	 * localeMatcher
	 * The locale matching algorithm to use. Possible values are "lookup" and "best fit";
	 * the default is "best fit". For information about this option, see the Intl page.
	 * usage
	 * Whether the comparison is for sorting or for searching for matching strings.
	 * Possible values are "sort" and "search"; the default is "sort".
	 * sensitivity
	 * Which differences in the strings should lead to non-zero result values. Possible
	 * values are:
	 *   "base": Only strings that differ in base letters compare as unequal. Examples: a ≠ b, a = á, a = A.
	 *   "accent": Only strings that differ in base letters or accents and other diacritic marks compare as unequal. Examples: a ≠ b, a ≠ á, a = A.
	 *   "case": Only strings that differ in base letters or case compare as unequal. Examples: a ≠ b, a = á, a ≠ A.
	 *   "variant": Strings that differ in base letters, accents and other diacritic marks, or case compare as unequal. Other differences may also be taken into consideration. Examples: a ≠ b, a ≠ á, a ≠ A.
	 * The default is "variant" for usage "sort"; it's locale dependent for usage "search".
	 * ignorePunctuation
	 * Whether punctuation should be ignored. Possible values are true and false; the default is false.
	 * numeric
	 * Whether numeric collation should be used, such that "1" less "2" less "10". Possible
	 * values are true and false; the default is false. This option can be set through an
	 * options property or through a Unicode extension key; if both are provided, the options
	 * property takes precedence. Implementations are not required to support this property.
	 * caseFirst
	 * Whether upper case or lower case should sort first. Possible values are "upper", "lower", or
	 * "false" (use the locale's default); the default is "false". This option can be set through
	 * an options property or through a Unicode extension key; if both are provided, the options
	 * property takes precedence. Implementations are not required to support this property.
	 * @return TODO:
	 */
	public String localeCompare(String compareString, String locales, String options) {
		return null;
	}
	
	/**
	 * Retrieves the matches when matching a string against a regular expression.
	 * @param regexp A regular expression object. If a non-RegExp object obj is
	 * passed, it is implicitly converted to a RegExp by using new RegExp(obj).
	 * @return An Array containing the entire match result and any parentheses-captured
	 * matched results, or null if there were no matches.
	 */
	public Object match(oRegExp regexp) {
		return null;
	}
	
	/**
	 * Returns the Unicode Normalization Form of a given string (if the value
	 * isn't a string, it will be converted to one first).
	 * @param form One of "NFC", "NFD", "NFKC", or "NFKD", specifying the Unicode
	 * Normalization Form. If omitted or undefined, "NFC" is used.
	 * NFC — Normalization Form Canonical Composition.
	 * NFD — Normalization Form Canonical Decomposition.
	 * NFKC — Normalization Form Compatibility Composition.
	 * NFKD — Normalization Form Compatibility Decomposition.
	 * @return Unicode normalization form of given string.
	 */
	public String normalize(String form) {
		return value;
	}
	
	/**
	 * Constructs and returns a new string which contains the specified number of
	 * copies of the string on which it was called, concatenated together.
	 * @param count An integer between 0 and +inf: [0, +inf), indicating the number
	 * of times to repeat the string in the newly-created string that is to be returned.
	 * @return String repeated specified number of times.
	 */
	public String repeat(int count) {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<count; i++)
			s.append(value);
		return s.toString();
	}
	
	/**
	 * Returns a new string with some or all matches of a pattern replaced by a
	 * replacement. The pattern can be a string or a RegExp, and the replacement
	 * can be a string or a function to be called for each match.
	 * @param regexp A RegExp object or literal. The match is replaced by the
	 * return value of parameter #2.
	 * @param substr A String that is to be replaced by newSubStr. It is treated
	 * as a verbatim string and is not interpreted as a regular expression.
	 * @param newSubStr The String that replaces the substring received from
	 * parameter #1. A number of special replacement patterns are supported.
	 * @param function A function to be invoked to create the new substring (to
	 * put in place of the substring received from parameter #1).
	 * @return A new string with some or all matches of a pattern replaced by a replacement.
	 */
	public String replace() {
		return null;
	}
	
	/**
	 * Executes a search for a match between a regular expression and this String object.
	 * @param regexp A regular expression object. If a non-RegExp object obj is
	 * passed, it is implicitly converted to a RegExp by using new RegExp(obj).
	 * @return If successful, search() returns the index of the first match of
	 * the regular expression inside the string. Otherwise, it returns -1.
	 */
	public int search(oRegExp regexp) {
		return -1;
	}
	
	/**
	 * Extracts a section of a string and returns a new string.
	 * @param beginSlice The zero-based index at which to begin extraction. If
	 * negative, it is treated as sourceLength + beginSlice where sourceLength
	 * is the length of the string (for example, if beginSlice is -3 it is
	 * treated as sourceLength - 3).
	 * @param endSlice Optional. The zero-based index at which to end extraction.
	 * If omitted, slice() extracts to the end of the string. If negative, it is
	 * treated as sourceLength + endSlice where sourceLength is the length of the
	 * string (for example, if endSlice is -3 it is treated as sourceLength - 3).
	 * @return Extracts a region of the string.
	 */
	public String slice(int beginSlice, int endSlice) {
		return value.substring(beginSlice, endSlice);
	}
	/**
	 * Extracts a section of a string and returns a new string.
	 * @param beginSlice The zero-based index at which to begin extraction. If
	 * negative, it is treated as sourceLength + beginSlice where sourceLength
	 * is the length of the string (for example, if beginSlice is -3 it is
	 * treated as sourceLength - 3).
	 * @return Extracts a region of the string.
	 */
	public String slice(int beginSlice) {
		return value.substring(beginSlice);
	}
	
	/**
	 * Splits a String object into an array of strings by separating the string into substrings.
	 * @param separator Optional. Specifies the character(s) to use for separating the string.
	 * The separator is treated as a string or a regular expression. If separator is omitted,
	 * the array returned contains one element consisting of the entire string. If separator
	 * is an empty string, str is converted to an array of characters.
	 * @param limit Optional. Integer specifying a limit on the number of splits to be
	 * found. The split() method still splits on every match of separator, until the
	 * number of split items match the limit or the string falls short of seperator.
	 * @return Array of split strings.
	 */
	public String[] split(String separator, int limit) {
		return null;
	}
	/**
	 * Splits a String object into an array of strings by separating the string into substrings.
	 * @param separator Optional. Specifies the character(s) to use for separating the string.
	 * The separator is treated as a string or a regular expression. If separator is omitted,
	 * the array returned contains one element consisting of the entire string. If separator
	 * is an empty string, str is converted to an array of characters.
	 * @return Array of split strings.
	 */
	public String[] split(String separator) {
		return null;
	}
	/**
	 * Splits a String object into an array of strings by separating the string into substrings.
	 * @return Array of split strings.
	 */
	public String[] split() {
		return null;
	}
	
	/**
	 * Determines whether a string begins with the characters of another string,
	 * returning true or false as appropriate.
	 * @param searchString The characters to be searched for at the start of this string.
	 * @param position Optional. The position in this string at which to begin
	 * searching for searchString; defaults to 0.
	 * @return Whether or not a string begins with another string.
	 */
	public boolean startsWith(String searchString, int position) {
		return value.startsWith(searchString, position);
	}
	/**
	 * Determines whether a string begins with the characters of another string,
	 * returning true or false as appropriate.
	 * @param searchString The characters to be searched for at the start of this string.
	 * @return Whether or not a string begins with another string.
	 */
	public boolean startsWith(String searchString) {
		return value.startsWith(searchString);
	}
	
	/**
	 * Returns the characters in a string beginning at the specified location
	 * through the specified number of characters.
	 * @param start Location at which to begin extracting characters. If a
	 * negative number is given, it is treated as strLength + start where
	 * strLength is the length of the string (for example, if start is -3 it
	 * is treated as strLength - 3.)
	 * @param length Optional. The number of characters to extract.
	 * @return Substring starting at specified start index and of specified length.
	 */
	public String substr(int start, int length) {
		return value.substring(start, start+length);
	}
	/**
	 * Returns the characters in a string beginning at the specified location
	 * through the specified number of characters.
	 * @param start Location at which to begin extracting characters. If a
	 * negative number is given, it is treated as strLength + start where
	 * strLength is the length of the string (for example, if start is -3 it
	 * is treated as strLength - 3.)
	 * @return Substring starting at specified start index, till then end.
	 */
	public String substr(int start) {
		return value.substring(start);
	}
	
	/**
	 * Returns a subset of a string between one index and another, or through
	 * the end of the string.
	 * @param indexStart An integer between 0 and the length of the string,
	 * specifying the offset into the string of the first character to
	 * include in the returned substring.
	 * @param indexEnd Optional. An integer between 0 and the length of the
	 * string, which specifies the offset into the string of the first character
	 * not to include in the returned substring.
	 * @return Substring of the string from start index to end index.
	 */
	public String substring(int indexStart, int indexEnd) {
		return value.substring(indexStart, indexEnd);
	}
	/**
	 * Returns a subset of a string between one index and another, or through
	 * the end of the string.
	 * @param indexStart An integer between 0 and the length of the string,
	 * specifying the offset into the string of the first character to
	 * include in the returned substring.
	 * @return Substring of the string from start index to end.
	 */
	public String substring(int indexStart) {
		return value.substring(indexStart);
	}
	
	/**
	 * Returns the calling string value converted to lower case, according to
	 * any locale-specific case mappings.
	 * @return Value of the string converted to lower case according to any
	 * locale-specific case mappings.
	 */
	public String toLocaleLowerCase() {
		return value.toLowerCase();
	}
	
	/**
	 * Returns the calling string value converted to upper case, according to
	 * any locale-specific case mappings.
	 * @return Value of the string converted to upper case according to any
	 * locale-specific case mappings.
	 */
	public String toLocaleUpperCase() {
		return value.toUpperCase();
	}
	
	/**
	 * Returns the calling string value converted to lowercase.
	 * @return Value of the string converted to lowercase.
	 */
	public String toLowerCase() {
		return value.toLowerCase();
	}
	
	/**
	 * Returns the calling string value converted to uppercase.
	 * @return Value of the string converted to uppercase.
	 */
	public String toUpperCase() {
		return value.toUpperCase();
	}
	
	/**
	 * Removes whitespace from both ends of a string. Whitespace in this context
	 * is all the whitespace characters (space, tab, no-break space, etc.) and
	 * all the line terminator characters (LF, CR, etc.).
	 * @return String stripped from whitespace, on the left and right.
	 */
	public String trim() {
		return value.trim();
	}
	
	/* super method */
	@Override
	public String toString() {
		return value;
	}
	
	// TODO:
	public Object valueOf() {
		return value;
	}
}
