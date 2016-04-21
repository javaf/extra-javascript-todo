package js.lang.function;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/**
 * Test cMethod.
 */
public class cMethodTest {
	
	/* static data */
	public static Object ans;
	
	/* data */
	public cMethod c0MathPi;
	public cMethod c1StrRev;
	public cMethod c2StrCat;
	public cMethod c3MathMax;
	public cMethod c4MathMin;
	public cMethod c5ListAdd;
	public cMethod c6MapRemove;
	public cMethod c7NumSort;
	public cMethod f0MathPi;
	public cMethod f1StrRev;
	public cMethod f2StrCat;
	public cMethod f3MathMax;
	public cMethod f4MathMin;
	public cMethod f5ListAdd;
	public cMethod f6MapRemove;
	public cMethod f7NumSort;
	public cMethod gdfsp0;
	public cMethod sdfsp0;
	public cMethod gdfso0;
	public cMethod sdfso0;
	public cMethod gdsp0;
	public cMethod sdsp0;
	public cMethod gdso0;
	public cMethod sdso0;
	public cMethod gdp0;
	public cMethod sdp0;
	public cMethod gdo0;
	public cMethod sdo0;
	
	/* support data */
	public final static int DFSP0 = 1;
	public final static String DFSO0 = "DFSO0";
	public static int dsp0 = 2;
	public static String dso0 = "dso0";
	public int dp0 = 3;
	public String do0 = "do0";
	
	
	/* constructor */
	public cMethodTest() {
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
	public void newLambdaiMethod() {
		System.out.println("# New Lambda iMethod");
		c0MathPi = new cMethod((iProc)(Object... a) -> { c0MathPi(); return null; });
		c1StrRev = new cMethod((iProc)(Object... a) -> { c1StrRev((String)a[0]); return null; });
		c2StrCat = new cMethod((iProc)(Object... a) -> { c2StrCat((String)a[0], (String)a[1]); return null; });
		c3MathMax = new cMethod((iProc)(Object... a) -> { c3MathMax((double)a[0], (double)a[1], (double)a[2]); return null; });
		c4MathMin = new cMethod((iProc)(Object... a) -> { c4MathMin((double)a[0], (double)a[1], (double)a[2], (double)a[3]); return null; });
		c5ListAdd = new cMethod((iProc)(Object... a) -> { c5ListAdd((double)a[0], (double)a[1], (double)a[2], (double)a[3], (double)a[4]); return null; });
		c6MapRemove = new cMethod((iProc)(Object... a) -> { c6MapRemove((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5]); return null; });
		c7NumSort = new cMethod((iProc)(Object... a) -> { c7NumSort((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5], (int)a[6]); return null; });
		f0MathPi = new cMethod((iProc)(Object... a) -> f0MathPi());
		f1StrRev = new cMethod((iProc)(Object... a) -> f1StrRev((String)a[0]));
		f2StrCat = new cMethod((iProc)(Object... a) -> f2StrCat((String)a[0], (String)a[1]));
		f3MathMax = new cMethod((iProc)(Object... a) -> f3MathMax((double)a[0], (double)a[1], (double)a[2]));
		f4MathMin = new cMethod((iProc)(Object... a) -> f4MathMin((double)a[0], (double)a[1], (double)a[2], (double)a[3]));
		f5ListAdd = new cMethod((iProc)(Object... a) -> f5ListAdd((double)a[0], (double)a[1], (double)a[2], (double)a[3], (double)a[4]));
		f6MapRemove = new cMethod((iProc)(Object... a) -> f6MapRemove((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5]));
		f7NumSort = new cMethod((iProc)(Object... a) -> f7NumSort((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5], (int)a[6]));
		frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newRefiConsumer() {
		System.out.println("# New Ref iConsumer");
		c0MathPi = new cMethod((iSub0)this::c0MathPi);
		c1StrRev = new cMethod((iSub1<String>)this::c1StrRev);
		c2StrCat = new cMethod((iSub2<String, String>)this::c2StrCat);
		c3MathMax = new cMethod((iSub3<Double, Double, Double>)this::c3MathMax);
		c4MathMin = new cMethod((iSub4<Double, Double, Double, Double>)this::c4MathMin);
		c5ListAdd = new cMethod((iSub5<Double, Double, Double, Double, Double>)this::c5ListAdd);
		c6MapRemove = new cMethod((iSub6<Integer, Integer, Integer, Integer, Integer, Integer>)this::c6MapRemove);
		c7NumSort = new cMethod((iSub7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)this::c7NumSort);
		frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newLambdaiConsumer() {
		System.out.println("# New Lambda iConsumer");
		c0MathPi = new cMethod((iSub0)() -> { c0MathPi(); });
		c1StrRev = new cMethod((iSub1<String>)(a) -> { c1StrRev(a); });
		c2StrCat = new cMethod((iSub2<String, String>)(a, b) -> { c2StrCat(a, b); });
		c3MathMax = new cMethod((iSub3<Double, Double, Double>)(a, b, c) -> { c3MathMax((double)a, (double)b, (double)c); });
		c4MathMin = new cMethod((iSub4<Double, Double, Double, Double>)(a, b, c, d) -> { c4MathMin((double)a, (double)b, (double)c, (double)d); });
		c5ListAdd = new cMethod((iSub5<Double, Double, Double, Double, Double>)(a, b, c, d, e) -> { c5ListAdd((double)a, (double)b, (double)c, (double)d, (double)e); });
		c6MapRemove = new cMethod((iSub6<Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f) -> { c6MapRemove((int)a, (int)b, (int)c, (int)d, (int)e, (int)f); });
		c7NumSort = new cMethod((iSub7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f, g) -> { c7NumSort((int)a, (int)b, (int)c, (int)d, (int)e, (int)f, (int)g); });
		frun(); gcall(null); gapply(null);
	}

	@Test
	public void newRefiFunction() {
		System.out.println("# New Ref iFunction");
		f0MathPi = new cMethod((iFn0)cMethodTest::f0MathPi);
		f1StrRev = new cMethod((iFn1<String, String>)cMethodTest::f1StrRev);
		f2StrCat = new cMethod((iFn2<String, String, String>)cMethodTest::f2StrCat);
		f3MathMax = new cMethod((iFn3<Double, Double, Double, Double>)cMethodTest::f3MathMax);
		f4MathMin = new cMethod((iFn4<Double, Double, Double, Double, Double>)cMethodTest::f4MathMin);
		f5ListAdd = new cMethod((iFn5<Double, Double, Double, Double, Double, List>)cMethodTest::f5ListAdd);
		f6MapRemove = new cMethod((iFn6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)cMethodTest::f6MapRemove);
		f7NumSort = new cMethod((iFn7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)cMethodTest::f7NumSort);
		frun(); gcall(null); gapply(null);
	}

	@Test
	public void newLambdaiFunction() {
		System.out.println("# New Lambda iFunction");
		f0MathPi = new cMethod((iFn0<Double>)() -> f0MathPi());
		f1StrRev = new cMethod((iFn1<String, String>)(a) -> f1StrRev(a));
		f2StrCat = new cMethod((iFn2<String, String, String>)(a, b) -> f2StrCat(a, b));
		f3MathMax = new cMethod((iFn3<Double, Double, Double, Double>)(a, b, c) -> f3MathMax((double)a, (double)b, (double)c));
		f4MathMin = new cMethod((iFn4<Double, Double, Double, Double, Double>)(a, b, c, d) -> f4MathMin((double)a, (double)b, (double)c, (double)d));
		f5ListAdd = new cMethod((iFn5<Double, Double, Double, Double, Double, List>)(a, b, c, d, e) -> f5ListAdd((double)a, (double)b, (double)c, (double)d, (double)e));
		f6MapRemove = new cMethod((iFn6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)(a, b, c, d, e, f) -> f6MapRemove((int)a, (int)b, (int)c, (int)d, (int)e, (int)f));
		f7NumSort = new cMethod((iFn7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)(a, b, c, d, e, f, g) -> f7NumSort((int)a, (int)b, (int)c, (int)d, (int)e, (int)f, (int)g));
		frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newObjClsMthd() throws NoSuchMethodException, NoSuchFieldException, SecurityException {
		System.out.println("# cMethod(Object, Class, Method)");
		Class<?> c = cMethodTest.class;
		c0MathPi = new cMethod(this, c.getMethod("c0MathPi"));
		c1StrRev = new cMethod(this, c.getMethod("c1StrRev", String.class));
		c2StrCat = new cMethod(this, c.getMethod("c2StrCat", String.class, String.class));
		c3MathMax = new cMethod(this, c.getMethod("c3MathMax", double.class, double.class, double.class));
		c4MathMin = new cMethod(this, c.getMethod("c4MathMin", double.class, double.class, double.class, double.class));
		c5ListAdd = new cMethod(this, c.getMethod("c5ListAdd", double.class, double.class, double.class, double.class, double.class));
		c6MapRemove = new cMethod(this, c.getMethod("c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		c7NumSort = new cMethod(this, c.getMethod("c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		f0MathPi = new cMethod(this, c.getMethod("f0MathPi"));
		f1StrRev = new cMethod(this, c.getMethod("f1StrRev", String.class));
		f2StrCat = new cMethod(this, c.getMethod("f2StrCat", String.class, String.class));
		f3MathMax = new cMethod(this, c.getMethod("f3MathMax", double.class, double.class, double.class));
		f4MathMin = new cMethod(this, c.getMethod("f4MathMin", double.class, double.class, double.class, double.class));
		f5ListAdd = new cMethod(this, c.getMethod("f5ListAdd", double.class, double.class, double.class, double.class, double.class));
		f6MapRemove = new cMethod(this, c.getMethod("f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		f7NumSort = new cMethod(this, c.getMethod("f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		// gdfsp0 = new cMethod(this, c.getField("DFSP0"), false);
		// sdfsp0 = new cMethod(this, c.getField("DFSP0"), true);
		// gdfso0 = new cMethod(this, c.getField("DFSO0"), false);
		// sdfso0 = new cMethod(this, c.getField("DFSO0"), true);
		// gdsp0 = new cMethod(this, c.getField("DSP0"), false);
		// sdsp0 = new cMethod(this, c.getField("DSP0"), true);
		// gdso0 = new cMethod(this, c.getField("DSO0"), false);
		// sdso0 = new cMethod(this, c.getField("DSO0"), true);
		// gdp0 = new cMethod(this, c.getField("DP0"), false);
		// sdp0 = new cMethod(this, c.getField("DP0"), true);
		gdo0 = new cMethod(this, c.getField("do0"), false);
		sdo0 = new cMethod(this, c.getField("do0"), true);
		frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newClsMthd() throws NoSuchMethodException, NoSuchFieldException, SecurityException {
		System.out.println("# cMethod(Class, Method, Parameter types)");
		Class<?> c = cMethodTest.class;
		c0MathPi = new cMethod(null, c.getMethod("c0MathPi"));
		c1StrRev = new cMethod(null, c.getMethod("c1StrRev", String.class));
		c2StrCat = new cMethod(null, c.getMethod("c2StrCat", String.class, String.class));
		c3MathMax = new cMethod(null, c.getMethod("c3MathMax", double.class, double.class, double.class));
		c4MathMin = new cMethod(null, c.getMethod("c4MathMin", double.class, double.class, double.class, double.class));
		c5ListAdd = new cMethod(null, c.getMethod("c5ListAdd", double.class, double.class, double.class, double.class, double.class));
		c6MapRemove = new cMethod(null, c.getMethod("c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		c7NumSort = new cMethod(null, c.getMethod("c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		f0MathPi = new cMethod(null, c.getMethod("f0MathPi"));
		f1StrRev = new cMethod(null, c.getMethod("f1StrRev", String.class));
		f2StrCat = new cMethod(null, c.getMethod("f2StrCat", String.class, String.class));
		f3MathMax = new cMethod(null, c.getMethod("f3MathMax", double.class, double.class, double.class));
		f4MathMin = new cMethod(null, c.getMethod("f4MathMin", double.class, double.class, double.class, double.class));
		f5ListAdd = new cMethod(null, c.getMethod("f5ListAdd", double.class, double.class, double.class, double.class, double.class));
		f6MapRemove = new cMethod(null, c.getMethod("f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		f7NumSort = new cMethod(null, c.getMethod("f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		// gdfsp0 = new cMethod(null, c.getField("DFSP0"), false);
		// sdfsp0 = new cMethod(null, c.getField("DFSP0"), true);
		// gdfso0 = new cMethod(null, c.getField("DFSO0"), false);
		// sdfso0 = new cMethod(null, c.getField("DFSO0"), true);
		// gdsp0 = new cMethod(null, c.getField("DSP0"), false);
		// sdsp0 = new cMethod(null, c.getField("DSP0"), true);
		// gdso0 = new cMethod(null, c.getField("DSO0"), false);
		// sdso0 = new cMethod(null, c.getField("DSO0"), true);
		// gdp0 = new cMethod(null, c.getField("DP0"), false);
		// sdp0 = new cMethod(null, c.getField("DP0"), true);
		gdo0 = new cMethod(null, c.getField("do0"), false);
		sdo0 = new cMethod(null, c.getField("do0"), true);
		gcall(this); gapply(this); bind(this); frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newStringFn() {
		System.out.println("# cMethod(String...)");
		f0MathPi = new cMethod(0, new String[] {}, "return Math.PI;");
		f1StrRev = new cMethod(1, new String[] {"a"}, "return new StringBuilder((String)a).reverse().toString();");
		f2StrCat = new cMethod(2, new String[] {"a", "b"}, "return (String)a+(String)b;");
		f3MathMax = new cMethod(3, new String[] {"a", "b", "c"}, "return Math.max((double)a, Math.max((double)b, (double)c));");
		f4MathMin = new cMethod(4, new String[] {"a", "b", "c", "d"}, "return Math.min((double)a, Math.min((double)b, Math.min((double)c, (double)d)));");
		frun(); gcall(null); gapply(null);
	}
	
	
	/* test use function */
	/**
	 * Test of frun method, of class cMethod.
	 */
	public void frun() {
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
	 * Test of call method, of class cMethod.
	 * @param t This object.
	 */
	public void gcall(Object t) {
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
			ans = f0MathPi.call(null);
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
		if(sdfsp0!=null) {
			assertEquals((int)gdfsp0.call(null), 1);
		}
		if(sdfso0!=null) {
			assertEquals((String)gdfso0.call(null), "DFSO0");
		}
		if(sdsp0!=null) {
			sdsp0.call(null, 20);
			assertEquals((int)gdsp0.call(null), 20);
			sdsp0.call(null, 2);
		}
		if(sdso0!=null) {
			sdso0.call(null, "DDSO0DDSO0");
			assertEquals((String)gdso0.call(null), "DDSO0DDSO0");
			sdso0.call(null, "DDSO0");
		}
		if(sdp0!=null) {
			sdp0.call(t, 30);
			assertEquals((int)gdp0.call(t), 30);
		}
		if(sdo0!=null) {
			sdo0.call(t, "DDO0DDO0");
			assertEquals((String)gdo0.call(t), "DDO0DDO0");
		}
		System.out.println();
	}
	
	/**
	 * Test of fapply method, of class cMethod.
	 * @param t This object.
	 */
	public void gapply(Object t) {
		System.out.println("## fapply");
		if(c0MathPi!=null) {
			c0MathPi.apply(t, new Object[] {});
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(c1StrRev!=null) {
			c1StrRev.apply(t, new Object[] {"Splinter"});
			assertEquals(ans, "retnilpS");
		}
		if(c2StrCat!=null) {
			c2StrCat.apply(t, new Object[] {"Alpha", "bet"});
			assertEquals(ans, "Alphabet");
		}
		if(c3MathMax!=null) {
			c3MathMax.apply(t, new Object[] {0.0, 1.0, 0.1});
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(c4MathMin!=null) {
			c4MathMin.apply(t, new Object[] {1.0, 1.1, 0.1, 0.11});
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(c5ListAdd!=null) {
			ans = new ArrayList();
			c5ListAdd.apply(t, new Object[] {0.1, 0.2, 0.3, 0.4, 0.5});
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(c6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			c6MapRemove.apply(t, new Object[] {0, 1, 2, 3, 4, 5});
			assertEquals(p.size(), 0);
		}
		if(c7NumSort!=null) {
			c7NumSort.apply(t, new Object[] {4, 3, 5, 2, 0, 1, 6});
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		if(f0MathPi!=null) {
			ans = f0MathPi.apply(null, new Object[] {});
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.apply(null, new Object[] {"Splinter"});
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.apply(null, new Object[] {"Alpha", "bet"});
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.apply(null, new Object[] {0.0, 1.0, 0.1});
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.apply(null, new Object[] {1.0, 1.1, 0.1, 0.11});
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.apply(null, new Object[] {0.1, 0.2, 0.3, 0.4, 0.5});
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.apply(null, new Object[] {0, 1, 2, 3, 4, 5});
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.apply(null, new Object[] {4, 3, 5, 2, 0, 1, 6});
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		if(sdfsp0!=null) {
			assertEquals((int)gdfsp0.apply(null, new Object[] {}), 1);
		}
		if(sdfso0!=null) {
			assertEquals((String)gdfso0.apply(null, new Object[] {}), "DFSO0");
		}
		if(sdsp0!=null) {
			sdsp0.apply(null, new Object[] {20});
			assertEquals((int)gdsp0.apply(null, new Object[] {}), 20);
			sdsp0.apply(null, new Object[] {2});
		}
		if(sdso0!=null) {
			sdso0.apply(null, new Object[] {"DDSO0DDSO0"});
			assertEquals((String)gdso0.apply(null, new Object[] {}), "DDSO0DDSO0");
			sdso0.apply(null, new Object[] {"DDSO0"});
		}
		if(sdp0!=null) {
			sdp0.apply(t, new Object[] {30});
			assertEquals((int)gdp0.apply(t, new Object[] {}), 30);
		}
		if(sdo0!=null) {
			sdo0.call(t, new Object[] {"DDO0DDO0"});
			assertEquals((String)gdo0.call(t, new Object[] {}), "DDO0DDO0");
		}
		System.out.println();
	}
	
	/**
	 * Test of bind method, of class cMethod.
	 * @param t This object.
	 */
	public void bind(Object t) {
		System.out.println("## bind");
		if(c0MathPi!=null) c0MathPi = c0MathPi.bind(t);
		if(c1StrRev!=null) c1StrRev = c1StrRev.bind(t);
		if(c2StrCat!=null) c2StrCat = c2StrCat.bind(t);
		if(c3MathMax!=null) c3MathMax = c3MathMax.bind(t);
		if(c4MathMin!=null) c4MathMin = c4MathMin.bind(t);
		if(c5ListAdd!=null) c5ListAdd = c5ListAdd.bind(t);
		if(c6MapRemove!=null) c6MapRemove = c6MapRemove.bind(t);
		if(c7NumSort!=null) c7NumSort = c7NumSort.bind(t);
		if(gdp0!=null) gdp0 = gdp0.bind(t);
		if(sdp0!=null) sdp0 = sdp0.bind(t);
		if(gdo0!=null) gdo0 = gdo0.bind(t);
		if(sdo0!=null) sdo0 = sdo0.bind(t);
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
