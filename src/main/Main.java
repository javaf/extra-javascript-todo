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
		MethodHandle mh = MethodHandles.lookup().unreflect(m);
		System.out.println(mh.type());
		mh = LambdaMetafactory.metafactory(l, "apply", MethodType.methodType(BiFunction.class, Main.class), MethodType.methodType(Object.class, Object.class, Object.class), mh, MethodType.methodType(int.class, int.class, int.class)).getTarget();
		System.out.println(mh.type());
		System.out.println(l.unreflectGetter(Main.class.getField("a")).type());
		BiFunction f = (BiFunction)mh.invoke(new Main());
		System.out.println(f.apply(1, 2));
	}
}
