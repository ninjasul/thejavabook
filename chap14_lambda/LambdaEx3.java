
class LambdaOuter {
	int val = 10;
	
	class Inner {
		int val = 20;
		
		void method( int i ) {
			int val = 30;
			//i = 10;		// 람다식 내에서 참조하는 지역변수는 final 이 붙어 있지 않더라도 상수로 간주됨.
			
			// 다음과 같이 외부에 선언된 변수값을 람다식 내에서 참조할 수 있음.
			// 다만 람다식 내에서 참조하는 지역변수는 final 이 붙어있지 않더라도 상수로 간주됨.
			// 따라서 다른 곳에서도 이 지역변수들은 값을 변경할 수 없음.
			MyFunction f = () -> {
				System.out.println("             i : " + i );
				System.out.println("           val : " + val );
				System.out.println("      this.val : " + ++this.val );
				System.out.println("Outer.this.val : " + ++LambdaOuter.this.val );
			};
			
			f.run();
		}
	}
}

public class LambdaEx3 {
	
	public static void main(String[] args) {
		LambdaOuter outer = new LambdaOuter();
		LambdaOuter.Inner inner = outer.new Inner();
		inner.method(100);
	}
}
