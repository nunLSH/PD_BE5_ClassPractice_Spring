package a_regist.a_xml;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private Integer page;

    public Book() {
    }

    public Book(String title, String author, String publisher, Integer page) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
            "title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", publisher='" + publisher + '\'' +
            ", page=" + page +
            '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
