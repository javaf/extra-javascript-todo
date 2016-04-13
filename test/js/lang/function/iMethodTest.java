package js.lang.function;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Test iMethod.
 */
public class iMethodTest {
	
	/* data */
	public Object ans;
	public iMethod c0MathPi;
	public iMethod c1StrRev;
	public iMethod c2StrCat;
	public iMethod c3MathMax;
	public iMethod c4MathMin;
	public iMethod c5ListAdd;
	public iMethod c6MapRemove;
	public iMethod c7NumSort;
	public iMethod f0MathPi;
	public iMethod f1StrRev;
	public iMethod f2StrCat;
	public iMethod f3MathMax;
	public iMethod f4MathMin;
	public iMethod f5ListAdd;
	public iMethod f6MapRemove;
	public iMethod f7NumSort;
	
	
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
	}

	
	/* test functionality */
	public void lambdaMethod() {
		c0MathPi = (Object... a) -> { c0MathPi(); return null; };
	}
	
	
	/**
	 * Test of length method, of class iMethod.
	 */
	@Test
	public void length() {
		System.out.println("## length");
		if(c0MathPi!=null) assertEquals(c0MathPi.length(), 0);
		if(c1StrRev!=null) assertEquals(c1StrRev.length(), 0);
		if(c2StrCat!=null) assertEquals(c2StrCat.length(), 0);
		if(c3MathMax!=null) assertEquals(c3MathMax.length(), 0);
		if(c4MathMin!=null) assertEquals(c4MathMin.length(), 0);
		if(c5ListAdd!=null) assertEquals(c5ListAdd.length(), 0);
		if(c6MapRemove!=null) assertEquals(c6MapRemove.length(), 0);
		if(c7NumSort!=null) assertEquals(c7NumSort.length(), 0);
		if(f0MathPi!=null) assertEquals(f0MathPi.length(), 0);
		if(f1StrRev!=null) assertEquals(f1StrRev.length(), 0);
		if(f2StrCat!=null) assertEquals(f2StrCat.length(), 0);
		if(f3MathMax!=null) assertEquals(f3MathMax.length(), 0);
		if(f4MathMin!=null) assertEquals(f4MathMin.length(), 0);
		if(f4MathMin!=null) assertEquals(f5ListAdd.length(), 0);
		if(f6MapRemove!=null) assertEquals(f6MapRemove.length(), 0);
		if(f7NumSort!=null) assertEquals(f7NumSort.length(), 0);
	}

	/**
	 * Test of name method, of class iMethod.
	 */
	@Test
	public void name() {
		System.out.println("## name");
		if(c0MathPi!=null) assertEquals(c0MathPi.name(), "");
		if(c1StrRev!=null) assertEquals(c1StrRev.name(), "");
		if(c2StrCat!=null) assertEquals(c2StrCat.name(), "");
		if(c3MathMax!=null) assertEquals(c3MathMax.name(), "");
		if(c4MathMin!=null) assertEquals(c4MathMin.name(), "");
		if(c5ListAdd!=null) assertEquals(c5ListAdd.name(), "");
		if(c6MapRemove!=null) assertEquals(c6MapRemove.name(), "");
		if(c7NumSort!=null) assertEquals(c7NumSort.name(), "");
		if(f0MathPi!=null) assertEquals(f0MathPi.name(), "");
		if(f1StrRev!=null) assertEquals(f1StrRev.name(), "");
		if(f2StrCat!=null) assertEquals(f2StrCat.name(), "");
		if(f3MathMax!=null) assertEquals(f3MathMax.name(), "");
		if(f4MathMin!=null) assertEquals(f4MathMin.name(), "");
		if(f4MathMin!=null) assertEquals(f5ListAdd.name(), "");
		if(f6MapRemove!=null) assertEquals(f6MapRemove.name(), "");
		if(f7NumSort!=null) assertEquals(f7NumSort.name(), "");
	}

	/**
	 * Test of run method, of class iMethod.
	 */
	@Test
	public void testRun() {
		System.out.println("run");
		Object[] args = null;
		iMethod instance = new iMethodImpl();
		Object expResult = null;
		Object result = instance.run(args);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of ztoString method, of class iMethod.
	 */
	@Test
	public void testZtoString() {
		System.out.println("ztoString");
		iMethod instance = new iMethodImpl();
		String expResult = "";
		String result = instance.ztoString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class iMethodImpl implements iMethod {

		@Override
		public Object run(Object[] args) {
			return null;
		}
	}
	
	
	/* support function */
	public void c0MathPi() {
		ans = f0MathPi();
	}
	
	public void c1StrRev(String a) {
		ans = f1StrRev(a);
	}
	
	public void c2StrCat(String a, String b) {
		ans = f2StrCat(a, b);
	}
	
	public void c3MathMax(double a, double b, double c) {
		ans = f3MathMax(a, b, c);
	}
	
	public void c4MathMin(double a, double b, double c, double d) {
		ans = f4MathMin(a, b, c, d);
	}
	
	public void c5ListAdd(double a, double b, double c, double d, double e) {
		ans = f5ListAdd(a, b, c, d, e);
	}
	
	public void c6MapRemove(int a, int b, int c, int d, int e, int f) {
		ans = f6MapRemove(a, b, c, d, e, f);
	}
	
	public void c7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		ans = f7NumSort(a, b, c, d, e, f, g);
	}
	
	public double f0MathPi() {
		return Math.PI;
	}
	
	public String f1StrRev(String a) {
		return new StringBuilder(a).reverse().toString();
	}
	
	public String f2StrCat(String a, String b) {
		return a+b;
	}
	
	public double f3MathMax(double a, double b, double c) {
		return Math.max(a, Math.max(b, c));
	}
	
	public double f4MathMin(double a, double b, double c, double d) {
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}
	
	public List f5ListAdd(double a, double b, double c, double d, double e) {
		List p = (List)ans;
		p.addAll(Arrays.asList(a, b, c, d, e));
		return p;
	}
	
	public Map f6MapRemove(int a, int b, int c, int d, int e, int f) {
		Map p = (Map)ans;
		for(int n : new int[] {a, b, c, d, e, f})
			p.remove(n);
		return p;
	}
	
	public int[] f7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		int[] p = new int[] {a, b, c, d, e, f, g};
		Arrays.sort(p);
		return p;
	}
}
