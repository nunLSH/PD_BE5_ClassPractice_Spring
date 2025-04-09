package c_el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class D_Method {

    @Value("#{'hello'.toUpperCase()}")
    private String upperCase;

    @Value("#{T(java.lang.Math).random() * 100}")
    private double random;

    @Value("#{transactionManager.connect()}")
    private String connection;

    @Override
    public String toString() {
        return "D_Method{" +
            "upperCase='" + upperCase + '\'' +
            ", random=" + random +
            ", connection='" + connection + '\'' +
            '}';
    }
}