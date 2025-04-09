package d_aop.a_interceptor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"/aop/interceptor/application-context.xml"});

        Developer man = context.getBean("man", Developer.class);
        Developer woman = context.getBean("woman", Developer.class);

        System.out.println(man instanceof Developer);
        System.out.println(man instanceof Man);

        man.develop();
        System.out.println("================================");
        woman.develop();

    }
}