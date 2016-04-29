package js.lang.function;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Test iFn*.
 */
public class iFnTest {
	
	/* data */
	public Object ans;
	public iProc f0MathPi;
	public iProc f1StrRev;
	public iProc f2StrCat;
	public iProc f3MathMax;
	public iProc f4MathMin;
	public iProc f5ListAdd;
	public iProc f6MapRemove;
	public iProc f7NumSort;
	
	
	/* constructor */
	public iFnTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: iFn*");
		System.out.println("==========");
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
		f0MathPi = (iFn0<Double>)this::f0MathPi;
		f1StrRev = (iFn1<String, String>)this::f1StrRev;
		f2StrCat = (iFn2<String, String, String>)this::f2StrCat;
		f3MathMax = (iFn3<Double ,Double, Double, Double>)this::f3MathMax;
		f4MathMin = (iFn4<Double, Double, Double, Double, Double>)this::f4MathMin;
		f5ListAdd = (iFn5<Double, Double, Double, Double, Double, List>)this::f5ListAdd;
		f6MapRemove = (iFn6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)this::f6MapRemove;
		f7NumSort = (iFn7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)this::f7NumSort;
		frun(); fapply(); flength();
	}
	
	@Test
	public void lambdaMethod() {
		System.out.println("# Lambda Method");
		f0MathPi = (iFn0<Double>)() -> f0MathPi();
		f1StrRev = (iFn1<String, String>)(a) -> f1StrRev(a);
		f2StrCat = (iFn2<String, String, String>)(a, b) -> f2StrCat(a, b);
		f3MathMax = (iFn3<Double ,Double, Double, Double>)(a, b, c) -> f3MathMax(a, b, c);
		f4MathMin = (iFn4<Double, Double, Double, Double, Double>)(a, b, c, d) -> f4MathMin(a, b, c, d);
		f5ListAdd = (iFn5<Double, Double, Double, Double, Double, List>)(a, b, c, d, e) -> f5ListAdd(a, b, c, d, e);
		f6MapRemove = (iFn6<Integer, Integer, Integer, Integer, Integer, Integer, Map>)(a, b, c, d, e, f) -> f6MapRemove(a, b, c, d, e, f);
		f7NumSort = (iFn7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, int[]>)(a, b, c, d, e, f, g) -> f7NumSort(a, b, c, d, e, f, g);
		frun(); fapply(); flength();
	}
	
	
	/* test support function */
	public void frun() {
		System.out.println("## run");
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
		System.out.println();
	}
	
	public void fapply() {
		System.out.println("## accept");
		if(f0MathPi!=null) {
			ans = ((iFn0)f0MathPi).apply();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(f1StrRev!=null) {
			ans = ((iFn1)f1StrRev).apply("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(f2StrCat!=null) {
			ans = ((iFn2)f2StrCat).apply("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(f3MathMax!=null) {
			ans = ((iFn3)f3MathMax).apply(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(f4MathMin!=null) {
			ans = ((iFn4)f4MathMin).apply(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(f5ListAdd!=null) {
			ans = new ArrayList();
			ans = ((iFn5)f5ListAdd).apply(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(f6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			ans = ((iFn6)f6MapRemove).apply(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(f7NumSort!=null) {
			ans = ((iFn7)f7NumSort).apply(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		System.out.println();
	}
	
	public void flength() {
		System.out.println("## length");
		if(f0MathPi!=null) assertEquals(f0MathPi.type().parameterCount(), 0);
		if(f1StrRev!=null) assertEquals(f1StrRev.type().parameterCount(), 1);
		if(f2StrCat!=null) assertEquals(f2StrCat.type().parameterCount(), 2);
		if(f3MathMax!=null) assertEquals(f3MathMax.type().parameterCount(), 3);
		if(f4MathMin!=null) assertEquals(f4MathMin.type().parameterCount(), 4);
		if(f5ListAdd!=null) assertEquals(f5ListAdd.type().parameterCount(), 5);
		if(f6MapRemove!=null) assertEquals(f6MapRemove.type().parameterCount(), 6);
		if(f7NumSort!=null) assertEquals(f7NumSort.type().parameterCount(), 7);
	}
	
	
	/* support function */
	public double f0MathPi() {
		System.out.print("c0MathPi.");
		return Math.PI;
	}
	
	public String f1StrRev(String a) {
		System.out.print("c1StrRev.");
		return new StringBuilder(a).reverse().toString();
	}
	
	public String f2StrCat(String a, String b) {
		System.out.print("c2StrCat.");
		return a+b;
	}
	
	public double f3MathMax(Double a, Double b, Double c) {
		System.out.print("c3MathMax.");
		return Math.max(a, Math.max(b, c));
	}
	
	public double f4MathMin(Double a, Double b, Double c, Double d) {
		System.out.print("c4MathMin.");
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}
	
	public List f5ListAdd(Double a, Double b, Double c, Double d, Double e) {
		System.out.print("c5ListAdd.");
		List p = (List)ans;
		p.addAll(Arrays.asList(a, b, c, d, e));
		return p;
	}
	
	public Map f6MapRemove(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f) {
		System.out.print("c6MapRemove.");
		Map p = (Map)ans;
		for(int n : new int[] {a, b, c, d, e, f})
			p.remove(n);
		return p;
	}
	
	public int[] f7NumSort(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f, Integer g) {
		System.out.print("c7NumSort.");
		int[] p = new int[] {a, b, c, d, e, f, g};
		Arrays.sort(p);
		return p;
	}
}
