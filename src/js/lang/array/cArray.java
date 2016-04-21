package js.lang.array;
import java.nio.*;
import java.util.Iterator;

public class cArray<T> implements Iterable<T> {
	
	/* data */
	ByteBuffer buffer;
	Object array;
	
	
	
	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
