
public class InnerEx1 {
	class InstanceInner {
		int iv = 100;
		//static int cv = 100;		// instance inner 클래스에서는 static 변수를 선언할 수 없음.
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
			//static int cv = 300;			//  local inner 클래스에는 static 변수를 선언할 수 없음.
			final static int CONST = 300;
		}
	}
	
	public static void main(String args[]) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
		// System.out.println(StaticInner.iv);			// static inner 클래스의 instance 멤버에는 바로 접근이 불가함.
		//InnerEx1 ex1 = new InnerEx1();
		InnerEx1.StaticInner si = new InnerEx1.StaticInner();
		System.out.println(si.iv);						// static inner 클래스의 instance 멤버에 접근하려면 굳이 이렇게 불편하게 해야 함.		
	}
}
