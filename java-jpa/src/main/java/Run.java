import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Run {

    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookmanager")) {
            EntityManager em = emf.createEntityManager();
        } finally {

        }


    }

}
