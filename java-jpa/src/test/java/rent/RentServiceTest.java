package rent;

import java.util.List;
import org.junit.jupiter.api.Test;

class RentServiceTest {

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

    @Test
    public void removeRent(){
        rentService.removeRent(52L);
    }

    @Test
    public void removeRentBook(){
        rentService.removeRentBook(200009);
    }

    @Test
    public void removeRentBookWithRent(){
        rentService.removeRentBookWithRent(100001, 200008);
    }

}