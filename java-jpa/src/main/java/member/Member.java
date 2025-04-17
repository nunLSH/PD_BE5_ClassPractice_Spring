package member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert  // null 인 컬럼은 쿼리에 포함시키지 않음
@DynamicUpdate // 변경점이 발생하지 않은 컬럼은 쿼리에 포함시키지 않음
public class Member {
    @Id
    private String userId;
    private String password;
    private String email;
    private String role = "ROLE_USER";
    private String tel;
    private Boolean activated = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime rentableDate = LocalDateTime.now().plus(7, ChronoUnit.DAYS);

    public void modifyPassword(String password) {
        if(password.length() > 10) return;
        this.password = password;
    }
}