import java.util.*;
import java.util.function.*;

public class LambdaEx6 {
	
	public static void main(String[] args) {
		
		// 매개변수는 없고 int 형 리턴값만 있음.
		IntSupplier s = () -> (int) (Math.random()*100)+1;
		
		// int형 매개변수만 있고 리턴 값은 없음.
		IntConsumer c = i -> System.out.print(i+", ");
		
		// int 형 매개변수를 통한 조건문, 리턴값은 boolean
		IntPredicate p = i -> i % 2 == 0;
		
		// 매개변수 하나와 리턴 값의 타입이 int형으로 동일
		IntUnaryOperator op = i -> i/10*10;					// Functon을 사용하는 것보다 오토박싱&언박싱 횟수가 줄어들어서 성능이 좋음.
		Function<Integer, Integer> f = i -> i/10*10;		// 매개변수 리턴타입 모도 Integer
		IntFunction<Integer> f2 = i -> i/10*10;				// 매개변수는 int, 리턴 타입은 Integer
		
		int [] arr = new int[10];
		
		makeRandomList(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum( p, c, arr );
		
		int [] newArr = doSomething( op, arr );
		System.out.println(Arrays.toString(newArr));
	}
	
	static void makeRandomList( IntSupplier s, int[] arr ) {
		for( int i = 0; i < arr.length; i++ ) {
			arr[i] = s.getAsInt();
		}
	}

	static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		
		for( int i : arr ) {
			if( p.test(i) ) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}
	
	static int[] doSomething(IntUnaryOperator op, int[] arr ) {
		int [] newArr = new int[arr.length];
		
		for( int i = 0; i < newArr.length; i++ ) {
			newArr[i] = op.applyAsInt(arr[i]);
		}
		
		return newArr;
	}
}
