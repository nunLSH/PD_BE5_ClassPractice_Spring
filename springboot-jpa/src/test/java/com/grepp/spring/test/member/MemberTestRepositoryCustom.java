package com.grepp.spring.test.member;

import com.grepp.spring.app.model.member.entity.Member;
import com.grepp.spring.app.model.rent.code.RentState;
import com.querydsl.core.Tuple;
import java.util.List;

public interface MemberTestRepositoryCustom {

    List<Member> subQuery(RentState state);
    List<Tuple> thetaJoin();
    List<Member> dynamicQuery(String keyword, String tel);
}