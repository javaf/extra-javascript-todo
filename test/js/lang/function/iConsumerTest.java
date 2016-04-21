package js.lang.function;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Test iMethod.
 */
public class iConsumerTest {
	
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
	
	
	/* constructor */
	public iConsumerTest() {
	}
	
	
	/* set up and clear */
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Test: iConsumer");
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
		System.out.println();
	}

	
	/* test functionality */
	@Test
	public void refMethod() {
		System.out.println("# Ref Method");
		c0MathPi = (iConsumer0)this::c0MathPi;
		c1StrRev = (iConsumer1<String>)this::c1StrRev;
		c2StrCat = (iConsumer2<String, String>)this::c2StrCat;
		c3MathMax = (iConsumer3<Double ,Double, Double>)this::c3MathMax;
		c4MathMin = (iConsumer4<Double, Double, Double, Double>)this::c4MathMin;
		c5ListAdd = (iConsumer5<Double, Double, Double, Double, Double>)this::c5ListAdd;
		c6MapRemove = (iConsumer6<Integer, Integer, Integer, Integer, Integer, Integer>)this::c6MapRemove;
		c7NumSort = (iConsumer7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)this::c7NumSort;
		frun(); faccept(); flength();
	}
	
	@Test
	public void lambdaMethod() {
		System.out.println("# Lambda Method");
		c0MathPi = (iConsumer0)() -> { c0MathPi(); };
		c1StrRev = (iConsumer1<String>)(a) -> { c1StrRev(a); };
		c2StrCat = (iConsumer2<String, String>)(a, b) -> { c2StrCat(a, b); };
		c3MathMax = (iConsumer3<Double ,Double, Double>)(a, b, c) -> { c3MathMax(a, b, c); };
		c4MathMin = (iConsumer4<Double, Double, Double, Double>)(a, b, c, d) -> { c4MathMin(a, b, c, d); };
		c5ListAdd = (iConsumer5<Double, Double, Double, Double, Double>)(a, b, c, d, e) -> { c5ListAdd(a, b, c, d, e); };
		c6MapRemove = (iConsumer6<Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f) -> { c6MapRemove(a, b, c, d, e, f); };
		c7NumSort = (iConsumer7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>)(a, b, c, d, e, f, g) -> { c7NumSort(a, b, c, d, e, f, g); };
		frun(); faccept(); flength();
	}
	
	
	/* test support function */
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
		System.out.println();
	}
	
	public void faccept() {
		System.out.println("## accept");
		if(c0MathPi!=null) {
			((iConsumer0)c0MathPi).accept();
			assertEquals((double)ans, Math.PI, 0.0);
		}
		if(c1StrRev!=null) {
			((iConsumer1)c1StrRev).accept("Splinter");
			assertEquals(ans, "retnilpS");
		}
		if(c2StrCat!=null) {
			((iConsumer2)c2StrCat).accept("Alpha", "bet");
			assertEquals(ans, "Alphabet");
		}
		if(c3MathMax!=null) {
			((iConsumer3)c3MathMax).accept(0.0, 1.0, 0.1);
			assertEquals((double)ans, 1.0, 0.0);
		}
		if(c4MathMin!=null) {
			((iConsumer4)c4MathMin).accept(1.0, 1.1, 0.1, 0.11);
			assertEquals((double)ans, 0.1, 0.0);
		}
		if(c5ListAdd!=null) {
			ans = new ArrayList();
			((iConsumer5)c5ListAdd).accept(0.1, 0.2, 0.3, 0.4, 0.5);
			assertEquals(ans, Arrays.asList(new Double[] {0.1, 0.2, 0.3, 0.4, 0.5}));
		}
		if(c6MapRemove!=null) {
			HashMap<Integer, String> p = new HashMap<>();
			for(int n : new int[] {0, 1, 2, 3, 4, 5})
				p.put(n, ""+n);
			ans = p;
			((iConsumer6)c6MapRemove).accept(0, 1, 2, 3, 4, 5);
			assertEquals(p.size(), 0);
		}
		if(c7NumSort!=null) {
			((iConsumer7)c7NumSort).accept(4, 3, 5, 2, 0, 1, 6);
			assertArrayEquals((int[])ans, new int[] {0, 1, 2, 3, 4, 5, 6});
		}
		System.out.println();
	}
	
	public void flength() {
		System.out.println("## length");
		if(c0MathPi!=null) assertEquals(c0MathPi.length(), 0);
		if(c1StrRev!=null) assertEquals(c1StrRev.length(), 1);
		if(c2StrCat!=null) assertEquals(c2StrCat.length(), 2);
		if(c3MathMax!=null) assertEquals(c3MathMax.length(), 3);
		if(c4MathMin!=null) assertEquals(c4MathMin.length(), 4);
		if(c5ListAdd!=null) assertEquals(c5ListAdd.length(), 5);
		if(c6MapRemove!=null) assertEquals(c6MapRemove.length(), 6);
		if(c7NumSort!=null) assertEquals(c7NumSort.length(), 7);
	}
	
	
	/* support function */
	public void c0MathPi() {
		System.out.print("c0MathPi.");
		ans = Math.PI;
	}
	
	public void c1StrRev(String a) {
		System.out.print("c1StrRev.");
		ans = new StringBuilder(a).reverse().toString();
	}
	
	public void c2StrCat(String a, String b) {
		System.out.print("c2StrCat.");
		ans = a+b;
	}
	
	public void c3MathMax(Double a, Double b, Double c) {
		System.out.print("c3MathMax.");
		ans = Math.max(a, Math.max(b, c));
	}
	
	public void c4MathMin(Double a, Double b, Double c, Double d) {
		System.out.print("c4MathMin.");
		ans = Math.min(a, Math.min(b, Math.min(c, d)));
	}
	
	public void c5ListAdd(Double a, Double b, Double c, Double d, Double e) {
		System.out.print("c5ListAdd.");
		List p = (List)ans;
		p.addAll(Arrays.asList(a, b, c, d, e));
		ans = p;
	}
	
	public void c6MapRemove(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f) {
		System.out.print("c6MapRemove.");
		Map p = (Map)ans;
		for(int n : new int[] {a, b, c, d, e, f})
			p.remove(n);
		ans = p;
	}
	
	public void c7NumSort(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f, Integer g) {
		System.out.print("c7NumSort.");
		int[] p = new int[] {a, b, c, d, e, f, g};
		Arrays.sort(p);
		ans = p;
	}
}
