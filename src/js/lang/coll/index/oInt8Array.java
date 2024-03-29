package js.lang.coll.index;
import java.nio.*;
import java.util.*;

/**
 * The Int8Array typed array represents an array of twos-complement 8-bit
 * signed integers. The contents are initialized to 0. Once established, you
 * can reference elements in the array using the object's methods, or using
 * standard array index syntax (that is, using bracket notation).
 */
public class oInt8Array extends oArray {
	
	/* static data */
	/** Returns a number value of the element size. 1 in the case of an Int8Array. */
	public final static int BYTES_PER_ELEMENT = 1;
	/** Returns the string value of the constructor name. In the case of the Int8Array type: "Int8Array". */
	public static final String name = "Int8Array";
	
	
	/* data */
	/** Stores the int8 values. */
	private final ByteBuffer o;
	
	
	/* constructor */
	public oInt8Array(int length) {
		super(0);
		o = ByteBuffer.allocate(length);
	}
	
	
	/* property */
	/**
	 * Get the elements as a byte array.
	 * @return Byte array containing the elements.
	 */
	public final byte[] array() {
		return o.array();
	}
	
	/**
	 * Get the value stored at given index.
	 * @param index Location of stored value.
	 * @return Int8 value.
	 */
	@Override
	public final Byte get(int index) {
		return getByte(index);
	}
	/**
	 * Get the byte stored at given index.
	 * @param index Location of stored value.
	 * @return byte value.
	 */
	public final byte getByte(int index) {
		return o.get(index);
	}
	
	/**
	 * Set the value stored at given index.
	 * @param index Location of value storage.
	 * @param value New Int8 value.
	 * @return Int8 value.
	 */
	public Byte set(int index, Byte value) {
		return setByte(index, value);
	}
	public byte setByte(int index, byte value) {
		o.put(index, value);
		return value;
	}
	
	public Object buffer() {
		return null;
	}
	
	public int byteLength() {
		return 0;
	}
	
	public int byteOffset() {
		return 0;
	}
	
	@Override
	public int length() {
		return o.capacity();
	}
	
	
	
	
	@Override
	public void values() {
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	public byte[] valueOf() {
		return array();
	}
	
	
	/* static method */
	public static final oInt8Array from(Iterable<Byte> source) {
		oInt8Array a = new oInt8Array(BYTES_PER_ELEMENT);
		byte[] b = new byte[1];
		for(Byte v : source)
			b[0] = (byte)v;
		return a;
	}
	
	
	
	/**
	 * Creates a new typed array with a variable number of arguments. This method
	 * is nearly the same as Array.of().
	 * @param elements Elements of which to create the typed array.
	 * @return Typed array created from arguments.
	 */
	public static final oInt8Array of(byte... elements) {
		return new oInt8Array(elements.length); // value = elements
	}
}
