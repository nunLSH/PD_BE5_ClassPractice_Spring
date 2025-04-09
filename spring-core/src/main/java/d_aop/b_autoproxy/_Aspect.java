package d_aop.b_autoproxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class _Aspect {

    // @Before : target 호출 전
    // @After  : target 호출 후
    // @AfterThrowing : target 호출 후 예외가 발생했을 때 수행
    // @AfterReturning : target 호출 후 반환되는 객체에 접근하여 작업을 수행

    @Before("execution(* d_aop.b_autoproxy.*.*(..))")
    public void before(){
        System.out.println("출근카드를 찍는다.");
    }

    @After("execution(public * d_aop.b_autoproxy.*.*(..))")
    public void after(){
        System.out.println("집에 간다.");
    }

    @AfterThrowing(pointcut = "execution(public * d_aop.b_autoproxy.*.*(..))",
        throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println(ex.getMessage());
        System.out.println("쉬는 날이었다.");
    }

    @AfterReturning(pointcut = "execution(* d_aop.b_autoproxy.Man.*(..))", returning = "res")
    public void afterReturning(Object res){
        System.out.println(res);
    }

}