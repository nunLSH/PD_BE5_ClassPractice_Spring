package c_el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A_Literal {

    // SpringEL 표현식 기반의 값을 주입해주는 어노테이션
    @Value("#{'Hello Spring EL'}")
    private String message;

    @Value("#{100}")
    private int number;

    @Value("#{3.14}")
    private double pie;

    @Value("#{true}")
    private boolean activated;

    @Value("#{null}")
    private Object nullValue;

    @Override
    public String toString() {
        return "A_Literal{" +
            "message='" + message + '\'' +
            ", number=" + number +
            ", pie=" + pie +
            ", activated=" + activated +
            ", nullValue=" + nullValue +
            '}';
    }
}