package ch13_ninjasul;

public class ThreadEx02 {
	public static void main(String args[]) {
		ThreadEx02_01 t1 = new ThreadEx02_01();
		t1.start();
		System.out.println("ThreadEx2 - main() end");
	}
}

class ThreadEx02_01 extends Thread {
	public void run() {
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
