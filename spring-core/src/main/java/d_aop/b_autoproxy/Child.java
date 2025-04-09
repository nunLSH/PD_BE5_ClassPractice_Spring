package d_aop.b_autoproxy;

import org.springframework.stereotype.Component;

@Component
public class Child {
    public String develop(){
        System.out.println("아기가 자바로 개발한다.");
        throw new RuntimeException("귀여운 실수가 발생했습니다.");
    }
}