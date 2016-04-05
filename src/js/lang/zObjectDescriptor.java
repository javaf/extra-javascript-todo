package js.lang;
import java.util.*;
import java.util.function.*;


/**
 * Defines descriptors for special oObject properties.
 */
class zObjectDescriptor {
	
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
	public boolean writeable;
	/**
	 * The value associated with the property. Can be any valid JavaScript value
	 * (number, object, function, etc). Defaults to null.
	 */
	public Object value;
	/**
	 * A function which serves as a getter for the property, or null if there is
	 * no getter. The function return will be used as the value of property.
	 * Defaults to null.
	 */
	public Supplier get;
	/**
	 * A function which serves as a setter for the property, or null if there is
	 * no setter. The function will receive as only argument the new value being
	 * assigned to the property. Defaults to null.
	 */
	public Consumer set;
	
	
	/* constructor */
	/**
	 * Creates an oObject descriptor.
	 * @param value Map describing the descriptor. Options not provided are set to default.
	 */
	public zObjectDescriptor(Map value) {
		set(value);
	}
	/**
	 * Creates an oObject descriptor.
	 * @param configurable Tells is property is configurable.
	 * @param enumerable Tells if property is enumerable.
	 * @param writeable Tells if property can be written to.
	 * @param value Defines the value of property (if accessors are not set).
	 * @param get Defines get accessor for property.
	 * @param set Defines set accessor for property.
	 */
	public zObjectDescriptor(boolean configurable, boolean enumerable, boolean writeable, Object value, Supplier get, Consumer set) {
		this.configurable = configurable;
		this.enumerable = enumerable;
		this.writeable = writeable;
		this.value = get==null && set==null? value : null;
		this.get = get;
		this.set = set;
	}
	/**
	 * Creates an oObject descriptor with default options.
	 */
	public zObjectDescriptor() {
	}
	
	
	/* method */
	/**
	 * Gets the fields as a map.
	 * @return Fields as a map.
	 */
	public final oObject get() {
		oObject o = new oObject();
		o.set("configurable", configurable);
		o.set("enumerable", enumerable);
		o.set("writeable", writeable);
		o.set("value", value);
		o.set("get", get);
		o.set("set", set);
		return o;
	}

	/**
	 * Set the fields with a map.
	 * @param value Map with field names, and values.
	 */
	public final void set(Map value) {
		if(value==null) return;
		for(Object k : value.keySet()) {
			Object v = value.get(k);
			switch(k.toString()) {
				case "configurable": configurable = (Boolean)v; break;
				case "enumerable": enumerable = (Boolean)v; break;
				case "writeable": writeable = (Boolean)v; break;
				case "value": this.value = v; break;
				case "get": get = (Supplier)v; break;
				case "set": set = (Consumer)v; break;
			}
		}
		this.value = get==null && set==null? this.value : null;
	}
	
	/**
	 * Indicates if a property is a data property.
	 * @return True if it is a data property, else false.
	 */
	public final boolean isData() {
		return get==null && set==null;
	}
}
