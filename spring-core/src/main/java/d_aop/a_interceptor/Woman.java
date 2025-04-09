package d_aop.a_interceptor;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Developer {
    public void develop() {
        System.out.println("여자가 JS로 개발한다.");
    }
}