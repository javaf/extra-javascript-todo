package main;
import java.util.regex.Pattern;
import js.lang.function.oFunction;

public class Main {
		
	public int add(int a, int b, int c) {
		return a+b+c;
	}

	public static void main(String[] args) throws Throwable {
		oFunction f = new oFunction(Main.class, "add", int.class, int.class, int.class);
		f = f.bind(new Main());
		System.out.println("name: "+f.name());
		System.out.println("length: "+f.length());
		long j = 0;
		for(long i=0; i<1000000000; i++)
			j += (long)(int)f.apply(null, new Integer[] {1, 2, 3});
		System.out.println(j);
	}
}
