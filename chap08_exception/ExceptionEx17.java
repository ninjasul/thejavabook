public class ExceptionEx17 {

	public static void main(String[] args) {
		try {
			//method1();
			//System.out.println(method2());	
			System.out.println(method3());
		} catch( Exception e ) {
			System.out.println("main 메서드에서 예외가 처리되었습니다.");
		}
	}
	
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch( Exception e ) {
			System.out.println("method1 메서드에서 예외가 처리되었습니다.");
			
			// 다시 예외를 발생시킴.
			throw e;
		}		
	}
	
	static int method2() throws Exception {
		try {
			System.out.println("method2() 가 호출되었습니다.");
			return 0;
		} catch( Exception e ) {
			e.printStackTrace();
			return 1;	// catch 블럭 내에도 return 문이 필요함.
		} finally {
			System.out.println("method2() 의 finally 블록이 실행되었습니다.");
		}
		
	}
	
	
	static int method3() throws Exception {
		try {
			throw new Exception("method3() 내에서 Exception 호출");
			//System.out.println("method3() 가 호출되었습니다.");			
			//return 0;
		} catch( Exception e ) {			
			e.printStackTrace();			
			//return 1;	// catch 블럭 내에도 return 문이 필요함.
			throw new Exception(); 	// return 문 대신 예외를 호출한 메서드로 전달.
		} finally {
			System.out.println("method3() 의 finally 블록이 실행되었습니다.");
		}
		
	}
}
