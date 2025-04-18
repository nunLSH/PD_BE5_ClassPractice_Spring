package rent;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpa.JpaTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentRepositoryTest {

    private RentRepository rentRepository = new RentRepository();
    private JpaTemplate template = JpaTemplate.getInstance();
    EntityManager em = null;

    @Test
    @Transactional
    @DisplayName("N+1 이슈 발생")
    public void findAll() {
        em = template.createEntityManager();
        rentRepository.findAll(em)
            .forEach(System.out::println);
    }

    @Test
    public void findAllWithFetchJoin(){
        em = template.createEntityManager();
        rentRepository.findAllWithFetchJoin(em)
            .forEach(System.out::println);
    }

    @Test
    public void findAllWithEntityGraph(){
        em = template.createEntityManager();
        rentRepository.findAllWithEntityGraph(em)
            .forEach(System.out::println);
    }

    @Test
    public void findAllWithNamedEntityGraph(){
        em = template.createEntityManager();
        rentRepository.findAllWithNamedEntityGraph(em)
            .forEach(System.out::println);
    }

}