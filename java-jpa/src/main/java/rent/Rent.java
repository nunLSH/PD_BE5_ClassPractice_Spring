package rent;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import member.Member;

@Data
@Entity
public class Rent {
    @Id
    @GeneratedValue
    private Long rentId;
    private String title;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Boolean isReturn = false;
    private Boolean activated = true;

    // FetchType
    // EAGER : Rent 를 데이터베이스에서 엮어 올 때 Member 도 함께 조회
    // LAZY : default, Rent 가 member 를 사용하는 시점에 데이터베이스에서 조회
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Member member;

    @OneToMany(mappedBy = "rent",
        fetch =FetchType.LAZY,
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<RentBook> rentBooks;

    public void addRentBook(RentBook rentBook) {
        rentBooks.add(rentBook);
    }
}
