
class Outer {
	class InstanceInner {
		int iv = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
	}
}

class InnerEx4 {
	public static void main(String[] args) {
		// instance class의 instance 를 생성하려면 outer 클래스의 instance를 먼저 생성해야 함.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv: " + ii.iv );
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv );
		
		// static inner 클래스의 instance는 outer 클래스를 먼저 생성하지 않아도 됨.
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.lv : " + si.iv );
	}
}