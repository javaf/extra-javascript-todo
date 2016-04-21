package js.lang.function;
import static org.junit.Assert.*;
import java.util.function.*;
import java.util.*;
import org.junit.*;

/**
 * Test oFunction.
 */
public class oFunctionTest {
	
	/* data */
	public Object ans;
	public oFunction c0MathPi;
	public oFunction c1StrRev;
	public oFunction c2StrCat;
	public oFunction c3MathMax;
	public oFunction c4MathMin;
	public oFunction c5ListAdd;
	public oFunction c6MapRemove;
	public oFunction c7NumSort;
	public oFunction f0MathPi;
	public oFunction f1StrRev;
	public oFunction f2StrCat;
	public oFunction f3MathMax;
	public oFunction f4MathMin;
	public oFunction f5ListAdd;
	public oFunction f6MapRemove;
	public oFunction f7NumSort;
	
	
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
	
	@Test
	public void newiConsumerX() {
		System.out.println("# oFunction(iConsumerX)");
		c0MathPi = new oFunction((iConsumer0)() -> { c0MathPi(); });
		c1StrRev = new oFunction((iConsumer1<String>)(a) -> { c1StrRev(a); });
		c2StrCat = new oFunction((iConsumer2<String, String>)(a, b) -> { c2StrCat(a, b); });
		c3MathMax = new oFunction((iConsumer3<Double, Double, Double>)(a, b, c) -> { c3MathMax((double)a, (double)b, (double)c); });
		c4MathMin = new oFunction((iConsumer4<Double, Double, Double, Double>)(a, b, c, d) -> { c4MathMin((double)a, (double)b, (double)c, (double)d); });
		c5ListAdd = new oFunction((iConsumer5<Double, Double, Double, Double, Double>)(a, b, c, d, e) -> { c5ListAdd((double)a, (double)b, (double)c, (double)d, (double)e); });
		c6MapRemove = new oFunction((iConsumer6<Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f) -> { c6MapRemove((int)a, (int)b, (int)c, (int)d, (int)e, (int)f); });
		c7NumSort = new oFunction((iConsumer7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f, g) -> { c7NumSort((int)a, (int)b, (int)c, (int)d, (int)e, (int)f, (int)g); });
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}

	@Test
	public void newiFunctionX() {
		System.out.println("# oFunction(iFunctionX)");
		f0MathPi = new oFunction((iFunction0<Double>)() -> f0MathPi());
		f1StrRev = new oFunction((iFunction1<String, String>)(a) -> f1StrRev(a));
		f2StrCat = new oFunction((iFunction2<String, String, String>)(a, b) -> f2StrCat(a, b));
		f3MathMax = new oFunction((iFunction3<Double, Double, Double, Double>)(a, b, c) -> f3MathMax((double)a, (double)b, (double)c));
		f4MathMin = new oFunction((iFunction4<Double, Double, Double, Double, Double>)(a, b, c, d) -> f4MathMin((double)a, (double)b, (double)c, (double)d));
		f5ListAdd = new oFunction((iFunction5<Double, Double, Double, Double, Double, List>)(a, b, c, d, e) -> f5ListAdd((double)a, (double)b, (double)c, (double)d, (double)e));
		f6MapRemove = new oFunction((iFunction6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)(a, b, c, d, e, f) -> f6MapRemove((int)a, (int)b, (int)c, (int)d, (int)e, (int)f));
		f7NumSort = new oFunction((iFunction7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)(a, b, c, d, e, f, g) -> f7NumSort((int)a, (int)b, (int)c, (int)d, (int)e, (int)f, (int)g));
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}
	
	@Test
	public void newConsumer() {
		System.out.println("# oFunction(Consumer)");
		c1StrRev = new oFunction((Consumer<String>)(a) -> { c1StrRev(a); });
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}
	
	@Test
	public void newBiConsumer() {
		System.out.println("# oFunction(BiConsumer)");
		c2StrCat = new oFunction((BiConsumer<String, String>)(a, b) -> { c2StrCat(a, b); });
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}

	@Test
	public void newSupplier() {
		System.out.println("# oFunction(Supplier)");
		f0MathPi = new oFunction((Supplier)() -> f0MathPi());
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}

	@Test
	public void newFunction() {
		System.out.println("# oFunction(Function)");
		f1StrRev = new oFunction((Function<String, String>)(a) -> f1StrRev(a));
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}

	@Test
	public void newBiFunction() {
		System.out.println("# oFunction(BiFunction)");
		f2StrCat = new oFunction((BiFunction<String, String, String>)(a, b) -> f2StrCat(a, b));
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}

