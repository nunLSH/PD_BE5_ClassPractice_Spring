package com.grepp.spring.test.book;

import com.grepp.spring.app.model.book.entity.Book;
import com.grepp.spring.app.model.book.entity.QBook;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookTestRepositoryCustomImpl implements BookTestRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final QBook book = QBook.book;

    @Override
    public List<Book> orderBy() {
        return queryFactory
            .select(book)
            .from(book)
            .orderBy(book.amount.desc())
            .limit(3)
            .fetch();
    }

    @Override
    public List<Tuple> groupBy() {
        return queryFactory
            .select(book.category, book.amount.max(), book.amount.avg(), book.count())
            .from(book)
            .groupBy(book.category)
            .fetch();

    }
}
