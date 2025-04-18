package com.grepp.spring.test;

import com.grepp.spring.app.model.book.code.Category;
import com.grepp.spring.app.model.book.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTestRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleOrAuthor(String title, String author);
    int countByCategory(Category category);
    List<Book> findByCategoryAndAmountGreaterThanEqualAndTitleStartingWith(
        Category category, int amount, String title
    );

}
