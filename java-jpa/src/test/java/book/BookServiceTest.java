package book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookServiceTest {

    private BookService bookService = new BookService();

    @Test
    public void add(){
        Book book = new Book();
        book.setTitle("해리포터");
        book.setAuthor("조앤롤링");
        bookService.add(book);
    }

}