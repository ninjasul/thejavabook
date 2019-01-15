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
	// ���ڿ� ���׸� Ÿ���� ���ڰ� �����ϴ� ��� varargs ��� �߻���.
	// ������ �������� T�� Object�� ġȯ�ǰ�, Object�� �迭���� ��� Ÿ���� ��ü�� �� �� �����Ƿ� varargs ��� �߻��ϴ� ����.
	// Type safety: Potential heap pollution via varargs parameter a
	// @SafeVarargs ������̼��� �����Ͽ� �ذ�.
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
