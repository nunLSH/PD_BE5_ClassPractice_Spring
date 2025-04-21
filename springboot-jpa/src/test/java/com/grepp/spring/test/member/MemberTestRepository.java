package com.grepp.spring.test.member;

import com.grepp.spring.app.model.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTestRepository extends JpaRepository<Member, String>
    , MemberTestRepositoryCustom{
}