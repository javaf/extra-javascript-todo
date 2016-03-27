package js.core;
import java.util.*;


/**
 * Defines value for an oObject.
 */
class zObjectValue extends HashMap<String, Object> {
	
	/* data */
	/** Defines the value of primitive object. */
	public Object primitive;
	/** Defines the prototype of this object. */
	public iObject prototype;
	/** Tells whether this object is extensible. */
	public boolean extensible;
	/** Describes the state of properties. */
	public HashMap<String, zObjectDescriptor> descriptor;

	
	/* constructor */
	/**
	 * Creates a new object value.
	 */
	public zObjectValue() {
		descriptor = new HashMap<>();
	}
	
	
	/* method */
	/**
	 * Get the value of a property.
	 * @param key Name of the property.
	 * @return Property value.
	 */
	public final Object prop(String key) {
		zObjectDescriptor desc = descriptor.get(key);
		if(desc!=null && !desc.isData()) return desc.get!=null? desc.get.get() : null;
		return containsKey(key)? super.get(key) : (prototype!=null? prototype.get(key) : null);
	}
	
	/**
	 * Put the value of a property.
	 * @param key Name of the property.
	 * @param value New property value.
	 * @return Old property value.
	 */
	public final Object prop(String key, Object value) {
		zObjectDescriptor desc = descriptor.get(key);
		if(desc==null) return !containsKey(key) && prototype!=null && prototype.containsKey(key)? prototype.put(key, value) : super.put(key, value);
		if(desc.isData()) { if(desc.writeable) return super.put(key, value); }
		else if(desc.set!=null) desc.set.accept(value);
		return null;
	}
	
	/**
	 * Remove a property from object, if it is configurable.
	 * @param key Property to remove.
	 * @return Old value.
	 */
	public final Object delete(String key) {
		boolean hasd = descriptor.containsKey(key);
		if(!containsKey(key) || hasd && !descriptor.get(key).configurable) return null;
		if(hasd) descriptor.remove(key);
		return super.remove(key);
	}

	/**
	 * Checks if object data is locked upto a certain level.
	 * @param l Lock level (0: unlock, 1: preventExtensions, 2: seal, 3: freeze)
	 */
	public final boolean isLocked(int l) {
		if(l>0 && extensible) return false;
		if(l>1 && size()>descriptor.size()) return false;
		if(l>1) for(zObjectDescriptor d : descriptor.values())
			if(d.configurable || (l>2 && d.isData() && d.writeable)) return false;
		return true;
	}
	
	/**
	 * Locks or unlocks this object data.
	 * @param l Lock level (0: unlock, 1: preventExtensions, 2: seal, 3: freeze)
	 */
	public final void lock(int l) {
		extensible = l>0;
		for(String key : keySet()) {
			zObjectDescriptor d = descriptor.get(key);
			if(d!=null) { d.configurable = l<2; if(d.isData()) d.writeable = l>0? (l<3? d.writeable : false) : true; }
			else if(l>1) descriptor.put(key, new zObjectDescriptor(false, true, l<3, null, null, null));
		}
	}
}
