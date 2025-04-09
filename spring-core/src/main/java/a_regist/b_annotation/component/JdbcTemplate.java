package a_regist.b_annotation.component;

import org.springframework.stereotype.Component;

@Component("mysqlTemplate")
public class JdbcTemplate {

    @Override
    public String toString() {
        return "JdbcTemplate";
    }
}
