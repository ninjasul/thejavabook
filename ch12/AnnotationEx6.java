import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

public class AnnotationEx6 {
	@Target({FIELD, TYPE, TYPE_USE})
	public @interface MyAnnotation{}
	
	@MyAnnotation
	class MyClass {
		@MyAnnotation
		int i;
		
		@MyAnnotation
		MyClass mc;		
	}
}
