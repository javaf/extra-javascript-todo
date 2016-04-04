package main;
import java.util.function.*;
import js.core.*;
import js.lang.function.*;

public class Main {

    public static void main(String[] args) {
			oFunction f = new oFunction((BiFunction<Integer, Integer, Integer>) (a, b) -> a+b);
			System.out.println(f);
    }
}
