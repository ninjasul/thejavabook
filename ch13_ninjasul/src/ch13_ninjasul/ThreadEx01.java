package ch13_ninjasul;

class ThreadEx01 {
	public static void main(String args[]) {
		ThreadEx01_01 t1 = new ThreadEx01_01();
		
		Runnable r = new ThreadEx01_02();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}

class ThreadEx01_01 extends Thread {
	public void run() {
		for( int i = 0; i < 5; i++ ) {			
			System.out.println(getName());			
		}
	}
}


class ThreadEx01_02 implements Runnable {
	public void run() {
		for( int i = 0; i < 5; i++ ) {
			// Thread.currentThread() - 현재 실행 중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}
}
