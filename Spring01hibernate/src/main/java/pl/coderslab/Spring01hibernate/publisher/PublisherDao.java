package pl.coderslab.Spring01hibernate.publisher;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void merge(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void remove(Publisher publisher) {
        entityManager.remove(publisher);
    }

    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Publisher p");
        return query.getResultList();
    }

}
