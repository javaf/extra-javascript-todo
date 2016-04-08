package js.lang.code.compile;
import java.util.*;

/**
 * Represents class loader for java compiled code.
 * @author trung, wolfram77
 */
public class cJavaClassLoader extends ClassLoader {
	
	/* data */
	/** Defines java compiled code for each class (in map) */
	private final Map<String, cJavaCompiled> code;
	
	
	/* constructor */
	/**
	 * Creates cJavaClassLoader, where multiple classes can each have a compiled code.
	 * @param parent Parent class loader object.
	 */
	public  cJavaClassLoader(ClassLoader parent) {
		super(parent);
		code = new HashMap<>();
	}
	
	
	/* property */
	/**
	 * Add java compiled code to class loader.
	 * @param cls java compiled code, of a class.
	 * @return This object.
	 */
	public cJavaClassLoader add(cJavaCompiled cls) {
		code.put(cls.getName(), cls);
		return this;
	}
	
	
	/* super method */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		cJavaCompiled cls = code.get(name);
		if(cls==null) return super.findClass(name);
		byte[] byteCode = cls.byteCode();
		return super.defineClass(name, byteCode, 0, byteCode.length);
	}
}
