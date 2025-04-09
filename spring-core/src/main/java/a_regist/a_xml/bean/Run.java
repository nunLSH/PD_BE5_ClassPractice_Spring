package a_regist.a_xml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
            "/regist/xml/application-context.xml"
        );

        // NOTE bean 01 Spring Scope
        // singleton pattern : 클래스 당 인스턴스 하나
        // singleton scope : 애플리케이션이 종료될 때까지 이름 당 인스턴스가 하나
        // request       : HttpRequest
        // session       : HttpSession
        // application   : Servlet Context
        // websocket     : WebSocket Session
        // prototype     : application context 에 bean 을 요청할 때 생성, getBean() 호출 시 생성
        Book book = context.getBean("harryPotter", Book.class);
        System.out.println(book);

        Book ring = context.getBean("ringOfKing", Book.class);
        System.out.println(ring);
    }
}
