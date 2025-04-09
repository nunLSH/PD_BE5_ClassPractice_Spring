package c_el.bean;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JdbcProperties mysqlProperties() {
        Properties properties = new Properties();
        properties.setProperty("db", "mysql");
        properties.setProperty("user","bm");
        return new JdbcProperties(properties);
    }

    @Bean
    public JdbcProperties oracleProperties() {
        Properties properties = new Properties();
        properties.setProperty("db", "oracle");
        properties.setProperty("user","oracleBm");
        return new JdbcProperties(properties);
    }

}