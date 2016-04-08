package js.lang.code.compile;
import javax.tools.*;
import java.util.*;

/**
 * Represents in memory java compiler.
 * @author trung, wolfram77
 */
public class cJavaMemoryCompiler {
	
	/* static data */
	/** Java compiler provided by JDK. */
	private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	
	
	/* static method */
	/**
	 * Compile a java class code.
	 * @param className Full name of the java class.
	 * @param content String content of the java class.
	 * @return Dynamically loaded class.
	 * @throws Exception If class name is invalid or dynamic loading fails.
	 */
	public static Class<?> compile(String className, String content) throws Exception {
		cJavaSource source = new cJavaSource(className, content);
		cJavaCompiled compiled = new cJavaCompiled(className);
		Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(source);
		cJavaClassLoader loader = new cJavaClassLoader(ClassLoader.getSystemClassLoader()).add(compiled);
		cJavaCodeManager manager = new cJavaCodeManager(compiler.getStandardFileManager(null, null, null), compiled, loader);
		JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, compilationUnits);
		boolean result = task.call();
		return loader.loadClass(className);
	}
}
