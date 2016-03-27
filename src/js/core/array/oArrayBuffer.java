package js.core.array;
import java.nio.*;


/**
 * The ArrayBuffer object is used to represent a generic, fixed-length raw
 * binary data buffer. You can not directly manipulate the contents of an
 * ArrayBuffer; instead, you create one of the typed array objects or a
 * DataView object which represents the buffer in a specific format, and use
 * that to read and write the contents of the buffer.
 */
public class oArrayBuffer {
	
	/* data */
	public final ByteBuffer buffer;
	public final int offset, length;
	
	/* constructor */
	/**
	 * Create a new fixed-length array buffer.
	 * @param length Size of the buffer, in bytes.
	 */
	public oArrayBuffer(int length) {
		buffer = ByteBuffer.allocate(length);
		this.length = length;
		offset = 0;
	}
	protected oArrayBuffer(ByteBuffer buffer, int offset, int length) {
		this.buffer = buffer;
		this.offset = offset;
		this.length = length;
	}
	
	
	/* property */
	public int byteLength() {
		return length;
	}
	
	public static void isView() {
		
	}
	
	public static void transfer() {
		
	}
	
	public int length() {
		return 0;
	}
	
	public int length(int v) {
		return 0;
	}
	
	public oArrayBuffer slice(int begin, int end) {
		return new oArrayBuffer(buffer, begin>=0? (begin<length? begin+offset :offset+length) : 0, length);
	}
}
