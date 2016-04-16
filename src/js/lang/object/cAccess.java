package js.lang.object;
import java.util.function.*;
import java.util.*;


/**
 * Defines descriptors for special oObject properties.
 */
public class cAccess<T> {
	
	/* data */
	/**
	 * True if and only if the type of this property descriptor may be changed
	 * and if the property may be deleted from the corresponding object. Defaults
	 * to false.
	 */
	public boolean configurable;
	/**
	 * True if and only if this property shows up during enumeration of the
	 * properties on the corresponding object. Defaults to false.
	 */
	public boolean enumerable;
	/**
	 * True if and only if the value associated with the property may be changed
	 * with an assignment operator. Defaults to false.
	 */
	public boolean writable;
	/**
	 * A function which serves as a getter for the property, or null if there is
	 * no getter. The function return will be used as the value of property.
	 * Defaults to null.
	 */
	public Supplier<T> get;
	/**
	 * A function which serves as a setter for the property, or null if there is
	 * no setter. The function will receive as only argument the new value being
	 * assigned to the property. Defaults to null.
	 */
	public Consumer<T> set;
	/**
	 * The value associated with the property. Can be any valid JavaScript value
	 * (number, object, function, etc). Defaults to null.
	 */
	public T value;
	
	
	/* constructor */
	/**
	 * Creates an oObject descriptor.
	 * @param val Map describing the descriptor. Options not provided are set to default.
	 */
	public cAccess(Map val) {
		set(val);
	}
	/**
	 * Creates an oObject descriptor.
	 * @param configurable Tells is property is configurable.
	 * @param enumerable Tells if property is enumerable.
	 * @param writable Tells if property can be written to.
	 * @param value Defines the value of property (if accessors are not set).
	 * @param get Defines get accessor for property.
	 * @param set Defines set accessor for property.
	 */
	public cAccess(boolean configurable, boolean enumerable, boolean writable, Supplier<T> get, Consumer<T> set, T value) {
		this.configurable = configurable;
		this.enumerable = enumerable;
		this.writable = writable;
		this.value = value;
		this.get = get;
		this.set = set;
	}
	/**
	 * Creates an oObject descriptor with default options.
	 */
	public cAccess() {
	}
	
	
	/* method */
	/**
	 * Gets the fields as a map.
	 * @param o Input map where values are to be stored.
	 * @return Fields as a map.
	 */
	public final Map get(Map o) {
		o.put("configurable", configurable);
		o.put("enumerable", enumerable);
		o.put("writable", writable);
		o.put("value", value);
		o.put("get", get);
		o.put("set", set);
		return o;
	}

	/**
	 * Set the fields with a map.
	 * @param val Map with field names, and values.
	 */
	public final void set(Map val) {
		if(val==null) return;
		for(Object k : val.keySet()) {
			Object v = val.get(k);
			switch(k.toString()) {
				case "configurable": configurable = (boolean)v; break;
				case "enumerable": enumerable = (boolean)v; break;
				case "writable": writable = (boolean)v; break;
				case "get": get = (Supplier<T>)v; break;
				case "set": set = (Consumer<T>)v; break;
				case "value": value = (T)v; break;
			}
		}
	}
	
	/**
	 * Indicates if a property is a data property.
	 * @return True if it is a data property, else false.
	 */
	public final boolean isData() {
		return get==null && set==null;
	}
}
