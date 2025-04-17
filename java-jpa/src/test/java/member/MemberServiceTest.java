package member;

import static org.junit.jupiter.api.Assertions.*;

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
        member.setUserId("grepp3");
        member.setPassword("1234");
        member.setTel("01022223333");
        member.setEmail("aaa@aaa.com");
        memberService.add(member);
    }


}