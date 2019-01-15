
public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv;		// outer 클래스의 private 멤버에도 접근이 가능함.
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
		// static inner 클래스는 outer 클래스의 instance 멤버에 접근할 수 없음.
		// int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;
		
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;			// 원래 에러이나 JDK 1.8부터 에러가 아님
			int liv4 = LV;			// 가능함.
		}
	}
}
