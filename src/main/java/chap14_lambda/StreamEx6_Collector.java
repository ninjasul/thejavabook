import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6_Collector {
	
	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("이자바", 3, 300 ),
				new Student("김자바", 1, 200 ),
				new Student("안자바", 2, 100 ),
				new Student("박자바", 2, 150 ),
				new Student("소자바", 1, 200 ),
				new Student("나자바", 3, 290 ),
				new Student("감자바", 3, 180 ),
		};
		
		// 이름만 뽑아서 List<String> 에 저장
		List<String> names = Stream.of(stuArr).map(Student::getName)
											.collect(Collectors.toList());
		System.out.println(names);
		
		// 스트림을 배열로 변환
		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
		
		for( Student s : stuArr2 ) {
			System.out.println(s);
		}
		
		// 스트림을 Map<String, Student> 로 변환. 학생이름이 key.
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s->s.getName(),  p->p));
		
		for( String name : stuMap.keySet() ) {
			System.out.println(name + "-" + stuMap.get(name));
		}
		
		// 학생 수 구하기
		long count1 = Stream.of(stuArr).count();
		long count2 = Stream.of(stuArr).collect(Collectors.counting());
		
		System.out.println("count1="+count1);
		System.out.println("count2="+count2);
		
		
		// 총점 합계 구하기
		long totalScore1 = Stream.of(stuArr).mapToInt(Student::getTotalScore).sum();
		long totalScore2 = Stream.of(stuArr).collect(Collectors.summingLong(Student::getTotalScore));
		long totalScore3 = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		
		System.out.println("totalScore1="+totalScore1);
		System.out.println("totalScore2="+totalScore2);
		System.out.println("totalScore3="+totalScore3);
		
		// 최고 총점 획득 학생 구하기
		Optional<Student> topStudent1 = Stream.of(stuArr).max(Comparator.comparingInt(Student::getTotalScore));
		Optional<Student> topStudent2 = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		
		System.out.println("topStudent1="+topStudent1.get());
		System.out.println("topStudent2="+topStudent2.get());
		
		// 통계 정보 구하기
		IntSummaryStatistics stat1 = Stream.of(stuArr).mapToInt(Student::getTotalScore).summaryStatistics();
		IntSummaryStatistics stat2 = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore));
	
		System.out.println("stat1="+stat1);
		System.out.println("stat2="+stat2);
	
		// 문자열 연결 (구분자, 접두사, 접미사 지정 가능)
		String stuNames = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",", "{", "}"));		
		System.out.println(stuNames);
	}
}
