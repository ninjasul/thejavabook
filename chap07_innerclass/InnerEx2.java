
public class InnerEx2 {
	class InstanceInner {}
	static class StaticInner {}
	
	InstanceInner iv = new InstanceInner();	
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		// static 멤버는 instance 멤버에 직접 접근할 수 없음.
		//InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		// 굳이 static 멤버에서 instance 멤버에 접근하려면 아래와 같이 객체를 생성해야 함.
		// 인스턴스 클래스는 외부 클래스를 먼저 생성해야 함.
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj1 = outer.new InstanceInner();
	}
	
	void instanceMethod() {
		// 인스턴스 메서드에서는 인스턴스 멤버와 static 멤버 모두 접근 가능함.
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		// local class는 해당 메서드 내에서만 접근 가능함.
		// LocalInner lv = new LocalInner();
	}
	
	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
}
