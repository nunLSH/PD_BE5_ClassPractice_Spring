package d_aop.a_interceptor;

import org.springframework.stereotype.Component;

@Component
public class Man implements Developer {
    public void develop() {
        System.out.println("남자가 파이썬으로 개발한다.");
    }
}