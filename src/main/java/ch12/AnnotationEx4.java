import java.util.Arrays;

class MyArrayList<T> {
	T[] arr;

	@SafeVarargs
	@SuppressWarnings("varargs")
	MyArrayList(T... arr) {
		this.arr = arr;
	}
	
	// @SafeVarargs
	@SuppressWarnings("unchecked")
	// 인자에 제네릭 타입의 인자가 존재하는 경우 varargs 경고가 발생함.
	// 컴파일 과정에서 T가 Object로 치환되고, Object의 배열에는 모든 타입의 객체가 들어갈 수 있으므로 varargs 경고가 발생하는 것임.
	// Type safety: Potential heap pollution via varargs parameter a
	// @SafeVarargs 어노테이션을 삽입하여 해결.
	public static <T> MyArrayList<T> asList(T... a) { 
        return new MyArrayList<>(a);
    }

	public String toString() {
		return Arrays.toString(arr);
	}
}

class AnnotationEx4 {
//	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		MyArrayList<String> list = MyArrayList.asList("1","2","3");

		System.out.println(list);
	}
}
