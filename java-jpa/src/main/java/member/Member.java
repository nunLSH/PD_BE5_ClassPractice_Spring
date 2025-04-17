package member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@Entity
@DynamicInsert
public class Member {
    @Id
    private String userId;
    private String password;
    private String email;
    private String role;
    private String tel;
    private Boolean activated;
    private LocalDateTime createdAt;
    private LocalDateTime rentableDate;
}
