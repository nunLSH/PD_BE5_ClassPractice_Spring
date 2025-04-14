package com.grepp.spring.app.model.book.dto;

import com.grepp.spring.app.model.book.code.Category;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    public Book(Category category, String title, String author, String info) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.info = info;
    }
}