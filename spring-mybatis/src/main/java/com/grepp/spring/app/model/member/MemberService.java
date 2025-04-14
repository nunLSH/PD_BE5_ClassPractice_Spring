package com.grepp.spring.app.model.member;

import com.grepp.spring.app.model.member.code.Role;
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.member.dto.MemberInfo;
import com.grepp.spring.infra.error.exceptions.CommonException;
import com.grepp.spring.infra.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(Member dto) {
        if(memberRepository.existsMember(dto.getUserId()))
            throw new CommonException(ResponseCode.BAD_REQUEST);

        dto.setRole(Role.ROLE_USER);
        memberRepository.insert(dto);

        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setUserId(dto.getUserId());

        memberRepository.insertInfo(memberInfo);
        throw new RuntimeException("test Error");
    }
}