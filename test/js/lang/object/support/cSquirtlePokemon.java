package js.lang.object.support;
import js.lang.object.*;

/**
 * Support class for object test.
 */
public class cSquirtlePokemon extends cLevel0 {
	
	/* constant data */
	public final static String TYPE = "Water";
	
	/* static data */
	public static String type = TYPE;
	
	/* data */
	public String name;
	public int splash;
	
	
	/* constructor */
	public cSquirtlePokemon() {
		name = "Squirtle";
		family = "Water";
	}
	
	
	/* method */
	@aAccess(enumerable=false)
	public int splash() {
		return splash;
	}
	@aAccess(enumerable=false)
	public String splash(String val) {
		splash = Integer.parseInt(val);
		return val;
	}
	
	
	/* super method */
	// TODO: see if access is needed in this super method
	@Override
	public String name() {
		return "cSquirtle Pokemon Name: "+name;
	}
	
	// TODO: see if access is needed in this super method
	@Override
	public String family() {
		return "cSquirtle Pokemon Family: "+family;
	}
}
