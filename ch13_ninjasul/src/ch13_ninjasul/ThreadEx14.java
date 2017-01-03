package ch13_ninjasul;

import javax.swing.JOptionPane;

public class ThreadEx14 {
	public static void main(String[] args) throws Exception {
		ThreadEx14_01 th1 = new ThreadEx14_01();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + " �Դϴ�.");
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
        
        System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
    }
}