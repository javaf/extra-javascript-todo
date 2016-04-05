package js.lang;

/**
 * The oBoolean object is an object wrapper for a boolean value.
 */
public class oBoolean {

	/* data */
	boolean value;
	
	/* constructor */
	/**
	 * Create an oBoolean object, which is set to true if value is truthy.
	 * @param value Value used to set the boolean value.
	 */
	public oBoolean(Object value) {
		this.value = true;
		if(value==null) this.value = false;
		else if(value instanceof Boolean) this.value = (Boolean)value;
		else if(value instanceof Double) this.value = (Double)value==0 || (Double)value==Double.NaN;
		else if(value instanceof CharSequence) this.value = ((CharSequence)value).length()==0;
	}
	/**
	 * Create an oBoolean object, which is set to true if value is truthy.
	 * @param value Value used to set the boolean value.
	 */
	public oBoolean(boolean value) {
		this.value = value;
	}
	/**
	 * Create an oBoolean object, which is set to true if value is truthy.
	 */
	public oBoolean() {
		this(false);
	}
	
	/**
	 * Returns a string of either "true" or "false" depending upon the value of
	 * the object. 
	 * @return String value.
	 */
	@Override
	public String toString() {
		return value? "true" : "false";
	}
	
	/**
	 * Returns the primitive value of the Boolean object.
	 * @return Primitive value.
	 */
	public Object valueOf() {
		return value;
	}
}
