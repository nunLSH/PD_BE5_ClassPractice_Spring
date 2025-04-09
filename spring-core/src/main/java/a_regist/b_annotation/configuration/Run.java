package a_regist.b_annotation.configuration;

import a_regist.b_annotation.Book;
import a_regist.b_annotation.component.Developer;
import a_regist.b_annotation.component.JdbcProperties;
import a_regist.b_annotation.component.JdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            "/regist/annotation/configuration/application-context.xml"
        );

        Book book = context.getBean("harryPotter", Book.class);
        System.out.println(book);

        Book book2 = context.getBean("ringOfKing", Book.class);
        System.out.println(book2);

    }

}
