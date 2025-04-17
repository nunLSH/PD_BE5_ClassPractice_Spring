package member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Member {

    @Id
    private String userId;
    private String password;
    private String email;
    private String role;
    private Boolean activated;
    private LocalDateTime createdAt;
    private LocalDateTime rentableDate;
}
