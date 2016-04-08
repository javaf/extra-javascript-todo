package js.lang.code.compile;
import javax.tools.*;

/**
 * Represents code manager for java compiled code, and loading it dynamically.
 * @author trung, wolfram77
 */
public class cJavaCodeManager extends ForwardingJavaFileManager<JavaFileManager> {
	
	/* data */
	/** Compiled java code. */
	private final cJavaCompiled compiled;
	/** Dynamic class loader. */
	private final cJavaClassLoader loader;
	
	
	/* constructor */
	/**
	 * Create a new cJavaCodemanager.
	 * @param fileManager Java file manager.
	 * @param compiled Java compiled code.
	 * @param loader Dynamic class loader.
	 */
	protected cJavaCodeManager(JavaFileManager fileManager, cJavaCompiled compiled, cJavaClassLoader loader) {
		super(fileManager);
		this.compiled = compiled;
		this.loader = loader;
		this.loader.add(compiled);
	}
	
	
	/* super method */
	@Override
	public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind, FileObject sibling) {
		return compiled;
	}
	
	@Override
	public ClassLoader getClassLoader(JavaFileManager.Location location) {
		return loader;
	}
}
