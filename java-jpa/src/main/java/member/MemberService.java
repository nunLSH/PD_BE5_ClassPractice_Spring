package member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.JpaTemplate;

public class MemberService {

    private final MemberRepository memberRepository = new MemberRepository();
    private final JpaTemplate jpaTemplate = JpaTemplate.getInstance();

    public Member findById(String userId) {
        Member member = null;
        try (EntityManager em = jpaTemplate.createEntityManager();) {
            member = em.find(Member.class, userId);
        }
        return member;
    }

    public void add(Member member) {

        EntityManager em = jpaTemplate.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
