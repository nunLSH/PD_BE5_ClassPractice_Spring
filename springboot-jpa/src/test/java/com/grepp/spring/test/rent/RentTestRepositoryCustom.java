package com.grepp.spring.test.rent;

import com.grepp.spring.app.model.rent.entity.Rent;
import com.grepp.spring.test.rent.dto.RentDto;
import com.querydsl.core.Tuple;
import java.util.List;

public interface RentTestRepositoryCustom {

    List<Rent> whereAnd();
    List<Rent> whereOr();
    List<Rent> join();
    List<RentDto> projections();
    List<Tuple> tuple();
}
