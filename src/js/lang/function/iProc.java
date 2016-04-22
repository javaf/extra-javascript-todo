package js.lang.function;
import java.lang.invoke.*;
import js.lang.object.*;
import js.lang.array.*;

/**
 * Represents a procedure which can be called with variable arguments, and it
 * returns a value or null.
 */
public interface iProc extends iToString {

	/* property */
	/**
	 * Specifies the method type of the functional method.
	 * @return Method type.
	 */
	default MethodType type() {
		return null;
	}
	
	
	/* static method */
	/**
	 * Returns generic signature for a procedure.
	 * @param ret Return type of the procedure.
	 * @param params Number of input parameters.
	 * @return Method type of procedure.
	 */
	static MethodType type(boolean ret, int params) {
		return MethodType.methodType(ret? Object.class : void.class, cArray.fill(new Class<?>[params], Object.class));
	}
	
	
	/* method */
	/**
	 * Calls the (main) procedure of this object defined in a class, which implements
	 * a super-interface to this interface.
	 * @param args The input arguments to pass to the procedure.
	 * @return The output value.
	 */
	Object call(Object... args);
	
	/**
	 * Returns string representation of the procedure.
	 * @return String representation of procedure.
	 */
	@Override
	default String z_toString() {
		MethodType t = type();
		StringBuilder s = new StringBuilder();
		s.append(t==null? "?" : t.returnType()).append(" (");
		if(t==null) s.append("Object... args");
		else for(int i=0; i<t.parameterCount(); i++)
			s.append(t.parameterType(i)).append(' ').append((char)('a'+i)).append(", ");
		if(t!=null && t.parameterCount()>0) s.delete(s.length()-2, s.length());
		return s.append(") { [native code] }").toString();
	}
}
