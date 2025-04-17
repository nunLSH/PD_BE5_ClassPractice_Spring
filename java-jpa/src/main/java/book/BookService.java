package book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.JpaTemplate;

public class BookService {

    private final JpaTemplate jpaTemplate = JpaTemplate.getInstance();

    public void add(Book book){
        EntityManager em = jpaTemplate.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

}
