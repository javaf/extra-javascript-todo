package js.lang.function;
import java.lang.reflect.*;
import java.lang.invoke.*;

/**
 * Defines a procedure interface for a field which can be called.
 * @param <TR> Datatype of field.
 */
public class cGetterProc<TR> implements iProc<TR> {
	
	/* data */
	private MethodHandle handle;
	private Field field;
	private iProc proc;
	private Object obj;
	
	
	/* constructor */
	public cGetterProc(Field f, Object o) {
		try {
			handle = MethodHandles.lookup().unreflectGetter(f);
		}
		catch(IllegalAccessException e) { throw new RuntimeException(e); }
	}
	public cGetterProc(Field f) {
		this(f, null);
	}
	
	/* method */
	// Returns a procedure that gets the value of a field.
	private static iProc _proc(Field f, MethodHandle mh, Object obj) {
		if(Modifier.isStatic(f.getModifiers())) return (iFn0)()->{ try { return mh.invoke(); } catch(Throwable e) { throw new RuntimeException(e); } };
		else if(obj==null) return (iFn1)(o)->{ try { return mh.invoke(o); } catch(Throwable e) { throw new RuntimeException(e); } };
		return (iFn0)()->{ try { return mh.invoke(obj); } catch(Throwable e) { throw new RuntimeException(e); } };
	}
	
					
	/* super method */
	@Override
	public TR apply() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
