package proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckNotNull { // method가 호출될 때 전달되는 parameter가 null인지 check
    String[] parameterNames(); // parameterNames attribute에 복수개의 문자열 value
}
