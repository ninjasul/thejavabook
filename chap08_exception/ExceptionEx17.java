public class ExceptionEx17 {

	public static void main(String[] args) {
		try {
			//method1();
			//System.out.println(method2());	
			System.out.println(method3());
		} catch( Exception e ) {
			System.out.println("main �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
		}
	}
	
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch( Exception e ) {
			System.out.println("method1 �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			
			// �ٽ� ���ܸ� �߻���Ŵ.
			throw e;
		}		
	}
	
	static int method2() throws Exception {
		try {
			System.out.println("method2() �� ȣ��Ǿ����ϴ�.");
			return 0;
		} catch( Exception e ) {
			e.printStackTrace();
			return 1;	// catch �� ������ return ���� �ʿ���.
		} finally {
			System.out.println("method2() �� finally ����� ����Ǿ����ϴ�.");
		}
		
	}
	
	
	static int method3() throws Exception {
		try {
			throw new Exception("method3() ������ Exception ȣ��");
			//System.out.println("method3() �� ȣ��Ǿ����ϴ�.");			
			//return 0;
		} catch( Exception e ) {			
			e.printStackTrace();			
			//return 1;	// catch �� ������ return ���� �ʿ���.
			throw new Exception(); 	// return �� ��� ���ܸ� ȣ���� �޼���� ����.
		} finally {
			System.out.println("method3() �� finally ����� ����Ǿ����ϴ�.");
		}
		
	}
}
