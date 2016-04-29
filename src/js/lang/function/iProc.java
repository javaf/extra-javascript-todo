package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;
import js.lang.object.*;
import js.lang.array.*;

/**
 * Represents a procedure which can be called with variable arguments, and it
 * returns a value or null.
 * @param <TR> Return type.
 */
public interface iProc<TR> extends iObj {
	
	/* static method */
	/**
	 * Get a method object from class and its specified name. The returned method
	 * object is obtained through reflection.
	 * @param clazz Class object which contains the method.
	 * @param method Name of the method.
	 * @param parameterTypes Parameter types of the method.
	 * @return Field object.
	 */
	static Method method(Class<?> clazz, String method, Class<?>[] parameterTypes) {
		try { return clazz.getMethod(method, parameterTypes); }
		catch(NoSuchMethodException | SecurityException e) { throw new RuntimeException(e); }
	}
	
	/**
	 * Get a field object from class and its specified name. The returned field
	 * object is obtained through reflection.
	 * @param clazz Class object which contains the field.
	 * @param field Name of the field.
	 * @return Field object.
	 */
	static Field field(Class<?> clazz, String field) {
		try { return clazz.getField(field); }
		catch(NoSuchFieldException | SecurityException e) { throw new RuntimeException(e); }
	}

	/**
	 * Returns generic signature for a procedure.
	 * @param ret Return type of the procedure.
	 * @param params Number of input parameters.
	 * @return Method type of procedure.
	 */
	static MethodType type(boolean ret, int params) {
		return MethodType.methodType(ret? Object.class : void.class, cArray.fill(new Class<?>[params], Object.class));
	}

	
	/* property */
	/**
	 * Specifies the method type of the functional method.
	 * @return Method type.
	 */
	default MethodType type() {
		return null;
	}

	
	/* method */
	/**
	 * Calls the (main) procedure of this object defined in a class, which implements
	 * a super-interface to this interface.
	 * @param args The input arguments to pass to the procedure.
	 * @return The output value.
	 */
	TR call(Object... args);
	
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
