package ch13_ninjasul;

public class ThreadEx05 {
	
	static long startTime = 0;

	public static void main(String[] args)	{
		ThreadEx05_01 th1 = new ThreadEx05_01();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 500; i++)
			System.out.printf("%s",  new String("-"));
		System.out.println("");
		
		System.out.println("소요시간1: " + (System.currentTimeMillis()-startTime));
		
	}
}

class ThreadEx05_01 extends Thread {
	public void run() {
		for( int i = 0; i< 500; i++ )
			System.out.printf("%s",  new String("|"));
		System.out.println("");
		
		System.out.println("소요시간2: "+(System.currentTimeMillis() - ThreadEx05.startTime));
	}
}