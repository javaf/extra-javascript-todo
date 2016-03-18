package js;
import java.util.*;


/**
 * Defines data for an oObject.
 */
class oObjectData extends HashMap {
	
	/* data */
	public oObject prototype;
	public boolean extensible, sealed;
	public HashMap<Object, oObjectDescriptor> descriptor;
	
	/* method */
	@Override
	public final Object get(Object key) {
		if(descriptor.containsKey(key) && descriptor.get(key).get!=null) return descriptor.get(key).get.get();
		return containsKey(key)? super.get(key) : (prototype != null? prototype.get(key) : null);
	}
	
	@Override
	public final Object put(Object key, Object value) {
		return null;
	}
	
	public final boolean isExtensible() {
		return extensible;
	}
	
	public final boolean isFrozen() {
		if(extensible || size()>descriptor.size()) return false;
		for(oObjectDescriptor d : descriptor.values())
			if(d.configurable && (!d.writeable || (d.get==null && d.set==null))) return false;
		return true;
	}
	
	public final boolean isSealed() {
		if(extensible || size()>descriptor.size()) return false;
		for(oObjectDescriptor d : descriptor.values())
			if(d.configurable) return false;
		return true;
	}
	
	public final void preventExtensions() {
		extensible = false;
	}
	
	public final void freeze() {
		preventExtensions();
		for(Object key : keySet())
			if(!descriptor.containsKey(key)) descriptor.put(key, new oObjectDescriptor(false, true, false, super.get(key), null, null));
	}
}
