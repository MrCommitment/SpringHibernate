package pl.coderslab.Spring01hibernate.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.author.AuthorDao;
import pl.coderslab.Spring01hibernate.publisher.Publisher;
import pl.coderslab.Spring01hibernate.publisher.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private AuthorDao authorDao;


    @ModelAttribute("publishers")
    public List<Publisher> findAllPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("allBooks")
    public List<Book> allBooks() {
        return bookDao.findAll();
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute Book book) {
        bookDao.persist(book);
        return "redirect:/book/viewBooks";
    }

    @GetMapping("/viewBooks")
    public String redirect() {
        return "book/viewAllBooks";
    }

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
