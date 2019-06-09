package pl.coderslab.Spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01hibernate.Category;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.book.Book;
import pl.coderslab.Spring01hibernate.publisher.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, MyOwnInterface {

    List<Book> findBooksByPropositionIsTrue();

    List<Book> findBooksByPropositionIsFalse();

    List<Book> findBookByTitleAndProposition(String title, boolean proposition);

    List<Book> findBooksByCategoryAndProposition(Category category, boolean proposition);

    List<Book> findBooksByCategory_Id(long id);

    List<Book> findBooksByAuthors(List<Author> authors);

    List<Book> findBooksByPublisherAndProposition(Publisher publisher, boolean proposition);

    List<Book> findBooksByRatingIsBetween(int firstValue, int secondValue);

    Book findTopByCategoryOrderByTitle(Category category);

    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.proposition = :proposition")
    List<Book> findTitle(@Param("title") String title, @Param("proposition") boolean proposition);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> getByCategory(@Param("category") Category category);

    @Query("SELECT b FROM Book b WHERE b.rating >= 3 AND b.rating <= 5")
    List<Book> getBookRatingBetween3And5();

    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher")
    List<Book> bookByPublisher(@Param("publisher") Publisher publisher);

    @Query(value = "select * from books where category_id = :category order by title limit 1;", nativeQuery = true)
    Book findFirstWithCategory(@Param("category") Category category);

}
