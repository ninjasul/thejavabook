import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
	public static void main(String[] args) {
		File[] fileArr = { 	
			new File("Ex1.java"),
			new File("Ex1.bak"),
			new File("Ex2.java"),
			new File("Ex1"),
			new File("Filex1.txt")
		};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		// ���ϸ� ȹ��
		Stream<String> filenameStream = fileStream.map(File::getName);
		// ���ϸ� ���
		filenameStream.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
			.filter(s -> s.indexOf('.') != -1)			// Ȯ���ڰ� ���� ���� ����	
			.map(s -> s.substring(s.indexOf('.')+1))	// Ȯ���ڸ� ���� -> java, bak, java, txt
			.map(String::toUpperCase)					// �빮�ڷ� ��ȯ -> JAVA, BAK, JAVA, TXT
			.distinct()									// �ߺ� ���� -> JAVA, BAK, TXT
			.forEach(System.out::print);			    // JAVABAKTXT
		
		System.out.println();
	}
}
