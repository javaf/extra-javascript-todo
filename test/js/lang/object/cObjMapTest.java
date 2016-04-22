package js.lang.object;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.util.Map.*;
import js.lang.object.support.*;

/**
 * Test cObjMap.
 */
public class cObjMapTest {
	
	/* data */
	public final static String[] specified = new String[] {"dfsp", "dfso", "dsp", "dso", "dp", "do", "msp", "mso", "mp", "mo"};
	public final static String[] merged = new String[] {"mfpe1w1v1", "mmpe1w1v2"};
	public final static String[] unspecified = new String[] {"mfpu0", "mmpu1"};
	public final static cLevel0 lvl0 = new cLevel0();
	public final static cLevel1 lvl1 = new cLevel1();
	public final static Map mlvl0 = new cObjMap(lvl0);
	public final static Map mlvl1 = new cObjMap(lvl1);
	
	
	/* constructor */
	public cObjMapTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: cObjectMap");
		System.out.println("================");
		System.out.println();
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
		System.out.println();
	}
	
	
	/* test functionality */
	/**
	 * Test of get method, of class cObjMap.
	 */
	@Test
	public void fget() {
		System.out.println("# Get");
		System.out.println(mlvl0);
	}
	
	/**
	 * Test of put method, of class cObjMap.
	 */
	@Test
	public void fput() {
		System.out.println("# Put");
	}

	/**
	 * Test of clear method, of class cObjMap.
	 */
	@Test
	public void fclear() {
		System.out.println("# Clear");
		int n0 = mlvl0.size();
		mlvl0.clear();
		int n1 = mlvl0.size();
		System.out.println("mlvl0: "+n0+" -> "+n1);
		assertEquals(n1, n0);
		n0 = mlvl1.size();
		mlvl1.clear();
		n1 = mlvl1.size();
		System.out.println("mlvl1: "+n0+" -> "+n1);
		assertEquals(n1, n0);
		System.out.println();
	}

	/**
	 * Test of entrySet method, of class cObjMap.
	 */
	@Test
	public void fentrySet() {
		System.out.println("# Entry Set");
	}

	/**
	 * Test of keySet method, of class cObjMap.
	 */
	@Test
	public void fkeySet() {
		System.out.println("# Key Set");
		Set<String> ks = mlvl0.keySet();
		for(String t : specified)
			for(int e=0; e<2; e++)
				for(int w=0; w<2; w++)
					for(int v=0; v<3; v++) {
						System.out.println(t+"e"+e+"w"+w+"v"+v);
						// assertEquals(ks.contains(t+"e"+e+"w"+w+"v"+v), e>0);
					}
	}
}
