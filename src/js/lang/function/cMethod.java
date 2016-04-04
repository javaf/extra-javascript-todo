package js.lang.function;

/**
 * Defines a method which can be called.
 * @param <TA> Input argument 1 type.
 * @param <TB> Input argument 2 type.
 * @param <TC> Input argument 3 type.
 * @param <TD> Input argument 4 type.
 * @param <TE> Input argument 5 type.
 * @param <TF> Input argument 6 type.
 * @param <TG> Input argument 7 type.
 * @param <TR> Return type. 
 */
public class cMethod<TA, TB, TC, TD, TE, TF, TG, TR> implements iMethod {
	
	/* data */
	private final iMethod m;
	
	
	/* constructor */
	public cMethod(iMethod mthd) {
		m = mthd;
	}
	
	
	/* super property */
	@Override
	public int length() {
		return m.length();
	}
	
	@Override
	public String name() {
		return m.name();
	}
	
	
	/* method */
	public Object apply(Object thisArg, Object[] args) {
		return run(args);
	}
	
	public Object call(Object thisArg, Object... args) {
		return run(args);
	}
	
	
	/* super method */
	@Override
	public Object run(Object... args) {
		return m.run(args);
	}
	
	@Override
	public String _toString() {
		return m._toString();
	}
	
	@Override
	public String toString() {
		return _toString();
	}
}
