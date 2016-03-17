package main;
import java.util.*;
import java.util.function.*;
import js.*;


public class Main {

    public static void main(String[] args) {
			String[] a = new String[] {"hello", "java"};
			Map b = new HashMap();
			b.put("massage", a);
			b.put("response", a);
			System.out.println(JSON.stringify(b, (BiFunction)((Object k, Object v) -> { if(k.equals("message")) return "aaaaa"; return v; }), 4));
    }
}
