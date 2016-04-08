package js.lang.code.compile;
import javax.tools.*;
import java.net.*;
import java.io.*;

/**
 * Represents java source code, to be used for in-memory compilation.
 * @author trung, wolfram77
 */
public class cJavaSource extends SimpleJavaFileObject {
	
	/* data */
	/** Defines the source content. */
	private final String content;
	
	
	/* constructor */
	/**
	 * Creates a cJavaSource from specified class name and contents.
	 * @param className Name of the java class.
	 * @param content Actual source code of the class.
	 */
	public cJavaSource(String className, String content) {
		super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
		this.content = content;
	}
	
	
	/* super method */
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return content;
	}
}
