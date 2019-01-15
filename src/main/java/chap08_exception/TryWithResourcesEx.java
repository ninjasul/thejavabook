
public class TryWithResourcesEx {
	public static void main(String [] args) {
		// JDK 1.7 ???? try ?? ??? AutoCloseable interface ???? ????? ??? ??? close ??? ????? ?? ????.
		try(CloseableResource cr = new CloseableResource() ) {
			cr.exceptionWork(false);	// ????? ??????? ????.
		} catch(WorkException e) {
			e.printStackTrace();
		} catch(CloseException e ) {
			e.printStackTrace();
		}
		System.out.println();


		try(CloseableResource cr = new CloseableResource() ) {
			// WorkException?? ?????? ??????
			cr.exceptionWork(true);		// ????? ?????.
		} catch(WorkException e) {
			// WorkException?? main Exception??.
			// ????? CloseableResource ????? close ??? CloseException?? ?????.
			// ?????? java?? ?? ???? ?? ?? ????? Exception?? ?????? ?? ???????
			// CloseException?? suppressed Exception???? ?????? ?????.
			// ???? try-catch ???? ????????? ???? ????? WorkException?? ??????,
			// ???????? ????? CloseException ?? ???????? ????.
			e.printStackTrace();
		} catch(CloseException e ) {
			e.printStackTrace();
		}
		System.out.println();

		// ???? try ???????? finally ?? ???? try-catch ???? ?? ????? ??.
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
		System.out.println("exceptionWork(" + throwException + ")?? ????");

		if( throwException ) {
			throw new WorkException("WorkException ???!!!");
		}
	}

	public void close() throws CloseException {
		System.out.println("close()?? ????");
		throw new CloseException("CloseException ???!!!");
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