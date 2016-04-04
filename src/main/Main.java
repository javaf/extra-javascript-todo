package main;
import js.core.*;

public class Main {
		
	public int add(int a, int b, int c) {
		return a+b+c;
	}

	public static void main(String[] args) throws Throwable {
		oFunction f = new oFunction(new Main(), Main.class, "add", int.class, int.class, int.class);
		System.out.println("name: "+f.name());
		System.out.println("length: "+f.length());
		long j = 0;
		for(long i=0; i<10000000000L; i++)
			j += (long)(int)f.apply(null, new Integer[] {1, 2, 3});
		System.out.println(j);
	}
}
