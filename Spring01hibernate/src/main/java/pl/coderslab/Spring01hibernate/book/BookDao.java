package pl.coderslab.Spring01hibernate.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Book book) {
        entityManager.persist(book);
    }

    public void merge(Book book) {
        entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void remove(Book book) {
        entityManager.remove(book);
    }

}
