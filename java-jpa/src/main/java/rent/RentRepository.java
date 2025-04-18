package rent;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class RentRepository {

    public List<Rent> findAll(EntityManager em){
        return em.createQuery("from Rent").getResultList();
    }

    public List<Rent> findAllWithFetchJoin(EntityManager em){
        String jpql = "select r from Rent r"
            + " left join fetch r.rentBooks rb"
            + " left join fetch rb.book"
            + " left join fetch r.member";

        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public List<Rent> findAllWithEntityGraph(EntityManager em){
        EntityGraph<Rent> entityGraph = em.createEntityGraph(Rent.class);
        entityGraph.addAttributeNodes("rentBooks", "member");
        entityGraph.addSubgraph("rentBooks").addAttributeNodes("book");
        Query query = em.createQuery("from Rent")
            .setHint("jakarta.persistence.fetchgraph", entityGraph);

        return query.getResultList();
    }

    public List<Rent> findAllWithNamedEntityGraph(EntityManager em){
        EntityGraph<?> entityGraph = em.getEntityGraph("rentEntityGraph");
        entityGraph.addSubgraph("rentBooks");
        Query query = em.createQuery("from Rent")
            .setHint("jakarta.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

}
