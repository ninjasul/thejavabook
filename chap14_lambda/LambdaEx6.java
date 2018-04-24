import java.util.*;
import java.util.function.*;

public class LambdaEx6 {
	
	public static void main(String[] args) {
		
		// �Ű������� ���� int �� ���ϰ��� ����.
		IntSupplier s = () -> (int) (Math.random()*100)+1;
		
		// int�� �Ű������� �ְ� ���� ���� ����.
		IntConsumer c = i -> System.out.print(i+", ");
		
		// int �� �Ű������� ���� ���ǹ�, ���ϰ��� boolean
		IntPredicate p = i -> i % 2 == 0;
		
		// �Ű����� �ϳ��� ���� ���� Ÿ���� int������ ����
		IntUnaryOperator op = i -> i/10*10;					// Functon�� ����ϴ� �ͺ��� ����ڽ�&��ڽ� Ƚ���� �پ�� ������ ����.
		Function<Integer, Integer> f = i -> i/10*10;		// �Ű����� ����Ÿ�� �� Integer
		IntFunction<Integer> f2 = i -> i/10*10;				// �Ű������� int, ���� Ÿ���� Integer
		
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
