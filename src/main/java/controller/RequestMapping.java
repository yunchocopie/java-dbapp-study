package controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 실행 시점에 어노테이션 보게 함
@Target(ElementType.METHOD) // 메서드 위에 설정하겠다 (해당 어노테이션이 어떤 종류의 요소에 적용될 수 있는지를 지정하는 메타 어노테이션)
public @interface RequestMapping {
    String uri(); // i : identify // 추상메소드
}
