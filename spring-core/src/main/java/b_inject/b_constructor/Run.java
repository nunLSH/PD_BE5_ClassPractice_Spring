package b_inject.b_constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            "/inject/constructor/application-context.xml"
        );

        TransactionManager transactionManager =
            context.getBean("transactionManager", TransactionManager.class);
        System.out.println(transactionManager);

        JdbcTemplate jdbcTemplate =
            context.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println(jdbcTemplate);
    }
}