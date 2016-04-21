package js.lang.array;
import java.nio.*;
import java.util.Arrays;
import java.util.Iterator;

public class cArray<T> implements Iterable<T> {
	
	/* data */
	ByteBuffer buffer;
	Object array;
	
	
	public static <T> T[] fill(T[] dst, T value) {
		Arrays.fill(dst, value);
		return dst;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
