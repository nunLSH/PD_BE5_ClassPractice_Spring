package com.grepp.spring.test.rent;

import com.grepp.spring.app.model.rent.entity.RentBook;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
public class RentDto {
    private Long id;
    private String userId;
    private Boolean isReturn;
    private String title;
    private Integer rentBookCnt;

}
