package b_inject.a_autowired;

import a_regist.b_annotation.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            "/inject/autowired/application-context.xml"
        );

        TransactionManager transactionManager =
            context.getBean("transactionManager", TransactionManager.class);
        //System.out.println(transactionManager);

        JdbcTemplate jdbcTemplate =
            context.getBean("jdbcTemplate", JdbcTemplate.class);

        //System.out.println(jdbcTemplate);
    }
}