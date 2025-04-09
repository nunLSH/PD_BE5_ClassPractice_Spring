package a_regist.b_annotation.component;

import java.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            "/regist/annotation/component/application-context.xml"
        );

        Developer developer = context.getBean("developer", Developer.class);
        JdbcProperties jdbcProperties = context.getBean("jdbcProperties", JdbcProperties.class);
        JdbcTemplate jdbcTemplate = context.getBean("mysqlTemplate", JdbcTemplate.class);
        System.out.println(developer);
        System.out.println(jdbcProperties);
        System.out.println(jdbcTemplate);

    }

}
