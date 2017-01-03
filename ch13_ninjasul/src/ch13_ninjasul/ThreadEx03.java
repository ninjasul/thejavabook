package ch13_ninjasul;

public class ThreadEx03 {
	public static void main(String args[]) {
		ThreadEx03_01 t1 = new ThreadEx03_01();
		t1.run();
		System.out.println("ThreadEx2 - main() end");
	}
}

class ThreadEx03_01 extends Thread {
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
