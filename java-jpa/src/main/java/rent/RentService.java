package rent;

import book.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import jpa.JpaTemplate;
import member.Member;

public class RentService {

    private final RentRepository rentRepository = new RentRepository();
    private final JpaTemplate template = JpaTemplate.getInstance();

    public void addRent(String userId, List<Long> bkIdx){

        EntityManager em = template.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            List<Book> books = new ArrayList<>();

            bkIdx.forEach(id -> {
                books.add(em.find(Book.class, id));
            });

            Member member = em.find(Member.class, userId);

            Rent rent = new Rent();
            rent.setTitle(books.getFirst().getTitle() + "외 [" + (books.size()-1) + "권]");

            List<RentBook> rentBooks = books.stream().map(book -> {
                RentBook rb = new RentBook();
                rb.setBook(book);
                rb.setBookTitle(book.getTitle());
                rb.setRent(rent);
//                em.persist(rb);
                return rb;
            }).toList();

            rent.setMember(member);
//            rent.setRentBooks(rentBooks);
            em.persist(rent);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void addRentBook(String userId, long rentId, long bkIdx){
        EntityManager em = template.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Book book = em.find(Book.class, bkIdx);
            Rent rent = em.find(Rent.class, rentId);

            RentBook rentBook = new RentBook();
            rentBook.setBookTitle(book.getTitle());
            rentBook.setBook(book);

            rentBook.setRent(rent);
            em.persist(rentBook);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
    }
}
