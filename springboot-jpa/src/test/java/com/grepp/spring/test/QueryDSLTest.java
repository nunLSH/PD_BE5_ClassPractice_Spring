package com.grepp.spring.test;

import com.grepp.spring.app.model.rent.code.RentState;
import com.grepp.spring.test.book.BookTestRepository;
import com.grepp.spring.test.member.MemberTestRepository;
import com.grepp.spring.test.member.MemberTestRepositoryCustomImpl;
import com.grepp.spring.test.rent.RentTestRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class QueryDSLTest {

    @Autowired
    private RentTestRepository rentTestRepository;
    @Autowired
    private BookTestRepository bookTestRepository;
    @Autowired
    private MemberTestRepository memberTestRepository;


    @Test
    @DisplayName("대출건 제목이 디디로 시작하고 대출자 id가 test")
    public void whereAnd(){
        System.out.println(rentTestRepository.whereAnd());
    }

    @Test
    @DisplayName("대출건 제목이 비행운으로 시작하거나 대출자 id가 jpa")
    public void whereOr(){
        rentTestRepository.whereOr()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("대출건 제목이 비행운으로 시작하거나 대출자 id가 jpa")
    public void join(){
        rentTestRepository.join()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("projections")
    public void projections(){
        rentTestRepository.projections()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("tuple")
    public void tuple(){
        rentTestRepository.tuple()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("도서 등록일자로 내림차순 정렬")
    public void orderBy(){
        bookTestRepository.orderBy()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("카테고리별 group by")
    public void groupBy(){
        bookTestRepository.groupBy()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("대출도서가 존재하는 회원 조회")
    public void subQuery(){
        memberTestRepository.subQuery(RentState.RENT)
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("사용자와 동명이인의 작가가 존재하는 회원과 도서정보 조회")
    public void thetaJoin(){
        memberTestRepository.thetaJoin()
            .forEach(System.out::println);
    }

    @Test
    @DisplayName("dynamicQuery")
    public void dynamicQuery(){
        memberTestRepository.dynamicQuery("test", "01022223333")
            .forEach(System.out::println);
    }

}