package pl.coderslab.Spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01hibernate.author.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByEmail(String email);

    List<Author> findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    @Query("SELECT a FROM Author a WHERE a.email like CONCAT(:startWith,'%')")
    List<Author> authorEmailStartsWith(@Param("startWith") String startWith);

    @Query("SELECT a FROM Author a WHERE a.pesel like CONCAT(:startWith,'%')")
    List<Author> authorPeselStartWith(@Param("startWith") String startWith);

}
