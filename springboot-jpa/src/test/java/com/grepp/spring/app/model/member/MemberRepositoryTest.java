package com.grepp.spring.app.model.member;

import static org.junit.jupiter.api.Assertions.*;

import com.grepp.spring.app.model.member.entity.Member;
import com.grepp.spring.app.model.member.entity.MemberInfo;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findById(){
        System.out.println(memberRepository.findById("test"));
    }

    @Test
    public void addInfo(){
        Member member = memberRepository.findById("test").get();
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setUserId("test");
        member.setInfo(memberInfo);
        memberRepository.save(member);
    }

    @Test
    public void updateInfo(){
        Member member = memberRepository.findById("test").get();

        member.updateLoginAt(LocalDateTime.now());
        memberRepository.save(member);
    }
}