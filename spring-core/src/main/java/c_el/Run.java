package c_el;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.MapPropertySource;

public class Run {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"/el/application-context.xml"}, false
        );

        Map<String, Object> environmentProperty = new HashMap<>();
        environmentProperty.put("lecture.name", "hmd");
        environmentProperty.put("lecture.age", "20");
        environmentProperty.put("lecture.subject", List.of("java", "js", "spring").toString());
        environmentProperty.put("lecture.progress",
            Map.of("java",100, "js", 100, "spring", 20).toString());

        MapPropertySource propertySource = new MapPropertySource("A", environmentProperty);
        context.getEnvironment().getPropertySources().addLast(propertySource);
        context.refresh();

        A_Literal aLiteral = context.getBean("a_Literal", A_Literal.class);
        System.out.println(aLiteral);
        System.out.println("==================================");
        B_Operator operator = context.getBean("b_Operator", B_Operator.class);
        System.out.println(operator);
        System.out.println("==================================");
        C_BeanRef beanRef = context.getBean("c_BeanRef", C_BeanRef.class);
        System.out.println(beanRef);
        System.out.println("==================================");
        D_Method method = context.getBean("d_Method", D_Method.class);
        System.out.println(method);
        System.out.println("==================================");
        E_Properties properties = context.getBean("e_Properties", E_Properties.class);
        System.out.println(properties);
    }
}