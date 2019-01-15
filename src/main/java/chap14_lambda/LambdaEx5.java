import java.util.*;
import java.util.function.*;

public class LambdaEx5 {
	
	public static void main(String[] args) {
		
		// 매개 변수는 없고 리턴값만 있음.
		Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
		
		// 매개 변수만 있고 리턴값이 없음.
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		
		// 조건식을 표현. 매개변수는 하나, 리턴값은 boolean
		Predicate<Integer> p = i -> i % 2 == 0;
		
		// 매개 변수 하나에 리턴값 있음.
		Function<Integer, Integer> f = i -> i/10 * 10;		
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		
		printEvenNum( p, c, list );
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list ) {
		List<T> newList = new ArrayList<T>(list.size());
		
		for( T i : list ) {
			newList.add(f.apply(i));
		}
		
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		
		for( T i : list ) {
			if( p.test(i) ) {
				c.accept(i);
			}			
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList( Supplier<T> s, List<T> list ) {
		for( int i = 0; i < 10; i++ ) {
			list.add(s.get());
		}
	}
}
