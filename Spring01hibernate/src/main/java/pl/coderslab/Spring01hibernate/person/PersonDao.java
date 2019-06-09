package pl.coderslab.Spring01hibernate.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Person person) {
        entityManager.persist(person);
    }

    public void merge(Person person) {
        entityManager.merge(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void remove(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }

    public List<Person> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }

}
