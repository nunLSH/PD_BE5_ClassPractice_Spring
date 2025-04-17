package member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;
import jpa.JpaTemplate;

public class MemberService {

    private final MemberRepository memberRepository = new MemberRepository();
    private final JpaTemplate jpaTemplate = JpaTemplate.getInstance();

    public Member findById(String userId){

        Member member = null;
        try(EntityManager em = jpaTemplate.createEntityManager();){
            member = em.find(Member.class, userId);

        }
        return member;
    }

    public List<Member> findAll(){
        try(EntityManager em = jpaTemplate.createEntityManager()){
            return memberRepository.findAll(em);
        }
    }

    public List<Member> findWithCreatedAt(LocalDateTime start, LocalDateTime end){
        try(EntityManager em = jpaTemplate.createEntityManager()){
            return memberRepository.findWithCreatedAt(em, start, end);
        }
    }

    public void add(Member member){

        EntityManager em = jpaTemplate.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    void modify(String userId, String password){
        EntityManager em = jpaTemplate.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Member member = em.find(Member.class, userId);
            member.modifyPassword(password);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    void merge(Member member){
        EntityManager em = jpaTemplate.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // 엔터티 매니저가 관리 중인 지 여부 확인
            System.out.println("before merge : " +  em.contains(member));
            Member result = em.merge(member);
            tx.commit();
            System.out.println("after merge : " +  em.contains(result));
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    void detach(String userId, String password){
        EntityManager em = jpaTemplate.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            // 영속 상태
            Member member = em.find(Member.class, userId);
            // 준영속 상태
            em.detach(member);
            member.modifyPassword(password);

            System.out.println("after detach : " + em.contains(member));
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    public void remove(Member member){
        EntityManager em = jpaTemplate.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            member = em.find(Member.class, member.getUserId());
            em.remove(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }
}