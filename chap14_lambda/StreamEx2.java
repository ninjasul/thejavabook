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
		
		// 파일명만 획득
		Stream<String> filenameStream = fileStream.map(File::getName);
		// 파일명 출력
		filenameStream.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
			.filter(s -> s.indexOf('.') != -1)			// 확장자가 없는 것은 제외	
			.map(s -> s.substring(s.indexOf('.')+1))	// 확장자만 추출 -> java, bak, java, txt
			.map(String::toUpperCase)					// 대문자로 변환 -> JAVA, BAK, JAVA, TXT
			.distinct()									// 중복 제거 -> JAVA, BAK, TXT
			.forEach(System.out::print);			    // JAVABAKTXT
		
		System.out.println();
	}
}
