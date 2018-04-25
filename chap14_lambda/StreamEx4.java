import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx4 {
	public static void main(String[] args) {
		
		Stream<String[]> strArrStrm = Stream.of(
			new String[] { "abc", "def", "jkl" },
			new String[] { "ABC", "GHI", "JKL" }
		);
		
		// Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		// Stream<Stream<String>> -> Stream<String>
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		
		strStrm.map(String::toLowerCase)		
				.distinct()
				.sorted()
				.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
			"Believe or not It is true",
			"Do or do not There is no try",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))		// �迭 �� ���ڿ��� �������� split ó��
			.map(String::toLowerCase)								// �ҹ��ڷ� ��ȯ
			.distinct()												// �ߺ� ����
			.sorted()												// ����
			.forEach(System.out::println);							// ���
		System.out.println();
		
		
		// case3 - ��Ʈ���� ��Ʈ���� �ϳ��� ��ĥ �� 
		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");
			
		// Stream<String> + Stream<String> -> Stream<Stream<String>>
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		Stream<String> strStream = strStrmStrm
				.map( s -> s.toArray(String[]::new) )	// Stream<Stream<String>> -> Stream<String[]>
				.flatMap(Arrays::stream);				// Stream<String[]> -> Stream<String>
		
		strStream.map(String::toLowerCase)
			.distinct()
			.forEach(System.out::println);
		
	}
}
