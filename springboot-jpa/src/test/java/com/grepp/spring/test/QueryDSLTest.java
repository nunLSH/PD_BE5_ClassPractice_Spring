package com.grepp.spring.test;

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
    @DisplayName("projections")
    public void tuple(){
        rentTestRepository.tuple()
            .forEach(System.out::println);
    }
}
