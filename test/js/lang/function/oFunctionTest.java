package js.lang.function;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/**
 * Test oFunction.
 */
public class oFunctionTest {
	
	/* data */
	private Object ans;
	private oFunction c0MathPi;
	private oFunction c1StrRev;
	private oFunction c2StrCat;
	private oFunction c3MathMax;
	private oFunction c4MathMin;
	private oFunction c5ListAdd;
	private oFunction c6MapRemove;
	private oFunction c7NumSort;
	private oFunction f0MathPi;
	private oFunction f1StrRev;
	private oFunction f2StrCat;
	private oFunction f3MathMax;
	private oFunction f4MathMin;
	private oFunction f5ListAdd;
	private oFunction f6MapRemove;
	private oFunction f7NumSort;
	
	
	/* constructor */
	public oFunctionTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: oFunction");
		System.out.println("===============");
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
	@Test
	public void newiMethod() {
		System.out.println("# oFunction(iMethod)");
		Object t = new oFunctionTest();
		c0MathPi = new oFunction((iMethod)(Object... a) -> { c0MathPi(); return null; });
		c1StrRev = new oFunction((iMethod)(Object... a) -> { c1StrRev((String)a[0]); return null; });
		c2StrCat = new oFunction((iMethod)(Object... a) -> { c2StrCat((String)a[0], (String)a[1]); return null; });
		c3MathMax = new oFunction((iMethod)(Object... a) -> { c3MathMax((double)a[0], (double)a[1], (double)a[2]); return null; });
		c4MathMin = new oFunction((iMethod)(Object... a) -> { c4MathMin((double)a[0], (double)a[1], (double)a[2], (double)a[3]); return null; });
		c5ListAdd = new oFunction((iMethod)(Object... a) -> { c5ListAdd((double)a[0], (double)a[1], (double)a[2], (double)a[3], (double)a[4]); return null; });
		c6MapRemove = new oFunction((iMethod)(Object... a) -> { c6MapRemove((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5]); return null; });
		c7NumSort = new oFunction((iMethod)(Object... a) -> { c7NumSort((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5], (int)a[6]); return null; });
		f0MathPi = new oFunction((iMethod)(Object... a) -> f0MathPi());
		f1StrRev = new oFunction((iMethod)(Object... a) -> f1StrRev((String)a[0]));
		f2StrCat = new oFunction((iMethod)(Object... a) -> f2StrCat((String)a[0], (String)a[1]));
		f3MathMax = new oFunction((iMethod)(Object... a) -> f3MathMax((double)a[0], (double)a[1], (double)a[2]));
		f4MathMin = new oFunction((iMethod)(Object... a) -> f4MathMin((double)a[0], (double)a[1], (double)a[2], (double)a[3]));
		f5ListAdd = new oFunction((iMethod)(Object... a) -> f5ListAdd((double)a[0], (double)a[1], (double)a[2], (double)a[3], (double)a[4]));
		f6MapRemove = new oFunction((iMethod)(Object... a) -> f6MapRemove((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5]));
		f7NumSort = new oFunction((iMethod)(Object... a) -> f7NumSort((int)a[0], (int)a[1], (int)a[2], (int)a[3], (int)a[4], (int)a[5], (int)a[6]));
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}
	
	
	/* test use function */
	/**
	 * Test of accept method, of class oFunction.
	 */
	public void accept() {
		System.out.println("## accept");
		if(c0MathPi!=null) {
			c0MathPi.accept();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(c1StrRev!=null) {
			c1StrRev.accept("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(c2StrCat!=null) {
			c2StrCat.accept("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(c3MathMax!=null) {
			c3MathMax.accept(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(c4MathMin!=null) {
			c4MathMin.accept(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(c5ListAdd!=null) {
			ans = new ArrayList();
			c5ListAdd.accept(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(c6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			c6MapRemove.accept(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(c7NumSort!=null) {
			c7NumSort.accept(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
	}
	
	/**
	 * Test of get method, of class oFunction.
	 */
	private void get() {
		System.out.println("## get");
		if(f0MathPi!=null) {
			ans = f0MathPi.get();
			assertEquals((double)ans, Math.PI, 0.0);
		}
	}
	
	/**
	 * Test of apply method, of class oFunction.
	 */
	private void apply() {
		System.out.println("## apply");
		if(f0MathPi!=null) {
			ans = f0MathPi.apply();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = f1StrRev.apply("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = f2StrCat.apply("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = f3MathMax.apply(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = f4MathMin.apply(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = f5ListAdd.apply(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = f6MapRemove.apply(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = f7NumSort.apply(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
	}
	
	private void run() {
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
	}
	
	/**
	 * Test of call method, of class oFunction.
	 */
	private void fcall(Object t) {
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
	}
	
	/**
	 * Test of apply method, of class oFunction.
	 */
	private void fapply(Object t) {
		System.out.println("## fapply");
		if(c0MathPi!=null) {
			c0MathPi.apply(t);
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
			ans = f0MathPi.apply(t);
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
	}
	
	/**
	 * Test of bind method, of class oFunction.
	 */
	private void bind(Object t) {
		c0MathPi.bind(t);
		c1StrRev.bind(t);
		c2StrCat.bind(t);
		c3MathMax.bind(t);
		c4MathMin.bind(t);
		c5ListAdd.bind(t);
		c6MapRemove.bind(t);
		c7NumSort.bind(t);
		f0MathPi.bind(t);
		f1StrRev.bind(t);
		f2StrCat.bind(t);
		f3MathMax.bind(t);
		f4MathMin.bind(t);
		f5ListAdd.bind(t);
		f6MapRemove.bind(t);
		f7NumSort.bind(t);
	}

	/**
	 * Test of andThen method, of class oFunction.
	 */
	public void testAndThen() {
	}
	
	
	/* support function */
	private void c0MathPi() {
		ans = f0MathPi();
	}
	
	private void c1StrRev(String a) {
		ans = f1StrRev(a);
	}
	
	private void c2StrCat(String a, String b) {
		ans = f2StrCat(a, b);
	}
	
	private void c3MathMax(double a, double b, double c) {
		ans = f3MathMax(a, b, c);
	}
	
	private void c4MathMin(double a, double b, double c, double d) {
		ans = f4MathMin(a, b, c, d);
	}
	
	private void c5ListAdd(double a, double b, double c, double d, double e) {
		ans = f5ListAdd(a, b, c, d, e);
	}
	
	private void c6MapRemove(int a, int b, int c, int d, int e, int f) {
		ans = f6MapRemove(a, b, c, d, e, f);
	}
	
	private void c7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		ans = f7NumSort(a, b, c, d, e, f, g);
	}
	
	private double f0MathPi() {
		return Math.PI;
	}
	
	private String f1StrRev(String a) {
		return new StringBuilder(a).reverse().toString();
	}
	
	private String f2StrCat(String a, String b) {
		return a+b;
	}
	
	private double f3MathMax(double a, double b, double c) {
		return Math.max(a, Math.max(b, c));
	}
	
	private double f4MathMin(double a, double b, double c, double d) {
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}
	
	private List f5ListAdd(double a, double b, double c, double d, double e) {
		List p = (List)ans;
		p.addAll(Arrays.asList(a, b, c, d, e));
		return p;
	}
	
	private Map f6MapRemove(int a, int b, int c, int d, int e, int f) {
		Map p = (Map)ans;
		for(int n : new int[] {a, b, c, d, e, f})
			p.remove(n);
		return p;
	}
	
	private int[] f7NumSort(int a, int b, int c, int d, int e, int f, int g) {
		int[] p = new int[] {a, b, c, d, e, f, g};
		Arrays.sort(p);
		return p;
	}

}
