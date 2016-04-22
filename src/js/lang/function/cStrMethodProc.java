package js.lang.function;
import js.lang.code.compile.*;
import java.lang.invoke.*;

/**
 * Defines a method which can be called.
 * @param <TR> Return type of method.
 */
public class cStrMethodProc<TR> implements iProc<TR> {
	
	/* static data */
	/** Indicates the number of dynamically generated classes. */
	private static long classNo;
	
	
	/* data */
	/** Defines the method call procedure for the specified method string. */
	private final iProc proc;
	
	
	/* constructor */
	/**
	 * Creates method call procedure for specified method string (requires JDK). The
	 * method string is used to generate class code, which is then compiled. A bound
	 * procedure is returned which the same generic signature as the original method.
	 * @param args Names to be used by the function as formal argument names. Each must
	 * be a string that corresponds to a valid Java identifier or a list of such strings
	 * separated with a comma; for example "x", "theValue", or "a,b". The last value must
	 * be a string containing the Java statements comprising the function definition.
	 */
	public cStrMethodProc(String... args) {
		int argn = args.length-1;
		if(argn<0) { proc = (iSub0)() -> {}; return; }
		String code = args[argn], cName = "c"+classNumber();
		boolean isvoid = !code.contains("return") || code.replace(" ", "").contains("return;");
		StringBuilder s = new StringBuilder("package js.lang.function.dynamic;");
		s.append("public class ").append(cName).append(" implements js.lang.function.");
		s.append(isvoid? "iConsumer" : "iFunction").append(argn).append(" {");
		s.append("public ").append(isvoid? "void accept(" : "Object apply(");
		for(int i=0; i<argn; i++)
			s.append("Object ").append(args[i]).append(", ");
		if(argn>0) s.delete(s.length()-2, s.length());
		s.append(") { ").append(code).append(" } }");
		try { proc = (iProc)cJavaMemoryCompiler.compile("js.lang.function.dynamic."+cName, s.toString()).newInstance(); }
		catch(Exception e) { throw new RuntimeException(e); }
	}
	
	
	/* static property */
	/**
	 * Returns number of dynamically generated classes, and increments it.
	 * @return Number of dynamically generated classes.
	 */
	private static synchronized long classNumber() {
		return classNo++;
	}
	
	
	/* super property */
	@Override
	public MethodType type() {
		return proc.type();
	}
	
	
	/* super method */
	@Override
	public final TR call(Object... a) {
		return (TR)proc.call(a);
	}
	
	@Override
	public final Object valueOf() {
		return proc;
	}
	
	@Override
	public final String z_toString() {
		return proc.z_toString();
	}
	
	@Override
	public final String toString() {
		return z_toString();
	}
}
