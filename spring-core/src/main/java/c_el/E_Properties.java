package c_el;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class E_Properties {

    // ${} Spring 의 속성값 참조
    // String 반환
    @Value("${lecture.name}")
    private String name;

    @Value("${lecture.age}")
    private String age;

    @Value("${lecture.subject}")
    private String subject;

    @Value("${lecture.progress}")
    private String progress;

    // : property 를 찾을 수 없을 경우 기본값 지정
    @Value("${lecture.none:spring el}")
    private String none;

    @Override
    public String toString() {
        return "E_Properties{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", subject='" + subject + '\'' +
            ", progress='" + progress + '\'' +
            ", none='" + none + '\'' +
            '}';
    }
}