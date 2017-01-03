package ch13_ninjasul;

import javax.swing.JOptionPane;

public class ThreadEx14 {
	public static void main(String[] args) throws Exception {
		ThreadEx14_01 th1 = new ThreadEx14_01();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		th1.interrupt();
		System.out.println("main(): isInterrupted(): " + th1.isInterrupted());
	}
}

class ThreadEx14_01 extends Thread {
    public void run() {
        int i = 10;
        
        while( i != 0 && !isInterrupted() ) {
            System.out.println(i--);
            try {
            	Thread.sleep(1000);
            } catch( InterruptedException e ) {
            	System.out.println("run(): isInterrupted #1: " + isInterrupted());
            	interrupt();
            	System.out.println("run(): isInterrupted #2: " + isInterrupted());
            }
        }
        
        System.out.println("카운트가 종료되었습니다.");
    }
}