	@Test
	public void newObjClsMthd() {
		System.out.println("# oFunction(Object, Class, Method, Parameter types)");
		c0MathPi = new oFunction(this, oFunctionTest.class, "c0MathPi");
		c1StrRev = new oFunction(this, oFunctionTest.class, "c1StrRev", String.class);
		c2StrCat = new oFunction(this, oFunctionTest.class, "c2StrCat", String.class, String.class);
		c3MathMax = new oFunction(this, oFunctionTest.class, "c3MathMax", double.class, double.class, double.class);
		c4MathMin = new oFunction(this, oFunctionTest.class, "c4MathMin", double.class, double.class, double.class, double.class);
		c5ListAdd = new oFunction(this, oFunctionTest.class, "c5ListAdd", double.class, double.class, double.class, double.class, double.class);
		c6MapRemove = new oFunction(this, oFunctionTest.class, "c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class);
		c7NumSort = new oFunction(this, oFunctionTest.class, "c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class);
		f0MathPi = new oFunction(this, oFunctionTest.class, "f0MathPi");
		f1StrRev = new oFunction(this, oFunctionTest.class, "f1StrRev", String.class);
		f2StrCat = new oFunction(this, oFunctionTest.class, "f2StrCat", String.class, String.class);
		f3MathMax = new oFunction(this, oFunctionTest.class, "f3MathMax", double.class, double.class, double.class);
		f4MathMin = new oFunction(this, oFunctionTest.class, "f4MathMin", double.class, double.class, double.class, double.class);
		f5ListAdd = new oFunction(this, oFunctionTest.class, "f5ListAdd", double.class, double.class, double.class, double.class, double.class);
		f6MapRemove = new oFunction(this, oFunctionTest.class, "f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class);
		f7NumSort = new oFunction(this, oFunctionTest.class, "f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class);
		accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}

	@Test
	public void newClsMthd() {
		System.out.println("# oFunction(Class, Method, Parameter types)");
		c0MathPi = new oFunction(null, oFunctionTest.class, "c0MathPi");
		c1StrRev = new oFunction(null, oFunctionTest.class, "c1StrRev", String.class);
		c2StrCat = new oFunction(null, oFunctionTest.class, "c2StrCat", String.class, String.class);
		c3MathMax = new oFunction(null, oFunctionTest.class, "c3MathMax", double.class, double.class, double.class);
		c4MathMin = new oFunction(null, oFunctionTest.class, "c4MathMin", double.class, double.class, double.class, double.class);
		c5ListAdd = new oFunction(null, oFunctionTest.class, "c5ListAdd", double.class, double.class, double.class, double.class, double.class);
		c6MapRemove = new oFunction(null, oFunctionTest.class, "c6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class);
		c7NumSort = new oFunction(null, oFunctionTest.class, "c7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class);
		f0MathPi = new oFunction(null, oFunctionTest.class, "f0MathPi");
		f1StrRev = new oFunction(null, oFunctionTest.class, "f1StrRev", String.class);
		f2StrCat = new oFunction(null, oFunctionTest.class, "f2StrCat", String.class, String.class);
		f3MathMax = new oFunction(null, oFunctionTest.class, "f3MathMax", double.class, double.class, double.class);
		f4MathMin = new oFunction(null, oFunctionTest.class, "f4MathMin", double.class, double.class, double.class, double.class);
		f5ListAdd = new oFunction(null, oFunctionTest.class, "f5ListAdd", double.class, double.class, double.class, double.class, double.class);
		f6MapRemove = new oFunction(null, oFunctionTest.class, "f6MapRemove", int.class, int.class, int.class, int.class, int.class, int.class);
		f7NumSort = new oFunction(null, oFunctionTest.class, "f7NumSort", int.class, int.class, int.class, int.class, int.class, int.class, int.class);
		fcall(this); fapply(this); bind(this); accept(); apply(); run(); fcall(null); fapply(null);
		System.out.println();
	}
	
	@Test
	public void newStringFn() {
		System.out.println("# oFunction(String...)");
		f0MathPi = new oFunction("return Math.PI;");
		f1StrRev = new oFunction("a", "return new StringBuilder((String)a).reverse().toString();");
		f2StrCat = new oFunction("a", "b", "return (String)a+(String)b;");
		f3MathMax = new oFunction("a", "b", "c", "return Math.max((double)a, Math.max((double)b, (double)c));");
		f4MathMin = new oFunction("a", "b", "c", "d", "return Math.min((double)a, Math.min((double)b, Math.min((double)c, (double)d)));");
		accept(); apply(); run(); fcall(null); fapply(null);
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
	public void get() {
		System.out.println("## get");
		if(f0MathPi!=null) {
			ans = f0MathPi.get();
			assertEquals((double)ans, Math.PI, 0.0);
		}
	}
	
	/**
	 * Test of apply method, of class oFunction.
	 */
	public void apply() {
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
	
	/**
	 * Test of call method, of class oFunction.
	 */
	public void run() {
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
	}
	
	/**
	 * Test of call method, of class oFunction.
	 * @param t This object.
	 */
	public void fcall(Object t) {
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
	 * @param t This object.
	 */
	public void fapply(Object t) {
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
	}
	
	/**
	 * Test of bind method, of class oFunction.
	 * @param t This object.
	 */
	public void bind(Object t) {
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
	}

	/**
	 * Test of andThen method, of class oFunction.
	 */
	public void testAndThen() {
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
