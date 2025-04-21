package com.grepp.spring.test.member;

import static com.grepp.spring.app.model.book.entity.QBook.book;
import static com.grepp.spring.app.model.rent.entity.QRentBook.rentBook;

import com.grepp.spring.app.model.member.entity.Member;
import com.grepp.spring.app.model.member.entity.QMember;
import com.grepp.spring.app.model.rent.code.RentState;
import com.grepp.spring.app.model.rent.entity.QRent;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberTestRepositoryCustomImpl implements MemberTestRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final QMember member = QMember.member;
    private final QRent rent = QRent.rent;
    @Override
    public List<Member> subQuery(RentState state) {
        return queryFactory.select(member)
            .from(member)
            .where(member.userId.in(
                JPAExpressions
                    .select(rent.userId)
                    .from(rent)
                    .innerJoin(rent.rentBooks, rentBook)
                    .where(rentBook.state.eq(state))
            ))
            .fetch();
    }

    @Override
    public List<Tuple> thetaJoin() {
        return queryFactory
            .select(member.userId, book.author, book.title)
            .from(member, book)
            .where(member.userId.eq(book.author))
            .fetch();
    }

    @Override
    public List<Member> dynamicQuery(String keyword, String tel) {
        return queryFactory
            .select(member)
            .from(member)
            .where(emailEqOrUserIdEq(keyword), telEq(tel))
            .fetch();
    }

    private BooleanExpression emailEqOrUserIdEq(String keyword){
        return keyword.isBlank() ? null
            : member.userId.eq(keyword).or(member.email.eq(keyword));
    }

    private BooleanExpression telEq(String tel){
        return tel.isBlank() ? null
            : member.tel.eq(tel);
    }
}