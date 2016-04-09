package js.lang.object;

public class cObject {
	
	/* data */
	private final Object value;
	
	
	/* constructor */
	public cObject(Object v) {
		value = v;
	}
	
	
	/* property */
	public Object get(String prop) {
		try { return value.getClass().getField(prop).get(value); }
		catch(Exception e) {throw new RuntimeException(e); }
	}
	
	public Object set(String prop, Object value) {
		try { this.value.getClass().getField(prop).set(this.value, value); return value; }
		catch(Exception e) { throw new RuntimeException(e); }
	}
	
	public boolean propertyIsEnumerable() {
		return false;
	}
}
