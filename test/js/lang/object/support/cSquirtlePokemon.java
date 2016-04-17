package js.lang.object.support;

/**
 * Support class for object test.
 */
public class cSquirtlePokemon extends cPokemon {
	
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
	public int splash() {
		return splash;
	}
	public String splash(String val) {
		splash = Integer.parseInt(val);
		return val;
	}
	
	
	/* super method */
	@Override
	public String name() {
		return "cSquirtle Pokemon Name: "+name;
	}
	
	@Override
	public String family() {
		return "cSquirtle Pokemon Family: "+family;
	}
}
