package js.lang.function;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/**
 * Test cMethod.
 */
public class cMethodTest {
	
	/* data */
	public Object ans;
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
		c0MathPi = new cMethod((iMethod)(Object... a) -> { c0MathPi(); return null; });
		c1StrRev = new cMethod((iMethod)(Object... a) -> { c1StrRev((String)a[0]); return null; });
		c2StrCat = new cMethod((iMethod)(Object... a) -> { c2StrCat((String)a[0], (String)a[1]); return null; });
		c3MathMax = new cMethod((iMethod)(Object... a) -> { c3MathMax((double)a[0], (double)a[1], (double)a[2]); return null; });
		c4MathMin = new cMethod((iMethod)(Object... a) -> { c4MathMin((double)a[0], (double)a[1], (double)a[2], (double)a[3]); return null; });
		c5ListAdd = new cMethod((iMethod)(Object... a) -> { c5ListAdd((double)a[0], (double)a[1], (double)a[2], (double)a[3], (double)a[4]); return null; });
		c6MapRemove = new cMethod((iMethod)(Object... a) -> { c6MapRemove((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5]); return null; });
		c7NumSort = new cMethod((iMethod)(Object... a) -> { c7NumSort((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5], (int)a[6]); return null; });
		f0MathPi = new cMethod((iMethod)(Object... a) -> f0MathPi());
		f1StrRev = new cMethod((iMethod)(Object... a) -> f1StrRev((String)a[0]));
		f2StrCat = new cMethod((iMethod)(Object... a) -> f2StrCat((String)a[0], (String)a[1]));
		f3MathMax = new cMethod((iMethod)(Object... a) -> f3MathMax((double)a[0], (double)a[1], (double)a[2]));
		f4MathMin = new cMethod((iMethod)(Object... a) -> f4MathMin((double)a[0], (double)a[1], (double)a[2], (double)a[3]));
		f5ListAdd = new cMethod((iMethod)(Object... a) -> f5ListAdd((double)a[0], (double)a[1], (double)a[2], (double)a[3], (double)a[4]));
		f6MapRemove = new cMethod((iMethod)(Object... a) -> f6MapRemove((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5]));
		f7NumSort = new cMethod((iMethod)(Object... a) -> f7NumSort((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5], (int)a[6]));
		frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newRefiConsumer() {
		System.out.println("# New Ref iConsumer");
		c0MathPi = new cMethod((iConsumer0)this::c0MathPi);
		c1StrRev = new cMethod((iConsumer1<String>)this::c1StrRev);
		c2StrCat = new cMethod((iConsumer2<String, String>)this::c2StrCat);
		c3MathMax = new cMethod((iConsumer3<Double, Double, Double>)this::c3MathMax);
		c4MathMin = new cMethod((iConsumer4<Double, Double, Double, Double>)this::c4MathMin);
		c5ListAdd = new cMethod((iConsumer5<Double, Double, Double, Double, Double>)this::c5ListAdd);
		c6MapRemove = new cMethod((iConsumer6<Integer, Integer, Integer, Integer, Integer, Integer>)this::c6MapRemove);
		c7NumSort = new cMethod((iConsumer7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)this::c7NumSort);
		frun(); gcall(null); gapply(null);
	}
	
	@Test
	public void newLambdaiConsumer() {
		System.out.println("# New Lambda iConsumer");
		c0MathPi = new cMethod((iConsumer0)() -> { c0MathPi(); });
		c1StrRev = new cMethod((iConsumer1<String>)(a) -> { c1StrRev(a); });
		c2StrCat = new cMethod((iConsumer2<String, String>)(a, b) -> { c2StrCat(a, b); });
		c3MathMax = new cMethod((iConsumer3<Double, Double, Double>)(a, b, c) -> { c3MathMax((double)a, (double)b, (double)c); });
		c4MathMin = new cMethod((iConsumer4<Double, Double, Double, Double>)(a, b, c, d) -> { c4MathMin((double)a, (double)b, (double)c, (double)d); });
		c5ListAdd = new cMethod((iConsumer5<Double, Double, Double, Double, Double>)(a, b, c, d, e) -> { c5ListAdd((double)a, (double)b, (double)c, (double)d, (double)e); });
		c6MapRemove = new cMethod((iConsumer6<Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f) -> { c6MapRemove((int)a, (int)b, (int)c, (int)d, (int)e, (int)f); });
		c7NumSort = new cMethod((iConsumer7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f, g) -> { c7NumSort((int)a, (int)b, (int)c, (int)d, (int)e, (int)f, (int)g); });
		frun(); gcall(null); gapply(null);
	}

