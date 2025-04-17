package rent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import member.Member;

@Data
@Entity
public class Rent {
    @Id
    @GeneratedValue
    private Long rentId;
    private String title;
    private LocalDateTime createdAt;
    private Boolean isReturn;
    private Boolean activated;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member member;

    @OneToMany(mappedBy = "rent")
    private List<RentBook> rentBooks;
}
