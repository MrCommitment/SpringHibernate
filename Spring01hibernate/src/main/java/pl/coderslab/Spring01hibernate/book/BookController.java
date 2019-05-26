package pl.coderslab.Spring01hibernate.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.author.AuthorDao;
import pl.coderslab.Spring01hibernate.publisher.Publisher;
import pl.coderslab.Spring01hibernate.publisher.PublisherDao;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping("/add/{authorId}/{title}")
    @ResponseBody
    public Book add(@PathVariable("authorId") long authorId, @PathVariable("title") String title) {
        Author author = authorDao.findById(authorId);
        Book book = new Book();
        book.setTitle(title);
        book.getAuthors().add(author);
        author.getBooks().add(book);
        bookDao.persist(book);
        return book;
    }

    @RequestMapping("/addPublisher/{id}/{publisherId}")
    public Book addPublisher(@PathVariable("id") long id, @PathVariable("publisherId")  long publisherId) {
        Publisher publisher = publisherDao.findById(publisherId);
        Book book = bookDao.findById(id);
        book.setPublisher(publisher);
        bookDao.merge(book);
        return book;
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public Book merge(@PathVariable("id")long id) {
        return bookDao.findById(id);
    }

    @RequestMapping("/changeDescription/{id}/{description}")
    @ResponseBody
    public String changeDescription(@PathVariable("description") String description, @PathVariable("id") long id) {
        Book book = bookDao.findById(id);
        book.setDescription(description);
        bookDao.merge(book);
        return "Żądanie zakończone sukcesem";
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        Book book = bookDao.findById(id);
        bookDao.remove(book);
        return "Żądanie zakończone sukcesem";
    }

}
