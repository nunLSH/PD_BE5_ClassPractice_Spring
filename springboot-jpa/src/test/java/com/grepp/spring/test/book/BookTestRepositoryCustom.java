package com.grepp.spring.test.book;

import com.grepp.spring.app.model.book.entity.Book;
import com.querydsl.core.Tuple;
import java.util.List;

public interface BookTestRepositoryCustom {

    List<Book> orderBy();
    List<Tuple> groupBy();
}
