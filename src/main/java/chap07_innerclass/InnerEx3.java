
public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv;		// outer Ŭ������ private ������� ������ ������.
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
		// static inner Ŭ������ outer Ŭ������ instance ����� ������ �� ����.
		// int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;
		
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;			// ���� �����̳� JDK 1.8���� ������ �ƴ�
			int liv4 = LV;			// ������.
		}
	}
}
