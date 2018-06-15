import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectorEx1 {
	public static void main(String[] args) {
		String[] strArr = { "aaa", "bbb", "ccc" };
		Stream<String> strStream = Stream.of(strArr);

		String result = strStream.collect(new ConcatCollector());

		System.out.println(Arrays.toString(strArr));
		System.out.println("result="+result);
	}
}

// T(요소)를 A에 누적한 다음, 결과를 R로 변환해서 return
class ConcatCollector implements Collector<String, StringBuilder, String> {

	// 작업 결과를 저장할 공간을 제공
	@Override
	public Supplier<StringBuilder> supplier() {
		return () -> new StringBuilder();
		//return StringBuilder::new;
	}

	// 스트림 요소를 수집할 방법을 제공
	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		return (sb, s) -> sb.append(s);
		//return StringBuilder::append;
	}

	// 두 저장 공간을 병합할 방법을 제공(병렬 스트림)
	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (sb, sb2) -> sb.append(sb2);
		// return StringBuilder::append;
	}

	// 결과를 최종적으로 변환할 방법을 제공
	@Override
	public Function<StringBuilder, String> finisher() {
		return sb -> sb.toString();
		// return StringBuilder::toString;
	}


	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}
}

