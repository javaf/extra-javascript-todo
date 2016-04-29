package js.lang.function;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/**
 * Test cMethodProc.
 */
public class cMethodProcTest {
	
	/* static data */
	public static Object ans;
	
	/* data */
	public cMethodProc c0MathPi;
	public cMethodProc c1StrRev;
	public cMethodProc c2StrCat;
	public cMethodProc c3MathMax;
	public cMethodProc c4MathMin;
	public cMethodProc c5ListAdd;
	public cMethodProc c6MapRemove;
	public cMethodProc c7NumSort;
	public cMethodProc f0MathPi;
	public cMethodProc f1StrRev;
	public cMethodProc f2StrCat;
	public cMethodProc f3MathMax;
	public cMethodProc f4MathMin;
	public cMethodProc f5ListAdd;
	public cMethodProc f6MapRemove;
	public cMethodProc f7NumSort;
	public cMethodProc gdfsp0;
	public cMethodProc sdfsp0;
	public cMethodProc gdfso0;
	public cMethodProc sdfso0;
	public cMethodProc gdsp0;
	public cMethodProc sdsp0;
	public cMethodProc gdso0;
	public cMethodProc sdso0;
	public cMethodProc gdp0;
	public cMethodProc sdp0;
	public cMethodProc gdo0;
	public cMethodProc sdo0;
	
