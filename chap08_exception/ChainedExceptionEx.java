
public class ChainedExceptionEx {
	public static void main(String[] args) {
		try {
			install();
		} catch( InstallException e ) {
			System.out.println("InstallException caught");
			e.printStackTrace();
		} catch( Exception e ) {
			System.out.println("Exception caught");
			e.printStackTrace();
		}
	}
	
	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch( SpaceException e ) {
			// ���� Exception �� SpaceException
			// ���� Exception �� InstallException
			InstallException ie = new InstallException("��ġ �� ���� �߻�");
			ie.initCause(e);
			throw ie;
		} catch( MemoryException me ) {
			InstallException ie = new InstallException("��ġ �� ���� �߻�");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() throws SpaceException, MemoryException {
		if( !enoughSpace() ) {
			throw new SpaceException("��ġ�� ������ �����մϴ�.");
		}
		
		if( !enoughMemory() ) {
			throw new MemoryException("�޸𸮰� �����մϴ�.");
			// throw new RuntimeException(new MemoryException("�޸𸮰� �����մϴ�."));
		}
	}
	
	static void copyFiles() {
		System.out.println("copying files...");
	}
	
	
	static void deleteTempFiles() {
		System.out.println("deleting temporary files...");
	}
	
	static boolean enoughSpace() {
		return true;
	}
	
	static boolean enoughMemory() {
		return false;
	}
}

class InstallException extends Exception {
	InstallException(String msg) {
		super(msg);
	}
}

class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}