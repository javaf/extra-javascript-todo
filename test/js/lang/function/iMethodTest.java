package js.lang.function;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test iMethod.
 */
public class iMethodTest implements iMethod {
	
	/* data */
	public iMethod strCat;
	
	
	/* constructor */
	public iMethodTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: iMethod");
		System.out.println("=============");
		System.out.println();
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println();
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
	public void refMethod() {
		System.out.println("# Ref Method");
		strCat = this::strCatVararg;
		assertEquals(strCat.run("Mum", "my"), "Mummy");
		assertEquals(strCat.name(), "");
		assertEquals(strCat.length(), 0);
		assertEquals(strCat.ztoString(), "? (...) { [native code] }");
		System.out.println();
	}
	
	@Test
	public void lambdaMethod() {
		System.out.println("# Lambda Method");
		strCat = (Object... a) -> strCatDirect((String)a[0], (String)a[1]);
		assertEquals(strCat.run("Mum", "my"), "Mummy");
		assertEquals(strCat.name(), "");
		assertEquals(strCat.length(), 0);
		assertEquals(strCat.ztoString(), "? (...) { [native code] }");
		System.out.println();
	}
	
	@Test
	public void classMethod() {
		System.out.println("# Class Method");
		strCat = this;
		assertEquals(strCat.run("Mum", "my"), "Mummy");
		assertEquals(strCat.name(), "strCat");
		assertEquals(strCat.length(), 2);
		assertEquals(strCat.toString(), "String (String a, String b) { ... }");
		System.out.println();
	}
	
	@Test
	public void implMethod() {
		System.out.println("# Impl Method");
		strCat = new iMethod() {
			@Override
			public int length() {
				return 2;
			}
			
			@Override
			public String name() {
				return "strCat";
			}
			
			@Override
			public String ztoString() {
				return "String (String a, String b) { ... }";
			}
			
			@Override
			public Object run(Object... a) {
				return strCatDirect((String)a[0], (String)a[1]);
			}
			
			@Override
			public String toString() {
				return ztoString();
			}
		};
		assertEquals(strCat.run("Mum", "my"), "Mummy");
		assertEquals(strCat.name(), "strCat");
		assertEquals(strCat.length(), 2);
		assertEquals(strCat.toString(), "String (String a, String b) { ... }");
		System.out.println();
	}
	
	
	/* support function */
	public String strCatDirect(String a, String b) {
		System.out.print("strCatDirect.");
		return a+b;
	}

	public Object strCatVararg(Object... a) {
		System.out.print("strCatVararg.");
		return strCatDirect((String)a[0], (String)a[1]);
	}
	
	@Override
	public Object run(Object... a) {
		System.out.print("run.");
		return strCatVararg(a);
	}
	
	@Override
	public int length() {
		System.out.print("length.");
		return 2;
	}
	
	@Override
	public String name() {
		System.out.print("name.");
		return "strCat";
	}
	
	@Override
	public String ztoString() {
		System.out.print("ztoString.");
		return "String (String a, String b) { ... }";
	}
	
	@Override
	public String toString() {
		System.out.print("toString.");
		return ztoString();
	}
}