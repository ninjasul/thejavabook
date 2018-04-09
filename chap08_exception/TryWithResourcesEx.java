
public class TryWithResourcesEx {
	public static void main(String [] args) {
		// JDK 1.7 부터 try 문 안에 AutoCloseable interface 하위 객체를 넣어 자동 close 되게 처리할 수 있음.
		try(CloseableResource cr = new CloseableResource() ) {
			cr.exceptionWork(false);	// 예외가 발생하지 않음.
		} catch(WorkException e) {
			e.printStackTrace();
		} catch(CloseException e ) {
			e.printStackTrace();
		}
		System.out.println();
		
		
		try(CloseableResource cr = new CloseableResource() ) {
			// WorkException을 강제로 발생시킴
			cr.exceptionWork(true);		// 예외가 발생함.
		} catch(WorkException e) {
			// WorkException이 main Exception임.
			// 그런데 CloseableResource 객체를 close 하면서 CloseException도 발생함.
			// 하지만 java는 한 번에 두 개 이상의 Exception을 발생시킬 수 없으므로 
			// CloseException은 suppressed Exception으로 추가되어 발생함.
			// 기존 try-catch 문을 사용하였다면 최초 발생한 WorkException은 무시되고, 
			// 마지막에 발생한 CloseException 만 발생하였을 것임.
			e.printStackTrace();
		} catch(CloseException e ) {
			e.printStackTrace();
		}		
		System.out.println();
		
		// 기존 try 문에서는 finally 문 내에 try-catch 문을 또 써줘야 함.
		CloseableResource cr = null;
		try {
			cr = new CloseableResource();
			cr.exceptionWork(true);	
		} catch(WorkException e) {
			e.printStackTrace();
		} finally {
			try {
				cr.close();
			} catch (CloseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class CloseableResource implements AutoCloseable {
	public void exceptionWork(boolean throwException) throws WorkException {
		System.out.println("exceptionWork(" + throwException + ")가 호출됨");
		
		if( throwException ) {
			throw new WorkException("WorkException 발생!!!");
		}
	}
	
	public void close() throws CloseException {
		System.out.println("close()가 호출됨");
		throw new CloseException("CloseException 발생!!!");
	}
}

class WorkException extends Exception {
	WorkException(String msg) {
		super(msg);
	}
}

class CloseException extends Exception {
	CloseException(String msg) {
		super(msg);
	}
}
