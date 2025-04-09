package d_aop.b_autoproxy;

import org.springframework.stereotype.Component;

@Component
public class Man {
    public String develop() {
        System.out.println("남자가 파이썬으로 개발한다.");
        return "Man";
    }
}