package js.lang.object.support;

/**
 * Support class for object test.
 */
public class cPokemon {
	
	/* constant data */
	public final static String TYPE = "Normal";
	
	/* static data */
	public static String type = TYPE;
	
	/* data */
	public String name;
	public String family;
	public float height;
	public float weight;
	public int age;
	
	
	/* constructor */
	public cPokemon() {
	}
	
	
	/* method */
	public String name() {
		return "cPokemon Name: "+name;
	}
	public void name(String val) {
		name = val;
	}
	
	public String family() {
		return "cPokemon Family: "+family;
	}
	public String family(String val) {
		return (family = val);
	}
	
	public float height() {
		return height;
	}
	public String height(String val) {
		height = Float.parseFloat(val);
		return val;
	}
	
	public float weight() {
		return weight;
	}
	public float weight(String val) {
		return (Float.parseFloat(val));
	}
	
	public String age() {
		return ""+age;
	}
	public int age(int val) {
		return (age = val);
	}
}
