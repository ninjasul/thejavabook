import java.util.*;
import java.util.function.*;

public class LambdaEx7 {
	
	public static void main(String[] args) {
		
		// String을 입력받아 16진수로 변환
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		
		// Integer를 입력받아 2진수 문자열로 반환
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		
		// f 실행 후 g 실행
		Function<String, String> h = f.andThen(g);
		
		// g실행 후 f 실행
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println(h.apply("FF"));		// "FF" -> 255 -> "11111111"
		System.out.println(h2.apply(2));		// 2 -> "10" -> 16
		
		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();    // i >= 100
		
		Predicate<Integer> all = notP.and(q).or(r);		// ( i >= 100 && i < 200 || i%2==0 )
		System.out.println(all.test(150));				// true
		
		String str1 = "abc";
		String str2 = "abc";
		
		Predicate<String> p2 = Predicate.isEqual(str1);		
		boolean result = p2.test(str2);		// true
		System.out.println(result);
		
	}
}
