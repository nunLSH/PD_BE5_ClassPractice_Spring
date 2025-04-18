package rent;

import jakarta.persistence.EntityManager;
import java.util.List;

public class RentRepository {

    public List<Rent> findAll(EntityManager em){
        return em.createQuery("from Rent").getResultList();
    }

}
