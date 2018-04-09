
public class InnerEx2 {
	class InstanceInner {}
	static class StaticInner {}
	
	InstanceInner iv = new InstanceInner();	
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		// static ����� instance ����� ���� ������ �� ����.
		//InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		// ���� static ������� instance ����� �����Ϸ��� �Ʒ��� ���� ��ü�� �����ؾ� ��.
		// �ν��Ͻ� Ŭ������ �ܺ� Ŭ������ ���� �����ؾ� ��.
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj1 = outer.new InstanceInner();
	}
	
	void instanceMethod() {
		// �ν��Ͻ� �޼��忡���� �ν��Ͻ� ����� static ��� ��� ���� ������.
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		// local class�� �ش� �޼��� �������� ���� ������.
		// LocalInner lv = new LocalInner();
	}
	
	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
}
