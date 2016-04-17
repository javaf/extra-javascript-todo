package js.lang.object;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import js.lang.object.support.*;

/**
 * Test cObjectMap.
 */
public class cObjectMapTest {
	
	/* data */
	
	
	/* constructor */
	public cObjectMapTest() {
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
	 * Test of get method, of class cObjectMap.
	 */
	@Test
	public void fget() {
		System.out.println("# Get");
		Map m = new cObjectMap(new cLevel0());
		System.out.println(m);
	}
	
	/**
	 * Test of put method, of class cObjectMap.
	 */
	@Test
	public void fput() {
		System.out.println("# Put");
	}

	/**
	 * Test of clear method, of class cObjectMap.
	 */
	@Test
	public void fclear() {
		System.out.println("# Clear");
	}

	/**
	 * Test of entrySet method, of class cObjectMap.
	 */
	@Test
	public void fentrySet() {
		System.out.println("# Entry Set");
	}

	/**
	 * Test of keySet method, of class cObjectMap.
	 */
	@Test
	public void fkeySet() {
		System.out.println("# Key Set");
	}
}
