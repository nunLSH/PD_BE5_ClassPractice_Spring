package com.grepp.spring.app.model.book.dto;

import com.grepp.spring.app.model.book.code.Category;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Book {

    private Integer bkIdx;
    private Category category;
    private String title;
    private String author;
    private String info;
    private Integer amount;
    private LocalDateTime createdAt;
    private Integer rentCnt;
    private Boolean activated;

}
