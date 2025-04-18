package rent;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RentRepositoryTest {

    private final RentService rentService = new RentService();
    private final RentRepository rentRepository = new RentRepository();

    @Test
    public void add(){
        rentService.addRent("test", List.of(1000L));
    }

    @Test
    public void addRentBook(){
        rentService.addRentBook("test", 52L, 1001L);
    }

}