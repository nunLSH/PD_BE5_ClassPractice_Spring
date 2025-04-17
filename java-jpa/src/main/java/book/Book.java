package book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.nio.file.LinkOption;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long bkIdx;
    private String title;
    private String author;
    private String category;
    private String info;
    private Integer amount;
    private LocalDateTime createdAt;
    private Integer rentCnt;
    private Boolean activated;
}
