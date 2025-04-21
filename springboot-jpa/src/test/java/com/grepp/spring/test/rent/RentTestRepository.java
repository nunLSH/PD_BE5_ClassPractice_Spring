package com.grepp.spring.test.rent;

import com.grepp.spring.app.model.rent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTestRepository extends JpaRepository<Rent, Long>,
    RentTestRepositoryCustom {

}
