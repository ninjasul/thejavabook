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
				new Student("���ڹ�", 3, 300 ),
				new Student("���ڹ�", 1, 200 ),
				new Student("���ڹ�", 2, 100 ),
				new Student("���ڹ�", 2, 150 ),
				new Student("���ڹ�", 1, 200 ),
				new Student("���ڹ�", 3, 290 ),
				new Student("���ڹ�", 3, 180 ),
		};
		
		// �̸��� �̾Ƽ� List<String> �� ����
		List<String> names = Stream.of(stuArr).map(Student::getName)
											.collect(Collectors.toList());
		System.out.println(names);
		
		// ��Ʈ���� �迭�� ��ȯ
		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
		
		for( Student s : stuArr2 ) {
			System.out.println(s);
		}
		
		// ��Ʈ���� Map<String, Student> �� ��ȯ. �л��̸��� key.
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s->s.getName(),  p->p));
		
		for( String name : stuMap.keySet() ) {
			System.out.println(name + "-" + stuMap.get(name));
		}
		
		// �л� �� ���ϱ�
		long count1 = Stream.of(stuArr).count();
		long count2 = Stream.of(stuArr).collect(Collectors.counting());
		
		System.out.println("count1="+count1);
		System.out.println("count2="+count2);
		
		
		// ���� �հ� ���ϱ�
		long totalScore1 = Stream.of(stuArr).mapToInt(Student::getTotalScore).sum();
		long totalScore2 = Stream.of(stuArr).collect(Collectors.summingLong(Student::getTotalScore));
		long totalScore3 = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		
		System.out.println("totalScore1="+totalScore1);
		System.out.println("totalScore2="+totalScore2);
		System.out.println("totalScore3="+totalScore3);
		
		// �ְ� ���� ȹ�� �л� ���ϱ�
		Optional<Student> topStudent1 = Stream.of(stuArr).max(Comparator.comparingInt(Student::getTotalScore));
		Optional<Student> topStudent2 = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		
		System.out.println("topStudent1="+topStudent1.get());
		System.out.println("topStudent2="+topStudent2.get());
		
		// ��� ���� ���ϱ�
		IntSummaryStatistics stat1 = Stream.of(stuArr).mapToInt(Student::getTotalScore).summaryStatistics();
		IntSummaryStatistics stat2 = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore));
	
		System.out.println("stat1="+stat1);
		System.out.println("stat2="+stat2);
	
		// ���ڿ� ���� (������, ���λ�, ���̻� ���� ����)
		String stuNames = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",", "{", "}"));		
		System.out.println(stuNames);
	}
}
