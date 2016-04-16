package js.lang.object;
import static org.junit.Assert.*;
import js.lang.function.*;
import java.util.function.*;
import org.junit.*;
import java.util.*;

/**
 *
 * @author wolfram77
 */
public class cAccessTest {
	
	/* data */
	public cAccess acc;
	public Object ans;
	
	
	/* constructor */
	public cAccessTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: cAccess");
		System.out.println("=============");
		System.out.println();
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println();
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
		System.out.println();
	}
	
	
	/* test functionality */
	@Test
	public void newProps() {
		System.out.println("# New Props");
		for(int i=0; i<8; i++) {
			boolean configurable = (i&1)==1;
			boolean enumerable = (i&2)==2;
			boolean writable = (i&4)==4;
			Supplier get = new oFunction(() -> 0);
			Consumer set = new oFunction((a) -> { ans = a; });
			Object value = i<3? null : i;
			acc = new cAccess(configurable, enumerable, writable, get, set, value);
			System.out.println(acc.get(new HashMap()));
			assertEquals(acc.configurable, configurable);
			assertEquals(acc.enumerable, enumerable);
			assertEquals(acc.writable, writable);
			assertEquals(acc.value, value);
			assertEquals(acc.get, get);
			assertEquals(acc.set, set);
		}
	}

	/**
	 * Test of get method, of class cAccess.
	 */
	@Test
	public void fget() {
		System.out.println("# Get");
		for(int i=0; i<8; i++) {
			boolean configurable = (i&1)==1;
			boolean enumerable = (i&2)==2;
			boolean writable = (i&4)==4;
			Supplier get = new oFunction(() -> 0);
			Consumer set = new oFunction((a) -> { ans = a; });
			Object value = i<3? null : i;
			acc = new cAccess(configurable, enumerable, writable, get, set, value);
			Map mo = acc.get(new HashMap());
			System.out.println(mo);
			assertEquals(mo.get("configurable"), configurable);
			assertEquals(mo.get("enumerable"), enumerable);
			assertEquals(mo.get("writable"), writable);
			assertEquals(mo.get("value"), value);
			assertEquals(mo.get("get"), get);
			assertEquals(mo.get("set"), set);
		}
	}

	/**
	 * Test of set method, of class cAccess.
	 */
	@Test
	public void fset() {
		System.out.println("# Set");
		for(int i=0; i<8; i++) {
			Map mi = new HashMap();
			mi.put("configurable", (i&1)==1);
			mi.put("enumerable", (i&2)==2);
			mi.put("writable", (i&4)==4);
			mi.put("get", new oFunction(() -> 0));
			mi.put("set", new oFunction((a) -> { ans = a; }));
			mi.put("value", i<3? null : i);
			acc = new cAccess();
			acc.set(mi);
			Map mo = acc.get(new HashMap());
			System.out.println(mi);
			System.out.println(mo);
			assertEquals(mo.get("configurable"), mi.get("configurable"));
			assertEquals(mo.get("enumerable"), mi.get("enumerable"));
			assertEquals(mo.get("writable"), mi.get("writable"));
			assertEquals(mo.get("get"), mi.get("get"));
			assertEquals(mo.get("set"), mi.get("set"));
			assertEquals(mo.get("value"), mi.get("value"));
		}
	}

	/**
	 * Test of isData method, of class cAccess.
	 */
	@Test
	public void fisData() {
		System.out.println("# Is Data");
		Supplier get = new oFunction(() -> 0);
		Consumer set = new oFunction((a) -> { ans = a; });
		for(int i=0; i<8; i++) {
			Map mi = new HashMap();
			mi.put("get", (i&1)==1? get : null);
			mi.put("set", (i&2)==2? set : null);
			mi.put("value", i<3? null : i);
			acc = new cAccess();
			acc.set(mi);
			System.out.println(mi);
			assertEquals(acc.isData(), (i&3)==0);
		}
	}
}
