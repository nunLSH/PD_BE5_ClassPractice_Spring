package com.grepp.spring.test.rent;

import com.grepp.spring.app.model.rent.entity.QRent;
import com.grepp.spring.app.model.rent.entity.QRentBook;
import com.grepp.spring.app.model.rent.entity.Rent;
import com.grepp.spring.test.rent.dto.RentDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RentTestRepositoryCustomImpl implements RentTestRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QRent rent = QRent.rent;
    private final QRentBook rentBook = QRentBook.rentBook;


    @Override
    public List<Rent> whereAnd() {
        return queryFactory
            .select(rent)
            .from(rent)
            .where(rent.title.startsWith("디디"),
                rent.userId.eq("test"))
            .fetch();
    }

    @Override
    public List<Rent> whereOr() {
        return queryFactory.select(rent)
            .from(rent)
            .where(rent.userId.eq("jpa")
                .or(rent.title.startsWith("비행운")))
            .fetch();
    }

    @Override
    public List<Rent> join() {
        return queryFactory
            .select(rent)
            .from(rent)
            .leftJoin(rent.rentBooks)
            .fetchJoin()
            .where(rent.userId.eq("jpa")
                .or(rent.title.startsWith("비행운")))
            .fetch();
    }

    @Override
    public List<RentDto> projections() {
        return queryFactory
            .select(Projections.fields(RentDto.class, rent.title, rent.id))
            .from(rent)
            .where(rent.userId.eq("test"))
            .fetch();
    }

    @Override
    public List<Tuple> tuple() {
        return queryFactory.select(rent.id, rent.title, rent.userId)
            .from(rent)
            .where(rent.userId.eq("test"))
            .fetch();
    }
}
