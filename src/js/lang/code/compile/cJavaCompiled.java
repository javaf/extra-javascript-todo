package js.lang.code.compile;
import javax.tools.*;
import java.net.*;
import java.io.*;

/**
 * Represents compiled java code.
 * @author trung, wolfram77
 */
public class cJavaCompiled extends SimpleJavaFileObject {
	
	/* data */
	/** Defines compiled java byte code. */
	private final ByteArrayOutputStream out;
	
	
	/* constructor */
	/**
	 * Initializes cJavaCompiled with specified class name.
	 * @param className Class name of compiled java code.
	 * @throws URISyntaxException If class name is invalid.
	 */
	public cJavaCompiled(String className) throws URISyntaxException {
		super(new URI(className), Kind.CLASS);
		out = new ByteArrayOutputStream();
	}
	
	
	/* property */
	/**
	 * Returns java compiled byte code.
	 * @return Compiled byte code.
	 */
	public byte[] byteCode() {
		return out.toByteArray();
	}
	
	
	/* super method */
	@Override
	public OutputStream openOutputStream() {
		return out;
	}
}
