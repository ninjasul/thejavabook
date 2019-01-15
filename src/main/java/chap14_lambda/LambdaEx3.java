
class LambdaOuter {
	int val = 10;
	
	class Inner {
		int val = 20;
		
		void method( int i ) {
			int val = 30;
			//i = 10;

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
