package main;
import js.core.*;

public class Main {
		
	public Integer add(Integer a, Integer b) {
		return a+b;
	}

	public static void main(String[] args) throws Throwable {
		oFunction f = new oFunction(new Main(), Main.class, "add", Integer.class, Integer.class);
		System.out.println("name: "+f.name());
		System.out.println(f.call(null, 1, 2));
	}
}