	@Test
	public void newRefiFunction() {
		System.out.println("# New Ref iFunction");
		f0MathPi = new cMethod((iFunction0)this::f0MathPi);
		f1StrRev = new cMethod((iFunction1<String, String>)this::f1StrRev);
		f2StrCat = new cMethod((iFunction2<String, String, String>)this::f2StrCat);
		f3MathMax = new cMethod((iFunction3<Double, Double, Double, Double>)this::f3MathMax);
		f4MathMin = new cMethod((iFunction4<Double, Double, Double, Double, Double>)this::f4MathMin);
		f5ListAdd = new cMethod((iFunction5<Double, Double, Double, Double, Double, List>)this::f5ListAdd);
		f6MapRemove = new cMethod((iFunction6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)this::f6MapRemove);
		f7NumSort = new cMethod((iFunction7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)this::f7NumSort);
		frun(); gcall(null); gapply(null);
	}

	@Test
	public void newLambdaiFunction() {
		System.out.println("# New Lambda iFunction");
		f0MathPi = new cMethod((iFunction0<Double>)() -> f0MathPi());
		f1StrRev = new cMethod((iFunction1<String, String>)(a) -> f1StrRev(a));
		f2StrCat = new cMethod((iFunction2<String, String, String>)(a, b) -> f2StrCat(a, b));
		f3MathMax = new cMethod((iFunction3<Double, Double, Double, Double>)(a, b, c) -> f3MathMax((double)a, (double)b, (double)c));
		f4MathMin = new cMethod((iFunction4<Double, Double, Double, Double, Double>)(a, b, c, d) -> f4MathMin((double)a, (double)b, (double)c, (double)d));
		f5ListAdd = new cMethod((iFunction5<Double, Double, Double, Double, Double, List>)(a, b, c, d, e) -> f5ListAdd((double)a, (double)b, (double)c, (double)d, (double)e));
		f6MapRemove = new cMethod((iFunction6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)(a, b, c, d, e, f) -> f6MapRemove((int)a, (int)b, (int)c, (int)d, (int)e, (int)f));
		f7NumSort = new cMethod((iFunction7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)(a, b, c, d, e, f, g) -> f7NumSort((int)a, (int)b, (int)c, (int)d, (int)e, (int)f, (int)g));
		frun(); gcall(null); gapply(null);
	}

