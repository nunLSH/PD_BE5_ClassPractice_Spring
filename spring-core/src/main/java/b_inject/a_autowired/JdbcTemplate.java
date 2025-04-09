package b_inject.a_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplate {

    @Autowired
    private TransactionManager transactionManager;

    @Override
    public String toString() {
        return "JdbcTemplate{" +
            "transactionManager=" + transactionManager +
            '}';
    }
}