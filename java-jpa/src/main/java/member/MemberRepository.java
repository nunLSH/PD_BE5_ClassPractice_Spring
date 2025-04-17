package member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import jpa.JpaTemplate;

public class MemberRepository {

    public List<Member> findAll(EntityManager em) {
        String jpql = "select m from Member m";
        Query query = em.createQuery(jpql, Member.class);
        return query.getResultList();
    }

    public List<Member> findWithCreatedAt(EntityManager em, LocalDateTime start,
        LocalDateTime end) {
        String jpql = "select m from Member m where "
            + "m.createdAt between :start and :end";

        Query query = em.createQuery(jpql, Member.class);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }
}