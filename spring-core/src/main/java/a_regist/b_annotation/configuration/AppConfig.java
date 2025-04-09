package a_regist.b_annotation.configuration;

import a_regist.b_annotation.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean : 메서드가 반환하는 객체를 bean 으로 등록

    @Bean
    public Book harryPotter(){
        return new Book("해리포터", "조앤롤링", "황금가지", 700);
    }

    @Bean
    public Book ringOfKing(){
        return new Book("반지의 제왕", "작가", "출판사", 700);
    }
}
