package js;
import java.util.*;
import java.util.function.*;


/**
 * Defines descriptors for special oObject properties.
 */
class oObjectDescriptor {
	
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
	public oObjectDescriptor(Map value) {
		if(value == null) return;
		if(value.get("configurable") instanceof Boolean) configurable = (Boolean)value.get("configurable");
		if(value.get("enumerable") instanceof Boolean) enumerable = (Boolean)value.get("enumerable");
		if(value.get("writeable") instanceof Boolean) writeable = (Boolean)value.get("writeable");
		if(value.get("get") instanceof Supplier) get = (Supplier)value.get("get");
		if(value.get("set") instanceof Consumer) set = (Consumer)value.get("set");
		if(get==null && set==null) this.value = value.get("value");
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
	public oObjectDescriptor(boolean configurable, boolean enumerable, boolean writeable, Object value, Supplier get, Consumer set) {
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
	public oObjectDescriptor() {
	}
	
	
	/**
	 * Indicates if a property is a data property.
	 * @return True if it is a data property, else false.
	 */
	public final boolean isData() {
		return get==null && set==null;
	}
}
