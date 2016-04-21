package main;
import java.lang.reflect.*;
import java.lang.invoke.*;
import java.util.function.*;

public class Main {
	
	public static int a;
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) throws Throwable {
		MethodHandles.Lookup l = MethodHandles.lookup();
		Method m = Main.class.getMethod("add", int.class, int.class);
		MethodHandle mh = l.unreflectGetter(Main.class.getField("a"));
		System.out.println(mh.type());
		mh = LambdaMetafactory.metafactory(l, "get", MethodType.methodType(Supplier.class), MethodType.methodType(Object.class), mh, MethodType.methodType(int.class)).getTarget();
		System.out.println(mh.type());
		Supplier f = (Supplier)mh.invoke();
		System.out.println(f.get());
	}
}
