package rent;

import book.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Data;

@Data
@Entity
public class RentBook {
    @Id
    @GeneratedValue
    private Long rbIdx;
    private String state;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime returnDate = LocalDateTime.now().plus(7, ChronoUnit.DAYS);
    private String bookTitle;
    private Boolean activated = true;

    @ManyToOne
    @JoinColumn(name = "bkIdx")
    private Book book;

    @ManyToOne
    @JoinColumn(name="rentId")
    private Rent rent;

}