	@Test
	public void newObjClsMthd() throws NoSuchMethodException, SecurityException {
		System.out.println("# cMethod(Object, Class, Method)");
		Class<?> c = cMethodTest.class;
		c0MathPi = new cMethod(this, c, c.getMethod("c0MathPi"));
		c1StrRev = new cMethod(this, c, c.getMethod("c1StrRev", String.class));
		c2StrCat = new cMethod(this, c, c.getMethod("c2StrCat", String.class, String.class));
		c3MathMax = new cMethod(this, c, c.getMethod("c3MathMax", double.class, double.class, double.class));
		c4MathMin = new cMethod(this, c, c.getMethod("c4MathMin", double.class, double.class, double.class, double.class));
		c5ListAdd = new cMethod(this, c, c.getMethod("c5ListAdd", double.class, double.class, double.class, double.class, double.class));
		c6MapRemove = new cMethod(this, c, c.getMethod("c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		c7NumSort = new cMethod(this, c, c.getMethod("c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		f0MathPi = new cMethod(this, c, c.getMethod("f0MathPi"));
		f1StrRev = new cMethod(this, c, c.getMethod("f1StrRev", String.class));
		f2StrCat = new cMethod(this, c, c.getMethod("f2StrCat", String.class, String.class));
		f3MathMax = new cMethod(this, c, c.getMethod("f3MathMax", double.class, double.class, double.class));
		f4MathMin = new cMethod(this, c, c.getMethod("f4MathMin", double.class, double.class, double.class, double.class));
		f5ListAdd = new cMethod(this, c, c.getMethod("f5ListAdd", double.class, double.class, double.class, double.class, double.class));
		f6MapRemove = new cMethod(this, c, c.getMethod("f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		f7NumSort = new cMethod(this, c, c.getMethod("f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		frun(); gcall(null); gapply(null);
	}

	@Test
	public void newClsMthd() throws NoSuchMethodException, SecurityException {
		System.out.println("# cMethod(Class, Method, Parameter types)");
		Class<?> c = cMethodTest.class;
		c0MathPi = new cMethod(null, c, c.getMethod("c0MathPi"));
		c1StrRev = new cMethod(null, c, c.getMethod("c1StrRev", String.class));
		c2StrCat = new cMethod(null, c, c.getMethod("c2StrCat", String.class, String.class));
		c3MathMax = new cMethod(null, c, c.getMethod("c3MathMax", double.class, double.class, double.class));
		c4MathMin = new cMethod(null, c, c.getMethod("c4MathMin", double.class, double.class, double.class, double.class));
		c5ListAdd = new cMethod(null, c, c.getMethod("c5ListAdd", double.class, double.class, double.class, double.class, double.class));
		c6MapRemove = new cMethod(null, c, c.getMethod("c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		c7NumSort = new cMethod(null, c, c.getMethod("c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
		f0MathPi = new cMethod(null, c, c.getMethod("f0MathPi"));
		f1StrRev = new cMethod(null, c, c.getMethod("f1StrRev", String.class));
		f2StrCat = new cMethod(null, c, c.getMethod("f2StrCat", String.class, String.class));
		f3MathMax = new cMethod(null, c, c.getMethod("f3MathMax", double.class, double.class, double.class));
		f4MathMin = new cMethod(null, c, c.getMethod("f4MathMin", double.class, double.class, double.class, double.class));
		f5ListAdd = new cMethod(null, c, c.getMethod("f5ListAdd", double.class, double.class, double.class, double.class, double.class));
		f6MapRemove = new cMethod(null, c, c.getMethod("f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class));
		f7NumSort = new cMethod(null, c, c.getMethod("f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class));
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
			c0MathPi.run();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(c1StrRev!=null) {
			c1StrRev.run("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(c2StrCat!=null) {
			c2StrCat.run("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(c3MathMax!=null) {
			c3MathMax.run(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(c4MathMin!=null) {
			c4MathMin.run(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(c5ListAdd!=null) {
			ans = new ArrayList();
			c5ListAdd.run(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(c6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			c6MapRemove.run(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(c7NumSort!=null) {
			c7NumSort.run(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		if(f0MathPi!=null) {
			ans = f0MathPi.run();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.run("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.run("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.run(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.run(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.run(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.run(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.run(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
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
			ans = f0MathPi.call(t);
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.call(t, "Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.call(t, "Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.call(t, 0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.call(t, 1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.call(t, 0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.call(t, 0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.call(t, 4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
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
			ans = f0MathPi.apply(t, new Object[] {});
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.apply(t, new Object[] {"Splinter"});
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.apply(t, new Object[] {"Alpha", "bet"});
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.apply(t, new Object[] {0.0, 1.0, 0.1});
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.apply(t, new Object[] {1.0, 1.1, 0.1, 0.11});
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.apply(t, new Object[] {0.1, 0.2, 0.3, 0.4, 0.5});
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.apply(t, new Object[] {0, 1, 2, 3, 4, 5});
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.apply(t, new Object[] {4, 3, 5, 2, 0, 1, 6});
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		System.out.println();
	}
	
	/**
	 * Test of bind method, of class cMethod.
	 * @param t This object.
	 */
	public void bind(Object t) {
		System.out.println("## bind");
		c0MathPi = c0MathPi.bind(t);
		c1StrRev = c1StrRev.bind(t);
		c2StrCat = c2StrCat.bind(t);
		c3MathMax = c3MathMax.bind(t);
		c4MathMin = c4MathMin.bind(t);
		c5ListAdd = c5ListAdd.bind(t);
		c6MapRemove = c6MapRemove.bind(t);
		c7NumSort = c7NumSort.bind(t);
		f0MathPi = f0MathPi.bind(t);
		f1StrRev = f1StrRev.bind(t);
		f2StrCat = f2StrCat.bind(t);
		f3MathMax = f3MathMax.bind(t);
		f4MathMin = f4MathMin.bind(t);
		f5ListAdd = f5ListAdd.bind(t);
		f6MapRemove = f6MapRemove.bind(t);
		f7NumSort = f7NumSort.bind(t);
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
	
	public double f0MathPi() {
		System.out.print("f0MathPi.");
		return Math.PI;
	}
	
	public String f1StrRev(String a) {
		System.out.print("f1StrRev.");
		return new StringBuilder(a).reverse().toString();
	}
	
	public String f2StrCat(String a, String b) {
		System.out.print("f2StrCat.");
		return a+b;
	}
	
	public double f3MathMax(double a, double b, double c) {
		System.out.print("f3MathMax.");
		return Math.max(a, Math.max(b, c));
	}
	
	public double f4MathMin(double a, double b, double c, double d) {
		System.out.print("f4MathMin.");
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}
	
	public List f5ListAdd(double a, double b, double c, double d, double e) {
		System.out.print("f5ListAdd.");
		List p = (List)ans;
		p.addAll(Arrays.asList(a, b, c, d, e));
		return p;
	}
	
	public Map f6MapRemove(int a, int b, int c, int d, int e, int f) {
		System.out.print("f6MapRemove.");
		Map p = (Map)ans;
		for(int n : new int[] {a, b, c, d, e, f})
			p.remove(n);
		return p;
	}
	
	public int[] f7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		System.out.print("f7NumSort.");
		int[] p = new int[] {a, b, c, d, e, f, g};
		Arrays.sort(p);
		return p;
	}
}
