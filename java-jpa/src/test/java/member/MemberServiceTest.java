package member;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
class MemberServiceTest {

    private final MemberService memberService = new MemberService();

    @Test
    void findById(){
        memberService.findById("test");
    }

    @Test
    void add(){
        Member member = new Member();
        member.setUserId("grepp");
        member.setPassword("123456");
        member.setTel("01022223333");
        member.setEmail("aaa@ppp.jjj");
        memberService.add(member);
    }

    @Test
    void modify(){
        memberService.modify("grepp", "8888888");
    }

    @Test
    void merge(){
        Member member = new Member();
        member.setUserId("grepp010101010");
        memberService.merge(member);
    }

    @Test
    void detach(){
        memberService.detach("grepp", "*****");
    }

    @Test
    void remove(){
        Member member = new Member();
        member.setUserId("grepp");
        memberService.remove(member);
    }

    @Test
    void findAll(){
        memberService.findAll().forEach(System.out::println);
    }

    @Test
    void findWithCreatedAt(){
        LocalDateTime start = LocalDateTime.of(2023,1,1,1,1,1);
        LocalDateTime end = LocalDateTime.of(2024,1,1,1,1,1);
        memberService.findWithCreatedAt(start, end)
            .forEach(System.out::println);
    }

}