	/* support data */
	public final static int DFSP0 = 1;
	public final static String DFSO0 = "DFSO0";
	public static int dsp0 = 2;
	public static String dso0 = "dso0";
	public int dp0 = 3;
	public String do0 = "do0";
	
	
	/* constructor */
	public cMethodProcTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: cMethod");
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
	public void newObjClsMthd() throws NoSuchMethodException, NoSuchFieldException, SecurityException {
		System.out.println("# cMethod(Object, Class, Method)");
		Class<?> c = cMethodProcTest.class;
		c0MathPi = new cMethodProc(c.getMethod("c0MathPi"), this);
		c1StrRev = new cMethodProc(c.getMethod("c1StrRev", String.class), this);
		c2StrCat = new cMethodProc(c.getMethod("c2StrCat", String.class, String.class), this);
		c3MathMax = new cMethodProc(c.getMethod("c3MathMax", double.class, double.class, double.class), this);
		c4MathMin = new cMethodProc(c.getMethod("c4MathMin", double.class, double.class, double.class, double.class), this);
		c5ListAdd = new cMethodProc(c.getMethod("c5ListAdd", double.class, double.class, double.class, double.class, double.class), this);
		c6MapRemove = new cMethodProc(c.getMethod("c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class), this);
		c7NumSort = new cMethodProc(c.getMethod("c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class), this);
		f0MathPi = new cMethodProc(c.getMethod("f0MathPi"), this);
		f1StrRev = new cMethodProc(c.getMethod("f1StrRev", String.class), this);
		f2StrCat = new cMethodProc(c.getMethod("f2StrCat", String.class, String.class), this);
		f3MathMax = new cMethodProc(c.getMethod("f3MathMax", double.class, double.class, double.class), this);
		f4MathMin = new cMethodProc(c.getMethod("f4MathMin", double.class, double.class, double.class, double.class), this);
		f5ListAdd = new cMethodProc(c.getMethod("f5ListAdd", double.class, double.class, double.class, double.class, double.class), this);
		f6MapRemove = new cMethodProc(c.getMethod("f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class), this);
		f7NumSort = new cMethodProc(c.getMethod("f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class), this);
		fcall();
	}
	
	@Test
	public void newClsMthd() throws NoSuchMethodException, NoSuchFieldException, SecurityException {
		System.out.println("# cMethod(Class, Method, Parameter types)");
		Class<?> c = cMethodProcTest.class;
		c0MathPi = new cMethodProc(c.getMethod("c0MathPi"), null);
		c1StrRev = new cMethodProc(c.getMethod("c1StrRev", String.class), null);
		c2StrCat = new cMethodProc(c.getMethod("c2StrCat", String.class, String.class), null);
		c3MathMax = new cMethodProc(c.getMethod("c3MathMax", double.class, double.class, double.class), null);
		c4MathMin = new cMethodProc(c.getMethod("c4MathMin", double.class, double.class, double.class, double.class), null);
		c5ListAdd = new cMethodProc(c.getMethod("c5ListAdd", double.class, double.class, double.class, double.class, double.class), null);
		c6MapRemove = new cMethodProc(c.getMethod("c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class), null);
		c7NumSort = new cMethodProc(c.getMethod("c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class), null);
		f0MathPi = new cMethodProc(c.getMethod("f0MathPi"), null);
		f1StrRev = new cMethodProc(c.getMethod("f1StrRev", String.class), null);
		f2StrCat = new cMethodProc(c.getMethod("f2StrCat", String.class, String.class), null);
		f3MathMax = new cMethodProc(c.getMethod("f3MathMax", double.class, double.class, double.class), null);
		f4MathMin = new cMethodProc(c.getMethod("f4MathMin", double.class, double.class, double.class, double.class), null);
		f5ListAdd = new cMethodProc(c.getMethod("f5ListAdd", double.class, double.class, double.class, double.class, double.class), null);
		f6MapRemove = new cMethodProc(c.getMethod("f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class), null);
		f7NumSort = new cMethodProc(c.getMethod("f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class), null);
		fcallObj(this);
	}
	
	
	/* test use function */
	/**
	 * Test of fcall method, of class cMethodProc.
	 */
	public void fcall() {
		System.out.println("## run");
		if(c0MathPi!=null) {
			c0MathPi.call();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(c1StrRev!=null) {
			c1StrRev.call("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(c2StrCat!=null) {
			c2StrCat.call("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(c3MathMax!=null) {
			c3MathMax.call(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(c4MathMin!=null) {
			c4MathMin.call(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(c5ListAdd!=null) {
			ans = new ArrayList();
			c5ListAdd.call(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(c6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			c6MapRemove.call(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(c7NumSort!=null) {
			c7NumSort.call(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		if(f0MathPi!=null) {
			ans = f0MathPi.call();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.call("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.call("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.call(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.call(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.call(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.call(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.call(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		if(sdfsp0!=null) {
			assertEquals((int)gdfsp0.call(), 1);
		}
		if(sdfso0!=null) {
			assertEquals((String)gdfso0.call(), "DFSO0");
		}
		if(sdsp0!=null) {
			sdsp0.call(20);
			assertEquals((int)gdsp0.call(), 20);
			sdsp0.call(2);
		}
		if(sdso0!=null) {
			sdso0.call("DDSO0DDSO0");
			assertEquals((String)gdso0.call(), "DDSO0DDSO0");
			sdso0.call("DDSO0");
		}
		if(sdp0!=null) {
			sdp0.call(30);
			assertEquals((int)gdp0.call(), 30);
		}
		if(sdo0!=null) {
			sdo0.call("DDO0DDO0");
			assertEquals((String)gdo0.call(), "DDO0DDO0");
		}
		System.out.println();
	}
	
	/**
	 * Test of call method, of class cMethodProc.
	 * @param t This object.
	 */
	public void fcallObj(Object t) {
		System.out.println("## fcall");
		if(c0MathPi!=null) {
			c0MathPi.call(t);
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(c1StrRev!=null) {
			c1StrRev.call(t, "Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(c2StrCat!=null) {
			c2StrCat.call(t, "Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(c3MathMax!=null) {
			c3MathMax.call(t, 0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(c4MathMin!=null) {
			c4MathMin.call(t, 1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(c5ListAdd!=null) {
			ans = new ArrayList();
			c5ListAdd.call(t, 0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(c6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			c6MapRemove.call(t, 0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(c7NumSort!=null) {
			c7NumSort.call(t, 4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		if(f0MathPi!=null) {
			ans = f0MathPi.call((Object)null);
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.call(null, "Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.call(null, "Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.call(null, 0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.call(null, 1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.call(null, 0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.call(null, 0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.call(null, 4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		System.out.println();
	}
	
	
	/* support function */
	public void c0MathPi() {
		System.out.print("c0MathPi.");
		ans = f0MathPi();
	}
	
	public void c1StrRev(String a) {
		System.out.print("c1StrRev.");
		ans = f1StrRev(a);
	}
	
	public void c2StrCat(String a, String b) {
		System.out.print("c2StrCat.");
		ans = f2StrCat(a, b);
	}
	
	public void c3MathMax(double a, double b, double c) {
		System.out.print("c3MathMax.");
		ans = f3MathMax(a, b, c);
	}
	
	public void c4MathMin(double a, double b, double c, double d) {
		System.out.print("c4MathMin.");
		ans = f4MathMin(a, b, c, d);
	}
	
	public void c5ListAdd(double a, double b, double c, double d, double e) {
		System.out.print("c5ListAdd.");
		ans = f5ListAdd(a, b, c, d, e);
	}
	
	public void c6MapRemove(int a, int b, int c, int d, int e, int f) {
		System.out.print("c6MapRemove.");
		ans = f6MapRemove(a, b, c, d, e, f);
	}
	
	public void c7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		System.out.print("c7NumSort.");
		ans = f7NumSort(a, b, c, d, e, f, g);
	}
	
	public static double f0MathPi() {
		System.out.print("f0MathPi.");
		return Math.PI;
	}
	
	public static String f1StrRev(String a) {
		System.out.print("f1StrRev.");
		return new StringBuilder(a).reverse().toString();
	}
	
	public static String f2StrCat(String a, String b) {
		System.out.print("f2StrCat.");
		return a+b;
	}
	
	public static double f3MathMax(double a, double b, double c) {
		System.out.print("f3MathMax.");
		return Math.max(a, Math.max(b, c));
	}
	
	public static double f4MathMin(double a, double b, double c, double d) {
		System.out.print("f4MathMin.");
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}
	
	public static List f5ListAdd(double a, double b, double c, double d, double e) {
		System.out.print("f5ListAdd.");
		List p = (List)ans;
		p.addAll(Arrays.asList(a, b, c, d, e));
		return p;
	}
	
	public static Map f6MapRemove(int a, int b, int c, int d, int e, int f) {
		System.out.print("f6MapRemove.");
		Map p = (Map)ans;
		for(int n : new int[] {a, b, c, d, e, f})
			p.remove(n);
		return p;
	}
	
	public static int[] f7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		System.out.print("f7NumSort.");
		int[] p = new int[] {a, b, c, d, e, f, g};
		Arrays.sort(p);
		return p;
	}
}
