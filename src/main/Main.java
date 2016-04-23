package main;
import java.util.function.*;
import java.lang.reflect.*;
import java.lang.invoke.*;

public class Main {
	
	public static int add(int a) {
		return a;
	}
	
	public static void main(String[] args) throws Throwable {
		MethodHandles.Lookup l = MethodHandles.lookup();
		Method m = Main.class.getMethod("add", int.class);
		MethodHandle mh = l.unreflect(m);
		mh = LambdaMetafactory.metafactory(l, "apply", MethodType.methodType(BiFunction.class),
			MethodType.genericMethodType(2), mh, mh.type()).getTarget();
		BiFunction f = (BiFunction)mh.invoke();
		System.out.println(f.apply(null, 1));
	}
}
