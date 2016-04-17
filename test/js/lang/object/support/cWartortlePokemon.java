package js.lang.object.support;
import js.lang.object.*;

/**
 * Support class for object test.
 */
@aAccess
public class cWartortlePokemon extends cSquirtlePokemon {
	
	/* super method */
	@aAccess(enumerable=false)
	@Override
	public int splash() {
		return splash;
	}
	@aAccess(enumerable=false,writable=false)
	@Override
	public String splash(String val) {
		splash = Integer.parseInt(val);
		return val;
	}
}
