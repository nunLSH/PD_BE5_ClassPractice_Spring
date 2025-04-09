package c_el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class B_Operator {

    @Value("#{ 10 + 20}")
    private int add;

    @Value("#{ 10 / 20}")
    private int divide;

    @Value("#{10 == 10}")
    private boolean equal;

    @Value("#{100 > 20}")
    private boolean greater;

    @Value("#{true or false}")
    private boolean or;

    @Value("#{!true}")
    private boolean not;

    @Override
    public String toString() {
        return "B_Operator{" +
            "add=" + add +
            ", divide=" + divide +
            ", equal=" + equal +
            ", greater=" + greater +
            ", or=" + or +
            ", not=" + not +
            '}';
    }
}