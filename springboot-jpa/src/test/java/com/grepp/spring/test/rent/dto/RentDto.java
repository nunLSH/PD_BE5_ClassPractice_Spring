package com.grepp.spring.test.rent.dto;

import lombok.Data;

@Data
public class RentDto {
    private Long id;
    private String userId;
    private Boolean isReturn;
    private String title;
    private Integer rentBookCnt;

}
