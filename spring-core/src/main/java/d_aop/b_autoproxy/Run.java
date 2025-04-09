package d_aop.b_autoproxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"/aop/autoproxy/application-context.xml"});

        Man man = context.getBean("man", Man.class);
        Woman woman = context.getBean("woman", Woman.class);
        Child child = context.getBean("child", Child.class);

        System.out.println(man instanceof Man);

        man.develop();
        System.out.println("================================");
        woman.develop();
        System.out.println("================================");
        child.develop();

    }
}