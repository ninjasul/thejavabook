
public class InnerEx1 {
	class InstanceInner {
		int iv = 100;
		//static int cv = 100;		// instance inner Ŭ���������� static ������ ������ �� ����.
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
			//static int cv = 300;			//  local inner Ŭ�������� static ������ ������ �� ����.
			final static int CONST = 300;
		}
	}
	
	public static void main(String args[]) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
		// System.out.println(StaticInner.iv);			// static inner Ŭ������ instance ������� �ٷ� ������ �Ұ���.
		//InnerEx1 ex1 = new InnerEx1();
		InnerEx1.StaticInner si = new InnerEx1.StaticInner();
		System.out.println(si.iv);						// static inner Ŭ������ instance ����� �����Ϸ��� ���� �̷��� �����ϰ� �ؾ� ��.		
	}
}
