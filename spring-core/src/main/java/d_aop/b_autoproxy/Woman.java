package d_aop.b_autoproxy;

import org.springframework.stereotype.Component;

@Component
public class Woman {
    public String develop() {
        System.out.println("여자가 JS로 개발한다.");
        return "woman";
    }
}