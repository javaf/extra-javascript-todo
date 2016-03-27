package js.core;
import java.util.*;
import java.util.regex.*;
import java.util.function.*;

/**
 * The oJSON class contains methods for parsing JavaScript Object Notation
 (oJSON) and converting values to oJSON.
 */
public class oJSON {
	
	/* data */
	private static Pattern _string = Pattern.compile("[^\\\\]\"");
	private static Pattern _number = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
	
	public static Object parse(String text) {
		return null;
	}
	private static Object _parse(String text) {
		return null;
	}
	private static Map _parseMap(String text) {
		return null;
	}
	private static Iterable _parseArray(String text) {
		return null;
	}
	private static Object _parseValue(String text) {
		if(text.startsWith("\"")) return text.substring(1, text.length()-1);
		if(text.equalsIgnoreCase("true")) return true;
		if(text.equalsIgnoreCase("false")) return false;
		return null;
	}
	public static String _parseString(String t) {
		if(t.charAt(0) != '\"') return null;
		Matcher m = _string.matcher(t);
		if(!m.find()) return null;
		return t.substring(1, m.end()-1);
	}
	
	
	/**
	 * Converts a JavaScript value to a oJSON string, optionally replacing values
 if a replacer function is specified, or optionally including only the
 specified properties if a replacer array is specified.
	 * @param value The value to convert to a oJSON string.
	 * @return oJSON string corresponding to the specified value, optionally
 including only certain properties or replacing property values in a
 user-defined manner.
	 */
	public static String stringify(Object value) {
		return stringify(value, null, "");
	}
	/**
	 * Converts a JavaScript value to a oJSON string, optionally replacing values
 if a replacer function is specified, or optionally including only the
 specified properties if a replacer array is specified.
	 * @param value The value to convert to a oJSON string.
	 * @param replacer Optional. A function that alters the behavior of the
 stringification process, or an array of String and Number objects that
 serve as a whitelist for selecting the properties of the value object to
 be included in the oJSON string. If this value is null or not provided, all
 properties of the object are included in the resulting oJSON string.
	 * @return oJSON string corresponding to the specified value, optionally
 including only certain properties or replacing property values in a
 user-defined manner.
	 */
	public static String stringify(Object value, Object replacer) {
		return stringify(value, replacer, "");
	}
	/**
	 * Converts a JavaScript value to a oJSON string, optionally replacing values
 if a replacer function is specified, or optionally including only the
 specified properties if a replacer array is specified.
	 * @param value The value to convert to a oJSON string.
	 * @param replacer Optional. A function that alters the behavior of the
 stringification process, or an array of String and Number objects that
 serve as a whitelist for selecting the properties of the value object to
 be included in the oJSON string. If this value is null or not provided, all
 properties of the object are included in the resulting oJSON string.
	 * @param space Optional. A String or Number object that's used to insert
 white space into the output oJSON string for readability purposes. If this
 is a Number, it indicates the number of space characters to use as white
 space; this number is capped at 10 if it's larger than that. Values less
 than 1 indicate that no space should be used. If this is a String, the
 string (or the first 10 characters of the string, if it's longer than
 that) is used as white space. If this parameter is not provided (or is
 null), no white space is used.
	 * @return oJSON string corresponding to the specified value, optionally
 including only certain properties or replacing property values in a
 user-defined manner.
	 */
	public static String stringify(Object value, Object replacer, double space) {
		return stringify(value, replacer, _repeat(" ", (int)space));
	}
	/**
	 * Converts a JavaScript value to a oJSON string, optionally replacing values
 if a replacer function is specified, or optionally including only the
 specified properties if a replacer array is specified.
	 * @param value The value to convert to a oJSON string.
	 * @param replacer Optional. A function that alters the behavior of the
 stringification process, or an array of String and Number objects that
 serve as a whitelist for selecting the properties of the value object to
 be included in the oJSON string. If this value is null or not provided, all
 properties of the object are included in the resulting oJSON string.
	 * @param space Optional. A String or Number object that's used to insert
 white space into the output oJSON string for readability purposes. If this
 is a Number, it indicates the number of space characters to use as white
 space; this number is capped at 10 if it's larger than that. Values less
 than 1 indicate that no space should be used. If this is a String, the
 string (or the first 10 characters of the string, if it's longer than
 that) is used as white space. If this parameter is not provided (or is
 null), no white space is used.
	 * @return oJSON string corresponding to the specified value, optionally
 including only certain properties or replacing property values in a
 user-defined manner.
	 */
	public static String stringify(Object value, Object replacer, String space) {
		space = space.length()>20? space.substring(0, 20) : space;
		replacer = replacer==null? (BiFunction)((Object k, Object v) -> { return v; }) : replacer;
		return _stringify(value, (BiFunction)replacer, "", space);
	}
	/**
	 * Internal: Converts an object into a string.
	 * @param o Value of object.
	 * @param f Replacer function.
	 * @param s Current space value.
	 * @param r Original space value.
	 * @return String representation of object.
	 */
	private static String _stringify(Object o, BiFunction f, String s, String r) {
		o = f.apply("", o);
		String ret = _stringifyMap(o, f, s, r);
		ret = ret==null? _stringifyArray(o, f, s, r) : ret;
		ret = ret==null? _stringifyValue(o) : ret;
		return ret;
	}
	/**
	 * Internal: Converts a map type object into a string.
	 * @param o Value of object.
	 * @param f Replacer function.
	 * @param s Current space value.
	 * @param r Original space value.
	 * @return String representation of object.
	 */
	private static String _stringifyMap(Object o, BiFunction f, String s, String r) {
		int rlen = r.length();
		String m = rlen>0? " " : "", e = rlen>0? "\n" : "", t = s+r;
		StringBuilder z = new StringBuilder(rlen>0? "{\n" : "{");
		if(o instanceof Map) for(Object k : ((Map)o).keySet())
			z.append(t).append('\"').append(k).append("\":").append(m).append(_stringify(f.apply(k, ((Map)o).get(k)), f, t, r)).append(',').append(e);
		else if(o instanceof Dictionary) for(Object k : Collections.list(((Dictionary)o).keys()))
			z.append(t).append('\"').append(k).append("\":").append(m).append(_stringify(f.apply(k, ((Dictionary)o).get(k)), f, t, r)).append(',').append(e);
		else return null;
		if(z.length() > 1) z.deleteCharAt(z.length()-e.length()-1);
		return z.append(s).append('}').toString();
	}
	/**
	 * Internal: Converts an array type object into a string.
	 * @param o Value of object.
	 * @param f Replacer function.
	 * @param s Current space value.
	 * @param r Original space value.
	 * @return String representation of object.
	 */
	private static String _stringifyArray(Object o, BiFunction f, String s, String r) {
		int i = 0, rlen = r.length();
		String e = rlen>0? "\n" : "", t = s+r;
		StringBuilder z = new StringBuilder(rlen>0? "[\n" : "[");
		if(o instanceof Iterable) for(Object v : (Iterable)o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof Object[]) for(Object v : (Object[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof byte[]) for(byte v : (byte[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof short[]) for(short v : (short[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof int[]) for(int v : (int[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof long[]) for(long v : (long[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof float[]) for(float v : (float[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof double[]) for(double v : (double[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof boolean[]) for(boolean v : (boolean[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else if(o instanceof char[]) for(char v : (char[])o)
			z.append(t).append(_stringify(f.apply(i++, v), f, t, r)).append(',').append(e);
		else return null;
		if(z.length() > 1) z.deleteCharAt(z.length()-e.length()-1);
		return z.append(s).append(']').toString();
	}
	/**
	 * Internal: Converts a value type object into a string.
	 * @param o Value of object.
	 * @return String representation of object.
	 */
	private static String _stringifyValue(Object o) {
		if(o instanceof CharSequence || o instanceof Character) return "\""+o.toString()+"\"";
		return o != null? o.toString() : "null";
	}
	/**
	 * Internal: Repeat a string value specified number of times.
	 * @param value String to repeat.
	 * @param count Number of times to repeat.
	 * @return String with repeated value.
	 */
	private static String _repeat(String value, int count) {
		StringBuilder str = new StringBuilder();
		for(int i=0; i<count; i++)
			str.append(value);
		return str.toString();
	}
}
